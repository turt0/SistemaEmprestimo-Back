package modelo;

import dao.AmigoDAO;
import java.util.ArrayList;

public class Amigo extends ModeloBase {

    /**
     * atributos
     */
    private String telefone;

    /**
     * construtor
     */
    public Amigo() {
        this(0, "", "");
    }
    
    /**
     * construtor com parâmetros
     */
    public Amigo(int id, String nome, String telefone) {
        super(id, nome);
        this.telefone = telefone;
    }

    /**
     * gets e sets
     */
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * Método toString para imprimir os detalhes do Amigo
     */
    @Override
    public String toString() {
        return super.toString() + "telefone=" + telefone;
    }
}