<?php

    class Finah
    {
        static function send_simple_message($to, $subject, $msg)
        {
            $ch = curl_init();
            curl_setopt($ch, CURLOPT_HTTPAUTH, CURLAUTH_BASIC);
            curl_setopt($ch, CURLOPT_USERPWD, 'api:key-565e6499bb52058f2bddef8fb635e30d');
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
            curl_setopt($ch, CURLOPT_POST, true);
            curl_setopt($ch, CURLOPT_URL, 'https://api.mailgun.net/v2/sandboxcf4f32d957ba488ca2ecc971252c6d88.mailgun.org/messages');
            curl_setopt($ch, CURLOPT_POSTFIELDS,
                ['from' => 'webmaster@finah.com',
                    'to' => $to,
                    'subject' => $subject,
                    'html' => $msg]);
            $result = curl_exec($ch);
            curl_close($ch);
            return $result;
        }
        static function arrayToCsv($array,$delimiter=',') {

            return implode($delimiter, $array);
        }
/*        static function arrayToCsv( array &$fields, $delimiter = ';', $enclosure = '"', $encloseAll = false, $nullToMysqlNull = false ) {
            $delimiter_esc = preg_quote($delimiter, '/');
            $enclosure_esc = preg_quote($enclosure, '/');

            $output = [];
            foreach ( $fields as $field ) {
                if ($field === null && $nullToMysqlNull) {
                    $output[] = 'NULL';
                    continue;
                }

                // Enclose fields containing $delimiter, $enclosure or whitespace
                if ( $encloseAll || preg_match( "/(?:${delimiter_esc}|${enclosure_esc}|\s)/", $field ) ) {
                    $output[] = $enclosure . str_replace($enclosure, $enclosure . $enclosure, $field) . $enclosure;
                }
                else {
                    $output[] = $field;
                }
            }

            return implode( $delimiter, $output );
        }*/

        static function csvToArray($csv='', $delimiter=',')
        {
            $header = NULL;
            $data = [];

                while (($row = fgetcsv($csv, 1000, $delimiter)) !== FALSE)
                {
                    if(!$header)
                        $header = $row;
                    else
                        $data[] = array_combine($header, $row);
                }
            return $data;
        }

    }

?>