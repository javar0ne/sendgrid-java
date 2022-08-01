package com.bi.sendgrid;

import com.sendgrid.helpers.mail.Mail;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
@Slf4j
public class SendGridServiceImpl implements SendGridService {

    private final WebClient webClient;

    @Override
    public void sendMail(Mail mail) {
        SendGridRestApi sendMail = SendGridRestApi.SendMail;

        log.info("trying to send email(s)...", mail.getSubject());

        this.webClient
                .method(sendMail.getHttpMethod())
                .uri(sendMail.getMethodName())
                .body(Mono.just(mail), Mail.class)
                .retrieve()
                .onStatus(
                        status -> status.is2xxSuccessful(),
                        response -> {
                            log.info("email(s) sent with success!");

                            return Mono.empty();
                        }
                )
                .onStatus(
                        status -> status.isError(),
                        response -> {
                            log.error("email(s) not sent!");

                            return response.bodyToMono(String.class)
                                .map(SendGridException::new);
                        }
                )
                .toBodilessEntity()
                .block();
    }

}
