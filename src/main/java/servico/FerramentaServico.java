
package servico;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import modelo.Ferramenta;

/**
 * Interface do serviço SOAP de Ferramenta.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface FerramentaServico {
    
    /**
     * Retorna a lista de todas as ferramentas cadastradas.
     */
    @WebMethod(operationName = "listar")
    List<Ferramenta> listar();
}
