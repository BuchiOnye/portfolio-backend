package com.career.setup.portfolio.repository;

import com.career.setup.portfolio.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {

    @Query(
            value = "select rl.name from role rl inner join user_role_mapper urm on urm.role = rl.id  where  urm.user_fk = :user_id",
            nativeQuery = true)
    Set<String> getUserRoles(@Param("user_id") Long userId);

}
