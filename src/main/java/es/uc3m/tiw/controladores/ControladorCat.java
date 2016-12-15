package es.uc3m.tiw.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import es.uc3m.tiw.daos.ProductoRepository;
import es.uc3m.tiw.dominios.*;

@RestController
public class ControladorCat {
	
	@Autowired
	ProductoRepository productoDao;
	
	@RequestMapping(value="/altaProducto", method = RequestMethod.POST)
	public @ResponseBody Producto registrarProducto(@RequestBody Producto productoARegistrar){
	productoDao.save(productoARegistrar);; //guardar, editar, borrar, findbyOne(Primary key) son métodos que vienen implementados ya en el CrudRepository
	return productoARegistrar;
	}
	
		
	@RequestMapping(value="/ModificarProducto", method=RequestMethod.PUT) // POST
	public boolean editarProducto(@RequestBody Producto productoAEditar){
		
		/*
		productoAEditar.setTitulo(productoAEditar.getTitulo());
		productoAEditar.setCategoria(productoAEditar.getCategoria());
		productoAEditar.setDescripcion(productoAEditar.getDescripcion());
		productoAEditar.setEstado(productoAEditar.getEstado());
		productoAEditar.setCiudad(productoAEditar.getCiudad());
		productoAEditar.setImagen(productoAEditar.getImagen());
		productoAEditar.setPrecio(productoAEditar.getPrecio());
		*/
		
		productoDao.save(productoAEditar);
		return true;
	}

	@RequestMapping(value="/eliminarProducto", method=RequestMethod.POST)
	public boolean eliminarProducto(@RequestBody long id){
		productoDao.delete(id);
		return true;
	}
	
	 @RequestMapping(value="/catalogo" , method = RequestMethod.GET)
	 public @ResponseBody List<Producto> ObtenerProductosCatalogo(){
		 return productoDao.findAll();
	}
	 
	 @RequestMapping(value="/buscarProductoPorID", method=RequestMethod.POST)
	public Producto buscarProductoporID(@RequestBody long id){
		return productoDao.findOne(id);
	}
	 
	 @RequestMapping(value="/busquedaSimple", method=RequestMethod.POST)
	public List <Producto> buscarPorTitulooDescripcion(@RequestParam(value ="titulo")String titulo,@RequestParam(value ="descripcion")String descripcion){
		return productoDao.findByTituloOrDescripcion(titulo, descripcion);
	}
	
	
}