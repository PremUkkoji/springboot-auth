package com.premukkoji.user.service;

import com.premukkoji.user.domain.Role;
import com.premukkoji.user.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();
}
