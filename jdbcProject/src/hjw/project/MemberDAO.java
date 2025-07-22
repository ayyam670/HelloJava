package hjw.project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MemberDAO {
	public boolean insert(Member member)
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
	}
		
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
	}
	
	
	
}//end class
