package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.UnidadeFederacao;

public class UnidadeFederacaoDAO {
    
    public void InserirUnidadeFederacao(UnidadeFederacao unidadeFederacao){
        String sql = "INSERT INTO unidadeFederacao (siglaUF, nomeUF) VALUES (?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, unidadeFederacao.getUF());
            ps.setString(2, unidadeFederacao.getNomeUF());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<UnidadeFederacao> listarUnidadeFederacaos(){
        List<UnidadeFederacao> listaUnidadeFederacaos = new ArrayList<UnidadeFederacao>();

        try {
            String sql = "SELECT * FROM unidadeFederacao";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                UnidadeFederacao unidadeFederacao = new UnidadeFederacao(rs.getString("siglaUF"), rs.getString("nomeUF"));
                listaUnidadeFederacaos.add(unidadeFederacao);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaUnidadeFederacaos;
    }

    public static void imprimirUnidadeFederacaos(List<UnidadeFederacao> unidadeFederacaos) throws SQLException {
        System.err.println("-- UnidadeFederacaos --");
        System.out.printf("%s - ", "siglaUF");
        System.out.printf("%s", "nomeUF");
        System.err.println();

        for (int i = 0; i < unidadeFederacaos.size(); i++) {
            System.out.print("");
            System.out.print(unidadeFederacaos.get(i).getUF());
            System.out.print(" - ");
            System.out.print(unidadeFederacaos.get(i).getNomeUF());
            System.out.println("");
        }
        System.err.println();
    }
}
