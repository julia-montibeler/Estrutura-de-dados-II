package classes;

import java.util.HashMap;

public class Vertice {
    
    public Vertice(int id) {
        this.id = id;
    }

    private HashMap<Vertice, Aresta> arestas = new HashMap<>();
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Vertice, Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(HashMap<Vertice, Aresta> arestas) {
        this.arestas = arestas;
    }
    
}
