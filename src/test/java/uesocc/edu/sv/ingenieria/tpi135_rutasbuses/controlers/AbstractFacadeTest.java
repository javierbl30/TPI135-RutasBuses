/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers;

import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
public class AbstractFacadeTest {
    
    @EJB
    BusesFacade bfc = new BusesFacade();
       
    @Test(expected = IllegalArgumentException.class)
    public void testCreate() {
        System.out.println("testCreate");
        boolean ise=false;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        try{
            bfc.create(new Buses());
        }catch(IllegalStateException e){
            ise = true;
        }
        Assert.assertTrue(ise);
        bfc.em = entityManager;
        bfc.create(new Buses());
        Mockito.verify(entityManager).persist(Matchers.anyObject());
        bfc.create(null);
    }

    /**
     * Test of edit method, of class AbstractFacade.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testEdit() {
        System.out.println("testEdit");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        boolean ise = false;
        try{
            bfc.edit(new Buses());
        }catch(IllegalStateException e){
            ise = true;
        }
        Assert.assertTrue(ise);
        Buses bus = new Buses("AB12-135");
        bfc.em = entityManager;
        bfc.edit(bus);
        Mockito.verify(entityManager).merge(Matchers.any(Buses.class));
        bfc.edit(null);
    }

    /**
     * Test of remove method, of class AbstractFacade.
     */
 /**   @Test
    public void testRemove() {
        System.out.println("remove");
        Object entity = null;
        AbstractFacade instance = null;
        instance.remove(entity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class AbstractFacade.
     */
  /**  @Test
    public void testFind() {
        System.out.println("find");
        Object id = null;
        AbstractFacade instance = null;
        Object expResult = null;
        Object result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class AbstractFacade.
     */
  /**  @Test
    public void testFindAll() {
        System.out.println("findAll");
        AbstractFacade instance = null;
        List expResult = null;
        List result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findRange method, of class AbstractFacade.
     */
 /**   @Test
    public void testFindRange() {
        System.out.println("findRange");
        int inicio = 0;
        int tamanio = 0;
        AbstractFacade instance = null;
        List expResult = null;
        List result = instance.findRange(inicio, tamanio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of count method, of class AbstractFacade.
     */
  /**  @Test
    public void testCount() {
        System.out.println("count");
        AbstractFacade instance = null;
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class AbstractFacadeImpl extends AbstractFacade {

        public AbstractFacadeImpl() {
            super(null);
        }

        public EntityManager getEntityManager() {
            return null;
        }
    } */
    
}
