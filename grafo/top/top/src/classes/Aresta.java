package classes;

public class Aresta {
    

    public Aresta(int id, Vertice v1, Vertice v2) {
        this.v1 = v1;
        this.v2 = v2;
        this.id = id;
    }

    private int id;
    private Vertice v1;
    private Vertice v2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
