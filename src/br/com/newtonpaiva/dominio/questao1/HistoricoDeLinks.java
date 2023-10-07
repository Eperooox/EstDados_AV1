package br.com.newtonpaiva.dominio.questao1;

import java.io.*;
import java.util.*;

class HistoricoDeLinks {
    private LinkedList<String> historico;

    public HistoricoDeLinks() {
        historico = new LinkedList<>();
    }

    public void carregarHistoricoDeArquivo(String caminhoArquivo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                historico.addFirst(linha);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar o histórico de arquivo.");
        }
    }

    public void mostrarHistorico() {
        for (String link : historico) {
            System.out.println(link);
        }
    }

    public void excluirLink(String link) {
        if (historico.contains(link)) {
            historico.remove(link);
            System.out.println("Link excluído com sucesso!");
        } else {
            System.out.println("Link inexistente no histórico.");
        }
    }

    public int quantidadeRegistros() {
        return historico.size();
    }

    public void consultarLink(String link) {
        if (historico.contains(link)) {
            System.out.println("Link Encontrado");
        } else {
            System.out.println("Link Não Encontrado");
        }
    }

    public static void main(String[] args) {
        HistoricoDeLinks historicoLinks = new HistoricoDeLinks();
        historicoLinks.carregarHistoricoDeArquivo("C:\\Users\\12117275\\Downloads\\AV1\\Lista_URL.txt");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nOpções:");
            System.out.println("1. Mostrar histórico");
            System.out.println("2. Excluir link");
            System.out.println("3. Mostrar quantidade de registros");
            System.out.println("4. Consultar link");
            System.out.println("5. Sair");

            String escolha = scanner.nextLine();

            switch (escolha) {
                case "1":
                    System.out.println("\nHistórico de links:");
                    historicoLinks.mostrarHistorico();
                    break;
                case "2":
                    System.out.print("Digite o link para exclusão: ");
                    String linkParaExcluir = scanner.nextLine();
                    historicoLinks.excluirLink(linkParaExcluir);
                    break;
                case "3":
                    System.out.println("Quantidade de registros: " + historicoLinks.quantidadeRegistros());
                    break;
                case "4":
                    System.out.print("Digite o link para consulta: ");
                    String linkParaConsulta = scanner.nextLine();
                    historicoLinks.consultarLink(linkParaConsulta);
                    break;
                case "5":
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}