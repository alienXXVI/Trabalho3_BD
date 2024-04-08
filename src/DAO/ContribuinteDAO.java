package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.Contribuinte;

public class ContribuinteDAO {
    
    public void InserirContribuinte(Contribuinte contribuinte){
        String sql = "INSERT INTO contribuinte (idContribuinte, CPFcontribuinte, nomeContribuinte, dataNascimento, idEndereco, complemento, nroCasa) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, contribuinte.getIdContribuinte());
            ps.setString(2, contribuinte.getCPFcontribuinte());
            ps.setString(3, contribuinte.getNomeContribuinte());
            ps.setDate(4, contribuinte.getDataNascimento());
            ps.setInt(5, contribuinte.getIdEndereco());
            ps.setString(6, contribuinte.getComplemento());
            ps.setInt(7, contribuinte.getNroCasa());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Contribuinte> listarContribuintes(){
        List<Contribuinte> listaContribuintes = new ArrayList<Contribuinte>();

        try {
            String sql = "SELECT * FROM contribuinte";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Contribuinte contribuinte = new Contribuinte(rs.getInt("idContribuinte"), rs.getString("CPFcontribuinte"), rs.getString("nomeContribuinte"), rs.getDate("dataNascimento"), rs.getInt("idEndereco"), rs.getString("complemento"), rs.getInt("nroCasa"));
                listaContribuintes.add(contribuinte);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaContribuintes;
    }

    public static void imprimirContribuintes(List<Contribuinte> contribuintes) throws SQLException {
        System.err.println("-- Contribuinte --");
        System.out.printf("%s - ", "idContribuinte");
        System.out.printf("%s - ", "CPFcontribuinte");
        System.out.printf("%s - ", "nomeContribuinte");
        System.out.printf("%s - ", "dataNascimento");
        System.out.printf("%s - ", "idEndereco");
        System.out.printf("%s - ", "complemento");
        System.out.printf("%s", "nroCasa");
        System.err.println();

        for (int i = 0; i < contribuintes.size(); i++) {
            System.out.print("");
            System.out.print(contribuintes.get(i).getIdContribuinte());
            System.out.print(" - ");
            System.out.print(contribuintes.get(i).getCPFcontribuinte());
            System.out.print(" - ");
            System.out.print(contribuintes.get(i).getNomeContribuinte());
            System.out.print(" - ");
            System.out.print(contribuintes.get(i).getDataNascimento());
            System.out.print(" - ");
            System.out.print(contribuintes.get(i).getIdEndereco());
            System.out.print(" - ");
            System.out.print(contribuintes.get(i).getComplemento());
            System.out.print(" - ");
            System.out.print(contribuintes.get(i).getNroCasa());
            System.out.println("");
        }
        System.err.println();
    }

    public List<Contribuinte> listarContribuintesPorCidade(String nomeCidade){
        List<Contribuinte> listaContribuintes = new ArrayList<>();
    
        try {
            String sql = "SELECT c.* " +
                         "FROM contribuinte c " +
                         "INNER JOIN endereco e ON c.idEndereco = e.idEndereco " +
                         "INNER JOIN cidade ci ON e.idCidade = ci.idCidade " +
                         "WHERE ci.nomeCidade = ?";
    
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, nomeCidade);
    
            ResultSet rs = ps.executeQuery();
    
            while(rs.next()){
                Contribuinte contribuinte = new Contribuinte(
                    rs.getInt("idContribuinte"),
                    rs.getString("CPFcontribuinte"),
                    rs.getString("nomeContribuinte"),
                    rs.getDate("dataNascimento"),
                    rs.getInt("idEndereco"),
                    rs.getString("complemento"),
                    rs.getInt("nroCasa")
                );
                listaContribuintes.add(contribuinte);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    
        return listaContribuintes;
    }
    
    public Contribuinte buscarPorId(int id) {
        Contribuinte contribuinte = null;
        try {
            String sql = "SELECT * FROM contribuinte WHERE idContribuinte = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                contribuinte = new Contribuinte(
                    rs.getInt("idContribuinte"),
                    rs.getString("CPFcontribuinte"),
                    rs.getString("nomeContribuinte"),
                    rs.getDate("dataNascimento"),
                    rs.getInt("idEndereco"),
                    rs.getString("complemento"),
                    rs.getInt("nroCasa")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contribuinte;
    }
}
