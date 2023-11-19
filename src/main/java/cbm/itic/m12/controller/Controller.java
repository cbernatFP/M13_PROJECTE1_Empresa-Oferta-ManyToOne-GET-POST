package cbm.itic.m12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cbm.itic.m12.exception.EmpresaNotFoundException;
import cbm.itic.m12.model.Empresa;
import cbm.itic.m12.model.Oferta;
import cbm.itic.m12.repository.EmpresaRepository;
import cbm.itic.m12.repository.OfertaRepository;

@RestController
@RequestMapping("/api")
public class Controller {
	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private OfertaRepository ofertaRepository;

	// Gestió OFERTES
	// --------------------------------------------------------------------

	@GetMapping("/oferta")
	public Iterable<Oferta> buscaTotes() {
		return ofertaRepository.findAll();
	}

	@GetMapping("/oferta/{id}")
	Oferta buscaPerIdOferta(@PathVariable Long id) {
		return ofertaRepository.findById(id).orElseThrow();
	}

	@GetMapping("/empresa/{empresaId}/oferta")
	public ResponseEntity<List<Oferta>> getAllOfertesByEmpresaId(@PathVariable(value = "empresaId") Long empresaId) {
		// No hi ha control d'errors!!!
		List<Oferta> ofertes = ofertaRepository.findByEmpresaId(empresaId);
		return new ResponseEntity<>(ofertes, HttpStatus.OK);
	}


	@PostMapping("/empresa/{empresaId}/oferta")
	public ResponseEntity<Oferta> createOferta(@PathVariable(value = "empresaId") Long empresaId,
			@RequestBody Oferta ofertaRequest) {
		Empresa empresa = empresaRepository.findById(empresaId).orElseThrow();
		ofertaRequest.setEmpresa(empresa);
		Oferta oferta = ofertaRepository.save(ofertaRequest);

		return new ResponseEntity<>(oferta, HttpStatus.CREATED);
	}
	
	// --------------------------------------------------------------------	
	// TODO: FALTA FER LA RESTA DE MÈTODES
	// --------------------------------------------------------------------
	
	
	

	// Gestió EMPRESES
	// --------------------------------------------------------------------

	@GetMapping("/empresa")
	public Iterable<Empresa> buscaTots() {
		System.out.println("1111111111");
		return empresaRepository.findAll();
	}

	@GetMapping("/empresa/{id}")
	Empresa buscaPerId(@PathVariable Long id) {
		return empresaRepository.findById(id).orElseThrow(() -> new EmpresaNotFoundException());
	}


	@PostMapping("/empresa")
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa afegeix(@RequestBody Empresa empresa) {
		Empresa empresa1 = empresaRepository.save(empresa);
		return empresa1;
	}

	@DeleteMapping("/empresa/{id}")
	public void esborra(@PathVariable long id) {
		empresaRepository.deleteById(id);
	}

	// --------------------------------------------------------------------
	// TODO: FALTA FER LA RESTA DE MÈTODES
	// --------------------------------------------------------------------	
	// TODO: FALTA FER GESTIÓ D'ERRORS I EXCEPCIONS
	// --------------------------------------------------------------------
	

}
