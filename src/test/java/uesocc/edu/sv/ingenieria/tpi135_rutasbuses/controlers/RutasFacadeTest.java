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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Horarios;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Rutas;

/**
 *
 * @author pedrojv
 */
@RunWith(MockitoJUnitRunner.class)
public class RutasFacadeTest {
    
  @EJB  
  RutasFacade rfc = new RutasFacade();
  
    /**
     * Test of horaSalidaRuta method, of class RutasFacade.
     */
    @Test
    public void testHoraSalidaRuta() throws Exception {
        System.out.println("tesHoraSalidaRuta");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Assert.assertEquals(Collections.EMPTY_LIST,rfc.horaSalidaRuta("ACOD01"));
        rfc.em = entityManager;
        List<Horarios> expResult = new ArrayList<>();
        expResult.add(new Horarios("ACOD01","AB12-135"));
        List<Horarios> salida = new ArrayList<>();
        salida.add(new Horarios("ACOD01","AB12-135"));
        Query query = mock(Query.class);
        Mockito.when(entityManager.createQuery("SELECT r FROM Rutas r JOIN r.horariosList h WHERE h.rutas.idRuta = ACOD01")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(expResult,rfc.horaSalidaRuta("ACOD01"));
        Mockito.when(rfc.horaSalidaRuta(null)).thenReturn(Collections.EMPTY_LIST);
        Assert.assertEquals(Collections.EMPTY_LIST,rfc.horaSalidaRuta(null));
    }
    
}
