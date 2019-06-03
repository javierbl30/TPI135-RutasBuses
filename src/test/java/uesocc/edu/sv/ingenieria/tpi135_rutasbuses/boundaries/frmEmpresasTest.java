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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.EmpresasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Empresas;

/**
 *
 * @author pedrojv
 */
@RunWith(MockitoJUnitRunner.class)
public class frmEmpresasTest extends AbstractfrmDataModelTest<Empresas> {
    
    protected List<Empresas> listEmpresas;
    
    @InjectMocks
    frmEmpresas frmEmpresas = new frmEmpresas();
    @InjectMocks
    EmpresasFacade empresasfacade = new EmpresasFacade();
    @InjectMocks
    Empresas empresas = new Empresas();
    
    @Override
    public AbstractFacade getFacade(){
        return empresasfacade;
    }
    
    public frmEmpresasTest() {
        super(new Empresas(1));
    }
  
    
    @Before
    public void setUp() {
        this.listEmpresas = new ArrayList<>();
        listEmpresas.add(new Empresas(1));
    }
    

    /**
     * Test of inicializar method, of class frmEmpresas.
     */
    @Test
    public void testInicializar() {
        System.out.println("testInicializar");
        frmEmpresas frme = Mockito.spy(frmEmpresas);
        frme.inicializar();
        Mockito.verify(frme).inicializar();
    }

    /**
     * Test of clavePorDatos method, of class frmEmpresas.
     */
    @Test
    public void testClavePorDatos() {
        System.out.println("testClavePorDatos");
        Empresas entity = Mockito.mock(Empresas.class);
        Object exp = 1;
        Mockito.when(entity.getIdEmpresa()).thenReturn(1);
        Assert.assertEquals(frmEmpresas.clavePorDatos(new Empresas(1)),exp);
        Assert.assertEquals(frmEmpresas.clavePorDatos(null),null);
    }

    /**
     * Test of datosPorClave method, of class frmEmpresas.
     */
    @Test
    public void testDatosPorClave() {
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listEmpresas);
        frmEmpresas.lazymodel=lazy;
        Assert.assertEquals(frmEmpresas.datosPorClave("1"),new Empresas(1));
        boolean aser=false;
        try{
            frmEmpresas.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
       // Assert.assertTrue(aser);
        Assert.assertNull(frmEmpresas.datosPorClave(null));
    }

    /**
     * Test of getFacade method, of class frmEmpresas.
     */
    @Test
    public void testGetFacade() {
        System.out.println("testGetFacade");
        frmEmpresas frme = Mockito.spy(frmEmpresas);
        frme.getFacade();
        Mockito.verify(frme).getFacade();
    }

    /**
     * Test of registroNew method, of class frmEmpresas.
     */
    @Test
    public void testRegistroNew() {
         System.out.println("testRegistroNew");
        frmEmpresas frme = Mockito.spy(frmEmpresas);
        Assert.assertEquals(frme.registroNew(),new Empresas());
    }
    
}
