/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Empresas;

/**
 *
 * @author pedrojv
 */
@LocalBean
@Stateless
public class EmpresasFacade extends AbstractFacade<Empresas>{

    @PersistenceContext(unitName = "uesocc.edu.sv.ingenieria_TPI135_RutasBuses_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public EmpresasFacade() {
        super(Empresas.class);
    }
    
}
