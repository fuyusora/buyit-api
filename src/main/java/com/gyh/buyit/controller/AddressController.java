package com.gyh.buyit.controller;

import com.gyh.buyit.entity.Address;
import com.gyh.buyit.entity.ListInfo;
import com.gyh.buyit.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressMapper addressMapper;

    @RequestMapping("/findAllAddress")
    public List<Address> findAllAddress(){
        return addressMapper.findAllAddress();
    }

    @RequestMapping("/findAllAddressByPage")
    List<Address> findAllAddressByPage(@RequestBody ListInfo listInfo){
        return addressMapper.findAllAddressByPage(listInfo);
    }

    @RequestMapping("/findAddressByUserId/{userId}")
    List<Address> findAddressByUserId(@PathVariable("userId") int userId){
        return addressMapper.findAddressByUserId(userId);
    }

    @RequestMapping("/addAddress")
    int addAddress(@RequestBody Address address){
        return addressMapper.addAddress(address);
    }

    @RequestMapping("/deleteAddressByAddressId/{addressId}")
    int deleteAddressByAddressId(@PathVariable("addressId") int addressId){
        return addressMapper.deleteAddressByAddressId(addressId);
    }

    @RequestMapping("/updateAddress")
    int updateAddress(@RequestBody Address address){
        return addressMapper.updateAddress(address);
    }

    @RequestMapping("/addressCount")
    int addressCount(){
        return addressMapper.addressCount();
    }

}
