package org.example;

import model.LogEntry;
import service.LogManager;
//Design a logging application for analyzing logs
//Should be able to parse different types of logs (JSON, txt, Binary)
//Should have a search API for keys
//Returns true if key is present in txt files
//Returns the value if key is present in JSON file
//Success metric : End to end running code with extensible design
public class Main {
    String format;
    public static void main(String[] args) {
        LogManager logManager = new LogManager();


        String jsonLog = "{\"event\":\"login\", \"status\":\"success\", \"user\":\"john\"}";
        LogEntry logEntry = logManager.parse("JSON",jsonLog);
        System.out.println("search for user:"+ logManager.getsearchitem(logEntry,"user"));


        String textLog = "event: login\nstatus: success\nuser: john";
        LogEntry textEntry = logManager.parse("TEXT", textLog);
        System.out.println("search for status:"+ logManager.getsearchitem(textEntry,"status"));

        String binaryLog = "0101011101001111";
        LogEntry binaryEntry = logManager.parse("BINARY", binaryLog);
        System.out.println("Search for 'status': " + logManager.getsearchitem(binaryEntry, "status"));

    }
}