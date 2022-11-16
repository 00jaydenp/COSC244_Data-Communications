import java.io.*;
import java.util.*;

public class BitLevel{
    public static void main (String[] args){
        String infile= "";
        String outfile = "";
        String keyString;
        byte [] key;
        int pos = 0;
        //set two args to infile and outfile
        if(args.length >0){
            infile = args[0];
            outfile = args[1];
        } else {
            System.out.println("Please enter two arguments");
        }
        System.out.println("Enter Key: ");
        Scanner sc = new Scanner (System.in);
        keyString = sc.nextLine();
        // set the key to the bytes of the keyString
        key = keyString.getBytes();
        try{
            //read in infile and outfile as input and output streams
            FileInputStream in = new FileInputStream(infile);
            FileOutputStream out = new FileOutputStream(outfile);

            //read in initial byte
            int b = in.read();

            while(b != -1){
                //reset key to position 0 if it reaches end of string
                if(pos >= keyString.length()){
                    pos = 0;
                }

                //use XOR to write out encrypted bit
                out.write(key[pos]^b);
                pos++;
                out.flush();
                b=in.read();
            }
            out.close();
        } catch (IOException e){
            System.err.println("IO Exception " + e);
        }
    }
}
                
