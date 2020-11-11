package test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.json.simple.JSONObject;

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

//		Article test1 = new Article(1, "a", "a", "2020.10.20", "익명", "aasdfadf", 20);
//		Article test2 = new Article(2, "b", "b", "2020.10.21", "익명","asdfasdf", 25);
//		Article test3 = new Article(3, "c", "c", "2020.10.21", "익명","Adsfasdf", 23);
//
//		articles.add(test1);
//		articles.add(test2);
//		articles.add(test3);
		
		for(int i = 1; i <= 50 ; i++) {
			Article a4 = new Article();
			a4.setId(i);
			a4.setTitle("제목" + i);
			a4.setBody("내용" + i);
			a4.setNickname("익명");
			a4.setDate("2020.11.09");
			articles.add(a4);
			
		}
	}
	
	public void writeJsonFile(JSONObject jobj) {
		try {
			// 파일 객체 생성
			int id = (int)jobj.get("id");
			String filePath = "C:/test/article_" + id;
			
			File file = new File("C:/test/article1.json");
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

			if (file.isFile()) {
				// 쓰기
				bufferedWriter.write(filePath);
				// 개행문자쓰기
				bufferedWriter.newLine();
				bufferedWriter.write(filePath);

				bufferedWriter.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public JSONObject articleToJsonText(Article article) {
		JSONObject obj = new JSONObject();
		String jsonText;

		obj.put("id", article.getId());
		obj.put("title", article.getTitle());
		obj.put("body", article.getBody());
		obj.put("nickname", article.getNickname());
		obj.put("read", article.getRead());
		obj.put("like", article.getLike());
		obj.put("date", article.getDate());
		obj.put("time", article.getTime());
	
		return obj;
	}
	
	public void insertArticle(Article a) {
		a.setId(no);
		no++;
		a.setDate(date);
		a.setTime(time);
		
		JSONObject jobj = articleToJsonText(a);
		writeJsonFile(jobj);
		
//		articles.add(a);
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
