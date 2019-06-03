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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.EmpresasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.ParadasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Empresas;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Paradas;

/**
 *
 * @author pedrojv
 */
@Path("empresas")
@RequestScoped
public class EmpresasResource extends AbstractResource<Empresas>{
    @Inject
    protected EmpresasFacade empresasFacade;
    
    @Override
    protected AbstractFacade<Empresas> entity() {
        return empresasFacade;
    }

    @Override
    protected Empresas nuevo() {
        return new Empresas();
    }
}
