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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.EmpresasFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Empresas;

/**
 *
 * @author pedrojv
 */
@Named
@ViewScoped
public class frmEmpresas extends AbstractfrmDataModel<Empresas> implements Serializable {

    @Inject
    private EmpresasFacade empresasfacade;
    
    @Override
    @PostConstruct
    public void inicializar(){
        super.inicializar();
    }
    
     @Override
    public Object clavePorDatos(Empresas object) {
        if (object != null) {
            return object.getIdEmpresa();
        }
        return null;
    }

    @Override
    public Empresas datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdEmpresa().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }

    @Override
    public AbstractFacade getFacade() {
        return empresasfacade;
    }
    
    @Override
    public Empresas registroNew(){
    return new Empresas();
    }
    
}
