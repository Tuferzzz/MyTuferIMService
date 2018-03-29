package com.tufer.mylove.web.push;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.tufer.mylove.web.push.provider.AuthRequestFilter;
import com.tufer.mylove.web.push.provider.GsonProvider;
import com.tufer.mylove.web.push.service.AccountService;
import org.glassfish.jersey.server.ResourceConfig;

import java.util.logging.Logger;

/**
 * @Author:Tufer
 * @Date:Created in 2018/3/26 002612:44
 */
public class Application extends ResourceConfig {
    public Application(){
        // 注册逻辑处理的包名
        //packages("com.tufer.mylove.web.push");
        packages(AccountService.class.getPackage().getName());

        // 注册我们的全局请求拦截器
        register(AuthRequestFilter.class);

        // 注册Json解析器
        // register(JacksonJsonProvider.class);
        // 替换解析器为Gson
        register(GsonProvider.class);

        // 注册日志打印输出
        register(Logger.class);

    }
}
