package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws IOException {
		//cd C:\javaStudy\workspace\chapter07\bin
		//java echo.Client
		Socket socket = new Socket();
		
		System.out.println("<클라이언트 시작>");
		System.out.println("================================================");
		System.out.println("[서버에 연결을 요청합니다.]");
		
		socket.connect(new InetSocketAddress("192.168.123.111", 10001));
		
		System.out.println("[서버에 연결 되었습니다.]");
		
		//메세지 보내기 스트림
		OutputStream os = socket.getOutputStream(); //주스트림
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw = new BufferedWriter(osw);
		
		//메세지 받기용 스트림
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//Scanner (키보드 입력용)
		//Scanner sc = new Scanner(System.in);
		
		InputStream in = System.in;
		InputStreamReader sisr = new InputStreamReader(in);
		BufferedReader sbr = new BufferedReader(sisr);
		
		while(true) {
			//String str = sc.nextLine();
			String str = sbr.readLine();
			
			if ("/q".equals(str)) {
				System.out.println("종료키 입력");
				break;
			}
			
			//메세지 보내기
			bw.write("[이혜인]"+str);
			bw.newLine();
			bw.flush();
			
			//메세지 받기
			String reMsg = br.readLine();
			System.out.println("server:[" + reMsg + "]");
		}
	
		System.out.println("================================================");
		//System.out.println("<클라이언트종료>");
		
		OutputStream out = System.out;
		OutputStreamWriter posr = new OutputStreamWriter(out);
		BufferedWriter pbw = new BufferedWriter(posr);
		
		pbw.write("<클라이언트종료> 스트림사용구현");
		pbw.newLine();
		pbw.flush();
		
		//sc.close();
		bw.close();
		br.close();
		socket.close();
	}

}
