package com.demo.controllerlayer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * 如果直接使用 ResponseBodyAdvice，对于一般的类型都没有问题，当处理字符串类型时，会抛出 xxx.包装类 cannot be cast to java.lang.String 的类型转换的异常
 * 在 ResponseBodyAdvice 实现类中 debug 发现，只有 String 类型的 selectedConverterType 参数值是 org.springframework.http.converter.StringHttpMessageConverter，而其他数据类型的值是 org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
 * 最合理的做法应该是调整 MappingJackson2HttpMessageConverter 在集合中的顺序
 * @author cj
 * @created on 9/26/24
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * 交换MappingJackson2HttpMessageConverter与第一位元素
     * 让返回值类型为String的接口能正常返回包装结果
     *
     * @param converters initially an empty list of converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        for (int i = 0; i < converters.size(); i++) {
            if (converters.get(i) instanceof MappingJackson2HttpMessageConverter) {
                MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = (MappingJackson2HttpMessageConverter) converters.get(i);
                converters.set(i, converters.get(0));
                converters.set(0, mappingJackson2HttpMessageConverter);
                break;
            }
        }
    }
}
