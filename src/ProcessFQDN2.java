/**
 * This program finds the unique FQDNs and 2LDs in a file, the file
 * is a command line argument.
 *
 * Useage:
 *   java ProcessFQDN2 url.txt
 *
 * @author Nirre Pluf {@literal }
 * @version 0.2, Sept. 19, 2022
 */

import java.io.*;
import java.util.Scanner;


public class ProcessFQDN2 {

    /**
     * main method, where the magic starts...

     * @param args String[], -[c|d|f|t|s] names.txt results.txt
     */
    public static void main(String[] args){
        List<String> uniqueHost = null;  // unique hostnames
        List<String> unique2LD = null;   // unique 2LD names
        List<String> uniqueTLD = null;   // unique TLD names
        int numFQDN;                        // number of FQDNs

        if(!argsOK(args))
            System.exit(1);

        /* use the list specified by the user... */
        if(args[0].equals("-d")) {
            /*
            uniqueHost = new DList<String>();
            unique2LD = new DList<String>();
            uniqueTLD = new DList<String>();
            */
        }
        else if(args[0].equals("-s")) {
            /*
            uniqueHost = new SortedList<String>();
            unique2LD = new SortedList<String>();
            uniqueTLD = new SortedList<String>();
            */
        }
        else {
            System.out.println("list type " + args[0] + " is incorrect ");
            return;
        }

        final long startTime = System.currentTimeMillis();
        numFQDN = readNameFile(args[1], uniqueHost, unique2LD, uniqueTLD);
        displayNameInfo(args[2], numFQDN, uniqueHost, unique2LD, uniqueTLD);
        final long endTime = System.currentTimeMillis();

        /* just subtract the two times */
        long difference = endTime - startTime;
        System.out.println("Time to complete: " + difference + " msec");
    }

    /* a lot more code here, hear? */


    /**
     *  This method reads (and eventually stores) FQDN and 2LD in the fqdn file
     *
     *  @param  filename is the fqdn filename (command line argument)
     */
    static int readNameFile(String fileName, List<String> uniqueHost, List<String> unique2LD,
                            List<String> uniqueTLD) {
        int numFQDN = 0;
        // reading the name file
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNext()) {
                String line = input.nextLine();
                line = line.toLowerCase();
                System.out.println(line);
            }
            input.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("Error in opening " + fileName);
            System.exit(1);
        }

        return numFQDN;
    }


    /**
     *  This method displays the stats and FQDN and 2LD found in the file
     *
     *  @param  the lists...
     */
    static void displayNameInfo(String filename, int numFQDN, List<String> uniqueHost, List<String> unique2LD,
                                List<String> uniqueTLD) {

    }


    /**
     *  This method returns true if the command line arguments are acceptable,
     *
     *  @param  args list of Strings (command line arguments)
     *  @return true if the arguments are acceptable, false otherwise
     */
     private static boolean argsOK(String[] args) {
         if(args.length < 3) {
             System.out.println("Usage: java program [-c|d|f|s|t] nameFile outputFile");
             System.out.println("  -c|d|f|s|t      list management (count, double, front, sorted, transpose)");
             System.out.println("  nameFile    file containing input names ");
             System.out.println("  outputFile  file containing output name info ");
             return false;
         }
         return true;
     }

}
