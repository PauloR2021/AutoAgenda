<%-- 
    Document   : form
    Created on : 2 de jun. de 2025, 20:34:49
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
        <form action="agendamento" method="post">
            <input type="hidden" name="acao" value="retirar"/>
            Veículo: <input type="text" name="veiculo" required></br>
            Data Retirada: <input type="datetime-local" name="dataRetirada" required></br>
            Data Devolucao: <input type="datetime-local" name="dataDevolucao"></br>]
            <button type="submit">Agendar</button>>
        </form>
    </body>
</html>
