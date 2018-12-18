/*
 * Criptografar.java
 *
 * Created on 13-12-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */
package com.proj.art.mod.core.strategy.impl;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Description the class Criptografar - xxxxx
 *
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev $Revision$
 * @since Build 1.1 13/12/2018
 */
public class Criptografar {

    public static String criptografar(String texto) {

        MessageDigest algorithm;
        byte messageDigest[];

        try {
            algorithm = MessageDigest.getInstance("SHA-256");
            messageDigest = algorithm.digest(texto.getBytes("UTF-8"));

        } catch (NoSuchAlgorithmException ex) {
            return "<5900>" + ex.getMessage();
        } catch (UnsupportedEncodingException ex) {
            return "<5900>" + ex.getMessage();
        }

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        String textohex = hexString.toString();

        return textohex;
    }
}