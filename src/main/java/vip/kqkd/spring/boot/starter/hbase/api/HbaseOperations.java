package vip.kqkd.spring.boot.starter.hbase.api;

import org.apache.hadoop.hbase.client.Mutation;
import org.apache.hadoop.hbase.client.Row;
import org.apache.hadoop.hbase.client.Scan;

import java.util.List;

/**
 * Interface that specifies a basic set of Hbase operations, implemented by {@link vip.kqkd.spring.boot.starter.hbase.api.HBaseTemplate}. Not often used,
 * but a useful option to enhance testability, as it can easily be mocked or stubbed.
 *
 * @author lichen
 */

/**
 *
 * @author lichen
 * @version 1.0.0
 * desc: copy from spring data hadoop hbase, modified by JThink, remove the unuse interface
 * date: 2020-03-08 19:26
 */
public interface HbaseOperations {

    /**
     * Executes the given action against the specified table handling resource management.
     * <p>
     * Application exceptions thrown by the action object get propagated to the caller (can only be unchecked).
     * Allows for returning a result object (typically a domain object or collection of domain objects).
     *
     * @param tableName the target table
     * @param <T> action type
     * @return the result object of the callback action, or null
     */
    <T> T execute(String tableName, TableCallback<T> mapper);

    /**
     * Scans the target table, using the given column family.
     * The content is processed row by row by the given action, returning a list of domain objects.
     *
     * @param tableName target table
     * @param family column family
     * @param <T> action type
     * @return a list of objects mapping the scanned rows
     */
    <T> List<T> find(String tableName, String family, final Class<? extends RowMapper<T>> mapperCls);

    /**
     * Scans the target table, using the given column family.
     * The content is processed row by row by the given action, returning a list of domain objects.
     *
     * @param tableName target table
     * @param family column family
     * @param qualifier column qualifier
     * @param <T> action type
     * @return a list of objects mapping the scanned rows
     */
    <T> List<T> find(String tableName, String family, String qualifier, final Class<? extends RowMapper<T>> mapperCls);

    /**
     * Scans the target table using the given {@link Scan} object. Suitable for maximum control over the scanning
     * process.
     * The content is processed row by row by the given action, returning a list of domain objects.
     *
     * @param tableName target table
     * @param scan table scanner
     * @param <T> action type
     * @return a list of objects mapping the scanned rows
     */
    <T> List<T> find(String tableName, final Scan scan, final Class<? extends RowMapper<T>> mapperCls);

    /**
     * Gets an individual row from the given table. The content is mapped by the given action.
     *
     * @param tableName target table
     * @param rowName row name
     * @param mapperCls row mapper
     * @param <T> mapper type
     * @return object mapping the target row
     */
    <T> T get(String tableName, String rowName, final Class<? extends RowMapper<T>> mapperCls);

    /**
     * Gets an individual row from the given table. The content is mapped by the given action.
     *
     * @param tableName target table
     * @param rowName row name
     * @param familyName column family
     * @param mapperCls row mapper
     * @param <T> mapper type
     * @return object mapping the target row
     */
    <T> T get(String tableName, String rowName, String familyName, final Class<? extends RowMapper<T>> mapperCls);

    /**
     * Gets an individual row from the given table. The content is mapped by the given action.
     *
     * @param tableName target table
     * @param rowName row name
     * @param familyName family
     * @param qualifier column qualifier
     * @param mapperCls row mapper
     * @param <T> mapper type
     * @return object mapping the target row
     */
    <T> T get(String tableName, final String rowName, final String familyName, final String qualifier, final Class<? extends RowMapper<T>> mapperCls);

    /**
     * 执行put update or delete
     * @param tableName
     * @param action
     */
    void execute(String tableName, MutatorCallback action);

    /**
     *
     * @param tableName
     * @param mutation
     */
    void putOrDelete(String tableName, Mutation mutation);

    /**
     *
     * @param tableName
     * @param mutations
     */
    void putOrDeletes(String tableName, List<Mutation> mutations);

    /**
     *  batch operate
     * @param tableName
     * @param actions
     * @param results
     */
    Object[] batch(String tableName, List<Row> actions, Object[] results);

}