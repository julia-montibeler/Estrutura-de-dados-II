package main;

import classes.Aresta;
import classes.Grafo;
import java.util.ArrayList;
import classes.Vertice;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();
        g.insereV();
        g.insereV();
        g.insereV();
        g.insereV();
        g.insereV();

        ArrayList<Vertice> v = g.vertices();

        g.insereA(v.get(0), v.get(1), 5);
        g.insereA(v.get(0), v.get(4), 1);
        g.insereA(v.get(1), v.get(4), 3);
        g.insereA(v.get(1), v.get(2), 3);
        g.insereA(v.get(2), v.get(3), 2);
        g.insereA(v.get(3), v.get(4), 4);

        g.prim(v.get(0));

        Grafo h = new Grafo();
        h.insereV();
        h.insereV();
        h.insereV();

        ArrayList<Vertice> u = h.vertices();

        h.insereA(u.get(0), u.get(1), 5);
        h.insereA(u.get(0), u.get(2), 2);
        h.insereA(u.get(1), u.get(2), 1);

        System.out.println("");
        h.djikstra(u.get(0));

































    }

}
