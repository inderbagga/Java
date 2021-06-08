package multithreading;

import java.io.IOException;

public class JavaRuntime {

    public static void main(String[] args){

        openLibreOffice();

    }

    static private void openLibreOffice(){

        Runtime runtime=Runtime.getRuntime();

        try {
            runtime.exec("/usr/bin/libreoffice");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
