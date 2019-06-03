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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Horarios;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Rutas;

/**
 *
 * @author pedrojv
 */
@LocalBean
@Stateless
public class RutasFacade extends AbstractFacade<Rutas> {

    @PersistenceContext(unitName = "uesocc.edu.sv.ingenieria_TPI135_RutasBuses_war_1.0-SNAPSHOTPU")
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public RutasFacade() {
        super(Rutas.class);
    }
    
    public List<Horarios> horaSalidaRuta(String idRuta){
        List<Horarios> lista = new ArrayList<>();
        try{
            if(idRuta!=null){
                Query query = em.createQuery("SELECT r FROM Rutas r JOIN r.horariosList h WHERE h.rutas.idRuta = "+idRuta);
                return lista = query.getResultList();
            }else{
                return Collections.EMPTY_LIST;
            }
        }catch(Exception e){
                return Collections.EMPTY_LIST;
        }
    }
    
    
}
