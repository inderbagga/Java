package strings;

public class Reverse {

    public static void main(String[] args){

        String adjective="Grateful";
        String name="Inder Bagga";

        //using single loop
        reverseInCamel(adjective.toLowerCase());
        reverseInCamel(name.toLowerCase());

        //using byte[]
        reverseInBytes(adjective);
    }

    private static void reverseInBytes(String adjective) {

        byte[] inBytes=adjective.getBytes();
        byte[] revBytes=new byte[inBytes.length];


        for(int i=0;i<inBytes.length;i++){
            revBytes[i]=inBytes[inBytes.length-1-i];
        }

        System.out.println(new String(revBytes));
    }

    private static void reverseInCamel(String input) {

        String output="";

        for(int i=input.length()-1;i>=0;i--){
            output=output.concat(String.valueOf(input.charAt(i)));
        }


        if(input.contains(" ")){

            int position=input.indexOf(" ")+1;

            System.out.println(output.substring(0,1).toUpperCase()+
                    output.substring(1,position)+
                    output.substring(position,position+1).toUpperCase()+
                    output.substring(position+1,output.length()));
        }
        else System.out.println(output.substring(0,1).toUpperCase()+
                output.substring(1,output.length()));
    }
}
