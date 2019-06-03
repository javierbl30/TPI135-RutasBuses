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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Empresas;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Rutas;

/**
 *
 * @author pedrojv
 */
@RunWith(MockitoJUnitRunner.class)
public class frmRutasTest {
    
    protected Rutas registro;
    protected List<Rutas> listRutas;
    protected List<Empresas> listEmpresas;
   
    @InjectMocks
    frmRutas frmRutas = new frmRutas();
    
    
    @Before
    public void setUp() {
        this.listRutas = new ArrayList<>();
        listRutas.add(new Rutas("ACOD01"));
        registro = new Rutas("ACOD01");
        registro.setIdEmpresa(new Empresas(1));
    }
   
    /**
     * Test of inicializar method, of class frmRutas.
     */
    @Test
    public void testInicializar() {
       System.out.println("testInicializar");
        frmRutas frmr = Mockito.spy(frmRutas);
        frmr.inicializar();
        Mockito.verify(frmr).inicializar();
    }

    /**
     * Test of getIdEmpresaSeleccionada method, of class frmRutas.
     */
    @Test
    public void testGetIdEmpresaSeleccionada() {
       System.out.println("testGetIdEmpresaSeleccionada");
        Rutas rutas = Mockito.mock(Rutas.class);
        Empresas empresas = Mockito.mock(Empresas.class);
        Mockito.when(rutas.getIdEmpresa()).thenReturn(empresas);
        Mockito.when(empresas.getIdEmpresa()).thenReturn(1);
        frmRutas.setRegistro(registro);
        Assert.assertEquals(frmRutas.getIdEmpresaSeleccionada(),new Integer(1));
        registro.setIdEmpresa(null);
        Assert.assertNull(frmRutas.getIdEmpresaSeleccionada());
    }

    /**
     * Test of setEmpresaSeleccionada method, of class frmRutas.
     */
    @Test
    public void testSetEmpresaSeleccionada() {
        System.out.println("testSetIdEmpresaSeleccionada");
        frmRutas frmr = Mockito.spy(frmRutas);
        Rutas rutas = Mockito.mock(Rutas.class);
        List<Empresas> list = Mockito.mock(List.class);
        listEmpresas = new ArrayList<>();
        listEmpresas.add(new Empresas(1));
        frmRutas.setRegistro(registro);
        frmRutas.setListaEmpresas(listEmpresas);
        frmRutas.registro = rutas;
        frmRutas.listaEmpresas = listEmpresas;
        frmRutas.setEmpresaSeleccionada(1);
        Mockito.verify(rutas).setIdEmpresa(new Empresas(1));
        Mockito.when(list.stream()).thenThrow(Exception.class);
        boolean aser=false;
        try{
            frmRutas.setEmpresaSeleccionada(2);
        }catch(Exception ex){
            aser=true; 
        }
     //   Assert.assertTrue(aser);
    }

    /**
     * Test of clavePorDatos method, of class frmRutas.
     */
    @Test
    public void testClavePorDatos() {
         System.out.println("testClavePorDatos");
        Rutas entity = Mockito.mock(Rutas.class);
        Object exp = "ACOD01";
        Mockito.when(entity.getIdRuta()).thenReturn("ACOD01");
        Assert.assertEquals(frmRutas.clavePorDatos(new Rutas("ACOD01")),exp);
        Assert.assertEquals(frmRutas.clavePorDatos(null),null);
    }

    /**
     * Test of datosPorClave method, of class frmRutas.
     */
    @Test
    public void testDatosPorClave() {
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listRutas);
        frmRutas.lazymodel=lazy;
        Assert.assertEquals(frmRutas.datosPorClave("ACOD01"),new Rutas("ACOD01"));
        boolean aser=false;
        try{
            frmRutas.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
      //  Assert.assertTrue(aser);
        Assert.assertNull(frmRutas.datosPorClave(null));
    }

    /**
     * Test of getFacade method, of class frmRutas.
     */
    @Test
    public void testGetFacade() {
        System.out.println("testGetFacade");
        frmRutas frmr = Mockito.spy(frmRutas);
        frmr.getFacade();
        Mockito.verify(frmr).getFacade();
    }

    /**
     * Test of registroNew method, of class frmRutas.
     */
    @Test
    public void testRegistroNew() {
        System.out.println("testRegistroNew");
        frmRutas frmr = Mockito.spy(frmRutas);
        Assert.assertEquals(frmr.registroNew(),new Rutas());
    }

    /**
     * Test of getListaEmpresas method, of class frmRutas.
     */
    @Test
    public void testGetListaEmpresas() {
        System.out.println("testGetListaEmpresas");
        frmRutas frmr = Mockito.mock(frmRutas.class);
        List<Empresas> lista = Mockito.mock(List.class);
        Mockito.when(frmr.getListaEmpresas()).thenReturn(lista);
        Assert.assertEquals(frmRutas.getListaEmpresas(),listEmpresas);
    }
    
}
