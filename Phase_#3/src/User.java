
public class User {
	private String name;
	private String email;
	private String password;
	private String userName;
	private char gender;
	private int age;

	public User(String name, String email, String password, String userName, char gender, int age) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
	}

	public User() {
		super();
		this.name = null;
		this.email = null;
		this.password = null;
		this.userName = null;
		this.gender = '\0';
		this.age = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
