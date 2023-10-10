package ThirdAssignment;

public abstract class Staff extends User {

	public Staff(String userName, int password) {
		super(userName, password);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public abstract void viewPersonalInfo(); //Abstract metodu abstract override edip subclassların farklı infolarını override etmeye zorladım.

	public void permissionRequest() {
		System.out.println("İzin talep edildi");
		
	}
	
}
