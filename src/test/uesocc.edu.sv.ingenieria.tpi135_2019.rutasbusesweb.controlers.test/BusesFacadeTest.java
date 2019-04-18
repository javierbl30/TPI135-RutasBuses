/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.BusesFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;

/**
 *
 * @author pedrojv
 */
@RunWith(MockitoJUnitRunner.class)
public class BusesFacadeTest {
    
    
    
    /**
     * Test of create method, of class MedioContactoFacade.
     */
    @Test
    public void testCreate() {
        System.out.println("testCreate");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        BusesFacade cut = new BusesFacade();
        cut.em = entityManager;
        cut.create(new Buses());
        Mockito.verify(entityManager).persist(Matchers.anyObject());
    }

    

    
}
