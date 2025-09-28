package ar.edu.unahur.obj2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class CazadorTest {
    static Zona hurlingham;
    static Rural lucas;
    static Urbano cristian;
    static Sigiloso marcos;

    @BeforeAll
    static void inicializar(){
        Profugo profugo1 = new Profugo(8, 10, true);
        Profugo profugo2 = new Profugo(20, 30, false);
        Profugo profugo3 = new Profugo(40, 50, true);
        Profugo profugo4 = new Profugo(30, 60, false);

        hurlingham = new Zona("Hurlingham");
        hurlingham.agregarProfugo(profugo1);
        hurlingham.agregarProfugo(profugo2);
        hurlingham.agregarProfugo(profugo3);
        hurlingham.agregarProfugo(profugo4);

        lucas = new Rural(30);
        cristian = new Urbano(50);
        marcos = new Sigiloso(40);
 
    }

    @Test
    void marcosVaAcazarAHurlingham(){
        assertEquals(4, hurlingham.profugos.size());
        marcos.cazarEnZona(hurlingham);
        assertEquals(2, marcos.capturados.size());
        assertEquals(2, hurlingham.profugos.size());
        assertEquals(89, marcos.getExperiencia());
    }

    @Test
    void lucasVaAcazarAHurlingham(){
        lucas.cazarEnZona(hurlingham);
        assertEquals(0, lucas.capturados.size());
        assertEquals(1, hurlingham.profugos.size());
        assertEquals(75, lucas.getExperiencia());
    }

    @Test
    void crisVaAcazarAHurlingham(){
        cristian.cazarEnZona(hurlingham);
        assertEquals(1, cristian.capturados.size());
        assertEquals(1, hurlingham.profugos.size());
        assertEquals(97, cristian.getExperiencia());
    }
}
