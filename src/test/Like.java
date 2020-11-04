package test;

public class Like {
	private int id;
	private int parentId;
	private int memberId;
	private String date;
	
	
	
	public Like() {
		
	}
	
	public Like(int parentId, int memberId) {
		this.parentId = parentId;
		this.memberId = memberId;
	}
	
	public Like(int parentId, int memberId, String date) {
		this.parentId = parentId;
		this.memberId = memberId;
		this.date = date;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getParentId() {
		return parentId;
	}
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	

	
}
