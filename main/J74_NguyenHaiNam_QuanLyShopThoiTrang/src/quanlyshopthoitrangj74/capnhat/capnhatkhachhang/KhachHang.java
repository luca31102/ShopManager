package quanlyshopthoitrangj74.capnhat.capnhatkhachhang;

public class KhachHang {
	
	private int id;
	private String name;
	private String phone;
	
	public void display() {
		System.out.printf("%10d %-35s %-12s%n",this.id, this.name, this.phone);
	}

	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHang(int id, String name, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	
	
	
	
	
}
