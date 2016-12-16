package es.uc3m.tiw;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import es.uc3m.tiw.daos.ProductoRepository;

import es.uc3m.tiw.dominios.Producto;


@SpringBootApplication
public class CatalogoSpringApplication {
	
	
	@Autowired
	private ProductoRepository repositoryproductos;
	

	public static void main(String[] args) {
		SpringApplication.run(CatalogoSpringApplication.class, args);
	}
	
	
	@PostConstruct
	public void init() {
		Set<Producto> productos = new HashSet<>();
		
		productos.add(new Producto(0, "iPhone5", "Telefonía", "Perfecto", "Disponible", "Madrid", 100, 1));
		productos.add(new Producto(0, "Guardaropa", "Muebles", "OK", "Disponible", "Sevilla",60, 2));
		productos.add(new Producto(0, "iPhone6", "Telefonia", "Perfecto", "Disponible", "Barcelona", 400, 3));
		productos.add(new Producto(0, "Balón", "Juguetes", "2ª Mano", "Disponible", "Madrid", 35, 4));
		productos.add(new Producto(0, "Calculadora", "Electronica", "Buen Estado", "Disponible", "Caceres", 12, 1));
		productos.add(new Producto(0, "TV Samsung", "Electronica", "Nueva", "Disponible", "Madrid", 240, 2));
		productos.add(new Producto(0, "Sofa", "Muebles", "Nuevo", "Disponible", "Bilbao", 230, 3));
		productos.add(new Producto(0, "Cargador", "Electronica", "Seminuevo", "Disponible", "Madrid", 21, 4));
		
		

		repositoryproductos.save(productos);
		repositoryproductos.flush();
		

	}
	
}
