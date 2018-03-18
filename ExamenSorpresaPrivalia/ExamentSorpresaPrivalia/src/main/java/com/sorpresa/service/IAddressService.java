package com.sorpresa.service;

import java.util.List;

import com.sorpresa.entity.Address;

public interface IAddressService {
     List<Address> getAllAddresses();
     Address getAddressById(long id);
     boolean addAddress(Address student);
     void updateAddress(Address student);
     void deleteAddress(long id);
}
