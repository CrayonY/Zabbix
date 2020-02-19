package com.ucd.micro.monitor.lambda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName: MyTest
 * @Description: TODO
 * @Author: Crayon
 * @CreateDate: 2019/7/25 4:38 PM
 * @Version 1.0
 * @Copyright: Copyright©2018-2019 BJCJ Inc. All rights reserved.
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyTest {

    @Test
    public void javaTest(){
        int item_one = 1;
        int item_two = 2;
        int item_three = 3;
        int total = item_one + item_two + item_three;
        System.out.println("输出"+total);
    }


    /**
     * 双引号相加
     */
    @Test
    public void MyTest(){

        // 在常量池上创建常量AA、BB和AABB，并返回AABB
        String a1 = "AA" + "BB";
        // 常量池上存在常量AABB
        String a2 = "AABB";
        String a3 = "AA" + "BB";
        System.out.println(a2 == a3); //true


        System.out.println("111111111111"+a2);

        // 常量池上存在引用AABB
        // 堆上创建对象AA、BB和AABB，在常量池上创建常量AA和BB
        String a4 = new String("AA") + new String("BB");
        a4.intern();
        String a5 = "AA" + "BB";
        System.out.println(a4 == a5); //true
    }


    @Test
    public void MyTest1(){
    }

    @Test
    public void Test(){
        // 在常量池上创建常量AA、BB和AABB，并返回AABB
        String a1 = "AA" + "BB";
    }

    @Test
    public void timeTest(){
        Date date = new Date();
        // String -> LocalDateTime String-> LocalDate
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse("2017-09-02 17:07:05",df);
        LocalDate localDate1 = LocalDate.parse("2017-09-02 17:07:05",df);
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("yyyy/M/d");
        String localDate = df1.format(localDate1);
        System.out.println("localDate"+localDate);

        System.out.println("localDateTime"+localDateTime);
        System.out.println("localDate1"+localDate1);
        LocalDate today = LocalDate.now();
        String strDate3 = df1.format(today);
        System.out.println("LocalDate"+strDate3);

    }

    /**
     * 生成随机数
     */
    @Test
    public void random() {
        Random r = new Random();
        float sum = 0;
        List<Integer> lists1 = new ArrayList();
        List<Integer> lists2 = new ArrayList();

        List<Integer> lists3 = new ArrayList();

        List<Integer> lists4 = new ArrayList();

        List<Integer> lists5 = new ArrayList();
        List<Integer> lists6 = new ArrayList();
        List<Integer> lists7 = new ArrayList();
        List<Integer> lists8 = new ArrayList();
        List<Integer> lists9 = new ArrayList();


        // 时间状态  00:00、15:00、30:00、45:00


        // 风险车站 0
        System.out.println("AG 风险车站【0】");
        //AG 设备总数 300-700


            for (int i = 0; i < 29; i++) {
                //创建Random类对象
                Random random = new Random();
                //产生随机数
                int number = random.nextInt(700 - 300 + 1) + 300;
                lists1.add(number);
            }
            System.out.println("AG 设备总数 300-700" + lists1.toString().replace(",", "\n"));


        // AG 正常服务总数 比设备一到十个

            // AG 失效服务  0-5
            for (int i = 0; i < 29; i++) {
                //创建Random类对象
                Random random = new Random();
                //产生随机数
                int number = random.nextInt(5 - 0 + 1) + 0;
                lists2.add(number);
            }
            System.out.println("AG 失效服务  0-5" + lists2.toString().replace(",", "\n"));



            // TVM风险车站  0-5
            for (int i = 0; i < 29; i++) {
                //创建Random类对象
                Random random = new Random();
                //产生随机数
                int number = random.nextInt(5 - 0 + 1) + 0;
                lists3.add(number);
            }
            System.out.println("TVM风险车站   0-5" + lists3.toString().replace(",", "\n"));


            // TVM 设备总数  100-300
            for (int i = 0; i < 29; i++) {
                //创建Random类对象
                Random random = new Random();
                //产生随机数
                int number = random.nextInt(300 - 100 + 1) + 100;
                lists4.add(number);
            }
            System.out.println("TVM 设备总数  100-300" + lists4.toString().replace(",", "\n"));



            // TVM 全模式 0-6
            for (int i = 0; i < 29; i++) {
                //创建Random类对象
                Random random = new Random();
                //产生随机数
                int number = random.nextInt(6 - 0 + 1) + 0;
                lists5.add(number);
            }
            System.out.println("TVM 全模式 0-6" + lists5.toString().replace(",", "\n"));



            // TVM 单模式 0-6
            for (int i = 0; i < 29; i++) {
                //创建Random类对象
                Random random = new Random();
                //产生随机数
                int number = random.nextInt(6 - 0 + 1) + 0;
                lists6.add(number);
            }
            System.out.println("TTVM 单模式 0-6" + lists6.toString().replace(",", "\n"));


            // TVM 失效服务 0-4
            for (int i = 0; i < 29; i++) {
                //创建Random类对象
                Random random = new Random();
                //产生随机数
                int number = random.nextInt(4 - 0 + 1) + 0;
                lists7.add(number);
            }
            System.out.println("TVM 失效服务0-4" + lists7.toString().replace(",", "\n"));

            // TVM 一票通 0
            System.out.println("TVM 一票通 0 【0】");
            // TVM 一卡通 0
            System.out.println("TTVM 一卡通 0 【0】");
        List<Integer> li = Stream.iterate(1, item -> item+1).limit(116).collect(Collectors.toList());


        System.out.println("1-116数字"+li.toString().replace(",", "\n"));

      int rd1 = new Random().nextInt(201);
      int rd2 = new Random().nextInt(201-rd1);
      int rd3 = new Random().nextInt(101-rd1-rd2);
      int rd4 = new Random().nextInt(101-rd1-rd2-rd3);
      int rd5 = new Random().nextInt(101-rd1-rd2-rd3-rd4);

        }

        @Test
        public void euqipmentMap(){
            Map<String, Object> map1 = new HashMap<>(16);

            Map<String, Object> map2 = new HashMap<>(16);
            Map<String, Object> map3 = new HashMap<>(16);
            List<Map<String, Object>> mapList = new ArrayList<>();

            Map<String, Object> mapTest = new HashMap<>(16);
            Map<String, Object> mapTest1 = new HashMap<>(16);



            List<String> tractivePowerList = new ArrayList<>();
            List<String> othersList = new ArrayList<>();
            map1.put("A","祥丰街站");


            map2.put("A","羊甫头站");


            map3.put("A","苏家塘站");


            mapList.add(map1);
            mapList.add(map2);
            mapList.add(map3);

            List<Map<String, Object>> mapListEquipment = new ArrayList<>();

            mapTest.put("equipments",mapList);
            mapTest1.put("equipments",mapList);
            mapListEquipment.add(mapTest);
            mapListEquipment.add(mapTest1);


    List<Map<String, Object>> test = new ArrayList<>();

      mapListEquipment.stream().forEach(mapnew->{
                Map<String, Object> mapNew = new HashMap<>(16);
                mapnew.forEach((a,b) -> {
                    if(a.equals("equipments")){
                       // mapNew.put((String) a,"哈哈哈");
                        test.add((Map<String, Object>) b);
                    }
                });
            });

                System.out.println("筛选Key为某个值得数据,并把值存到对应 List<Map<String,Object>>中"+test.toString());
    System.out.println("=====");

        }


}
