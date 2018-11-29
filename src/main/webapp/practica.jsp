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
                        <div class="row">
                            <div class="col-sm-4">
                                <div>
                                    <label>Id</label></div>
                                <input type="text" name="idP" id="idP" placeholder="numero">
                            </div>
                            <div class="col-sm-4">
                                <label>Nombre</label>
                                <input type="text" name="nombreP" id="nombreP" placeholder="Inserte nombre">
                            </div>
                            <div class="col-sm-4">
                                <label>Apellido</label>
                                <input type="text" name="apellidoP" id="apellidoP" placeholder="Inserte apellido">
                            </div>
                        </div>
                        <br>
                        <div class="row">
                            <div class="col-sm-4">
                                <div>
                                    <label>Fecha nacimiento</label></div>
                                <input type="date" name="fecha_N" id="fecha_N">
                            </div>
                            <div class="col-sm-4">
                                <div>
                                    <label>Sexo</label>
                                </div>
                                <input type="radio" name="sexo" value="M" id="M" checked> Maculino
                                <input type="radio" name="sexo" value="F" id="F"> Femenino
                            </div>

                            <div class="col-sm-4">
                                <div>Pais</div>
                                <select name="pais" id="pais">
                                    <option value="null">null</option>
                                </select>

                            </div>

                        </div>
                        <br>
                        <div class="row">
                            <div> <label>Descripcion</label>></div>
                            <div class="col-sm-4">
                                <textarea row="4" cols="30" name="descripcion" id="descripcion">

                                </textarea>
                            </div>
                            <div class="col-sm-2">
                                <input type="button" class="btn btn-success" value="RegistrarP" id="RegistrarP" name="RegistrarP"
                                       style="color: black; ">
                            </div>
                            <div class="col-sm-2">
                                <input type="button" class="btn btn-primary" value="BuscarP" id="BuscarP" name="BuscarP"
                                       style="color: black; ">
                            </div>
                            <div class="col-sm-2">
                                <input type="button" class="btn btn-secondary" value="ActualizarP" id="ActualizarP" name="ActualizarP"
                                       style="color: black; ">
                            </div>


                        </div>



                    </div>





                    <div class="col-sm-4">
                        <h3> <label style="color:blue">Amistad</label></h3>
                        <div class="row">
                            <div class="col-sm-6">
                                <label>Id persona</label>
                                <input type="text" name="idP1" id="idP1">

                            </div>

                            <div class="col-sm-6">
                                <label>Id persona</label>
                                <input type="text" name="idP2" id="idP2">
                            </div>
                        </div>

                        <br>
                        <div class="row">
                            <div class="col-sm-3">
                                <input type="button" class="btn btn-success" value="RegistrarA" id="RegistrarA" name="RegistrarA"
                                       style="color: black; ">
                            </div>
                            <div class="col-sm-2">

                            </div>
                            <div class="col-sm-3">
                                <input type="button" class="btn btn-secondary" value="Buscar Amigos" id="BuscarA" name="BuscarA"
                                       style="color: black; ">
                            </div>
                        </div>



                    </div>
                </div>

                <hr>

                <div class="row">
                    <div class="col-sm-4">
                        <div class="col-sm-3">
                            <input type="button" class="btn btn-secondary" value="Mostrar Tabla" id="motrarP" name="mostrarP"
                                   style="color: black; ">
                        </div>
                    </div>



                </div>
                <br>



                <div class="row">
                    <div class="col-sm-12">
                        <label>Tabla:</label>
                        <table id="Tabla1" class="display" width="100%">

                        </table>
                    </div>


                </div>



                <br>
                <br>


            </div>
        </form>
        <!-- Inicio Tabla-->
        <script>
            function actualizar(json) {
                table = $('#Tabla1').DataTable({
                    data: json.dat,
                    destroy: true,
                    empty: true,
                    columns: json.col
                });
            }

        </script>



        <!-- Botone Registrar-->
        <script type="text/javascript">
            $(document).ready(function () {
                $('#RegistrarP').click(function (event) {
                    var id = $('#idP').val();
                    var nombre = $('#nombreP').val();
                    var apellido = $('#apellidoP').val();
                    var fecha = $('#fecha_N').val();
                    var sexo = $('input:radio[name=sexo]:checked').val();
                    var pais = $('#pais').val();
                    var descript=$('#descripcion').val();
                    var regis= $('#RegistrarP').val();
                    $.post('Repaso', {
                        id: id,
                        nombre: nombre,
                        apellido: apellido,
                        fecha: fecha.getTime(),
                        sexo: sexo,
                        pais: pais,
                        BRegistrar:regis,
                        descripcion:descript
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


            $(document).ready(function () {
                $('#BuscarA').click(function (event) {
                    var id = $('#idP1').val();

                    $.post('Repaso', {
                        id: id
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
       if(request.getAttribute("paises")!=null){            
       List<Pais> pais  = (List<Pais>)request.getAttribute("paises");  
        for(int i=0; i<pais.size(); i++){
 
        %>

        <script>
            document.getElementById("pais").options[<%=i%>] = new Option(<%=pais.get(i).getNombre()%>,<%=pais.get(i).getId()%>);
        </script>

        <%
            }
          }
            
        %>

    </div>


</body>

</html>