package vip.kqkd.spring.boot.starter.hbase.boot;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
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
 * date 2020-03-08 19:26
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
        conf.set("hbase.zookeeper.quorum", hbaseProperties.getQuorum());
        conf.set("hbase.client.keyvalue.maxsize", hbaseProperties.getKeyValueSize());
        // 是否连接Alihbase
        if (hbaseProperties.getEnableAlihbase()) {
            conf.set("hbase.client.username", hbaseProperties.getUsername());
            conf.set("hbase.client.password", hbaseProperties.getPassword());
        }
        return new HBaseTemplate(conf);
    }
}
