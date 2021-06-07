package br.com.kafkaconsumer.utils;

import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class SlackUtils {

	private static final String URL = "aHR0cHM6Ly9zbGFjay5jb20vYXBpL2NoYXQucG9zdE1lc3NhZ2U=";
	private static final String TOKEN = "eG94Yi0yMTQ0ODI1OTQxNTI0LTIxNjI0ODI4MDE1MzYtdDZCa3dmOWt6Y3laT0daZ24xU3I1V2RF";
	private static final String CHANNEL_SLACK = "QzAyM1ZTMk02Qkc=";
	private static final String CHANNEL_SLACK_TEST = "QzAyM1ZSWEROQ0U=";

	public static void sendMessage(String message, boolean isSlackTest) {
		RestTemplate template = new RestTemplate();

		HttpHeaders headers = createHeaders();
		UriComponentsBuilder builder = UriComponentsBuilder
				.fromHttpUrl(new String(Base64.decodeBase64(URL.getBytes())));
		HashMap<String, String> body = setBody(message, isSlackTest);
		HttpEntity<?> entity = new HttpEntity<>(body, headers);

		template.exchange(builder.toUriString(), HttpMethod.POST, entity, Void.class);
	}

	private static HashMap<String, String> setBody(String message, boolean isSlackTest) {
		HashMap<String, String> body = new HashMap<>();
		body.put("channel", new String(
				Base64.decodeBase64(isSlackTest ? CHANNEL_SLACK_TEST.getBytes() : CHANNEL_SLACK.getBytes())));
		body.put("text", message);
		return body;
	}

	private static HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();

		String token = new String(Base64.decodeBase64(TOKEN.getBytes()));

		headers.add("Authorization", "Bearer " + token);
		headers.add("Accept", "*/*");
		headers.add("Content-type", "application/json");
		return headers;
	}
}
