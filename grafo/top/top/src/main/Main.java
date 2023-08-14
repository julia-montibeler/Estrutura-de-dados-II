package main;

import classes.Grafo;
import java.util.ArrayList;
import classes.Vertice;

public class Main {
    public static void main(String[] args) {
        Grafo g = new Grafo();
        g.insereV();
        g.insereV();
        ArrayList<Vertice> v = g.vertices();

        System.out.println(v.get(0).getId() + " " + v.get(1).getId());

        g.insereA(v.get(0), v.get(1));

    }

}
