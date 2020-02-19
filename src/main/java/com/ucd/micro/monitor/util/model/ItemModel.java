package com.ucd.micro.monitor.util.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

/**
 * @ClassName: ItemModel
 * @Description: TODO
 * @Author: liuxin
 * @CreateDate: 2020/1/13 11:22
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemModel {
    private Integer id;
    private Integer hostId;
    private String value;
    private String name;

}