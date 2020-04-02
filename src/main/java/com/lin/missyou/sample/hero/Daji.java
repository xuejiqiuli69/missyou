/**
 * @作者 leokkzhang
 * @创建时间 2020/3/6 16:21
 */
package com.lin.missyou.sample.hero;

import com.lin.missyou.sample.BaseHero;

public class Daji implements BaseHero {

    private String name;
    private Integer age;

    public Daji(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Daji() {
        System.out.println("daji实例化");
    }

    public void skill1(){
        System.out.println("Daji skill1");
    }

    public void skill2(){
        System.out.println("Daji skill2");
    }

    public void skill3(){
        System.out.println("Daji skill3");
    }
}
