package classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Vertice {
    
    public Vertice(int id) {
        this.id = id;
    }

    private HashMap<Vertice, Aresta> arestas = new HashMap<>();
    private int id;
    private int estado;
    private int d;

    private int ta;
    private int te;
    private Vertice p;

    public ArrayList<Vertice> adjacentes () {
        ArrayList<Vertice> adj = new ArrayList<>();
        for (Vertice v : arestas.keySet()) {
            adj.add(v);
        }

        return adj;
    }

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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }    

    public Vertice getP() {
        return p;
    }

    public void setP(Vertice v) {
        this.p = v;
    }

    public int getTa() {
        return ta;
    }

    public void setTa(int ta) {
        this.ta = ta;
    }

    public int getTe() {
        return te;
    }

    public void setTe(int te) {
        this.te = te;
    }
}
