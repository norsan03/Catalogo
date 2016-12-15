package es.uc3m.tiw.dominios;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Column;

@Entity
@Table(name = "PRODUCTOS")
@XmlRootElement(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = AUTO)
	private int id;
	@Column (length = 25, nullable = false)
	private String titulo;
	@Column (length = 25, nullable = false)
	private String categoria;
	@Column (length = 500, nullable = false)
	private String descripcion;
	@Column (length = 25, nullable = false)
	private String estado;
	@Column (length = 25, nullable = false)
	private String ciudad;
	/*@Lob
	@Column(nullable=true, columnDefinition="mediumblob")
	private byte[] imagen;*/
	@Column (length = 25, nullable = false)
	private int precio;
	@Column (length = 25, nullable = false)
	private int usuario;
	

	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(int id, String titulo, String categoria, String descripcion, String estado, String ciudad,
			/*byte[] imagen,*/ int precio, int usuario) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.estado = estado;
		this.ciudad = ciudad;
		//this.imagen = imagen;
		this.precio = precio;
		this.usuario = usuario;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/*public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}*/
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getUsuario() {
		return usuario;
	}
	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}
	
}