package study10_4;

public class BookShelf extends Shelf implements Queue{
	@Override
	public void enQueue(String title) {
		shelf.add(title);
	}
	@Override
	public String deQueue(){
		return shelf.remove(0);
	}
	@Override
	public int getSize() {
		return getCount();
	}
	public String deQueue2() {
		if(getSize()>0) {
			return shelf.remove(0);
			
		}else {
			return "비어 있음";
		}
	}
}
