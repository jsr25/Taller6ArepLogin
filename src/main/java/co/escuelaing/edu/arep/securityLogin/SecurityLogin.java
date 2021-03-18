package co.escuelaing.edu.arep.securityLogin;


import static spark.Spark.*;

public class SecurityLogin {
    public static void main(String[] args) {
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null);
        port(getPort());
        staticFiles.location("/staticfiles");
        init();

        get("/hello",(req,res)->{

            res.redirect ("test.html");

            return "";
        });
    }

    public static int getPort(){
        if(System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 8080;
    }



}
