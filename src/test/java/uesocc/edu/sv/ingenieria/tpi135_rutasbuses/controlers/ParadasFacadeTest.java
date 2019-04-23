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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Paradas;

/**
 *
 * @author pedrojv
 */
@RunWith(MockitoJUnitRunner.class)
public class ParadasFacadeTest {
    
    @EJB
    ParadasFacade pfc = new ParadasFacade();
 
    /**
     * Test of paradasPorRuta method, of class ParadasFacade.
     */
    @Test
    public void testParadasPorRuta() throws Exception {
        System.out.println("tesParadasPorRuta");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Assert.assertEquals(Collections.EMPTY_LIST,pfc.paradasPorRuta("ACOD01"));
        pfc.em = entityManager;
        List<Paradas> expResult = new ArrayList<>();
        expResult.add(new Paradas(1));
        List<Paradas> salida = new ArrayList<>();
        salida.add(new Paradas(1));
        Query query = mock(Query.class);
        Mockito.when(entityManager.createQuery("SELECT p FROM Paradas p JOIN p.recorridoRutasList rr WHERE rr.rutas.idRuta = ACOD01")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(expResult,pfc.paradasPorRuta("ACOD01"));
        Mockito.when(pfc.paradasPorRuta(null)).thenReturn(Collections.EMPTY_LIST);
        Assert.assertEquals(Collections.EMPTY_LIST,pfc.paradasPorRuta(null));
    }
    
}
