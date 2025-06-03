/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.prsoftware.dao;

import br.com.prsoftware.env.EnvLoader;
import br.com.prsoftware.model.Agendamento;
import com.mysql.cj.Messages;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Paulo
 * Criando os Métodos que vão ser utilizados para funções no Banco de Dados
 */
public class AgendamentoDAO {
    private Connection getConnection()throws SQLException{
        return DriverManager.getConnection(EnvLoader.get("DB_URL"),EnvLoader.get("DB_USER"),EnvLoader.get("DB_PASSWORD"));
    }
    
    public void inserir(Agendamento ag) throws SQLException{
        String sql = "INSERT INTO agendamentos (motorista,veiculo,placa,data_retirada,data_devolucao,status)  VALUES (?, ?, ?, ?, ?, ?)";
        try(Connection conn = getConnection();PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, ag.getMotorista());
            ps.setString(2, ag.getVeiculo());
            ps.setString(3, ag.getPlaca());
            ps.setTimestamp(4, new Timestamp(ag.getDataRetirada().getTime()));
            if(ag.getDataDevolucao() !=null){
                ps.setTimestamp(4, new Timestamp(ag.getDataRetirada().getTime()));
            }else{
                ps.setNull(5, Types.TIMESTAMP);
            }
            
            ps.setString(6, ag.getStatus());
            ps.executeUpdate();
        }
            
    }
    
    public List<Agendamento> listar(){
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
                lista.add(ag);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    public void devolver (int id, Date dataDevolucao)throws SQLException{
        String sql = "UPDATE agendamento SET data_devolucao=?, status= 'DEVOLVIDO', where id=?";
        try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setTimestamp(1,new Timestamp(dataDevolucao.getTime()));
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
}
