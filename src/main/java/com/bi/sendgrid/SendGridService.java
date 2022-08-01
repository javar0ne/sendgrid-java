package com.bi.sendgrid;

import com.sendgrid.helpers.mail.Mail;
import org.springframework.stereotype.Service;

public interface SendGridService {
    public void sendMail(Mail mail);
}
