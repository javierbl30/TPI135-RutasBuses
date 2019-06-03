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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.ParadasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Paradas;

/**
 *
 * @author pedrojv
 */
@Path("paradas")
@RequestScoped
public class ParadasResource extends AbstractResource<Paradas>{

    @Inject
    protected ParadasFacade paradasFacade;
    
    @Override
    protected AbstractFacade<Paradas> entity() {
        return paradasFacade;
    }

    @Override
    protected Paradas nuevo() {
        return new Paradas();
    }
    
    //Para las entidades que necesitan consultas especiales, aquí se deben crear los métodos especificos de json para obtenerlos y mandarlos.
}
