package com.example.frota.marca;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

	@Entity
	@Table(name = "marca")
	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@EqualsAndHashCode(of ="id")
	public class Marca {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		private String nome;
		private String pais;
		
	 
	}
	
	