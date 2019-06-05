/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.services.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.RecorridoRutasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.RecorridoRutas;

/**
 *
 * @author pedrojv
 */
@Path("recorridorutas")
@RequestScoped
public class RecorridoRutasResource extends AbstractResource<RecorridoRutas>{
    
    @Inject
    protected RecorridoRutasFacade recorridoRutasFacade;
    
    @Override
    protected AbstractFacade<RecorridoRutas> entity(){
        return recorridoRutasFacade;
    }
    
    @Override
    protected RecorridoRutas nuevo(){
        return new RecorridoRutas();
    }
    
    
}
