package com.bi.sendgrid;

import com.sendgrid.helpers.mail.Mail;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SendGridController {

    private final SendGridService sendGridService;

    @Operation(
            summary = "Send Email",
            description = "Send Email"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Email sent."),
            @ApiResponse(responseCode = "404", description = "Bad Request.")
    })
    @PostMapping(value="send/mail", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> sendMail(@RequestBody Mail mail) {
        this.sendGridService.sendMail(mail);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .build();
    }
}
