package com.CXF.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {

    String selectPassWdByLoginID(String loginID);
}
