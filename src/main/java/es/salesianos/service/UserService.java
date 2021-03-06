package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.assembler.UserAssembler;
import es.salesianos.model.User;
import es.salesianos.repository.UserRepository;

public class UserService implements Service {

	UserAssembler assembler = new UserAssembler();
	private UserRepository repository = new UserRepository();

	public void createNewUserFromRequest(HttpServletRequest req) {
		User user = assembler.createUserFromRequest(req);

		if (!repository.search(user).isPresent()) {
			repository.insert(user);
		} else {
			repository.update(user);
		}
	}


}
