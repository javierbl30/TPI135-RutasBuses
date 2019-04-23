/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.boundaries;

import java.io.Serializable;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.EmpresasFacade;

/**
 *
 * @author pedrojv
 */
@Named(value = "frmEmpresas")
@ViewScoped
public class frmEmpresas implements Serializable {

    @Inject
    private EmpresasFacade empresasfacade;
    /**
     * Creates a new instance of frmEmpresas
     */
    public frmEmpresas(){
        
    }
    
}
