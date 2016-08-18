package com.i2i.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;

import com.i2i.exception.DatabaseException;

/**
 * Handles Generic tasks.
 *
 * @author Shrie Satheyaa

 * @created 2016-07-08
 */
public class GenericService {

    private static BufferedWriter bufferedWriter =null;
    private static PrintWriter printWriter;

    /**
     * Calls closeSessionFactory() of Super class for closing the SessionFactory object.
     */
    public void terminateSessionFactory() throws DatabaseException {
   //     closeSessionFactory(); 
    }

    /**
     * Writes the exception stack trace to the log file.
     *
     * @param e
     *    Exception Object which is to be written into the log file.
     */
    public static void exceptionWriter(Exception e) {
    	try {
            Date date = new Date();
             SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
             FileWriter fileWriter = new FileWriter("OnlineTicketBooking/log/"+dateFormat.format(date)+".txt", true);
             bufferedWriter = new BufferedWriter(fileWriter);
             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
             fileWriter.append(simpleDateFormat.format(date));
             fileWriter.append("\n");
             printWriter = new PrintWriter(bufferedWriter, true);
             e.printStackTrace(printWriter);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
            printWriter.close();         
        }
    } 
}    