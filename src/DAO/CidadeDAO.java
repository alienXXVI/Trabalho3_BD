package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.Cidade;

public class CidadeDAO {
    
    public void InserirCidade(Cidade cidade){
        String sql = "INSERT INTO cidade (idCidade, nomeCidade, siglaUF) VALUES (?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, cidade.getIdCidade());
            ps.setString(2, cidade.getNomeCidade());
            ps.setString(3, cidade.getSiglaUF());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Cidade> listarCidades(){
        List<Cidade> listaCidades = new ArrayList<Cidade>();

        try {
            String sql = "SELECT * FROM cidade";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Cidade cidade = new Cidade(rs.getInt("idCidade"), rs.getString("nomeCidade"), rs.getString("siglaUF"));
                listaCidades.add(cidade);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaCidades;
    }

    public static void imprimirCidades(List<Cidade> cidades) throws SQLException {
        System.err.println("-- Cidades --");
        System.out.printf("%s - ", "idCidade");
        System.out.printf("%s - ", "nomeCidade");
        System.out.printf("%s", "siglaUF");
        System.err.println();

        for (int i = 0; i < cidades.size(); i++) {
            System.out.print("");
            System.out.print(cidades.get(i).getIdCidade());
            System.out.print(" - ");
            System.out.print(cidades.get(i).getNomeCidade());
            System.out.print(" - ");
            System.out.print(cidades.get(i).getSiglaUF());
            System.out.println("");
        }
        System.err.println();
    }
}
