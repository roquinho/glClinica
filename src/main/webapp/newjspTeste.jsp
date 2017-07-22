<%-- 
    Document   : newjspTeste
    Created on : 22/07/2017, 12:09:33
    Author     : manoel
--%>

<%@page import="java.util.Date"%>
<%@page import="br.gl.glClinica.entidades.LogAcesso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <form action ="LogAcesso/gerar" method ="post">
            
            <h<h2>Horário:</h1> <input type="text" name="horaAcesso">
            <h2>codigoUsuario:</h1> <input type="number" name="codigoUsuario">
            <h2> Dia:</h1> <input type="text" name="diaAcesso">
           
            
            		

                        <input type="submit" name="testarData" value="vai" class="button">
		</form> 

    </body>
</html>
