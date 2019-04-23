/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.RutasBuses;

/**
 *
 * @author pedrojv
 */
@LocalBean
@Stateless
public class RutasBusesFacade extends AbstractFacade<RutasBuses> {

    @PersistenceContext(unitName = "uesocc.edu.sv.ingenieria_TPI135_RutasBuses_war_1.0-SNAPSHOTPU")
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RutasBusesFacade() {
        super(RutasBuses.class);
    }
    
    public Double costoBus(String idRuta){
        Double salida=0.0;
        try{
            if(idRuta!=null){
                Query query = em.createQuery("SELECT rb.costo FROM RutasBuses rb JOIN rb.rutas p WHERE p.idRuta = "+idRuta);
                salida = (Double) query.getSingleResult();
                return salida;
            }else{
                return salida;
            }
        }catch(Exception e){
            return salida;
        }
    }
    
   
}
    

