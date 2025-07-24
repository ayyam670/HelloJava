package hjw.project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ReservationDAO {
	Connection conn = DBUtil.getConnect();
	static MemberDAO dao = new MemberDAO();
	private Set<LocalDate> reservedDates = new HashSet<>();// 예약된 날짜들을 저장하는 Set (중복을 자동으로 막아줌)
	//ArrayList<Member> memberList = dao.findAll(Id , loginPw);
	
	
	public void showFromToday()
	{
	    LocalDate today = LocalDate.now();                        // 오늘 날짜
	    LocalDate oneMonthLater = today.plusDays(30);             // 30일 뒤 날짜

	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM월 dd일 (E)");
	    System.out.println("예약 가능한 날짜:");

	    int count = 0;
	    LocalDate current = today;

	    while (!current.isAfter(oneMonthLater)) {
	        System.out.print(current.format(formatter) + " ");
	        count++;

	        if (count % 7 == 0) {
	            System.out.println(); // 7개마다 줄바꿈
	        }

	        current = current.plusDays(1); // 다음 날짜로 이동
	    }

	    System.out.println(); // 마지막 줄 줄바꿈
	}//----------------------------------------------
	
	
	
	public boolean isReserved(LocalDate date) // 특정 날짜가 이미 예약되어 있는지 확인
    {
        return reservedDates.contains(date);
    }//----------------------------------------------

    
	
	
    public boolean reserve(LocalDate date) // 날짜 예약 시도 (성공하면 true, 이미 예약되었으면 false)
    {
        if (isReserved(date)) return false; // 이미 예약된 날짜는 예약 불가
        reservedDates.add(date);            // 예약 등록
        return true;
    }//-----------------------------------------------
	
	
	
	public boolean insertRev(String id, String service, LocalDate date)
	{
		
		String query = "insert into maintenance(id, service,  reservation_date) "
				      +" values(?, ?, ?)";
		
		try {
			PreparedStatement rstmt = conn.prepareStatement(query);
			
			rstmt.setString(1, id);
			rstmt.setString(2, service);
			rstmt.setDate(3, Date.valueOf(date));
			
			
			int r = rstmt. executeUpdate();
			if(r > 0)
			{
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return false;
	}
	
	
    
	public boolean saveReservation(String id, String name, String service, LocalDate date)//-----------------------------다시 보기 
	{
	    //Connection conn = DBUtil.getConnection();
	    String sql = "INSERT INTO maintenance (id, name, service, reservation_date) VALUES (?, ?, ?, ?)";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, id);
	        pstmt.setString(2, name);
	        pstmt.setString(3, service);
	        pstmt.setDate(4, java.sql.Date.valueOf(date));

	        int result = pstmt.executeUpdate();
	        return result > 0;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        try { if (conn != null) conn.close(); } catch (SQLException e) {}
	    }
	}
	
	
	public ArrayList<Reservation> getAllReservations(String id) {
	    ArrayList<Reservation> list = new ArrayList<Reservation>();
	    
	    String sql = "SELECT * FROM maintenance WHERE id = '" + id + "' ORDER BY reservation_date";

	    try {
	    	Statement pstmt = conn.createStatement();
	         ResultSet rs = pstmt.executeQuery(sql);
	        while (rs.next()) {
	            Reservation r = new Reservation();
	            r.setId(rs.getString("id"));
	            r.setName(rs.getString("name"));
	            r.setService(rs.getString("service"));
	            r.setReservationDate(rs.getString("reservation_date"));

	            list.add(r);
	        }

	        conn.close(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 

	    return list;
	}
	
	
}//end class
