
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.boundaries;

import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.RutasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Paradas;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Rutas;
import uesocc.edu.sv.ingenieria.tpi13_rutasbuses.boundary.abs.AbstractfrmDataModel;

/**
 *
 * @author pedrojv
 */
@Named
@ViewScoped
public class frmRutas extends AbstractfrmDataModel<Rutas> implements Serializable{

   @Inject
   private RutasFacade rutasfacade;
   
    @Override
  @PostConstruct
    public void inicializar(){
        super.inicializar();
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
    
    
}
