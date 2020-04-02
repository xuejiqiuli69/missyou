/**
 * @作者 leokkzhang
 * @创建时间 2020/2/23 20:27
 */
package com.lin.missyou.sample.hero;


import com.lin.missyou.sample.BaseHero;

public class Wangzhaojun implements BaseHero {

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String name;
    private Integer age;

    public Wangzhaojun(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Wangzhaojun() {
        System.out.println("wangzhaojun实例化");
    }

    public void skill1(){
        System.out.println("Wangzhaojun skill1");
    }

    public void skill2(){
        System.out.println("Wangzhaojun skill2");
    }

    public void skill3(){
        System.out.println("Wangzhaojun skill3");
    }
}
