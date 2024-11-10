package model;

import java.util.HashMap;
import java.util.Map;

public class BinaryLog implements Log {
    @Override
    public LogEntry parse(String logdata) {
        Map<String,String> data= new HashMap<>();
        data.put("Binary_data",logdata);
        return new LogEntry("BINARY",data);
    }

}
