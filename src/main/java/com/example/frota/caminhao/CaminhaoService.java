package com.example.frota.caminhao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CaminhaoService {

	@Autowired
	CaminhaoRepository repository;

	public Caminhao save(Caminhao caminhao) {
		return repository.save(caminhao);
	}

	public List<Caminhao> getAllCaminhao() {
		return repository.findAll(Sort.by("nome").ascending());
	}

}