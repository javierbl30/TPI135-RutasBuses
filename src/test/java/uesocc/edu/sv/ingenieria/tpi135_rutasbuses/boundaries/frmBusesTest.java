/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.boundaries;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.primefaces.model.LazyDataModel;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.BusesFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;

/**
 *
 * @author pedrojv
 */
@RunWith(MockitoJUnitRunner.class)
public class frmBusesTest extends AbstractfrmDataModelTest<Buses>{
    
    protected List<Buses> listBuses;
    
    @InjectMocks
    frmBuses frmBuses = new frmBuses();
    @InjectMocks
    BusesFacade busesfacade = new BusesFacade();
    @InjectMocks
    Buses buses = new Buses();
    
    @Override
    public AbstractFacade getFacade(){
        return busesfacade;
    }
    
    public frmBusesTest() {
        super(new Buses("AB12-123"));
    }
    
     
    @Before
    public void setUp() {
        this.listBuses = new ArrayList<>();
        listBuses.add(new Buses("AB12-123"));
    }
    
    @Test
    public void testInicializar() {
        System.out.println("testInicializar");
        frmBuses frmb = Mockito.spy(frmBuses);
        frmb.inicializar();
        Mockito.verify(frmb).inicializar();
    }

    /**
     * Test of clavePorDatos method, of class frmBuses.
     */
    @Test
    public void testClavePorDatos() {
        System.out.println("testClavePorDatos");
        Buses entity = Mockito.mock(Buses.class);
        Object exp = "AB12-123";
        Mockito.when(entity.getPlacaBus()).thenReturn("AB12-123");
        Assert.assertEquals(frmBuses.clavePorDatos(new Buses("AB12-123")),exp);
        Assert.assertEquals(frmBuses.clavePorDatos(null),null);
    }

    /**
     * Test of datosPorClave method, of class frmBuses.
     */
   @Test
    public void testDatosPorClave() {
       System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listBuses);
        frmBuses.lazymodel=lazy;
        Assert.assertEquals(frmBuses.datosPorClave("AB12-123"),new Buses("AB12-123"));
        boolean aser=false;
        try{
            frmBuses.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
      //  Assert.assertTrue(aser);
        Assert.assertNull(frmBuses.datosPorClave(null));
    } 

    /**
     * Test of getFacade method, of class frmBuses.
     */
    @Test
    public void testGetFacade() {
        System.out.println("testGetFacade");
        frmBuses frmb = Mockito.spy(frmBuses);
        frmb.getFacade();
        Mockito.verify(frmb).getFacade();
    }

    /**
     * Test of registroNew method, of class frmBuses.
     */
    @Test
    public void testRegistroNew() {
        System.out.println("testRegistroNew");
        frmBuses frmb = Mockito.spy(frmBuses);
        Assert.assertEquals(frmb.registroNew(),new Buses());
    }
    
}
