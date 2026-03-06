package main.java.com.test.emprestimo.entity;

import  java.sql.Date;

@Entity
@Table(name = "tbl_Carteira")
public class CarteiraBiblioteca {
 
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dataEmisssao;

    private boolean isValid;  
    
    @OneToOne(mappeBy = "usuario")
    private Usuario usuario;

    public CarteiraBiblioteca(Date dataEmisssao, boolean isValid, Usuario usuario) {
        this.dataEmisssao = dataEmisssao;
        this.isValid = isValid;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataEmisssao() {
        return dataEmisssao;
    }

    public void setDataEmisssao(Date dataEmisssao) {
        this.dataEmisssao = dataEmisssao;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

   
}
