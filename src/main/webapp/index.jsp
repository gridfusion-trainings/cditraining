<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>TMF Sydney</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                    <a class="navbar-brand">GRIDFUSION NEW</a>
                </div>

                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <!--<li class="active"><a href="#">Home</a></li>-->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Service Portfolio<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#consulting">Consulting</a></li>
                                <li><a href="#managementcoaching">Management Coaching</a></li>
                                <li><a href="#assessments">Assessments</a></li>
                                <li><a href="#proofofconcepts">Proof of Concepts</a></li>
                                <li><a href="#training">Training</a></li>
                                <!--
                                <li class="divider"></li>
                                <li class="dropdown-header">Nav header</li>
                                <li><a href="#">Separated link</a></li>
                                <li><a href="#">One more separated link</a></li>
                                -->
                            </ul>
                        </li>
                        <li><a href="#philosophy">Philosophy</a></li>
                        <li><a href="http://gridfusion.net/blog">Blog</a></li>
                        <li><a href="#about">About Us</a></li>
                        <li><a href="#contact">Contact</a></li>
                        <li><a href="mailto:info@gridfusion.net"><span class="glyphicon glyphicon-envelope"></span></a></li>
                        <li><a href="index_de.html"><img src="img/flag_DE.jpeg"> DE</a></li>
                        <li class=" active pull-right" ><a href="index.html"><img src="img/flag_UK.jpeg"> EN</a></li>

                    </ul>
                </div>
            </div>
        </div>

    </div>
</div>


<div class="container marketing">
    <div class="row">
        <div class="col-lg-12">

            <form id="details" action="process.do" class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input id="firstname" type="text" name="firstname" class="form-control" placeholder="Firstname">
                    <input id="lastname" type="text" name="lastname" class="form-control" placeholder="Lastname">
                    <input id="dob" type="date" name="dateofbirth" class="form-control" placeholder="DOB">
                </div>
                <button id="submitbutton" type="submit" class="btn btn-default">Submit</button>
            </form>
        </div>
     </div>
</div>





<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>