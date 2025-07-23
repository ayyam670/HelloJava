package hjw.project;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	static MemberDAO dao = new MemberDAO();
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		ReservationDAO rdao = new ReservationDAO();
		
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
					System.out.println("정상 등록.");
				}else
				{
					System.out.println("등록 중 오류.");
				}
				break;
				
			case 2 :
				
				while(run)
				{
					System.out.println("<<< 로그인 >>>");
					System.out.print("아이디  :  ");
					String loginId = sc.nextLine();
					System.out.print("비밀번호 :  ");
					String loginPw = sc.nextLine();
					
					
					ArrayList<Member> memberList = dao.findAll(loginId , loginPw);
					
					
					if(memberList.size() > 0)
					{
						System.out.println("로그인 성공!");
						System.out.println();
						
						boolean logSs = true;
						while(logSs)
						{
							System.out.println("====메뉴 선택====");
							System.out.println("1. 정비 예약");
							System.out.println("2. 회원정보 관리");
							System.out.println("9. 프로그램 종료");
							System.out.println("===============");
							System.out.print("선택>>>  ");
							
							int choice = Integer.parseInt(sc.nextLine());
						
							   switch (choice)
							   {
				                case 1:
				                	
				                    rdao.showFromToday();
				                    
				                    System.out.println();
				                    break; 
				                case 2:
				                	
				                    memberMenu(sc, memberList);
				                    
				                    break;
				                case 9:
				                    System.out.println("프로그램 종료.\n");
				                    logSs = false; // 내부 메뉴 반복 종료
				                    break;
				                default:
				                    System.out.println("오류가 발생했습니다. 다시 시도해주세요.\n");
				                    break;
							   }
						}
			        
					}else
					{
			        System.out.println("아이디나 비밀번호가 틀렸습니다.\n");
			        //return;  //<- 로그인 반복을 끝내지 않으려면 이거 지우기
					}		
					run = false;
					
				}//end while

			case 3 : 
				System.out.println("====아이디 찾기====");
				System.out.println("이름과 전화번호를 입력해주세요.");
				name = sc.nextLine();
				phone = sc.nextLine();
				
				
				
				
			case 9 :
				//System.out.println("프로그램 종료."); ----------------이거 있으면 종료 두번뜸
				run = false;
			}
		}
		

	}//end main
	
	
	public static void memberMenu(Scanner sc, ArrayList<Member> memberList)
	//스캐너는 객체가 있어서 같은 객체를 재사용하기 위해 , 로그인에 성공한 회원의 정보를 받기위해
	{
		boolean loginMem = true;
		
		while(loginMem)
		{
			System.out.println("=======회원정보 관리=======");
			System.out.println("1. 회원정보조회");
			System.out.println("2. 구매내역조회");
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
				
				System.out.println("===================================================");
				System.out.println("이름\t아이디\t 비밀번호\t   생년월일    전화번호");
				System.out.println("===================================================");
				for(int i = 0; i < memberList.size(); i++)
				{
					System.out.println(memberList.get(i).getName()
								       + "\t"  + memberList.get(i).getId()
								       + "\t "  + memberList.get(i).getPw()
								       + "  "  + memberList.get(i).getBirth()
								       + "   "  + memberList.get(i).getPhone()
            						   );
				}
				System.out.println();
				break;
			case 2 : 
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
			}
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
	    while (run) {
	        System.out.print("회원탈퇴 하시겠습니까? (Y / N) : ");
	        String slt = sc.nextLine();

	        if (slt.equalsIgnoreCase("Y")) {
	            if (dao.delete(id, pw)) {
	                System.out.println("회원탈퇴가 완료되었습니다.\n 안녕히 가십시오.");
	                run = false; // 프로그램 종료
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
	
	

}//end class

