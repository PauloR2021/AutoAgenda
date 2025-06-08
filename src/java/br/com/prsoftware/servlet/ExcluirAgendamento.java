/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.prsoftware.servlet;

import br.com.prsoftware.dao.AgendamentoDAO;

import br.com.prsoftware.model.AgendamentoExcluir;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Paulo
 */
@WebServlet("/excluir")
public class ExcluirAgendamento extends HttpServlet {

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
            AgendamentoExcluir agendamentoExcluir = new AgendamentoExcluir(id);

            dao.excluir(agendamentoExcluir);

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
