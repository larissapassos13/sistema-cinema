package system;

import model.*;
import service.FilmeService;
import service.IngressoService;
import service.SessaoService;
import service.ClienteService;
import repository.ClienteRepository;
import repository.IngressoRepository;
import repository.SessaoRepository;

import java.util.Scanner;

public class SistemaCinema {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // cria um obj de cada repository
        ClienteRepository clienteRepository = new ClienteRepository();
        SessaoRepository sessaoRepository = new SessaoRepository();
        IngressoRepository ingressoRepository = new IngressoRepository();

        FilmeService service = new FilmeService();

        SessaoService sessaoService =
                new SessaoService(sessaoRepository);

        ClienteService clienteService =
                new ClienteService(clienteRepository);

        IngressoService ingressoService =
                new IngressoService(
                        ingressoRepository,
                        clienteRepository,
                        sessaoRepository
                );

        while (true) {
            System.out.println("1 - Cadastrar filme\n" +
                    "2 - Listar filmes\n" +
                    "3 - Cadastrar sessão\n" +
                    "4 - Listar sessões\n" +
                    "5 - Cadastrar cliente\n" +
                    "6 - Listar clientes\n" +
                    "7 - Comprar ingresso\n" +
                    "8 - Consultar ingressos\n" +
                    "9 - Cancelar ingresso\n" +
                    "10 - Sair\n" +
                    "Digite uma opção: ");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();

                    System.out.println("Digite o título: ");
                    String titulo = scanner.nextLine();

                    System.out.println("Digite a duração do filme em minutos: ");
                    int duracao = scanner.nextInt();

                    System.out.println("Digite o gênero: ");
                    scanner.nextLine();
                    String genero = scanner.nextLine();

                    System.out.println("Escolha a classificação indicativa:");
                    System.out.println("1 - Livre");
                    System.out.println("2 - 10 anos");
                    System.out.println("3 - 12 anos");
                    System.out.println("4 - 14 anos");
                    System.out.println("5 - 16 anos");
                    System.out.println("6 - 18 anos");
                    System.out.println("Digite uma opção: ");
                    int opcaoClassificacao = scanner.nextInt();

                    ClassificacaoIndicativa classificacao = null;

                    switch (opcaoClassificacao) {
                        case 1:
                            classificacao = ClassificacaoIndicativa.LIVRE;
                            break;
                        case 2:
                            classificacao = ClassificacaoIndicativa.DEZ;
                            break;
                        case 3:
                            classificacao = ClassificacaoIndicativa.DOZE;
                            break;
                        case 4:
                            classificacao = ClassificacaoIndicativa.QUATORZE;
                            break;
                        case 5:
                            classificacao = ClassificacaoIndicativa.DEZESSEIS;
                            break;
                        case 6:
                            classificacao = ClassificacaoIndicativa.DEZOITO;
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }

                    if (classificacao == null) {
                        break;
                    }

                    service.cadastrarFilme(
                            titulo,
                            duracao,
                            genero,
                            classificacao
                    );

                    System.out.println("Filme cadastrado com sucesso!");
                    break;

                case 2:
                    for (Filme filme : service.listarFilmes()) {
                        System.out.println("ID: " + filme.getId());
                        System.out.println("Título: " + filme.getTitulo());
                        System.out.println("Duração: " + filme.getDuracao() + " minutos");
                        System.out.println("Gênero: " + filme.getGenero());
                        System.out.println("Classificação: " + filme.getClassificacaoIndicativa());
                        System.out.println("-------------------------");
                    }
                    break;

                case 3:
                    for (Filme filme : service.listarFilmes()) {
                        System.out.println("ID: " + filme.getId());
                        System.out.println("Título: " + filme.getTitulo());
                    }

                    System.out.println("Digite o ID do filme: ");
                    int idFilme = scanner.nextInt();

                    Filme filmeID = service.buscarFilme(idFilme);

                    if (filmeID == null) {
                        System.out.println("Filme não encontrado!");
                        break;
                    }

                    System.out.println("Digite o horário da sessão: ");
                    scanner.nextLine();
                    String horario = scanner.nextLine();

                    System.out.println("Digite a sala da sessão: ");
                    int sala = scanner.nextInt();

                    System.out.println("Digite a capacidade da sala: ");
                    int capacidade = scanner.nextInt();

                    sessaoService.cadastrarSessao(filmeID, horario, sala, capacidade);

                    System.out.println("Sessão cadastrada com sucesso!");
                    break;

                case 4:
                    for (Sessao sessao : sessaoService.listarSessoes()) {
                        System.out.println("ID da sessão: " + sessao.getId());
                        System.out.println("Título: " + sessao.getFilme().getTitulo());
                        System.out.println("Horário: " + sessao.getHorario());
                        System.out.println("Sala: " + sessao.getSala());
                        System.out.println("Capacidade: " + sessao.getCapacidade());
                        System.out.println("-------------------------");
                    }
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.println("Digite o nome do cliente: ");
                    String nomeCliente = scanner.nextLine();

                    System.out.println("Digite o CPF do cliente: ");
                    String cpfCliente = scanner.nextLine();

                    clienteService.cadastrarCliente(nomeCliente, cpfCliente);

                    break;

                case 6:
                    for (Cliente cliente : clienteService.listarClientes()) {
                        System.out.println("Nome: " + cliente.getNome());
                        System.out.println("CPF: " + cliente.getCpf());
                        System.out.println("-------------------------");
                    }
                    break;

                case 7:
                    for (Sessao sessao : sessaoService.listarSessoes()) {
                        System.out.println("ID da sessão: " + sessao.getId());
                        System.out.println("Filme: " + sessao.getFilme().getTitulo());
                        System.out.println("Horário: " + sessao.getHorario());
                        System.out.println("Sala: " + sessao.getSala());
                        System.out.println("-------------------------");
                    }

                    scanner.nextLine();

                    System.out.println("Digite seu CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.println("Digite o ID da sessão: ");
                    int idSessao = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Escolha o tipo de ingresso:");
                    System.out.println("1 - Normal");
                    System.out.println("2 - Meia");
                    int opcaoTipo = scanner.nextInt();

                    TipoIngresso tipo = null;

                    switch (opcaoTipo) {
                        case 1:
                            tipo = TipoIngresso.NORMAL;
                            break;
                        case 2:
                            tipo = TipoIngresso.MEIA;
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }

                    if (tipo == null) {
                        break;
                    }

                    System.out.println("Digite a quantidade de ingressos que deseja comprar: ");
                    int quantidade = scanner.nextInt();

                    ingressoService.comprarIngresso(cpf, idSessao, tipo,quantidade);
                    break;

                case 8:
                    for (Ingresso ingresso : ingressoService.listarIngressos()) {
                        System.out.println("ID do ingresso: " + ingresso.getId());
                        System.out.println("Cliente: " + ingresso.getCliente().getNome());
                        System.out.println("CPF: " + ingresso.getCliente().getCpf());
                        System.out.println("Filme: " + ingresso.getSessao().getFilme().getTitulo());
                        System.out.println("Sessão: " + ingresso.getSessao().getId());
                        System.out.println("Horário: " + ingresso.getSessao().getHorario());
                        System.out.println("Sala: " + ingresso.getSessao().getSala());
                        System.out.println("Tipo: " + ingresso.getTipoIngresso());
                        System.out.println("-------------------------");
                    }
                    break;

                case 9:
                    for (Ingresso ingresso : ingressoService.listarIngressos()) {
                        System.out.println("ID do ingresso: " + ingresso.getId());
                        System.out.println("Cliente: " + ingresso.getCliente().getNome());
                        System.out.println("Filme: " + ingresso.getSessao().getFilme().getTitulo());
                        System.out.println("Horário: " + ingresso.getSessao().getHorario());
                        System.out.println("-------------------------");
                    }

                    System.out.println("Digite o ID do ingresso que você deseja cancelar: ");
                    int idIngresso = scanner.nextInt();

                    ingressoService.cancelarIngresso(idIngresso);
                    break;

                case 10:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
