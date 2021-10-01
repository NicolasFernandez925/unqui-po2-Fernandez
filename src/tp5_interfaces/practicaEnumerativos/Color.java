package tp5_interfaces.practicaEnumerativos;

public enum Color {
			
		ROJO(4){
			
			@Override
			public Color proximoColorMaduracion() {
				return MIEL;
			}
			
		},GRIS(3){
			
			@Override
			public Color proximoColorMaduracion() {
				return ROJO;
			}

		},AMARILLO(2){
			
			@Override
			public Color proximoColorMaduracion() {
				return GRIS;
			}

		},MIEL(1){
			
			@Override
			public Color proximoColorMaduracion() {
				return AMARILLO;
			}

		};
		
		private int nivelDeRiesgo;
		public abstract Color proximoColorMaduracion();
		
		Color(int nvlRiesgo){
			this.nivelDeRiesgo = nvlRiesgo;
		}
		
		public int getNivelDeRiesto() {
			return this.nivelDeRiesgo;
		}
		
}
