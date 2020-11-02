package test;

public class Comment {
	private int id;
	private int parentId;
	private String body;
	private String nickname;
	private String date;
	private String time;
	
	public int getId() {
		return id;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getParentId() {
		return parentId;
	}
	
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	

}
