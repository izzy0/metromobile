<?php
include('simple_html_dom.php');
$url = "http://www.metrostate.edu/events";
$html = str_get_html(file_get_contents($url));

$eventContent = array(
    'Header' => array(),
    'Date' => array(),
    'Summary' => array(),
    'Link' => array()
    );
//Parse article
foreach($html->find('.article') as $element){
    $header = $element->find('div h3', 0)->innertext() . '<br />';
    array_push($eventContent['Header'], $header);
    
    $date= $element->find('.article-content-meta', 0)->innertext() . '<br />';
    array_push($eventContent['Date'], $date);
    
    $summary= $element->find('.article-content-bd p', 0)->innertext() . '<br />';
    array_push($eventContent['Summary'], $summary);
    
    $link = $element->find('a', 0)->href . '<br />';
    array_push($eventContent['Link'], $link);
}      

$json_data = json_encode($eventContent,JSON_UNESCAPED_SLASHES);
file_put_contents('./json/events.json', $json_data);
?>