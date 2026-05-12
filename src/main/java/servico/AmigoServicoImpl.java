
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
}
