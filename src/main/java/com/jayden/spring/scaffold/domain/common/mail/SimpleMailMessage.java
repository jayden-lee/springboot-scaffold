package com.jayden.spring.scaffold.domain.common.mail;

import lombok.Getter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Objects;

@Getter
public class SimpleMailMessage implements MailMessage {

    private String to;
    private String subject;
    private String body;
    private String from;

    public SimpleMailMessage(String to, String subject, String body, String from) {
        this.to = to;
        this.subject = subject;
        this.body = body;
        this.from = from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleMailMessage)) return false;
        SimpleMailMessage that = (SimpleMailMessage) o;
        return Objects.equals(to, that.to) &&
                Objects.equals(subject, that.subject) &&
                Objects.equals(body, that.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(to, subject, body);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("to", to)
                .append("subject", subject)
                .append("body", body)
                .toString();
    }
}