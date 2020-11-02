package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class CommentDao {

	private ArrayList<Comment> comments;

	int no = 4;

	SimpleDateFormat today = new SimpleDateFormat("yyyy.MM.dd");
	Calendar c1 = Calendar.getInstance();
	String date = today.format(c1.getTime());

	SimpleDateFormat today2 = new SimpleDateFormat("HH:mm");
	Calendar c2 = Calendar.getInstance();
	String time = today2.format(c2.getTime());

	public CommentDao() {
		comments = new ArrayList<>();

//		comment test1 = new comment(1, "a", "a", "2020.10.20", "익명");
//		comment test2 = new comment(2, "b", "b", "2020.10.21", "익명");
//		comment test3 = new comment(3, "c", "c", "2020.10.21", "익명");
//
//		comments.add(test1);
//		comments.add(test2);
//		comments.add(test3);
	}

	public void insertcomment(Comment a) {
		a.setId(no);
		no++;
		a.setTime(time);
		a.setDate(date);

		comments.add(a);
	}

	public void removecomment(Comment a) {
		comments.remove(a);
	}

	public ArrayList<Comment> getcomments() {
		return comments;
	}

	public ArrayList<Comment> getReplies() {
		return comments;
	}

	public ArrayList<Comment> getCommentsByParentId(int parentId) {
		ArrayList<Comment> searchedcomments = new ArrayList<>();
		for (int i = 0; i < comments.size(); i++) {
			Comment comment = comments.get(i);
			if (comment.getParentId() == parentId) {
				searchedcomments.add(comment);
			}
		}
		return searchedcomments;
	}

//	public static comment get_comment_Id(int targetId) {
//		for (int j = 0; j < comments.size(); j++) {
//			Article comments = comments.get(j);
//			int id = comments.getId();
//			if (id == targetId) {
//				return comments.get(j);
//
//			}
//		}
//		return null;
//	}

//	public ArrayList<Article> getSearchedCommentsByFlag(int flag, String keyword) {
//
//		ArrayList<comment> searchedComments = new ArrayList<>();
//		for (int i = 0; i < comments.size(); i++) {
//			Article comment = comments.get(i);
//			String str = article.getPropertiesByFlag(flag);
//			if (str.contains(keyword)) {
//				searchedComments.add(article);
//			}
//		}
//		return searchedComments;
//	}

}
