package br.com.algoritmobusca.principal;

import br.com.algoritmobusca.modelo.Grafo;
import br.com.algoritmobusca.modelo.No;
import java.util.List;

/**
 *
 * @author nayra
 */
public class BuscaProfundidade {

    public static void busca(Grafo g, No raiz) {
        raiz = g.getNos().get(raiz.getValor());
        buscaNo(raiz);
        System.out.println("");
    }

    public static void buscaNo(No raiz) {
        raiz.setMarcado(true);
        System.out.print(raiz.getValor() + " ");
        for (No nosAdjacente : raiz.getNosAdjacentes()) {
            if (!nosAdjacente.isMarcado()) {
                buscaNo(nosAdjacente);
            }
        }
    }

}
