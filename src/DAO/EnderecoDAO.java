package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.Endereco;

public class EnderecoDAO {
    
    public void InserirEndereco(Endereco endereco){
        String sql = "INSERT INTO endereco (idEndereco, CEP, idCidade, idLogradouro, idBairro) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, endereco.getIdEndereco());
            ps.setString(2, endereco.getCEP());
            ps.setInt(3, endereco.getIdCidade());
            ps.setInt(4, endereco.getIdLogradouro());
            ps.setInt(5, endereco.getIdBairro());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Endereco> listarEnderecos(){
        List<Endereco> listaEnderecos = new ArrayList<Endereco>();

        try {
            String sql = "SELECT * FROM endereco";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Endereco endereco = new Endereco(rs.getInt("idEndereco"), rs.getString("CEP"), rs.getInt("idCidade"), rs.getInt("idLogradouro"), rs.getInt("idBairro"));
                listaEnderecos.add(endereco);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaEnderecos;
    }

    public static void imprimirEnderecos(List<Endereco> enderecos) throws SQLException {
        System.err.println("-- Enderecos --");
        System.out.printf("%s - ", "idEndereco");
        System.out.printf("%s - ", "CEP");
        System.out.printf("%s -", "idCidade");
        System.out.printf("%s - ", "idLogradouro");
        System.out.printf("%s", "idBairro");
        System.err.println();

        for (int i = 0; i < enderecos.size(); i++) {
            System.out.print("");
            System.out.print(enderecos.get(i).getIdEndereco());
            System.out.print(" - ");
            System.out.print(enderecos.get(i).getCEP());
            System.out.print(" - ");
            System.out.print(enderecos.get(i).getIdCidade());
            System.out.print(" - ");
            System.out.print(enderecos.get(i).getIdLogradouro());
            System.out.print(" - ");
            System.out.print(enderecos.get(i).getIdBairro());
            System.out.println("");
        }
        System.err.println();
    }
}
