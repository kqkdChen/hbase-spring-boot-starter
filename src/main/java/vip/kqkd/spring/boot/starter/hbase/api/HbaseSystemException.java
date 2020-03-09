package vip.kqkd.spring.boot.starter.hbase.api;

import org.springframework.dao.UncategorizedDataAccessException;

/**
 * HBase Data Access exception.
 *
 * @author lichen
 * @version 1.0.0
 * desc： copy from spring data hadoop hbase, modified by lichen
 * date： 2020-03-09 19:26
 */
public class HbaseSystemException extends UncategorizedDataAccessException {

    public HbaseSystemException(Exception cause) {
        super(cause.getMessage(), cause);
    }

    public HbaseSystemException(Throwable throwable) {
        super(throwable.getMessage(), throwable);
    }
}
