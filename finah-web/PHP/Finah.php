<?php
    //require("class.phpmailer.php");

    class Finah
    {
        //Onderstaande code is om mail te versturen met Gmail GoogleAPI
        static function send_mail()
        {
            $mailer = new PHPMailer();
            $mailer->IsSMTP();
            $mailer->Host = 'ssl://smtp.gmail.com:465';
            $mailer->SMTPAuth = TRUE;
            $mailer->Username = 'fake[ @ ] googlemail.com';  // Change this to your gmail adress
            $mailer->Password = 'fakepassword';  // Change this to your gmail password
            $mailer->From = 'fake[ @ ] googlemail.com';  // This HAVE TO be your gmail adress
            $mailer->FromName = 'fake'; // This is the from name in the email, you can put anything you like here
            $mailer->Body = 'This is the main body of the email';
            $mailer->Subject = 'This is the subject of the email';
            $mailer->AddAddress('fake2[ @ ] gmail.com');  // This is where you put the email adress of the person you want to mail
            if (!$mailer->Send()) {
                echo "Message was not sent<br/ >";
                echo "Mailer Error: " . $mailer->ErrorInfo;
            } else {
                echo "Message has been sent";
            }

        }

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



    }

?>