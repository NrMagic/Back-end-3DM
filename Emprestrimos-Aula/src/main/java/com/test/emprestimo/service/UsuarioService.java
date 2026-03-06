package main.java.com.test.emprestimo.service;

import java.util.List;
import java.util.Optional;

import main.java.com.test.emprestimo.dto.UsuarioRequestDTO;
import main.java.com.test.emprestimo.dto.UsuarioResponseDTO;
import main.java.com.test.emprestimo.entity.Usuario;
import main.java.com.test.emprestimo.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //criar usuario
    public UsuarioResponseDTO saveUser(UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = new Usuario(usuarioRequestDTO.getNome(), usuarioRequestDTO.getEmail(), usuarioRequestDTO.getEmprestimos(), usuarioRequestDTO.getCarteira());
        
        UsuarioRepository.save(usuario);
        return new UsuarioResponseDTO(usuario);
    }

    // login
	public String login(UsuarioRequestDTO user) {
		Usuario findUser = usuarioRepository.findByEmail(user.getEmail());

	
		if (findUser == null) {

			return "Usuário não encontrado.";
		} else {
			if (findUser.getSenha().equals(user.getSenha())) {
				return "Logado com sucesso.";
			} else {

				return "Senha incorreta.";
			}
		}
	}

    // resposta em caso de erro
    public String searchById(int id) {
            Optional<Usuario> usuario = usuarioRepository.findById(id);
    
            if (usuario.isPresent()) {
                UsuarioResponseDTO dto = new UsuarioResponseDTO(usuario.get());
                return dto.toString();
            } else {
                return "Esse ID não existe.";
            }
        }

    // mostrar todos os usuarios
	public List<UsuarioResponseDTO> mostrar() {
		List<Usuario> usuarios = usuarioRepository.findAll();
		List<UsuarioResponseDTO> listadeUsuarios = usuarios.stream().map(UsuarioResponseDTO::new).toList();

		return listadeUsuarios;
	}

    	// atualizar nome do usuario
	public String atualizar(int id, Usuario novoUsuario) {
		Optional<Usuario> UsuarioExistente = usuarioRepository.findById(id);

		if (UsuarioExistente.isPresent()) {
			Usuario Usuario = UsuarioExistente.get();
			Usuario.setNome(novoUsuario.getNome());
			usuarioRepository.save(Usuario);
			UsuarioResponseDTO dto = new UsuarioResponseDTO(Usuario);
			return dto.toString();

		} else {
			return "Não foi achado o usuário.";
		}
    }

    // deletar usuario
	public String deleteUsuario(int id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);

		if (usuario.isPresent()) {
			usuarioRepository.deleteById(id);
			return "Usuário deletado com sucesso.";
		} else {
			return "Esse ID não existe.";
		}
	}
}
