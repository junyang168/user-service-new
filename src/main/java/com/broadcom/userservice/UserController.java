package com.broadcom.userservice;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;


import java.util.Arrays;
import java.util.List;
import java.util.ArrayList; 


@RestController
public class UserController  {

    @Autowired
	private UserDAO userDAO;

	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/users")
	public ResponseEntity<List<User>> getusers  (
		@RequestParam(value = "name", required=false) String nameFilter,
		@RequestParam(value = "age", required=false) String ageFilter,
		@RequestParam(value = "sortBy", required=false) String sortBy,		
		@RequestParam(value = "sortOrder", required=false) String sortOrder		
		)  throws UserException {


		try {
			ArrayList<Filter> filters = new ArrayList<Filter>();
			if( nameFilter != null && nameFilter.trim().length() > 0) {
				filters.add( new Filter("name",nameFilter));
			}

			if( ageFilter != null && ageFilter.trim().length() > 0) {
				filters.add( new Filter("age",ageFilter));
			}

			Filter[] arr = new Filter[filters.size()];
			arr = filters.toArray(arr);
			List<User> users = userDAO.getUsers( arr , sortBy, sortOrder);
			return ResponseEntity.ok(users);
		}	
		catch ( UserException ex ) {
			throw ex;
		}
	}
}