package br.com.senai.api.Services;

import br.com.senai.api.models.Produto;
import br.com.senai.api.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    //acessar repository
    @Autowired
    private ProdutoRepository repository;

    //listar todos os produtos
    public List<Produto> listarTodos(){
        return repository.findAll();
    }
    //encontrar um produto pelo id
    public Produto encontrarPorId(Long id){
        return repository.findById(id).orElse(null);

    }
    //salvar um produto
    public Produto salvar(Produto produto){
        return repository.save(produto);
    }
    //atualizar um produto
    public Produto atualizar(Produto produto, long id){
        produto.setId(id);
        return repository.save(produto);
    }
    //deletar um produto
    public void deletar(Long id){
        repository.deleteById(id);
    }
}