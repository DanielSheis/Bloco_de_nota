package anotacao.app;

import anotacao.domain.Nota;

import java.util.Scanner;

public class Anotacao {

    private static final int LIMITE_DE_NOTAS = 100;
    private static final Nota[] Nota = new Nota[Anotacao.LIMITE_DE_NOTAS];
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String tituloNota;
        String conteudoNota;
        int notasFeitas = 1;
        int opcao;

        do {
            System.out.print("[1] - Criar nova nota\n[2] - Visualizar nota\n> ");
            int selecao = scanner.nextInt();
            scanner.nextLine(); // Captura o enter e evita dar um input fantasma

            if (selecao == 1) {
                do {
                    System.out.println("\nTitulo da Nota:");
                    tituloNota = scanner.nextLine();

                    System.out.println("Digite o contéudo:");
                    conteudoNota = scanner.nextLine();

                    gerarNota(notasFeitas, tituloNota, conteudoNota);

                    notasFeitas++;

                } while(tituloNota == null || conteudoNota == null);
            }
            else if (selecao == 2) {
                System.out.println("\nDigite o ID da nota:");
                int idNota = scanner.nextInt();

                visualizarNota(idNota);
            }

            System.out.println("\nDigite 1 para sair, se não digite 2: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Captura o enter e evita dar um input fantasma
            System.out.println();

        } while(opcao != 1);

        System.out.println("Saindo....");
    }

    public static void gerarNota(int idNota, String tituloNota, String conteudoNota) {
        Anotacao.Nota[idNota] = new Nota(idNota, tituloNota, conteudoNota);
    }

    public static void visualizarNota(int idNota) {
        if (Nota[idNota] == null) {
            System.out.println("\n ~ Essa nota não existe! ~");
            return;
        }

        Nota[idNota].imprimirNota();
    }
}
