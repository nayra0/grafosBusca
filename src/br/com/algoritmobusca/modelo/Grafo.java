package br.com.algoritmobusca.modelo;

import java.util.HashMap;
import java.util.List;

/**
 *
 * @author nayra
 */
public class Grafo {

    HashMap<String, No> nos;

    public Grafo() {
        this.nos = new HashMap();
    }

    public Grafo(int numVertices, int numArestas, List<No> nos) {
        this.nos = new HashMap();
    }

    public void adicionarAresta(String v, String w) {
        if (!this.nos.containsKey(v)) {
            this.nos.put(v, new No(v));
        }
        if (!this.nos.containsKey(w)) {
            this.nos.put(w, new No(w));
        }
        boolean exists = false;

        for (No nosAdjacente : this.nos.get(v).getNosAdjacentes()) {
            if (nosAdjacente.getValor().equals(w)) {
                exists = true;
            }
        }
        if (!exists) {
            this.nos.get(v).nosAdjacentes.add(this.nos.get(w));
            this.nos.get(w).nosAdjacentes.add(this.nos.get(v));
        }
    }

    public void printGrafo() {
        for (String vertices : this.nos.keySet()) {
            System.out.print(vertices + " : ");
            for (No no : this.nos.get(vertices).getNosAdjacentes()) {
                System.out.print("-> " + no.getValor());
            }
            System.out.println("");
        }
    }

    public void grausVertices() {
        for (String vertices : this.nos.keySet()) {
            System.out.println(vertices + " : " + this.nos.get(vertices).getNosAdjacentes().size());
        }
    }

    public HashMap<String, No> getNos() {
        return nos;
    }

    public void setNos(HashMap<String, No> nos) {
        this.nos = nos;
    }

    public void reset() {
        for (String string : this.nos.keySet()) {
            this.nos.get(string).setMarcado(false);
        }
    }

}
