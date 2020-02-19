package com.ucd.micro.monitor.zabbix.info;

import lombok.Getter;

/**
 * @ClassName: ZabbixUrl
 * @Description: TODO
 * @Author: gongweimin
 * @CreateDate: 2020/1/13 11:27
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Getter
public enum ZabbixUrl {
    /**
     * Zabbix各站url枚举
     * */
    //金川路站
    STATION_JINCHUANLU("1", "http://10.47.1.230/zabbix/api_jsonrpc.php"),

    //大河埂站
    STATION_DAHEGENG("2", "http://10.47.3.230/zabbix/api_jsonrpc.php"),

    //海屯路站
    STATION_HAITUNLU("3", "http://10.47.5.230/zabbix/api_jsonrpc.php"),

    //小屯站
    STATION_XIAOTUNLU("4", "http://10.47.7.230/zabbix/api_jsonrpc.php"),

    //金鼎山北路站
    STATION_JINDINGSHANBEILU("5", "http://10.47.9.230/zabbix/api_jsonrpc.php"),

    //苏家塘站
    STATION_SUJIATANG("6", "http://10.47.11.230/zabbix/api_jsonrpc.php"),

    //小菜园站
    STATION_XIAOYUAN("7", "http://10.47.13.230/zabbix/api_jsonrpc.php"),

    //火车北站
    STATION_HUOCHEBEI("8", "http://10.47.15.230/zabbix/api_jsonrpc.php"),

    //白龙路站
    STATION_BAILONGLU("9", "http://10.47.17.230/zabbix/api_jsonrpc.php"),

    //大树营站
    STATION_DASHUYING("10", "http://10.47.19.230/zabbix/api_jsonrpc.php"),

    //菊花村站
    STATION_JUHUACUN("11", "http://10.47.21.230/zabbix/api_jsonrpc.php"),

    //菊华站
    STATION_JUHUA("12", "http://10.47.23.230/zabbix/api_jsonrpc.php"),

    //和甸营站
    STATION_HEDIANYING("13", "http://10.47.25.230/zabbix/api_jsonrpc.php"),

    //牛街庄站
    STATION_NIUJIEZHUANG("14", "http://10.47.27.230/zabbix/api_jsonrpc.php"),

    //朱家村站
    STATION_ZHUJIACUN("15", "http://10.47.29.230/zabbix/api_jsonrpc.php"),
    /**
     *  以上暂未部署
     * */
    //羊甫头站
    STATION_YANGFUTOU("16", "http://10.47.31.230/zabbix/api_jsonrpc.php"),
    /**
     *  未通电
     * */
    //玉缘路站
    STATION_YUYUANLU("17", "http://10.47.33.230/zabbix/api_jsonrpc.php"),

    //广卫站（暂未部署）
    STATION_CHANGWEI("18", "http://10.47.35.230/zabbix/api_jsonrpc.php"),

    //塔密站
    STATION_TAMI("19", "http://10.47.37.230/zabbix/api_jsonrpc.php"),

    //斗南站
    STATION_DOUNAN("20", "http://10.47.39.230/zabbix/api_jsonrpc.php"),

    //金桂街站
    STATION_JINGUIJIE("21", "http://10.47.41.230/zabbix/api_jsonrpc.php"),

    //梅子村站
    STATION_MEIZICUN("22", "http://10.47.43.230/zabbix/api_jsonrpc.php"),

    //古城站
    STATION_GUCHENG("23", "http://10.47.45.230/zabbix/api_jsonrpc.php"),

    //可乐村站
    STATION_KELECUN("24", "http://10.47.47.230/zabbix/api_jsonrpc.php"),

    //祥丰街站
    STATION_XIANGFENGJIE("25", "http://10.47.49.230/zabbix/api_jsonrpc.php"),

    //牛头山站
    STATION_NIUTOUSHAN("26", "http://10.47.51.230/zabbix/api_jsonrpc.php"),

    //联大街站
    STATION_LIANDAJIE("27", "http://10.47.53.230/zabbix/api_jsonrpc.php"),

    //吴家营站
    STATION_WUJIAYING("28", "http://10.47.55.230/zabbix/api_jsonrpc.php"),

    //昆明南站
    STATION_KUNMINGNAN("29", "http://10.47.57.230/zabbix/api_jsonrpc.php"),

    //广卫停车场（暂未部署）
    STOP_CHANGWEI("30", "http://10.47.93.230/zabbix/api_jsonrpc.php"),

    //白龙潭停车场
    STOP_BAILONGTAN("31", "http://10.47.95.230/zabbix/api_jsonrpc.php"),

    //火车北控制中心
    CENTER_HUOCHEBEI("32", "http://10.47.97.116/zabbix/api_jsonrpc.php"),

    //大漾田车辆段（暂未部署）
    CENTER_DAYANGTIAN("33", "http://10.47.89.116/zabbix/api_jsonrpc.php"),

    //主变电所（暂未部署）
    POWER_ELECTRICITY("34", "http://10.47.91.230/zabbix/api_jsonrpc.php");


    private String code;

    private String url;

    ZabbixUrl(String code, String url) {
        this.code = code;
        this.url = url;
    }
    public static String getUrlByCode(String code) {
        for (ZabbixUrl result : ZabbixUrl.values()) {
            if (code.equals(result.getCode())) {
                return result.getUrl();
            }
        }
        return null;
    }

}