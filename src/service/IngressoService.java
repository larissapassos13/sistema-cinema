package service;

import model.Cliente;
import model.Ingresso;
import model.Sessao;
import model.TipoIngresso;
import repository.ClienteRepository;
import repository.IngressoRepository;
import repository.SessaoRepository;

import java.util.List;


public class IngressoService {

    // entrega ao service os repositories q ele precisa

    private IngressoRepository ingressoRepository;
    private ClienteRepository clienteRepository;
    private SessaoRepository sessaoRepository;

    public IngressoService(
            IngressoRepository ingressoRepository,
            ClienteRepository clienteRepository,
            SessaoRepository sessaoRepository) {

        this.ingressoRepository = ingressoRepository;
        this.clienteRepository = clienteRepository;
        this.sessaoRepository = sessaoRepository;
    }

    private int proximoId = 1;

    public void comprarIngresso(String cpf, int idSessao, TipoIngresso tipo, int quantidade) {

        if (quantidade <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
            return;
        }

        Cliente cliente = clienteRepository.buscarCliente(cpf);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Sessao sessao = sessaoRepository.buscarSessao(idSessao);

        if (sessao == null) {
            System.out.println("Sessão não encontrada.");
            return;
        }

        int ingressosOcupados = ingressoRepository.contarPorSessao(idSessao);

        if (ingressosOcupados + quantidade > sessao.getCapacidade()) {
            System.out.println("Não há ingressos suficientes para essa quantidade.");
            return;
        }

        for (int i = 0; i < quantidade; i++) {
            Ingresso ingresso = new Ingresso(proximoId, tipo, cliente, sessao);
            ingressoRepository.adicionar(ingresso);
            proximoId++;
        }

        System.out.println("Ingresso comprado com sucesso!");
    }

    public List<Ingresso> listarIngressos() {
        return ingressoRepository.listar();
    }

    public void cancelarIngresso(int id) {
        Ingresso ingresso = ingressoRepository.buscarIngresso(id);

        if (ingresso == null) {
            System.out.println("Ingresso não encontrado.");
            return;
        }

        ingressoRepository.remover(ingresso);
        System.out.println("Ingresso removido com sucesso!");
    }
}
