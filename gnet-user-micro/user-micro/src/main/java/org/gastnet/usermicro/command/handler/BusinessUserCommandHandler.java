package org.gastnet.usermicro.command.handler;

import java.util.Date;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventhandling.GenericEventMessage;
import org.gastnet.usermicro.command.CreateUserForBusinessCommand;
import org.gastnet.usermicro.command.FinishBusinessUserCreationCommand;
import org.gastnet.usermicro.command.InitializeBusinessUserSagaCommand;
import org.gastnet.usermicro.entity.User;
import org.gastnet.usermicro.enumeration.Role;
import org.gastnet.usermicro.enumeration.UserState;
import org.gastnet.usermicro.event.BusinessUserFinishedUser;
import org.gastnet.usermicro.event.CreateUserForBusinessEvent;
import org.gastnet.usermicro.event.UserForBusinessCreatedEvent;
import org.gastnet.usermicro.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class BusinessUserCommandHandler {

	@Autowired
	private EventBus eventBus;

	@Autowired
	private UserService userService;

	@CommandHandler
	protected void handle(InitializeBusinessUserSagaCommand initializeSagaCommand) {
		eventBus.publish(GenericEventMessage.asEventMessage(new CreateUserForBusinessEvent(
				initializeSagaCommand.businessSagaId, initializeSagaCommand.businessUserDTO)));
	}

	@CommandHandler
	protected void handle(CreateUserForBusinessCommand createUserCommand) {
		try {
			log.info("Handling CreateUserCommand");
			User user = createUserCommand.businessUserDTO.getUser();
			user.setCreationDate(new Date());
			user.setGoogleUser(false);
			user.setStatus(true);
			user.setUserState(UserState.PENDING);
			user.setRole(Role.BUSINESS);
			User persistedUser = userService.save(user);
			createUserCommand.businessUserDTO.setUser(persistedUser);
			log.info("User " + persistedUser + "Created \n Triggering UserCreatedEvent");
			eventBus.publish(GenericEventMessage.asEventMessage(new UserForBusinessCreatedEvent(createUserCommand.businessSagaId, createUserCommand.businessUserDTO)));
		} catch (Exception e) {
			log.error("Exception on CreateUserCommand handler :" + e.getMessage());
		}
	}
	
	@CommandHandler
	protected void handle(FinishBusinessUserCreationCommand finishUserCreationCommand) {
		try {
			log.info("Handling FinishBusinessUserCreationCommand");
			User user = userService.findById(finishUserCreationCommand.userId);
			user.setUserState(UserState.CREATED);
			userService.save(user);
//			EmailSender.builder().withFrom("")
//					.withTo(user.getEmail()).withContext("")
//					.withSubject("User Created Succesfully")
//					.build().send();
			log.info("User " + user + "Created \n Triggering UserFinishedEvent");
			eventBus.publish(GenericEventMessage.asEventMessage(new BusinessUserFinishedUser(user.getEmail(),user.getUserId())));
		} catch (Exception e) {
			log.error("Exception on FinishBusinessUserCreationCommand handler :" + e.getMessage());
		}
		
	}

}
