package com.jayden.spring.scaffold.domain.user.exception;

import com.jayden.spring.scaffold.domain.common.model.EmailAddress;
import com.jayden.spring.scaffold.global.error.ErrorCode;
import com.jayden.spring.scaffold.global.error.exception.InvalidValueException;

public class EmailDuplicateException extends InvalidValueException {

    public EmailDuplicateException(final EmailAddress emailAddress) {
        super(emailAddress.getValue(), ErrorCode.EMAIL_DUPLICATION);
    }
}
