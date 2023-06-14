import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RifaClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RifaService rifaService = (RifaService) registry.lookup("RifaService");
            rifaService.comprarNumero("Cliente 1");
            rifaService.comprarNumero("Cliente 2");
            rifaService.realizarSorteio();
        } catch (Exception e) {
            System.err.println("Erro ao acessar o serviço RMI: " + e.getMessage());
        }
    }
}
