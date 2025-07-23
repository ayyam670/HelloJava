package hjw.project;

public class Member {
	private String name;
	private String id;
	private String pw;
	private int birth;
	private String phone;
	
	public Member() {} //기본 생성자  DAO에서 Member객체를 생성할 떄 필요
	
	public Member(String name, String id, String pw, int birth, String phone)
	{
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.birth = birth;
		this.phone = phone;
	}
	
	
	
	
	
	//getter setter 생성
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


}//end class
