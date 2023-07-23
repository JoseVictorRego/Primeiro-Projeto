import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "127.0.0.1"; // ip do serivor mais pode ser o dns.
    private Socket clientSocket; //o socket do client
    private Scanner scanner;     // função scanner
    private BufferedWriter out;

    public ChatClient(){
        scanner = new Scanner(System.in); //chat do servidor
    }

    public void start() throws IOException{
        clientSocket = new Socket(SERVER_ADDRESS, ChatServer.PORT);
        
        this.out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream())); //poder enviar um conjunto de string
        
        System.out.println("Cliente conectado ao servidor em " + SERVER_ADDRESS + " : " + ChatServer.PORT);
        messageLoop();
    }

    private void messageLoop() throws IOException{
        String msg;
        do{
            System.out.print("\nDigite (ou 'sair' para finalizar): ");
            msg = scanner.nextLine();
            out.write(msg);
            out.newLine();
            out.flush();

        }while(!msg.equalsIgnoreCase("sair"));
    }

    public static void main(String[] args){
        try {
            ChatClient client = new ChatClient(); 
            client.start(); //iniciar a função principal

        } catch (Exception ex) {
            System.out.println("Erro ao iniciar cliente: " + ex.getMessage());
        }

        System.out.println("Cliente finalizado!");
    }
}
