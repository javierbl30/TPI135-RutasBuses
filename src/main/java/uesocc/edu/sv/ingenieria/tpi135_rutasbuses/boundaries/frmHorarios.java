
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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.BusesFacade;

import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.HorariosFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.RutasBusesFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.RutasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Horarios;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.HorariosPK;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Rutas;

import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.RutasBuses;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.RutasBusesPK;

/**
 *
 * @author pedrojv
 */
@Named
@ViewScoped
public class frmHorarios extends AbstractfrmDataModel<Horarios> implements Serializable{

    @Inject
     HorariosFacade horariosfacade;
    @Inject
     RutasFacade rutasfacade;
    @Inject
    BusesFacade busesfacade;
            
   protected List<Rutas> listaRutas;
    protected List<Buses> listaBuses;
    
    @Override
    @PostConstruct
    public void inicializar(){
        super.inicializar();
       try{
            this.listaRutas = rutasfacade.findAll();
        }catch(Exception ex) {
        this.listaRutas = Collections.EMPTY_LIST;
        }
        try{
            this.listaBuses = busesfacade.findAll();
        }catch(Exception ex) {
        this.listaBuses = Collections.EMPTY_LIST;
        }   
    }
    
    public String getIdRutaSeleccionada() {
        if (this.registro != null && this.registro.getRutas().getIdRuta()!= null) {
            return this.registro.getRutas().getIdRuta();
        }
        return null;
    }
    
    public void setRutaSeleccionada(String idRutaSeleccionada) {
        if (this.registro != null && this.listaRutas != null) {
            try {
            
             this.registro.setRutas(this.listaRutas.stream().filter(r -> r.getIdRuta().compareTo(idRutaSeleccionada) == 0).collect(Collectors.toList()).get(0));
            } catch (Exception ex) {

            }
        }
    }
    
    public String getPlacaSeleccionada() {
        if (this.registro != null && this.registro.getBuses().getPlacaBus()!= null) {
            return this.registro.getBuses().getPlacaBus();
        }
        return null;
    }
    
    public void setBusSeleccionado(String placaSeleccionada) {
        if (this.registro != null && this.listaBuses != null) {
            try {
                this.registro.setBuses(this.listaBuses.stream().filter(r -> r.getPlacaBus().compareTo(placaSeleccionada) == 0).collect(Collectors.toList()).get(0));
            } catch (Exception ex) {

            }
        }
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
    
    public List<Rutas> getListaRutas(){
        return listaRutas;
    }
    
    public List<Buses> getListaBuses(){
        return listaBuses;
    }
    
     public void setListaRutas(List<Rutas> listRutas) {
        this.listaRutas = listRutas;
    }
     
     public void setListaBuses(List<Buses> listBuses) {
        this.listaBuses = listBuses;
    }
    
}
