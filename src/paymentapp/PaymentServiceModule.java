package paymentapp;
import com.google.inject.AbstractModule;

public class PaymentServiceModule extends AbstractModule{
    @Override
    protected void configure(){
        bind(Transaction.class).toProvider(TransactionProvider.class);
    }
}
