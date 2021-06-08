package br.com.kafkaconsumer.services;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import br.com.kafkaconsumer.utils.SlackUtils;

@Service
public class KafkaConsumerService {

	private static final String TOPIC = "slack";

	@KafkaListener(topics = TOPIC, groupId = "slack")
	public void consume(String message) throws IOException {
		JSONObject jsonObject = new JSONObject(message);

		StringBuilder sb = new StringBuilder();
		sb.append("*Data: " + jsonObject.getString("Data") + " / Erro status: " + jsonObject.getString("Erro_status") + "*\n");
		sb.append("Sistema: " + jsonObject.getString("Sistema") + "\n");
		sb.append("Usuário: " + jsonObject.getString("Usuario") + "\n");
		sb.append("Mensagem: " + jsonObject.getString("Mensagem") + "\n");
		sb.append("StackTrace: " + jsonObject.getString("StackTrace") + "\n");

		sendSlack(sb.toString(), jsonObject.getString("Sistema").equals("DataHub") ? false : true);
	}

	private void sendSlack(String message, boolean isSlackTest) {
		SlackUtils.sendMessage(message, isSlackTest);
	}

}
