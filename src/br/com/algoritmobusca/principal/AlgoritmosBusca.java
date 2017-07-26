package br.com.algoritmobusca.principal;

import br.com.algoritmobusca.modelo.Grafo;
import br.com.algoritmobusca.modelo.No;
import java.util.Scanner;

/**
 *
 * @author nayra
 */
public class AlgoritmosBusca {

    private static final double NANOSECONDS = 1000000000.0;
    private static long tempoInicio;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Executar grafos de exemplo? Sim(s) ou N(n)");
        Scanner s = new Scanner(System.in);
        String op = s.nextLine();

        if (op.equals("s")) {
            buscaG4();
            buscaG8();
            buscaG12();
            buscaG16();
        } else if (op.equals("n")) {
            System.out.println("Inserir grafo manualmente? Sim(s) ou N(n)");
            if (s.nextLine().equals("s")) {
                System.out.print("Digite a quantidade de vertices:");
                Integer qtd = Integer.valueOf(s.nextLine());

                Grafo gf = new Grafo();

                System.out.println("Insira os dados seguindo este padrão: \n"
                        + "1>2:3 - Onde 1 é o vertice e 2 e 3 são vertices adjacentes a 1");
                for (int i = 0; i < qtd; i++) {
                    String st = s.nextLine();
                    String[] v = st.split(">");
                    String[] va = st.replace(v[0] + ">", "").split(":");
                    for (String string : va) {
                        gf.adicionarAresta(v[0], string);
                    }
                }

                System.out.print("Digite o vertice raiz da busca: ");
                String st = s.nextLine();

                System.out.println("Busca em Largura");
                startTimer();
                BuscaLargura.busca(gf, new No(st));
                printTimer();
                gf.reset();
                System.out.println("Busca em Profundidade");
                startTimer();
                BuscaProfundidade.busca(gf, new No(st));
                printTimer();
                gf.printGrafo();
            }
        }
        System.out.println("Bye!");

    }

    private static void buscaG4() {
        Grafo g4 = grafo4();
        g4.printGrafo();
        System.out.println("Busca Largura");
        startTimer();
        BuscaLargura.busca(g4, new No("1"));
        printTimer();
        g4.reset();
        System.out.println("Busca Profundidade");
        startTimer();
        BuscaProfundidade.busca(g4, new No("1"));
        printTimer();
        g4.grausVertices();
        System.out.println("-----------------------------------------");
    }

    private static void buscaG8() {
        Grafo g8 = grafo8();
        g8.printGrafo();
        System.out.println("Busca Largura");
        startTimer();
        BuscaLargura.busca(g8, new No("1"));
        printTimer();
        g8.reset();
        System.out.println("Busca Profundidade");
        startTimer();
        BuscaProfundidade.busca(g8, new No("1"));
        printTimer();
        g8.grausVertices();
        System.out.println("-----------------------------------------");
    }

    private static void buscaG12() {
        Grafo g12 = grafo12();
        g12.printGrafo();
        System.out.println("Busca Largura");
        startTimer();
        BuscaLargura.busca(g12, new No("1"));
        printTimer();
        g12.reset();
        System.out.println("Busca Profundidade");
        startTimer();
        BuscaProfundidade.busca(g12, new No("1"));
        printTimer();
        g12.grausVertices();
        System.out.println("-----------------------------------------");
    }

    private static void buscaG16() {
        Grafo g16 = grafo16();
        g16.printGrafo();
        System.out.println("Busca Largura");
        startTimer();
        BuscaLargura.busca(g16, new No("1"));
        printTimer();
        g16.reset();
        System.out.println("Busca Profundidade");
        startTimer();
        BuscaProfundidade.busca(g16, new No("1"));
        printTimer();
        g16.grausVertices();
        System.out.println("-----------------------------------------");
    }

    public static void startTimer() {
        tempoInicio = System.nanoTime();
    }

    public static void printTimer() {
        System.out.printf("%f segundos\n", (double) (System.nanoTime() - tempoInicio) / NANOSECONDS);
    }

    private static Grafo grafo4() {
        Grafo g4 = new Grafo();
        g4.adicionarAresta("1", "2");
        g4.adicionarAresta("2", "3");
        g4.adicionarAresta("2", "4");
        g4.adicionarAresta("1", "3");
        g4.adicionarAresta("3", "4");
        return g4;
    }

    private static Grafo grafo8() {
        Grafo g8 = new Grafo();
        g8.adicionarAresta("1", "2");
        g8.adicionarAresta("1", "3");
        g8.adicionarAresta("2", "4");
        g8.adicionarAresta("2", "5");
        g8.adicionarAresta("3", "6");
        g8.adicionarAresta("4", "7");
        g8.adicionarAresta("5", "7");
        g8.adicionarAresta("5", "8");
        g8.adicionarAresta("6", "8");
        return g8;
    }

    private static Grafo grafo12() {
        Grafo g8 = new Grafo();
        g8.adicionarAresta("1", "2");
        g8.adicionarAresta("1", "3");
        g8.adicionarAresta("3", "4");
        g8.adicionarAresta("3", "5");
        g8.adicionarAresta("3", "7");
        g8.adicionarAresta("4", "6");
        g8.adicionarAresta("5", "10");
        g8.adicionarAresta("6", "9");
        g8.adicionarAresta("7", "8");
        g8.adicionarAresta("8", "9");
        g8.adicionarAresta("8", "10");
        g8.adicionarAresta("8", "12");
        g8.adicionarAresta("11", "12");
        return g8;
    }

    private static Grafo grafo16() {
        Grafo g8 = new Grafo();
        g8.adicionarAresta("1", "10");
        g8.adicionarAresta("2", "3");
        g8.adicionarAresta("2", "5");
        g8.adicionarAresta("2", "8");
        g8.adicionarAresta("3", "10");
        g8.adicionarAresta("4", "5");
        g8.adicionarAresta("4", "8");
        g8.adicionarAresta("4", "11");
        g8.adicionarAresta("4", "12");
        g8.adicionarAresta("4", "13");
        g8.adicionarAresta("6", "10");
        g8.adicionarAresta("7", "10");
        g8.adicionarAresta("9", "12");
        g8.adicionarAresta("9", "15");
        g8.adicionarAresta("11", "14");
        g8.adicionarAresta("12", "16");
        g8.adicionarAresta("15", "16");
        return g8;
    }

}
