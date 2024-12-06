package home.desafiopolvo.Controller;

import home.desafiopolvo.Usuario.DadosUsuarios;
import home.desafiopolvo.Usuario.ServiceUsuarios;
import home.desafiopolvo.Usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {
    @Autowired
    private ServiceUsuarios service;


    @PostMapping("/adicionar")
    public ResponseEntity<Usuario> adicionarUsuario(@RequestBody DadosUsuarios dadosUsuarios) {
        return service.adicionarUsuarios(dadosUsuarios);
    }


    @PutMapping("/atulizar/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody DadosUsuarios dadosUsuarios) {
        return service.atualizarUsuarios(id, dadosUsuarios);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        return service.deletarUsuarios(id);
    }


    @GetMapping("/buscar")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        return service.listarUsuarios();
    }
}
