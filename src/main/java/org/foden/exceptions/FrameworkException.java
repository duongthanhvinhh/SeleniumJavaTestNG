package org.foden.exceptions;

/**
 * The type Framework exception.
 */
public class FrameworkException extends RuntimeException{

    /**
     * Instantiates a new Framework exception.
     *
     * @param message the message
     */
    public FrameworkException(String message){
        super(message);
    }

    /**
     * Instantiates a new Framework exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public FrameworkException(String message, Throwable cause){
        super(message,cause);
    }
}
