package com.forum.messages.controllers;

import java.util.Optional;
import java.util.Properties;
import java.util.UUID;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forum.messages.dao.TokenRepository;
import com.forum.messages.dao.UserRepository;
import com.forum.messages.entities.Token;
import com.forum.messages.entities.User;


@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*")
public class RegisterController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private TokenRepository tokenRepository;
	
	@PutMapping("/newUser")
	public void newUser(@RequestBody User user) {
		userRepository.save(user);
		sendMail(user);
	}
	
	@GetMapping("/enable/{alphanumeric}")
	public String enableAccount(@PathVariable String alphanumeric) {
		Token token = tokenRepository.findByAlphaNumeric(alphanumeric);
		Optional<User> result=userRepository.findById(token.getUser().getUsername());
		User user = null;
		if (result.isPresent()) {
			user = result.get();
		} else {
			throw new RuntimeException("No user with this id");
		}
		user.setEnabled(1);
		userRepository.save(user);
		return "Your account is now activated";
	}
	
	
	
	public void sendMail(User user) {
        try {
            String alphanumeric = UUID.randomUUID().toString();
            Token token = new Token(alphanumeric, user);
            tokenRepository.save(token);
            String fromEmail = ""; // your mail here
            String username = ""; // your username here
            String password = ""; // your password
            String subject = "Account verification!";
            String toEmail = user.getEmail();
            String temp = "http://localhost:8080/register/enable/" + alphanumeric;
            String message = "Enable your account through this link <a href=" + temp + ">Click here</a>";
            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.fallback", "false");
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(true);
            Message mailmessage = new MimeMessage(mailSession);
            mailmessage.setFrom(new InternetAddress(fromEmail));
            mailmessage.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mailmessage.setSubject(subject);
            mailmessage.setContent(message, "text/html");
            Transport transport = mailSession.getTransport("smtp");
            transport.connect("smtp.gmail.com", username, password);
            transport.sendMessage(mailmessage, mailmessage.getAllRecipients());
        } catch (Exception ex) {
        }
    }

}
