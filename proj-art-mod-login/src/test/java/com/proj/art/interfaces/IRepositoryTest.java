/*
 * IRepositoryTest.java
 *
 * Created on 30-10-2018
 *
 * Copyright(c) 2018 Foz Sociedade de Advogados Company, Inc.  All Rights Reserved.
 * This software is the proprietary information of Foz Sociedade de Advogados Company.
 *
 */

package com.proj.art.interfaces;

/**
 * Description the class  IRepositoryTest - xxxxx
 * @author Daniela Xavier Conceição - sistemas@fozadvogados.com.br
 * @version $v rev. $rev  $Revision$
 * @since Build 1.0 17/12/2018
 */
public interface IRepositoryTest {
    public void save();  
    public void update();  
    public void delete();
    public void findByFilter();
    public void findAll();
    public void findById();
}
