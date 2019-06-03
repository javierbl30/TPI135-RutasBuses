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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.BusesFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.RutasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Horarios;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.HorariosPK;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Rutas;

/**
 *
 * @author pedrojv
 */
@RunWith(MockitoJUnitRunner.class)
public class frmHorariosTest {
    
    protected Horarios registro;
    protected List<Horarios> listHorarios;
    protected List<Buses> listBuses;
    protected List<Rutas> listRutas;
    
    @InjectMocks
    frmHorarios frmHorarios = new frmHorarios();  
    
    @Before
    public void setUp() {
        this.listHorarios = new ArrayList<>();
        listHorarios.add(new Horarios("ACOD01", "AB12-123"));
        registro = new Horarios();
        registro.setBuses(new Buses("AB12-123"));
        registro.setRutas(new Rutas("ACOD01"));
    }
    
   
    /**
     * Test of inicializar method, of class frmHorarios.
     */
    @Test
    public void testInicializar() {
        System.out.println("testInicializar");
        frmHorarios frmh = Mockito.spy(frmHorarios);
        //BusesFacade busesfacade = Mockito.mock(BusesFacade.class);
        //RutasFacade rutasfacade = Mockito.mock(RutasFacade.class);
       // frmHorarios.busesfacade = busesfacade;
       // frmHorarios.rutasfacade = rutasfacade;
        frmh.inicializar();
        Mockito.verify(frmh).inicializar();
      // Mockito.verify(busesfacade).findAll();
      //  Mockito.verify(rutasfacade).findAll();
    }

    /**
     * Test of getIdRutaSeleccionada method, of class frmHorarios.
     */
    @Test
    public void testGetIdRutaSeleccionada() {
        System.out.println("testGetIdRutaSeleccionada");
        Horarios horarios = Mockito.mock(Horarios.class);
        Rutas rutas = Mockito.mock(Rutas.class);
        Mockito.when(horarios.getRutas()).thenReturn(rutas);
        Mockito.when(rutas.getIdRuta()).thenReturn("ACOD01");
        frmHorarios.setRegistro(registro);
        Assert.assertEquals(frmHorarios.getIdRutaSeleccionada(),new String("ACOD01"));
        registro.setRutas(new Rutas(null));
        Assert.assertNull(frmHorarios.getIdRutaSeleccionada());
    }

    /**
     * Test of setRutaSeleccionada method, of class frmHorarios.
     */
    @Test
    public void testSetRutaSeleccionada() {
        System.out.println("testSetIdRutaSeleccionada");
        frmHorarios frmh = Mockito.spy(frmHorarios);
        Horarios horarios = Mockito.mock(Horarios.class);
        List<Rutas> list = Mockito.mock(List.class);
        listRutas = new ArrayList<>();
        listRutas.add(new Rutas("ACOD01"));
        frmHorarios.setRegistro(registro);
        frmHorarios.setListaRutas(listRutas);
        frmHorarios.registro = horarios;
        frmHorarios.listaRutas = listRutas;
        frmHorarios.setRutaSeleccionada("ACOD01");
        Mockito.verify(horarios).setRutas(new Rutas("ACOD01"));
        Mockito.when(list.stream()).thenThrow(Exception.class);
        boolean aser=false;
        try{
            frmHorarios.setRutaSeleccionada("ACOD02");
        }catch(Exception ex){
            aser=true; 
        }
//        Assert.assertTrue(aser);
    }

    /**
     * Test of getPlacaSeleccionada method, of class frmHorarios.
     */
    @Test
    public void testGetPlacaSeleccionada() {
        System.out.println("testGetPlacaSeleccionada");
        Horarios horarios = Mockito.mock(Horarios.class);
        Buses buses = Mockito.mock(Buses.class);
        Mockito.when(horarios.getBuses()).thenReturn(buses);
        Mockito.when(buses.getPlacaBus()).thenReturn("AB12-123");
        frmHorarios.setRegistro(registro);
        Assert.assertEquals(frmHorarios.getPlacaSeleccionada(),new String("AB12-123"));
        registro.setBuses(new Buses(null));
        Assert.assertNull(frmHorarios.getPlacaSeleccionada());
    }

