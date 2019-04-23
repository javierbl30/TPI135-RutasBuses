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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Paradas;

/**
 *
 * @author pedrojv
 */
@LocalBean
@Stateless
public class ParadasFacade extends AbstractFacade<Paradas> {

    @PersistenceContext(unitName = "uesocc.edu.sv.ingenieria_TPI135_RutasBuses_war_1.0-SNAPSHOTPU")
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParadasFacade() {
        super(Paradas.class);
    }
    
    public List<Paradas> paradasPorRuta(String idRuta){
        List<Paradas> lista = new ArrayList<>();
        try{
            if(idRuta!=null){
                Query query = em.createQuery("SELECT p FROM Paradas p JOIN p.recorridoRutasList rr WHERE rr.rutas.idRuta = "+idRuta);
                lista = query.getResultList();
                return lista;
            }else{
                return Collections.EMPTY_LIST;
            }
        }catch(Exception e){
            return Collections.EMPTY_LIST;
        }
    }
}
