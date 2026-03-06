package main.java.com.test.emprestimo.dto;

import java.util.List;

import main.java.com.test.emprestimo.entity.CarteiraBiblioteca;
import main.java.com.test.emprestimo.entity.Usuario;

public class UsuarioResponseDTO {

    private long idUsuario;

    private String nome;

    private String email;

    private List <emprestimo>emprestimos;

    private CarteiraBiblioteca carteira;

    public UsuarioResponseDTO(Usuario usuario){

        this.idUsuario = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.emprestimos = usuario.getEmprestimos();
        this.carteira = usuario.getCarteira();

    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
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
