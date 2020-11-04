package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MemberDao {
	
	private ArrayList<Member> members;
	private int no = 2;

	SimpleDateFormat today = new SimpleDateFormat("yyyy.MM.dd");
	Calendar c1 = Calendar.getInstance();
	String date = today.format(c1.getTime());

	public MemberDao() {
		members = new ArrayList<>();

		Member test1 = new Member(1, "hong123", "1234", "홍길동");
//		comment test2 = new comment(2, "b", "b", "2020.10.21", "익명");
//		comment test3 = new comment(3, "c", "c", "2020.10.21", "익명");
//
		members.add(test1);
//		comments.add(test2);
//		comments.add(test3);
	}

	public ArrayList<Member> getMembers() {
		return members;
	}

	public void setSignups(ArrayList<Member> signups) {
		this.members = signups;
	}

	public void insertMembers(Member a) {
		a.setId(no);
		no++;
		a.setDate(date);

		members.add(a);
	}

	
//	public Member getMemberByLogin(String id, String pw) {
//		int n = 0;
//		for (int j = 0; j < members.size(); j++) {
//			Member member = members.get(j);
//			if (member.getLoginId().equals(id)) {
//				if (member.getLoginPw().equals(pw)) {
//					n = 1;
//					System.out.println(member.getNickName() + "님 환영합니다");
//					return member;
//				}
//			}
//			return null;
//		}
//		if (n == 0) {
//			System.out.println("비밀번호를 틀렸거나 잘못된 회원정보입니다.");
//		}
//	}
	
}
