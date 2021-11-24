package tp8_Patrones1.composite.shapeShifter;

import java.util.List;

public interface IShapeShifter {
	
	public IShapeShifter compose(IShapeShifter s);
	public int deepest();
	public IShapeShifter flat();
	public List<Integer> values();
	
}
