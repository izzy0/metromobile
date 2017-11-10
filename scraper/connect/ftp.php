<?php
$host = 'gator4247.hostgator.com';
$user = 'public_metro@russwilkie.com ';
$pass = 'um!Pky0nlE';
$port = '21';
$timeout = 1000;
        
$source_news_file = '../json/news.json';
$dest_news_file = 'news.json';

$source_events_file = '../json/events.json';
$dest_events_file = 'events.json';

$ftp = ftp_connect($host,$port,$timeout);
ftp_login($ftp,$user,$pass);

ftp_delete($ftp, $dest_events_file);
ftp_delete($ftp, $dest_news_file);

$upload_news = ftp_nb_put($ftp, $dest_news_file, $source_news_file, FTP_BINARY, FTP_AUTORESUME);
$upload_events = ftp_nb_put($ftp, $dest_events_file, $source_events_file, FTP_BINARY, FTP_AUTORESUME);

while (FTP_MOREDATA == $upload_news )
    {
        $upload_news = ftp_nb_continue($ftp);
    }
    
while (FTP_MOREDATA == $upload_events)
    {
        $upload_events = ftp_nb_continue($ftp);
    }
    
    ftp_close($ftp);

?>