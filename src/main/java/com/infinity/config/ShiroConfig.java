package com.infinity.config;

import org.springframework.context.annotation.Bean;

public class ShiroConfig {

//    @Bean
//    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
//        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();
//        // 由于demo1展示统一使用注解做访问控制，所以这里配置所有请求路径都可以匿名访问
//        chain.addPathDefinition("/**", "anon"); // all paths are managed via annotations
//
//        // 这另一种配置方式。但是还是用上面那种吧，容易理解一点。
//        // or allow basic authentication, but NOT require it.
//        // chainDefinition.addPathDefinition("/**", "authcBasic[permissive]");
//        return chain;
//    }
}
