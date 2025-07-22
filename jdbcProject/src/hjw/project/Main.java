package hjw.project;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		MemberDAO dao = new MemberDAO();
		
		while(run)
		{
			System.out.println("=======회원가입 및 로그인=======");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
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
						//여기에 메소드 추가
						memberMenu(sc, memberList);
						break;
					}else
					{
						System.out.println("아이디나 비밀번호가 틀렸습니다.");
					}
					
				}//end while

			case 9 :
				System.out.println("프로그램 종료");
				run = false;
			}
		}
		

	}//end main
	
	
	public static void memberMenu(Scanner sc, ArrayList<Member> memberList)
	//스캐너는 객체가 있어서 같은 객체를 재사용하기 위해 , 로그인에 성공한 회원의 정보를 받기위해
	{
		boolean loginMem = true;
		MemberDAO dao = new MemberDAO();
		
		while(loginMem)
		{
			System.out.println("=======회원정보관리=======");
			System.out.println("1. 회원정보조회");
			System.out.println("2. 구매내역조회");
			System.out.println("3. 회원정보수정");
			System.out.println("4. 회원탈퇴");
			System.out.println("5. 프로그램 종료");
			System.out.println("=======================");
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
				
			case 2 : 
			case 3 :
				System.out.println("비밀번호 확인  : ");
				String loginPw = sc.nextLine();
				
				memberList = dao.findAll2(loginPw);
				
				
				if(memberList.size() > 0)
				{
					System.out.print("현재 비밀번호 입력  : ");
					nPw = sc.nextLine();
					System.out.print("변경할 비밀번호 입력 : ");
					fPw = sc.nextLine();
					
					break;
				}else
				{
					System.out.println("비밀번호가 틀렸습니다.");
				}
				
			case 4 :
			case 5 :
			}
			
			
		}
	}
}//end class
