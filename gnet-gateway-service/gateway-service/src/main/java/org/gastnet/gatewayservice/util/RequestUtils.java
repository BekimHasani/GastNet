package org.gastnet.gatewayservice.util;

import java.net.URI;

import org.gastnet.gatewayservice.enumeration.URL;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;

public class RequestUtils {
	
	private RequestUtils() {}
	
	public static URI getURI(URL url,String endpointSuffix) {
		return URI.create(url.getValue() + endpointSuffix);
	}
	
	public static <T> RequestEntity<T> getRequestEntity(T t, URL url,String endpointSuffix){
		return RequestEntity.post(getURI(url, endpointSuffix))
							.accept(MediaType.APPLICATION_JSON).body(t);
	}

}