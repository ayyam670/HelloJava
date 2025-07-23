package hjw.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	public boolean insert(Member member)//------------------------------------------insert
	{
		Connection conn = DBUtil.getConnect();
		String query = "insert into member1(name, id, pw, birth, phone)"
				       +" values(?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			
			stmt.setString(1, member.getName());
			stmt.setString(2, member.getId());
			stmt.setString(3, member.getPw());
			stmt.setInt(4, member.getBirth());
			stmt.setString(5, member.getPhone());
			
			int r = stmt.executeUpdate();
			if(r > 0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}//end insert
	
    public boolean idCheck(String id)//-------------------------------------아이디 중복체크
    {
        Connection conn = DBUtil.getConnect();
        String query = "SELECT id FROM member1 WHERE id = ?";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // 아이디가 이미 존재함
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // 중복 아님
    }
    
    public String idphCheck(String name, String phone)//------------------------------아이디 찾기
    {
    	Connection conn = DBUtil.getConnect();
    	String query = "SELECT * FROM member1 WHERE name = ? AND phone = ? ";
    	
    		
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, name);
    		stmt.setString(2, phone);
    		
    		ResultSet ch = stmt.executeQuery();
    		
    		if(ch.next())
    		{
    			return ch.getString("id");
    		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return null;	
    	
    }
    
	

	public boolean update(String id, String fPw)//----------------------------pw update
	{
		Connection conn = DBUtil.getConnect();
		String query = "update member1 "
						+ "set pw = ? "
						+ "where id = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, fPw);
			stmt.setString(2, id);
			
			int r = stmt.executeUpdate();
			if(r > 0) //= 한건 입력이 되었으면
			{
				return true; 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updatePhone(String id, String newPhone)//-------------------------phone update
	{
		Connection conn = DBUtil.getConnect();
		String query = "update member1 "
						+ "set phone = ? "
						+ "where id = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, newPhone);
			stmt.setString(2, id);
			
			int r = stmt.executeUpdate();
			if(r > 0) //= 한건 입력이 되었으면
			{
				return true; 
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean delete(String id, String pw)//-----------------------------------------delete
	{
		Connection conn = DBUtil.getConnect();
		String query = "delete from member1 "
				       + "where id = ? "
				       + "and pw = ? ";
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
			int r = stmt.executeUpdate();
			if(r > 0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public ArrayList<Member> findAll(String id, String pw)
	{
		Connection conn = DBUtil.getConnect();
		ArrayList<Member> list = new ArrayList<Member>();
		Statement stmt;
		
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from member1 where id = '"+ id +"' and pw = '" + pw + "'");
			
			while(rs.next())
			{
				Member member = new Member();
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setBirth(rs.getInt("birth"));
				member.setPhone(rs.getString("phone"));
				
				list.add(member);		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}//end findAll
		
		public ArrayList<Member> findAll2(String pw)
		{
			Connection conn = DBUtil.getConnect();
			ArrayList<Member> list = new ArrayList<Member>();
			Statement stmt;
			
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select * from member1 where pw =  '" + pw + "'");
				
				while(rs.next())
				{
					Member member = new Member();
					member.setName(rs.getString("name"));
					member.setId(rs.getString("id"));
					member.setPw(rs.getString("pw"));
					member.setBirth(rs.getInt("birth"));
					member.setPhone(rs.getString("phone"));
					
					list.add(member);		
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}//end findAll2
	
	
	
}//end class
