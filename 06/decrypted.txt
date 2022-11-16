import java.io.*;

public class Caesar{
    public static void main(String[] args){
        InputStream in = System.in;
        OutputStream out = System.out;

        int shift = 0;
        int count;

        /** Makes sure that there are arguments entered **/
        if(args.length > 0){
            /** try block to make sure the shift entered is an integer **/
            try{
                /** Set shift to be the first argument entered **/
                shift = Integer.parseInt(args[0]);
            } catch(NumberFormatException e){
                System.out.print("Argument " + args[0] + " has to be an integer");
                System.exit(0);
            }
        } else {
            System.out.print("Enter an integer into commandline");
        }
        /** Try block to make sure that the value of the character being shifted wraps around **/
        try{
            while((count = in.read())!= -1){
                /** Offset the count by the shift **/
                count += shift;
                if(count > 255){
                    count = count % 256;
                }
                /** write out encrypted byte **/
                out.write(count);
                out.flush();
            }
            /** close output file **/
            out.close();
        } catch (IOException e){
            System.out.print("IO exception caught " + e);
        }
    }
}
            
                
