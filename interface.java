interface IPayment {
    void pay(double amount);
}

interface IRefund {
    void refund(int failedPaymentId, double amount);
}

class HdfcCard implements IPayment, IRefund {

    public void pay(double amount) {
        System.out.println("Paying through HDFC Card, amount: " + amount);
    }

    public void refund(int failedPaymentId, double amount) {
        System.out.println("HDFC initiated refund for Payment ID: " + failedPaymentId + ", Amount: " + amount);
    }
}
