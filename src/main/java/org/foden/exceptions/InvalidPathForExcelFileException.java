package org.foden.exceptions;

public class InvalidPathForExcelFileException extends InvalidPathForFileException{

    /**
     * Instantiates a new Invalid path for excel file exception.
     *
     * @param message the message
     */
    public InvalidPathForExcelFileException(String message){
        super(message);
    }

    /**
     * Instantiates a new Invalid path for excel file exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public InvalidPathForExcelFileException(String message, Throwable cause){
        super(message,cause);
    }
}
