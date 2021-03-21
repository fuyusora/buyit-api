package com.gyh.buyit.mapper;

import com.gyh.buyit.entity.Address;
import com.gyh.buyit.entity.ListInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Repository
@Mapper
public interface AddressMapper {
    List<Address> findAllAddress();
    List<Address> findAllAddressByPage(ListInfo listInfo);
    List<Address> findAddressByUserId(int userId);
    int addAddress(Address address);
    int deleteAddressByAddressId(int addressId);
    int updateAddress(Address address);
    int addressCount();
}
