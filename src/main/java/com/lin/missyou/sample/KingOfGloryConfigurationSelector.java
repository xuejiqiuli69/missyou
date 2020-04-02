/**
 * @作者 leokkzhang
 * @创建时间 2020/3/14 14:39
 */
package com.lin.missyou.sample;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class KingOfGloryConfigurationSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {HeroConfiguration.class.getName()};
    }
}
