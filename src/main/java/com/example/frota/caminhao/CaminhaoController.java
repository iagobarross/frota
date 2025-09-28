package com.example.frota.caminhao;
 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.frota.marca.MarcaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
 
 
@Controller
@RequestMapping("/caminhao")
public class CaminhaoController {
	@Autowired
	private CaminhaoService caminhaoService;
	@Autowired
	private MarcaService marcaService;
	@GetMapping                 
	public String carregaPaginaFormulario ( Model model){ 
		model.addAttribute("listaVeiculos", caminhaoService.procurarTodos());
	    return "caminhao/listagem";              
	} 
	@GetMapping ("/formulario")
	public String carregaPaginaFormulario (Long id, Model model) {
		model.addAttribute("marcas", marcaService.procurarTodos());
		if(id != null) {
			var caminhao = caminhaoService.procurarPorId(id);
			model.addAttribute("caminhao", caminhao);
		}
		return "caminhao/formulario";
	}
	@PostMapping
	@Transactional
	public String cadastrar (@Valid CadastroCaminhao dados) {
		var marca = marcaService.procurarPorId(dados.marca().getId());
		var caminhao = new Caminhao(dados, marca);
		caminhaoService.salvar(caminhao);
		return "redirect:caminhao";
	}
	@DeleteMapping
	@Transactional
	public String excluir (Long id) {
		caminhaoService.apagarPorId(id);
		return "redirect:caminhao";
	}
}