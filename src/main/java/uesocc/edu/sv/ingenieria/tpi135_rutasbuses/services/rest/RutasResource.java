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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.RutasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Rutas;

/**
 *
 * @author pedrojv
 */
@Path("rutas")
@RequestScoped
public class RutasResource extends AbstractResource<Rutas> {
    
    @Inject
    protected RutasFacade rutasFacade;
    
    @Override
    protected AbstractFacade<Rutas> entity(){
        return rutasFacade;
    }
    
    @Override
    protected Rutas nuevo(){
        return new Rutas();
    }
}
