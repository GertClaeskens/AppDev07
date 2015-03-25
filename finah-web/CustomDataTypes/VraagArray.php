<?php
/**
 * Created by PhpStorm.
 * User: Gert
 * Date: 26/03/2015
 * Time: 0:44
 */

class VraagArray extends ArrayObject{
    public function offsetSet($name, $value)
    {
        if (!is_object($value) || !($value instanceof Vraag)) {
            throw new InvalidArgumentException(sprintf('Only objects of Vraag allowed.'));
        }
        parent::offsetSet($name, $value);
    }
}