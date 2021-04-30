package org.gastnet.businessmicro.command.handler;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.gastnet.businessmicro.entity.Business;
import org.gastnet.businessmicro.service.BusinessService;
import org.gastnet.businessmicro.service.ContactService;
import org.gastnet.businessmicro.service.LocationService;
import org.gastnet.businessmicro.utils.SagaUtils;
import org.gnet.common.command.CreateBusinessUserCommand;
import org.gnet.common.event.BusinessCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BusinessCommandHandler {

	@Autowired
	private EventBus eventBus;

	@Autowired
	private BusinessService businessService; 
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private LocationService locationService;
	
	@CommandHandler
	protected void on(CreateBusinessUserCommand createBusinessCommand) {
		try {
			log.info("BusinessCommandHandler called");
			Business business = SagaUtils.convertToBusinessEntity(createBusinessCommand.business);
			business.setUserId(createBusinessCommand.userId);
			final Business insertedBusiness = businessService.save(business);
			insertedBusiness.getContacts().stream().forEach(contact->{
				contact.setBusiness(insertedBusiness);
				contactService.save(contact);
			});
			insertedBusiness.getLocations().stream().forEach(location->{
				location.setBusiness(insertedBusiness);
				locationService.save(location);
			});
			eventBus.publish(GenericEventMessage.asEventMessage(new BusinessCreatedEvent(createBusinessCommand.userId)));
		} catch (Exception e) {
			log.error("Error at BusinessCommandHandler handler : " + e.getMessage());
		}
	}
	
}
