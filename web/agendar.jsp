<%-- 
    Document   : agendar
    Created on : 2 de jun. de 2025, 20:49:11
    Author     : Paulo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Agendamento de Veículo</h2>
        <form action="agendar" method="post">
            <label>Nome do Motorista:</label>
            <input type="text" name="motorista" required><br>

            <label>Veículo:</label>
            <input type="text" name="veiculo" required><br>

            <label>Data de Retirada:</label>
            <input type="date" name="dataRetirada" required><br>

            <label>Data de Devolução:</label>
            <input type="date" name="dataDevolucao" required><br>

            <button type="submit">Agendar</button>
        </form>
        
        
    </body>
   
</html>
