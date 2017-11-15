package es.salesianos.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import connection.ConnectionManager;
import es.salesianos.assembler.UserAssembler;
import es.salesianos.model.User;

public class UserService implements Service {

	UserAssembler assembler = new UserAssembler();
	@Autowired
	private ConnectionManager manager;

	public void createNewUserFromRequest(HttpServletRequest req) {
		User user = assembler.createUserFromRequest(req);

		if (!getManager().search(user).isPresent()) {
			getManager().insert(user);
		} else {
			getManager().update(user);
		}
	}

	public ConnectionManager getManager() {
		return manager;
	}

	public void setManager(ConnectionManager manager) {
		this.manager = manager;
	}

}
