package com.example.kancollewiki.util;

import android.content.Context;

import com.colintmiller.simplenosql.NoSQL;

/**
 * Created by Administrator on 2015/9/26.
 */
public class NoSQLHelper {
    public static NoSQL noSQL;
    public static void init(Context context) {
        noSQL = NoSQL.with(context);
    }

    public static NoSQL getNoSQL() {
        if (noSQL != null) {
            return noSQL;
        }
        throw new IllegalStateException("NoSQL may not init");

    }
}
