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
import javax.persistence.Query;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.RecorridoRutas;

/**
 *
 * @author pedrojv
 */
@LocalBean
@Stateless
public class RecorridoRutasFacade extends AbstractFacade<RecorridoRutas> {

    @PersistenceContext(unitName = "uesocc.edu.sv.ingenieria_TPI135_RutasBuses_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RecorridoRutasFacade() {
        super(RecorridoRutas.class);
    }
    
   /** public Integer tiempoDesdeParadaAnterior(String idRuta, Integer idParada, Integer correlativo){
        Integer salida=0;
        try{
            if(idRuta!=null && idParada!=null && correlativo!=null){
                Query query = em.createQuery("SELECT rr.tiempoDesdeParadaAnterior FROM RecorridoRutas rr JOIN rr.rutas r, AND JOIN rr.paradas p (WHERE r.idRuta = "+idRuta"), AND (p.idParada = "+idParada"), AND (rr.correlativo = "+correlativo")");
                salida = (Integer) query.getSingleResult();
                return salida;
            }else{
                return salida;
            }
        }catch(Exception e){
            return salida;
        }
    } */
    
    
    
}
