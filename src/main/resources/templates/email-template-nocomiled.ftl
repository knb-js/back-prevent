<<!DOCTYPE html>
<html lang="en">
<head>
  <style>
  	.title	{
    	background-color: transparent;
        border-bottom: 1px solid rgba(0,0,0,.125);
        padding: .75rem 1.25rem;
        position: relative;
        border-top-left-radius: .25rem;
        border-top-right-radius: .25rem;
    }
    .btn-confirm {
    	background-color: rgb(22,202,133);
        border-color: rgb(21,212,139);
    }
    .btn-confirm:hover {
    	background-color: #20b2aa;
        border-color: #20b2aa;
    }
  </style>
</head>
<body class="bg-light">
  <div class="container">
        <img class="ax-center mt-10 w-40" src="https://i.ibb.co/SBDtKpV/logo-No-Mas.png" />
    <h1 class="title text-center"><strong>NO</strong> <br /> + Accidentes</h1>
    <div class="card p-6 p-lg-10 space-y-4 text-center">
      <h1 class="h3 fw-700 text-center">
        Cambiar contraseña
      </h1>
      <p>
       	Has solicitado un cambio de contraseña, favor de presionar el botón para realizarlo
      </p>
      <a class="btn btn-confirm text-white p-3 fw-700 text-center" href="http://localhost:4300/resetPassword?token=123123">Confirmar correo</a>
    </div>
    <div class="text-muted text-center my-6">
      No + accidentes <br>
      Caso 4<br>
    </div>
  </div>
</body>