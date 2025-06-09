package br.com.senai.api.Controller;

import br.com.senai.api.Services.ProdutoService;
import br.com.senai.api.models.Produto;
import jdk.jfr.Registered;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")

public class ProdutoController {
    @Autowired
    private ProdutoService service;

    //lista com todos os produtos do restaurante
    @GetMapping
    public List<Produto> listar(){
        return service.listarTodos();
    }

    //encontrar um produto pelo id
    @GetMapping("/{id}")
    public Produto encontrarPorId(@PathVariable Long id){
        return service.encontrarPorId(id);

    }
    //salvar um produto
    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        return service.salvar(produto);

    }
    //alterar um produto
    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id, @RequestBody Produto produto){
        produto.setId(id);
        return service.atualizar(produto ,id);

    }
    //deletar um produto pelo id
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);

    }



}
