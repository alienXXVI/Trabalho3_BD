package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import conexao.Conexao;
import entity.Dependente;
import entity.GrauParentesco;

public class DependenteDAO {

    private Connection conexao;

    // Construtor que recebe a conexão com o banco de dados
    public DependenteDAO() {
        
    }
    
    public void InserirDependente(Dependente dependente){
        String sql = "INSERT INTO dependente (idDependente, CPFdependente, nomeDependente, dataNascimento, idGrauParentesco) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, dependente.getIdDependente());
            ps.setString(2, dependente.getCPFdependente());
            ps.setString(3, dependente.getNomeDependente());
            ps.setDate(4, dependente.getDataNascimento());
            ps.setInt(5, dependente.getIdGrauParentesco());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Dependente> listarDependentes(){
        List<Dependente> listaDependentes = new ArrayList<Dependente>();

        try {
            String sql = "SELECT * FROM dependente";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Dependente dependente = new Dependente(rs.getInt("idDependente"), rs.getString("CPFdependente"), rs.getString("nomeDependente"), rs.getDate("dataNascimento"), rs.getInt("idGrauParentesco"), rs.getInt("idContribuinte"));
                listaDependentes.add(dependente);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaDependentes;
    }

    public static void imprimirDependentes(List<Dependente> dependentes) throws SQLException {
        System.err.println("-- Dependentes --");
        System.out.printf("%s - ", "idDependente");
        System.out.printf("%s - ", "CPFdependente");
        System.out.printf("%s - ", "nomeDependente");
        System.out.printf("%s - ", "dataNascimento");
        System.out.printf("%s - ", "idGrauParentesco");
        System.out.printf("%s", "idContribuinte");
        System.err.println();

        for (int i = 0; i < dependentes.size(); i++) {
            System.out.print("");
            System.out.print(dependentes.get(i).getIdDependente());
            System.out.print(" - ");
            System.out.print(dependentes.get(i).getCPFdependente());
            System.out.print(" - ");
            System.out.print(dependentes.get(i).getNomeDependente());
            System.out.print(" - ");
            System.out.print(dependentes.get(i).getDataNascimento());
            System.out.print(" - ");
            System.out.print(dependentes.get(i).getIdGrauParentesco());
            System.out.print(" - ");
            System.out.print(dependentes.get(i).getIdContribuinte());
            System.out.println("");
        }
        System.err.println();
    }

    // Apenas aparece os ids
    public List<Dependente> listarDependentesComParentesco() {
        List<Dependente> listaDependentes = new ArrayList<>();

        try {
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT d.*, gp.idGrauParentesco, gp.grauParentesco " +
                         "FROM Dependente d " +
                         "INNER JOIN GrauParentesco gp ON d.idGrauParentesco = gp.idGrauParentesco";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dependente dependente = new Dependente(
                    rs.getInt("idDependente"),
                    rs.getString("CPFdependente"),
                    rs.getString("nomeDependente"),
                    rs.getDate("dataNascimento"),
                    rs.getInt("idGrauParentesco"),
                    rs.getInt("idContribuinte")
                );
                GrauParentesco grauParentesco = new GrauParentesco(
                    rs.getInt("idGrauParentesco"),
                    rs.getString("grauParentesco")
                );
                dependente.setGrauParentesco(grauParentesco);
                listaDependentes.add(dependente);
            }

            // Fechando recursos
            rs.close();
            ps.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaDependentes;
    }
    
    public Dependente buscarPorId(int id) {
        Dependente dependente = null;
        try {
            String sql = "SELECT * FROM dependente WHERE idDependente = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dependente = new Dependente(
                    rs.getInt("idDependente"),
                    rs.getString("CPFdependente"),
                    rs.getString("nomeDependente"),
                    rs.getDate("dataNascimento"),
                    rs.getInt("idGrauParentesco"),
                    rs.getInt("idContribuinte")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dependente;
    }

    public List<Dependente> listarPorContribuinte(int idContribuinte) {
        List<Dependente> listaDependentes = new ArrayList<>();

        String sql = "SELECT * FROM Dependente WHERE idContribuinte = ?";

                     try {
                        PreparedStatement ps = null;
                        ps = Conexao.getConexao().prepareStatement(sql);
                        ps.setInt(1, idContribuinte);
                        ResultSet rs = ps.executeQuery();
                
                        while (rs.next()) {
                            Dependente dependente = new Dependente();
                            dependente.setIdDependente(rs.getInt("idDependente"));
                            dependente.setCPFdependente(rs.getString("CPFdependente"));
                            dependente.setNomeDependente(rs.getString("nomeDependente"));
                            dependente.setDataNascimento(rs.getDate("dataNascimento"));
                            dependente.setIdGrauParentesco(rs.getInt("idGrauParentesco"));
                
                            listaDependentes.add(dependente);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    return listaDependentes;
    }

    public void imprimirListaDependentes(List<Dependente> dependentes) {
        System.out.println("Lista de Dependentes:");
        for (Dependente dependente : dependentes) {
            System.out.println("ID do Dependente: " + dependente.getIdDependente());
            System.out.println("Nome do Dependente: " + dependente.getNomeDependente());
            System.out.println("CPF do Dependente: " + dependente.getCPFdependente());
            System.out.println("Data de Nascimento do Dependente: " + dependente.getDataNascimento());
            System.out.println("ID Grau Parentesco: " + dependente.getIdGrauParentesco());
            System.out.println("-----------------------------------------");
        }
    }
    
}
