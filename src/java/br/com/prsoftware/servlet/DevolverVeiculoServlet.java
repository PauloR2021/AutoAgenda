/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 * @author Paulo
 */
package br.com.prsoftware.servlet;

import br.com.prsoftware.dao.AgendamentoDAO;
import br.com.prsoftware.model.AgendamentoDevolucao;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.ServerErrorException;

/**
 *
 * @author Paulo
 */
@WebServlet("/devolver")
public class DevolverVeiculoServlet extends HttpServlet {

    private AgendamentoDAO dao = new AgendamentoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        try {
            String idParam = request.getParameter("id");
            if (idParam == null || idParam.isEmpty()) {
                request.setAttribute("erro", "ID do agendamento não fornecido.");
                request.getRequestDispatcher("erro.jsp").forward(request, response);
                return;
            }

            int id = Integer.parseInt(idParam);
            AgendamentoDevolucao agendamentoDevolucao = new AgendamentoDevolucao(id);

            dao.devolucao(agendamentoDevolucao);

            response.sendRedirect("agendamento"); // redireciona para servlet que lista agendamentos

        } catch (NumberFormatException e) {
            request.setAttribute("erro", "ID inválido.");
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("erro", "Erro ao processar devolução.");
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
    }
}

