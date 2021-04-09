package com.imooc.web.config;

public class BroadcastMessage<T> {
    /**
     * 消息发送的目的地路径
     */
    private String destinationPath;
    /**
     * 消息内容
     */
    private T content;

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
