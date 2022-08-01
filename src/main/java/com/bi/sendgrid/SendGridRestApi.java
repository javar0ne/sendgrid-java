package com.bi.sendgrid;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpMethod;

@AllArgsConstructor
@Getter
public enum SendGridRestApi {

    SendMail("mail/send", HttpMethod.POST);

    private String methodName;
    private HttpMethod httpMethod;

}
