package com.techrocking.payment.kafka.channel;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.techrocking.payment.kafka.channel.PaymentChannel;

@EnableBinding(PaymentChannel.class)
public class StreamsConfig {

}
