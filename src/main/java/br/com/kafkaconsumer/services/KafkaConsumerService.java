package br.com.kafkaconsumer.services;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.kafkaconsumer.dtos.SlackMessage;
import br.com.kafkaconsumer.utils.SlackUtils;

@Service
public class KafkaConsumerService {
	
	private static final String TOPIC = "slack-messages";

	@KafkaListener(topics = TOPIC, groupId = "slack")
    public void consume(String message) throws IOException {
		sendSlack(message);
    }
	
	private void sendSlack(String message) {
		SlackMessage slackMessage = new SlackMessage(message);
		SlackUtils.sendMessage(slackMessage);
	}
}
