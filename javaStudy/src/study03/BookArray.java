package study03;

public class BookArray {

	public static void main(String[] args) {
		Book b = new Book();
		b.setBookName("삼국지1");
		String bs = b.getBookName();
		System.out.println(bs);
		
		Book[] lib = new Book[5];
		
		lib[0]=new Book("삼국지1","나관중");
		lib[1]=new Book("삼국지2","나관중");
		lib[2]=new Book("삼국지3","나관중");
		lib[3]=new Book("삼국지4","나관중");
		lib[4]=new Book("삼국지5","나관중");
		//lib[4]=new Book("삼국지6","나관중");
		System.out.println(lib);
		
		for (Book book : lib) {
			book.printBookInfo();
		}
		//향상for문으로 출력
		
		System.out.println();
		
		for (int i = 0; i < lib.length; i++) {
			lib[i].printBookInfo();
		}
		//기본for문으로 출력
	}

}
