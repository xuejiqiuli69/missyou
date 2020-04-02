/**
 * @作者 leokkzhang
 * @创建时间 2020/3/14 14:28
 */
package com.lin.missyou;

import com.lin.missyou.sample.BaseHero;
import com.lin.missyou.sample.EnableKingOfGloryConfiguration;
import com.lin.missyou.sample.HeroConfiguration;
import com.lin.missyou.sample.KingOfGloryConfigurationSelector;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

//@ComponentScan
//@Import(KingOfGloryConfigurationSelector.class)
@EnableKingOfGloryConfiguration
public class KingOfGloryApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
               new SpringApplicationBuilder(KingOfGloryApplication.class)
                       .web(WebApplicationType.NONE).run(args);
        BaseHero baseHero = (BaseHero) context.getBean("daji");
        baseHero.skill1();
    }
}
