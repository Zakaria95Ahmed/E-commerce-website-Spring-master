package com.shopping.freshcart.Security.UserAccount.Model.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
public class HTTPResponse {
    //    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = "Europe/Berlin")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy hh:mm:ss", timezone = "Africa/Cairo")
    private Date timeStamp;
    private int httpStatusCode;
    /*
    Responses are grouped in five classes:
    1xx Informational
    2xx Success
    3xx Redirection
    4xx Client Error
    5xx Server Error
    */
    private HttpStatus httpStatus;// import From org.springframework.http.HttpStatus
    private String reason;
    private String message;


    public HTTPResponse(int httpStatusCode, HttpStatus httpStatus, String reason, String message) {
        this.timeStamp = new Date();
        this.httpStatusCode = httpStatusCode;
        this.httpStatus = httpStatus;
        this.reason = reason;
        this.message = message;
    }
}
