package vip.kqkd.spring.boot.starter.hbase.boot;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * HBase Properties
 *
 * @author lichen
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "spring.data.hbase")
public class HBaseProperties {

    private String quorum;

    private String keyValueSize;

    private boolean enableAlihbase = false;

    private String endpoint;

    private String username;

    private String password;

    public boolean getEnableAlihbase() {
        return enableAlihbase;
    }

    public void setEnableAlihbase(boolean enableAlihbase) {
        this.enableAlihbase = enableAlihbase;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKeyValueSize() {
        return keyValueSize;
    }

    public void setKeyValueSize(String keyValueSize) {
        this.keyValueSize = keyValueSize;
    }

    public String getQuorum() {
        return quorum;
    }

    public void setQuorum(String quorum) {
        this.quorum = quorum;
    }

}
