/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.RutasBuses;

/**
 *
 * @author pedrojv
 */
 @RunWith(MockitoJUnitRunner.class)
 public class RutasBusesFacadeTest {
    
    @EJB
    RutasBusesFacade rbf = new RutasBusesFacade();
    
    /**
     * Test of costoBus method, of class RutasBusesFacade.
     */
    @Test
    public void testCostoBus() throws Exception {
        System.out.println("testCostoBus");
        EntityManager entitymanager = Mockito.mock(EntityManager.class);
        Double exp=0.0;
        Assert.assertEquals(exp,rbf.costoBus("ACOD01"));
        Query query = Mockito.mock(Query.class);
        rbf.em = entitymanager;
        Assert.assertEquals(exp,rbf.costoBus(null));
        exp = 0.25;
        Mockito.when(entitymanager.createQuery("SELECT rb.costo FROM RutasBuses rb JOIN rb.rutas p WHERE p.idRuta = ACOD01"))
               .thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(new Double (0.25));
        Assert.assertEquals(exp,rbf.costoBus("ACOD01"));
    }
    
    @Test
    public void testEntityManager(){
        System.out.println("testEM");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        rbf.em = entityManager;
        Assert.assertEquals(entityManager,rbf.getEntityManager());
    }
}
