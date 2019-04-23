/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import static org.hamcrest.CoreMatchers.is;
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
    @Test
    public void testEdit() throws Exception {
        System.out.println("testEdit");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        BusesFacade bfc = new BusesFacade();
        Buses buses = new Buses("AB17-569", "BlueBird", "Azul y Blanco", 150); //Llama la clase Buses con el constructor al que se le pasan los valores de todos los campos
        bfc.em = entityManager;
        bfc.edit(buses);
        Mockito.verify(entityManager).merge(Matchers.any(Buses.class));
    }

    /**
     * Test of remove method, of class BusesFacade.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("testRemove");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        BusesFacade bfc = new BusesFacade();
        Buses buses = new Buses("AB17-569"); //Llama la clase Buses con el constructor al que solo se le pasa el ID de los campos
        bfc.em = entityManager;
        bfc.remove(buses);
        Mockito.verify(entityManager).remove(Matchers.any(Buses.class));
    }

    /**
     * Test of find method, of class BusesFacade.
     */
   @Test
    public void testFind() throws Exception {
        System.out.println("testFind");
        Object id="AB17-569";
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(entityManager.find(Buses.class,"AB17-569")).thenReturn(new Buses("AB17-569"));
        Buses expResult = new Buses("AB17-569");
        BusesFacade bfc = new BusesFacade();
        bfc.em = entityManager;
        Buses result = bfc.find(id);
        Assert.assertEquals(expResult,result);
    }

    /**
     * Test of findAll method, of class BusesFacade.
     */
   @Test
    public void testFindAll() {
        List<Buses> buses = new ArrayList<>();
        BusesFacade bfc = new BusesFacade();
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        bfc.em = entityManager;
        Mockito.when(entityManager.find(Buses.class, "AB17-569")).thenReturn(new Buses("AB17-569"));
        Buses resultado = new Buses("AB17-569");
        buses.add(resultado);
        TypedQuery typedQuery = Mockito.mock(TypedQuery.class);
        Mockito.when(typedQuery.getResultList()).thenReturn(buses);
        Mockito.when(typedQuery.setParameter(Matchers.anyString(), Matchers.anyObject())).thenReturn(typedQuery);
      //  Mockito.when(bfc.findAll()).thenReturn(typedQuery);
        buses = bfc.findAll();
        assertThat(buses.size(), is(1));
        
     /**  System.out.println("testFindAll");
        BusesFacade bfc = new BusesFacade();
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        bfc.em = entityManager;
        bfc.findAll(); */
      /** System.out.println("findAll");
       Buses bus1 = new Buses("AB12-568", "BlueBird", "Rojo con Blanco", 150);
        Buses bus2 = new Buses("AB154-895", "Mascarello", "Verde con Amarillo", 80);

        List<Buses> list = new ArrayList<>();
        list.add(bus1);
        list.add(bus2);
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        BusesFacade bfc = new BusesFacade();
        //Whitebox.setInternalState(Af, "em", emp.em());
        bfc.em = entityManager;
        bfc.getEntityManager().getTransaction().begin();
        bfc.getEntityManager().persist(bus1);
        bfc.getEntityManager().persist(bus2);
        assertEquals(list, bfc.findAll()); */
        
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
    } */

    /**
     * Test of count method, of class BusesFacade.
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("testCount");
        BusesFacade bfc = new BusesFacade();
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(bfc.count()).thenReturn(new Integer(25));
        bfc.em=entityManager;
        Integer esperado = 25;
        Integer retornado = bfc.count();
        Assert.assertEquals(esperado,retornado);
    }

    /**System.out.println("count");
        BusesFacade instance = new BusesFacade();
        int expResult = 0;
        int result = instance.count();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
     * Test of findByName method, of class BusesFacade.
     */ 
    
}
