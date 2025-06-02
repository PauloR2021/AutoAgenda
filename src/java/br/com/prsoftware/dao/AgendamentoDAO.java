/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.prsoftware.dao;

import java.sql.*;
import java.util.*;
import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;

/**
 *
 * @author Paulo
 * Criando os Métodos que vão ser utilizados para funções no Banco de Dados
 */
public class AgendamentoDAO {
    private Connection getConnection()throws SQLException{
        return DriverManager.getConnection("","","");
    }
}
