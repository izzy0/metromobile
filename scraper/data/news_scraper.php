<?php
include('simple_html_dom.php');
$url = "http://www.metrostate.edu/news";
$html = str_get_html(file_get_contents($url));

$newsArticles = array();
//Parse article
foreach($html->find('.article') as $element){
    $header = keep_html_entities($element->find('div h3', 0)->innertext());
    $date= keep_html_entities($element->find('.article-content-meta', 0)->innertext());
    $summary= keep_html_entities($element->find('.article-content-bd p', 0)->innertext());
    $link = $element->find('a', 0)->href;
    
    $newsArticles[] = array(
        'header' => $header,
        'summary' => $summary,
        'date' => $date,
        'link' => $link
        );   
}      

$json_data = json_encode(array('result' => $newsArticles),JSON_UNESCAPED_SLASHES);
file_put_contents('../json/news.json', $json_data);

function keep_html_entities($str){
    return html_entity_decode($str,ENT_QUOTES);
}
