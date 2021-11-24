package tp8_Patrones1.composite.shapeShifter;

import java.util.ArrayList;
import java.util.List;

public class ShapeShifterSimple implements IShapeShifter {

	private int value;
	
	public ShapeShifterSimple(int v) {
		this.value = v;
	}
	
	public int getValue() {
		return this.value;
	}
	
	@Override
	public IShapeShifter compose(IShapeShifter s) {
		List<IShapeShifter> listSS= new ArrayList<IShapeShifter>();
		listSS.add(this);
		listSS.add(s);
		return new ShapeShifterCompuesto(listSS);
	}

	@Override
	public int deepest() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IShapeShifter flat() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public List<Integer> values() {
		List<Integer> l = new ArrayList<Integer>();
		l.add(this.getValue());
		return l;
	}

}
