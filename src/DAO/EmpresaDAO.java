package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.Empresa;

public class EmpresaDAO {
    
    public void InserirEmpresa(Empresa empresa){
        String sql = "INSERT INTO empresa (idEmpresa, cnpjEmpresa, razaoSocial, nomeFantasia) VALUES (?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, empresa.getIdEmpresa());
            ps.setString(2, empresa.getCNPJempresa());
            ps.setString(3, empresa.getRazaoSocial());
            ps.setString(4, empresa.getNomeFantasia());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Empresa> listarEmpresas(){
        List<Empresa> listaEmpresas = new ArrayList<Empresa>();

        try {
            String sql = "SELECT * FROM empresa";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Empresa empresa = new Empresa(rs.getInt("idEmpresa"), rs.getString("cnpjEempresa"), rs.getString("razaoSocial"), rs.getString("nomeFantasia"));
                listaEmpresas.add(empresa);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaEmpresas;
    }

    public static void imprimirEmpresas(List<Empresa> empresas) throws SQLException {
        System.err.println("-- Empresas --");
        System.out.printf("%s - ", "idEmpresa");
        System.out.printf("%s - ", "CPFempresa");
        System.out.printf("%s -", "nomeEmpresa");
        System.out.printf("%s", "dataNascimento");
        System.err.println();

        for (int i = 0; i < empresas.size(); i++) {
            System.out.print("");
            System.out.print(empresas.get(i).getIdEmpresa());
            System.out.print(" - ");
            System.out.print(empresas.get(i).getCNPJempresa());
            System.out.print(" - ");
            System.out.print(empresas.get(i).getRazaoSocial());
            System.out.print(" - ");
            System.out.print(empresas.get(i).getNomeFantasia());
            System.out.println("");
        }
        System.err.println();
    }

    public Empresa buscarPorId(int id) {
        Empresa empresa = null;
        try {
            String sql = "SELECT * FROM empresa WHERE idEmpresa = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                empresa = new Empresa(
                    rs.getInt("idEmpresa"),
                    rs.getString("CNPJempresa"),
                    rs.getString("razaoSocial"),
                    rs.getString("nomeFantasia")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empresa;
    }

    public List<Empresa> listarPorContribuinte(int idContribuinte) {
        List<Empresa> listaEmpresas = new ArrayList<>();
        try {
            String sql = "SELECT e.* FROM empresa e " +
                         "INNER JOIN rendimento_tributavel r ON e.idEmpresa = r.idEmpresa " +
                         "WHERE r.idContribuinte = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idContribuinte);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Empresa empresa = new Empresa(
                    rs.getInt("idEmpresa"),
                    rs.getString("CNPJempresa"),
                    rs.getString("razaoSocial"),
                    rs.getString("nomeFantasia")
                );
                listaEmpresas.add(empresa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaEmpresas;
    }
}
