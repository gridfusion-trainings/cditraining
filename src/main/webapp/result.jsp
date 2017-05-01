<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cisco Vienna Result</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- NAVBAR
================================================== -->
<body>
<div class="navbar-wrapper">
    <div class="container">

        <div class="navbar navbar-inverse navbar-static-top" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand">ELEMENT34</a>
                </div>
            </div>
        </div>

    </div>
</div>

<div class="container marketing">
    <div class="row">
        <div class="col-lg-6">

            <div class="panel panel-default">
                <div class="panel-body">
                    <%
                        String fullname = request.getAttribute("fullname").toString();
                        String length = request.getAttribute("length").toString();

                        out.print("<div id=fullname><p>You entered " + fullname + " as your name</p><div>");
                        out.print("<div id=length><p>Your name has " + length + " characters</p><div>");
                    %>
                </div>
            </div>

        </div>
    </div>
</div>



<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
