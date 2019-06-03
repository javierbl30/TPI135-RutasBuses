/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.services.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author pedrojv
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(uesocc.edu.sv.ingenieria.tpi135_rutasbuses.services.rest.CorsFilter.class);
        resources.add(uesocc.edu.sv.ingenieria.tpi135_rutasbuses.services.rest.EmpresasResource.class);
        resources.add(uesocc.edu.sv.ingenieria.tpi135_rutasbuses.services.rest.ParadasResource.class);
    }
    
}
