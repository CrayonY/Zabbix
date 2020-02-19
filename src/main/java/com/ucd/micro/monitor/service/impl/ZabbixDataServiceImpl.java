package com.ucd.micro.monitor.service.impl;

import com.ucd.micro.monitor.constant.StatusConst;
import com.ucd.micro.monitor.service.ZabbixDataService;
import com.ucd.micro.monitor.util.*;
import com.ucd.micro.monitor.util.model.HostModel;
import com.ucd.micro.monitor.util.model.ItemModel;
import com.ucd.micro.monitor.util.model.TriggerModel;
import com.ucd.micro.monitor.util.model.problem.ProblemObject;
import com.ucd.micro.monitor.util.model.problem.ZabbixApiProblem;
import com.ucd.micro.monitor.zabbix.info.ZabbixUrl;
import com.zabbix4j.ZabbixApiException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ZabbixDataServiceImpl
 * @Description: TODO
 * @Author: liuxin
 * @CreateDate: 2020/1/7 16:45
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Slf4j
@Service
@RequestMapping("/zabbix")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ZabbixDataServiceImpl implements ZabbixDataService {

    @Value("${zabbix.username}")
    public String username;
    @Value("${zabbix.password}")
    public String password;


    @Override
    public ResultVO<?> getZabbixDate(String stationId, String stationName, String GroupName, String IteamName) {
        ResultVO<?> resultVO = new ResultVO<>();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("stationId", stationId);
        resultMap.put("stationName", stationName);
        resultMap.put("time", NewDateUtil.getDate6Result(NewDateUtil.getCurrentDateTimeStr()));
        List<Map<String, Object>> hostList = new ArrayList<>();
        int status = StatusConst.EQUIPMENT_NORMAL;
        try {
            // login to Zabbix
            log.info("beging...");
            String url = ZabbixUrl.getUrlByCode(stationId);
            if (StringUtils.isEmpty(url)) {
                return ResultVO.FAIL(ApiResultType.PARAMETER_ILLEGAL.code,
                        ApiResultType.PARAMETER_ILLEGAL.message);
            }
            //Zabbix登陆
            ZabbixApiProblem zabbixApiProblem = new ZabbixApiProblem(url);
            zabbixApiProblem.login(username, password);
            if (StringUtils.isEmpty(zabbixApiProblem.getAuth())) {
                resultMap.put("status", StatusConst.EQUIPMENT_ERROR);
                return ResultVO.SUCC(ApiResultType.SUCCESS.code,
                        ApiResultType.SUCCESS.message, resultMap);
            }
            //Zabbix获取ItemModel
            Zabbix4jSampleGetItem zabbix4jSampleGetItem = new Zabbix4jSampleGetItem(zabbixApiProblem);
            List<ItemModel> ItemModelList = zabbix4jSampleGetItem.getItemModelList(zabbix4jSampleGetItem, GroupName, IteamName);
            for (ItemModel itemModel : ItemModelList) {
                Map<String, Object> hostMap = new HashMap<>();
                //Zabbix获取HostModel
                Zabbix4jSampleGetHost zabbix4jSampleGetHost = new Zabbix4jSampleGetHost(zabbixApiProblem);
                HostModel hostModel = zabbix4jSampleGetHost.getHostModelList(zabbix4jSampleGetHost, itemModel.getHostId());
                //HostModel为空跳出逻辑，继续循环
                if (null == hostModel) {
                    continue;
                }
                hostMap.put("value", itemModel.getValue());
                hostMap.put("unit", "B");
                hostMap.put("ip", hostModel.getIp());
                Zabbix4jSampleGetTrigger zabbix4jSampleGetTrigger = new Zabbix4jSampleGetTrigger(zabbixApiProblem);
                List<TriggerModel> triggerModelList = zabbix4jSampleGetTrigger.getTriggerModelList(zabbix4jSampleGetTrigger, itemModel.getId());
                hostMap.put("status", StatusConst.HostStatus.HOST_NORMAL);
                //判断节点状态正常
                if (null != triggerModelList && 0 != triggerModelList.size()) {
                    Zabbix4jSampleGetProblem zabbix4jSampleGetProblem = new Zabbix4jSampleGetProblem(zabbixApiProblem);
                    ProblemObject problemObject = zabbix4jSampleGetProblem.getProblemModel(zabbix4jSampleGetProblem, triggerModelList.get(0).getTriggerId());
                    if (!StringUtils.isEmpty(problemObject.getObjectid())) {
                        //取List中的最坏状态值
                        int severity = Integer.valueOf(problemObject.getSeverity());
                        if(severity < StatusConst.HostStatus.HOST_ALERT){
                            severity=StatusConst.HostStatus.HOST_NORMAL;
                        }
                        hostMap.put("status",severity);
                        if (severity >= StatusConst.EQUIPMENT_ERROR) {
                            status = StatusConst.EQUIPMENT_ERROR;
                        }
                    }

                }
                hostList.add(hostMap);

            }
            resultMap.put("status", status);
            resultMap.put("hosts", hostList);

            log.info("create new get host instance...");


        } catch (ZabbixApiException e) {
            e.printStackTrace();
            resultMap.put("status", StatusConst.EQUIPMENT_DOWN);
            return ResultVO.SUCC(ApiResultType.SUCCESS.code,
                    ApiResultType.SUCCESS.message,resultMap);
        }
        return ResultVO.SUCC(ApiResultType.SUCCESS.code,ApiResultType.SUCCESS.message,resultMap);
    }

}