package org.gastnet.clientmicro.util;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.gastnet.clientmicro.enumeration.URL;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;

public class RequestUtils {
	
	private RequestUtils() {}

	public static <T> RequestEntity<T>  getAuthorizedPostRequest(HttpServletRequest request,T t,URI uri) throws NullPointerException {
		HttpSession session = request.getSession();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization",session.getAttribute("token").toString());
		RequestEntity<T>  requestEntity = RequestEntity.post(uri)
				.accept(MediaType.APPLICATION_JSON)
				.headers(headers)
				.body(t);
		
		return requestEntity;
	}
	
	public static RequestEntity<?> getAuthorizedGetRequest(HttpServletRequest request, URI uri) throws NullPointerException {
		HttpSession session = request.getSession();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization","Bearer "+session.getAttribute("token").toString());
		RequestEntity<?> requestEntity = RequestEntity.get(uri)
				.headers(headers)
				.build();
		
		return requestEntity;
	}
	
	public static <T> RequestEntity<T>  getAuthorizedPutRequest(HttpServletRequest request,T t,URI uri) throws NullPointerException {
		HttpSession session = request.getSession();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization",session.getAttribute("token").toString());
		RequestEntity<T>  requestEntity = RequestEntity.put(uri)
				.accept(MediaType.APPLICATION_JSON)
				.headers(headers)
				.body(t);
		
		return requestEntity;
	}
	
	public static URI getURI(URL url,String endpointSuffix) {
		return URI.create(url.getValue() + endpointSuffix);
	}
	
	public static <T> RequestEntity<T> getRequestEntity(T t, URL url,String endpointSuffix){
		return RequestEntity.post(getURI(url, endpointSuffix))
							.accept(MediaType.APPLICATION_JSON).body(t);
	}

}