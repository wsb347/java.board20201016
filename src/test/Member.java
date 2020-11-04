package test;

public class Member {
	private int id;
	private String loginId;
	private String loginPw;
	private String nickName;
	private String date;
	
	
	
	public Member() {
		
	}
	
	public Member(int id, String loginId, String loginPw, String nickName) {
		this.id = id;
		this.loginId = loginId;
		this.loginPw = loginPw;
		this.nickName = nickName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getLoginPw() {
		return loginPw;
	}

	public void setLoginPw(String loginPw) {
		this.loginPw = loginPw;
	}


	public String getNickName() {
		return nickName;
	}
	
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	
}
