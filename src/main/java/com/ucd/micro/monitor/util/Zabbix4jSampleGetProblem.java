package com.ucd.micro.monitor.util;


import com.ucd.micro.monitor.util.model.problem.ProblemGetRequest;
import com.ucd.micro.monitor.util.model.problem.ProblemGetResponse;
import com.ucd.micro.monitor.util.model.problem.ProblemObject;
import com.ucd.micro.monitor.util.model.problem.ZabbixApiProblem;
import com.zabbix4j.ZabbixApiException;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;


/**
 * @ClassName: Zabbix4jSampleGetProblem
 * @Description: TODO
 * @Author: gongweimin
 * @CreateDate: 2020/1/11 14:29
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Slf4j
public class Zabbix4jSampleGetProblem extends ZabbixApiTestDummyMethodBase {


    public Zabbix4jSampleGetProblem(ZabbixApiProblem zabbixApiProblem) {
        super(zabbixApiProblem);
    }


    // 调用api的host get方法的封装
    public ProblemGetResponse getProblem(Integer objectId) throws ZabbixApiException {

//        Integer targetObjectId = 17160;
        ProblemGetRequest request = new ProblemGetRequest();
        ProblemGetRequest.Params params = request.getParams();

        ArrayList<Integer> objectIds = new ArrayList<Integer>();
        objectIds.add(objectId);
        params.setObjectids(objectIds);
        log.info("parames setting complete...");
        log.info("params:" + params);
        ProblemGetResponse response = zabbixApiProblem.problem().get(request);
        return response;
    }

    public ProblemObject getProblemModel(Zabbix4jSampleGetProblem zabbix4jSampleGetProblem, Integer TriggerId) throws ZabbixApiException {
        ProblemObject myProblemObject = new ProblemObject();
        ProblemGetResponse response = zabbix4jSampleGetProblem.getProblem(TriggerId);
        // 对response进行处理
        // 触发器与问题一一对应，如果不是，则需要修改逻辑
        for (int i = 0; i < response.getResult().size(); i++) {
            myProblemObject = response.getResult().get(i);
            if (null == myProblemObject) {
                log.info("Get problem null, program will exit");
            }
        }
        log.info("______________________________________"+myProblemObject);
        return myProblemObject;
    }


}