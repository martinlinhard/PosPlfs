/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linhard.kaindorf._plf.pojo.xml;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 *
 * @author martin
 */
public class XmlUserAdapter extends XmlAdapter<String, LocalDate>{
    private static DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate unmarshal(String vt) throws Exception {
        return LocalDate.parse(vt, DTF);
    }

    @Override
    public String marshal(LocalDate bt) throws Exception {
        return DTF.format(bt);
    } 
}
