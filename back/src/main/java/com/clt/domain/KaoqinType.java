package com.clt.domain;

public class KaoqinType {
    private String controlerId;

    private String controlerName;

    private String controlTaskOrderId;

    private String controlTaskName;

    public KaoqinType(String controlerId, String controlerName, String controlTaskOrderId, String controlTaskName) {
        this.controlerId = controlerId;
        this.controlerName = controlerName;
        this.controlTaskOrderId = controlTaskOrderId;
        this.controlTaskName = controlTaskName;
    }

    public KaoqinType() {
        super();
    }

    public String getControlerId() {
        return controlerId;
    }

    public void setControlerId(String controlerId) {
        this.controlerId = controlerId == null ? null : controlerId.trim();
    }

    public String getControlerName() {
        return controlerName;
    }

    public void setControlerName(String controlerName) {
        this.controlerName = controlerName == null ? null : controlerName.trim();
    }

    public String getControlTaskOrderId() {
        return controlTaskOrderId;
    }

    public void setControlTaskOrderId(String controlTaskOrderId) {
        this.controlTaskOrderId = controlTaskOrderId == null ? null : controlTaskOrderId.trim();
    }

    public String getControlTaskName() {
        return controlTaskName;
    }

    public void setControlTaskName(String controlTaskName) {
        this.controlTaskName = controlTaskName == null ? null : controlTaskName.trim();
    }
}