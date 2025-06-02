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
import java.text.ParseException;
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
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        List<Agendamento> lista = dao.listar();
        request.setAttribute("agendamentos", lista);
        request.getRequestDispatcher("listar.jsp").forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException{
        String acao = request.getParameter("acao");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        
        try{
            if("retirar".equals(acao)){
                String veiculo = request.getParameter("veiculo");
                Date dataRetirada = sdf.parse(request.getParameter("dataRetirada"));
                String dataDevStr = request.getParameter("dataDevolucao");
                
                Agendamento ag = new Agendamento();
                ag.setVeiculo(veiculo);
                ag.setDataRetirada(dataRetirada);
                ag.setStatus("RETIRADO");
                
                if(dataDevStr != null && !dataDevStr.isEmpty()){
                    ag.setDataDevolucao(sdf.parse(dataDevStr));
                    ag.setStatus("DEVOLVIDO");                
                }
                
                dao.inserir(ag);
            }else if("DEVOLVER".equals(acao)){
                int id = Integer.parseInt(request.getParameter("id"));
                dao.devolver(id, (java.sql.Date) new Date());   
            }
            
            response.sendRedirect("agendamento");
        } catch (Exception e) {
            throw new ServletException(e); }
    }    
}
