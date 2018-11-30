<%-- 
    Document   : parcial
    Created on : 30/11/2018, 12:53:30 PM
    Author     : Labing
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="edu.co.sergio.mundo.vo.*"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <title>Bootstrap Example</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <script src="http://code.jquery.com/jquery-latest.js"></script>


        <!-- TABLES-->
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
        <link href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css" rel="stylesheet">


    </head>

    <body>

        <!--Cuerpo HTML-->
        <div class="jumbotron text-center">
            <h1>Parcial Bases</h1>
            <p>Jhoan</p>

        </div>

        <hr>

        <form id="form">
            <div class="container">
                <div class="row">
                    <div class="col-sm-8">

                        <h3> <label style="color:blue">Persona</label></h3>

                        <br>
                        <div class="row">

                            <div class="col-sm-4">
                                <div>Pais</div>
                                <select name="topic" id="topic">

                                </select>

                            </div>

                            <div class="col-sm-6">
                                <input type="button" class="btn btn-success" value="Consultar" id="promedio" name="promedio"
                                       style="color: black; ">
                            </div>


                        </div>


                    </div>

                </div>

                <div class="row">
                    <div class="col-sm-12">
                        <label>Tabla:</label>
                        <table id="Tabla1" class="display" width="100%">

                        </table>
                    </div>


                </div>





            </div>
        </form>
        <!-- Inicio Tabla-->
        <script>
            function actualizar(json) {
                table = $('#Tabla1').DataTable({
                    data: json.dat,
                    destroy: true,
                    empty: true,
                    columns: json.col.col2
                });
            }

        </script>



        <!-- Botone Registrar-->
        <script type="text/javascript">
            $(document).ready(function () {
                $('#promedio').click(function (event) {

                    var pais = $('#topic').val();
 
                    $.post('Parcial', {
                        topic: pais
                    }, function (responseText) {
                        var fc = JSON.parse(responseText);

                        if (typeof fc.error === "undefined") {

                            actualizar(fc);
                        } else {
                            alert("Error " + fc.error);

                        }
                    });


                });
            });




        </script>

        <%
       if(request.getAttribute("topic")!=null){            
       List<Exercise> pais  = (List<Exercise>)request.getAttribute("topic"); 
       
        %>

        <script>
            select = document.getElementById("topic");
        </script>

        <%
         for(int i=0; i<pais.size(); i++){
 
        %>

        <script>
            option = document.createElement("option");
            option.value = "<%=pais.get(i).getTopic()%>";
            option.text = "<%=pais.get(i).getTopic()%>";
            select.appendChild(option);

        </script>

        <%
            }
          }
            
        %>



    </div>


</body>

</html>