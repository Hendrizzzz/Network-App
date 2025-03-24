package hendrizzzz.network_app.model;

import java.util.Map;

public class WebSocketMessage {
    private String type;
    private Map<String, Object> data; // Map to hold dynamic fields in 'data'

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}

