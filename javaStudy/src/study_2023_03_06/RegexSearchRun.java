package study_2023_03_06;

public class RegexSearchRun {

	public static void main(String[] args) {	 
		 String txt = "123456";
	        boolean result1 = txt.matches("[0-9]+");//+가 1개라도 포함된 숫자가 있다면
	        //boolean result1 = txt.matches("[0-9]+");
	        System.out.println(result1);

	        //replaceAll() 전체 다 바꿔주겟다
	        String txt2 = "study2023*-;";
	        String res2 = txt2.replaceAll("[^a-z0-9]","!");
	        System.out.println(res2);

	        //split()
	        String[ ] txts = txt2.split("\\d+");
	        for(String tt:txts) {
	            System.out.println(tt);
	        }
	}

}
