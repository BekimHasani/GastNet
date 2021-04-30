package org.gastnet.clientmicro.model;

import java.util.Map;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ValidationErrors {
	
	private Map<String,String> errors;

}
