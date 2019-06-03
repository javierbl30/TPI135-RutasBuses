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
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Horarios;

/**
 *
 * @author pedrojv
 */
@LocalBean
@Stateless
public class BusesFacade extends AbstractFacade<Buses>{

    @PersistenceContext(unitName = "uesocc.edu.sv.ingenieria_TPI135_RutasBuses_war_1.0-SNAPSHOTPU")
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public BusesFacade() {
        super(Buses.class);
    }
    
    public List<Horarios> horaSalidaBus(String placa){
        List<Horarios> lista = new ArrayList<>();
        try{
            if(placa!=null){
                Query query = em.createQuery("SELECT b FROM Buses b JOIN b.horariosList h WHERE h.buses.placaBus = "+placa);
                return lista = query.getResultList();
            }else{
                return Collections.EMPTY_LIST;
            }
        }catch(Exception e){
                return Collections.EMPTY_LIST;
        }
    }
    
     public List<Buses> busesPorRuta(String idRuta){
        List<Buses> lista = new ArrayList<>();
        try{
            if(idRuta!=null){
                Query query = em.createQuery("SELECT b FROM Buses b JOIN b.rutasBusesList rb WHERE rb.rutas.idRuta = "+idRuta);
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
