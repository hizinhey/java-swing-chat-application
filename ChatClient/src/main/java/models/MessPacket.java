package models;

import java.io.Serializable;

public abstract class MessPacket implements Serializable {
    static final long serialVersionUID = -1;
    protected String flag;

    protected abstract void setFlag();
    public String getFlag(){
        return flag;
    }
}
