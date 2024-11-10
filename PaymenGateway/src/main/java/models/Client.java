package models;

import java.util.HashSet;
import java.util.Set;

public class Client {
    private String id;
    private String name;
    private Set<String> paymentModes = new HashSet<>();
}
