package cn.hsiaopan.learnjava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket severSocket = new ServerSocket(8080);  // 监听端口
        System.out.println("Server is running...");
        for (; ; ) {
            Socket socket = severSocket.accept();
            System.out.println("connected from " + socket.getRemoteSocketAddress());
            Thread thread = new Handler(socket);
            thread.start();
        }

    }
}

class Handler extends Thread {
    Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = this.socket.getInputStream()) {
            try (OutputStream outputStream = this.socket.getOutputStream()) {
                handle(inputStream, outputStream);
            }
        } catch (Exception e) {
            try {
                this.socket.close();
            } catch (IOException ioException) {

            }
            System.out.println("Client disconnected.");
        }
    }

    private void handle(InputStream inputStream, OutputStream outputStream) throws IOException {
        System.out.println("Process new http request...");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));

        // 读取HTTP请求
        boolean requestOK = false;
        String first = bufferedReader.readLine();
        if (first.startsWith("GET / HTTP/1.")) {
            requestOK = true;
        }
        for (; ; ) {
            String header = bufferedReader.readLine();
            if (header.isEmpty()) {
                break;
            }
            System.out.println(header);
        }
        System.out.println(requestOK ? "Response OK" : "Response Error");
        if (!requestOK) {
            bufferedWriter.write("404 Not Found\r\n");
            bufferedWriter.write("Content-Length: 0\r\n");
            bufferedWriter.write("\r\n");
            bufferedWriter.flush();
        } else {
            String data = "<html><body><h1>Hello, world!</h1></body></html>";
            int length = data.getBytes(StandardCharsets.UTF_8).length;
            bufferedWriter.write("HTTP/1.0 200 OK\r\n");
            bufferedWriter.write("Connection: close\r\n");
            bufferedWriter.write("Content-Type: Text/html\r\n");
            bufferedWriter.write("Content-Length: " + length + "\r\n");
            bufferedWriter.write("\r\n");
            bufferedWriter.write(data);
            bufferedWriter.flush();
        }
    }
}
