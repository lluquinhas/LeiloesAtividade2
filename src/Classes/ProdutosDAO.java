package Classes;


import Classes.ProdutosDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosDAO {

   Connection conn;
    PreparedStatement st;
    ResultSet rs;
    // private static final List<ProdutosDTO> lista = new ArrayList<>();

   public List<ProdutosDTO> listagem(String filtro) {

        String sql = "select * from produtos";

        if (!filtro.isEmpty()) {
            sql = sql + " where nome like ?";
        }

        try {
            st = conn.prepareStatement(sql);

            if (!filtro.isEmpty()) {
                st.setString(1,"%" + filtro + "%");
            }

            rs = st.executeQuery();
            List<ProdutosDTO> lista = new ArrayList<>();

            while (rs.next()) {
                ProdutosDTO dto = new ProdutosDTO();
                dto.setId(rs.getString("id"));
                dto.setNome(rs.getString("nome"));
                dto.setValor(rs.getString("valor"));
                dto.setStatus(rs.getString("status"));
                lista.add(dto);
            }
            return lista;
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return null;
        }
   }
   
   

}
