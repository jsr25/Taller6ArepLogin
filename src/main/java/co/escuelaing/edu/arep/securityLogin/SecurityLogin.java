package co.escuelaing.edu.arep.securityLogin;


import co.escuelaing.edu.arep.authenticate.impl.AuthenticateImpl;
import co.escuelaing.edu.arep.connect.ConnectJava;

import static spark.Spark.*;

public class SecurityLogin {
    public static void main(String[] args) {
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath, truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", "keystores/trusStoreApi", "123456");
        port(getPort());
        staticFiles.location("/staticfiles");
        init();

        get("/opera/:numa/:numb/:ope",(req,res)->{
            ConnectJava connectJava= new ConnectJava();
            return connectJava.connect(req.params(":numa"),req.params(":numb"),req.params(":ope"));
        });


        post("/login",(req,res)->{
            String val=req.body();
            AuthenticateImpl authenticate = new AuthenticateImpl();
            authenticate.convert(val);
            authenticate.comprobar();
            return authenticate.comprobar();
        });

        get("/login",(req,res)->{
            res.redirect ("calc.html");
            return "";
        });
    }

    public static int getPort(){
        if(System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }



}
