package br.com.Spring_Boot_04.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String message, String details) {}
