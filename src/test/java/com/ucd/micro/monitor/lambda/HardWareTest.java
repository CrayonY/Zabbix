package com.ucd.micro.monitor.lambda;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by crayon on 2019/4/30.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HardWareTest {
@Test
    public void test(){
        List<String> testList = new ArrayList<String>();
        String[] A = {"金川路站","大河埂站","海屯路站","小屯站","金鼎山北路站","苏家塘站","小菜园站","火车北站","白龙路站","大树营站","菊花村站","菊华站","和甸营站","牛街庄站","朱家村站","羊甫头站","玉缘路站","广卫站","塔密站","斗南站","金桂街站","梅子村站","古城站","可乐村站","祥丰街站","牛头山站","联大街站","吴家营站","昆明南站"};
        List<String> resultList= new ArrayList<>(Arrays.asList(A));
         resultList.forEach((k)->{
                     resultList.forEach((v)->{
                     if (!k.equals(v)){
                         String a = k+"_"+v;
                         testList.add(a);
                     }
                     });
            });
         System.out.println(testList.toString());

       /*     for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (!A[i].equals(A[j])) {
                        String a = A[i]+"_"+A[j];
                        testList.add(a);
                    }
                }
            }
        System.out.println(testList.toString());*/

    }


}
