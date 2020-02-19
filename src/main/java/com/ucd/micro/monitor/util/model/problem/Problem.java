package com.ucd.micro.monitor.util.model.problem;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zabbix4j.ZabbixApiException;
import com.zabbix4j.ZabbixApiMethod;
import lombok.Data;

/**
 * @ClassName: Problem
 * @Description: TODO
 * @Author: gongweimin
 * @CreateDate: 2020/1/12 18:03
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Data
public class Problem extends ZabbixApiMethod {
    public Problem(String apiUrl, String auth) {
        super(apiUrl, auth);
    }
    public ProblemGetResponse get(ProblemGetRequest request) throws ZabbixApiException {
        ProblemGetResponse response = null;
        request.setAuth(this.auth);
        Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        String requestJson = gson.toJson(request);

        try {
            String responseJson = this.sendRequest(requestJson);
            response = gson.fromJson(responseJson, ProblemGetResponse.class);
            return response;
        } catch (ZabbixApiException var6) {
            throw new ZabbixApiException(var6);
        }
    }
}
