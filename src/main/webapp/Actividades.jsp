 

<%@page import="edu.co.sergio.mundo.vo.*"%>
<%@page import="java.util.*"%>

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
        <title>Actividades</title>
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
                    <a class="navbar-brand" href="">ADMINISTRADOR - ACTIVIDADES</a>
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
                            <a href="ServletLogin?Admin=1&idEmpleado=<%=emp1.getCorreo()%>" class="dropdown-toggle" data-toggle="dropdown" role="button">
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
                            <div class="card">

                                <form action="ServletActividad" method="POST">

                                    <div class="container-fluid">
                                        <div class="block-header">
                                            <div class="header">
                                                <h1>
                                                    ACTIVIDADES
                                                </h1>
                                            </div>
                                            <br>

                                            <div class="row clearfix"> 

                                                <%
                                               if(request.getAttribute("todo")!=null){
                                                 List<Object> todo=(List<Object>)request.getAttribute("todo"); 
                                                  
                                                 if(todo.size()>4){
                                                     String a=(String)todo.get(4);
                                                     String h[]= (a).split(" ");                                                     
                                                       if(h[0].equals("Error")){
                                                %>
                                                <div class="alert alert-danger" role="alert">
                                                    <%=(String)todo.get(4)%>
                                                </div>
                                                <%
                                                          
                                            }

                                                if(h[0].equals("Warning")){
                                                %>
                                                <div class="alert alert-warning" role="alert">
                                                    <%=(String)todo.get(4)%>
                                                </div>
                                                <%
                                                          
                                                    }


                                           if(h[0].equals("OK")){
                                                %>
                                                <div class="alert alert-success" role="alert">
                                                    <%=(String)todo.get(4)%>
                                                </div>
                                                <%  
                                                         }
                                                      
                                                                 }
                                                     }
                                                %>



                                            </div>

                                            <div class="row clearfix">
                                                <div class="col-sm-4">
                                                    <label>Empresa</label>
                                                    <select name="empresa" id="select1"> 
                                                        <option value="">--Seleccione --</option>
                                                    </select>

                                                </div>

                                                <div class="col-sm-4">
                                                    <label>Categoria</label>

                                                    <select name="categoria" id="select2">
                                                        <option value="">--Seleccione --</option>
                                                    </select>

                                                </div>

                                                <div class="col-sm-4">
                                                    <label>Servidor</label>
                                                    <select name="servidor" id="select3">
                                                        <option value="">--Seleccione --</option>
                                                    </select>

                                                </div>
                                            </div>

                                            <br>
                                            <div class="row clearfix">
                                                <div class="col-sm-4">
                                                    <label>Nombre</label>
                                                    <input type="text"   name="nombre" id="input1" placeholder="ej: Jhoan">

                                                </div>

                                                <div class="col-sm-4">
                                                    <label style="color:red">Interválo de Tiempo</label>
                                                    <input type="text"  name="intervalotiempo" id="input2"
                                                           placeholder="ej: 4">



                                                </div>
                                                <div class="col-sm-4">

                                                    <label style="color:red"># Veces del dia</label>
                                                    <input type="text"  name="vecesdeldia" id="input3" placeholder="ej: 4">
                                                </div>
                                            </div>

                                            <br>
                                            <div class="row clearfix">
                                                <div class="col-sm-4">
                                                    <label>Duración Estimada</label>
                                                    <input type="text"  name="durest" id="input4" placeholder="ej: 4">
                                                </div>
                                                <div class="col-sm-4">

                                                    <label style="color:red">Hora de Inicio</label>
                                                    <input type="time"  name="horainicio" id="input5" placeholder="ej: 4">
                                                </div>
                                            </div>

                                            <br>
                                            <br>
                                            <div class="row clearfix">
                                                <div class="col-sm-6">
                                                    <label style="font-size: 25px; color:darkgreen">Ejecución</label>
                                                </div>
                                                <div class="col-sm-6">

                                                    <label style="font-size: 25px; color:darkgreen">Descripción</label>
                                                </div>
                                            </div>

                                            <br>
                                            <div class="row clearfix">

                                                <div class="col-sm-6">

                                                    <div class="row clearfix">

                                                        <div>

                                                            <script language="JavaScript">
                                                                var era;
                                                                var previo = null;
                                                                function uncheckRadio(rbutton) {
                                                                    if (previo && previo != rbutton) {
                                                                        previo.era = false;
                                                                    }
                                                                    if (rbutton.checked == true && rbutton.era == true) {
                                                                        rbutton.checked = false;
                                                                    }
                                                                    rbutton.era = rbutton.checked;
                                                                    previo = rbutton;
                                                                }
                                                            </script>

                                                            <div class="col-sm-4">
                                                                <input name="group5" type="radio" id="Primero" class="with-gap radio-col-blue"
                                                                       value="Primero" onclick="uncheckRadio(this)" />
                                                                <label for="Primero">Primer día</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <input name="group5" type="radio" id="Ultimo" class="with-gap radio-col-indigo" value="Ultimo" onclick="uncheckRadio(this)"/>
                                                                <label for="Ultimo" >Último dia del mes</label>
                                                            </div>
                                                            <div class="col-sm-4">
                                                                <input name="group5" type="radio" id="Critico" class="with-gap radio-col-red" value="Critico" onclick="uncheckRadio(this)"/>
                                                                <label for="Critico">Proceso Crítico</label>

                                                            </div>
                                                        </div>
                                                        <br> <br> <br>

                                                        <div class="col-sm-12">

                                                            <div align="left">
                                                                <label style="font-size: 25px; color:darkgreen">Programación Semanal</label>
                                                            </div>
                                                            <div class="demo-checkbox">
                                                                <input type="checkbox" name="Lu" value="Lu" id="Lu" class="filled-in chk-col-indigo" />
                                                                <label for="Lu">Lu</label>
                                                                <input type="checkbox" name="Ma" value="Ma" id="Ma" class="filled-in chk-col-indigo" />
                                                                <label for="Ma">Ma</label>
                                                                <input type="checkbox" name="Mi" value="Mi" id="Mi" class="filled-in chk-col-indigo" />
                                                                <label for="Mi">Mi</label>
                                                                <input type="checkbox" name="Ju" value="Ju" id="Ju" class="filled-in chk-col-indigo" />
                                                                <label for="Ju">Ju</label>
                                                                <input type="checkbox" name="Vi" value="Vi" id="Vi" class="filled-in chk-col-indigo" />
                                                                <label for="Vi">Vi</label>
                                                                <input type="checkbox" name="Sa" value="Sa" id="Sa" class="filled-in chk-col-indigo" />
                                                                <label for="Sa">Sa</label>
                                                                <input type="checkbox" name="Do" value="Do" id="Do" class="filled-in chk-col-indigo" />
                                                                <label for="Do">Do</label>
                                                                <input type="checkbox" name="Fe" value="Fe" id="Fe" class="filled-in chk-col-red" />
                                                                <label style="color:red" for="Fe">Festivos</label>
                                                            </div>
                                                        </div>

                                                        <br> <br>
                                                        <br> <br>
                                                        <br> <br>

                                                        <br>
                                                        <div class="col-sm-12">
                                                            <input type="text" id="comodin" name="comodin" placeholder="">
                                                            <label style="color:red;font-size: 15px" for="comodin">Días comodín (Se
                                                                restan al último dia del mes)</label>
                                                        </div>


                                                        <br> <br>
                                                        <br>
                                                        <div>
                                                            <div class="col-sm-12">
                                                                <div align="left">
                                                                    <label style="font-size: 25px; color:darkgreen">Fechas Específicas</label>
                                                                </div>

                                                                <br>

                                                                <div class="row clearfix">
                                                                    <div class="col-sm-4">
                                                                        <input style="width: 85%" name="fecha1" type="date" id="fecha1" size="10">
                                                                    </div>
                                                                    <div class="col-sm-4">

                                                                        <input style="width: 85%" name="fecha2" type="date" id="fecha2" size="10">
                                                                    </div>
                                                                    <div class="col-sm-4">

                                                                        <input style="width: 85%" name="fecha3"type="date" id="fecha3" size="10">
                                                                    </div>
                                                                </div> 
                                                            </div>
                                                        </div>

                                                    </div>


                                                </div>
                                                <div class="col-sm-6">
                                                    <div class="row clearfix">
                                                        <div>
                                                            <label>Descripción de la tarea</label>
                                                        </div>


                                                        <div class="col-sm-12">
                                                            <textarea name="destarea" id="area1" rows="4" cols="65"   placeholder="Please type what you want..."></textarea>
                                                        </div>


                                                        <div>
                                                            <label>URL Manual</label>
                                                        </div>
                                                        <div class="col-sm-12">
                                                            <textarea name="manualarea" id="area2" rows="1" cols="65" placeholder="Please type what you want..."></textarea>
                                                        </div>

                                                        <div>
                                                            <label>URL Video Explicativo</label>
                                                        </div>

                                                        <div class="col-sm-12">
                                                            <textarea name="expliarea"  id="area3" rows="1" cols="65" placeholder="Please type what you want..."></textarea>
                                                        </div>

                                                    </div>


                                                </div>
                                            </div>

                                            <br><br><br>
                                            <div class="row clearfix">

                                                <div class="col-lg-8">
                                                    <div align="center">

                                                        <label style="font-size: 18px; color:darkgreen">TABLA</label>

                                                    </div>
                                                    <div class="table-responsive">
                                                        <table class="table table-bordered table-striped table-hover js-basic-example dataTable">
                                                            <thead>
                                                                <tr>
                                                                    <th>Código</th>
                                                                    <th>Descripción</th>
                                                                    <th>Empresa</th>
                                                                    <th>Categoría</th>
                                                                    <th>Servidor</th>
                                                                    <th>Duración(min)</th>
                                                                    <th>Ejecución</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                                <%
                                                                 if(request.getAttribute("todo")!=null){
                                                                     List<Object> todo=(List<Object>)request.getAttribute("todo");       
                                                                     
                                                                     
                                                                     
                                                                     List<Actividad> act = (List<Actividad>) todo.get(3);    
                                                                     
                                                                  for(int i=0; i<act.size(); i++){
                                                                %>
                                                                <tr>
                                                                    <td><%=act.get(i).getCodigo()%></td>
                                                                    <td><%=act.get(i).getNombre()+":"+act.get(i).getDescripcion()%></td>
                                                                    <td><%=act.get(i).getEmpresa().getNombre()+":"+act.get(i).getEmpresa().getCodigo()%></td>
                                                                    <td><%=act.get(i).getCategoria().getNombre()+":"+ act.get(i).getCategoria().getCodigo()%></td>
                                                                    <td><%=act.get(i).getServidor().getNombre() +":"+ act.get(i).getServidor().getCodigo()%></td>
                                                                    <td><%=act.get(i).getDuracionEst()%></td>
                                                                    <td><%=act.get(i).getEjecucion()%></td>
                                                                </tr>
                                                                <%
                                                            }
                                                                     
                                                        } 
                                                                %>


                                                            </tbody>
                                                        </table>
                                                    </div>


                                                </div>



                                                <div class="col-sm-4">

                                                    <div>

                                                    </div>

                                                    <div class="button-demo">


                                                        <div align="center">
                                                            <label style="font-size: 25px; color:darkgreen">Acciones</label>
                                                        </div>
                                                        <br>
                                                        <br>
                                                        <div>
                                                            <input type="text" id="codigoBAE" name="codigoBAE" class="form-control" placeholder="Código Actividad solo para Busqueda/Actualización/Eliminar">
                                                        </div>
                                                        <br>
                                                        <div class="row clearfix" align="center">
                                                            <div class="col-sm-6">
                                                                <div> <button name="registrar" type="submit" class="btn btn-success waves-effect">Registrar</button></div>
                                                                <div> <button name="buscar" type="submit" class="btn btn-primary waves-effect">Buscar</button></div>
                                                            </div>
                                                            <div class="col-sm-6">
                                                                <div><button name="actualizar" type="submit" class="btn btn-warning waves-effect">Actualizar</button></div>
                                                                <div> <button name="eliminar" type="submit" class="btn btn-danger waves-effect">Eliminar</button></div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </form>

                                <%
                                    if(request.getAttribute("todo")!=null){
                                        System.out.println("Entrada");
                                        List<Object> todo=(List<Object>)request.getAttribute("todo");                            
                                        List<Empresa> emp = (List<Empresa>) todo.get(0);                           
                                        List<Categoria> cat=(List<Categoria>)todo.get(1);
                                        List<Servidor> serv=(List<Servidor>)todo.get(2);
                                         String h;
                                %>                                 
                                <script>
                                    select = document.getElementById("select1");
                                    <%
                                    for (int i = 0; i < emp.size(); i++) { 
                                        h=emp.get(i).getNombre()+": "+emp.get(i).getCodigo();
                                    %>
                                    option = document.createElement("option");
                                    option.value = "<%=emp.get(i).getCodigo()%>";
                                    option.text = "<%=emp.get(i).getNombre()%>";
                                    option.id = "<%=h%>";
                                    select.appendChild(option);

                                    <%
                                    }
                                    %>
                                </script>

                                <script>
                                    select = document.getElementById("select2");
                                    <%
                                   for (int i = 0; i < cat.size(); i++) { 
                                       h=cat.get(i).getNombre()+": "+cat.get(i).getCodigo();
                                    %>
                                    option = document.createElement("option");
                                    option.value = "<%=cat.get(i).getCodigo()%>";
                                    option.text = "<%=cat.get(i).getNombre()%>";
                                    option.id = "<%=h%>";
                                    select.appendChild(option);

                                    <%
                                   }
                                    %>
                                </script>


                                <script>
                                    select = document.getElementById("select3");
                                    <%
                                  for (int i = 0; i < serv.size(); i++) { 
                                      h=serv.get(i).getNombre()+": "+serv.get(i).getCodigo();
                                    %>
                                    option = document.createElement("option");
                                    option.value = "<%=serv.get(i).getCodigo()%>";
                                    option.text = "<%=serv.get(i).getNombre()%>";
                                    option.id = "<%=h%>";
                                    select.appendChild(option);

                                    <%
                                  }
                                    %>
                                </script>

                                <% 
                                 if(todo.size()>5){
                                    Actividad act=(Actividad)todo.get(5);
                                   String especificos[]=act.getEjecucion().split("-");
                                    
                                %>
                                <script>
                                         document.getElementById("<%=act.getEmpresa().getNombre()+": "+act.getEmpresa().getCodigo()%>").selected = "true";
                                         document.getElementById("<%=act.getCategoria().getNombre()+": "+act.getCategoria().getCodigo()%>").selected = "true";
                                         document.getElementById("<%=act.getServidor().getNombre()+": "+act.getServidor().getCodigo()%>").selected = "true";
                                         document.getElementById("input1").value = "<%=act.getNombre()%>";
                                         document.getElementById("input2").value = "<%=act.getIntervaloTiempo()%>";
                                         document.getElementById("input3").value = "<%=act.getNroVecesDia()%>";
                                         document.getElementById("input4").value = "<%=act.getDuracionEst()%>";
                                         document.getElementById("input5").value = "<%=act.getHoraInicio().substring(0, 5)%>";
                                         document.getElementById("fecha1").value = "<%=act.getFechaEspecifica()%>";
                                         document.getElementById("area1").value = "<%=act.getDescripcion()%>";
                                    document.getElementById("area2").value = "<%=act.getURLManual()%>";
                                    document.getElementById("area3").value = "<%=act.getURLVideo()%>";
                                    document.getElementById("codigoBAE").value = "<%=act.getCodigo()%>";
                                    
                                         
                                          
                                </script>
                                <%
                                    for(int j=0; j<especificos.length; j++){
                                    String js=especificos[j];
                                    System.out.println(js);
                                    %>
                                      <script>
                                         document.getElementById("<%=js%>").checked=true;
                                      </script>
                                       <% 
                                        
                                    }
                                    
                                    
                                    }  
                             }                                                           
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

                        <!-- Autosize Plugin Js -->
                        <script src="plugins/autosize/autosize.js"></script>

                        <!-- Moment Plugin Js -->
                        <script src="plugins/momentjs/moment.js"></script>
                        <script src="plugins/jquery-datatable/jquery.dataTables.js"></script>
                        <script src="plugins/jquery-datatable/skin/bootstrap/js/dataTables.bootstrap.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/dataTables.buttons.min.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/buttons.flash.min.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/jszip.min.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/pdfmake.min.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/vfs_fonts.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/buttons.html5.min.js"></script>
                        <script src="plugins/jquery-datatable/extensions/export/buttons.print.min.js"></script>



                        <!-- Bootstrap Material Datetime Picker Plugin Js -->
                        <script src="plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>

                        <!-- Custom Js -->
                        <script src="js/admin.js"></script>
                        <script src="js/pages/forms/basic-form-elements.js"></script>
                        <script src="js/pages/tables/jquery-datatable.js"></script>

                        <!-- Demo Js -->
                        <script src="js/demo.js"></script>
                        </body>

                        </html>
                        <%}%>