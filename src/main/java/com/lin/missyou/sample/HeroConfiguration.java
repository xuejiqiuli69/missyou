/**
 * @作者 leokkzhang
 * @创建时间 2020/3/10 23:44
 */
package com.lin.missyou.sample;

import com.lin.missyou.sample.hero.Anqila;
import com.lin.missyou.sample.hero.Daji;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {

    @Bean
//    @ConditionalOnProperty(value="hero.condition",havingValue="daji",matchIfMissing = true)
//    @Conditional(DajiCondition.class)
    public BaseHero daji(){
        return new Daji("daji",18);
    }

//    @Bean
//    @ConditionalOnProperty(value="hero.condition",havingValue="anqila")
//    @Conditional(AnqilaCondition.class)
    public BaseHero anqila(){
        return new Anqila("anqila",18);
    }
}
