package br.com.meteora.api.controller;

import org.springframework.web.bind.annotation.*;
import br.com.meteora.api.model.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
        
    @PostMapping("/cadastrar")
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadatroUsuario dados){
        repository.save(new UsuarioModel(dados));
    }

    @GetMapping("/listar")
    public List<UsuarioModel> lista(){
        return repository.findAll();
    }

    @PutMapping 
    @Transactional
    public void Atualizar(@RequestBody DadosAtualizarUsuario dados){
        UsuarioModel usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id ){
        repository.deleteById(id);

    }
}
