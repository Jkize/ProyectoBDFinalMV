 
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
        <title>Basic Form Elements | Bootstrap Based Admin Template - Material Design</title>
        <!-- Favicon-->
        <link rel="icon" href="favicon.ico" type="image/x-icon">
        -
        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">
        -
        <!-- Bootstrap Core Css -->
        <link href="plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

        <!-- Waves Effect Css -->
        <link href="plugins/node-waves/waves.css" rel="stylesheet" />

        <!-- Animation Css -->
        <link href="plugins/animate-css/animate.css" rel="stylesheet" />

        <!-- Bootstrap Material Datetime Picker Css -->
        <link href="plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css" rel="stylesheet" />

        <!-- Wait Me Css -->
        <link href="plugins/waitme/waitMe.css" rel="stylesheet" />

        <!-- Bootstrap Select Css -->
        <link href="plugins/bootstrap-select/css/bootstrap-select.css" rel="stylesheet" />

        <!-- Custom Css -->
        <link href="css/style.css" rel="stylesheet">

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="css/themes/all-themes.css" rel="stylesheet" />
        <style>
            hr{
                height: 2px;
                background-color:rgb(42, 75, 104);
            }
        </style>
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
                    <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse"
                       aria-expanded="false"></a>
                    <a href="javascript:void(0);" class="bars"></a>
                    <a class="navbar-brand" href="">ADMINISTRADOR - ASIGNACIÓN DE TURNOS</a>
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
                                                    <div class="progress-bar bg-pink" role="progressbar" aria-valuenow="85"
                                                         aria-valuemin="0" aria-valuemax="100" style="width: 32%">
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
                                                    <div class="progress-bar bg-cyan" role="progressbar" aria-valuenow="85"
                                                         aria-valuemin="0" aria-valuemax="100" style="width: 45%">
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
                                                    <div class="progress-bar bg-teal" role="progressbar" aria-valuenow="85"
                                                         aria-valuemin="0" aria-valuemax="100" style="width: 54%">
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
                                                    <div class="progress-bar bg-orange" role="progressbar" aria-valuenow="85"
                                                         aria-valuemin="0" aria-valuemax="100" style="width: 65%">
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
                                                    <div class="progress-bar bg-purple" role="progressbar" aria-valuenow="85"
                                                         aria-valuemin="0" aria-valuemax="100" style="width: 92%">
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
                                <li>
                                    <a href="ServletRegistro">Registro</a>
                                </li>
                                <li class="active">
                                    <a href="ServletAsignacionTurnos">Asignación de Turnos</a>
                                </li>
                            </ul>
                        </li>
                        <li >
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
                        <li>
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
                            <form action="ServletAsignacionTurnos" method="POST">
                                <div class="container-fluid">
                                    <div class="block-header">
                                        <!-- HOLI-->
                                        <div class="row clearfix">
                                            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                                                <div class="card">
                                                    <div class="header">
                                                        <h1>
                                                            REGISTRO TURNOS
                                                        </h1>
                                                        <ul class="header-dropdown m-r--5">
                                                            <li class="dropdown">
                                                                <a href="javascript:void(0);" class="dropdown-toggle" data-toggle="dropdown"
                                                                   role="button" aria-haspopup="true" aria-expanded="false">
                                                                </a>
                                                            </li>
                                                        </ul>
                                                    </div>
                                                    <div class="body">

                                                        <div class="row clearfix">

                                                            <div class="col-sm-6">
                                                                <h1>Selección Sede</h1><br>
                                                                <select class="form-control show-tick" id="inputcito2" name="Sede">
                                                                    <option>Seleccione la sede</option>

                                                                    <%
                                                                        if (request.getAttribute("listaSedes") != null) {
                                                                            ArrayList sedes = (ArrayList<Sede>) request.getAttribute("listaSedes");
                                                                            for (int i = 0; i < sedes.size(); i++) {
                                                                                Sede sed = (Sede) sedes.get(i);
                                                                    %>
                                                                    <option><%=sed.getCodigo()%></option>
                                                                    <%
                                                                            }
                                                                        }
                                                                    %>

                                                                </select>
                                                                <h1>Selección Turnos</h1><br>
                                                                <h2>Turno de la mañana</h2>
                                                                <hr /><br>
                                                                <select class="form-control show-tick" name="TurnoManana">
                                                                    <option value="">Seleccione operador</option>
                                                                    <%
                                                                if (request.getAttribute("listaEmpleados") != null ) {
                                                                    ArrayList empleados = (ArrayList<Empleado>) request.getAttribute("listaEmpleados");
                                                                    for (int i = 0; i < empleados.size(); i++) {
                                                                        Empleado emp = (Empleado) empleados.get(i);
                                                                    %>
                                                                    <option><%=emp.getCorreo()%></option>
                                                                    <%
                                                                            }
                                                                        }
                                                                    %>
                                                                </select><br><br>
                                                                <h2>Turno de la tarde 1</h2>
                                                                <hr /><br>
                                                                <select class="form-control show-tick" name="TurnoTarde1">
                                                                    <option value="">Seleccione operador</option>
                                                                   <%
                                                                if (request.getAttribute("listaEmpleados") != null) {
                                                                    ArrayList empleados = (ArrayList<Empleado>) request.getAttribute("listaEmpleados");
                                                                    for (int i = 0; i < empleados.size(); i++) {
                                                                        Empleado emp = (Empleado) empleados.get(i);
                                                                    %>
                                                                    <option><%=emp.getCorreo()%></option>
                                                                    <%
                                                                            }
                                                                        }
                                                                    %>
                                                                    
                                                                </select><br><br>
                                                                <h2>Turno de la tarde 2</h2>
                                                                <hr /><br>
                                                                <select class="form-control show-tick" name="TurnoTarde2">
                                                                    <option value="">Seleccione operador</option>
                                                                   <%
                                                                if (request.getAttribute("listaEmpleados") != null) {
                                                                    ArrayList empleados = (ArrayList<Empleado>) request.getAttribute("listaEmpleados");
                                                                    for (int i = 0; i < empleados.size(); i++) {
                                                                        Empleado emp = (Empleado) empleados.get(i);
                                                                    %>
                                                                    <option><%=emp.getCorreo()%></option>
                                                                    <%
                                                                            }
                                                                        }
                                                                    %>
                                                                </select><br><br>
                                                                <h2>Turno de la noche</h2>
                                                                <hr /><br>

                                                                <select class="form-control show-tick" name="TurnoNoche">
                                                                    <option value="">Seleccione operador</option>
                                                                   <%
                                                                if (request.getAttribute("listaEmpleados") != null) {
                                                                    ArrayList empleados = (ArrayList<Empleado>) request.getAttribute("listaEmpleados");
                                                                    for (int i = 0; i < empleados.size(); i++) {
                                                                        Empleado emp = (Empleado) empleados.get(i);
                                                                    %>
                                                                    <option><%=emp.getCorreo()%></option>
                                                                    <%
                                                                            }
                                                                        }
                                                                    %>
                                                                </select><br><br>
                                                            </div>
                                                                <div class="col-sm-6"><br><br><br><br>
                                                                <div align="center">
                                                                            <button  style="width: 140px" class="btn bg-teal btn-block waves-effect" name="Buscar">Buscar</button>
                                                                </div><br><br><br>
                                                                <div class="body">
                                                                    <div class="table-responsive">
                                                                        <table class="table table-striped">
                                                                            <thead>
                                                                                <tr>
                                                                                    <th>Correo</th>
                                                                                    <th>Nombre</th>
                                                                                    <th>Turno</th>
                                                                                </tr>
                                                                            </thead>
                                                                            <tbody>
                                                                               
                                                                                     <%
                                                                if (request.getAttribute("listaEmpleados") != null ) {
                                                                    ArrayList empleados = (ArrayList<Empleado>) request.getAttribute("listaEmpleados");
                                                                    for (int i = 0; i < empleados.size(); i++) {
                                                                        Empleado emp = (Empleado) empleados.get(i);
                                                                    %>
                                                                     <tr>
                                                                    <td><%=emp.getCorreo()%></td>
                                                                    <td><%=emp.getNombre()%></td>
                                                                    <td><%=emp.getTurno()%></td>
                                                                    </tr>
                                                                    <%
                                                                            }
                                                                        }
                                                                    %>
                                                                                
                                                                                
                                                                            </tbody>
                                                                        </table><br><br>
                                                                        <div align="center">
                                                                            <button style="width: 140px" class="btn bg-teal btn-block waves-effect" name="Asignar">Asignar
                                                                                Turnos</button>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- TABLA-->

                                        <!--FIN HOLI-->
                                    </div>

                                </div>
                            </form>

                        </section>


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

                        <script src="plugins/jquery-datatable/jquery.dataTables.js"></script>
                        <script src="plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/pdfmake.min.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>

                        <!-- Custom Js -->
                        <script src="js/admin.js"></script>
                        <script src="js/pages/tables/jquery-datatable.js"></script>

                        <!-- Autosize Plugin Js -->
                        <script src="plugins/autosize/autosize.js"></script>

                        <!-- Moment Plugin Js -->
                        <script src="plugins/momentjs/moment.js"></script>

                        <!-- Bootstrap Material Datetime Picker Plugin Js -->
                        <script src="plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>

                        <!-- Custom Js -->
                        <script src="js/admin.js"></script>
                        <script src="js/pages/forms/basic-form-elements.js"></script>

                        <!-- Demo Js -->
                        <script src="js/demo.js"></script>
                        </body>

                        </html>
                        <%}%>