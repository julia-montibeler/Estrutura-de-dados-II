package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Grafo {

    public Grafo() {
    }

    private int contIdV = 0;
    private int contIdA = 0;

    private int tempP = 0;

    private ArrayList<Vertice> vertices = new ArrayList<>();

    public int getOrdem() {

        return vertices.size();

    }

    public String toString() {
        ArrayList<Aresta> arestas = this.arestas();
        String grafot = "";
        for (Aresta a : arestas) {
            grafot += a.getV1().getId() + " - " + a.getV2().getId() + "\n";
        }
        return grafot;
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

    public int[][] matriz() {
        int[][] m = new int[getOrdem()][getOrdem()];
        for (Vertice v : vertices) {
            for (Vertice w : vertices) {
                if (v == w) {
                    m[v.getId()][w.getId()] = 0;
                }
                else if (v.getArestas().containsKey(w)) {
                    m[v.getId()][w.getId()] = v.getArestas().get(w).getCusto();
                } else {
                    m[v.getId()][w.getId()] = Integer.MAX_VALUE;
                }
            }
        }
        return m;
    }

    public void prim(Vertice r) {
        ArrayList<Vertice> arvore = new ArrayList<>();
        int[][] valores = matriz();
        for (Vertice v : vertices) {
            v.setP(null);
            v.setChave(Integer.MAX_VALUE);
        }
        r.setChave(0);
        ArrayList<Vertice> q = vertices;
        while (!q.isEmpty()) {
            Vertice u = removeMin(q);
            arvore.add(u);
            for (Vertice v : adj(u)) {
                if (q.contains(v) && valores[u.getId()][v.getId()] < v.getChave()) {
                    v.setP(u);
                    v.setChave(valores[u.getId()][v.getId()]);
                }
            }
        }
        for (Vertice v : arvore) {
            System.out.println(v.getId());
        }
    }

    public void djikstra(Vertice i) {
        int valor = 0;
        int[][] matriz = matriz();
        for (Vertice v : vertices) {
            v.setChave(Integer.MAX_VALUE);
            v.setP(null);
        }
        i.setChave(0);
        ArrayList<Vertice> s = new ArrayList<>();
        ArrayList<Vertice> q = vertices;
        while (!q.isEmpty()) {
            Vertice u = removeMin(q);
            s.add(u);
            for (Vertice v : adj(u)) {
                if (q.contains(v) && v.getChave() > (u.getChave() + matriz[u.getId()][v.getId()])) {
                    v.setChave(u.getChave() + matriz[u.getId()][v.getId()]);
                    v.setP(u);
                }
            }
        }
        for (Vertice v : s) {
            System.out.println(v.getId());
        }
    }

    private Vertice removeMin(ArrayList<Vertice> vertices) {
        int c = Integer.MAX_VALUE;
        Vertice min = null;
        for (Vertice v : vertices) {
            if (v.getChave() < c) {
                c = v.getChave();
                min = v;
            }
        }
        vertices.remove(min);
        return min;
    }

    public void insereV() {

        Vertice v = new Vertice(contIdV);
        contIdV++;
        
        vertices.add(v);

    }

    public void removeV(Vertice v) {
        for (Vertice u : vertices) {
            u.getArestas().remove(v);
        }
        vertices.remove(v);
    }

    public void insereA (Vertice u, Vertice v, int valor) {
        Aresta aresta = new Aresta(contIdA, u, v, valor);
        contIdA++;
        u.getArestas().put(v, aresta);
        v.getArestas().put(u, aresta);
    }

    public void removeA(Aresta a) {
        a.getV1().getArestas().remove(a.getV2());
        a.getV2().getArestas().remove(a.getV1());
    }

    public ArrayList<Vertice> adj (Vertice v) {
        ArrayList<Vertice> va = new ArrayList<>();
        for (Vertice u: vertices) {
            if (u.getArestas().containsKey(v)) {
                va.add(u);
            }
        }
        return va;
    }

    public Aresta getA(Vertice u, Vertice v) {
        if (u.getArestas().containsKey(v)) {
            return u.getArestas().get(v);
        }
        return null;
    }

    public int grau (Vertice v) {
        return v.getArestas().size();
    }

    public Vertice[] verticesA(Aresta a) {
        Vertice[] va = new Vertice[2];
        va[0] = a.getV1();
        va[1] = a.getV2();

        return va;
    }

    public Vertice oposto(Vertice u, Aresta a) {
        if ((u.getArestas().containsValue(a))) {
            return null;
        }

        if (a.getV1() == u) {
            return a.getV2();
        }
        return a.getV1();
    }

    public void buscaLargura(Grafo g, Vertice i) {
        for (Vertice v : vertices) {
            v.setEstado(0);
            v.setP(null);
            v.setD(Integer.MAX_VALUE);
        }

        i.setD(0);
        i.setEstado(1);
        Queue<Vertice> f = new LinkedList<>();
        f.add(i);

        while (!f.isEmpty()) {
            Vertice v = f.remove();
            ArrayList<Vertice> adj = v.adjacentes();
            for (Vertice a : adj) {
                if (a.getEstado() == 0) {
                    f.add(a);
                    a.setEstado(1);
                    a.setP(v);
                    a.setD(v.getD() + 1);
                }
            }
            v.setEstado(2);
        }
    }

    public void printBuscaLargura(Grafo g, Vertice i) {
        buscaLargura(g, i);
        for (Vertice v : g.vertices) {
            if (v.getP() == null) {
                System.out.println("p("+v.getId()+") = null");
            } else {
                System.out.println("p("+v.getId()+") = " + v.getP().getId());
            }
        }
    }

    public void buscaProfundidade(Grafo g, Vertice i) {
        for (Vertice v : g.vertices) {
            v.setEstado(0);
            v.setP(null);
        }
        tempP = 0;
        System.out.println("p("+i.getId()+") = null");
        buscaProfundidadeRec(i);
    }

    private void buscaProfundidadeRec(Vertice i) {
        i.setEstado(1);
        tempP ++;
        i.setTa(tempP);
        for (Vertice a : i.adjacentes()) {
            if (a.getEstado() == 0) {
                a.setP(i);
                System.out.println("p("+a.getId()+") = " + a.getP().getId());
                buscaProfundidadeRec(a);
            }
        }
        i.setEstado(2);
        tempP++;
        i.setTe(tempP);
    }

    public void imprimeCaminho (Grafo g, Vertice v1, Vertice v2) {
        g.buscaLargura(g, v1);

        System.out.println("\nCaminho: ");
        imprimeCaminhoRec(v1, v2);
    }

    private void imprimeCaminhoRec(Vertice v1, Vertice v2) {
        if (v1 == v2) {
            System.out.println(v1.getId());
        }
        else if (v2.getP() == null) {
            System.out.println("Não existe caminho de v1 para v2");
        }
        else {
            imprimeCaminhoRec(v1, v2.getP());
            System.out.println(v2.getId());
        }
    }

    public ArrayList<Vertice> achaCaminho (Grafo g, Vertice v1, Vertice v2) {
        g.buscaLargura(g, v1);
        ArrayList<Vertice> caminho = new ArrayList<>();

        achaCaminhoRec(caminho, v1, v2);
        return caminho;
    }

    private void achaCaminhoRec(ArrayList<Vertice> caminho, Vertice v1, Vertice v2) {
        if (v1 == v2) {
            caminho.add(v1);
        }
        else if (!(v2.getP() == null)){
            achaCaminhoRec(caminho, v1, v2.getP());
            caminho.add(v2);
        }
    }

    public boolean fortementeConexo(Grafo g) {
        for (Vertice v : g.vertices) {
            for (Vertice v2 : g.vertices) {
                ArrayList<Vertice> a = achaCaminho(g, v, v2);
                if (a.size() > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
