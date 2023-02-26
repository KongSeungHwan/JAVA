package test2023_02_09;

public class Exam06 {

	public static void dbWork(DataAccessObject dao){
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
	public static void main(String[] args){
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}//그냥 출력문만 하랬으니 여까지!

}
