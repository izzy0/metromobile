<?php

require_once 'news.php';

$newsObject = new News();


$json_create = $newsObject->createJSON();

?>