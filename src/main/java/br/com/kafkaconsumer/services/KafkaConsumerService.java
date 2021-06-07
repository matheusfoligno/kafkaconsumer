package br.com.kafkaconsumer.services;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.kafkaconsumer.utils.SlackUtils;

@Service
public class KafkaConsumerService {

	private static final String TOPIC = "slack";
	private static final String TOPIC_TESTE = "slack_test";

	@KafkaListener(topics = TOPIC, groupId = "slack")
	public void consume(String message) throws IOException {
		sendSlack(message, false);
	}

	@KafkaListener(topics = TOPIC_TESTE, groupId = "slack_test")
	public void consumeOtherTopic(String message) throws IOException {
		sendSlack("Teste de mensagem outro topico logstash", true);
	}

	private void sendSlack(String message, boolean isSlackTest) {
		SlackUtils.sendMessage(message, isSlackTest);
	}

}
