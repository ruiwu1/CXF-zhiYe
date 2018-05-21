package com.CXF.mapper;

import com.CXF.model.postgreUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestPostgresqlMapper {

    List<String> selectCountTest();

    void updatePassWd( postgreUser postgreUser);
}
