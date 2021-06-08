package multithreading;

import java.io.IOException;

public class JavaRuntime {

    public static void main(String[] args){

        String operatingSystem=System.getProperty("os.name");

        //openLibreOffice(operatingSystem);//uncomment to open another application.*/

        shutdown(operatingSystem,true);
    }

    static private void shutdown(String OS,boolean restart){

        Runtime runtime=Runtime.getRuntime();

        try {

            if(OS.equals("Linux")){
                Process proc =runtime.exec(restart?"shutdown -r -t 0":"shutdown -h -t 0");
                System.exit(0);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static private void openLibreOffice(String OS){

        Runtime runtime=Runtime.getRuntime();

        try {
            if(OS.equals("Linux"))
                runtime.exec("/usr/bin/libreoffice");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
