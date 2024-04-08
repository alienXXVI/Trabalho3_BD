package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.Bairro;
import entity.Cidade;

public class BairroDAO {

    public void InserirBairro(Bairro bairro){
        String sql = "INSERT INTO bairro (idBairro, nomeBairro) VALUES ( ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, bairro.getIdBairro());
            ps.setString(2, bairro.getNomeBairro());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Bairro> listarBairros(){
        List<Bairro> listaBairros = new ArrayList<Bairro>();

        try {
            String sql = "SELECT * FROM bairro";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Bairro bairro = new Bairro(rs.getInt("idBairro"), rs.getString("nomeBairro"));
                listaBairros.add(bairro);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaBairros;
    }

    public static void imprimirBairros(List<Bairro> bairros) throws SQLException {
        System.err.println("-- Bairros --");
        System.out.printf("%s - ", "idBairro");
        System.out.printf("%s", "nomeBairro");
        System.err.println();

        for (int i = 0; i < bairros.size(); i++) {
            System.out.print("");
            System.out.print(bairros.get(i).getIdBairro());
            System.out.print(" - ");
            System.out.print(bairros.get(i).getNomeBairro());
            System.out.println("");
        }
        System.err.println();
    }
}
