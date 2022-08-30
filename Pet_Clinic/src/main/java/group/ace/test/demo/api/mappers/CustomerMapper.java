package group.ace.test.demo.api.mappers;

import group.ace.test.demo.api.models.CustomerDTO;
import group.ace.test.demo.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mappings({
            @Mapping(target = "email", source = "contact.email"),
            @Mapping(target = "telephone", source = "contact.telephone"),
            @Mapping(target = "address", source = "contact.address"),
            @Mapping(target = "secondaryEmail", source = "contact.secondaryEmail")
    })
        CustomerDTO customerToCustomerDTO(Customer customer);

//    @Mappings({
//            @Mapping(target = "contact.email", source = "email"),
//            @Mapping(target = "contact.telephone", source = "telephone"),
//            @Mapping(target = "contact.address", source = "address"),
//            @Mapping(target = "contact.secondaryEmail", source = "secondaryEmail")
//    })
//    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
