package cz.marek_b.stock.bean;

import java.io.Serializable;

public class Stock implements Serializable {

    private static final long serialVersionUID = -6826575209603986205L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
