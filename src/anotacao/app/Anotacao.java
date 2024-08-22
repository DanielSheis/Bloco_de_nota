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
            System.out.print("[1] - Criar nova nota\n[2] - Visualizar nota\n[3] - Alterar nota\n[4] - Deletar nota\n> ");
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
            else if (selecao == 3) {
                System.out.println("\nDigite o ID da nota:");
                int idNota = scanner.nextInt();
                scanner.nextLine();

                alterarNota(idNota);
            }
            else if (selecao == 4) {
                System.out.println("\nDigite o ID da nota:");
                int idNota = scanner.nextInt();

                notasFeitas -= deletarNota(idNota);
            }

            System.out.println("\nDigite [ 9 ] para sair, digite [ 1 ] para continuar: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Captura o enter e evita dar um input fantasma
            System.out.println();

        } while(opcao != 9);

        System.out.println("Saindo....");
    }

    public static void gerarNota(int idNota, String tituloNota, String conteudoNota) {
        Anotacao.Nota[idNota] = new Nota(idNota, tituloNota, conteudoNota);
    }

    public static void visualizarNota(int idNota) {
        if (idNota == 0) {
            int i = 1;
            while (Nota[i] != null) {
                Nota[i].imprimirNota();

                i++;

            }

            return;
        }

        if (Nota[idNota] == null) {
            System.out.println("\n ~ Essa nota não existe! ~");
            return;
        }

        Nota[idNota].imprimirNota();
    }

    public static void alterarNota(int idNota) {
        String novoTituloNota;
        String novoConteudoNota;

        if (Anotacao.Nota[idNota] == null) {
            System.out.println("\n ~ Essa nota não existe! ~ ");
            return;
        }

        do {
            System.out.println("\nTitulo da Nota:");
            novoTituloNota = scanner.nextLine();

            System.out.println("Digite o contéudo:");
            novoConteudoNota = scanner.nextLine();

        } while(novoTituloNota == null || novoConteudoNota == null);

        Anotacao.Nota[idNota] = new Nota(idNota, novoTituloNota, novoConteudoNota);
    }

    public static int deletarNota(int idNota) {
        if (Anotacao.Nota[idNota] == null) {
            System.out.println("\n ~ Essa nota não existe! ~ ");
            return 0;
        }
        if (Anotacao.Nota[idNota + 1] == null) {
            if (Anotacao.Nota[idNota] == Anotacao.Nota[1]) {
                Anotacao.Nota[idNota] = null;
                return 0;
            }

            Anotacao.Nota[idNota] = null;
            return 1;
        }

        int tempIdNota = idNota;
        for (int i = 1; i < Anotacao.Nota.length; i++) {
            if (Anotacao.Nota[tempIdNota + 1] == null) {
                Anotacao.Nota[tempIdNota] = null;
                break;
            }
            Anotacao.Nota[tempIdNota].setTituloNota(Anotacao.Nota[tempIdNota + 1].getTituloNota());
            Anotacao.Nota[tempIdNota].setConteudoNota(Anotacao.Nota[tempIdNota + 1].getConteudoNota());
            tempIdNota++;
        }

        return 1;
    }
}
