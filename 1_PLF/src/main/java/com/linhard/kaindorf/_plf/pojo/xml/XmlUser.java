/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linhard.kaindorf._plf.pojo.xml;

import java.time.LocalDate;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.linhard.kaindorf._plf.pojo.generic.User;

/**
 *
 * @author martin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@lombok.AllArgsConstructor
@lombok.NoArgsConstructor
@lombok.Data
public class XmlUser {

    @XmlAttribute
    private String id;
    private String name;
    @XmlJavaTypeAdapter(XmlUserAdapter.class)
    @javax.xml.bind.annotation.XmlElement(name = "birth_date")
    private LocalDate birthDay;

    public static User toGenericUser(XmlUser self) {
        return new User(self.id, self.name, self.birthDay);
    }
}
