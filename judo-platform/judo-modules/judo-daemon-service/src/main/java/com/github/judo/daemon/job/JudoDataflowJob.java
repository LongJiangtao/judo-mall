package com.github.judo.daemon.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.dataflow.DataflowJob;
import com.zen.elasticjob.spring.boot.annotation.ElasticJobConfig;

import java.util.List;

/**
 * @Auther: xiangjunzhong@qq.com
 * @Description: 类描述
 * @Version: 1.0
 */
@ElasticJobConfig(cron = "0 0 0/1 * * ? ", shardingTotalCount = 3, shardingItemParameters = "0=Beijing,1=Shanghai,2=Guangzhou")
public class JudoDataflowJob implements DataflowJob<Integer> {

    @Override
    public List<Integer> fetchData(ShardingContext shardingContext) {
        return null;
    }

    @Override
    public void processData(ShardingContext shardingContext, List<Integer> list) {

    }
}

