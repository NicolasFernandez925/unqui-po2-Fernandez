package tp8_Patrones1.composite.shapeShifter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShapeShifterCompuesto implements IShapeShifter{
	
	private List<IShapeShifter> ss;
	
	public ShapeShifterCompuesto(List<IShapeShifter> shapeSimples) {
		this.ss = shapeSimples;
	}
	
	public List<IShapeShifter> getShapeShifters(){
		return this.ss;
	}

	@Override
	public IShapeShifter compose(IShapeShifter s) {
		this.ss.add(s);
		return new ShapeShifterCompuesto(this.getShapeShifters());
	}

	@Override
	public int deepest() {
		return this.ss.stream().mapToInt(s -> s.deepest() + 1).max().getAsInt();	
	}

	@Override
	public IShapeShifter flat() {
		
		List<IShapeShifter> list = new ArrayList<IShapeShifter>();
		if(this.deepest() >= 1) {		
			this.values().stream().forEach(s -> {
				list.add(new ShapeShifterSimple(s));
			});
	
			return new ShapeShifterCompuesto(list);
		}
		else {
			return this;
		}
	}

	@Override
	public List<Integer> values() {
		return this.getShapeShifters().stream().flatMap(ss->ss.values().stream()).collect(Collectors.toList());
		
	}
}
