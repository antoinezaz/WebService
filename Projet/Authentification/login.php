<?php
/**
 * Created by IntelliJ IDEA.
 * User: Julien
 * Date: 02/06/2016
 * Time: 23:48
 */

    $user = $_POST['user'];
    $pass = $_POST['pass'];

    if ($user != "billy" && $pass != "billy123")
    {
        $response["succes"] = -1;
        $response["message"] = "Authentification incorrect.";
    }
    else {
        $response["succes"] = 0;
        $response["message"] = "Vous êtes maintenant connecté.";
    }
?>