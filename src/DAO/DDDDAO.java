package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.DDD;

public class DDDDAO {
    
    public void InserirDDD(DDD ddd){
        String sql = "INSERT INTO ddd (DDD) VALUES (?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, ddd.getDdd());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<DDD> listarDDDs(){
        List<DDD> listaDDDs = new ArrayList<DDD>();

        try {
            String sql = "SELECT * FROM ddd";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                DDD ddd = new DDD(rs.getString("DDD"));
                listaDDDs.add(ddd);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaDDDs;
    }

    public static void imprimirDDDs(List<DDD> ddds) throws SQLException {
        System.err.println("-- DDDs --");
        System.out.printf("%s", "DDD");
        System.err.println();

        for (int i = 0; i < ddds.size(); i++) {
            System.out.print("");
            System.out.print(ddds.get(i).getDdd());
            System.out.println("");
        }
        System.err.println();
    }
}
