<?php
include('simple_html_dom.php');
$url = "http://www.metrostate.edu/events";
$html = str_get_html(file_get_contents($url));

$eventArticles = array();
//Parse article
foreach($html->find('.article') as $element){
    $header = $element->find('div h3', 0)->innertext();
    $date= $element->find('.article-content-meta', 0)->innertext();
    $summary= $element->find('.article-content-bd p', 0)->innertext();
    $link = $element->find('a', 0)->href;
    
    $eventArticles[] = array(
        'Header' => $header,
        'Date' => $date,
        'Summary' => $summary,
        'Link' => $link
        );   
}      

$json_data = json_encode($eventArticles,JSON_UNESCAPED_SLASHES);
file_put_contents('../json/events.json', $json_data);
?>