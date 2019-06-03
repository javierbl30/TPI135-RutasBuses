
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.boundaries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.boundaries.AbstractfrmDataModel.EstadosCRUD;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.RutasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Rutas;

/**
 *
 * @author pedrojv
 * @param <T>
 * 
 */
@Ignore public abstract class AbstractfrmDataModelTest<T> {
    
  protected T registro;
  protected abstract AbstractFacade<T> getFacade();
  protected frmRutas frm = new frmRutas();
  protected Map<String,Object> filters = new HashMap<>();
  protected List<Rutas> lista = new ArrayList<>();

  @Mock
  private EntityManager entityManager;
    
    public AbstractfrmDataModelTest(T entity) {
        this.registro = entity;
    }
  

    @Test
    public void testGetEstado() {
        System.out.println("testGetEstado");
        frmRutas frmr = Mockito.spy(frm);
        frmr.getEstado();
        Mockito.verify(frmr).getEstado();
    }

    
    @Test
    public void testNuevoEstado() {
        System.out.println("testNuevoEstado");
        frmRutas frmr = Mockito.spy(frm);
        frmr.nuevoEstado();
        Mockito.verify(frmr).nuevoEstado();
    }
    
/*    @Test
    public void testLoadDatos() {
        System.out.println("testLoadDatos");
        frmRutas frmr = Mockito.spy(frm);
        RutasFacade rutasfacade = Mockito.mock(RutasFacade.class);
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Map<String,Object> filtro = Mockito.spy(filters);
        Assert.assertEquals(frmr.loadDatos(1,10,"null", SortOrder.UNSORTED, filters),new ArrayList<>());
        Mockito.when(frmr.getFacade()).thenReturn(rutasfacade);
        List<Rutas> list = Mockito.spy(lista);
        frmr.setLazymodel(lazy);
        Mockito.when(rutasfacade.findRange(1,100)).thenReturn(new ArrayList<>());
        Assert.assertEquals(frmr.loadDatos(1,100,"String",SortOrder.UNSORTED,filtro),lista);
        boolean aser = false;
        try{
            Mockito.when(rutasfacade.findRange(1,20)).thenThrow(Exception.class);
            frmr.loadDatos(1,20,"ex", SortOrder.UNSORTED, filters);
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
    } */


  /*  @Test
    public void testGuardar() {
        System.out.println("testGuardar");
        frmRutas frmr = Mockito.spy(frm);
        AbstractFacade fac = Mockito.spy(getFacade());
        Rutas reg = Mockito.mock(Rutas.class);
        EntityManager emm = Mockito.mock(EntityManager.class);
        Mockito.when(frmr.getFacade()).thenReturn(fac);
        Mockito.when(fac.getEntityManager()).thenReturn(emm);
        boolean aser=false;
        try{
        frmr.guardar();
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        frmr.setRegistro(reg);
        frmr.guardar();
        Mockito.verify(fac).create(reg);
        Mockito.when(frmr.getFacade()).thenReturn(null);
        frmr.guardar();
    } */

    
/*    @Test
    public void testEditar() {
        System.out.println("testEditar");
        frm.editar();
        frmRutas frmr = Mockito.spy(frm);
        AbstractFacade fac = Mockito.spy(getFacade());
        Rutas reg = Mockito.mock(Rutas.class);
        EntityManager emm = Mockito.mock(EntityManager.class);
        Mockito.when(frmr.getFacade()).thenReturn(fac);
        Mockito.when(fac.getEntityManager()).thenReturn(emm);
        boolean aser=false;
        try{
            frmr.setRegistro(null);
            frmr.editar();
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        frmr.setRegistro(reg);
        frmr.editar();
        Mockito.verify(fac).edit(reg);
        Mockito.when(frmr.getFacade()).thenReturn(null);
        frmr.editar();
    } */

    
/*    @Test
    public void testEliminar() {
        System.out.println("testEliminar");
        frmRutas frmr = Mockito.spy(frm);
        AbstractFacade fac = Mockito.spy(getFacade());
        Rutas reg = Mockito.mock(Rutas.class);
        EntityManager emm = Mockito.mock(EntityManager.class);
        Mockito.when(frmr.getFacade()).thenReturn(fac);
        Mockito.when(fac.getEntityManager()).thenReturn(emm);
        boolean aser=false;
        try{
        frmr.eliminar();
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        frmr.setRegistro(reg);
        frmr.eliminar();
        Mockito.verify(fac).remove(reg);
        Mockito.when(frmr.getFacade()).thenReturn(null);
        frmr.eliminar();
    } */

    @Test
    public void testCambiarSeleccion() {
        System.out.println("testCambiarSeleccion");
        frmRutas frmr = Mockito.spy(frm);
        frmr.cambiarSeleccion();
        Mockito.verify(frmr).cambiarSeleccion();
    }


    @Test
    public void testBtnCancelar() {
        System.out.println("testBtnCancelar");
        frmRutas frmr = Mockito.spy(frm);
        frmr.btnCancelar();
        Mockito.verify(frmr).btnCancelar();
    }

 

    
    @Test
    public void testSetLazymodel() {
        System.out.println("testSetLazyModel");
        frmRutas frmr = Mockito.spy(frm);
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        frmr.setLazymodel(lazy);
        Mockito.verify(frmr).setLazymodel(lazy);
    }

    
    @Test
    public void testGetRegistro() {
        System.out.println("testGetRegistro");
        frmRutas frmr = Mockito.spy(frm);
        Mockito.when(frmr.getRegistro()).thenReturn(new Rutas());
        Assert.assertEquals(frmr.getRegistro(),new Rutas());
    }


   
    @Test
    public void testIsSeleccion() {
        System.out.println("testGeneral");
        frmRutas frmr = Mockito.spy(frm);
        frmr.isSeleccion();
        Mockito.verify(frmr).isSeleccion();
    }

    
    @Test
    public void testSetSeleccion() {
        System.out.println("testSetSeleccion");
        frmRutas frmr = Mockito.spy(frm);
        frmr.setSeleccion(true);
        Mockito.verify(frmr).setSeleccion(true);
    }

    
    @Test
    public void testIsBotonAgregar() {
        System.out.println("testIsBtnAgregar");
        frmRutas frmr = Mockito.spy(frm);
        frmr.isBotonAgregar();
        Mockito.verify(frmr).isBotonAgregar();
    }

    
    @Test
    public void testSetBotonAgregar() {
        System.out.println("testSetBtnAgregar");
        frmRutas frmr = Mockito.spy(frm);
        frmr.setBotonAgregar(true);
        Mockito.verify(frmr).setBotonAgregar(true);
    }

    
    @Test
    public void testIsBotones() {
        System.out.println("testIsBotones");
        frmRutas frmr = Mockito.spy(frm);
        frmr.isBotones();
        Mockito.verify(frmr).isBotones();
    }

    
    @Test
    public void testSetBotones() {
        System.out.println("testSetBotones");
        frmRutas frmr = Mockito.spy(frm);
        frmr.setBotones(true);
        Mockito.verify(frmr).setBotones(true);
    }

    
    @Test
    public void testGetStdCrud() {
        System.out.println("testGetStdCrud");
        frmRutas frmr = Mockito.spy(frm);
        frmr.getStdCrud();
        Mockito.verify(frmr).getStdCrud();
    }

    
    @Test
    public void testSetStdCrud() {
        System.out.println("testSetStdCrud");
        frmRutas frmr = Mockito.spy(frm);
        frmr.setStdCrud(EstadosCRUD.ADD);
        Mockito.verify(frmr).setStdCrud(EstadosCRUD.ADD);
    } 

}
