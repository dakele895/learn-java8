package io.github.biezhi.java8.lambda.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author dalele
 * @date 2020/6/11 11:33
 */
public class ListSort {


    public static void main(String[] args) {
        //数据准备
        List<Student> list = new ArrayList<>();
        list.add(new Student("小明",1));
        list.add(new Student("小红",4));
        list.add(new Student("小刚",3));
        list.add(new Student("小鸡",5));
        list.add(new Student("小狗",2));
        BigDecimal a=new BigDecimal("0.1010");
        System.out.println(a.stripTrailingZeros().toPlainString());

        //使用Collections集合工具类进行排序
        Collections.sort(list, new Comparator<Student>() {

            @Override
            public int compare(Student o1, Student o2) {
                //升序排序，降序反写
                return o2.getAge()-o1.getAge();
            }

        });

        for (Student student : list) {
            System.out.println(student);
        }

    }
    public static class Student {

        private String name;

        private Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public Student() {
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }

}


