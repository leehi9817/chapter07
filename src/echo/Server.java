package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) throws IOException {
		
		ServerSocket serverSocket = new ServerSocket();
		//ipconfig 명령어로 ip주소 확인
		serverSocket.bind(new InetSocketAddress("192.168.123.111", 10001));

		System.out.println("<서버시작>");
		System.out.println("================================================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		while(true) {
			Socket socket = serverSocket.accept();
			Thread thread = new ServerThread(socket);	//출장나가고, [선보강, 메세지 주고받기], 출장종료
			thread.start();
		}
		
		/*
		System.out.println("================================================");
		System.out.println("<서버종료>");
		
		serverSocket.close();
		*/
	}

}
