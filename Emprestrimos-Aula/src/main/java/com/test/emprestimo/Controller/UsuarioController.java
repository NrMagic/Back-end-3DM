package main.java.com.test.emprestimo.Controller;

import java.util.List;

import main.java.com.test.emprestimo.dto.UsuarioRequestDTO;
import main.java.com.test.emprestimo.dto.UsuarioResponseDTO;
import main.java.com.test.emprestimo.entity.Usuario;
import main.java.com.test.emprestimo.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "usuario")

public class UsuarioController {

    private final UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@PostMapping(value = "cadastro")
	public ResponseEntity<?> saveUser(@Valid @RequestBody UsuarioRequestDTO user) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.saveUser(user));
	}
	
	
	//fala que não acha o usuario
	@PostMapping(value = "login")
	public ResponseEntity<?> login(@Valid @RequestBody UsuarioRequestDTO user) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.login(user));
	}

	@GetMapping(value = "view")
	public List<UsuarioResponseDTO> mostrar() {
		return usuarioService.mostrar();
	}

	@GetMapping(value = "view/{id}")
	public ResponseEntity<?> searchById(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.searchById(id));
	}
	
	//o git bugou?
	@PutMapping("{id}")
	public ResponseEntity<?> atualizar(@Valid @PathVariable int id, @RequestBody Usuario novoUsuario) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.atualizar(id, novoUsuario));
	}

	@DeleteMapping(value = "delete/{id}")
	public ResponseEntity<?> deleteUsuario(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.deleteUsuario(id));
	}
	@GetMapping("buscar/{id}")
	public UsuarioResponseDTO buscarUsuario(@PathVariable int id) {
    Usuario usuario = usuarioService.buscarPorId(id);
    return new UsuarioResponseDTO(usuario);
}

}
