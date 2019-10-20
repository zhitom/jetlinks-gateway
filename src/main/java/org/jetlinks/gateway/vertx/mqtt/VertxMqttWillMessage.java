package org.jetlinks.gateway.vertx.mqtt;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.vertx.mqtt.MqttWill;
import io.vertx.mqtt.messages.MqttPublishMessage;
import lombok.AllArgsConstructor;
import org.jetlinks.core.message.codec.MqttMessage;

import javax.annotation.Nonnull;

@AllArgsConstructor
public class VertxMqttWillMessage implements MqttMessage {

    private String deviceId;

    private MqttWill will;

    @Override
    public int getMessageId() {
        return -1;
    }

    @Nonnull
    @Override
    public String getTopic() {
        return will.getWillTopic();
    }

    @Override
    public int getQosLevel() {
        return will.getWillQos();
    }

    @Override
    public boolean isDup() {
        return false;
    }

    @Override
    public boolean isRetain() {
        return false;
    }

    @Override
    public boolean isWill() {
        return true;
    }

    @Nonnull
    @Override
    public ByteBuf getPayload() {
        return Unpooled.copiedBuffer(will.getWillMessageBytes());
    }

    @Nonnull
    @Override
    public String getDeviceId() {
        return deviceId;
    }
}
