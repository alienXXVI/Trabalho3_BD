package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.EmailContribuinte;

public class EmailContribuinteDAO {
    
    public void InserirEmailContribuinte(EmailContribuinte emailcontribuinte){
        String sql = "INSERT INTO emailcontribuinte (emailContribuinte, idContribuinte) VALUES (?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, emailcontribuinte.getEmailContribuinte());
            ps.setInt(2, emailcontribuinte.getIdContribuinte());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<EmailContribuinte> listarEmailContribuintes(){
        List<EmailContribuinte> listaEmailContribuintes = new ArrayList<EmailContribuinte>();

        try {
            String sql = "SELECT * FROM emailcontribuinte";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                EmailContribuinte emailcontribuinte = new EmailContribuinte(rs.getString("emailContribuinte"), rs.getInt("idContribuinte"));
                listaEmailContribuintes.add(emailcontribuinte);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaEmailContribuintes;
    }

    public static void imprimirEmailContribuintes(List<EmailContribuinte> emailcontribuintes) throws SQLException {
        System.err.println("-- EmailContribuintes --");
        System.out.printf("%s - ", "emailContribuinte");
        System.out.printf("%s", "idContribuinte");
        System.err.println();

        for (int i = 0; i < emailcontribuintes.size(); i++) {
            System.out.print("");
            System.out.print(emailcontribuintes.get(i).getEmailContribuinte());
            System.out.print(" - ");
            System.out.print(emailcontribuintes.get(i).getIdContribuinte());
            System.out.println("");
        }
        System.err.println();
    }
}
