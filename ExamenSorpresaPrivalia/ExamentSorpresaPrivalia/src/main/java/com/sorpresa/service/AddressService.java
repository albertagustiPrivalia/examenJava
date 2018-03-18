package com.sorpresa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sorpresa.entity.Address;
import com.sorpresa.repository.AddressRepository;
@Service
public class AddressService implements IAddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Address getAddressById(long addressId) {
		Optional<Address> obj = this.addressRepository.findById(addressId);
		return obj.get();
	}	
	
	@Override
	public List<Address> getAllAddresses(){
		List<Address> list = new ArrayList<Address>();
		Page<Address> page = (Page<Address>) this.addressRepository.findAll();
		list = page.getContent();
		return list;
	}
	
	@Override
	public boolean addAddress(Address address){

	   Optional<Address> optional = this.addressRepository.findById(address.getId());

       if (optional.empty() != null) {
    			addressRepository.save(address);
    	   		return true;
       } else {
    	   		return false;
       }
	}
	
	@Override
	public void updateAddress(Address address) {
		addressRepository.save(address);
	}
	
	@Override
	public void deleteAddress(long addressId) {
		addressRepository.delete(getAddressById(addressId));
	}
}
