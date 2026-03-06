package main.java.com.test.emprestimo.repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Não e nessesario realizar essa declaração no repository
    Usuario findByEmail (String email);
    
} 
