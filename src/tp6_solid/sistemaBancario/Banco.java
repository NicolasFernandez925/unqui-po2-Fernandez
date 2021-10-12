package tp6_solid.sistemaBancario;

import java.util.ArrayList;
import java.util.List;

import tp6_solid.sistemaBancario.creditos.ISolicitudDeCredito;
import tp6_solid.sistemaBancario.creditos.SolicitudDeCredito;


public class Banco {
	
	private SectorCrediticio sectorCrediticio;
	private SectorContable sectorContable;
	private List<Cliente> clientes;
	private List<ISolicitudDeCredito> solicitudesDeCredito;
	
	public Banco(SectorCrediticio sectorCrediticio, SectorContable sectorContable) {
		super();
		this.sectorCrediticio = sectorCrediticio;
		this.sectorContable = sectorContable;
		this.clientes = new ArrayList<Cliente>();
		this.solicitudesDeCredito = new ArrayList<ISolicitudDeCredito>();
	}
	
	public void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	

	public void registrarSolicitud(ISolicitudDeCredito solicitable) {
		this.solicitudesDeCredito.add(solicitable);
	}
	
	public void totalADesenbolsar() {
		sectorContable.totalADesenbolsar(this);
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public List<ISolicitudDeCredito> getSolicitudesDeCredito() {
		return solicitudesDeCredito;
	}

	
	public void otorgarCredito(ISolicitudDeCredito credito) {
		this.registrarSolicitud(credito);
		sectorCrediticio.analizarCredito(credito);
	}

}
