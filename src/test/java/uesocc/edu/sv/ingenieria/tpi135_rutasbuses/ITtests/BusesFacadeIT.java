
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.ITtests;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Rule;
import org.junit.Test;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.AbstractFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.controlers.BusesFacade;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;


public class BusesFacadeIT {
 
    BusesFacade busesFacade = new BusesFacade();
    
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-rutasbuses", busesFacade);
    
    public AbstractFacade facade() {
        return emp.getFacade();
    }
    
    @Test
    public void testCreate() {
        System.out.println("create");
        Buses buses = new Buses("AB12-123");
        facade().getEntityManager().getTransaction().begin();
        facade().create(buses);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }
    
    @Test
    public void testEdit() {
        System.out.println("edit");
        Buses buses = new Buses("AB12-123", "Blue-Bird", "AZUL CON BLANCO", 90);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(buses);
        Buses modificacion = new Buses("AB12-123", "Blue-Bird", "ROJO CON BLANCO", 90);
        facade().edit(modificacion);
        assertEquals(modificacion.getColor(), modificacion.getColor());
    }
    
    @Test
    public void testDelete() {
        System.out.println("delete");
        Buses busesUno = new Buses("AB12-123");
        Buses busesDos = new Buses("AB13-124");
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(busesUno);
        facade().getEntityManager().persist(busesDos);
        facade().remove(new Buses("AB12-123"));
        assertEquals(busesDos, facade().find("AB13-124"));
    }
    
    @Test
    public void testFindById() {
        System.out.println("findById");
        Buses buses = new Buses("AB12-123", "Blue-Bird", "ROJO CON BLANCO", 90);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(buses);

        assertEquals(buses, facade().find("AB12-123"));
    }
    
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Buses busesUno = new Buses("AB12-123", "Blue-Bird", "ROJO CON BLANCO", 90);
        Buses busesDos = new Buses("AB13-124", "Blue-Bird", "AZUL CON BLANCO", 95);

        List<Buses> list = new ArrayList<>();
        list.add(busesUno);
        list.add(busesDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(busesUno);
        facade().getEntityManager().persist(busesDos);

        assertEquals(list, facade().findAll());
    }
    
    @Test
    public void testFindRange() {
        System.out.println("findRange");

        Buses busesUno = new Buses("AB12-123", "Blue-Bird", "ROJO CON BLANCO", 90);
        Buses busesDos = new Buses("AB13-124", "Blue-Bird", "AZUL CON BLANCO", 95);
              
        List<Buses> list = new ArrayList<>();
        list.add(busesUno);
        list.add(busesDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(busesUno);
        facade().getEntityManager().persist(busesDos);
        
        int inicio = 1;
        int tamanio = 2;
        assertEquals(list.get(0), facade().findRange(inicio, tamanio).get(0));
    }
    
    @Test
    public void testCount() {
        System.out.println("count");
        Buses busesUno = new Buses("AB12-123", "Blue-Bird", "ROJO CON BLANCO", 90);
        Buses busesDos = new Buses("AB13-124", "Blue-Bird", "AZUL CON BLANCO", 95);

        List<Buses> list = new ArrayList<>();
        list.add(busesUno);
        list.add(busesDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(busesUno);
        facade().getEntityManager().persist(busesDos);

        assertEquals(list.size(), facade().count());
    }
}
