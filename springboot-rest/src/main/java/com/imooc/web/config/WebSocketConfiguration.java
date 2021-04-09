package com.imooc.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.StompWebSocketEndpointRegistration;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.util.List;

@Configuration
@EnableConfigurationProperties(MessageBrokerConfigurationProperties.class)
@EnableWebSocketMessageBroker
@ConditionalOnProperty(value = "drp-websocket.endpointPaths")
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    @Autowired(required = false)
    private List<HandshakeInterceptor> handshakeInterceptorList;

    @Autowired(required = false)
    private HandshakeHandler handshakeHandler;

    @Autowired
    private MessageBrokerConfigurationProperties drpMessageBrokerConfigurationProperties;

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker(
                drpMessageBrokerConfigurationProperties.getDestinationPrefixes().toArray(new String[0])
        );
        //设置客户端接收点对点消息地址的前缀（可不设置）
        if (StringUtils.hasText(drpMessageBrokerConfigurationProperties.getUserDestinationPrefix())) {
            registry.setUserDestinationPrefix(drpMessageBrokerConfigurationProperties.getUserDestinationPrefix());
        }
        if (StringUtils.hasText(drpMessageBrokerConfigurationProperties.getApplicationDestinationPrefixes())) {
            //设置客户端向服务器发送消息的地址前缀（可不设置）
            registry.setApplicationDestinationPrefixes(drpMessageBrokerConfigurationProperties.getApplicationDestinationPrefixes());
        }
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        StompWebSocketEndpointRegistration stompWebSocketEndpointRegistration = registry
                .addEndpoint(drpMessageBrokerConfigurationProperties.getEndpointPaths().toArray(new String[0])).setAllowedOrigins("*");
        if (!CollectionUtils.isEmpty(handshakeInterceptorList)) {
            stompWebSocketEndpointRegistration.addInterceptors(handshakeInterceptorList.toArray(new HandshakeInterceptor[0]));
        }
        if (handshakeHandler != null) {
            stompWebSocketEndpointRegistration.setHandshakeHandler(handshakeHandler);
        }
        stompWebSocketEndpointRegistration.withSockJS();
    }


    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
