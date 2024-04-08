package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.TipoBem;

public class TipoBemDAO {
    
    public void InserirTipoBem(TipoBem tipoBem){
        String sql = "INSERT INTO tipoBem (idTipoBem, nomeTipoBem) VALUES (?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, tipoBem.getIdTipoBem());
            ps.setString(2, tipoBem.getNomeTipoBem());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<TipoBem> listarTipoBems(){
        List<TipoBem> listaTipoBems = new ArrayList<TipoBem>();

        try {
            String sql = "SELECT * FROM tipoBem";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                TipoBem tipoBem = new TipoBem(rs.getInt("idTipoBem"), rs.getString("nomeTipoBem"));
                listaTipoBems.add(tipoBem);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaTipoBems;
    }

    public static void imprimirTipoBems(List<TipoBem> tipoBems) throws SQLException {
        System.err.println("-- TipoBems --");
        System.out.printf("%s - ", "idTipoBem");
        System.out.printf("%s", "nomeTipoBem");
        System.err.println();

        for (int i = 0; i < tipoBems.size(); i++) {
            System.out.print("");
            System.out.print(tipoBems.get(i).getIdTipoBem());
            System.out.print(" - ");
            System.out.print(tipoBems.get(i).getNomeTipoBem());
            System.out.println("");
        }
        System.err.println();
    }
}
