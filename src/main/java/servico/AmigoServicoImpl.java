
package servico;

import dao.AmigoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import modelo.Amigo;


@WebService(endpointInterface = "servico.AmigoServico")
public class AmigoServicoImpl implements AmigoServico {
    
    private final AmigoDAO dao = new AmigoDAO();
    
    @Override
    public List<Amigo> listar() {
        System.out.println("AAmigoServico: executando listar()");
        return new ArrayList<>(dao.getMinhaLista());
    }
    
    @Override
    public Amigo carregar(int id) {
        System.out.println("AmigoServico: executando carregar(" + id + ")");
        return dao.carregaAmigo(id);
    }
    
    @Override
    public boolean inserir(Amigo amigo) {
        System.out.println("AmigoServico: executando inserir(" + amigo + ")");
        if (amigo == null) {
            return false;
        }
        // Geração do id é responsabilidade do servidor, não do cliente,
        // para evitar colisões em ambiente distribuído.
        int novoId = dao.maiorID() + 1;
        amigo.setId(novoId);
        return dao.insertAmigoBD(amigo);
    }
}
