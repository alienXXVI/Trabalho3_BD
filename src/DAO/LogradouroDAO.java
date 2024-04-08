package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.Logradouro;

public class LogradouroDAO {
    
    public void InserirLogradouro(Logradouro logradouro){
        String sql = "INSERT INTO logradouro (idLogradouro, nomeLogradouro, siglaLogradouro) VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, logradouro.getIdLogradouro());
            ps.setString(2, logradouro.getNomeLogradouro());
            ps.setString(3, logradouro.getSiglaLogradouro());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Logradouro> listarLogradouros(){
        List<Logradouro> listaLogradouros = new ArrayList<Logradouro>();

        try {
            String sql = "SELECT * FROM logradouro";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Logradouro logradouro = new Logradouro(rs.getInt("idLogradouro"), rs.getString("nomeLogradouro"), rs.getString("siglaLogradouro"));
                listaLogradouros.add(logradouro);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaLogradouros;
    }

    public static void imprimirLogradouros(List<Logradouro> logradouros) throws SQLException {
        System.err.println("-- Logradouros --");
        System.out.printf("%s - ", "idLogradouro");
        System.out.printf("%s - ", "nomeLogradouro");
        System.out.printf("%s", "siglaLogradouro");
        System.err.println();

        for (int i = 0; i < logradouros.size(); i++) {
            System.out.print("");
            System.out.print(logradouros.get(i).getIdLogradouro());
            System.out.print(" - ");
            System.out.print(logradouros.get(i).getNomeLogradouro());
            System.out.print(" - ");
            System.out.print(logradouros.get(i).getSiglaLogradouro());
            System.out.println("");
        }
        System.err.println();
    }
}
