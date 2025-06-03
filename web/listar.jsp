<%-- 
    Document   : listar
    Created on : 2 de jun. de 2025, 20:39:41
    Author     : Paulo
--%>

<%@page import="br.com.prsoftware.model.Agendamento"%>
<%@ page import="java.util.*, br.com.prsoftware.model.Agendamento" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%
    List<Agendamento> lista = (List<Agendamento>) request.getAttribute("agendamentos");
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
%>
<table border="1">
    <tr>
        <th>ID</th><th>Veículo</th><th>Retirada</th><th>Devolução</th><th>Status</th><th>Ações</th>
    </tr>
    <% for (Agendamento ag : lista) { %>
    <tr>
        <td><%= ag.getId() %></td>
        <td><%= ag.getMotorista() %></td>
        <td><%= ag.getVeiculo() %></td>
        <td><%= ag.getPlaca() %></td>
        <td><%= sdf.format(ag.getDataRetirada()) %></td>
        <td><%= (ag.getDataDevolucao() != null ? sdf.format(ag.getDataDevolucao()) : "-") %></td>
        <td><%= ag.getStatus() %></td>
        <td>
            <% if ("RETIRADO".equals(ag.getStatus())) { %>
            <form action="agendamento" method="post" style="display:inline;">
                <input type="hidden" name="acao" value="devolver">
                <input type="hidden" name="id" value="<%= ag.getId() %>">
                <button type="submit">Devolver</button>
            </form>
            <% } %>
        </td>
    </tr>
    <% } %>
</table>
