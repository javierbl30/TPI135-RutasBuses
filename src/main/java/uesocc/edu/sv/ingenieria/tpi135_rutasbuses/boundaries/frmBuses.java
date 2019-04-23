/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.boundaries;

import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.BusesFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Empresas;
import uesocc.edu.sv.ingenieria.tpi13_rutasbuses.boundary.abs.AbstractfrmDataModel;

/**
 *
 * @author pedrojv
 */
@Named
@ViewScoped
public class frmBuses extends AbstractfrmDataModel<Buses> implements Serializable {

  @Inject
  private BusesFacade busesfacade;
  
  @Override
  @PostConstruct
    public void inicializar(){
        super.inicializar();
    }
    
    @Override
    public Object clavePorDatos(Buses object) {
        if (object != null) {
            return object.getPlacaBus();
        }
        return null;
    }
    
    @Override
    public Buses datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getPlacaBus().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }
    
    @Override
    public AbstractFacade getFacade() {
        return busesfacade;
    }
    
    @Override
    public Buses registroNew(){
    return new Buses();
    }
    
}

