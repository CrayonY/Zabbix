package com.ucd.micro.monitor.util;

import com.ucd.micro.monitor.util.model.HostModel;
import com.ucd.micro.monitor.util.model.problem.ZabbixApiProblem;
import com.zabbix4j.ZabbixApiException;
import com.zabbix4j.host.HostGetRequest;
import com.zabbix4j.host.HostGetResponse;
import com.zabbix4j.host.HostObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Zabbix4jSampleGetHost
 * @Description: TODO
 * @Author: liuxin
 * @CreateDate: 2020/1/11 14:29
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Slf4j
public class Zabbix4jSampleGetHost extends ZabbixApiTestDummyMethodBase {


    public Zabbix4jSampleGetHost(ZabbixApiProblem zabbixApiProblem) {
        super(zabbixApiProblem);
    }

    // 调用api的host get方法的封装
    public HostGetResponse getHost(Integer hostid) throws ZabbixApiException {

        HostGetRequest request = new HostGetRequest();
        HostGetRequest.Params params = request.getParams();
        List<Integer> hostIds = new ArrayList<Integer>();
        hostIds.add(hostid);
        params.setHostids(hostIds);
        HostGetResponse response = zabbixApiProblem.host().get(request);
        return response;
    }

    public HostModel getHostModelList(Zabbix4jSampleGetHost zabbix4jSampleGetHost, Integer hostid) throws ZabbixApiException {
        HostModel hostModel = null;
        HostGetResponse response = zabbix4jSampleGetHost.getHost(hostid);
        // 对response进行处理
        for (int i = 0; i < response.getResult().size(); i++) {
            HostObject myHostObject = response.getResult().get(i);
            if (null == myHostObject) {
                log.info("Get host null, program will exit");
            } else {
                hostModel = HostModel.builder()
                        .ip(myHostObject.getHost())
                        .hostName(myHostObject.getName())
                        .build();
            }

        }
        return hostModel;

    }


}