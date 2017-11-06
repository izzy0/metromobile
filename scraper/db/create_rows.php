<?php

require_once 'news.php';

$username = "";

$password = "";

$email = "";

if (isset($_POST['news_header']) && isset($_POST['news_summary']) && isset($_POST['news_link'])) {

    $header = $_POST['news_header'];
    $summary = $_POST['news_summary'];
    $link = $_POST['news_link'];
}

$newsObject = new News();


$json_registration = $newsObject->createNewsRows();

echo json_encode($json_registration);

?>