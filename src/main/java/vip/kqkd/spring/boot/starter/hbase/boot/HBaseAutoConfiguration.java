package vip.kqkd.spring.boot.starter.hbase.boot;

import com.alibaba.hbase.client.AliHBaseUEConnection;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import vip.kqkd.spring.boot.starter.hbase.api.HBaseTemplate;

/**
 * hbase auto configuration
 *
 * @author lichen
 * @version 0.0.1
 * @create 2020-03-08 19:26
 */
@EnableConfigurationProperties(HBaseProperties.class)
@ConditionalOnClass(HBaseTemplate.class)
@org.springframework.context.annotation.Configuration
public class HBaseAutoConfiguration {

    @Autowired
    private HBaseProperties hbaseProperties;

    @Bean
    public HBaseTemplate hbaseTemplate() {
        Configuration conf = HBaseConfiguration.create();
        // 是否连接Alihbase
        if (hbaseProperties.getEnableAlihbase()) {
            conf.set("hbase.client.connection.impl", AliHBaseUEConnection.class.getName());
            conf.set("hbase.client.endpoint", hbaseProperties.getEndpoint());
            conf.set("hbase.client.username", hbaseProperties.getUsername());
            conf.set("hbase.client.password", hbaseProperties.getPassword());
        } else {
            conf.set("hbase.zookeeper.quorum", hbaseProperties.getQuorum());
            conf.set("hbase.client.keyvalue.maxsize", hbaseProperties.getKeyValueSize());
        }
        return new HBaseTemplate(conf);
    }
}
