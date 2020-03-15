package com.jayden.spring.scaffold.domain.common.model;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static java.util.regex.Pattern.matches;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EmailAddress {

    @Column(name = "email")
    private String value;

    public EmailAddress(String value) {
        checkArgument(isNotEmpty(value), "address must be provided");
        checkArgument(checkAddress(value), "Invalid email address: " + value);
        this.value = value;
    }

    public static EmailAddress of(String value) {
        return new EmailAddress(value);
    }

    /**
     * 정규식으로 이메일 형식 체크
     *
     * @param address String 이메일 주소
     * @return boolean
     */
    private boolean checkAddress(String address) {
        return matches("[\\w~\\-.+]+@[\\w~\\-]+(\\.[\\w~\\-]+)+", address);
    }

    /**
     * 로컬 파트 반환
     *
     * @return String
     */
    public String getName() {
        String[] tokens = value.split("@");
        if (tokens.length == 2) {
            return tokens[0];
        }

        return null;
    }

    /**
     * 도메인 이름 반환
     *
     * @return String
     */
    public String getDomain() {
        String[] tokens = value.split("@");
        if (tokens.length == 2) {
            return tokens[1];
        }

        return null;
    }

    /**
     * 이메일 반환
     *
     * @return String
     */
    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailAddress emailAddress = (EmailAddress) o;
        return Objects.equals(value, emailAddress.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
            .append("address", value)
            .toString();
    }
}
