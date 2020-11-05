package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ArticleDao {
	private ArrayList<Article> articles;

	int no = 4;

	SimpleDateFormat today = new SimpleDateFormat("yyyy.MM.dd");
	Calendar c1 = Calendar.getInstance();
	String date = today.format(c1.getTime());

	SimpleDateFormat today2 = new SimpleDateFormat("HH:mm");
	Calendar c2 = Calendar.getInstance();
	String time = today2.format(c2.getTime());

	public ArticleDao() {
		articles = new ArrayList<>();

		Article test1 = new Article(1, "a", "a", "2020.10.20", "익명", "aasdfadf", 20);
		Article test2 = new Article(2, "b", "b", "2020.10.21", "익명","asdfasdf", 25);
		Article test3 = new Article(3, "c", "c", "2020.10.21", "익명","Adsfasdf", 23);

		articles.add(test1);
		articles.add(test2);
		articles.add(test3);
	}

	public void insertArticle(Article a) {
		a.setId(no);
		no++;

		articles.add(a);
		a.setDate(date);
		a.setTime(time);
	}

	public void removeArticle(Article a) {
		articles.remove(a);
	}

	public ArrayList<Article> getArticles() {
		return articles;
	}

	public Article get_Article_Id(int targetId) {
		for (int j = 0; j < articles.size(); j++) {
			Article article = articles.get(j);
			int id = article.getId();
			if (id == targetId) {
				return articles.get(j);

			}
		}
		return null;
	}

	public void searchList(int j) {
		Article article = articles.get(j);
		System.out.println("번호 : " + article.getId());
		System.out.println("제목 : " + article.getTitle());
		System.out.println("====================");
	}

	public void readList(int targetId) {
		Article target = get_Article_Id(targetId);
		
		System.out.println("===== " + targetId + "번 게시물 =====");
		System.out.println("번호 : " + target.getId());
		System.out.println("제목 : " + target.getTitle());
		if(target.getComment() == null) {
			System.out.println("작성된 댓글이 없습니다.");
		} else {
			System.out.println("댓글 : " + target.getComment());			
		}
		System.out.println("좋아요 : " + target.getLike());
		System.out.println("=======================");
		
	}
	
	public ArrayList<Article> getSearchedArticlesByFlag(int flag, String keyword) {

		ArrayList<Article> searchedArticles = new ArrayList<>();
		for (int i = 0; i < articles.size(); i++) {
			Article article = articles.get(i);
			String str = article.getPropertiesByFlag(flag);
			if (str.contains(keyword)) {
				searchedArticles.add(article);
			}
		}
		return searchedArticles;
	}

}
