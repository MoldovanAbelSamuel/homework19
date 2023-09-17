package fasttrackit.org.Homework.Domain;

public class Transaction {
    private int id;
    private String product;
    private Type type;
    private double amount;

    public Transaction(int id, String product, Type type, double amount) {
        this.id = id;
        this.product = product;
        this.type = type;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Transaction{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
