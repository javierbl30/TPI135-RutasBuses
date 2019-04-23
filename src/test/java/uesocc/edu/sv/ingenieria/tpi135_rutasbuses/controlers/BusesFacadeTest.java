/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers;

import java.util.ArrayList;
import java.util.Collections;
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
import static org.mockito.Mockito.mock;
import org.mockito.runners.MockitoJUnitRunner;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Horarios;

/**
 *
 * @author pedrojv
 */
   @RunWith(MockitoJUnitRunner.class)
   public class BusesFacadeTest {
   
    @EJB
    BusesFacade bfc = new BusesFacade();
    /**
     * Test of horaSalidaBus method, of class BusesFacade.
     */
    @Test
    public void testHoraSalidaBus() throws Exception {
        System.out.println("tesHoraSalidaBus");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Assert.assertEquals(Collections.EMPTY_LIST,bfc.horaSalidaBus("AB12-135"));
        bfc.em = entityManager;
        List<Horarios> expResult = new ArrayList<>();
        expResult.add(new Horarios("ACOD01","AB12-135"));
        List<Horarios> salida = new ArrayList<>();
        salida.add(new Horarios("ACOD01","AB12-135"));
        Query query = mock(Query.class);
        Mockito.when(entityManager.createQuery("SELECT b FROM Buses b JOIN b.horariosList h WHERE h.buses.placaBus = AB12-135")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(expResult,bfc.horaSalidaBus("AB12-135"));
        Mockito.when(bfc.horaSalidaBus(null)).thenReturn(Collections.EMPTY_LIST);
        Assert.assertEquals(Collections.EMPTY_LIST,bfc.horaSalidaBus(null));
    }
    
    @Test
    public void testBusesPorRuta() throws Exception {
        System.out.println("tesBusesPorRuta");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Assert.assertEquals(Collections.EMPTY_LIST,bfc.busesPorRuta("ACOD01"));
        bfc.em = entityManager;
        List<Buses> expResult = new ArrayList<>();
        expResult.add(new Buses("AB12-135"));
        List<Buses> salida = new ArrayList<>();
        salida.add(new Buses("AB12-135"));
        Query query = mock(Query.class);
        Mockito.when(entityManager.createQuery("SELECT b FROM Buses b JOIN b.rutasBusesList rb WHERE rb.rutas.idRuta = ACOD01")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(expResult,bfc.busesPorRuta("ACOD01"));
        Mockito.when(bfc.busesPorRuta(null)).thenReturn(Collections.EMPTY_LIST);
        Assert.assertEquals(Collections.EMPTY_LIST,bfc.busesPorRuta(null));
    }
    
}
