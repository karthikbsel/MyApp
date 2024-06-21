package session20;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class SerializationAndDeserialization {

    @Test
    public  void test(){
        Employee emp1 = new Employee();
        emp1.setFirstname("suresh");
        emp1.setSalary(1000000);
        ObjectMapper objectMapper = new ObjectMapper();
        String string = null;
        try {
            string = objectMapper.writeValueAsString(emp1);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(string);

        }
}
