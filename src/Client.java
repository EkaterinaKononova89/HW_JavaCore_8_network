import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String host = "netology.homework";//"127.0.0.1";
        int port = 8089;

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {


            String resp = in.readLine(); // 3 шаг, считываю вопрос Write your name
            System.out.println(resp); // 4 шаг, вывожу в консоль Write your name

            out.println("Katya"); // 5 шаг, отправляю имя
            System.out.println("My name is Katya"); // дублирую ответ для консоли

            String resp2 = in.readLine(); // 8 шаг, считываю новый поток Are you child?
            System.out.println(resp2); // 9 шаг, вывожу в консоль Are you child? (yes/no)

            out.println("No"); // 10 шаг, отправляю ответ серверу
            System.out.println("no"); // // дублирую ответ для консоли

            String resp3 = in.readLine(); // 13 шаг, считываю последний поток
            System.out.println(resp3); // 14 шаг, вывожу в консоль Welcome to the adult zone

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
