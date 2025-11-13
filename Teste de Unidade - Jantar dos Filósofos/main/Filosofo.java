package main;

public class Filosofo {
    private int id;
    private Garfo garfoEsquerdo;
    private Garfo garfoDireito;
    private String estado;

    public Filosofo(int id, Garfo garfoEsquerdo, Garfo garfoDireito) {
        this.id = id;
        this.garfoEsquerdo = garfoEsquerdo;
        this.garfoDireito = garfoDireito;
        this.estado = "PENSANDO";
    }

    public int getId() {
        return id;
    }

    public Garfo[] getGarfos() {
        return new Garfo[]{garfoEsquerdo, garfoDireito};
    }

    public String getEstado() {
        return estado;
    }
}