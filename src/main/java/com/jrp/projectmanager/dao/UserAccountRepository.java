package com.jrp.projectmanager.dao;

import com.jrp.projectmanager.entity.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

}
