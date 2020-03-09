package vip.kqkd.spring.boot.starter.hbase.api;

import org.apache.hadoop.hbase.client.BufferedMutator;

/**
 *
 * @author lichen
 * @version 1.0.0
 * desc： callback for hbase put delete and update
 * date： 2020-03-08 19:26
 */
public interface MutatorCallback {

    /**
     * 使用 mutator api to update put and delete
     * @param mutator
     * @throws Throwable
     */
    void doInMutator(BufferedMutator mutator) throws Throwable;
}
