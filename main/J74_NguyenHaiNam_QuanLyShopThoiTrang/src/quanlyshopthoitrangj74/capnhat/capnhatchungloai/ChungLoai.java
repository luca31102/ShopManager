package quanlyshopthoitrangj74.capnhat.capnhatchungloai;

public class ChungLoai {
	private int id;
	private String name;
	private String description;
	
	public void display() {
		System.out.printf("%10d %-30s %-55s%n", this.id, this.name, this.description);
	}
	
	public ChungLoai() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ChungLoai(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
