package com.ucd.micro.monitor.util.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName: HostModel
 * @Description: TODO
 * @Author: liuxin
 * @CreateDate: 2020/1/13 15:46
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HostModel {
    private String ip;
    private String hostName;

}