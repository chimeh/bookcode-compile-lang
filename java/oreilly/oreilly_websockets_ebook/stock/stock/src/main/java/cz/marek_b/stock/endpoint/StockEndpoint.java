package cz.marek_b.stock.endpoint;

import cz.marek_b.stock.service.StockService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.json.JSONArray;
import org.json.JSONObject;

@ServerEndpoint("/stockEndpoint")
public class StockEndpoint {
    private static final Logger LOG = Logger.getLogger(StockEndpoint.class.getName());
    
    @EJB
    private StockService stockService;
    
    private Session peer;
    private final Timer timer = new Timer("stockTimer");
    
    @OnOpen
    public void onOpen(Session peer) {
        this.peer = peer;
    }
    
    @OnMessage
    public void onMessage(String message) {
        JSONObject jsonObj = new JSONObject(message);
        final JSONArray jsonArr = jsonObj.getJSONArray("stocks");
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                peer.getAsyncRemote().sendObject(
                    new JSONObject(stockService.getStockData(jsonArrToList(jsonArr)))
                );
            }
        }, 0, 2*1000);
        
    }
    
    @OnClose
    public void onClose() {
        try {
            peer.close();
        } catch (IOException ex) {
            LOG.warning(ex.getMessage());
        }
    }
    
    private List<String> jsonArrToList(JSONArray jsonArr) {
        List<String> result = new ArrayList<>(jsonArr.length());
        for (int i=0; i<jsonArr.length(); i++) {
            result.add(jsonArr.getString(i));
        }
        return result;
    }
    
}
