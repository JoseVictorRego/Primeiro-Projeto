import java.net.ServerSocket; //importar a função de socket
import java.io.IOException;   //importar a função de condicional

public class ChatServer {
    private final int PORT = 4000;
    private ServerSocket serverSocket;

    public void start() throws IOException{
        serverSocket = new ServerSocket(PORT);
    }

    public static void main(String[] args){

        try{
            ChatServer server = new ChatServer();
            server.start();
        }catch(IOException ex){
            System.out.println("Erro ao iniciar o servidor"+ex.getMessage());
        }
        
    }
}
