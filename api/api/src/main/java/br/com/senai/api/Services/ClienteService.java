package br.com.senai.api.Services;

import br.com.senai.api.models.Cliente;
import br.com.senai.api.repositorys.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    //listar todos os clientes
    public List<Cliente> listarTodos(){
        return repository.findAll();
    }
    //encontrar um cliente pelo id
    public Cliente encontrarPorId(Long id){
        return repository.findById(id).orElse(null);

    }
    //salvar um cliente
    public Cliente salvar(Cliente cliente){
        return repository.save(cliente);
    }
    //atualizar um cliente
    public Cliente atualizar(Cliente cliente, long id){
        cliente.setId(id);
        return repository.save(cliente);
    }
    //deletar um cliente
    public void deletar(Long id){
        repository.deleteById(id);
    }

    public Cliente atualizar(Cliente cliente) {
         return repository.save(cliente);
    }
}