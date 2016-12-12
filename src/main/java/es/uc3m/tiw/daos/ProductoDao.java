package es.uc3m.tiw.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import es.uc3m.tiw.dominios.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {
	
	//El DAO guarda, borra, busca

	//Buscar todos los productos de la base de datos
	List<Producto> findAll();
	
	//Borrar producto
	void delete(int id);
	
	//Guardar producto
	void save(int id);
	
	
	
   
}
