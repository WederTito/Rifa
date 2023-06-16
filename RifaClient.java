import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RifaClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RifaService rifaService = (RifaService) registry.lookup("RifaService");

            solicitarNomeEComprarNumero(rifaService);
            solicitarNomeEComprarNumero(rifaService);
            solicitarNomeEComprarNumero(rifaService);
            solicitarNomeEComprarNumero(rifaService);

            rifaService.realizarSorteio();
        } catch (Exception e) {
            System.err.println("Erro ao acessar o serviço RMI: " + e.getMessage());
        }
    }

    private static void solicitarNomeEComprarNumero(RifaService rifaService) throws RemoteException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
        rifaService.comprarNumero(nome);
    }
}