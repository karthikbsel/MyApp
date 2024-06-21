package session20;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Runtime.getRuntime;

public class curl {

    @Test
    public void f() throws Exception {

        String cmd1 = "curl -k -v -X POST -H 'Content-type: application/json' -d \"client_id=94850650719842148D619BA4EC4125C6&client_secret=2dbfd6631ede41caa387b4af2e410288f27244c30e3d70e24bda42fcfcdf137c\" https://xray.cloud.getxray.app/api/v2/authenticate";

        String authToken=null;

        String json_filePath="C:/Users/210076/Downloads/";

        String jsonPath = json_filePath+"cucumber333.json";

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(cmd1).getInputStream()));
            String line;
            while((line=is.readLine())!=null){
                authToken=line;
            }
            String cmd3="curl -X POST  -H \"Content-Type: application/json\" -H \"Authorization: Bearer "+authToken+" -d @\""+jsonPath+"\"  https://xray.cloud.getxray.app/api/v2/import/execution/cucumber";
            cmd3=cmd3.replace("Bearer \"","Bearer ");
            Runtime.getRuntime().exec(cmd3).getOutputStream().toString();
            BufferedReader is1 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(cmd3).getInputStream()));
            String line1;
            while((line1=is1.readLine())!=null){
                System.out.println(line1);
            }
        }catch (Exception e){
            e.printStackTrace();

        }

    }

}
