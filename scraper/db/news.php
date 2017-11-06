<?php

include_once 'db_connect.php';

class News {

    private $db;
    private $db_table = "news";

    public function __construct() {
        $this->db = new DbConnect();
    }

    public function createNewsRows() {

        $jsondata = file_get_contents('../json/news.json');
        $data = json_decode($jsondata, true);

        foreach ($data as $row) {
            $name = $row['Header'];
            $date = $row['Date'];
            $link = $row['Link'];
            $summary = $row['Summary'];

            $query = "INSERT INTO news(news_header, news_date, news_summary, news_link) VALUES('$name', '$date', '$summary', '$link')";
            $inserted = mysqli_query($this->db->getDb(), $query);

            if ($inserted == 1) {
                $json['success'] = 1;
                $json['message'] = "Successfully registered the user";
            } else {

                $json['success'] = 0;
                $json['message'] = "Error in creation";
            }
        }
        mysqli_close($this->db->getDb());
        return $json;
    }

    public function createJSON() {
        $sql = "SELECT * FROM news";

        $r = mysqli_query($this->db->getDb(), $sql);

        $result = array();

        while ($row = mysqli_fetch_array($r)) {
            array_push($result, array(
                'news_header' => $row['news_header'],
                'news_summary' => $row['news_summary'],
                'news_date' => $row['news_date'],
                'news_link' => $row['news_link']
            ));
        }

        $parse_news =  json_encode(array('result' => $result),JSON_UNESCAPED_SLASHES);
        
        file_put_contents('../json/parse_news.json', $parse_news);
        mysqli_close($this->db->getDb());
    }

}

?>