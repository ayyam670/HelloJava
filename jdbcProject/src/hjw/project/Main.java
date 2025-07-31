package hjw.project;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	static MemberDAO dao = new MemberDAO();
	static String Id = null;
	static ArrayList<Member> memberList = new ArrayList<>();
	static ArrayList<Reservation> list = new ArrayList<>();
	static ReservationDAO rdao = new ReservationDAO();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		
		
		while(run)
		{
			System.out.println("=======회원가입 및 로그인=======");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.println("3. 아이디 찾기");
			System.out.println("9. 종료");
			System.out.println("===========================");
			System.out.print("선택>>>  ");
			int menu = sc.nextInt(); sc.nextLine();
			
			switch(menu) {
			case 1 :
				System.out.println("<<<다음에 해당하는 내용을 입력해주세요>>>");
				System.out.println("이름))  ");
				String name = sc.nextLine();
				System.out.println("아이디))  ");
				String id = sc.nextLine();
				
				 // 중복 확인
		        if (dao.idCheck(id)) {
		            System.out.println("이미 존재하는 아이디입니다. 다른 아이디를 입력해주세요.");
		            return; // 또는 다시 입력받도록 처리
		        }
		        
				System.out.println("비밀번호))  8~12자리로 입력해주세요");
				String pw = sc.nextLine();
				System.out.println("비밀번호 확인))  ");
				String pw2 = sc.nextLine();
				System.out.println("생년월일))  YYMMDD");
				int birth = Integer.parseInt(sc.nextLine());
				System.out.println("전화번호)) - 을 포함해서 입력해주세요");
				String phone = sc.nextLine();
				
				if(!pw.equals(pw2))
				{
					System.out.println("비밀번호가 일치하지 않습니다.");
					break;
				}
				
				Member member = new Member(name, id, pw, birth, phone);
				
				
				if(dao.insert(member))
				{
					System.out.println("회원가입이 완료되었습니다.");
				}else
				{
					System.out.println("회원가입 중 오류가 발생했습니다. 다시 시도해주세요.");
				}
				break;
				
			case 2 :
				
				while(run)
				{
					System.out.println("<<< 로그인 >>>");
					System.out.print("아이디  :  ");
					Id = sc.nextLine();
					System.out.print("비밀번호 :  ");
					String loginPw = sc.nextLine();
					
					
					ArrayList<Member> memberList = dao.findAll(Id , loginPw);
					
					
					if(memberList.size() > 0)
					{
						System.out.println("로그인 성공!");
						System.out.println();
					
						
						boolean logSs = true;
						while(logSs)
						{
							System.out.println("\n====메뉴 선택====");
							System.out.println("1. 정비 예약");
							System.out.println("2. 회원정보 관리");
							System.out.println("9. 프로그램 종료");
							System.out.println("===============");
							System.out.print("\n선택>>>  ");
							
							int choice = Integer.parseInt(sc.nextLine());
						
							   switch (choice)
							   {
				                case 1 :
				                	
				                    rdao.showFromToday();//-------예약 가능한 날짜
				                    
				                    System.out.println("\n예약할 날짜를 입력해주세요>>> (예: 07-25)");
				                    String inputDate = sc.nextLine();
				                 
				                    if(!isValidDate(inputDate))
				                    {
				                    	System.out.println("날짜형식이 잘못되었습니다.");
				                    	break;
				                    }
				                    

				                    LocalDate selectedDate = convertToDate(inputDate);
				                    
				                    
				                    if (rdao.reserve(selectedDate))  // 예약 시도
				                    {
				                        System.out.println("날짜 선택이 완료되었습니다: " + selectedDate);
				                        System.out.println();
				                    } else {
				                        System.out.println("이미 예약된 날짜입니다. 다른 날짜를 선택해주세요.");
				                    }
				                    
				                    System.out.println("정비 항목을 선택해주세요>>>\n");
				                    System.out.println("1. 엔진오일");
				                    System.out.println("2. 타이어교체");
				                    System.out.println("3. 얼라이먼트");
				                    System.out.println("4. 이전 메뉴로");
				                    int jung = Integer.parseInt(sc.nextLine());
				                    
				                    String selectedService = "";
				                    
				                    switch(jung)
				                    {
				                    case 1 :
				                    	selectedService = "엔진오일";
				                    	System.out.println("1. 엔진오일을 선택하셨습니다.");
				                    	//System.out.println("예약이 완료되었습니다.");
				                    	System.out.println();
				                    	break;
				                    case 2 :
				                    	selectedService = "타이어교체";
				                    	System.out.println("2. 타이어교체를 선택하셨습니다");
				                    	//System.out.println("예약이 완료되었습니다.");
				                    	System.out.println();
				                    	break;
				                    case 3 :
				                    	selectedService = "얼라이먼트";
				                    	System.out.println("3. 얼라이먼트를 선택하셨습니다.");
				                    	//System.out.println("예약이 완료되었습니다.");
				                    	System.out.println();
				                    	break;
				                    case 4 :
				                    	System.out.println("이전 메뉴로 돌아갑니다.");
				                    	break;
				                    default : 
				                    	System.out.println("잘못 입력하셨습니다.\n이전 메뉴로 돌아갑니다.");
				                    }
				                    
				                 // 예약 완료 메시지 및 DB 저장
				                    if (!selectedService.isEmpty()) {
				                        String loginId = memberList.get(0).getId();
				                        String loginName = memberList.get(0).getName();

				                        boolean saved = rdao.saveReservation(loginId, loginName, selectedService, selectedDate);
				                        if (saved) {
				                            System.out.println("예약이 완료되었습니다.\n");
				                        } else {
				                            System.out.println("예약 실패.\n다시 시도해주세요.");
				                        }
				                    }
				                    
				                    break;
				                    
				                case 2 :
				                	
				                    memberMenu(sc, memberList, rdao);//-----------------
				                    
				                    break;
				                    
				                case 9 :
				                    System.out.println("프로그램 종료.\n");
				                    logSs = false; // 내부 메뉴 반복 종료
				                    break;
				                    
				                default:
				                    System.out.println("오류가 발생했습니다. 다시 시도해주세요.\n");
				                    break;
							   }
						}
						run = false;
						
					}else
					{
						System.out.println("아이디나 비밀번호가 틀렸습니다.\n");
						//continue;  //<- 로그인 반복을 끝내지 않으려면 이거 지우기
					}		
					
				}//end while
				break;
				
			case 3 : 
				
				System.out.println("====아이디 찾기====");
				System.out.println("이름과 전화번호를 입력해주세요.");
				System.out.print("이름 :  ");
				name = sc.nextLine();
				System.out.print("전화번호 :  ");
				phone = sc.nextLine();
				
				String foundId = dao.idphCheck(name, phone);
				
				if(foundId != null)
				{
					System.out.println("\n아이디는 |" + foundId + "| 입니다.\n");
				}else
				{
					System.out.println("일치하는 정보가 없습니다.");
				}
				break;
				
				
				
			case 9 :
				System.out.println("프로그램 종료."); //----------------이거 있으면 종료 두번뜸
				run = false;
				break;
			default :
				System.out.println("잘못 입력하셨습니다.");
				System.out.println("프로그램 종료."); //----------------이거 있으면 종료 두번뜸
				run = false;
				break;
				
			}
		}
		

	}//end main
	
	
	public static void memberMenu(Scanner sc, ArrayList<Member> memberList, ReservationDAO rdao)
	//스캐너는 객체가 있어서 같은 객체를 재사용하기 위해 , 로그인에 성공한 회원의 정보를 받기위해
	{
		boolean loginMem = true;
		
		while(loginMem)
		{
			System.out.println("\n=======회원정보 관리=======");
			System.out.println("1. 회원정보조회");
			System.out.println("2. 예약내역조회");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원탈퇴");
			System.out.println("5. 이전 메뉴로 이동");
			System.out.println("9. 프로그램 종료");
			System.out.println("========================");
			System.out.println();
			System.out.print("선택>>>  ");
			int menu = sc.nextInt(); sc.nextLine();
			System.out.println();
			
			switch(menu)
			{
			case 1 :
				
				System.out.println("====================================================");
				System.out.println("이름\t아이디\t 비밀번호\t     생년월일    전화번호");
				System.out.println("====================================================");
				for(int i = 0; i < memberList.size(); i++)
				{
					System.out.println(memberList.get(i).getName()
								       + "\t"  + memberList.get(i).getId()
								       + "\t "  + memberList.get(i).getPw()
								       + "  "  + memberList.get(i).getBirth()
								       + "   "  + memberList.get(i).getPhone()
            						   );
				}
				System.out.println("----------------------------------------------------");
				System.out.println();
				break;
				
			case 2 : 
				ArrayList<Reservation> list = rdao.getAllReservations(Id);
				
				
				System.out.println("=====================================================================");
				System.out.println("예약자ID    예약자명     연락처             정비내역     예약날짜  ");
				System.out.println("=====================================================================");
				
				 if (!memberList.isEmpty() && !list.isEmpty())
				 {
					 System.out.println(Id + "  " 
						           + " " + memberList.get(0).getName()
						           + "     " + memberList.get(0).getPhone()
						           + "     " + list.get(0).getService()
						           + "     " + list.get(0).getReservationDate());
				 } else
				 {
				     System.out.println("예약 정보 또는 회원 정보가 없습니다.");
				 }
				System.out.println("---------------------------------------------------------------------");
				System.out.println();
				break;
				
			case 3 :
				updateMem (sc, memberList);
				break;
			case 4 :
				 deleteMember(sc, memberList);
				 break;
			case 5 : 
				return;
			case 9 :
				loginMem = false;
				
			}
		}
	}//end memberMenu
	
	
	public static void updateMem(Scanner sc, ArrayList<Member> memberList)
	//스캐너는 객체가 있어서 같은 객체를 재사용하기 위해 , 로그인에 성공한 회원의 정보를 받기위해
	{
		boolean loginMem = true;
		
		
		System.out.println("회원정보수정을 선택하셨습니다.");
		System.out.println("비밀번호 확인  : ");
		String loginPw = sc.nextLine();
		
		memberList = dao.findAll2(loginPw);
		if(memberList.size() == 0)
		{
			System.out.println("비밀번호가 틀렸습니다.");
			return;
		}else
		{
			System.out.println("비밀번호 확인 완료!");
		}
		
		
		while(loginMem)
		{
			System.out.println("=====변경할 정보 선택=====");
			System.out.println("1. 비밀번호 변경");
			System.out.println("2. 전화번호 변경");
			System.out.println("======================");
			System.out.print("선택>>>");
			int upDt = sc.nextInt(); sc.nextLine();
			
			switch(upDt)
			{
			case 1 :
					System.out.print("현재 비밀번호 입력  : ");
					loginPw = sc.nextLine();
					System.out.print("변경할 비밀번호 입력 : ");
					String fPw = sc.nextLine();
					
					if(dao.update(memberList.get(0).getId(), fPw))
					{
						System.out.println("비밀번호가 변경되었습니다.");
						memberList = dao.findAll(memberList.get(0).getId(), fPw);
					}else {
						System.out.println("오류가 발생했습니다. 다시 시도해주세요.");
						return;
					}
					
					break;
				
			case 2 :
					String curPhone = memberList.get(0).getPhone();
				    System.out.println();
					System.out.println("현재 전화번호 : " + curPhone);
					System.out.print("변경 할 전화번호 입력 : ");
					String fPhone = sc.nextLine();
					
					if(dao.updatePhone(memberList.get(0).getId(), fPhone))
					{
						System.out.println("전화번호가 변경되었습니다.");
						System.out.println();
						memberList = dao.findAll(memberList.get(0).getId(), memberList.get(0).getPw());
					}else {
						System.out.println("오류가 발생했습니다. 다시 시도해주세요.");
						return;
					}
					
					break;
					
			default : 
				System.out.println("잘못 입력하셨습니다. 다시 선택해주세요.");
			}
			loginMem = false;
		}
	}//end updateMem

	
	public static void deleteMember(Scanner sc, ArrayList<Member> memberList)
	{
		boolean run = true;
	    String id = memberList.get(0).getId(); // 로그인된 회원 ID
	    System.out.print("비밀번호 확인 : ");
	    String pw = sc.nextLine();

	    // 회원 정보 다시 조회 (id + pw로 정확한 인증)
	    ArrayList<Member> checkList = dao.findAll(id, pw);

	    if (checkList.size() == 0) {
	        System.out.println("비밀번호가 틀렸습니다.\n탈퇴를 취소합니다.");
	        return;
	    }

	    // 탈퇴 의사 확인
	    while (run)
	    {
	        System.out.print("회원탈퇴 하시겠습니까? (Y / N) : ");
	        String slt = sc.nextLine();

	        if (slt.equalsIgnoreCase("Y")) {
	            if (dao.delete(id, pw)) {
	                System.out.println("회원탈퇴가 완료되었습니다.\n 안녕히 가십시오.");
	                System.exit(0); // 프로그램 종료
	            } else {
	                System.out.println("오류가 발생했습니다.\n다시 시도해주세요.");
	                return;
	            }
	        } else if (slt.equalsIgnoreCase("N")) {
	            System.out.println("회원탈퇴를 취소하였습니다.");
	            return;
	        } else {
	            System.out.println("잘못된 입력입니다. Y 또는 N을 입력해주세요.");
	        }
	    }
	}
	
	
	public static boolean isValidDate(String input) {
        // MM-dd 정규식 (01~12)-(01~31)
        String regex = "^(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";

        if (!input.matches(regex)) {
            return false; // 정규식 불일치
        }

        try {
            // 현재 연도 추가해서 전체 날짜로 만듦
            String full = LocalDate.now().getYear() + "-" + input;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // 날짜 파싱 시도
            LocalDate.parse(full, formatter);
            return true; // 유효한 날짜
        } catch (DateTimeParseException e) {
            return false; // 존재하지 않는 날짜
        }
    }
	
	
	public static LocalDate convertToDate(String mmdd) {
        // 현재 연도 가져오기
        int year = LocalDate.now().getYear();

        // "yyyy-MM-dd" 형태로 문자열 만들기
        String fullDate = year + "-" + mmdd;

        // 파서 정의
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // LocalDate로 변환
        return LocalDate.parse(fullDate, formatter);
    }

}//end class

