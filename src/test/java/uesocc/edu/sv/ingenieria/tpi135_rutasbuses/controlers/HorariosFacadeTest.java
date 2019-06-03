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
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Horarios;

/**
 *
 * @author pedrojv
 */
@RunWith(MockitoJUnitRunner.class)
@Ignore public class HorariosFacadeTest {
    
    @EJB
    HorariosFacade hrf = new HorariosFacade();
    /**
     * Test of horaSalidaBus method, of class HorariosFacade.
     */
  /*  @Test
    public void testHoraSalidaBus() throws Exception {
        System.out.println("testHoraSalidaBus");
        EntityManager entitymanager = Mockito.mock(EntityManager.class);
        String exp="";
        Assert.assertEquals(exp, hrf.horaSalidaBus("AB12-135"));
        Query query = Mockito.mock(Query.class);
        hrf.em = entitymanager;
        Assert.assertEquals(exp,hrf.horaSalidaBus(null));
        exp = "08:15:00.00000";
        Mockito.when(entitymanager.createQuery("SELECT h.horaSalida FROM Horarios h JOIN h.buses pb WHERE pb.placaBus = AB12-135"))
               .thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(new String("08:15:00.00000"));
        Assert.assertEquals(exp,hrf.horaSalidaBus("AB12-135"));
        
    } */

    /**
     * Test of horaSalidaRuta method, of class HorariosFacade.
     */

    
}
