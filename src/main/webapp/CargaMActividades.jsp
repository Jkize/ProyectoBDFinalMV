<%-- 
    Document   : CargaMActividades
    Created on : 2/12/2018, 11:46:24 PM
    Author     : katemorales
--%>

 
<%@page import="edu.co.sergio.mundo.vo.*"%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    Empleado emp1 = (Empleado)sesion.getAttribute("Admin");
    if( emp1 == null){
      response.sendRedirect("index.jsp");
    }else{ 

%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Informe Semanal</title>
        <!-- Favicon-->
        <link rel="icon" href="favicon.ico" type="image/x-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

        <!-- Bootstrap Core Css -->
        <link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Waves Effect Css -->
        <link href="plugins/node-waves/waves.css" rel="stylesheet" />

        <!-- Animation Css -->
        <link href="plugins/animate-css/animate.css" rel="stylesheet" />

        <!-- Custom Css -->
        <link href="css/style.css" rel="stylesheet">

        <!-- Bootstrap Select Css -->
        <link href="plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" />

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="css/themes/all-themes.css" rel="stylesheet" />

        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>
    </head>

    <body class="theme-indigo">
        <!-- Page Loader -->
        <div class="page-loader-wrapper">
            <div class="loader">
                <div class="preloader">
                    <div class="spinner-layer pl-red">
                        <div class="circle-clipper left">
                            <div class="circle"></div>
                        </div>
                        <div class="circle-clipper right">
                            <div class="circle"></div>
                        </div>
                    </div>
                </div>
                <p>Cargando...</p>
            </div>
        </div>
        <!-- #END# Page Loader -->
        <!-- Overlay For Sidebars -->
        <div class="overlay"></div>
        <!-- #END# Overlay For Sidebars -->
        <!-- Search Bar -->
        <!-- #END# Search Bar -->
        <!-- Top Bar -->
        <nav class="navbar">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
                    <a href="javascript:void(0);" class="bars"></a>
                    <a class="navbar-brand" href="">ADMINISTRADOR </a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <!-- Notifications -->
                        <li class="dropdown">
                            <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button">
                                <i class="material-icons">notifications</i>
                                <span class="label-count">7</span>
                            </a>

                            <ul class="dropdown-menu">
                                <li class="header">NOTIFICATIONS</li>
                                <li class="body">
                                    <ul class="menu">
                                        <li>
                                            <a href="javascript:void(0);">
                                                <div class="icon-circle bg-light-green">
                                                    <i class="material-icons">person_add</i>
                                                </div>
                                                <div class="menu-info">
                                                    <h4>12 new members joined</h4>
                                                    <p>
                                                        <i class="material-icons">access_time</i> 14 mins ago
                                                    </p>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void(0);">
                                                <div class="icon-circle bg-cyan">
                                                    <i class="material-icons">add_shopping_cart</i>
                                                </div>
                                                <div class="menu-info">
                                                    <h4>4 sales made</h4>
                                                    <p>
                                                        <i class="material-icons">access_time</i> 22 mins ago
                                                    </p>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void(0);">
                                                <div class="icon-circle bg-red">
                                                    <i class="material-icons">delete_forever</i>
                                                </div>
                                                <div class="menu-info">
                                                    <h4><b>Nancy Doe</b> deleted account</h4>
                                                    <p>
                                                        <i class="material-icons">access_time</i> 3 hours ago
                                                    </p>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void(0);">
                                                <div class="icon-circle bg-orange">
                                                    <i class="material-icons">mode_edit</i>
                                                </div>
                                                <div class="menu-info">
                                                    <h4><b>Nancy</b> changed name</h4>
                                                    <p>
                                                        <i class="material-icons">access_time</i> 2 hours ago
                                                    </p>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void(0);">
                                                <div class="icon-circle bg-blue-grey">
                                                    <i class="material-icons">comment</i>
                                                </div>
                                                <div class="menu-info">
                                                    <h4><b>John</b> commented your post</h4>
                                                    <p>
                                                        <i class="material-icons">access_time</i> 4 hours ago
                                                    </p>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void(0);">
                                                <div class="icon-circle bg-light-green">
                                                    <i class="material-icons">cached</i>
                                                </div>
                                                <div class="menu-info">
                                                    <h4><b>John</b> updated status</h4>
                                                    <p>
                                                        <i class="material-icons">access_time</i> 3 hours ago
                                                    </p>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void(0);">
                                                <div class="icon-circle bg-purple">
                                                    <i class="material-icons">settings</i>
                                                </div>
                                                <div class="menu-info">
                                                    <h4>Settings updated</h4>
                                                    <p>
                                                        <i class="material-icons">access_time</i> Yesterday
                                                    </p>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer">
                                    <a href="javascript:void(0);">View All Notifications</a>
                                </li>
                            </ul> 


                        </li>
                        <!-- #END# Notifications -->
                        <!-- Tasks -->
                        <li class="dropdown">
                            <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button">
                                <i class="material-icons">flag</i>
                                <span class="label-count">9</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li class="header">TASKS</li>
                                <li class="body">
                                    <ul class="menu tasks">
                                        <li>
                                            <a href="javascript:void(0);">
                                                <h4>
                                                    Footer display issue
                                                    <small>32%</small>
                                                </h4>
                                                <div class="progress">
                                                    <div class="progress-bar bg-pink" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 32%">
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void(0);">
                                                <h4>
                                                    Make new buttons
                                                    <small>45%</small>
                                                </h4>
                                                <div class="progress">
                                                    <div class="progress-bar bg-cyan" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 45%">
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void(0);">
                                                <h4>
                                                    Create new dashboard
                                                    <small>54%</small>
                                                </h4>
                                                <div class="progress">
                                                    <div class="progress-bar bg-teal" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 54%">
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void(0);">
                                                <h4>
                                                    Solve transition issue
                                                    <small>65%</small>
                                                </h4>
                                                <div class="progress">
                                                    <div class="progress-bar bg-orange" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 65%">
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void(0);">
                                                <h4>
                                                    Answer GitHub questions
                                                    <small>92%</small>
                                                </h4>
                                                <div class="progress">
                                                    <div class="progress-bar bg-purple" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 92%">
                                                    </div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="footer">
                                    <a href="javascript:void(0);">View All Tasks</a>
                                </li>
                            </ul>
                        </li>
                        <!-- #END# Tasks -->
                        <!-- #SIGN OUT -->
                        <li class="dropdown">
                            <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown" role="button">
                                <i class="material-icons">input</i>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- #Top Bar -->
        <section>
            <!-- Left Sidebar -->

            <aside id="leftsidebar" class="sidebar">
                <!-- User Info -->
                <div class="user-info">
                    <div class="image">
                        <img src="images/user.png" width="48" height="48" alt="User" />
                    </div>
                    <div class="info-container">
                        <div class="name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><%=emp1.getNombre()%></div>
                        <div class="email"><%=emp1.getCorreo()%></div>
                        <div class="btn-group user-helper-dropdown">
                            <i class="material-icons" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">keyboard_arrow_down</i>
                            <ul class="dropdown-menu pull-right">
                                <li><a href="javascript:void(0);"><i class="material-icons">person</i>Profile</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="javascript:void(0);"><i class="material-icons">group</i>Followers</a></li>
                                <li><a href="javascript:void(0);"><i class="material-icons">shopping_cart</i>Sales</a></li>
                                <li><a href="javascript:void(0);"><i class="material-icons">favorite</i>Likes</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="ServletLogin?Admin=1&idEmpleado=<%=emp1.getCorreo()%>"><i class="material-icons">input</i>Sign Out</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
                <!-- #User Info -->
                <!-- Menu -->
                <div class="menu">
                    <ul class="list">
                        <li class="header">Menu</li>
                        <li>
                            <a href="ServletAdministrador">
                                <i class="material-icons">home</i>
                                <span>Inicio</span>
                            </a>
                        </li>

                        <li>
                            <a href="javascript:void(0);" class="menu-toggle">
                                <i class="material-icons">group</i>
                                <span>Operarios</span>
                            </a>
                            <ul class="ml-menu">
                                <li class="active">
                                    <a href="ServletRegistro">Registro</a>
                                </li>
                                <li>
                                    <a href="ServletAsignacionTurnos">Asignación de Turnos</a>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="ServletActividad">
                                <i class="material-icons">assignment</i>
                                <span>Actividades</span>
                            </a>
                        </li>
                        <li>
                            <a href="ServletEmpresas">
                                <i class="material-icons">group_work</i>
                                <span>Empresas</span>
                            </a>
                        </li>
                        <li>
                            <a href="ServletServidoresCategorias">
                                <i class="material-icons">layers</i>
                                <span>Servidores - Categorias</span>
                            </a>
                        </li>
                        <li>
                            <a href="ServletBusquedas?inicio=1">
                                <i class="material-icons">search</i>
                                <span>Busquedas</span>
                            </a>
                        </li>
                        <li>
                            <a href="ServletInformeMensual">
                                <i class="material-icons">search</i>
                                <span>Informe Mensual</span>
                            </a>
                        </li>
                        <li >
                            <a href="ServletInformeSemanal">
                                <i class="material-icons">search</i>
                                <span>Informe Semanal</span>
                            </a>
                        </li>
                        <li>
                            <a href="ServletCargaMActividades?inicio=1">
                                <i class="material-icons">system_update_alt</i>
                                <span>Carga Masiva de Actividades</span>
                            </a>
                        </li>
                        </aside>
                        <!-- #END# Left Sidebar -->
                        <section class="content">
                            <div class="container-fluid">
                                <div class="block-header">

                                </div>

                                <div class="row clearfix">
                                    <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                        <div class="card">

                                            <form>

                                                <div class="header">
                                                    <h2>
                                                        Carga Masiva de Actividades
                                                    </h2>
                                                    <br>

                                                    <div class="row">
                                                        <div class="col-xs-4">
                                                            <h4>Empresa:</h4>
                                                        </div>
                                                        <div class="col-xs-8">
                                                            <select id="select1" name="Empresa" class="form-control">
                                                                <option value="">Seleccionar</option>
                                                            </select>
                                                        </div>
                                                    </div>

                                                    <br>

                                                    <div class="form-group">

                                                        <div class="row">
                                                            <div class="col-xs-4">
                                                                <input type="file" class="form-control-file" id="excelfile" />  
                                                            </div>
                                                            <div class="col-xs-8">
                                                                <input type="button" id="viewfile" value="Cargar Archivos" onclick="ExportToTable()" /> 
                                                            </div>
                                                        </div>

                                                        <br> 
                                                        <table class="table table-striped" id="exceltable"></table>                             

                                                    </div>

                                                    <div align="center">
                                                        <input type="button" name="actualizar" id="actualizar"  style="width: 450px; height: 50px;" class="btn bg-indigo waves-effect" value="Cargar Actividades">

                                                    </div>

                                            </form>    




                                        </div>


                                    </div>
                                </div>
                            </div>

                            </div>
                        </section>

                        <script type="text/javascript">

                            var text = "";
                            var col = 0;

                            function ExportToTable() {
                                var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.xlsx|.xls)$/;
                                /*Checks whether the file is a valid excel file*/
                                if (regex.test($("#excelfile").val().toLowerCase())) {
                                    var xlsxflag = false; /*Flag for checking whether excel is .xls format or .xlsx format*/
                                    if ($("#excelfile").val().toLowerCase().indexOf(".xlsx") > 0) {
                                        xlsxflag = true;
                                    }
                                    /*Checks whether the browser supports HTML5*/
                                    if (typeof (FileReader) != "undefined") {
                                        var reader = new FileReader();
                                        reader.onload = function (e) {
                                            var data = e.target.result;
                                            /*Converts the excel data in to object*/
                                            if (xlsxflag) {
                                                var workbook = XLSX.read(data, {type: 'binary'});
                                            } else {
                                                var workbook = XLS.read(data, {type: 'binary'});
                                            }
                                            /*Gets all the sheetnames of excel in to a variable*/
                                            var sheet_name_list = workbook.SheetNames;

                                            var cnt = 0; /*This is used for restricting the script to consider only first sheet of excel*/
                                            sheet_name_list.forEach(function (y) { /*Iterate through all sheets*/
                                                /*Convert the cell value to Json*/
                                                if (xlsxflag) {
                                                    var exceljson = XLSX.utils.sheet_to_json(workbook.Sheets[y]);
                                                } else {
                                                    var exceljson = XLS.utils.sheet_to_row_object_array(workbook.Sheets[y]);
                                                }
                                                if (exceljson.length > 0 && cnt == 0) {
                                                    BindTable(exceljson, '#exceltable');
                                                    cnt++;
                                                }
                                            });
                                            $('#exceltable').show();
                                            document.getElementById("demo").innerHTML = text;

                                        }
                                        if (xlsxflag) {/*If excel file is .xlsx extension than creates a Array Buffer from excel*/
                                            reader.readAsArrayBuffer($("#excelfile")[0].files[0]);
                                        } else {
                                            reader.readAsBinaryString($("#excelfile")[0].files[0]);
                                        }
                                    } else {
                                        alert("Sorry! Your browser does not support HTML5!");
                                    }
                                } else {
                                    alert("Please upload a valid Excel file!");
                                }
                            }

                            function BindTableHeader(jsondata, tableid) {/*Function used to get all column names from JSON and bind the html table header*/
                                var columnSet = [];
                                var headerTr$ = $('<tr/>');
                                for (var i = 0; i < jsondata.length; i++) {
                                    var rowHash = jsondata[i];
                                    for (var key in rowHash) {
                                        if (rowHash.hasOwnProperty(key)) {
                                            if ($.inArray(key, columnSet) == -1) {/*Adding each unique column names to a variable array*/
                                                columnSet.push(key);
                                                text += key + " ";
                                                col++;
                                                headerTr$.append($('<th/>').html(key));
                                            }
                                        }
                                    }
                                }
                                $(tableid).append(headerTr$);
                                return columnSet;
                            }


                            function BindTable(jsondata, tableid) {/*Function used to convert the JSON array to Html Table*/
                                var columns = BindTableHeader(jsondata, tableid); /*Gets all the column headings of Excel*/
                                for (var i = 0; i < jsondata.length; i++) {
                                    var row$ = $('<tr/>');

                                    for (var colIndex = 0; colIndex < columns.length; colIndex++) {
                                        var cellValue = jsondata[i][columns[colIndex]];
                                        text += cellValue + " ";
                                        if (cellValue == null)
                                            cellValue = "null";
                                        row$.append($('<td/>').html(cellValue));
                                    }
                                    $(tableid).append(row$);
                                }
                            }




                            $(document).ready(function () {
                                $('#actualizar').click(function (event) {
                                    var fc;
                                    var emp = $('#select1').val();
                                    $.post('ServlectCargaMActividades', {
                                        data: text,
                                        cols: col,
                                        empresa: emp
                                    }, function (responseText) {
                                        fc = JSON.parse(responseText);
                                        if (typeof fc.error === "undefined") {

                                        } else {
                                        }
                                    });
                                });
                            });





                        </script>


                        <%
                                 if(request.getAttribute("todo")!=null){
                                     System.out.println("Entrada");
                                     List<Object> todo=(List<Object>)request.getAttribute("todo");                            
                                     List<Empresa> empresas = (List<Empresa>) todo.get(0);                          
                                     String h;   
                        %> 

                        <script>
                            select = document.getElementById("select1");
                            <%
                           for (int i = 0; i < empresas.size(); i++) { 
                               h=empresas.get(i).getCodigo()+" "+empresas.get(i).getNombre();
                            %>
                            option = document.createElement("option");
                            option.value = "<%=h%>";
                            option.text = "<%=h%>";
                            select.appendChild(option);

                            <%
                           }

                         }     
                            %>
                        </script>




                        <!-- Jquery Core Js -->
                        <script src="plugins/jquery/jquery.min.js"></script>

                        <!-- Bootstrap Core Js -->
                        <script src="plugins/bootstrap/js/bootstrap.js"></script>

                        <!-- Select Plugin Js -->
                        <script src="plugins/bootstrap-select/js/bootstrap-select.js"></script>

                        <!-- Slimscroll Plugin Js -->
                        <script src="plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

                        <!-- Waves Effect Plugin Js -->
                        <script src="plugins/node-waves/waves.js"></script>

                        <script src="vendor/jquery-easing/jquery.easing.min.js"></script

                                                    <!-- Select Plugin Js -->
                                                    
                                                        
                                                        <!-- Custom Js -->
                                                    <script src="js/admin.js"></script>
                        <script src="js/pages/tables/jquery-datatable.js"></script>

                        <!-- Demo Js -->
          <script src="js/demo.js"></script>
                        </body>

                        </html>
                   <%}%>
