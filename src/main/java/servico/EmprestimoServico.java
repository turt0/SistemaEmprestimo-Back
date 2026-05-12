
package servico;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import modelo.Emprestimo;

/**
 * Interface do serviço SOAP de Empréstimo.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface EmprestimoServico {
    
    /**
     * Retorna a lista de todos os empréstimos.
     */
    @WebMethod(operationName = "listar")
    List<Emprestimo> listar();
}
