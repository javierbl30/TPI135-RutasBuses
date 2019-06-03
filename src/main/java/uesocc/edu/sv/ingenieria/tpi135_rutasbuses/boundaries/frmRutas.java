
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.boundaries;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.EmpresasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.RutasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Empresas;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Rutas;

/**
 *
 * @author pedrojv
 */
@Named
@ViewScoped
public class frmRutas extends AbstractfrmDataModel<Rutas> implements Serializable{

   @Inject
   private RutasFacade rutasfacade;
   @Inject
   private EmpresasFacade empresasfacade;
   
   protected List<Empresas> listaEmpresas;
   
    @Override
  @PostConstruct
    public void inicializar(){
        super.inicializar();
        try{
            this.listaEmpresas = empresasfacade.findAll();
        }catch(Exception ex) {
        this.listaEmpresas = Collections.EMPTY_LIST;
        }
    }
    
    public Integer getIdEmpresaSeleccionada() {
        if (this.registro != null && this.registro.getIdEmpresa()!= null) {
            return this.registro.getIdEmpresa().getIdEmpresa();
        }
        return null;
    }
    
    public void setEmpresaSeleccionada(Integer idEmpresaSeleccionada) {
        if (this.registro != null && this.listaEmpresas != null) {
            try {
              this.registro.setIdEmpresa(this.listaEmpresas.stream().filter(r -> r.getIdEmpresa().compareTo(idEmpresaSeleccionada) == 0).collect(Collectors.toList()).get(0));
            } catch (Exception ex) {

            }
        }
    }
   
    @Override
    public Object clavePorDatos(Rutas object) {
        if (object != null) {
            return object.getIdRuta();
        }
        return null;
    }
    
    @Override
    public Rutas datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdRuta().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }
    
    @Override
    public AbstractFacade getFacade() {
        return rutasfacade;
    }
    
    @Override
    public Rutas registroNew(){
    return new Rutas();
    }
    
    public List<Empresas> getListaEmpresas(){
        return listaEmpresas;
    }
    
     public void setListaEmpresas(List<Empresas> listEmpresas) {
        this.listaEmpresas = listEmpresas;
    }
    
}
