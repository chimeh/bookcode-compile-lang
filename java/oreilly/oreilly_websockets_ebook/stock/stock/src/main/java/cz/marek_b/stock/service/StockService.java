package cz.marek_b.stock.service;

import java.util.List;
import java.util.Map;

public interface StockService {
    
    Map<String, Double> getStockData(List<String> stocks);
    
}
