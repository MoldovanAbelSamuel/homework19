package fasttrackit.org.Homework.Domain;

public class TransactionDTO {
    private String product;
    private Type type;
    private double amount;

    public TransactionDTO(String product, Type type, double amount) {
        this.product = product;
        this.type = type;
        this.amount = amount;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "product='" + product + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
