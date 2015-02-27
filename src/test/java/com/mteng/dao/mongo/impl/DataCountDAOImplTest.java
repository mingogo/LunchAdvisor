package com.mteng.dao.mongo.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by mteng on 2/27/2015.
 */
public class DataCountDAOImplTest {
    /**
     * @verifies return the count of data
     * @see DataCountDAOImpl#documentsCounter()
     */
    @Test
    public void documentsCounter_shouldReturnTheCountOfData() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataCountDAOImpl dataCountDAO = (DataCountDAOImpl) ctx.getBean("dataCountDAOImpl");
        System.out.println( dataCountDAO.documentsCounter() );
    }
}
