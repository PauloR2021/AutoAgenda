/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.prsoftware.servlet;

import br.com.prsoftware.dao.AgendamentoDAO;
import br.com.prsoftware.model.Agendamento;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Paulo
 */
@WebServlet("/agendamento")
public class AgendamentoServlet extends HttpServlet {
    
    private AgendamentoDAO dao = new AgendamentoDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        try {
            List<Agendamento> lista = dao.listar();
            request.setAttribute("agendamentos", lista);
            request.getRequestDispatcher("listar.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AgendamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AgendamentoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        String acao = request.getParameter("acao");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        
        try{
            String motorista = request.getParameter("motorista");
            String veiculo = request.getParameter("veiculo");
            String placa = request.getParameter("placa");
            String text = request.getParameter("data-retirada");
            Date data = null;

            if (text != null && !text.isEmpty()) {
                sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"); // ou seu formato
                data = sdf.parse(text);
            }
            String dataDevStr = request.getParameter("data-devolucao");
            String observacao = request.getParameter("observacoes");

            Agendamento ag = new Agendamento();
            
            ag.setMotorista(motorista);
            ag.setVeiculo(veiculo);
            ag.setPlaca(placa);
            ag.setDataRetirada(data);
            ag.setObservacao(observacao);
            ag.setStatus("AGENDADO");
            
            dao.inserir(ag);
            
            
            response.sendRedirect("agendamento");
        } catch (Exception e) {
            throw new ServletException(e); }
    }    
}
