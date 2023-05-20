package com.vhbeltramini.dronezeta.model.enums;

public enum OrderStatus {

    WAITING_PAYMENT {
        @Override
        public boolean isWaitingForPayment() {
            return true;
        }
    },
    PAYMENT_CONFIRMED {
        @Override
        public boolean isPaymentConfirmed() {
            return true;
        }
    },
    READY {
        @Override
        public boolean isReadyToSent() {
            return true;
        }
    },
    SENT {
        @Override
        public boolean isSent() {
            return true;
        }
    },
    DELIVERED() {
        @Override
        public boolean isDelivered() {
            return true;
        }
    };

    private int timeToDelivery;
    private String description;
    private Integer statusID;

    public boolean isPaymentConfirmed() {
        return false;
    }

    public boolean isSent() {
        return false;
    }

    public boolean isReadyToSent() {
        return false;
    }

    public boolean isWaitingForPayment() {
        return false;
    }

    public boolean isDelivered() {
        return false;
    }

    public String getDescription() {
        return description;
    }

    public Integer getTimeToDelivery() {
        return timeToDelivery;
    }

    public Integer getStatusID() {
        return statusID;
    }

    OrderStatus() {
    }
}
