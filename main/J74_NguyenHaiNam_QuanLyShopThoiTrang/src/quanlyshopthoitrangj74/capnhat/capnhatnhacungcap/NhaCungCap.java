package quanlyshopthoitrangj74.capnhat.capnhatnhacungcap;

public class NhaCungCap {
	private int id;
	private String name;
	private String address;
	
	public void display() {
		System.out.printf("%10d %-35s %-55s%n", this.id, this.name, this.address);
	}
	
	public NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhaCungCap(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	
	
	
}
