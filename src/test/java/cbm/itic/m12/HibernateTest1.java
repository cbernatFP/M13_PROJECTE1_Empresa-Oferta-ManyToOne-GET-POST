package cbm.itic.m12;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.stream.StreamSupport;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cbm.itic.m12.model.Empresa;
import cbm.itic.m12.model.Oferta;
import cbm.itic.m12.repository.EmpresaRepository;
import cbm.itic.m12.repository.OfertaRepository;


@SpringBootTest
class HibernateTest1 {

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private OfertaRepository ofertaRepository;

	@Test
	void testSave() {
		Empresa empresa1 = new Empresa(4, "LaMeva", "eeeee");
		Empresa empresaRecuperada = empresaRepository.save(empresa1);
		long cont = StreamSupport.stream(empresaRepository.findAll().spliterator(), false).count();

		// N'hi havia 3, si n'afegim una n'hi ha d'haver 4
		assertEquals(4, cont);

		// Verifica que la empresa recuperada no sea nula
		assertNotNull(empresaRecuperada, "La empresa no se ha insertado correctamente en la base de datos");

		// Verifica que el nombre de la empresa sea el esperado
		assertEquals("LaMeva", empresaRecuperada.getNom(), "El nombre de la empresa no coincide");

	}

	@Test
	void testfindById() {
		Long id = (long) 1;
		Empresa empresaRecuperada = empresaRepository.findById(id).orElseThrow();

		// Verifica que el nombre de la empresa sea el esperado
		assertEquals("Indra", empresaRecuperada.getNom(), "El nombre de la empresa no coincide");
	}

	@Test
	void testdeleteById() {
		empresaRepository.deleteById((long) 2);

		long cont = StreamSupport.stream(ofertaRepository.findAll().spliterator(), false).count();

		Iterable<Oferta> ofertes = ofertaRepository.findAll();
		assertNotNull(ofertes, "La llista d'ofertes no pot ser nulla");

		// N'hi havia 3, si borrem les 2 d'itic
		assertEquals(1, cont);

//      // Itera sobre la lista de empresas
//      for (Oferta oferta : ofertes) {
//          System.out.println(oferta);
//      }
	
	}
	
/*  
 * VEIEU COM HEM DE MODIFICAR ELS PARÀMETRES DE LA DEFINICIÓ DEL CAMP EMPRESA A L'OFERTA
 * Perquè el test falli, sense donar error
 * 
 * Oferta.java
 * 	@ManyToOne(fetch = FetchType.EAGER, optional = true)
 *	@JoinColumn(name = "id_empresa", nullable = true)
 *	@OnDelete(action = OnDeleteAction.SET_NULL)
 *	private Empresa empresa;	
 *	
 *	
 *	@ManyToOne(fetch = FetchType.EAGER, optional = false)
 *	@JoinColumn(name = "id_empresa", nullable = false)
 *	@OnDelete(action = OnDeleteAction.CASCADE)
 *	private Empresa empresa;
 *	
 *	
 */
	
	

}
