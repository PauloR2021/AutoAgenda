/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.prsoftware.dao;

import br.com.prsoftware.env.EnvLoader;
import br.com.prsoftware.model.Agendamento;
import br.com.prsoftware.model.AgendamentoDevolucao;
import br.com.prsoftware.model.AgendamentoExcluir;
import br.com.prsoftware.model.AgendamentoUpdate;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paulo
 * Criando os Métodos que vão ser utilizados para funções no Banco de Dados
 */
public class AgendamentoDAO {
    
    private Connection getConnection()throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(EnvLoader.get("DB_URL"),EnvLoader.get("DB_USER"),EnvLoader.get("DB_PASSWORD"));
    }
    
    public void inserir(Agendamento ag) throws Exception {
        String sql = "INSERT INTO agendamentos (motorista, veiculo, placa, data_retirada, data_devolucao, observacao, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, ag.getMotorista());
            ps.setString(2, ag.getVeiculo());
            ps.setString(3, ag.getPlaca());
            ps.setTimestamp(4, new Timestamp(ag.getDataRetirada().getTime()));
            ps.setTimestamp(5, new Timestamp(ag.getDataRetirada().getTime())); // Pode ser null ou outra lógica
            ps.setString(6, ag.getObservacao());
            ps.setString(7, ag.getStatus());
            ps.executeUpdate();
        }
    }
    
    public List<Agendamento> listar() throws SQLException, ClassNotFoundException{
        List<Agendamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM agendamentos";
        try(Connection conn = getConnection(); PreparedStatement ps= conn.prepareStatement(sql); ResultSet rs=ps.executeQuery()){
            while(rs.next()){
                Agendamento ag = new Agendamento();
                ag.setId(rs.getInt("id"));
                ag.setMotorista(rs.getString("motorista"));
                ag.setPlaca(rs.getString("placa"));
                ag.setVeiculo(rs.getString("veiculo"));
                ag.setDataRetirada(rs.getTimestamp("data_retirada"));
                ag.setDataDevolucao(rs.getTimestamp("data_devolucao"));
                ag.setStatus(rs.getString("status"));
                ag.setObservacao(rs.getString("observacao"));
                lista.add(ag);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public void atualizar(AgendamentoUpdate update){
        
        String sql = "UPDATE agendamentos SET status=? WHERE id=?";
        
        try(Connection conn = getConnection();PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, update.getStatus());
            ps.setInt(2, update.getId());
            
            ps.executeUpdate();
            
        }catch (Exception e){
           e.printStackTrace();
        }
        
    }
    
    public void devolucao(AgendamentoDevolucao devolucao){

       String sql = "UPDATE agendamentos SET data_devolucao=NOW(), status='DEVOLVIDO' WHERE id=?";

       try(Connection conn = getConnection();PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setInt(1, devolucao.getId());

           ps.executeUpdate();

       }catch (Exception e){
          e.printStackTrace();
       }
   }
    
    public void excluir(AgendamentoExcluir excluir){

       String sql = "DELETE FROM agendamentos WHERE id = ?;";

       try(Connection conn = getConnection();PreparedStatement ps = conn.prepareStatement(sql)){
           ps.setInt(1, excluir.getId());

           ps.executeUpdate();

       }catch (Exception e){
          e.printStackTrace();
       }

   }
    
   
}
