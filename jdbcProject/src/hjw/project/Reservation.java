package hjw.project;

public class Reservation {
	private String id;
	

	private String service;
	private String reservationDate;
	private int price;
	
	public Reservation() {}
	
	public Reservation(String id, String service, String reservationDate, int price)
	{
		this.id = id;
		this.service = service;
		this.reservationDate = reservationDate;
		this.price = price;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}//end class
