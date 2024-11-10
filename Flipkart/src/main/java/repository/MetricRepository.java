package repository;

import lombok.Getter;
import model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Getter

public class MetricRepository {
    private Map<String, Map<String, Integer>> productMetrics = new HashMap<>();

    public MetricRepository() {
//            id ,productId,category ,countorder ,viewcount
//                    1, 123, chocolate, 100,order

        productMetrics.put("views", new HashMap<>());
        productMetrics.put("orders", new HashMap<>());
        productMetrics.get("views").put("P123_Laptop", 100);
        productMetrics.get("views").put("P124_dress", 150);
        productMetrics.get("views").put("P1_Phone", 200);
        productMetrics.get("orders").put("P123_Laptop", 200);
        productMetrics.get("orders").put("P1_Phone", 500);
        productMetrics.get("orders").put("P125_Chocolates", 300);
    }

//    public List<Product> fetchTopProductsByMetric(String metric, int limit) {
//        Map<String, Integer> metrics = productMetrics.get(metric);
//        return metrics.entrySet().stream()
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
//                .limit(limit)
//                .map(entry -> new Product(entry.getKey(),   entry.getKey(), entry.getKey().split("_")[1]))
//                .collect(Collectors.toList());
//    }




}
