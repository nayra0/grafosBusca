package br.com.algoritmobusca.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nayra
 */
public class No {

    String valor;
    boolean marcado = false;
    List<No> nosAdjacentes;

    public No() {
    }

    public No(String valor) {
        this.valor = valor;
        this.nosAdjacentes = new ArrayList<>();
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public List<No> getNosAdjacentes() {
        return nosAdjacentes;
    }

    public void setNosAdjacentes(List<No> nosAdjacentes) {
        this.nosAdjacentes = nosAdjacentes;
    }

    @Override
    public String toString() {
        return "No{" + "valor=" + valor + '}';
    }
}
