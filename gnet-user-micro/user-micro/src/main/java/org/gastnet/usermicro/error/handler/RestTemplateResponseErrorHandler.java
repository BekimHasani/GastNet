package org.gastnet.usermicro.error.handler;

import java.io.IOException;
import java.time.LocalDateTime;

import org.gastnet.usermicro.exception.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatus.Series;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class RestTemplateResponseErrorHandler implements ResponseErrorHandler{

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		return response.getStatusCode().series() == Series.CLIENT_ERROR
				|| response.getStatusCode().series() == Series.SERVER_ERROR;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		HttpStatus status = response.getStatusCode();
		if(status.series() == Series.CLIENT_ERROR) {
			if(!status.equals(HttpStatus.BAD_REQUEST)) {
				throw new HttpException(LocalDateTime.now(),status,"Client returned unhandled status: " + status.toString());
			}
		}else if(status.series() == Series.SERVER_ERROR) {
			throw new HttpException(LocalDateTime.now(),status,"Server returned unhandled status: " + status.toString());
		}
		
	}

}
