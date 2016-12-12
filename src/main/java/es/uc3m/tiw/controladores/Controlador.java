package es.uc3m.tiw.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.uc3m.tiw.daos.ProductoDao;
import es.uc3m.tiw.dominios.*;

public class Controlador {
	
	@Autowired
	ProductoDao pdao;
	
	@RequestMapping(value="/altaProducto", method=RequestMethod.POST)
	public void altaProducto(@RequestBody Producto producto){
		pdao.saveAndFlush(producto);
	}
		

	@RequestMapping(value="/ModificarProducto", method=RequestMethod.POST)
	public boolean editarProducto(@RequestBody Producto producto){
		pdao.saveAndFlush(producto);
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
}
