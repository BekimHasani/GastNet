package org.gastnet.clientmicro.service;

import javax.servlet.http.HttpServletRequest;

import org.gastnet.clientmicro.dto.BusinessProfileDTO;

public interface BusinessService {

	BusinessProfileDTO getBusinessProfileData(long businessId,HttpServletRequest request);
}
