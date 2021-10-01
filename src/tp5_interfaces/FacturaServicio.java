package tp5_interfaces;

public class FacturaServicio extends Factura {

	private double costoPorUnidadConsumida;
	private int cantidadDeUnidadesConsumidas; 
	
	public FacturaServicio(double costoPorUnidadConsumida, int cantidadDeUnidadesConsumidas, Agencia agencia) {
		super();
		this.setCostoPorUnidadConsumida(costoPorUnidadConsumida);
		this.setCantidadDeUnidadesConsumidas(cantidadDeUnidadesConsumidas);
		this.agencia = agencia;
	}
	
	public double getCostoPorUnidadConsumida() {
		return costoPorUnidadConsumida;
	}

	public void setCostoPorUnidadConsumida(double costoPorUnidadConsumida) {
		this.costoPorUnidadConsumida = costoPorUnidadConsumida;
	}

	public int getCantidadDeUnidadesConsumidas() {
		return cantidadDeUnidadesConsumidas;
	}

	public void setCantidadDeUnidadesConsumidas(int cantidadDeUnidadesConsumidas) {
		this.cantidadDeUnidadesConsumidas = cantidadDeUnidadesConsumidas;
	}

	@Override
	public double montoAPagar() {
		return this.getCantidadDeUnidadesConsumidas() * this.getCostoPorUnidadConsumida();
	}


}
