package com.vhbeltramini.dronezeta.model.enums;

public enum OrderStatus {

    WAITING_PAYMENT(5, "Aguardando pagamento.", 60) {
        @Override
        public boolean isWaitingForPayment() {
            return true;
        }
    },
    PAYMENT_CONFIRMED(4, "Pagamento Confirmado", 60) {
        @Override
        public boolean isPaymentConfirmed() {
            return true;
        }
    },
    READY(3, "Pronto para envio", 60) {
        @Override
        public boolean isReadyToSent() {
            return true;
        }
    },
    SENT(2, "Enviado", 60) {
        @Override
        public boolean isSent() {
            return true;
        }
    },
    DELIVERED(1, "Entregue", 0) {
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

    OrderStatus(Integer id, String description, Integer timeToDelivery) {
        this.statusID = id;
        this.description = description;
        this.timeToDelivery = timeToDelivery;
    }
}
