package org.gastnet.clientmicro.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class HttpException extends RuntimeException {

	private static final long serialVersionUID = 7591673785243473020L;

	@Getter
	private LocalDateTime timestamp;
	@Getter
	private HttpStatus status;
	@Getter
	private String message;

}
