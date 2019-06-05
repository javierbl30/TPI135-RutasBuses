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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.BusesFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;

/**
 *
 * @author pedrojv
 */
@Path("buses")
@RequestScoped
public class BusesResource extends AbstractResource<Buses>{
    
    @Inject
    protected BusesFacade busesFacade;
    
    @Override
    protected AbstractFacade<Buses> entity(){
        return busesFacade;
    }
    
    @Override
    protected Buses nuevo(){
        return new Buses();
    }
}
