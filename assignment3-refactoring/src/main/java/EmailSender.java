import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * This class represents an email sender that sends email to the requested email recepient. If the
 * recepient is not found, it throws a RecepientNotFoundException.
 */
public class EmailSender extends EmailVariableName {

	/**
	 * Constructs a new email sender.
	 */
	public EmailSender() {
	}

	/**
	 * Sends the email.
	 * @param persons the given list of persons (database)
	 * @param recepient the given email recepient name
	 * @throws RecepientNotFoundException when the recepient is not found in the database
	 */
	public void sendEmail(List<Person> persons, String recepient) throws RecepientNotFoundException {
		String emailRecepient = getRecepientEmail(persons, recepient);
		if (emailRecepient.equals("")) {
			// Throw exception when email recepient is not found
			throw new RecepientNotFoundException(recepient);
		}
		Properties props = new Properties();
		props.put("mail.smtp.host",EmailVariableName.SMTP_SERVER);
		props.put("mail.smtp.port", EmailVariableName.SMTP_PORT);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.socketFactory.port", EmailVariableName.SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(EmailVariableName.USERNAME,
								EmailVariableName.PASSWORD);
					}
				});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(EmailVariableName.USERNAME));
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(emailRecepient));
			message.setSubject(getEmailSubject(recepient));
			message.setText(getEmailText(recepient));

			Transport.send(message);
			System.out.println("message sent successfully...");
		} catch (MessagingException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the recepient's email address as String.
	 * @param persons the given list of persons
	 * @param recepient the given email recepient name
	 * @return the recepient's email address
	 */
	private String getRecepientEmail(List<Person> persons, String recepient) {
		String emailRecepient = "";
		for (Person person : persons) {
			String str = person.getFirstName() + " " + person.getLastName();
			if (str.equals(recepient)) {
				emailRecepient = person.getEmail();
			}
		}
		return emailRecepient;
	}

	/**
	 * Returns the email subject from the generated email message files as String.
	 * @param recepient the given email recepient name
	 * @return the email subject
	 * @throws IOException when the email message file is not found
	 */
	private String getEmailSubject(String recepient) throws IOException {
		Pattern pattern = Pattern.compile("(?<=Subject:\\s)(.*)");
		Matcher matcher = pattern.matcher(getFile(recepient));
		return matcher.group();
	}

	/**
	 * Returns the email text from the generated email message files as String.
	 * @param recepient the given email recepient name
	 * @return the email text
	 * @throws IOException when the email message file is not found
	 */
	private String getEmailText(String recepient) throws IOException {
		Pattern pattern = Pattern.compile("Dear.*([\\n|\\r].*)*");
		Matcher matcher = pattern.matcher(getFile(recepient));
		return matcher.group();
	}

	/**
	 * Returns the email message file as String.
	 * @param recepient the given email recepient name
	 * @return the email message
	 * @throws IOException when the email message file is not found
	 */
	private String getFile(String recepient) throws IOException {
		Path file = Paths.get(recepient + ".txt");
		Charset charset = StandardCharsets.UTF_8;
		return new String(Files.readAllBytes(file), charset);
	}
}
