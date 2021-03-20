package co.escuelaing.edu.arep.connect;



import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ConnectJava {

    /**
     * Metodo que realiza la conexion con el api y obtiene una respuesta
     * al enviar un json
     * @param numa primer numero ingresado
     * @param numb segundo numero ingresado
     * @param ope operacion realizada
     * @return resultado del a operacion sobre los dos numeros
     */
    public Integer connect(String numa, String numb, String ope){
        System.setProperty("javax.net.ssl.trustStore", "keystores/trusStoreApi");
        System.setProperty("javax.net.ssl.trustStorePassword", "123456");
        String https_url = "https://localhost:35000/"+ope;
        URL url;
        try {
            url = new URL(https_url);
            HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json; utf-8");
            con.setRequestProperty("Accept", "application/json");
            String jsonInputString = "{\"numa\": \""+numa+"\", \"numb\": \""+numb+"\", \"oper: \""+ope+"\"}";
            try(OutputStream os = con.getOutputStream()) {
                byte[] input = jsonInputString.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            con.connect();
            System.out.println("Creo que sirvio");
            Integer result = getResult(con);
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }


    /**
     * Metodo con el que se obtiene el resultado que llega despues de realizar la peticion
     * @param con connecion http creada
     * @return valor que trae la peticion en el body
     */
    private Integer getResult(HttpsURLConnection con){
        if(con!=null){
            try {
                List<String> list = new ArrayList<>();
                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(con.getInputStream()));

                String input;

                while ((input = br.readLine()) != null){
                    list.add(input);

                }
                br.close();
                return Integer.parseInt(list.get(list.size()-1));

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return 0;

    }

}




