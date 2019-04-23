/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
    @Test(expected = IllegalArgumentException.class)
    public void testRemove() {
        System.out.println("testRemove");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        boolean ise = false;
        try{
            bfc.remove(new Buses());
        }catch(IllegalStateException e){
            ise = true;
        }
        Assert.assertTrue(ise);
        Buses bus = new Buses("AB12-135");
        bfc.em = entityManager;
        bfc.remove(bus);
        Mockito.verify(entityManager).remove(Matchers.any(Buses.class));
        bfc.remove(null);
    }

    /**
     * Test of find method, of class AbstractFacade.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFind() {
        System.out.println("testFindById");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        boolean ise = false;
        try{
            bfc.find("AB12-135");
        }catch(IllegalStateException e){
            ise = true;
        }
        Assert.assertTrue(ise);
        Mockito.when(entityManager.find(Buses.class,"AB12-135")).thenReturn(new Buses("AB12-135"));
        Buses expResult = new Buses("AB12-135");
        bfc.em = entityManager;
        Object id= "AB12-135";
        Buses result = bfc.find(id);
        Assert.assertEquals(expResult,result);
        bfc.find(null);
    }

    /**
     * Test of findAll method, of class AbstractFacade.
     */
    @Test
    public void testFindAll(){
        System.out.println("testFindAll");
        List<Buses> salida = new ArrayList<>();
        salida.add(new Buses("AB12-135"));
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        bfc.em = entityManager;
        CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery cq = Mockito.mock(CriteriaQuery.class);
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(cb);
        Mockito.when(cb.createQuery()).thenReturn(cq);
        Mockito.when(entityManager.createQuery(cq)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        List<Buses> expResult = new ArrayList();
        expResult.add(new Buses("AB12-135"));
        Assert.assertEquals(expResult,bfc.findAll());
    }

    /**
     * Test of findRange method, of class AbstractFacade.
     */
    @Test
    public void testFindRange(){
        System.out.println("testFindRange");
        List<Buses> salida = new ArrayList<>();
        salida.add(new Buses("AB12-135"));
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        bfc.em = entityManager;
        CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery cq = Mockito.mock(CriteriaQuery.class);
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(cb);
        Mockito.when(cb.createQuery()).thenReturn(cq);
        Mockito.when(entityManager.createQuery(cq)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        List<Buses> expResult = new ArrayList();
        expResult.add(new Buses("AB12-135"));
        Assert.assertEquals(expResult,bfc.findRange(1,1000));
    }

    /**
     * Test of count method, of class AbstractFacade.
     */
    @Test
    public void testCount(){
        System.out.println("testCount");
        Long salida=1l;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        bfc.em = entityManager;
        CriteriaQuery cq = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(cb);
        Mockito.when(cb.createQuery()).thenReturn(cq);
        Mockito.when(entityManager.createQuery(cq)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(salida);
        Assert.assertEquals(1l,bfc.count());
    }
    
}
