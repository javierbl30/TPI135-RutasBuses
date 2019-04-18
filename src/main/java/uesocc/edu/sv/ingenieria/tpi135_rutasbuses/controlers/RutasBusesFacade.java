/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.RutasBuses;

/**
 *
 * @author pedrojv
 */
@Stateless
public class RutasBusesFacade extends AbstractFacade<RutasBuses> implements RutasBusesFacadeLocal {

    @PersistenceContext(unitName = "uesocc.edu.sv.ingenieria_TPI135_RutasBuses_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RutasBusesFacade() {
        super(RutasBuses.class);
    }
    
}
