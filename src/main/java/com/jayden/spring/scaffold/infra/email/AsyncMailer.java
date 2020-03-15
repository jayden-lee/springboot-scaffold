package com.jayden.spring.scaffold.infra.email;

import com.jayden.spring.scaffold.domain.common.mail.MailMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Slf4j
@Component
@RequiredArgsConstructor
public class AsyncMailer {

    private final JavaMailSender mailSender;

    @Async
    public void send(MailMessage mailMessage) {
        Assert.notNull(mailMessage, "Parameter `mailMessage` must not be null");

        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            if (StringUtils.isNotBlank(mailMessage.getFrom())) {
                simpleMailMessage.setFrom(mailMessage.getFrom());
            }

            if (StringUtils.isNotBlank(mailMessage.getSubject())) {
                simpleMailMessage.setSubject(mailMessage.getSubject());
            }

            if (StringUtils.isNotEmpty(mailMessage.getBody())) {
                simpleMailMessage.setText(mailMessage.getBody());
            }

            if (mailMessage.getTo() != null) {
                simpleMailMessage.setTo(mailMessage.getTo());
            }

            mailSender.send(simpleMailMessage);
        } catch (MailException e) {
            log.error("Failed to send mail mailMessage", e);
        }
    }
}