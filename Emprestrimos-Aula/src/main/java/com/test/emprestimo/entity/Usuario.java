package main.java.com.test.emprestimo.entity;

import java.lang.annotation.Inherited;

import javax.annotation.processing.Generated;

@Entity
@Table(name = "tbl_Usuario")
public class Usuario {
    
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Column (unique = true)
    private String email;

    @OneToMany(mappeBy ="usuario")
    private List<Emprestimo> emprestimos;

    @OneToOne(mappeBy = "usuario")
    private CarteiraBiblioteca carteira;

    public Usuario(String nome, String email, List<Emprestimo> emprestimos, CarteiraBiblioteca carteira) {
        this.nome = nome;
        this.email = email;
        this.emprestimos = emprestimos;
        this.carteira = carteira;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public CarteiraBiblioteca getCarteira() {
        return carteira;
    }

    public void setCarteira(CarteiraBiblioteca carteira) {
        this.carteira = carteira;
    }

  

}
