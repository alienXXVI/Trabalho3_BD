package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.Bem;

public class BemDAO {
    
    public void InserirBem(Bem bem){
        String sql = "INSERT INTO bem (idBemDireito, idContribuinte, idTipoBem, descricaoBem, valorBem, dataAquisicao) VALUES (?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, bem.getIdBemDireito());
            ps.setInt(2, bem.getIdContribuinte());
            ps.setInt(3, bem.getIdTipoBem());
            ps.setString(4, bem.getDescricaoBem());
            ps.setFloat(5, bem.getValorBem());
            ps.setDate(6, bem.getDataAquisicao());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Bem> listarBens(){
        List<Bem> listaBens = new ArrayList<Bem>();

        try {
            String sql = "SELECT * FROM bem";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Bem bem = new Bem(rs.getInt("idBemDireito"), rs.getInt("idContribuinte"), rs.getInt("idTipoBem"), rs.getString("descricaoBem"), rs.getFloat("valorBem"), rs.getDate("dataAquisicao"));
                listaBens.add(bem);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaBens;
    }

    public static void imprimirBens(List<Bem> bem) throws SQLException {
        System.err.println("-- Bens --");
        System.out.printf("%s - ", "idBemDireito");
        System.out.printf("%s - ", "idContribuinte");
        System.out.printf("%s - ", "idTipoBem");
        System.out.printf("%s - ", "descricaoBem");
        System.out.printf("%s - ", "valorBem");
        System.out.printf("%s", "dataAquisicao");
        System.err.println();

        for (int i = 0; i < bem.size(); i++) {
            System.out.print("");
            System.out.print(bem.get(i).getIdBemDireito());
            System.out.print(" - ");
            System.out.print(bem.get(i).getIdContribuinte());
            System.out.print(" - ");
            System.out.print(bem.get(i).getIdTipoBem());
            System.out.print(" - ");
            System.out.print(bem.get(i).getDescricaoBem());
            System.out.print(" - ");
            System.out.print(bem.get(i).getValorBem());
            System.out.print(" - ");
            System.out.print(bem.get(i).getDataAquisicao());
            System.out.println("");
        }
        System.err.println();
    }

    public List<Bem> listarPorContribuinte(int idContribuinte) {
        List<Bem> listaBens = new ArrayList<>();
        try {
            String sql = "SELECT * FROM bem WHERE idContribuinte = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idContribuinte);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Bem bem = new Bem(
                    rs.getInt("idBemDireito"),
                    rs.getInt("idContribuinte"),
                    rs.getInt("idTipoBem"),
                    rs.getString("descricaoBem"),
                    rs.getFloat("valorBem"),
                    rs.getDate("dataAquisicao")
                );
                listaBens.add(bem);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaBens;
    }

    public void imprimirListaBens(List<Bem> bens) {
        System.out.println("Lista de Bens:");
        for (Bem bem : bens) {
            System.out.println("ID do Bem: " + bem.getIdBemDireito());
            System.out.println("ID Contribuinte: " + bem.getIdContribuinte());
            System.out.println("ID do TipoBem: " + bem.getIdTipoBem());
            System.out.println("Descrição do Bem: " + bem.getDescricaoBem());
            System.out.println("Valor do Bem: " + bem.getValorBem());
            System.out.println("Data de Aquisição: " + bem.getDataAquisicao());
            // Adicione outros atributos conforme necessário
            System.out.println("-----------------------------------------");
        }
    }
}
