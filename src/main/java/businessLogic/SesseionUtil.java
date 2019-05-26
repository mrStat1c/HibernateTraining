package businessLogic;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SesseionUtil {

    @Getter
    private Session session;
    @Getter
    private Transaction transaction;

    public Session openSession(){
        return DbConnectionProvider.getSessionFactory().openSession();

    }

    public Session openTransactionSession(){
        session = openSession();
        transaction = session.beginTransaction();
        return session;
    }

    public void closeSession(){
        session.close();
    }

    public void closeTransactionSession(){
        transaction.commit();
        closeSession();
    }

}
