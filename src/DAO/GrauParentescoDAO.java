package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.GrauParentesco;

public class GrauParentescoDAO {
    
    public void InserirGrauParentesco(GrauParentesco grauParentesco){
        String sql = "INSERT INTO grauParentesco (idGrauParentesco, grauParentesco) VALUES (?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, grauParentesco.getIdGrauParentesco());
            ps.setString(2, grauParentesco.getGrauParentesco());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<GrauParentesco> listarGrauParentescos(){
        List<GrauParentesco> listaGrauParentescos = new ArrayList<GrauParentesco>();

        try {
            String sql = "SELECT * FROM grauParentesco";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                GrauParentesco grauParentesco = new GrauParentesco(rs.getInt("idGrauParentesco"), rs.getString("GrauParentesco"));
                listaGrauParentescos.add(grauParentesco);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaGrauParentescos;
    }

    public static void imprimirGrauParentescos(List<GrauParentesco> grauParentescos) throws SQLException {
        System.err.println("-- GrauParentescos --");
        System.out.printf("%s - ", "idGrauParentesco");
        System.out.printf("%s", "grauParentesco");
        System.err.println();

        for (int i = 0; i < grauParentescos.size(); i++) {
            System.out.print("");
            System.out.print(grauParentescos.get(i).getIdGrauParentesco());
            System.out.print(" - ");
            System.out.print(grauParentescos.get(i).getGrauParentesco());
            System.out.println("");
        }
        System.err.println();
    }
}
