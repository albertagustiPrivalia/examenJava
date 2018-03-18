package com.sorpresa.repository;

import org.springframework.data.repository.CrudRepository;
import com.sorpresa.entity.Address;


public interface AddressRepository extends CrudRepository<Address, Long>  {

}
