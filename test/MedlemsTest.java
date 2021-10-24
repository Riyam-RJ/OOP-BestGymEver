import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedlemsTest {

    @Test
    void isMedlem() {
        Medlems medlems = new Medlems();
        int medlem = medlems.isMedlem("Nahema Ninsson");
        assertEquals(0,medlem);

        int medlem2 = medlems.isMedlem("Ida Idylle");
        assertEquals(1,medlem2);

        int medlem3 = medlems.isMedlem("Riyam");
        assertEquals(2,medlem3);

    }
}