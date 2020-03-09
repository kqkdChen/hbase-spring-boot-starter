package vip.kqkd.spring.boot.starter.hbase.api;

import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;

/**
 * Callback for mapping rows of a {@link ResultScanner} on a per-row basis.
 * Implementations of this interface perform the actual work of mapping each row to a result object, but don't need to worry about exception handling.
 *
 * @author lichen
 * @version 1.0.0
 * desc： copy from spring data hadoop hbase, modified by lichen, use the 1.0.0 api
 * date： 2020-03-09 19:26
 */
public interface RowMapper<T> {

    /**
     * encapsulating the result set
     * @param result data result
     * @param rowNum row num
     * @return custom result set
     * @throws Exception exception
     */
    T mapRow(Result result, int rowNum) throws Exception;
}
