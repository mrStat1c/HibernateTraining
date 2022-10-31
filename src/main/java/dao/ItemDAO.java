package dao;

import entity.Item;

import java.util.List;

public interface ItemDAO {

    void addAll(List<Item> orders);
    void remove(Item item);
}
