package hjw.project;

public class Reservation {
	private String id;
	private String name;
	private String phone;
    private String service;
	private String reservationDate;
	
	public Reservation() {}
	
	public Reservation(String id,String name, String phone, String service, String reservationDate)
	{
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.service = service;
		this.reservationDate = reservationDate;
		
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	
}//end class
