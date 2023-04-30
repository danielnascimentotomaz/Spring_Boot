package api.segunda.api.segunda.api.controller;

import api.segunda.api.segunda.api.repository.UsuarioRepository;
import api.segunda.api.segunda.api.models.UsuarioModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping(value = "/ListaUsuarioCadrastrado")
    public List<UsuarioModels> getUsuario(){
        return usuarioRepository.findAll();
    }

    @PostMapping(value = "/cadrastrar")
    public UsuarioModels setUsuario(@RequestBody UsuarioModels usuarioModels){
        return  usuarioRepository.save(usuarioModels);
    }

    @DeleteMapping("/Deletar/{id}")
    public void delete(@PathVariable Integer id){
        usuarioRepository.deleteById(id);

    }


}
