package com.ucd.micro.monitor.util;


import com.ucd.micro.monitor.util.model.TriggerModel;
import com.ucd.micro.monitor.util.model.problem.ZabbixApiProblem;
import com.zabbix4j.ZabbixApiException;
import com.zabbix4j.trigger.TriggerGetRequest;
import com.zabbix4j.trigger.TriggerGetResponse;
import com.zabbix4j.trigger.TriggerObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Zabbix4jSampleGetTrigger
 * @Description: TODO
 * @Author: liuxin
 * @CreateDate: 2020/1/11 14:29
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Slf4j
public class Zabbix4jSampleGetTrigger extends ZabbixApiTestDummyMethodBase {


    public Zabbix4jSampleGetTrigger(ZabbixApiProblem zabbixApiProblem) {
        super(zabbixApiProblem);
    }


    // 调用api的host get方法的封装
    public TriggerGetResponse getTrigger(Integer itemId) throws ZabbixApiException {
        TriggerGetRequest request = new TriggerGetRequest();
        TriggerGetRequest.Params params = request.getParams();


        ArrayList<Integer> itemIds = new ArrayList<Integer>();
        itemIds.add(itemId);
        params.setItemids(itemIds);
        TriggerGetResponse response = zabbixApiProblem.trigger().get(request);
        return response;
    }

    public List<TriggerModel> getTriggerModelList(Zabbix4jSampleGetTrigger zabbix4jSampleGetTrigger, Integer itemId) throws ZabbixApiException {

        List<TriggerModel> triggerModelList = new ArrayList<TriggerModel>();
        TriggerGetResponse response = zabbix4jSampleGetTrigger.getTrigger(itemId);
        // 对response进行处理
        for (int i = 0; i < response.getResult().size(); i++) {
            TriggerObject itemObject = response.getResult().get(i);
            if (null == itemObject) {
                log.info("Get myTriggerObject null, program will exit");
            } else {
                log.info("++++++Print Result " + i
                        + " TriggerObject+++++++++++");
                TriggerModel triggerModel = TriggerModel.builder()
                        .triggerId(itemObject.getTriggerid())
                        .description(itemObject.getDescription())
                        .priority(itemObject.getPriority())
                        .build();
                triggerModelList.add(triggerModel);
            }
        }
        return triggerModelList;
    }


}