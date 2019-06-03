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
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.primefaces.model.LazyDataModel;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Paradas;

/**
 *
 * @author pedrojv
 */
@RunWith(MockitoJUnitRunner.class)
public class frmParadasTest {
    
    protected List<Paradas> listParadas;
    
    @InjectMocks
    frmParadas frmp = new frmParadas();
    
    
    @Before
    public void setUp() {
        this.listParadas = new ArrayList<>();
        listParadas.add(new Paradas(1));
    }
    

    /**
     * Test of inicializar method, of class frmParadas.
     */
    @Test
    public void testInicializar() {
       System.out.println("testInicializar");
        frmParadas frmparadas = Mockito.spy(frmp);
        frmparadas.inicializar();
        Mockito.verify(frmparadas).inicializar();
    }

    /**
     * Test of clavePorDatos method, of class frmParadas.
     */
    @Test
    public void testClavePorDatos() {
       System.out.println("testClavePorDatos");
        Paradas entity = Mockito.mock(Paradas.class);
        Object exp = 1;
        Mockito.when(entity.getIdParada()).thenReturn(1);
        Assert.assertEquals(frmp.clavePorDatos(new Paradas(1)),exp);
        Assert.assertEquals(frmp.clavePorDatos(null),null);
    }

    /**
     * Test of datosPorClave method, of class frmParadas.
     */
    @Test
    public void testDatosPorClave() {
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listParadas);
        frmp.lazymodel=lazy;
        Assert.assertEquals(frmp.datosPorClave("1"),new Paradas(1));
        boolean aser=false;
        try{
            frmp.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
       // Assert.assertTrue(aser);
        Assert.assertNull(frmp.datosPorClave(null));
    }

    /**
     * Test of getFacade method, of class frmParadas.
     */
    @Test
    public void testGetFacade() {
        System.out.println("testGetFacade");
        frmParadas frmparadas = Mockito.spy(frmp);
        frmparadas.getFacade();
        Mockito.verify(frmparadas).getFacade();
    }

    /**
     * Test of registroNew method, of class frmParadas.
     */
    @Test
    public void testRegistroNew() {
        System.out.println("testRegistroNew");
        frmParadas frmparadas = Mockito.spy(frmp);
        Assert.assertEquals(frmparadas.registroNew(),new Paradas());
    }
    
}
