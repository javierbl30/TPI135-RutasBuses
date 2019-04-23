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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Horarios;

/**
 *
 * @author pedrojv
 */
@LocalBean
@Stateless
public class HorariosFacade extends AbstractFacade<Horarios>{

    @PersistenceContext(unitName = "uesocc.edu.sv.ingenieria_TPI135_RutasBuses_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorariosFacade() {
        super(Horarios.class);
    }
    
}
