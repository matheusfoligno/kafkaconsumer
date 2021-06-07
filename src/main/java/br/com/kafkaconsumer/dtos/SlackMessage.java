package br.com.kafkaconsumer.dtos;

import java.io.Serializable;

public class SlackMessage implements Serializable {

	private static final long serialVersionUID = 8500768262598679382L;

	private String text;

	public SlackMessage(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
