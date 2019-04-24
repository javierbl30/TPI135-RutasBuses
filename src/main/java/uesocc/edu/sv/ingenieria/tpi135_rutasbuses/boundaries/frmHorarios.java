
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.boundaries;

import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.HorariosFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Horarios;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Rutas;
import uesocc.edu.sv.ingenieria.tpi13_rutasbuses.boundary.abs.AbstractfrmDataModel;

/**
 *
 * @author pedrojv
 */
@Named
@ViewScoped
public class frmHorarios extends AbstractfrmDataModel<Horarios> implements Serializable{

    @Inject
    private HorariosFacade horariosfacade;
    
    @Override
  @PostConstruct
    public void inicializar(){
        super.inicializar();
    }
    
    @Override
    public Object clavePorDatos(Horarios object) {
        if (object != null) {
            return object.getRutas().getIdRuta();
        }
        return null;
    }
    
    @Override
    public Horarios datosPorClave(String rowkey) {
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
        return horariosfacade;
    }
    
    @Override
    public Horarios registroNew(){
    return new Horarios();
    }
    
    
}
