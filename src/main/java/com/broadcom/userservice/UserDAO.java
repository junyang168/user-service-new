package com.broadcom.userservice;

import java.util.Arrays;
import java.util.List;

public interface UserDAO {
    List<User> getUsers(Filter[] filters, String sortBy, String sortOrder) throws UserException ;
}