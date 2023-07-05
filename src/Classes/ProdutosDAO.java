package Classes;


import Classes.ProdutosDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
     private static final List<ProdutosDTO> lista = new ArrayList<>();

   public static List<ProdutosDTO> Listar() {
        return lista;

    }

    public static void Adicionar(ProdutosDTO produto) {
        lista.add(produto);
    }

    public static ProdutosDTO getProdutos(int id) {
        return lista.get(id);
    }

    public static void Atualizar(ProdutosDTO produto, int posPro) {
        lista.set(posPro, produto);
    }

    public List<ProdutosDAO> listar(String text) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
