package es.uc3m.tiw.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.uc3m.tiw.daos.ProductoRepository;
import es.uc3m.tiw.dominios.*;

@RestController
public class Controlador {
	
	@Autowired
	ProductoRepository pdao;
	
	@RequestMapping(value="/altaProducto", method=RequestMethod.POST)
	public void altaProducto(@RequestBody Producto producto){
		pdao.save(producto);
	}
		

	@RequestMapping(value="/ModificarProducto", method=RequestMethod.PUT)
	public boolean editarProducto(@RequestBody Producto producto){
		pdao.save(producto);
		return true;
	}

	@RequestMapping(value="/eliminar", method=RequestMethod.POST)
	public boolean eliminarProducto(@RequestBody long id){
		pdao.delete(id);
		return true;
	}
	
	 @RequestMapping(value="/catalogo" , method = RequestMethod.GET)
	 public @ResponseBody List<Producto> ObtenerProductosCatalogo(){
		 return pdao.findAll();
	 }
	 
	 @RequestMapping(value="/buscarProductoPorID", method=RequestMethod.POST)
		public Producto buscarProductoporID(@RequestBody long id){
			return pdao.findOne(id);
		}
	 @RequestMapping(value="/busquedaSimple", method=RequestMethod.POST)
		public List <Producto> buscarPorTitulooDescripcion(@RequestParam(value ="titulo")String titulo,@RequestParam(value ="descripcion")String descripcion){
			return pdao.findByTituloOrDescripcion(titulo, descripcion);
		}
}
