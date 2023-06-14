import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RifaService extends Remote {
    void comprarNumero(String nome) throws RemoteException;
    void realizarSorteio() throws RemoteException;
}
