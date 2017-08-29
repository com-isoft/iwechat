package com.isoft.iwechat.corporation.message.transmission;

public interface CorpMessenger {
    /**
     * 发送消息
     * @param msg 消息
     * @param <T>
     */
    <T extends AbstractTransmissionMessage> void send(T msg);
}
