import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RifaServer {
    public static void main(String[] args) {
        try {
            RifaService rifaService = new RifaServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RifaService", rifaService);
            System.out.println("Servidor RMI iniciado.");
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o servidor RMI: " + e.getMessage());
        }
    }
}
