package es.uc3m.tiw.daos;

import java.util.List;


import org.springframework.data.
import es.uc3m.tiw.dominios.Producto;

public interface ProductoDao extends CrudRepository<Producto, Long> {

	List<Producto> findByClienteID(long clienteID);
}
