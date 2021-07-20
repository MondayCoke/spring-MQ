package com.study.pulsar;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.SubscriptionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class PulsarConsumer {
    private static final Logger log = LoggerFactory.getLogger(PulsarConsumer.class);
    private static final String SERVER_URL = "pulsar://192.168.18.22:6650";

    public static void main(String[] args) throws Exception {
        // 构造Pulsar Client
        PulsarClient client = PulsarClient.builder()
                .serviceUrl(SERVER_URL)
                .enableTcpNoDelay(true)
                .build();
        Consumer consumer = client.newConsumer()
                .consumerName("my-consumer")
                .topic("persistent://public/default/my-topic")
                .subscriptionName("my-subscription")
                .ackTimeout(10, TimeUnit.SECONDS)
                .maxTotalReceiverQueueSizeAcrossPartitions(10)
                .subscriptionType(SubscriptionType.Exclusive)
                .subscribe();
        do {
            // 接收消息有两种方式：异步和同步
            // CompletableFuture<Message<String>> message = consumer.receiveAsync();
            Message message = consumer.receive();
            log.info("get message from pulsar cluster,{}", message);
        } while (true);
    }
}