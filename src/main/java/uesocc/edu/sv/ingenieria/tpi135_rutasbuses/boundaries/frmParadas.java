
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.boundaries;

import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.ParadasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Paradas;
import uesocc.edu.sv.ingenieria.tpi13_rutasbuses.boundary.abs.AbstractfrmDataModel;

/**
 *
 * @author pedrojv
 */
@Named
@ViewScoped
public class frmParadas extends AbstractfrmDataModel<Paradas> implements Serializable {

   @Inject
   private ParadasFacade paradasfacade;
   
   @Override
  @PostConstruct
    public void inicializar(){
        super.inicializar();
    }
    
    @Override
    public Object clavePorDatos(Paradas object) {
        if (object != null) {
            return object.getIdParada();
        }
        return null;
    }
    
    @Override
    public Paradas datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdParada().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }
    
    @Override
    public AbstractFacade getFacade() {
        return paradasfacade;
    }
    
    @Override
    public Paradas registroNew(){
    return new Paradas();
    }
   
    
}
