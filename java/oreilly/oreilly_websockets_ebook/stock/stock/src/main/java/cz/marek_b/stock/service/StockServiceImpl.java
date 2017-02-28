package cz.marek_b.stock.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ejb.Stateless;

@Stateless
public class StockServiceImpl implements StockService {

    @Override
    public Map<String, Double> getStockData(List<String> stocks) {
        Map<String, Double> result = new HashMap<>();
        for (String stock : stocks) {
            result.put(stock, generateRandomDouble());
        }
        return result;
    }
    
    private double generateRandomDouble() {
        return 1000 * new Random().nextDouble();
    }
    
}
