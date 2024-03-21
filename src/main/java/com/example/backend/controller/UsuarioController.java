package com.example.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.entities.Usuario;
import com.example.backend.repository.UsuarioRepository;




@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping
	public List<Usuario> ListgetUsuarioAll(){
		return usuarioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Usuario getUsuariosbyId(@PathVariable Integer id) {
	Optional<Usuario> usuario = usuarioRepository.findById(id);
	return usuario.get();
	}
	
	
	//Metodo post para agregar alumnos
	@PostMapping
	public Usuario postAlumnosbyId(@RequestBody Usuario usuario) {
		
		usuarioRepository.save(usuario);
		return usuario;
		
	}
	
	@PutMapping("/{id}")
	public Usuario putUsuariosbyId(@PathVariable Integer id , @RequestBody Usuario usuario) {
		
		Optional<Usuario> usuarioCurrent = usuarioRepository.findById(id);
		
		if ( usuarioCurrent.isPresent()) {
			
			Usuario usuarioReturn = usuarioCurrent.get();
			
			
			usuarioReturn.setNombre(usuario.getNombre());
			usuarioReturn.setEmail(usuario.getEmail());
			usuarioReturn.setCurso(usuario.getCurso());
			usuarioReturn.setUniversidad(usuario.getUniversidad());
			
			
			
			
			usuarioRepository.save(usuarioReturn);
			
			return usuarioReturn;
		}
		
		return null;

	}
	
	
	//metodo para eliminar un usuario
	@DeleteMapping("/{id}")
    public Usuario deleteUsuariosbyId(@PathVariable Integer id) {
		
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		
		if (usuario.isPresent()) {
			
			Usuario usuarioReturn = usuario.get();
			
			usuarioRepository.deleteById(id);
			
			return usuarioReturn;
		}
		
		return null;

	}

}
