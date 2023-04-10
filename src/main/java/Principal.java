
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {
        try {
            String endereco = JOptionPane.showInputDialog("Digite um endereço","www.google.com.br");
            int porta = Integer.parseInt(JOptionPane.showInputDialog("Digite a porta","80"));
            Socket sock = new Socket(endereco, porta);
            PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));

            String linha = "";
            out.println("GET / HTTP/1.0\n");
            while ((linha = in.readLine()) != null) {
                System.out.println("echo: " + linha);
            }
        } catch (IOException e) {
            System.err.println("Problemas de IO");
        }
    }
}
