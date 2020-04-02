/**
 * @作者 leokkzhang
 * @创建时间 2020/3/15 15:14
 */
package com.lin.missyou.core.hack;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;


public class AutoPrefixUrlMapping extends RequestMappingHandlerMapping {

    @Value("${missyou.api-package}")
    private String apiPackagePath;

    @Override
    protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
        RequestMappingInfo mappingInfo = super.getMappingForMethod(method, handlerType);
        if(mappingInfo != null){
            String prefix = this.getPrefix(handlerType);
            if(prefix != null){
                return RequestMappingInfo.paths(prefix).build().combine(mappingInfo);
            }
        }
        return mappingInfo;
    }

    private String getPrefix(Class<?> handlerType){
        String packageName = handlerType.getPackage().getName();
        //由于整个项目中还有一些默认的地方被打上了@RequestMapping  例如默认的找不到页面的错误处理
        //因此 这个方法应该只处理api目录下的@RequestMapping 忽略其他地方的RequestMapping
        if(packageName.startsWith(this.apiPackagePath)){
            String dotPath = packageName.replaceAll(this.apiPackagePath,"");
            return dotPath.replace(".","/");
        }
        return null;
    }

}
