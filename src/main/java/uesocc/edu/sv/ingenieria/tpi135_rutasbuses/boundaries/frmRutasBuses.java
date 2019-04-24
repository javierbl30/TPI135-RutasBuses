
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.boundaries;

import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.RutasBusesFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.RutasBuses;
import uesocc.edu.sv.ingenieria.tpi13_rutasbuses.boundary.abs.AbstractfrmDataModel;

/**
 *
 * @author pedrojv
 */
@Named
@ViewScoped
public class frmRutasBuses extends AbstractfrmDataModel<RutasBuses> implements Serializable{

   @Inject
   private RutasBusesFacade rbfacade;
   
   @Override
  @PostConstruct
    public void inicializar(){
        super.inicializar();
    }
    
    @Override
    public Object clavePorDatos(RutasBuses object) {
        if (object != null) {
            return object.getRutas().getIdRuta();
        }
        return null;
    }
    
    @Override
    public RutasBuses datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getRutas().getIdRuta().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }
    
    @Override
    public AbstractFacade getFacade() {
        return rbfacade;
    }
    
    @Override
    public RutasBuses registroNew(){
    return new RutasBuses();
    }
    
}
