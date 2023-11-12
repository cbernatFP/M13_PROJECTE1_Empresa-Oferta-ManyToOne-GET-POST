package cbm.itic.m12.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cbm.itic.m12.model.Oferta;

public interface OfertaRepository extends CrudRepository<Oferta, Long> {

	List<Oferta> findByEmpresaId(Long empresaId);

}
