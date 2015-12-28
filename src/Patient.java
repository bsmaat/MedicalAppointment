
public class Patient {

	private int id;
	private String name, address;
	private int dob;
	
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

	public int getDob() {
		return dob;
	}

	public void setDob(int dob) {
		this.dob = dob;
	}

	public Patient(int id, String name, String address, int dob) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.dob = dob;
	}
	
	
	
}
