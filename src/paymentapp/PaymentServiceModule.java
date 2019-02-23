package paymentapp;
import com.google.inject.AbstractModule;

/**
 *
 * @author nicho
 */
public class PaymentServiceModule extends AbstractModule{
    @Override
    protected void configure(){
        bind(Transaction.class).toProvider(TransactionProvider.class);
    }
}
