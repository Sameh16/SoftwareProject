package com.GameForAll.RestCotrollers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.GameForAll.models.User;

public class UserRestController {

	@RequestMapping(method = RequestMethod.POST, value = "/adduser")
	public boolean verification(@RequestBody User user) {
		/*
		 * if(t.teachers.contains(user)) { return false; } else { return true; }
		 */
		return true;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/adduser")
	public boolean SignUp(@RequestBody User user) {
		/*
		 * if(verification(user)==false) { return false; }
		 * 
		 * else { return user.AddUser(user); }
		 */
		return true;
	}

	@RequestMapping(method = RequestMethod.POST, value = "/signin")
	public boolean SignIn(@RequestBody User user) {
		/*
		 * if(t.SearchUser(user)==false) { return false; } else { return true; }
		 */
		return true;
	}

}
