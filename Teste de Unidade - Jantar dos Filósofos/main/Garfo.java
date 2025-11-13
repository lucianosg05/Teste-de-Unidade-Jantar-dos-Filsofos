package main;

public class Garfo {
    private int id;
    private boolean disponivel;

    public Garfo(int id) {
        this.id = id;
        this.disponivel = true;
    }

    public int getId() {
        return id;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
}