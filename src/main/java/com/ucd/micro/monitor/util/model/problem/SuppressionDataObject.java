package com.ucd.micro.monitor.util.model.problem;

import lombok.Data;

/**
 * @ClassName: ProblemObject
 * @Description: TODO
 * @Author: gongweimin
 * @CreateDate: 2020/1/12 17:12
 * @Version 1.0
 * @Copyright: Copyright2018-2020 BJCJ Inc. All rights reserved.
 **/
@Data
public class SuppressionDataObject {
    private String maintenanceid;
    private String suppress_until;

}
