package study12;


	enum DayOfWeek{
		Sunday,Monday,Tuesday,Wednsday,Thursday,Friday,Saturday
	}
	enum Week{
		Sunday("일",1),
		Monday("월",2),
		Tuesday("화",3),
		Wednsday("수",4),
		Thursday("목",5),
		Friday("금",6),
		Saturday("토",7);
		private final String name;
		private final int order;
		Week(String string, int i) {
			name = string;
			order = i;
		}
		public String getName() {
			return name;
		}
		public int getOrder() {
			return order;
		}
		
	}
	public class EnumRun{
		enum Season{봄,여름,가을,겨울};
		public DayOfWeek today;
		
		public static void main(String[] args) {
			System.out.println(DayOfWeek.Sunday);
			System.out.println(DayOfWeek.Sunday.ordinal());
			System.out.println(Season.봄);
			Season season = Season.가을;
			System.out.println(season);
			System.out.println(season.ordinal());
			System.out.println(season.name());
			System.out.println(Season.valueOf("가을"));
			Season season2 = Season.겨울;
			System.out.println(season.compareTo(season2));
			System.out.println(season.compareTo(season));
			//1(false),0(true) 반대다 c언어에선 1이상이 true 0이하가 false로 된다.
			EnumRun er = new EnumRun();
			er.today = DayOfWeek.Friday;
			System.out.println(er.today);
			System.out.println();
			for(Week week: Week.values()) {
				System.out.println(week.ordinal());
				System.out.println(week.getName());
				System.out.println(week.getOrder());
			}
			System.out.println(Week.valueOf("Friday").name());
			System.out.println(Week.Monday);
		}
	}
