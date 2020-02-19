package com.ucd.micro.monitor.model;

import lombok.Data;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: Msg
 * @Description: 实体类
 * @Author: Crayon
 * @CreateDate: 2019/11/5 3:31 下午
 * @Version 1.0
 * @Copyright: Copyright©2018-2019 BJCJ Inc. All rights reserved.
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Data
public class Msg {
    String msg;

}
