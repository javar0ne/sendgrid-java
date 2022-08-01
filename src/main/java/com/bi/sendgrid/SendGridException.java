package com.bi.sendgrid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SendGridException extends RuntimeException {

    public SendGridException(String message) {
        super(message);
    }

    public SendGridException(Throwable cause) {
        super(cause);
    }

}
