package com.example.frota.caminhao;

import jakarta.validation.constraints.NotBlank;

public record CadastroCaminhao(@NotBlank String modelo, String placa, double cargaMaxima) {
	
}
