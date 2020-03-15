package com.jayden.spring.scaffold.domain.common.mail;

public interface MailMessage {

    String getTo();

    String getSubject();

    String getBody();

    String getFrom();
}
