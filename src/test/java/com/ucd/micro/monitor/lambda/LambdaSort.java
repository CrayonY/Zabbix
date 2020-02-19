package com.ucd.micro.monitor.lambda;

import com.ucd.micro.monitor.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * @ClassName: LambdaSort
 * @Description: lambda排序
 * @Author: Crayon
 * @CreateDate: 2019/10/31 2:39 下午
 * @Version 1.0
 * @Copyright: Copyright©2018-2019 BJCJ Inc. All rights reserved.
 **/

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class LambdaSort {
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


    public class AppleComparator implements Comparator<Person> {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge() - o2.getAge();
        }
    }

    @Test
    public void sort(){
        /**
         * 顺序排序
         */
         // 1、传递代码，函数式编程
        javaProgrammers.sort(new AppleComparator());
        System.out.println(javaProgrammers);

        // 2、匿名内部类
        javaProgrammers.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });


        // 3、使用Lambda表达式
        javaProgrammers.sort((a, b) -> a.getAge() - b.getAge());

        // 4、使用Comparator的comparing
        Comparator<Person> comparing = comparing((Person a) -> a.getAge());
        javaProgrammers.sort(comparing((Person a) -> a.getAge()));


       //或者等价于
        javaProgrammers.sort(comparing(Person::getAge));

        // 2、如果两个苹果的重量一样重，怎么办？那就再找一个条件进行排序呗
        javaProgrammers.sort(comparing(Person::getAge).reversed().thenComparing(Person:: getFirstName));
    }



    List<String> list = Arrays.asList("my","name","is","TaeYang","and","Gdragon");

/*
    Map<String, List<String>> listMap = phpProgrammers.stream()
            .collect(Collectors.toMap(
                    Person::getFirstName,
                    Person::getJob,
                    (v1, v2) -> {v1.addAll(v2);return v1;}));
*/

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



}
