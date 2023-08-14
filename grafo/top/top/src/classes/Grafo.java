package classes;

import java.util.ArrayList;

public class Grafo {

    public Grafo() {
    }

    private int contIdV = 0;
    private int contIdA = 0;

    private ArrayList<Vertice> vertices = new ArrayList<>();

    public int getOrdem() {

        return vertices.size();

    }

    public int getTamanho() {

        int cont = 0;

        for (Vertice v : vertices)
            cont += v.getArestas().size();
        
        return cont/2;

    }

    public ArrayList<Vertice> vertices() {

        return vertices;

    }

    public ArrayList<Aresta> arestas() {
        ArrayList<Integer> idArestas = new ArrayList<Integer>();
        ArrayList<Aresta> objAresta = new ArrayList<>();
        for (Vertice v : vertices) {
            for (Aresta a : v.getArestas().values()) {
                if (!(idArestas.contains(a.getId()))) {
                    idArestas.add(a.getId());
                    objAresta.add(a);
                }
            }
        }
        return objAresta;
    }

    public void insereV() {

        Vertice v = new Vertice(contIdV);
        contIdV++;
        
        vertices.add(v);

    }

    public void insereA (Vertice u, Vertice v) {
        Aresta aresta = new Aresta(contIdA, u, v);
        contIdA++;
        u.getArestas().put(v, aresta);
        v.getArestas().put(u, aresta);
    }

}
