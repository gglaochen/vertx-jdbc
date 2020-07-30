package com.example.vertx.vertxjdbc.utils;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.jdbc.JDBCClient;

/**
 * @author ChenHanLin 2020/7/30
 */
public class JdbcUtils {


    private JDBCClient dbClient;

    public JdbcUtils(Vertx vertx) {
        // 构造数据库的连接信息，可以改为从配置文件读
        JsonObject dbConfig = new JsonObject();
        dbConfig.put("url", "jdbc:mysql://localhost:3306/user?serverTimezone=GMT");
        dbConfig.put("driver_class", "com.mysql.jdbc.Driver");
        dbConfig.put("user", "root");
        dbConfig.put("password", "123456");

        // 创建客户端
        dbClient = JDBCClient.createShared(vertx, dbConfig);
    }

    // 提供一个公共方法来获取客户端
    public JDBCClient getDbClient() {
        return dbClient;
    }
}