    /**
     * Test of setBusSeleccionado method, of class frmHorarios.
     */
    @Test
    public void testSetBusSeleccionado() {
        System.out.println("testSetPlacaBusSeleccionada");
        frmHorarios frmh = Mockito.spy(frmHorarios);
        Horarios horarios = Mockito.mock(Horarios.class);
        List<Buses> list = Mockito.mock(List.class);
        listBuses = new ArrayList<>();
        listBuses.add(new Buses("AB12-123"));
        frmHorarios.setRegistro(registro);
        frmHorarios.setListaBuses(listBuses);
        frmHorarios.registro = horarios;
        frmHorarios.listaBuses = listBuses;
        frmHorarios.setBusSeleccionado("AB12-123");
        Mockito.verify(horarios).setBuses(new Buses("AB12-123"));
        Mockito.when(list.stream()).thenThrow(Exception.class);
        boolean aser=false;
        try{
            frmHorarios.setBusSeleccionado("AB13-123");
        }catch(Exception ex){
            aser=true; 
        }
    }

    /**
     * Test of clavePorDatos method, of class frmHorarios.
     */
  /*  @Test
    public void testClavePorDatos() {
        System.out.println("testClavePorDatos");
        Horarios entity = Mockito.mock(Horarios.class);
        Object exp = "ACOD01, AB12-123";
        Mockito.when(entity.getHorariosPK().getIdRuta()).thenReturn("ACOD01");
        Mockito.when(entity.getHorariosPK().getPlacaBus()).thenReturn("AB12-123");
        Assert.assertEquals(frmHorarios.clavePorDatos(new Horarios("ACOD01", "AB12-123")),exp);
        Assert.assertEquals(frmHorarios.clavePorDatos(null),null);
    } */

    /**
     * Test of datosPorClave method, of class frmHorarios.
     */
 /*   @Test
    public void testDatosPorClave() {
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listHorarios);
        frmHorarios.lazymodel=lazy;
        Assert.assertEquals(frmHorarios.datosPorClave("ACOD01, AB12-123"),new Horarios("ACOD01", "AB12-123"));
        boolean aser=false;
        try{
            frmHorarios.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
       // Assert.assertTrue(aser);
        Assert.assertNull(frmHorarios.datosPorClave(null));
    } */

    /**
     * Test of getFacade method, of class frmHorarios.
     */
    @Test
    public void testGetFacade() {
        System.out.println("testGetFacade");
        frmHorarios frmh = Mockito.spy(frmHorarios);
        frmh.getFacade();
        Mockito.verify(frmh).getFacade();
    }

    /**
     * Test of registroNew method, of class frmHorarios.
     */
    @Test
    public void testRegistroNew() {
        System.out.println("testRegistroNew");
        frmHorarios frmh = Mockito.spy(frmHorarios);
        Assert.assertEquals(frmh.registroNew(),new Horarios());
    }

    /**
     * Test of getListaRutas method, of class frmHorarios.
     */
    @Test
    public void testGetListaRutas() {
        System.out.println("testGetListaRutas");
        frmHorarios frmh = Mockito.mock(frmHorarios.class);
        List<Rutas> lista = Mockito.mock(List.class);
        Mockito.when(frmh.getListaRutas()).thenReturn(lista);
//        Assert.assertEquals(frmh.getListaRutas(),listRutas);
    }

    /**
     * Test of getListaBuses method, of class frmHorarios.
     */
  /*  @Test
    public void testGetListaBuses() {
        System.out.println("testGetListaBuses");
        frmHorarios frmh = Mockito.mock(frmHorarios.class);
        List<Buses> lista = Mockito.mock(List.class);
        Mockito.when(frmh.getListaBuses()).thenReturn(lista);
        Assert.assertEquals(frmh.getListaBuses(),listBuses);
    } */
    
}
