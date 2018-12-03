<%-- 
    Document   : Registro
    Created on : 15/10/2018, 07:45:15 PM
    Author     : Sebastian
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
<!DOCTYPE html>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <title>Registro</title>
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

        <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
        <link href="css/themes/all-themes.css" rel="stylesheet" />
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
                    <a class="navbar-brand" href="">ADMINISTRADOR - REGISTRO</a>
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
                                <li>
                                    <a href="ServletAsignacionTurnos">Asignación de Turnos</a>
                                </li>
                            </ul>
                        </li>
                        <li class="active">
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
                                    <h2>REGISTRO</h2>
                                </div>




                                <%
                                    if (request.getAttribute("empleado") != null) {
                                        Empleado persona = (Empleado) request.getAttribute("empleado");
                                %>  
                                <form action="ServletRegistro" method="POST">
                                    <div class="row clearfix">
                                        <div class="col-sm-6">
                                            <div class="card">
                                                <div class="header">
                                                    <h2>
                                                        Operador.
                                                    </h2>
                                                    <br>
                                                    <label>
                                                        Correo:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="correo">
                                                    </label>
                                                    <label>
                                                        Nombre:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="nombre">
                                                    </label>
                                                    <label>
                                                        Contraseña:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="contrasena">
                                                    </label>
                                                    <label>
                                                        Cargo:
                                                        <select name="Cargo_Operador" aria-controls="DataTables_Table_0" name="cargo">
                                                            <option value="10">a</option>
                                                            <option value="25">b</option>
                                                            <option value="50">c</option>
                                                            <option value="50">d</option>
                                                        </select>
                                                    </label>
                                                    <label>
                                                        Sede:
                                                        <select name="Sede_Operador" aria-controls="DataTables_Table_0" name="sede">
                                                            <option value="calle 100">Calle 100</option>
                                                            <option value="celta">Celta</option>
                                                        </select>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="card">
                                                <div class="header">
                                                    <h2>
                                                        Operador Suplente.
                                                    </h2>
                                                    <br>
                                                    <label>
                                                        Correo:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="correo">
                                                    </label>
                                                    <label>
                                                        Correo Operador Planta:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="correoPlanta">
                                                    </label>
                                                    <label>
                                                        Fecha Inicio:
                                                        <input type="month" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="fechaI">
                                                    </label>
                                                    <label>
                                                        Fecha Fin:
                                                        <input type="month" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="fechaF">
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="container-fluid">
                                        <div class="card">
                                            <div class="body">
                                                <div class="table-responsive">
                                                    <div class="col-sm-10">
                                                        <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                                            <thead>
                                                                <tr>
                                                                    <th>Correo</th>
                                                                    <th>Nombre</th>
                                                                    <th>Cargo</th>
                                                                    <th>Sede</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <%
                                                                    if (request.getAttribute("listaEmpleados") != null) {
                                                                        ArrayList empleados = (ArrayList<Empleado>) request.getAttribute("listaEmpleados");
                                                                        for (int i = 0; i < empleados.size(); i++) {
                                                                            Empleado empleado = (Empleado) empleados.get(i);
                                                                %>
                                                                <tr>
                                                                    <td><%=empleado.getCorreo()%></td>
                                                                    <td><%=empleado.getNombre()%></td>
                                                                    <td><%=empleado.getCargo()%></td>
                                                                    <td><%=empleado.getSede()%></td>
                                                                </tr>
                                                                <%
                                                                        }
                                                                    }

                                                                %>  


                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <button class="btn bg-indigo waves-effect" name="buscar">Buscar</button>
                                                        <h1></h1>
                                                        <button class="btn bg-indigo waves-effect" name="ingresar">Ingresar</button>
                                                        <h1> </h1>
                                                        <button class="btn bg-indigo waves-effect" name="actualizar">Actualizar</button>
                                                        <h1> </h1>
                                                        <button class="btn bg-indigo waves-effect" name="eliminar">Eliminar</button>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <%  } else {
                                %> 
                                <form action="ServletRegistro" method="POST">
                                    <div class="row clearfix">
                                        <div class="col-sm-6">
                                            <div class="card">
                                                <div class="header">
                                                    <h2>
                                                        Operador.
                                                    </h2>
                                                    <br>
                                                    <%
                                                        if (request.getAttribute("empleadoEncontrado") != null) {
                                                        Empleado emp = (Empleado) request.getAttribute("empleadoEncontrado");%>
                                                    <label>
                                                        Correo:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="correo" value="<%=emp.getCorreo()%>">
                                                    </label>
                                                    <label>
                                                        Nombre:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="nombre" value="<%=emp.getNombre()%>">
                                                    </label>
                                                    <label>
                                                        Contraseña:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="contrasena"value="<%=emp.getContraseña()%>">
                                                    </label>
                                                    <%} else {%>
                                                    <label>
                                                        Correo:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="correo" value="No encontrado.">
                                                    </label>
                                                    <label>
                                                        Nombre:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="nombre">
                                                    </label>
                                                    <label>
                                                        Contraseña:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="contrasena">
                                                    </label>
                                                    <%}
                                                    %>
                                                    <label>
                                                        Cargo:
                                                        <select name="Cargo_Operador" aria-controls="DataTables_Table_0">
                                                            <option value="10">a</option>
                                                            <option value="25">b</option>
                                                            <option value="50">c</option>
                                                            <option value="50">d</option>
                                                        </select>
                                                    </label>
                                                    <label>
                                                        Sede:
                                                        <select name="Sede_Operador" aria-controls="DataTables_Table_0" name="sede">
                                                            <option value="calle100">Calle 100</option>
                                                            <option value="Celta">Celta</option>
                                                        </select>
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <div class="card">
                                                <div class="header">
                                                    <h2>
                                                        Operador Suplente.
                                                    </h2>
                                                    <br>
                                                    <label>
                                                        Correo:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="correo2">
                                                    </label>
                                                    <label>
                                                        Correo Operador Planta:
                                                        <input type="search" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="correoPlanta">
                                                    </label>
                                                    <label>
                                                        Fecha Inicio:
                                                        <input type="month" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="fechaI">
                                                    </label>
                                                    <label>
                                                        Fecha Fin:
                                                        <input type="month" class="form-control input-sm" placeholder="" aria-controls="DataTables_Table_0" name="fechaF">
                                                    </label>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="container-fluid">
                                        <div class="card">
                                            <div class="body">
                                                <div class="table-responsive">
                                                    <div class="col-sm-10">
                                                        <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                                            <thead>
                                                                <tr>
                                                                    <th>Correo</th>
                                                                    <th>Nombre</th>
                                                                    <th>Cargo</th>
                                                                    <th>Sede</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                            <tbody>
                                                                <%
                                                                    if (request.getAttribute("listaEmpleados") != null) {
                                                                        ArrayList empleados = (ArrayList<Empleado>) request.getAttribute("listaEmpleados");
                                                                        for (int i = 0; i < empleados.size(); i++) {
                                                                            Empleado empleado = (Empleado) empleados.get(i);
                                                                %>
                                                                <tr>
                                                                    <td><%=empleado.getCorreo()%></td>
                                                                    <td><%=empleado.getNombre()%></td>
                                                                    <td><%=empleado.getCargo()%></td>
                                                                    <td><%=empleado.getSede()%></td>
                                                                </tr>
                                                                <%
                                                                        }
                                                                    }

                                                                %>  
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                    <div class="col-sm-2">
                                                        <button class="btn bg-indigo waves-effect" name="buscar">Buscar</button>
                                                        <h1></h1>
                                                        <button class="btn bg-indigo waves-effect" name="ingresar">Ingresar</button>
                                                        <h1> </h1>
                                                        <button class="btn bg-indigo waves-effect" name="actualizar">Actualizar</button>
                                                        <h1> </h1>
                                                        <button class="btn bg-indigo waves-effect" name="eliminar">Eliminar</button>
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                <%                                    }
                                %>


                            </div>

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

                        <!-- Custom Js -->
                        <script src="js/admin.js"></script>

                        <!-- Demo Js -->
                        <script src="js/demo.js"></script>
                        </body>

                        </html>
                        <%}%>