package co.escuelaing.edu.arep.securityLogin;


import co.escuelaing.edu.arep.authenticate.impl.AuthenticateImpl;
import co.escuelaing.edu.arep.connect.ConnectJava;

import static spark.Spark.*;

public class SecurityLogin {
    public static void main(String[] args) {
        secure("keystores/ecikeystore.p12", "123456", "keystores/trusStoreApi", "123456");
        port(getPort());
        staticFiles.location("/staticfiles");

        options("/",
                (request, response) -> {
                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", ""));
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

    /**
     * Metodo para obtener el puerto que se va a usar en la aplicacion
     * @return numero que indica el puerto
     */
    public static int getPort(){
        if(System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 34000;
    }



}
