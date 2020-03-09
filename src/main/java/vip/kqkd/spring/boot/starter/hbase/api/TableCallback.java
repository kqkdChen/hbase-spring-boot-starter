package vip.kqkd.spring.boot.starter.hbase.api;

import org.apache.hadoop.hbase.client.Table;

/**
 * Callback interface for Hbase code. To be used with {@link HBaseTemplate}'s execution methods, often as anonymous classes within a method implementation without
 * having to worry about exception handling.
 * @author lichen
 * @version 1.0.0
 * desc： copy from spring data hadoop hbase, modified by lichen, use the 1.0.0 api
 * date： 2020-03-08 19:26
 */
public interface TableCallback<T> {

    /**
     * Gets called by {@link HBaseTemplate} execute with an active Hbase table. Does need to care about activating or closing down the table.
     *
     * @param table active Hbase table
     * @return a result object, or null if none
     * @throws Throwable thrown by the Hbase API
     */
    T doInTable(Table table) throws Throwable;
}