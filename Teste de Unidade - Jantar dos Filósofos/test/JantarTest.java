import main.Jantar;
import main.Filosofo;
import main.Garfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class JantarTest {

    private Jantar jantar;

    @BeforeEach
    void setUp() {
        jantar = new Jantar();
        jantar.iniciar();
    }

    @Test
    void testCriacaoDeCincoFilosofos() {
        assertEquals(5, jantar.getFilosofos().length);
    }

    @Test
    void testCriacaoDeCincoGarfos() {
        assertEquals(5, jantar.getGarfos().length);
    }

    @Test
    void testCadaFilosofoTemDoisGarfos() {
        Filosofo[] filosofos = jantar.getFilosofos();
        for (int i = 0; i < filosofos.length; i++) {
            Garfo[] garfos = filosofos[i].getGarfos();
            assertEquals(2, garfos.length);
        }
    }

    @Test
    void testGarfosCompartilhadosCorretamente() {
        Filosofo[] filosofos = jantar.getFilosofos();
        Garfo[] garfos = jantar.getGarfos();
        
        for (int i = 0; i < 5; i++) {
            Filosofo filosofo = filosofos[i];
            Garfo garfoEsquerdo = garfos[i];
            Garfo garfoDireito = garfos[(i + 1) % 5];
            
            Garfo[] garfosDoFilosofo = filosofo.getGarfos();
            assertTrue(contemGarfo(garfosDoFilosofo, garfoEsquerdo));
            assertTrue(contemGarfo(garfosDoFilosofo, garfoDireito));
        }
    }

    @Test
    void testCadaGarfoCompartilhadoPorDoisFilosofos() {
        Filosofo[] filosofos = jantar.getFilosofos();
        Garfo[] garfos = jantar.getGarfos();
        
        for (Garfo garfo : garfos) {
            int count = 0;
            for (Filosofo filosofo : filosofos) {
                if (contemGarfo(filosofo.getGarfos(), garfo)) {
                    count++;
                }
            }
            assertEquals(2, count);
        }
    }

    @Test
    void testFilosofosTemIdsCorretos() {
        Filosofo[] filosofos = jantar.getFilosofos();
        for (int i = 0; i < filosofos.length; i++) {
            assertEquals(i, filosofos[i].getId());
        }
    }

    @Test
    void testGarfosTemIdsCorretos() {
        Garfo[] garfos = jantar.getGarfos();
        for (int i = 0; i < garfos.length; i++) {
            assertEquals(i, garfos[i].getId());
        }
    }

    @Test
    void testFilosofosComecamPensando() {
        Filosofo[] filosofos = jantar.getFilosofos();
        for (Filosofo filosofo : filosofos) {
            assertEquals("PENSANDO", filosofo.getEstado());
        }
    }

    @Test
    void testGarfosComecamDisponiveis() {
        Garfo[] garfos = jantar.getGarfos();
        for (Garfo garfo : garfos) {
            assertTrue(garfo.isDisponivel());
        }
    }

    private boolean contemGarfo(Garfo[] garfos, Garfo garfoProcurado) {
        for (Garfo garfo : garfos) {
            if (garfo == garfoProcurado) {
                return true;
            }
        }
        return false;
    }
}