import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RifaServiceImpl extends UnicastRemoteObject implements RifaService {
    private List<Integer> numeros;
    private List<String> clientes;
    private boolean sorteada;

    public RifaServiceImpl() throws RemoteException {
        numeros = new ArrayList<>();
        clientes = new ArrayList<>();
        sorteada = false;
        for (int i = 1; i <= 10; i++) {
            numeros.add(i);
        }
    }

    @Override
    public synchronized void comprarNumero(String nome) throws RemoteException {
        if (sorteada) {
            System.out.println("Desculpe, a rifa já foi sorteada. Não é possível comprar números.");
            return;
        }
        if (numeros.isEmpty()) {
            System.out.println("Desculpe, todos os números já foram vendidos.");
            return;
        }
        Random random = new Random();
        int indice = random.nextInt(numeros.size());
        int numero = numeros.remove(indice);
        clientes.add(nome);
        System.out.println(nome + " comprou o número " + numero);
    }

    @Override
    public synchronized void realizarSorteio() throws RemoteException {
        sorteada = true;
        Random random = new Random();
        int indiceVencedor = random.nextInt(clientes.size());
        String clienteVencedor = clientes.get(indiceVencedor);
        System.out.println("Sorteio realizado! O " + clienteVencedor + " é o vencedor.");
    }
}
