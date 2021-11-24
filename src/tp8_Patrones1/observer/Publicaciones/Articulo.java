package tp8_Patrones1.observer.Publicaciones;

import java.util.ArrayList;
import java.util.List;

public class Articulo {
	
	String titulo;
	String tipo;
	String lugarPublicado;
	List<String> autores;
	List<String> filiaciones;
	List<String> palabrasClaves;
		
	public Articulo(String titulo, String tipo, String lugarPublicado) {
		super();
		this.titulo = titulo;
		this.tipo = tipo;
		this.lugarPublicado = lugarPublicado;
		this.autores = new ArrayList<String>();
		this.filiaciones = new ArrayList<String>();
		this.palabrasClaves = new ArrayList<String>();
	}
	
	public void agregarAutor(String autor) {
		this.getAutores().add(autor);
	}
	
	public void agregarFiliacion(String filiacion) {
		this.getFiliaciones().add(filiacion);
	}
	
	public void agregarPalabraClave(String palabraClave) {
		this.getPalabrasClaves().add(palabraClave);
	}
	
	public List<String> datosBibliograficos(){
		List<String> datos = new ArrayList<String>();
		datos.addAll(this.getAutores());
		datos.addAll(this.getPalabrasClaves());
		datos.addAll(this.getFiliaciones());
		datos.add(this.getLugarPublicado());
		datos.add(this.getTipo());
		datos.add(this.getTitulo());	
		return datos;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public String getTipo() {
		return tipo;
	}
	public String getLugarPublicado() {
		return lugarPublicado;
	}
	public List<String> getAutores() {
		return autores;
	}
	public List<String> getFiliaciones() {
		return filiaciones;
	}
	public List<String> getPalabrasClaves() {
		return palabrasClaves;
	}
	
}
