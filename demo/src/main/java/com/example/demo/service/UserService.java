package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final List<User> usuarios = new ArrayList<>();

    public void salvarUsuario(User user) {
        usuarios.add(user);
    }

    public List<User> listarUsuarios() {
        return usuarios;
    }


    public boolean isNomeValido(User user) {
        return user != null && user.getNome() != null && !user.getNome().trim().isEmpty();
    }

    public boolean isEmailValido(User user) {
        return user != null &&
                user.getEmail() != null &&
                !user.getEmail().trim().isEmpty() &&
                user.getEmail().contains("@");
    }

    public boolean isSenhaValida(User user) {
        return user != null &&
                user.getSenha() != null &&
                !user.getSenha().trim().isEmpty() &&
                user.getSenha().length() >= 8;
    }

    public String mensagemErroNome(User user) {
        if (user == null || user.getNome() == null || user.getNome().trim().isEmpty()) {
            return "Campo 'Nome' é obrigatório!";
        }
        return "";
    }

    public String mensagemErroEmail(User user) {
        if (user == null || user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            return "Campo 'E-mail' é obrigatório!";
        } else if (!user.getEmail().contains("@")) {
            return "E-mail inválido!";
        }
        return "";
    }

    public String mensagemErroSenha(User user) {
        if (user == null || user.getSenha() == null || user.getSenha().trim().isEmpty()) {
            return "Campo 'Senha' é obrigatório!";
        } else if (user.getSenha().length() < 8) {
            return "O campo 'Senha' deve ter no mínimo 8 caracteres!";
        }
        return "";
    }

    public boolean atualizarUsuario(String email, User novoUser) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getEmail().equals(email)) {
                usuarios.set(i, novoUser);
                return true;
            }
        }
        return false;
    }

    public boolean deletarUsuario(String email) {
        return usuarios.removeIf(user -> user.getEmail().equals(email));
    }
}