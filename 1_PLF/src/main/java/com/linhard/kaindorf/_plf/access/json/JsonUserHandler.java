/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linhard.kaindorf._plf.access.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.linhard.kaindorf._plf.access.generic.UserHandler;
import com.linhard.kaindorf._plf.pojo.generic.User;
import com.linhard.kaindorf._plf.pojo.json.JsonUser;
import com.linhard.kaindorf._plf.pojo.xml.XmlUser;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author martin
 */
public class JsonUserHandler implements UserHandler {

    @Override
    public List<User> getUsers(String f) {
        try {
            f += ".json";

            ObjectReader r = new ObjectMapper().readerFor(new TypeReference<List<JsonUser>>() {
            });

            List<JsonUser> users = r.readValue(new File(f));

            return users.stream().map(JsonUser::toGenericUser).collect(Collectors.toList());
        } catch (IOException ex) {
            System.out.println("got exception: " + ex.toString());
            return null;
        }
    }

    @Override
    public void writeUsers(String f, List<User> users) {
        try {
            f += ".json";
            ObjectMapper m = new ObjectMapper();
            List<JsonUser> jsonUsers = users.stream().map(User::intoJsonUser).collect(Collectors.toList());
            m.writeValue(new File(f), jsonUsers);
        } catch (IOException ex) {
            Logger.getLogger(JsonUserHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
