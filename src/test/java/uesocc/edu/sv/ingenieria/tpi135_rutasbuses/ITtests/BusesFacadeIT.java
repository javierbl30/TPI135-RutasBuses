
package uesocc.edu.sv.ingenieria.tpi135_rutasbuses.ITtests;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Rule;
import org.junit.Test;
import uesocc.edu.sv.ingenieria.tpi135_rutasbuses.entitys.Buses;


public class BusesFacadeIT {
 
    @Rule
    public EntityManagerProvider provider = EntityManagerProvider.withUnit("IT-TEST");
    
    @Test
    public void horaSalidaBus() {
        this.provider.begin();
        this.provider.em().persist(new Buses("AB12-135", "BLUE BIRD", "AZUL CON BLANCO", 150));

        Buses resultado = this.provider.em()
            .createQuery("SELECT b FROM Buses b JOIN b.horariosList h WHERE h.buses.placaBus = AB12-135", Buses.class).getSingleResult();
        assertEquals("08:15:00.00000", resultado);
   /*     for (Buses resultBuses : resultado) {
            assertNotNull(resultBuses.getPlacaBus());
        } */
        this.provider.commit();
    
}
}