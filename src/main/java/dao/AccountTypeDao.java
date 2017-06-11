package dao;

import POJO.AccountType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Miłosz on 09.06.2017.
 */
public interface AccountTypeDao extends CrudRepository<AccountType, Integer> {

    AccountType findOne(Integer primaryKey);
    List<AccountType> findAll();
    AccountType save(AccountType accountType);
    AccountType findByAccountTypeNameIgnoreCase(String accountTypeName);
    boolean exists(Integer primaryKey);
    void delete(AccountType entity);

}
