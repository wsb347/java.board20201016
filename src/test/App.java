package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class App {

	CommentDao commentdao = new CommentDao();
	ArticleDao articledao = new ArticleDao();
	MemberDao memberdao = new MemberDao();
	Member loginedMember = null;
	LikeDao likedao = new LikeDao();
	LikeDao likeMemebrs = null;
	ArrayList<Article> likeMember = new ArrayList<>();

	public void start() {
		for (;;) {
			if (loginedMember == null) {
				System.out.println("명령어를 입력해주세요 : ");
			} else {
				System.out.println(
						"명령어 입력[" + loginedMember.getLoginId() + "(" + loginedMember.getNickName() + ")" + "] : ");
			}
			Scanner sc = new Scanner(System.in);
			String i = sc.nextLine();

			if (i.equals("exit")) {
				System.out.println("프로그램이 종료됩니다.");
				break;
			} // exit 종료

			if (i.equals("help")) {
				System.out.println("article [add: 게시물 추가 / list : 게시물 목록 조회 / read : 게시물 조회 / search : 검색]\r\n"
						+ "member [signup : 회원가입 / signin : 로그인 / findpass : 비밀번호 찾기 / findid : 아이디 찾기 / logout : 로그아웃 / myinfo : 나의 정보 확인및 수정]");
			} // help 도움말

//			-------------------------------article-------------------------------------------

			if (i.equals("article add")) {
				if (isLogin()) {
					Article a = new Article();

					a.setNickname(loginedMember.getNickName());
					System.out.println("게시물 제목을 입력해주세요 :");
					String title = sc.next();
					a.setTitle(title);
					System.out.println("게시물 내용을 입력해주세요 : ");
					String body = sc.next();
					a.setBody(body);
					a.setLoginId(loginedMember.getLoginId());

					articledao.insertArticle(a);
					System.out.println("게시물이 등록되었습니다.");
				}
			} // add 추가

			if (i.equals("article list")) {
				ArrayList<Article> articles = articledao.getArticles();

				for (int j = 0; j < articles.size(); j++) {
					Article article = articles.get(j);
					System.out.println("번호 : " + article.getId());
					System.out.println("제목 : " + article.getTitle());
					if (loginedMember == null) {
						System.out.println("작성자 : 익명");
					} else {
						System.out.println("작성자 : " + article.getNickname());
					}
					if (article.getDate().equals(articledao.date)) {
						System.out.println("등록시간 : " + article.getTime());
					} else {
						System.out.println("등록날짜 : " + article.getDate());
					}
					System.out.println("조회수 : " + article.getRead());
					System.out.println("====================");
				}
			} // list 목록

			if (i.equals("article update")) {

				System.out.println("수정할 게시물 선택 : ");
				int targetId = sc.nextInt();
				Article target = articledao.get_Article_Id(targetId);
				if (target == null) {
					System.out.println("없는 게시물입니다.");
				} else {
					System.out.println("게시물 제목을 입력해주세요 :");
					String newTitle = sc.next();

					System.out.println("게시물 내용을 입력해주세요 :");
					String newBody = sc.next();

					target.setTitle(newTitle);
					target.setBody(newBody);
					System.out.println("수정이 완료되었습니다.");
				}
			} // update 수정

			if (i.equals("article delete")) {
				ArrayList<Article> articles = articledao.getArticles();
				System.out.println("삭제할 게시글의 번호을 입력해주세요 : ");
				int targetId = sc.nextInt();
				Article target = articledao.get_Article_Id(targetId);
				if (target == null) {
					System.out.println("없는 게시물입니다.");
				} else {
					articledao.removeArticle(target);
					System.out.println(targetId + "번 게시글이 삭제되었습니다.");
				}
			} // delete 삭제

			if (i.equals("article read")) {
				if (isLogin()) {
					System.out.println("상세보기 하실 게시글의 번호을 입력해주세요 : ");
					int targetId = sc.nextInt();
					Article target = articledao.get_Article_Id(targetId);
					if (target == null) {
						System.out.println("없는 게시물입니다.");
					} else {
						target.setRead(target.getRead() + 1);

						printArticle(target);
						while (true) {
							System.out.println("상세보기 기능을 선택해주세요(1. 댓글 등록, 2. 좋아요, 3. 수정, 4. 삭제, 5. 목록으로) : ");
							int targetnum = sc.nextInt();

							if (targetnum == 1) {
								Comment r = new Comment();

								System.out.println("댓글 내용을 입력해주세요:");
								String body = sc.next();
								r.setParentId(target.getId());
								r.setBody(body);
								r.setNickname(loginedMember.getNickName());
								r.setParentId(targetId);

								commentdao.insertcomment(r);
								System.out.println("댓글이 등록되었습니다.");
								printArticle(target);

							}

							else if (targetnum == 2) {
								Like rst = likedao.getLike(target.getId(), loginedMember.getId());
								if (rst == null) {
									Like like = new Like(target.getId(), loginedMember.getId());
									likedao.insertLike(like);
									target.setLike(target.getLike() + 1);
									System.out.println("해당 게시물을 좋아합니다.");
									System.out.println("좋아요 누른 멤버 : " + likeMember);
								} else {
									likedao.removeLike(rst);
									target.setLike(target.getLike() - 1);
									System.out.println("해당 게시물의 좋아요를 해제합니다.");
									likeMember.remove(loginedMember.getNickName());
									System.out.println("좋아요 누른 멤버 : " + likeMember);
								}

								printArticle(target);

							} else if (targetnum == 3) {

								if (target.getLoginId().equals(loginedMember.getLoginId())) {
									System.out.println("게시물 제목을 입력해주세요 :");
									String newTitle = sc.next();
									System.out.println("게시물 내용을 입력해주세요 :");
									String newBody = sc.next();

									target.setTitle(newTitle);
									target.setBody(newBody);
								} else {
									System.out.println("자신의 게시물만 수정/삭제 할 수 있습니다.");
								}

							} else if (targetnum == 4) {
								if (target.getLoginId().equals(loginedMember.getLoginId())) {
									articledao.removeArticle(target);
									System.out.println(targetId + "번 게시글이 삭제되었습니다.");
									break;

								} else {
									System.out.println("자신의 게시물만 수정/삭제 할 수 있습니다.");
								}
							} else if (targetnum == 5) {
								break;
							}
						}
					}
				}
			} // read 상세목록

			if (i.equals("article search")) {
				System.out.println("검색 항목을 선택해주세요 (1. 제목, 2. 내용, 3. 제목 + 내용, 4. 작성자) :  ");
				int targetId = sc.nextInt();
				Article target = articledao.get_Article_Id(targetId);
				System.out.println("검색 키워드를 입력해주세요 : ");
				String keyword = sc.next();

				ArrayList<Article> searchedArticles;
				searchedArticles = articledao.getSearchedArticlesByFlag(targetId, keyword);
				printArticles(searchedArticles);
			} // search 검색

			if (i.equals("article sort")) {
				System.out.println("정렬 대상을 선택해주세요. (like : 좋아요,  read : 조회수) :");
				String sortType = sc.nextLine();
				System.out.println("정렬 방법을 선택해주세요. (asc : 오름차순,  desc : 내림차순) :");
				String sortOrder = sc.nextLine();
				MyComparator comp = new MyComparator();
				comp.sortOrder = sortOrder;
				comp.sortType = sortType;
				// 조회수로 오름차순
				ArrayList<Article> articles = articledao.getArticles();
				Collections.sort(articles, comp);
				printArticles(articles);
			} // sort 정렬

			if (i.equals("article page")) {
				ArrayList<Article> articles = articledao.getArticles();
				System.out.println("페이지 번호를 입력하세요");
				int no = sc.nextInt();
				
				
			} // page 페이징
			

//			-------------------------------member-----------------------------------------

			if (i.equals("member signup")) {
				System.out.println("==== 회원 가입을 진행합니다 ====");
				Member member = new Member();

				while (true) {
					System.out.print("아이디를 입력해주세요 : ");
					String loginid = sc.next();
					if (CheckId(loginid)) {
						member.setLoginId(loginid);
						break;
					} else {
						System.out.println("중복된 아이디입니다.");
					}
				}

				System.out.print("비밀번호를 입력해주세요 : ");
				String loginpw = sc.next();
				member.setLoginPw(loginpw);
				System.out.print("닉네임을 입력해주세요 : ");
				String nickName = sc.next();
				member.setNickName(nickName);

				memberdao.insertMembers(member);
				System.out.println("==== 회원가입이 완료되었습니다. ====");
			} // signup 회원가입

			if (i.equals("member login")) {
				ArrayList<Member> members = memberdao.getMembers();

				System.out.print("아이디를 입력해주세요 : ");
				String loginid = sc.next();
				System.out.print("비밀번호를 입력해주세요 : ");
				String loginpw = sc.next();
				int n = 0;
				for (int j = 0; j < members.size(); j++) {
					Member member = members.get(j);
					if (member.getLoginId().equals(loginid)) {
						if (member.getLoginPw().equals(loginpw)) {
							n = 1;
							System.out.println(member.getNickName() + "님 환영합니다");
							loginedMember = member;
						}
					}
				}
				if (n == 0) {
					System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
				}
			} // login 로그인

			if (i.equals("member logout")) {
				if (isLogin()) {
					loginedMember = null;
					System.out.println("로그아웃 되었습니다");
				}
			} // logout 로그아웃

		} // for 무한반복
	}

	private void printArticles(ArrayList<Article> articleList) {
		for (int i = 0; i < articleList.size(); i++) {
			Article article = articleList.get(i);
			System.out.println("번호 : " + article.getId());
			System.out.println("제목 : " + article.getTitle());
			System.out.println("등록날짜 : " + article.getDate());
			System.out.println("작성자 : " + article.getNickname());
			System.out.println("조회수 : " + article.getRead());
			System.out.println("===================");
		}
	}

	private void printComments(ArrayList<Comment> commentList) {
		for (int i = 0; i < commentList.size(); i++) {
			Comment comment = commentList.get(i);
			System.out.println("내용 : " + comment.getBody());
			System.out.println("작성자 : " + comment.getNickname());
			if (comment.getDate().equals(comment.getDate())) {
				System.out.println("등록시간 : " + comment.getTime());
			} else {
				System.out.println("등록날짜 : " + comment.getDate());
			}
			System.out.println("===================");
		}
	}

	private void printArticle(Article target) {
		System.out.println("==== " + target.getId() + " ====");
		System.out.println("번호 : " + target.getId());
		System.out.println("제목 : " + target.getTitle());
		System.out.println("내용 : " + target.getBody());
		if (target.getDate().equals(articledao.date)) {
			System.out.println("등록시간 : " + target.getTime());
		} else {
			System.out.println("등록날짜 : " + target.getDate());
		}
		int likeCnt = likedao.getLikeCount(target.getId());
		System.out.println("좋아요 : " + likeCnt);
		System.out.println("===============");
		System.out.println("================댓글==============");

		ArrayList<Comment> comments = commentdao.getCommentsByParentId(target.getId());
		printComments(comments);
	}

	private boolean isLogin() {
		if (loginedMember == null) {
			System.out.println("로그인이 필요한 기능입니다.");
			return false;
		} else {
			return true;
		}
	}

	private boolean CheckId(String loginid) {
		ArrayList<Member> members = memberdao.getMembers();
		int a = 0;
		for (int j = 0; j < members.size(); j++) {
			Member member = members.get(j);
			if (member.getLoginId().equals(loginid)) {
				a = 1;
				return false;
			}
		}
		if (a == 0) {
			return true;
		}
		return false;
	}

}

class MyComparator implements Comparator<Article> {

	String sortOrder = "asc";
	String sortType = "read";

	@Override
	public int compare(Article o1, Article o2) {
		int c1 = o1.getRead();
		int c2 = o2.getRead();

		if (sortType.equals("read")) {
			c1 = o1.getRead();
			c2 = o2.getRead();
		} else if (sortType.equals("like")) {
			c1 = o1.getLike();
			c2 = o2.getLike();
		}

		if (sortOrder.equals("asc")) {
			if (c1 > c2) {
				return 1;
			}

			return -1;
		} else {
			if (c1 < c2) {
				return 1;
			}

			return -1;
		}
	}

}
