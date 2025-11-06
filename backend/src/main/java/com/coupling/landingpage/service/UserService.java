package com.coupling.landingpage.service;

import com.coupling.landingpage.model.User;
import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
}
