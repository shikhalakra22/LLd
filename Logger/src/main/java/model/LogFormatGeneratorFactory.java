package model;

public class LogFormatGeneratorFactory {

    public Log getparse(String value){
        switch (value.toUpperCase()){
            case "TEXT":
                return new TextLog();
            case "JSON":
                return new JsonLog();
            case "BINARY":
                return new BinaryLog();
            default:
                throw new IllegalArgumentException("unsupported format "+ value );
        }
    }
}
