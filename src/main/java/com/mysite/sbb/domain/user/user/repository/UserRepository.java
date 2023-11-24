package com.mysite.sbb.domain.user.user.repository;

import com.mysite.sbb.domain.user.user.entitiy.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long> {

}
