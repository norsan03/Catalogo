package es.uc3m.tiw.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import es.uc3m.tiw.dominios.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	
	/* Para métodos que no vienen out-of-the-box
	 debemos usar una convención para el nombre del método.
	 El método tendrá el prefijo findBy y contendrá el nombre de 
	 los atributos por los que se quiera filtrar unidos por los operadores
	 And, Or, Between, LessThan, GreaterThan… Es la forma más simple de 
	 hacer una query pero no nos servirá si tenemos muchos parámetros (el nombre del método
	 será muy largo) o si la consulta es más compleja.*/

	
	List<Producto> findByTituloOrDescripcion(String titulo, String descripcion);
	
	Producto findById(int id);
	
   
}
