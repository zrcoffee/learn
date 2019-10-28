package com.zrcoffee.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

/**
 * Ehcache事件日志监听器
 *
 * @author Terry
 * @version 2019-10-27
 */
public class EhcacheEventLoggerListener implements CacheEventListener<Object, Object> {

    private final Log logger = LogFactory.getLog(EhcacheEventLoggerListener.class);

    @Override
    public void onEvent(CacheEvent<?, ?> event) {
        logger.debug("Cache Event " + "{Event: " + event.getType() + ", Key: " + event.getKey() +
                ", OldValue: " + event.getOldValue() + ", NewValue: " + event.getNewValue() + "}");
    }

}
