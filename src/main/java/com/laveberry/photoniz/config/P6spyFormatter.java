package com.laveberry.photoniz.config;

import com.p6spy.engine.logging.Category;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.hibernate.engine.jdbc.internal.FormatStyle;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class P6spyFormatter implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        sql = formatSql(category, sql);

        SimpleDateFormat format = new SimpleDateFormat("yy.MM.dd HH:mm:ss");
        return format.format(new Date()) + " | " + " OperationTime : " + elapsed + "ms" + sql;
    }

    private String formatSql(String category, String sql) {
        if (sql == null || sql.trim().equals("")) {
            return sql;
        }

        if (Category.STATEMENT.getName().equals(category)) {
            sql = formattedSql(sql);
        }

        return sql;
    }

    private String formattedSql(String sql) {
        return sqlStartCheck(sql.trim().toLowerCase(Locale.ROOT))
                ? FormatStyle.DDL.getFormatter().format(sql)
                : FormatStyle.BASIC.getFormatter().format(sql);
    }

    private boolean sqlStartCheck(String sql) {
        return sql.startsWith("create") || sql.startsWith("alter") || sql.startsWith("comment");
    }
}
