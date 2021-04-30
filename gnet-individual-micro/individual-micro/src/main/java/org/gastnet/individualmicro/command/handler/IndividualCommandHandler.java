package org.gastnet.individualmicro.command.handler;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.gastnet.individualmicro.entity.Individual;
import org.gastnet.individualmicro.service.IndividualService;
import org.gastnet.individualmicro.utils.SagaUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.gnet.common.command.CreateIndividualCommand;
import org.gnet.common.event.IndividualCreatedEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class IndividualCommandHandler {
	
	@Autowired
	private EventBus eventBus;

	@Autowired
	private IndividualService individualService;

	@CommandHandler
	protected void on(CreateIndividualCommand createIndividualCommand) {
		try {
			log.info("CreateIndividualCommand called");
			Individual individual = SagaUtils.convertToIndividualEntity(createIndividualCommand.individual);
			individual.setUserId(createIndividualCommand.userId);
			individualService.save(individual);
			eventBus.publish(GenericEventMessage.asEventMessage(new IndividualCreatedEvent(createIndividualCommand.userId)));
		} catch (Exception e) {
			log.error("Error at CreateIndividualCommand handler : " + e.getMessage());
		}
	}
		
}
