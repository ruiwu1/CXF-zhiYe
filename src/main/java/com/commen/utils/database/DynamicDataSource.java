package com.commen.utils.database;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author ruiwu
 * @version V1.0
 * @Description: 动态分配数据
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return CustomerContextHolder.getCustomerType();
    }

}
