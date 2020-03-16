package vip.kqkd.spring.boot.starter.hbase.api;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.util.Bytes;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * HBase查询数据转Map解析规则
 * @author lichen
 * @version 1.0.0
 * @date 2020-03-17 1:40
 */
public class BaseDataTransfer {

    public Map<String, Object> transfer(Cell cell, String typeName) {
        Map<String, Object> map = new HashMap<>(127);
        String key = Bytes.toString(CellUtil.cloneQualifier(cell));
        byte[] value = CellUtil.cloneValue(cell);
        if (String.class.getName().equals(typeName)) {
            map.put(key, Bytes.toString(value));
        } else if (byte[].class.getCanonicalName().equals(typeName)) {
            map.put(key, value);
        } else if (BigDecimal.class.getName().equals(typeName)) {
            map.put(key, Bytes.toBigDecimal(value));
        } else if (Integer.class.getName().equals(typeName) || int.class.getName().equals(typeName)) {
            map.put(key, Bytes.toInt(value));
        } else if (Double.class.getName().equals(typeName) || double.class.getName().equals(typeName)) {
            map.put(key, Bytes.toInt(value));
        } else if (Float.class.getName().equals(typeName) || float.class.getName().equals(typeName)) {
            map.put(key, Bytes.toFloat(value));
        } else if (Byte.class.getName().equals(typeName) || byte.class.getName().equals(typeName)) {
            map.put(key, Bytes.toLong(value));
        } else if (Short.class.getName().equals(typeName) || short.class.getName().equals(typeName)) {
            map.put(key, Bytes.toLong(value));
        } else if (Boolean.class.getName().equals(typeName) || boolean.class.getName().equals(typeName)) {
            map.put(key, Bytes.toBoolean(value));
        }
        return map;
    }

}
