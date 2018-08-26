package com.snax.vxvw.vxvwcore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义线程池执行异步 配置
 */
@Configuration
@EnableAsync
public class AsyncConfig {

    @Autowired
    private TaskThreadPoolConfig config;

    @Bean
    public Executor taskExecutor(){
        ThreadPoolTaskExecutor scheduler=new ThreadPoolTaskExecutor();
        scheduler.setCorePoolSize(config.getCorePoolSize());
        scheduler.setMaxPoolSize(config.getMaxPoolSize());
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        scheduler.setKeepAliveSeconds(config.getKeepAliveSeconds());
        scheduler.setQueueCapacity(config.getQueueCapacity());
        scheduler.setThreadNamePrefix("vxvw-task-");
        /**
         * rejected-policy:当pool已经到达max size的时候，如何处理新的任务
         * CALLER——RUNS：不再新线程中执行任务，而是由调用者所在的线程来执行
         */
        scheduler.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        scheduler.initialize();
        return scheduler;
    }
}
