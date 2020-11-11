package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class test3 {
	public static void main(String[] args) {

//		Json 읽기 (디코딩)
//		String jsonStr = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
//		JSONArray array = (JSONArray) JSONValue.parse(jsonStr);
//
//		System.out.println(array.get(1));
//		System.out.println();
//
//		JSONObject obj2 = (JSONObject) array.get(1); // 맵
//		System.out.println("Field \"1\"");
//		System.out.println(obj2.get("1"));

		JSONObject obj = new JSONObject();
		String jsonText;

		obj.put("id", new Integer(1));
		obj.put("title", "안녕하세요");
		obj.put("body", "파일저장");
		obj.put("nickname", "홍길동");
		jsonText = obj.toString();

		System.out.println("Encode a JSON Object - to String");
		System.out.println(jsonText);

		JSONObject jobj = (JSONObject) JSONValue.parse(jsonText);
		String s1 = (String) jobj.get("title");
		long s2 = (long) jobj.get("id");
		String s3 = (String) jobj.get("body");
		String s4 = (String) jobj.get("nickname");

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);

//		Json 쓰기 (인코딩)
//		JSONArray list = new JSONArray();
//		String jsonText;
//
//		list.add("foo");
//		list.add(new Integer(100));
//		list.add(new Double(1000.21));
//		list.add(new Boolean(true));
//		list.add(null);
//		jsonText = list.toString();
//
//		System.out.println("Encode a JSON Array - to String");
//		System.out.print(jsonText);
		
		

		
		
		// 파일 쓰기
		try {
			// 파일 객체 생성
			File file = new File("C:/test/test.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

			if (file.isFile()) {
				// 쓰기
				bufferedWriter.write(jsonText);
				// 개행문자쓰기
				bufferedWriter.newLine();
				bufferedWriter.write(jsonText);

				bufferedWriter.close();
			}
		} catch (IOException e) {
			System.out.println(e);
		}

		// 파일 읽기
		try {
			// 파일 객체 생성
			File file = new File("C:/test/test.txt");
			// 입력 스트림 생성
			FileReader filereader = new FileReader(file);
			// 입력 버퍼 생성
			BufferedReader bufReader = new BufferedReader(filereader);
			String line = "";
			while ((line = bufReader.readLine()) != null) {
				System.out.println(line);
			}
			// .readLine()은 끝에 개행문자를 읽지 않는다.
			bufReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}

	}
}
