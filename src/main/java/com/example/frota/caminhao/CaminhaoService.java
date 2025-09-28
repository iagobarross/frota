package com.example.frota.caminhao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import jakarta.validation.constraints.NotNull;
 
@Service
public class CaminhaoService {
	@Autowired
	private CaminhaoRepository caminhaoRepository;
	
	public Caminhao salvar(Caminhao caminhao) {
		return caminhaoRepository.save(caminhao);
	}
	public List<Caminhao> procurarTodos(){
		return caminhaoRepository.findAll(Sort.by("modelo").ascending());
	}
	public void apagarPorId (Long id) {
		caminhaoRepository.deleteById(id);
	}
	public Caminhao procurarPorId(@NotNull Long id) {
		return caminhaoRepository.getReferenceById(id);
	}
}