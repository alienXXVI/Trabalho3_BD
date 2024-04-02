import DAO.BairroDAO;
import entity.Bairro;

public class App {
    public static void main(String[] args) throws Exception {
        BairroDAO.imprimirBairros(new BairroDAO().listarBairros());
    }
}
