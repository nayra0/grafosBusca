package br.com.algoritmobusca.principal;

import br.com.algoritmobusca.modelo.Grafo;
import br.com.algoritmobusca.modelo.No;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nayra
 */
public class BuscaLargura {

    public static void busca(Grafo gf, No raiz) {
        ArrayList<No> pilha = new ArrayList<No>();
        pilha.add(gf.getNos().get(raiz.getValor()));
        System.out.print(raiz.getValor() + " ");
        busca(pilha);
        System.out.println("");
    }

    public static void busca(List<No> pilha) {
        No raiz = pilha.get(0);
        raiz.setMarcado(true);
        pilha.remove(0);
        for (No nosAdjacente : raiz.getNosAdjacentes()) {
            if (!nosAdjacente.isMarcado()) {
                pilha.add(nosAdjacente);
                nosAdjacente.setMarcado(true);
                System.out.print(nosAdjacente.getValor() + " ");
            }
        }
        if (!pilha.isEmpty()) {
            busca(pilha);
        }

    }

}
