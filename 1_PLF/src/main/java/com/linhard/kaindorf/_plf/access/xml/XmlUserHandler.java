/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linhard.kaindorf._plf.access.xml;

import com.linhard.kaindorf._plf.access.generic.UserHandler;
import com.linhard.kaindorf._plf.pojo.generic.User;
import com.linhard.kaindorf._plf.pojo.xml.XmlUser;
import com.linhard.kaindorf._plf.pojo.xml.XmlUserList;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import javax.xml.bind.JAXB;

/**
 *
 * @author martin
 */
public class XmlUserHandler implements UserHandler {

    @Override
    public List<User> getUsers(String f) {
        f += ".xml";
        XmlUserList list = JAXB.unmarshal(new File(f), XmlUserList.class);
        return list.getUsers().stream().map(XmlUser::toGenericUser).collect(Collectors.toList());
    }

    @Override
    public void writeUsers(String f, List<User> users) {
        f += ".xml";
        List<XmlUser> xmlUsers = users.stream().map(User::intoXmlUser).collect(Collectors.toList());
        JAXB.marshal(new XmlUserList(xmlUsers), new File(f));
    }
}
