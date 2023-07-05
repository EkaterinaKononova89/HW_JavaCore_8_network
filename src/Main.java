import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        int port = 8089;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("server started");

            while (true) {
                try (Socket clientSocket = serverSocket.accept(); // ждем подключения
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    out.println("Write your name"); // 2 шаг после подключения

                    final String name = in.readLine(); // 6 шаг, считывает имя клиента
                    out.println(name + ", are you child? (yes/no)"); // 7 шаг, отправляет поток Клиенту

                    String yesOrNo = in.readLine(); // 11 шаг, считываю ответ клиента (yes/no)
                    if (yesOrNo.equalsIgnoreCase("yes")) {
                        out.printf("Welcome to the kids area, %s! Let's play!", name); // 12 шаг, отправляю последний поток
                    } else if (yesOrNo.equalsIgnoreCase("no")) {
                        out.printf("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name);
                    }
                }
            }
        }
    }
}
