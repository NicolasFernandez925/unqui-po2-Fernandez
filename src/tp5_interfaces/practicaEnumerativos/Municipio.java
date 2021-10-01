package tp5_interfaces.practicaEnumerativos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Municipio {

	private List<ActividadSemanal> actividades;
	
	public Municipio() {
		this.actividades = new ArrayList<ActividadSemanal>();
	}
	
	public void agregarActidad(ActividadSemanal actividad) {
		actividades.add(actividad);
	}
	
	public List<ActividadSemanal> actividadesDeFutbol(){
		return actividades.stream().filter(a -> a.getDeporte().equals(Deporte.valueOf("FUTBOL"))).toList();
	}
	
	public List<ActividadSemanal> actividadesConComplejidad(int complejidad){
		return actividades.stream().filter(a -> a.getDeporte().getComplejidad() == complejidad ).toList();
	}
	
	public int horasTotales(){
		return actividades.stream().mapToInt(a -> a.getDuracion()).sum();
	}
	
	public ActividadSemanal actividadSemanalConMenorCostoDelDeporte(Deporte d) {
		List<ActividadSemanal> actividadesFiltradas = actividades.stream().filter(a -> a.getDeporte().equals(d)).toList();
		return this.laActividadMenorConMenorCostoDe(actividadesFiltradas);
	}
	
	public ActividadSemanal laActividadMenorConMenorCostoDe(List<ActividadSemanal> actividades) {
		return actividades.stream().min(Comparator.comparing(ActividadSemanal::costoActividadSemanal)).get();
	}
	
	public Map<Deporte,ActividadSemanal> actividadSemanalDeMenorCostoDeCadaDeporte() {
		 Map<Deporte,ActividadSemanal> mapFiltrado = new HashMap<Deporte,ActividadSemanal>();
		 Map<Deporte,List<ActividadSemanal>> listGroupBy =  actividades.stream().collect(Collectors.groupingBy(ActividadSemanal::getDeporte));
		 for (Map.Entry<Deporte, List<ActividadSemanal>> map : listGroupBy.entrySet()) {
			 mapFiltrado.put(map.getKey(), this.laActividadMenorConMenorCostoDe(map.getValue()));
			}
		 return mapFiltrado;
		 
		 
	}
	
	public void imprimirActividades() {
		actividades.forEach(a -> {
			System.out.println(a.toString());
		});
	}
}
