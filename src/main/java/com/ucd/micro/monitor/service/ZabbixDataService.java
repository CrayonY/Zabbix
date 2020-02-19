package com.ucd.micro.monitor.service;

import com.ucd.micro.monitor.util.ResultVO;

/**
 * @ClassName: ZabbixDataService
 * @Description: TODO
 * @Author: liuxin
 * @CreateDate: 2020/1/7 16:45
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
public interface ZabbixDataService {
    ResultVO<?> getZabbixDate(String stationId,String stationName,String GroupName,String IteamName);
}