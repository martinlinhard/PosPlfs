/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linhard.kaindorf._plf.pojo.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.linhard.kaindorf._plf.pojo.generic.User;

/**
 *
 * @author martin
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JsonUser {
    private String id;
    private String name;
    @JsonProperty("birth_date")
    @JsonSerialize(using = JsonUserSerializer.class)
    @JsonDeserialize(using = JsonUserDeserializer.class)
    private LocalDate birthDate;
    
    public static User toGenericUser(JsonUser self) {
        return new User(self.id, self.name, self.birthDate);
    }
}
