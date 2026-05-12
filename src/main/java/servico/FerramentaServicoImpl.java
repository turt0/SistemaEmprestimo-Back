
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
    
    @Override
    public Ferramenta carregar(int id) {
        System.out.println("FerramentaServico: executando carregar(" + id + ")");
        return dao.carregaFerramenta(id);
    }
    
    @Override
    public boolean inserir(Ferramenta ferramenta) {
        System.out.println("FerramentaServico: executando inserir(" + ferramenta + ")");
        if (ferramenta == null) {
            return false;
        }
        int novoId = dao.maiorID() + 1;
        ferramenta.setId(novoId);
        return dao.insertFerramentaBD(ferramenta);
    }
    
    @Override
    public boolean alterar(Ferramenta ferramenta) {
        System.out.println("FerramentaServico: executando alterar(" + ferramenta + ")");
        if (ferramenta == null || ferramenta.getId() <= 0) {
            return false;
        }
        return dao.updateFerramentaBD(ferramenta);
    }
    
    @Override
    public boolean deletar(int id) {
        System.out.println("FerramentaServico: executando deletar(" + id + ")");
        if (id <= 0) {
            return false;
        }
        return dao.deleteFerramentaBD(id);
    }
}
