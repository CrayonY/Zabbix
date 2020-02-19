package com.ucd.micro.monitor.util;

import com.ucd.micro.monitor.util.model.problem.ZabbixApiProblem;
import com.zabbix4j.ZabbixApi;

/**
 * @ClassName: ZabbixApiTestDummyMethodBase
 * @Description: TODO
 * @Author: liuxin
 * @CreateDate: 2020/1/11 14:32
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
public class ZabbixApiTestDummyMethodBase {
    protected ZabbixApi zabbixApi;
    protected ZabbixApiProblem zabbixApiProblem;

    public ZabbixApiTestDummyMethodBase(ZabbixApi zabbixApi) {
        this.zabbixApi = zabbixApi;
    }
    public ZabbixApiTestDummyMethodBase(ZabbixApiProblem zabbixApiProblem) {
        this.zabbixApiProblem = zabbixApiProblem;
    }
}