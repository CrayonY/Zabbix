package com.ucd.micro.monitor.lambda;


import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @ClassName: LambdaMap
 * @Description: TODO
 * @Author: Crayon
 * @CreateDate: 2019/11/8 3:16 下午
 * @Version 1.0
 * @Copyright: Copyright©2018-2019 BJCJ Inc. All rights reserved.
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LambdaMap {

    @Test
    public void listAndMap(){
        // Collectors.joining(",")  Collectors.toList()
        Map<String, Object> map1 = new HashMap<>(16);

        Map<String, Object> map2 = new HashMap<>(16);
        Map<String, Object> map3 = new HashMap<>(16);
        List<Map<String, Object>> mapList = new ArrayList<>();

        Map<String, Object> mapTest = new HashMap<>(16);

        List<String> tractivePowerList = new ArrayList<>();
        List<String> othersList = new ArrayList<>();
        map1.put("A","祥丰街站");
        map1.put("B","9178");
        map1.put("C","10110");
        map1.put("D",new Date());

        map2.put("A","羊甫头站");
        map2.put("B","9488");
        map2.put("C","8896");
        map2.put("D",new Date());

        map3.put("A","苏家塘站");
        map3.put("B","8866");
        map3.put("C","8419");
        map3.put("D",new Date());

        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);


        /** 5.转换为List<List<Map<String,Object></> [1,2,4]*/

        System.out.println("mapList"+mapList.toString());
        /** 4.转换为List<List<String> [1,2,4]*/
        List<List<Object>> resultValuesList = new ArrayList<List<Object>>();
        List<List<String>> resultSortedKeyList = new ArrayList<List<String>>();

        mapList.stream().forEach(mapnew->{
            List<String> resultSortedKey = new ArrayList<>();
            List<Object> resultValues = map3.entrySet().stream()
                    //sort a Map by key and stored in resultSortedKey
                    .sorted(Map.Entry.<String, Object>comparingByKey().reversed())
                    // 获取KEY值
                    .peek(e -> resultSortedKey.add(e.getKey()))
                    // 获取value值
                    .map(x -> x.getValue())
                    // 去除value值为祥丰街站的信息
                    //.filter(x -> !"祥丰街站".equals(x))
                    // filter banana and return it to resultValues
                    .collect(Collectors.toList());

            List<Object> result2 = mapnew.values().stream()
                    .collect(Collectors.toList());
            resultValuesList.add(result2);
            resultSortedKeyList.add(resultSortedKey);

        });
        System.out.printf("4.转换为List<List<String> [1,2,4]:"+resultValuesList.toString());

        /** 1.根据KEY值，获取value，并以逗号隔开 拼接成字符串 string()*/
        final String values = mapList.stream()
                .map(item -> item.get("B"))
                .filter(Objects::nonNull)
                .map(item -> item.toString())
                .collect(Collectors.joining(","));
        System.out.println("逗号隔开 拼接成字符串values==========="+values);


        /** 2.根据KEY值，获取value,存到List里面 */
        List<String> stringList = mapList.stream()
                .map(item -> item.get("B"))
                .filter(Objects::nonNull)
                .map(item -> item.toString())
                .collect(Collectors.toList());

        mapList.stream().collect(Collectors.toList()).forEach(mapall -> {
            Map<String, Object> y21 = (Map<String, Object>) mapall.get("A");
        });

        System.out.println("根据KEY值，获取value,存到List里面,stringList==================="+stringList.toString());

        /** 3.筛选Key为某个值得数据,并把值存到对应 List<Map<String,Object>> 中*/
        mapList.stream().forEach(mapnew->{
            Map<String, Object> mapNew = new HashMap<>(16);
            mapnew.forEach((a,b) -> {
                if(b.equals("哈哈哈")){
                    mapNew.put((String) a,"哈哈哈");
                }
            });
            List<Map<String, Object>> mapList1 = new ArrayList<>();
            mapList1.add(mapNew);
            System.out.println("筛选Key为某个值得数据,并把值存到对应 List<Map<String,Object>>中"+mapNew.toString());
            tractivePowerList.add(map1.get("C").toString());
            othersList.add(map1.get("D").toString());
        });


        System.out.println("tractivePowerList"+tractivePowerList.toString());
        System.out.println("othersList"+othersList.toString());
    }
    @Test
    public void mapListGroup(){
        /** 根据KEY值进行分组==========={A=[祥丰街站, 羊甫头站, 苏家塘站],
         * B=[9178, 9488, 8866],
         * C=[10110, 8896, 8419],
         * D=[Wed Nov 13 14:56:57 CST 2019, Wed Nov 13 14:56:57 CST 2019, Wed Nov 13 14:56:57 CST 2019]}
         * */
        Map<String, Object> map1 = new HashMap<>(16);

        Map<String, Object> map2 = new HashMap<>(16);
        Map<String, Object> map3 = new HashMap<>(16);
        List<Map<String, Object>> mapList = new ArrayList<>();

        Map<String, Object> mapTest = new HashMap<>(16);
        Map<String, Object> mapTest1 = new HashMap<>(16);

        List<String> tractivePowerList = new ArrayList<>();
        List<String> othersList = new ArrayList<>();
        map1.put("A","祥丰街站");
        map1.put("B","9178");
        map1.put("C","10110");
        map1.put("D",new Date());

        map2.put("A","羊甫头站");
        map2.put("B","9488");
        map2.put("C","8896");
        map2.put("D",new Date());

        map3.put("A","苏家塘站");
        map3.put("B","8866");
        map3.put("C","8419");
        map3.put("D",new Date());

        mapList.add(map1);
        mapList.add(map2);
        mapList.add(map3);

        List<Map<String, Object>> mapListEquipment = new ArrayList<>();

        mapTest.put("equipments",mapList);
        mapTest1.put("equipments",mapList);
        mapListEquipment.add(mapTest);
        mapListEquipment.add(mapTest1);

        System.out.println("mapListEquipment"+mapListEquipment.toString());

        List<Object> dayList = mapListEquipment.stream().map(item -> item.get("equipments")).filter(Objects::nonNull)
                .map(item -> item.toString()).collect(Collectors.toList());


        Map<String, List<Map<String, Object>>> glist = mapListEquipment.stream().collect(Collectors.groupingBy(e -> e.keySet().toString()));
        System.out.println("dayList"+dayList.toString());


        dayList.stream().forEach(a->{

        });

        Map<String, Object> merged = mapListEquipment.stream()
                .map(Map::entrySet).flatMap(Set::stream)
                .distinct()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        List<Map<String, Object>> lists = new ArrayList<>();
        lists.add(merged);

        System.out.println("lists"+lists.toString());

        System.out.println("glist"+glist.toString());


        Map<String, List<Object>> mapListEquipment111 = mapListEquipment.stream()
                .map(Map::entrySet)
                .flatMap(Set::stream)
                .collect(Collectors.groupingBy(
                        map -> (map.getKey()).toString(),
                        Collectors.mapping(map -> (map.getValue()).toString(),
                                Collectors.toList())));
        System.out.println("mapListEquipment根据KEY值进行分组=============="+mapListEquipment111.toString());


        Map<String, List<String>> result1 = mapList.stream()
                .map(Map::entrySet)
                .flatMap(Set::stream)
                .collect(Collectors.groupingBy(
                        map -> (map.getKey()).toString(),
                        Collectors.mapping(map -> (map.getValue()).toString(),
                                Collectors.toList())));
        System.out.println("根据KEY值进行分组=============="+result1.toString());
        Stream<Object> mlist = mapList.stream().map(Map::entrySet);
        Stream<Object> fmlist = mapList.stream()
                .map(Map::entrySet)
                .flatMap(Set::stream);


    }


    /**
     * 对List<map> 进行分组合并，按某个相同的key进行合并，并sum某个key，
     * 类似单表group by 功能
     */
    @Test
    public void summaryGroup(){
        Map<String, Object> m1=new HashMap<>();
        Map<String, Object> m11=new HashMap<>();
        Map<String, Object> m12=new HashMap<>();

        List<Map<String, Object>> list =new ArrayList<>();

        List<Map<String, Object>> result =new ArrayList<>();

        m1.put("aa", 11);
        m1.put("bb", "xm");
        m1.put("cc", 122);
        m1.put("dd", 122);

        m11.put("aa", 12);
        m11.put("bb","xm");
        m11.put("cc", 10);
        m11.put("dd", 122);


        m12.put("aa", 13);
        m12.put("bb", "zs");
        m12.put("cc", 31);
        m12.put("dd", 122);

        list.add(m1);
        list.add(m11);
        list.add(m12);

        //按bb进行分组统计
        Map<String, List<Map<String, Object>>> glist = list.stream().collect(Collectors.groupingBy(e -> e.get("bb").toString()));

        System.out.println("-----------按照bb进行分组统计后结果------------"+glist);
        glist.forEach((k,slist)->{
            Map<String, Object> nmap=new HashMap<>();
            IntSummaryStatistics sumcc = slist.stream().collect(Collectors.summarizingInt(e-> Integer.valueOf(e.get("cc").toString())));
            nmap.put("aa", slist.get(0).get("dd"));
            nmap.put("bb", slist.get(0).get("dd"));
            nmap.put("cc", sumcc.getSum());//求和
            nmap.put("counts", slist.size());//计算
            nmap.put("dd", slist.get(0).get("dd"));
            result.add(nmap);
        });
        System.out.println("--------summaryGroup-------------");
        result.forEach(x->{
            System.out.println(x);
        });
    }


    /**
     * list的中map合并为一个map,即List<Map> 转为Map newMap,
     * newMap中包含了list中每个map的key与value
     */
    @Test
    public void mergeListmapToOnemap(){

        Map<String, Object> h1 = new HashMap<>();
        h1.put("12","fdsa");
        h1.put("123","fdsa");
        h1.put("124","fdsa");
        h1.put("125","fdsa");

        Map<String, Object> h2 = new HashMap<>();
        h2.put("h12","fdsa");
        h2.put("h123","fdsa");
        h2.put("h124","fdsa");
        h2.put("h125","fdsa");

        Map<String, Object> h3 = new HashMap<>();
        h3.put("h12","fdsa");
        h3.put("h3123","fdsa");
        h3.put("h3124","fdsa");
        h3.put("h3125","fdsa");

        List<Map<String, Object>> lists = new ArrayList<>();
        lists.add(h1);
        lists.add(h2);
        lists.add(h3);

        //用java 8 把lists里面的map合并成一个新的map:
        Map<String, Object> haNew = new HashMap<>(); // 包含了h1,h2,h3的内容

        Map<String, Object> merged = lists.stream()
                .map(Map::entrySet)
                .flatMap(Set::stream)
                .distinct()
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue));


        Stream<Object> mlist = lists.stream().map(Map::entrySet);
        Stream<Object> fmlist = lists.stream()
                .map(Map::entrySet)
                .flatMap(Set::stream);

        System.out.println("merged="+merged);

    }



    /**
     * 两个list《map》中的map合并为一个list《map》,新的list中的每个map包含了之前的两个listmap的key
     */
    @Test
    public void mergeTwoListmapToOneListmap(){
        String mergeKey = "2";
        List<Map<String, Object>> lists = new ArrayList<>();

        List<Map<String, Object>> lists1 = new ArrayList<>();
        List<Map<String, Object>> lists2 = new ArrayList<>();


        //--------------lists1--------------------
        Map<String, Object> h1 = new HashMap<>();
        h1.put("name","fdsa0");
        h1.put("2","fdsa0");
        h1.put("3","fdsa0");
        h1.put("4","fdsa0");

        Map<String, Object> h2 = new HashMap<>();
        h2.put("name","fdsa00");
        h2.put("2","fdsa00");
        h2.put("3","fdsa00");
        h2.put("4","fdsa00");

        lists1.add(h1);
        lists1.add(h2);

        //--------------lists2--------------------

        Map<String, Object> h3 = new HashMap<>();
        h3.put("name","fdsa0");
        h3.put("21","fdsa1");
        h3.put("31","fdsa1");
        h3.put("41","fdsa1");

        Map<String, Object> h4 = new HashMap<>();
        h4.put("name","fdsa00");
        h4.put("21","fdsa2");
        h4.put("31","fdsa2");
        h4.put("41","fdsa2");

        lists2.add(h3);
        lists2.add(h4);
        //测试
        //mergeKey="name";

        lists1.parallelStream().forEach(x->{

            Map<String, Object> y2 = lists2.parallelStream().filter(y->y.get(mergeKey).toString().equals(x.get(mergeKey).toString()))
                    .findFirst().get();

            List<Map<String, Object>> sublist = Arrays.asList(x,y2);


            Map<String, Object> merged = sublist.stream()
                    .map(Map::entrySet)
                    .flatMap(Set::stream)
                    .distinct()
                    .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
            lists.add(merged);

        });
        System.out.println("----------list--mergetMap---------");
        lists.forEach(x->{
            System.out.println(x);

        });

    }

    // todo     List<Person> users = mapList.stream().map(m -> new User(m.getOrDefault("name", "").toString(), m.getOrDefault("code", "").toString()))
    //            .collect(Collectors.toList());
    //List<Map<String, Object>> maps = null;
    //
    //Map<Integer, List<Integer>> result = maps.stream()
    //        .collect(Collectors.groupingBy(
    //                map -> ((Number) map.get("id")).intValue(),
    //                    Collectors.mapping(map -> ((Number) map.get("uid")).intValue(),
    //                            Collectors.toList())));




    /**
     * @author Crayon
     * @Description 对集合字段进行分组 eg：
     * {
     *     "code": "0",
     *     "success": true,
     *     "msg": "成功",
     *     "data": {
     *             {
     *                 "stationname": "昆明火车南站",
     *
     *                 //"typeTong350kv": 32.90000,
     *                 //"typeTong400kv": 32.90000,
     *                 //"typeHuan350kv": 32.90000,
     *                 //"typeHuan400kv": 32.90000,
     *                  typeTongList: [
     *                 {
     *                   "typeTong350kv": 32.9,
     *                   "typeTong400kv": 32.9
     *                 }
     *                 typeHuanList: [
     *                 {
     *                   "typeHuan350kv": 32.9,
     *                   "typeHuan400kv": 32.9
     *                 }
     *                 "350kv": "20",
     *                 "400kv": "30"
     *             },
     *             {
     *                 "stationname": "昆明东站",
     *                 //"typeTong350kv": 52.90000,
     *                 //"typeTong400kv": 52.90000,
     *                 //"typeHuang350kv": 52.90000,
     *                 //"typeHuang400kv": 52.90000,
     *                  typeTongList: [
     *                 {
     *                   "typeTong350kv": 52.9,
     *                   "typeTong400kv": 52.9,
     *                 }
     *                 typeHuanList: [
     *                 {
     *                   "typeHuan350kv": 52.9,
     *                   "typeHuan400kv": 52.9,
     *                 }
     *                 "350kv": "20",
     *                 "400kv": "30"
     *             }
     *     }
     * }
     * @date 2020/2/19 10:15 上午
     * @params []
     * @exception
     * @return void
     */
    @Test
    public void kafkaListGroup(){
        // Collectors.joining(",")  Collectors.toList()
        Map<String, Object> map1 = new HashMap<>(16);
        Map<String, Object> map2 = new HashMap<>(16);
        //Map<String, Object> map3 = new HashMap<>(16);
        List<Map<String, Object>> mapList = new ArrayList<>();
        map1.put("stationname","昆明火车南站");
        map1.put("350kv","9178");
        map1.put("400kv","10110");
        map1.put("typeTong350kv",32.9);
        map1.put("typeTong400kv",32.9);
        map1.put("typeHuan350kv",32.9);
        map1.put("typeHuan400kv",32.9);


        map2.put("stationname","昆明北站");
        map2.put("350kv","9178");
        map2.put("400kv","10110");
        map2.put("typeTong350kv",52.9);
        map2.put("typeTong400kv",52.9);
        map2.put("typeHuan350kv",52.9);
        map2.put("typeHuan400kv",52.9);

        mapList.add(map1);
        mapList.add(map2);

        System.out.println("测试输出格式"+ mapList.toString());

            List<Map<String, Object>> list = new ArrayList<>();
            JSONObject js = new JSONObject();
            mapList.forEach(mm -> {
                js.put("stationname", mm.get("stationname"));
                js.put("350kv", mm.get("350kv"));
                js.put("400kv", mm.get("400kv"));
                JSONObject typeTongList = new JSONObject();
                typeTongList.put("typeTong350kv", mm.get("typeTong350kv"));
                typeTongList.put("typeTong400kv", mm.get("typeTong400kv"));

                JSONObject typeHuanList = new JSONObject();
                typeHuanList.put("typeHuan350kv", mm.get("typeHuan350kv"));
                typeHuanList.put("typeHuan400kv", mm.get("typeHuan400kv"));
                js.put("typeTongList", typeTongList);
                js.put("typeHuanList", typeHuanList);
            });
        System.out.println("给前端传输的格式要求"+js.toString());

    }
}
