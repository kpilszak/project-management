package com.kpilszak.projectmanagement.dao;

import com.kpilszak.projectmanagement.entities.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {
}
