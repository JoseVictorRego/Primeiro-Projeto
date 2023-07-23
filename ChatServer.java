import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket; //importar a função de socket
import java.net.Socket;
import java.io.IOException;   //importar a função de condicional

public class ChatServer {
    public static final int PORT = 4000; /*Porta do servidor*/
    private ServerSocket serverSocket;   /*socket do servidor*/
    private BufferedReader in;

    public void start() throws IOException{    /*Metodo de start das função */ 
        serverSocket = new ServerSocket(PORT); /*Informar a porta do servidor*/
        System.out.println("Servidor iniciado na porta: " + PORT);
        
        clientLoopconect();                    /*Chamando a função de coneção em loop do criente */
    }

    private void clientLoopconect() throws IOException{ /*função de coneção em loop do criente*/
        while(true){
            Socket clientSocket = serverSocket.accept();
            System.out.println("\n\n-> Cliente Conectou!!");
            this.in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); //poder ler um conjunto de string

            String msg = in.readLine();
            System.out.print(clientSocket.getRemoteSocketAddress()+": "+ msg);
            
        }
    }

    public static void main(String[] args){ //Main do servidor

        try{
            ChatServer server = new ChatServer(); 
            server.start();  //iniciar a função principal
            
        }catch(IOException ex){
            System.out.println("Erro ao iniciar o servidor"+ex.getMessage());
        }

        System.out.println("\nServidor finalizado\n");
    }
}
