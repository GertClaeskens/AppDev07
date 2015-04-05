<?php

    /**
     * Created by PhpStorm.
     * User: Gert
     * Date: 25/03/2015
     * Time: 23:15
     */
    class PathologieArray extends ArrayObject
    {
        public function offsetSet($name, $value)
        {
            if (!is_object($value) || !($value instanceof Pathologie)) {
                throw new InvalidArgumentException(sprintf('Only objects of Pathologie allowed.'));
            }
            parent::offsetSet($name, $value);
        }
    }