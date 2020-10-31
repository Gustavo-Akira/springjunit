package br.com.gustavoakira.reunion.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ErrorDetails {
    private Date time;
    private String message;
    private String details;
}
