package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class LikeDao {
	private ArrayList<Like> likes;
	private int no = 1;
	
	SimpleDateFormat today = new SimpleDateFormat("yyyy.MM.dd");
	Calendar c1 = Calendar.getInstance();
	String date = today.format(c1.getTime());
	
	
//	 이거 꼭 해야 리스트가 됨
	public LikeDao() {
		likes = new ArrayList<>();
	}
	
	public void insertLike(Like a) {
		a.setId(no);
		no++;
		a.setDate(date);

		likes.add(a);
	}

	public Like getLike(int aid, int mid) {
		for(int j = 0; j < likes.size(); j++) {
			Like like = likes.get(j);
			if(like.getParentId() == aid && like.getMemberId() == mid) {
				return like;
			}
		}
		return null;
	}
	
	public void removeLike(Like rst) {
		likes.remove(rst);		
	}

	public int getLikeCount(int id) {
		int cnt = 0;
		for(int i = 0; i < likes.size(); i++) {
			Like like = likes.get(i);
			if(like.getParentId() == id) {
				cnt++;
			}
		}
		return cnt;
	}

}
