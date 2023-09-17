package fasttrackit.org.Homework.Service;

import fasttrackit.org.Homework.Domain.Transaction;
import fasttrackit.org.Homework.Domain.Type;
import fasttrackit.org.Homework.Exceptions.EntityAlreadyExistsException;
import fasttrackit.org.Homework.Exceptions.EntityDoesntExistException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private List<Transaction> transactions;

    public TransactionService() {
        this.transactions = new ArrayList<>();
    }

    public List<Transaction> getAllTransactions(String product, Type type, double minAmount, double maxAmount){
        List<Transaction> getAllTransactionsFilter = new ArrayList<>();
        for (Transaction currentTransaction : this.transactions){
            if ((currentTransaction.getProduct().equals(product) || product == null) &&
                    (currentTransaction.getType().equals(type) || type == null) &&
                    (currentTransaction.getAmount() > minAmount || minAmount == -1) &&
                    (currentTransaction.getAmount() < maxAmount || maxAmount == -1)){
                getAllTransactionsFilter.add(currentTransaction);
            }
        }
        return getAllTransactionsFilter;
    }

    public Transaction getTransactionById(int id){
        Transaction tr = this.transactions.stream()
                .filter(transaction -> transaction.getId() == id)
                .findFirst().orElse(null);
        if (tr == null){
            throw new EntityDoesntExistException("Transaction with the given id not found", id);
        }
        return tr;
    }

    public Transaction addTransaction(Transaction transaction){
        Transaction tr = this.transactions.stream()
                .filter(t -> t.getId() == transaction.getId())
                .findFirst().orElse(null);
        if (tr == null){
            this.transactions.add(transaction);
            return transaction;
        }
        throw new EntityAlreadyExistsException("Your entity already exist with the given id", transaction.getId());
    }

    public Transaction updateTransaction(Transaction transaction){
        for(Transaction curentTransaction : this.transactions){
            if (curentTransaction.getId() == transaction.getId()){
                curentTransaction.setProduct(transaction.getProduct());
                curentTransaction.setAmount(transaction.getAmount());
                curentTransaction.setType(transaction.getType());
                return curentTransaction;
            }
        }
        this.transactions.add(transaction);
        return transaction;
    }

    public void deleteTransaction(int id){
        int position = -1;

        for(int i = 0; i < this.transactions.size(); i++){
            if (this.transactions.get(i).getId() == id){
                position = i;
            }
        }
        if (position != -1) {
            this.transactions.remove(position);
        }
        else {
            throw new EntityDoesntExistException("Transaction with the given id not found", id);
        }
    }

    public Map<Type, List<Transaction>> getReportType(){
        List<Transaction> bySellType = this.transactions.stream()
                .filter(transaction -> transaction.getType() == Type.SELL)
                .toList();
        List<Transaction> byBuyType = this.transactions.stream()
                .filter(transaction -> transaction.getType() == Type.BUY)
                .toList();

        Map<Type, List<Transaction>> reportType = new HashMap<>();
        reportType.put(Type.SELL, bySellType);
        reportType.put(Type.BUY, byBuyType);
        return reportType;
    }

    public Map<String, List<Transaction>> getReportProduct(String product){
        List<Transaction> transactionByProduct = this.transactions.stream()
                .filter(transaction -> transaction.getProduct().equals(product))
                .toList();
        Map<String, List<Transaction>> reportProduct = new HashMap<>();
        reportProduct.put(product, transactionByProduct);
        return reportProduct;
    }
}
