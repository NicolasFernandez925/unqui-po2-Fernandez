package tp5_interfaces.practicaEnumerativos;

public enum Color {
			
		ROJO(4),GRIS(3),AMARILLO(2),MIEL(1);
		
		private int nivelDeRiesgo;
		
		public  Color proximoColorMaduracion() {
			return this.ordinal() < Color.values().length - 1 ? 
					Color.values()[ this.ordinal() + 1] : 
						Color.values()[0];
		}
		
		Color(int nvlRiesgo){
			this.nivelDeRiesgo = nvlRiesgo;
		}
		
		public int getNivelDeRiesto() {
			return this.nivelDeRiesgo;
		}
		
}
