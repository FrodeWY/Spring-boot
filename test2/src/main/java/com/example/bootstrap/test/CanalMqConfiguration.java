package com.example.bootstrap.test;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Copyright 2008-2020 OPPO Mobile Comm Corp., Ltd, All rights reserved.
 *
 * @author 80320931
 * @version 1.0
 * @description: TODO
 * @date 2021/5/17 15:12
 */
@Configuration
@ConfigurationProperties(prefix = "canal")
public class CanalMqConfiguration {

    /**
     * mq 类型 rocketmq,kafka
     *
     */
    @Value("${type:rocketmq}")
    private String mqType;
    /**
     * 失败重试次数
     */
    @Value("${retryTimes:6}")
    private Integer retryTimes;
    /**
     * 发送超时 毫秒
     */
    @Value("${sendMsgTimeout:3000}")
    private Integer sendMsgTimeout;

    @Value("${maxMessageSize:10485760}")
    private Integer maxMessageSize;
//    @Value("${subscribe}")
//    private List<CanalSubscribeEntry> canalSubscribeList;
//    @Value("${produce.topic}")
//    private String produceTopic;

//    public List<CanalSubscribeEntry> getCanalSubscribeList() {
//        return canalSubscribeList;
//    }
//
//    public void setCanalSubscribeList(List<CanalSubscribeEntry> canalSubscribeList) {
//        this.canalSubscribeList = canalSubscribeList;
//    }

    public String getMqType() {
        return mqType;
    }

    public void setMqType(String mqType) {
        this.mqType = mqType;
    }

    public class CanalSubscribeEntry {
        /**
         * 订阅的database
         */
        private String database;
        /**
         * 订阅的表名
         */
        private String table;


        public String getDatabase() {
            return database;
        }

        public void setDatabase(String database) {
            this.database = database;
        }

        public String getTable() {
            return table;
        }

        public void setTable(String table) {
            this.table = table;
        }

        @Override
        public String toString() {
            return "CanalSubscribeEntry{" +
                    "database='" + database + '\'' +
                    ", table='" + table + '\'' +
                    '}';
        }
    }

    public Integer getSendMsgTimeout() {
        return sendMsgTimeout;
    }

    public void setSendMsgTimeout(Integer sendMsgTimeout) {
        this.sendMsgTimeout = sendMsgTimeout;
    }

    public Integer getMaxMessageSize() {
        return maxMessageSize;
    }

    public void setMaxMessageSize(Integer maxMessageSize) {
        this.maxMessageSize = maxMessageSize;
    }

    public Integer getRetryTimes() {
        return retryTimes;
    }

    public void setRetryTimes(Integer retryTimes) {
        this.retryTimes = retryTimes;
    }
//
//    public String getProduceTopic() {
//        return produceTopic;
//    }
//
//    public void setProduceTopic(String produceTopic) {
//        this.produceTopic = produceTopic;
//    }


}
