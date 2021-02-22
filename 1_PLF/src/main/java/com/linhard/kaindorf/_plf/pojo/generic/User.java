/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linhard.kaindorf._plf.pojo.generic;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.linhard.kaindorf._plf.pojo.json.JsonUser;
import com.linhard.kaindorf._plf.pojo.xml.XmlUser;

/**
 *
 * @author martin
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

    private String id;
    private String name;
    private LocalDate birthday;

    public static JsonUser intoJsonUser(User self) {
        return new JsonUser(self.id, self.name, self.birthday);
    }

    public static XmlUser intoXmlUser(User self) {
        return new XmlUser(self.id, self.name, self.birthday);
    }
}
