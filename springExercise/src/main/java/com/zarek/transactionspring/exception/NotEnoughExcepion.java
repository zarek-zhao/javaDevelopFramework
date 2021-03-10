package com.zarek.transactionspring.exception;

/**
 * @author zhao
 * @date 2021/3/3 11:43
 */
public class NotEnoughExcepion extends RuntimeException{

    public NotEnoughExcepion()
    {
    }

    public NotEnoughExcepion(String message)
    {
        super(message);
    }

}
