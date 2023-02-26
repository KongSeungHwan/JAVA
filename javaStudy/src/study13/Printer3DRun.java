package study13;

interface Material{
	void doPrinting();
	
} //3d프린터의 재료가 달라지는 것을 보여주기 위함 
class Powder implements Material{
	public String toString() {
		return "사용물질: 파우더";
	}

	public void doPrinting() {
		System.out.println("파우더 제품 제작중...");
	}
}
class Plastic implements Material{
	public String toString() {
		return "사용물질: 플라스틱";
	}

	public void doPrinting() {
		System.out.println("플라스틱 제품 제작중...");
	}
}
class Print3D<T extends Material>{
	private T material;
	
	public T getMaterial() {
		return material;
	}
	public void setMaterial(T material) {
		this.material =material;
	}
	public String toString() {
		return material.toString();
	}
	public void printing() {
		material.doPrinting();
	}
}
public class Printer3DRun{
	public static void main(String[] args) {
		Print3D<Powder> powder = new Print3D<>();
		powder.setMaterial(new Powder());
		System.out.println(powder.toString());
		powder.printing();
		Print3D<Plastic> plastic = new Print3D<>();
		plastic.setMaterial(new Plastic());
		System.out.println(plastic.toString());
		plastic.printing();
		Print3D<Material> pMa = new Print3D<>();
		pMa.setMaterial(new Powder());
		pMa.setMaterial(new Plastic());//다형성
	}
	
}
