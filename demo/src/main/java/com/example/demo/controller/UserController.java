package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> listarUsuarios() {
        return service.listarUsuarios();
    }

    @PostMapping("/users")
    public ResponseEntity<?> receberUsuario(@RequestBody User user) {
        List<String> erros = new ArrayList<>();

        if (!service.isNomeValido(user)) {
            erros.add(service.mensagemErroNome(user));
        }
        if (!service.isEmailValido(user)) {
            erros.add(service.mensagemErroEmail(user));
        }
        if (!service.isSenhaValida(user)) {
            erros.add(service.mensagemErroSenha(user));
        }

        if (!erros.isEmpty()) {
            return ResponseEntity.badRequest().body(erros);
        }

        service.salvarUsuario(user);
        return ResponseEntity.status(201).body("Usuário salvo com sucesso!");
    }

    @PutMapping("/users/{email}")
    public ResponseEntity<String> atualizarUsuario(
            @PathVariable String email,
            @RequestBody User userAtualizado) {

        boolean atualizado = service.atualizarUsuario(email, userAtualizado);

        if (atualizado) {
            return ResponseEntity.ok("Usuário atualizado com sucesso!");
        } else {
            return ResponseEntity.status(404).body("Usuário não encontrado.");
        }
    }

    @DeleteMapping("/users/{email}")
    public ResponseEntity<String> deletarUsuario(@PathVariable String email) {
        boolean deletado = service.deletarUsuario(email);

        if (deletado) {
            return ResponseEntity.ok("Usuário deletado com sucesso!");
        } else {
            return ResponseEntity.status(404).body("Usuário não encontrado.");
        }
    }
}