package com.example.backend.entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Usuario implements Serializable {
	
	
	@Id
	@SequenceGenerator(name="usuario_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_id_seq")
	private Integer id;
	private String nombre;
	private String email;
	private String curso;
	private String universidad;
	
	

}
