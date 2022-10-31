package service;

import businessLogic.SessionUtil;
import dao.ItemDAO;
import entity.Item;
import org.hibernate.Session;

import java.util.List;

public class ItemService extends SessionUtil implements ItemDAO {

    @Override
    public void addAll(List<Item> orders) {
        openTransactionSession();
        Session session = getSession();
        orders.forEach(session::save);
        closeTransactionSession();
    }

    @Override
    public void remove(Item item) {
        openTransactionSession();
        Session session = getSession();
        session.remove(item);
        closeTransactionSession();
    }
}
