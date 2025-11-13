package main;

public class Jantar {
    private Filosofo[] filosofos;
    private Garfo[] garfos;

    public void iniciar() {
        garfos = new Garfo[5];
        for (int i = 0; i < 5; i++) {
            garfos[i] = new Garfo(i);
        }
        
        filosofos = new Filosofo[5];
        for (int i = 0; i < 5; i++) {
            Garfo garfoEsquerdo = garfos[i];
            Garfo garfoDireito = garfos[(i + 1) % 5];
            filosofos[i] = new Filosofo(i, garfoEsquerdo, garfoDireito);
        }
    }

    public Filosofo[] getFilosofos() {
        return filosofos;
    }

    public Garfo[] getGarfos() {
        return garfos;
    }
}