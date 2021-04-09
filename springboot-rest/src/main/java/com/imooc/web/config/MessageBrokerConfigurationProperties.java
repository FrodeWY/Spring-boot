package com.imooc.web.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@ConfigurationProperties(prefix = "drp-websocket")
public class MessageBrokerConfigurationProperties {
    /**
     * 设置客户端接收消息地址的前缀
     */
    @Value("${destinationPrefixes:top,queue}")
    private List<String> destinationPrefixes;
    /**
     * 设置客户端接收点对点消息地址的前缀
     */
    private String userDestinationPrefix;
    /**
     * 设置客户端向服务器发送消息的地址前缀
     */
    private String applicationDestinationPrefixes;
    /**
     * 开启的endpoint 路径
     */
    private List<String>endpointPaths;

    public List<String> getEndpointPaths() {
        return endpointPaths;
    }

    public void setEndpointPaths(List<String> endpointPaths) {
        this.endpointPaths = endpointPaths;
    }

    public List<String> getDestinationPrefixes() {
        return destinationPrefixes;
    }

    public void setDestinationPrefixes(List<String> destinationPrefixes) {
        this.destinationPrefixes = destinationPrefixes;
    }

    public String getUserDestinationPrefix() {
        return userDestinationPrefix;
    }

    public void setUserDestinationPrefix(String userDestinationPrefix) {
        this.userDestinationPrefix = userDestinationPrefix;
    }

    public String getApplicationDestinationPrefixes() {
        return applicationDestinationPrefixes;
    }

    public void setApplicationDestinationPrefixes(String applicationDestinationPrefixes) {
        this.applicationDestinationPrefixes = applicationDestinationPrefixes;
    }
}

