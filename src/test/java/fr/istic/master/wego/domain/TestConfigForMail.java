package fr.istic.master.wego.domain;

import javax.mail.internet.MimeMessage;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailException;
import org.springframework.mail.MailPreparationException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class TestConfigForMail {

	@Bean
	public JavaMailSender mailSender() {
		final JavaMailSenderImpl sender = new MockMailSender();
		return sender;
	}

	private class MockMailSender extends JavaMailSenderImpl {
		@Override
		public void send(final MimeMessagePreparator mimeMessagePreparator) throws MailException {
			final MimeMessage mimeMessage = createMimeMessage();
			try {
				mimeMessagePreparator.prepare(mimeMessage);
				final String content = (String) mimeMessage.getContent();
				System.out.println("mail: " + content);
			} catch (final Exception e) {
				throw new MailPreparationException(e);
			}
		}
	}
}