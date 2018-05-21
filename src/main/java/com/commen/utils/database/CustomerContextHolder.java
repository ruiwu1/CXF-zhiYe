package com.commen.utils.database;

/**
 * @author ruiwu
 * @version V1.0
 * @Description: 利用ThreadLocal解决线程安全问题
 */
public class CustomerContextHolder {
    //用ThreadLocal来设置当前线程使用哪个dataSource
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    public static void setCustomerType(String customerType) {
        contextHolder.set(customerType);
    }
    public static String getCustomerType() {
        return contextHolder.get();
    }

    public static void clearCustomerType() {
        contextHolder.remove();
    }
}
