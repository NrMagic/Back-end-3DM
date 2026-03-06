package main.java.com.test.emprestimo.dto;

import java.util.List;

import main.java.com.test.emprestimo.entity.CarteiraBiblioteca;

public class UsuarioRequestDTO {
    
    private String nome;

    private String email;

    private CarteiraBiblioteca carteira;

    public UsuarioRequestDTO(){

    }

    public UsuarioRequestDTO(String nome, String email, List<emprestimo> emprestimos, CarteiraBiblioteca carteira) {
        this.nome = nome;
        this.email = email;
        this.emprestimos = emprestimos;
        this.carteira = carteira;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public CarteiraBiblioteca getCarteira() {
        return carteira;
    }

    public void setCarteira(CarteiraBiblioteca carteira) {
        this.carteira = carteira;
    }


}
