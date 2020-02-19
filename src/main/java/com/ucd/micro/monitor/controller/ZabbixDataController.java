package com.ucd.micro.monitor.controller;

import com.ucd.micro.monitor.service.ZabbixDataService;
import com.ucd.micro.monitor.util.ResultVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: ZabbixDataController
 * @Description: TODO
 * @Author: liuxin
 * @CreateDate: 2020/1/7 16:44
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Slf4j
@RestController
@RequestMapping("/monitor")
@CrossOrigin
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ZabbixDataController {

    public final ZabbixDataService zabbixDataService;

    @PostMapping("/data")
    public ResultVO<?> getZabbixDate(String stationId,String stationName,String GroupName,String IteamName){
        return zabbixDataService.getZabbixDate(stationId,stationName,GroupName,IteamName);
    }

}