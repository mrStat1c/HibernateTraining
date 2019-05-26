package dao;

import entity.Address;

import java.util.List;

public interface AddressDAO {

    void add(Address address);
    List<Address> getAll();
    Address getById(long id);
    void update(Address adress);
    void remove(Address address);
}
