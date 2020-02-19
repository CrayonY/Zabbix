package com.ucd.micro.monitor.util;

import com.ucd.micro.monitor.util.model.ItemModel;
import com.ucd.micro.monitor.util.model.problem.ZabbixApiProblem;
import com.zabbix4j.ZabbixApiException;
import com.zabbix4j.item.ItemGetRequest;
import com.zabbix4j.item.ItemGetResponse;
import com.zabbix4j.item.ItemObject;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: Zabbix4jSampleGetItem
 * @Description: TODO
 * @Author: liuxin
 * @CreateDate: 2020/1/11 14:29
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Slf4j
public class Zabbix4jSampleGetItem extends ZabbixApiTestDummyMethodBase {


    public Zabbix4jSampleGetItem(ZabbixApiProblem zabbixApiProblem) {
        super(zabbixApiProblem);
    }

    public ItemGetResponse getItem(String groupName, String itemName) throws ZabbixApiException {

        ItemGetRequest request = new ItemGetRequest();
        ItemGetRequest.Params params = request.getParams();
        ArrayList<Integer> itemIds = new ArrayList<Integer>();
        /**
         *  groupName,itemName 第一版目前为固定参数
         */
//        params.setGroup(groupName);
//        Map<String,String> keymap = new HashMap<>();
//        keymap.put("name",itemName);

        params.setGroup("SQLserver服务器");
        Map<String, String> keymap = new HashMap<>();
        keymap.put("name", "SQLServer: Buffer Manager: Page writes/sec");
        params.setSearch(keymap);
        log.info("parames setting complete...");
        ItemGetResponse response = zabbixApiProblem.item().get(request);
        return response;
    }

    public List<ItemModel> getItemModelList(Zabbix4jSampleGetItem zabbix4jSampleGetItem, String groupName, String itemName) throws ZabbixApiException {

        List<ItemModel> itemModelList = new ArrayList<ItemModel>();

        ItemGetResponse response = zabbix4jSampleGetItem.getItem(groupName, itemName);
        // 对response进行处理
        for (int i = 0; i < response.getResult().size(); i++) {
            ItemObject itemObject = response.getResult().get(i);
            if (null == itemObject) {
                log.info("Get item null, program will exit");
            } else {
                log.info("++++++Print Result " + i + " itemObject+++++++++++");
                ItemModel itemModel = ItemModel.builder()
                        .hostId(itemObject.getHostid())
                        .id(itemObject.getItemid())
                        .value(itemObject.getLastvalue())
                        .name(itemObject.getName())
                        .build();
                itemModelList.add(itemModel);
            }
        }
        return itemModelList;
    }
}