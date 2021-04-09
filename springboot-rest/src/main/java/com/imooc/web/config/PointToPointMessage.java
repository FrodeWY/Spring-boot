package com.imooc.web.config;

public class PointToPointMessage<T> {
    /**
     * 消息发送的目的地路径
     */
    private String destinationPath;
    /**
     * 消息内容
     */
    private T content;
    /**
     * 消息发送用户名称(websocket握手认证通过的用户name)
     */
    private String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
