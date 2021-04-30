package org.gastnet.usermicro.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailSender {
	
	private SimpleMailMessage message;

	@Autowired
	private JavaMailSender javaEmailSender;

	private EmailSender(Builder builder) {
		this.message = builder.message;
	}

	public void send() {
		javaEmailSender.send(message);
	}
	
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private SimpleMailMessage message;
		
		public Builder() {};

		public Builder withTo(String to) {
			message.setTo(to);
			return this;
		}

		public Builder withFrom(String from) {
			message.setFrom(from);
			return this;
		}

		public Builder withSubject(String subject) {
			message.setSubject(subject);
			return this;
		}

		public Builder withContext(String context) {
			message.setText(context);
			return this;
		}

		public EmailSender build() {
			return new EmailSender(this);
		}
	}
}
