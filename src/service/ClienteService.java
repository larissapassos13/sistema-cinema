package service;

import repository.ClienteRepository;
import model.Cliente;

import java.util.List;

public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void cadastrarCliente(String nome, String cpf) {
        if (repository.buscarCliente(cpf) != null) {
            // se o repository achar um cliente com esse cpf ele retorna um objeto diferente de null
            System.out.println("Cliente ja existente");
            return; // para a execução
        }
        Cliente cliente = new Cliente(nome, cpf);

        repository.adicionar(cliente);

    }

    public List<Cliente> listarClientes(){
        return repository.listar();
    }

    public Cliente buscarCliente(String cpf){
        return repository.buscarCliente(cpf);
    }
}
