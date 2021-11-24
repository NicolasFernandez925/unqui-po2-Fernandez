package tp9_Patrones2.adapter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

@SuppressWarnings("serial")
public class ListaDePalabrasOrdenadasAdapter extends DefaultListModel<String> {
	
	ListaDePalabrasOrdenadas palabrasOrdenadas;

	public ListaDePalabrasOrdenadasAdapter(ListaDePalabrasOrdenadas palabrasOrdenadas) {
		super();
		this.palabrasOrdenadas = palabrasOrdenadas;
	}
	
	/*public List <String> elementos () {
        List <String> list = new ArrayList <String> ();
        for (int i = 0; i < palabrasOrdenadas.cantidadDePalabras(); i++) {
            list.add(palabrasOrdenadas.getPalabraDePosicion(i));
        }
        return list;
    }
    */
	
	@Override
	public void addElement(String elemento) {
		  this.removeAllElements();
		  palabrasOrdenadas.agregarPalabra(elemento);		 
	      this.addAll(palabrasOrdenadas.getPalabras());
	}

}
