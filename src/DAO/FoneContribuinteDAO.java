package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.FoneContribuinte;

public class FoneContribuinteDAO {
    
    public void InserirFoneContribuinte(FoneContribuinte foneContribuinte){
        String sql = "INSERT INTO foneContribuinte (foneContribuinte, idContribuinte, DDD) VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, foneContribuinte.getFoneContribuinte());
            ps.setInt(2, foneContribuinte.getIdContribuinte());
            ps.setString(3, foneContribuinte.getDDD());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<FoneContribuinte> listarFoneContribuintes(){
        List<FoneContribuinte> listaFoneContribuintes = new ArrayList<FoneContribuinte>();

        try {
            String sql = "SELECT * FROM foneContribuinte";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                FoneContribuinte foneContribuinte = new FoneContribuinte(rs.getString("foneContribuinte"), rs.getInt("idContribuinte"), rs.getString("DDD"));
                listaFoneContribuintes.add(foneContribuinte);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaFoneContribuintes;
    }

    public static void imprimirFoneContribuintes(List<FoneContribuinte> foneContribuintes) throws SQLException {
        System.err.println("-- FoneContribuintes --");
        System.out.printf("%s - ", "foneContribuinte");
        System.out.printf("%s - ", "idContribuinte");
        System.out.printf("%s", "DDD");
        System.err.println();

        for (int i = 0; i < foneContribuintes.size(); i++) {
            System.out.print("");
            System.out.print(foneContribuintes.get(i).getFoneContribuinte());
            System.out.print(" - ");
            System.out.print(foneContribuintes.get(i).getIdContribuinte());
            System.out.print(" - ");
            System.out.print(foneContribuintes.get(i).getDDD());
            System.out.println("");
        }
        System.err.println();
    }
}
