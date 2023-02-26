package study13;

class GenBox<T> {
	private T type;
	public T getBox() {
		return type;
	}
	public void setBox(T type) {
		this.type=type;
	}

}

class Gen2Box<K,V>{
	private K key;
	private V value;
	
	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public void setKey(K key) {
		this.key = key;
	}
	
}
public class BoxRun2{
	public static void main(String[] args) {
		GenBox<Integer> b1 = new GenBox<>();
		b1.setBox(12);
		System.out.println(b1.getBox());
		GenBox<String> b2 = new GenBox<>();
		b2.setBox("generic Box");
		System.out.println(b2.getBox());
		
		Gen2Box<String, Integer> b3 = new Gen2Box<>();
		b3.setKey("java");
		b3.setValue(1234);
		System.out.printf("%s %d \n",b3.getKey(),b3.getValue());
		
		Gen2Box<String,Void> b4 = new Gen2Box<>();
		b4.setKey("key만 사용");
		//b4.setValue("제임스 본드");
		System.out.printf("%03d %s \n",b4.getKey(),b4.getValue());
		
		
	}
}