package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.Conexao;
import entity.TipoLogradouro;

public class TipoLogradouroDAO {
    
    public void InserirTipoLogradouro(TipoLogradouro tipoLogradouro){
        String sql = "INSERT INTO tipoLogradouro (siglaLogradouro, nomeLogradouro) VALUES (?, ?)";

        PreparedStatement ps = null;

        try{
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, tipoLogradouro.getSiglaLogradouro());
            ps.setString(2, tipoLogradouro.getNomeLogradouro());

            ps.execute();
            ps.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<TipoLogradouro> listarTipoLogradouros(){
        List<TipoLogradouro> listaTipoLogradouros = new ArrayList<TipoLogradouro>();

        try {
            String sql = "SELECT * FROM tipoLogradouro";

            PreparedStatement ps = null;

            ps = Conexao.getConexao().prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                TipoLogradouro tipoLogradouro = new TipoLogradouro(rs.getString("siglaLogradouro"), rs.getString("nomeLogradouro"));
                listaTipoLogradouros.add(tipoLogradouro);
            }
        
        } catch(Exception e){
            e.printStackTrace();
        }

        return listaTipoLogradouros;
    }

    public static void imprimirTipoLogradouros(List<TipoLogradouro> tipoLogradouros) throws SQLException {
        System.err.println("-- TipoLogradouros --");
        System.out.printf("%s - ", "siglaLogradouro");
        System.out.printf("%s", "nomeLogradouro");
        System.err.println();

        for (int i = 0; i < tipoLogradouros.size(); i++) {
            System.out.print("");
            System.out.print(tipoLogradouros.get(i).getSiglaLogradouro());
            System.out.print(" - ");
            System.out.print(tipoLogradouros.get(i).getNomeLogradouro());
            System.out.println("");
        }
        System.err.println();
    }
}
