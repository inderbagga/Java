package strings;

public class Reverse {

    public static void main(String[] args){

        //using single loop
        reverseInCamel("Grateful".toLowerCase());
        reverseInCamel("Inder Bagga".toLowerCase());
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
