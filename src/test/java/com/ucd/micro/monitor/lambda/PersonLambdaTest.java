package com.ucd.micro.monitor.lambda;

import com.alibaba.fastjson.JSON;
import com.ucd.visualization.common.ApiResultType;
import com.ucd.visualization.common.ResultVO;
import com.ucd.visualization.custom.layout.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by crayon on 2019/4/22.
 * lambda数据筛选
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonLambdaTest {

    List<Person> javaProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Evonne", "Jaycob", "Java programmer", "male", 43, 2000));
            add(new Person("Alvin", "Brittany", "Java programmer", "female", 23, 1500));
            add(new Person("Quinn", "Donny", "Java programmer", "male", 33, 1800));
            add(new Person("Evonne", "Jonie", "Java programmer", "female", 32, 1600));
            add(new Person("Fraser", "Hervey", "PHP programmer", "male", 22, 1200));
            add(new Person("Rosalind", "Jaimie", "PHP programmer", "female", 27, 1900));
        }
    };


    List<Person> phpProgrammers = new ArrayList<Person>() {
        {
            add(new Person("Jarrod", "Pace", "PHP programmer", "male", 34, 1550));
            add(new Person("Clarette", "Cicely", "PHP programmer", "female", 23, 1200));
            add(new Person("Victor", "Channing", "PHP programmer", "male", 32, 1600));
            add(new Person("Tori", "Sheryl", "PHP programmer", "female", 21, 1000));
            add(new Person("Osborne", "Shad", "PHP programmer", "male", 32, 1100));
            add(new Person("Rosalind", "Layla", "PHP programmer", "female", 25, 1300));
            add(new Person("Fraser", "Hewie", "PHP programmer", "male", 36, 1100));
            add(new Person("Quinn", "Tamara", "PHP programmer", "female", 21, 1000));
            add(new Person("Alvin", "Lance", "PHP programmer", "male", 38, 1600));
            add(new Person("Evonne", "Shari", "PHP programmer", "female", 40, 1800));
        }
    };


    @Test
    public void test() {

        // Java programmer true

        // PHP programmer false

        List<String> cc = new ArrayList<>();
        List<String> gg = new ArrayList<>();
        gg = cc.stream().filter(s -> s.equals("aa")).collect(Collectors.toList());


        cc.add("a");
        cc.add("b");
        cc.add("c");
        cc.add("h");


        List<String> mm = new ArrayList<>();
        mm.add("d");
        mm.add("e");
        mm.add("f");
        mm.add("a");
        mm.add("b");
        mm.add("c");

        List<String> dd = new ArrayList<>();
        mm.forEach(m ->{
            if(cc.parallelStream().noneMatch(m::equals)){
                dd.add(m);
            }
        });
        System.out.println("dd"+dd);


        ResultVO resultVO = ResultVO.SUCC(ApiResultType.SUCCESS.code,ApiResultType.SUCCESS.message,javaProgrammers);
        Object object = resultVO.getData();

        String pageViewString = Tools.toJson(object);

        List<Person> list = JSON.parseArray(pageViewString,Person.class);



        /** 输出aalist中详细信息*/


        List<String> aa = new ArrayList<>();
        aa.add("Jarrod");
        aa.add("Clarette");
        aa.add("Victorqqq");


        List<Person> collect11 = new ArrayList<>();
        phpProgrammers.forEach(allFirs ->{
            if(aa.parallelStream().anyMatch(allFirs.getFirstName()::equals)){
                collect11.add(allFirs);
            }

        });

        System.out.println("(ˉ▽￣～) 切~~"+collect11.toString());

        /** 查出字段为firstName的数据并存到list中 */
        List<String> firstNameAll = phpProgrammers.parallelStream().map(Person::getFirstName).collect(Collectors.toList());
        System.out.println("firstName:"+firstNameAll);

        /** 查出job 为PHP programmer的数据 */
        javaProgrammers = javaProgrammers.stream().filter(a -> a.getJob().equals("PHP programmer") || a.getJob().equals("Java programmer")).collect(Collectors.toList());


        System.out.println("javaProgrammers"+javaProgrammers);

        List<String> firstNamePHP = javaProgrammers.parallelStream().map(Person::getFirstName).collect(Collectors.toList());
        System.out.println("firstNamePHP"+firstNamePHP);

        // 查找数据
        List<String> collect = new ArrayList<>();
        firstNameAll.forEach(allFirstName ->{
            if(firstNamePHP.parallelStream().noneMatch(allFirstName::equals)){
                collect.add(allFirstName);
            }
        });
        System.out.println("collect"+collect);

        // 简化版
        List<String> collect1 = firstNameAll.parallelStream().filter(allFirstName ->firstNamePHP.parallelStream().noneMatch(allFirstName::equals)).collect(Collectors.toList());

        System.out.println("collect1"+collect1);
    }

/***===================================================================一、使用lambda表达式实现Comparator================================================================================*/

    List<String> list = Arrays.asList("my","name","is","TaeYang","and","Gdragon");

    /**
     * 对一个String的list进行排序 - 使用老方法
     */
    @Test
    public void oldSort(){
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                 if(o1.charAt(1) <= o2.charAt(1)){
                    return 1;
                }else {
                    return -1;
                }
            }
        });

        System.out.println("最终排序结果为"+list.toString());

    }

    @Test
    public void NewSortByLambda(){

        Collections.sort(list,((o1, o2) -> o1.charAt(1) < o2.charAt(1) ? 1 : -1));

        System.out.println("lambda最终排序结果"+list.toString());
    }

/***===================================================================二、使用lambda表达式替换Runnable匿名内部类=========================================================================*/

    @Test
    public void runSomeThing() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("开始运行了哟");
            }
        };

        new Thread(runnable).start();
    }

    /**
     * 使用lambda后
     */
    @Test
    public void runSomeThingByLambda() {
        new Thread(() -> System.out.println("lambda测试要开始了")).start();
    }


}


