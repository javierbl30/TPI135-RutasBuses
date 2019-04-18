/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Matchers;
import org.mockito.Mockito;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;

/**
 *
 * @author pedrojv
 */
public class BusesFacadeTest {
    

    /**
     * Test of create method, of class BusesFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("testCreate");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        BusesFacade bfc = new BusesFacade();
        bfc.em = entityManager;
        bfc.create(new Buses());
        Mockito.verify(entityManager).persist(Matchers.anyObject());
    }

    /**
     * Test of edit method, of class BusesFacade.
     */
   /** @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Buses entity = null;
        BusesFacade instance = new BusesFacade();
        Buses expResult = null;
        Buses result = instance.edit(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class BusesFacade.
     */
  /**  @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        Buses entity = null;
        BusesFacade instance = new BusesFacade();
        Buses expResult = null;
        Buses result = instance.remove(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class BusesFacade.
     */
  /**  @Test
    public void testFind() throws Exception {
        System.out.println("find");
        Object id = null;
        BusesFacade instance = new BusesFacade();
        Buses expResult = null;
        Buses result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class BusesFacade.
     */
 /**   @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        BusesFacade instance = new BusesFacade();
        List<Buses> expResult = null;
        List<Buses> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class BusesFacade.
     */
  /**  @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        int[] range = null;
        BusesFacade instance = new BusesFacade();
        List<Buses> expResult = null;
        List<Buses> result = instance.findRange(range);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class BusesFacade.
     */
 /**   @Test
    public void testCount() throws Exception {
        System.out.println("count");
        BusesFacade instance = new BusesFacade();
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByName method, of class BusesFacade.
     */
 /**   @Test
    public void testFindByName() throws Exception {
        System.out.println("findByName");
        String name = "";
        BusesFacade instance = new BusesFacade();
        List<Buses> expResult = null;
        List<Buses> result = instance.findByName(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    } */
    
}
