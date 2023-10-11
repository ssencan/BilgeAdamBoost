package FourthAssignment;

public abstract class User {
	
	private final String userName; //Genelde username TC gibi bir değer olduğundan değişmiyor.Immutable
	private int password;//Alt sınıflardan erişilip değişebilsin mi ???????

	public User(String userName,int password) {
		this.userName = userName;
		this.password = password;// ilk şifre ataması sistem tarafından
		//System.out.println("User constr girildi");
	}

    public abstract void viewPersonalInfo();
	
	public String getUserName() {
		return userName;
	}
		
	public int getPassword() {
		return password;
		
	}

	public void setPassword(int password) {
		this.password = password;
		
	}
	
	public void  login() {
		System.out.println("Giriş yapıldı");
	}
	

}
