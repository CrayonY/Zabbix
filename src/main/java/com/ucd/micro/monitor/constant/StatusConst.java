package com.ucd.micro.monitor.constant;

/**
 * @ClassName: StatusConst
 * @Description: TODO
 * @Author: liuxin
 * @CreateDate: 2020/1/13 17:57
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
public class StatusConst {
    /*返回DTO成功状态*/
    /** 设备正常 */
    public static final Integer EQUIPMENT_NORMAL = 1;
    /** 设备异常 */
    public static final Integer EQUIPMENT_ERROR= 2;
    /** 设备离线*/
    public static final Integer EQUIPMENT_DOWN= 3;

    public static final class HostStatus {
        /** 节点正常 */
        public static final Integer HOST_NORMAL = 1;
        /** 节点警告 */
        public static final Integer HOST_ALERT= 2;
        /** 节点一般严重*/
        public static final Integer HOST_BAD= 3;
        /** 节点严重*/
        public static final Integer HOST_TARRIBLE= 4;
        /** 节点灾难*/
        public static final Integer HOST_DISATER= 5;

    }
}