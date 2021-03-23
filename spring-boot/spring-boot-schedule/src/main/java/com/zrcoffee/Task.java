package com.zrcoffee;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 计划任务组件
 *
 * @author Terry
 * @version 2021-03-22
 */
@Component
public class Task {

    private final Logger logger = LoggerFactory.getLogger(Task.class);

    /**
     * 测试任务
     * <p>
     * cron表达式：由6~7项组成，中间用空格分开。从左到右依次是：秒、分、时、日、月、周几、年（可省略）。
     * *：所有值都匹配
     * ?：无所谓，不关心，通常放在“周几”里
     * ,：或者
     * /：增量值
     * -：区间
     */
    @Scheduled(cron = "0/5 * * * * ?")
    public void test() {
        logger.info(Thread.currentThread().getName()+"===task run");
    }

}
