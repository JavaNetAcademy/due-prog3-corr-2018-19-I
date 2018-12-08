<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='webjars/bootstrap/4.1.3/css/bootstrap.min.css'>
</head>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <span class="navbar-brand">HOE</span>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Admin
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="../hero">Hero</a>
                    <a class="dropdown-item" href="../pets">Pets</a>
                    <a class="dropdown-item" href="../empires">Empires</a>
                    <a class="dropdown-item" href="../job">Job</a>
                    <a class="dropdown-item" href="../weapons">Weapons</a>
                    <a class="dropdown-item" href="../armor">Armor</a>
                    <a class="dropdown-item" href="../settlements">Settlements</a>
                    <a class="dropdown-item" href="../factories">Factories</a>
                    <a class="dropdown-item" href="../skills">Skills</a>
                </div>
            </li>
        </ul>

        <span class="navbar-text">
            Hello, ${sessionScope.user.name}!
        </span>
    </div>
</nav>

<script type="text/javascript" src="webjars/jquery/2.2.1/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>