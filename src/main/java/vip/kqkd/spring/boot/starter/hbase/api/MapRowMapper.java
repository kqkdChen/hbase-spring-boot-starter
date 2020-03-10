package vip.kqkd.spring.boot.starter.hbase.api;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.HashMap;
import java.util.Map;

/**
 * map实现，可根据思路实现自己的POJO进行转换
 * @author lichen
 * @version 1.0.0
 * date: 2019-10-24 12:46
 */
public class MapRowMapper implements RowMapper<Map<String, Object>> {


    @Override
    public Map<String, Object> mapRow(Result result, int i) {
        if (result == null || result.size() == 0) {
            return null;
        }
        Map<String, Object> map = new HashMap<>(126);
        map.put("rowKey", Bytes.toString(result.getRow()));
        for (Cell cell : result.listCells()) {
            map.put(Bytes.toString(CellUtil.cloneQualifier(cell)), Bytes.toString(CellUtil.cloneValue(cell)));
        }
        return map;
    }

}
