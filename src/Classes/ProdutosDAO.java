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
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public int cadastrarProduto(ProdutosDTO produto) {
        ProdutosDTO dto = new ProdutosDTO();
        conectaDAO dao = new conectaDAO();

        Connection conn = dao.connectDB();

        int status;

        try {
            prep = conn.prepareStatement("INSERT INTO produtos VALUES(?,?,?,?)");
            prep.setString(1, dto.getId());
            prep.setString(2, dto.getNome());
            prep.setString(2, dto.getValor());
            prep.setString(3, dto.getStatus());
            status = prep.executeUpdate();
            return status; //retornar 1
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return ex.getErrorCode();
        }
    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        ProdutosDTO dto = new ProdutosDTO();
        conectaDAO dao = new conectaDAO();
        int status;

        String sql = "SELECT * FROM produtos";

        try ( PreparedStatement statement = conn.prepareStatement(sql)) {

            // Preparar a declaração SQL
            prep = conn.prepareStatement(sql);

            // Executar a consulta e obter o resultado
            resultset = prep.executeQuery();

            //criando lista
            List<ProdutosDTO> lista = new ArrayList<>();

            // Percorrer o resultado da consulta e adicionar cada produto à lista
            while (resultset.next()) {
                dto.setId(resultset.getString("id"));
                dto.setNome(resultset.getString("nome"));
                dto.setValor(resultset.getString("valor"));
                dto.setStatus(resultset.getString("status"));
                lista.add(dto);
            }
            return (ArrayList<ProdutosDTO>) lista;
        } catch (SQLException e) {

            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        } finally {

            // Fechar a conexão com o banco de dados
            dao.desconectar();

        }
    }

}
