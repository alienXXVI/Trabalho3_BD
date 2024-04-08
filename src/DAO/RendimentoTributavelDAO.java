package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.RendimentoTributavel;

public class RendimentoTributavelDAO {
    
    public void InserirRendimentoTributavel(RendimentoTributavel rendimentoTributavel){
        String sql = "INSERT INTO rendimentoTributavel (idRendimento, idEmpresa, idContribuinte, INSS, IRRFpago, valorRecebido, valorDecimoTerceiro) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, rendimentoTributavel.getIdRendimento());
            ps.setInt(2, rendimentoTributavel.getIdEmpresa());
            ps.setInt(3, rendimentoTributavel.getIdContribuinte());
            ps.setFloat(4, rendimentoTributavel.getINSS());
            ps.setFloat(5, rendimentoTributavel.getIRRFpago());
            ps.setFloat(6, rendimentoTributavel.getValorRecebido());
            ps.setFloat(7, rendimentoTributavel.getValorDecimoTerceiro());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<RendimentoTributavel> listarRendimentoTributavels(){
        List<RendimentoTributavel> listaRendimentoTributavels = new ArrayList<RendimentoTributavel>();

        try {
            String sql = "SELECT * FROM rendimentoTributavel";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                RendimentoTributavel rendimentoTributavel = new RendimentoTributavel(rs.getInt("idRendimento"), rs.getInt("idEmpresa"), rs.getInt("idContribuinte"), rs.getFloat("INSS"), rs.getFloat("IRRFpago"), rs.getFloat("valorRecebido"), rs.getFloat("valorDecimoTerceiro"));
                listaRendimentoTributavels.add(rendimentoTributavel);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaRendimentoTributavels;
    }

    public static void imprimirRendimentoTributavels(List<RendimentoTributavel> rendimentoTributavels) throws SQLException {
        System.err.println("-- RendimentoTributavels --");
        System.out.printf("%s - ", "idRendimento");
        System.out.printf("%s - ", "idEmpresa");
        System.out.printf("%s - ", "idContribuinte");
        System.out.printf("%s - ", "INSS");
        System.out.printf("%s - ", "IRRFpago");
        System.out.printf("%s - ", "valorRecebido");
        System.out.printf("%s", "valorDecimoTerceiro");
        System.err.println();

        for (int i = 0; i < rendimentoTributavels.size(); i++) {
            System.out.print("");
            System.out.print(rendimentoTributavels.get(i).getIdRendimento());
            System.out.print(" - ");
            System.out.print(rendimentoTributavels.get(i).getIdEmpresa());
            System.out.print(" - ");
            System.out.print(rendimentoTributavels.get(i).getIdContribuinte());
            System.out.print(" - ");
            System.out.print(rendimentoTributavels.get(i).getINSS());
            System.out.print(" - ");
            System.out.print(rendimentoTributavels.get(i).getIRRFpago());
            System.out.print(" - ");
            System.out.print(rendimentoTributavels.get(i).getValorRecebido());
            System.out.print(" - ");
            System.out.print(rendimentoTributavels.get(i).getValorDecimoTerceiro());
            System.out.println("");
        }
        System.err.println();
    }

    public RendimentoTributavel buscarPorId(int id) {
        RendimentoTributavel rendimentoTributavel = null;
        try {
            String sql = "SELECT * FROM rendimento_tributavel WHERE idRendimento = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                rendimentoTributavel = new RendimentoTributavel(
                    rs.getInt("idRendimento"),
                    rs.getInt("idEmpresa"),
                    rs.getInt("idContribuinte"),
                    rs.getFloat("INSS"),
                    rs.getFloat("IRRFpago"),
                    rs.getFloat("valorRecebido"),
                    rs.getFloat("valorDecimoTerceiro")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rendimentoTributavel;
    }

    public List<RendimentoTributavel> listarPorContribuinte(int idContribuinte) {
        List<RendimentoTributavel> listaRendimentos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM rendimentotributavel WHERE idContribuinte = ?";
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, idContribuinte);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RendimentoTributavel rendimento = new RendimentoTributavel(
                    rs.getInt("idRendimento"),
                    rs.getInt("idEmpresa"),
                    rs.getInt("idContribuinte"),
                    rs.getFloat("INSS"),
                    rs.getFloat("IRRFpago"),
                    rs.getFloat("valorRecebido"),
                    rs.getFloat("valorDecimoTerceiro")
                );
                listaRendimentos.add(rendimento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaRendimentos;
    }

    public void imprimirListaRendimentos(List<RendimentoTributavel> rendimentos) {
        System.out.println("Lista de Rendimentos Tributáveis:");
        for (RendimentoTributavel rendimento : rendimentos) {
            System.out.println("ID do Rendimento: " + rendimento.getIdRendimento());
            System.out.println("ID da Empresa: " + rendimento.getIdEmpresa());
            System.out.println("ID do Contribuinte: " + rendimento.getIdContribuinte());
            System.out.println("Valor Recebido: " + rendimento.getValorRecebido());
            System.out.println("Valor do INSS: " + rendimento.getINSS());
            System.out.println("Valor do IRRF Pago: " + rendimento.getIRRFpago());
            System.out.println("Valor recebido: " + rendimento.getValorRecebido());
            System.out.println("Valor Decimo Terceiro: " + rendimento.getValorDecimoTerceiro());
            // Adicione outros atributos conforme necessário
            System.out.println("-----------------------------------------");
        }
    }
}
