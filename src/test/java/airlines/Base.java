package airlines;

import java.io.IOException;
import java.util.Map;

import static utils.JsonUtils.getJsonDataAsMap;

public class Base {

    public static Map<String,Object> dataFromJsonFile;
    static{
        String env = System.getProperty("env")==null ? "qa" : System.getProperty("env");
        try {
            dataFromJsonFile = getJsonDataAsMap("airlines/"+env+"/airlinesApiData.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
