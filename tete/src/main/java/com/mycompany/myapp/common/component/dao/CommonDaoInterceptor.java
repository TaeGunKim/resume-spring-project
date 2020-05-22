package com.mycompany.myapp.common.component.dao;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Intercepts({
    @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})
})
public class CommonDaoInterceptor implements Interceptor {

    private static final Logger LOG = LoggerFactory.getLogger(CommonDaoInterceptor.class);

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Map<String, String> params = (Map<String, String>) args[1];

        BoundSql boundSql = ms.getBoundSql(params);
        StringBuilder sql = new StringBuilder(boundSql.getSql());

        for (ParameterMapping param : boundSql.getParameterMappings()) {
            String property = param.getProperty();
            int index = sql.indexOf("?");
            sql.replace(index, index + 1, "'" + params.get(property) + "'");
        }

        Object proceed = invocation.proceed();

        LOG.info("{} ==>  Preparing: {}", ms.getId(), sql.toString());
        if (proceed != null && proceed instanceof List) {
            List<Map<String, String>> list = (List<Map<String, String>>) proceed;
            if (list.size() > 0) {
                LOG.info("{} ==>     Result: {}", ms.getId(), list.get(0));

                /*for (Entry<String, String> entry : list.get(0).entrySet()) {
                    String key = entry.getKey();
                    String value = ((Object) entry.getValue()).toString();
                }*/
            }

            LOG.info("{} <==      Total: {}", ms.getId(), list.size());
        }

        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        LOG.info("properties => {}", properties);
    }
}
