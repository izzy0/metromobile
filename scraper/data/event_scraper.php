<?php
include('simple_html_dom.php');
$url = "http://www.metrostate.edu/events?currentPage=";
$num = 1;
$eventArticles = array();

while(true){
    $curr_url = $url . $num;
    $html = str_get_html(file_get_contents($curr_url));
    
    if(($html->find('.article')) == null){
        break;
    }
  
    //Parse article
    foreach($html->find('.article') as $element){
        $header = keep_html_entities($element->find('div h3', 0)->innertext());
        $date= keep_html_entities($element->find('.article-content-meta', 0)->innertext());
        $summary= keep_html_entities($element->find('.article-content-bd p', 0)->innertext());
        $link = $element->find('a', 0)->href;

        $eventArticles[] = array(
            'header' => $header,
            'summary' => $summary,
            'date' => $date,    
            'link' => $link
            );   
    }   
    
    $num++;
}
$json_data = json_encode(array('result' => $eventArticles),JSON_UNESCAPED_SLASHES);
file_put_contents('../json/events.json', $json_data);

function keep_html_entities($str){
    return html_entity_decode($str,ENT_QUOTES);
}
?>