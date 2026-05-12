
package servico;

import dao.FerramentaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import modelo.Ferramenta;
 
/**
 * Implementação do serviço SOAP de Ferramenta.
 */
@WebService(endpointInterface = "servico.FerramentaServico")
public class FerramentaServicoImpl implements FerramentaServico{
    
    private final FerramentaDAO dao = new FerramentaDAO();
 
    @Override
    public List<Ferramenta> listar() {
        System.out.println("FerramentaServico: executando listar()");
        return new ArrayList<>(dao.getMinhaLista());
    }
}
