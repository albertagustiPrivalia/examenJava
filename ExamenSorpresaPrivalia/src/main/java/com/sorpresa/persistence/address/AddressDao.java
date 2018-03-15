package com.sorpresa.persistence.address;

import java.util.Set;

import com.sorpresa.domain.entities.Address;

public interface AddressDao {

	public void insert(Address addresses);
	public void update(Address address);
	public Set<Address> get(int id);
	public Integer delete(Address address);
}
