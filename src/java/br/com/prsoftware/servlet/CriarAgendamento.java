/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.prsoftware.servlet;

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
@WebServlet("agendar")
public class CriarAgendamento extends HttpServlet {
    public class AgendarVeiculoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String motorista = request.getParameter("motorista");
        String veiculo = request.getParameter("veiculo");
        String dataRetirada = request.getParameter("dataRetirada");
        String dataDevolucao = request.getParameter("dataDevolucao");

        // Lógica para salvar no banco ou em uma lista

        response.getWriter().println("Veículo agendado com sucesso!");
    }
    }

    
}
