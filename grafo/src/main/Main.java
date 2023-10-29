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

        ArrayList<Vertice> v = g.vertices();

        g.insereA(v.get(0), v.get(1));
        g.insereA(v.get(0), v.get(2));
        g.insereA(v.get(1), v.get(2));
        g.insereA(v.get(0), v.get(3));

        System.out.println(g);

        g.printBuscaLargura(g, v.get(0));
        System.out.println("");
        g.buscaProfundidade(g, v.get(0));
        System.out.println("");

        g.imprimeCaminho(g, v.get(0), v.get(1));
        System.out.println("");

        if (g.fortementeConexo(g)) {
            System.out.println("Fortemente conexo");
        } else {
            System.out.println("Não é fortemente conexo");
        }

































    }

}
