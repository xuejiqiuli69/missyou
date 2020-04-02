/**
 * @作者 leokkzhang
 * @创建时间 2020/2/23 20:21
 */
package com.lin.missyou.sample.hero;


import com.lin.missyou.sample.BaseHero;
import org.springframework.stereotype.Component;

public class Anqila implements BaseHero {


    private String name;
    private Integer age;

    public Anqila(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Anqila() {
        System.out.println("anqila实例化");
    }

    public void skill1(){
        System.out.println("Anqila skill1");
    }

    public void skill2(){
        System.out.println("Anqila skill2");
    }

    public void skill3(){
        System.out.println("Anqila skill3");
    }
}
