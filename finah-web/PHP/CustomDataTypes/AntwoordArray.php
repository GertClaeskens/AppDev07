<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 26/03/2015
     * Time: 0:53
     */
    class AntwoordArray extends ArrayObject
    {
        public function offsetSet($name, $value)
        {
            if (!is_object($value) || !($value instanceof Antwoord)) {
                throw new InvalidArgumentException(sprintf('Only objects of Antwoord allowed.'));
            }
            parent::offsetSet($name, $value);
        }
    }