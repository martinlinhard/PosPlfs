/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linhard.kaindorf._plf.access.generic;

import java.io.File;
import java.util.List;
import com.linhard.kaindorf._plf.pojo.generic.User;

/**
 *
 * @author martin
 */
public interface UserHandler {
    public List<User> getUsers(String f);
    public void writeUsers(String f, List<User> users);
}
