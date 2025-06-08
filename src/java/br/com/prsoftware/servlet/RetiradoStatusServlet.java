/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 * @author Paulo
 */
package br.com.prsoftware.servlet;

import br.com.prsoftware.dao.AgendamentoDAO;
import br.com.prsoftware.model.AgendamentoUpdate;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.ServerErrorException;
import java.io.IOException;


@WebServlet("/retirado")
public class RetiradoStatusServlet extends HttpServlet {
    private AgendamentoDAO dao = new AgendamentoDAO();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServerErrorException, IOException{
        
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String status = ("RETIRADO");
            
            AgendamentoUpdate agendamentoUpdate = new AgendamentoUpdate(id,status);
            
            dao.atuaizar(agendamentoUpdate);
            
            response.sendRedirect("listar.jsp");
            
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("erro.jsp");
        }
        
    }

    
}
