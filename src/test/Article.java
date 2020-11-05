package test;

public class Article {
	private int id;
	private String title;
	private String body;
	private String date;
	private String time;
	private int read;
	private String nickname;
	private String comment;
	private int like;
	private String loginId;
	
	
	public String getLoginId() {
		return loginId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public int getLike() {
		return like;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getRead() {
		return read;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Article() {

	}

	public Article(int id, String title, String body, String date, String nickname, String loginId, int read) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.date = date;
		this.nickname = nickname;
		this.loginId = loginId;
		this.read= read;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public String getPropertiesByFlag(int flag) {
		String str = "";
		if(flag == 1) {
			 str = this.getTitle(); 
		} else if(flag == 2) {
			str = this.getBody();
		} else if(flag == 3) {
			str = this.getTitle() + this.getBody(); 
		} else {
			str = this.getNickname();
		}

		return str;
	}
}