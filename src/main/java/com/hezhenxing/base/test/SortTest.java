package com.hezhenxing.base.test;


import java.text.Collator;
import java.util.*;

/**
 * Created by Xing on 2016/9/29.
 */
public class SortTest {
    public static void main(String[] args) {
        sort1();
        System.out.println("-------------------华丽分割线------------------------");
        sort2();
        System.out.println("-------------------华丽分割线------------------------");
        sort3();
    }

    /**
     * 集合排序
     */
    private static void sort1(){
        List<String> stringList = new ArrayList<>();
        stringList.add("nice");
        stringList.add("delicious");
        stringList.add("able");
        stringList.add("moon");
        stringList.add("try");
        stringList.add("friend");
        Collections.sort(stringList);
        for(String str : stringList){
            System.out.println(str);
        }
    }

    /**
     * 对象排序
     */
    private static void sort2(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("Lucy", 19));
        userList.add(new User("Jack", 19));
        userList.add(new User("Jim", 19));
        userList.add(new User("James", 19));
        userList.add(new User("Herry", 19));
        userList.add(new User("Luccy", 19));
        userList.add(new User("James", 18));
        userList.add(new User("Herry", 20));
        Collections.sort(userList,new Comparator<User>(){
            @Override
            public int compare(User o1, User o2) {
                int compareName = o1.getName().compareTo(o2.getName());
                if(compareName == 0){
                    return o1.getAge() == o2.getAge() ? 0 : (o1.getAge() > o2.getAge() ? 1 : -1);
                }
                return compareName;
            }
        });
        for (User user : userList) {
            System.out.println(user.getName() + "\t\t" + user.getAge());
        }
    }

    /**
     * 中文排序
     */
    private static void sort3(){
        List<User> userList = new ArrayList<>();
        userList.add(new User("张三", 19));
        userList.add(new User("李四", 17));
        userList.add(new User("王五", 18));
        userList.add(new User("王六", 19));

        //正序
        Collections.sort(userList, new Comparator<User>(){
            Collator cmp = Collator.getInstance(java.util.Locale.CHINA);
            @Override
            public int compare(User o1, User o2) {
                return cmp.compare(o1.getName(),o2.getName());
            }
        });
        //倒序
        Collections.sort(userList, Collections.reverseOrder(new Comparator<User>(){
            Collator cmp = Collator.getInstance(java.util.Locale.CHINA);
            @Override
            public int compare(User o1, User o2) {
                return cmp.compare(o1.getName(),o2.getName());
            }
        }));
        for (User user : userList) {
            System.out.println(user.getName() + "\t\t" + user.getAge());
        }
    }


    private static class User{
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
