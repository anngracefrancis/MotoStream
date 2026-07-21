package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzag {
    private static Set<String> a(SQLiteDatabase sQLiteDatabase, String str) {
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
        sb.append("SELECT * FROM ");
        sb.append(str);
        sb.append(" LIMIT 0");
        Cursor cursorRawQuery = sQLiteDatabase.rawQuery(sb.toString(), null);
        try {
            Collections.addAll(hashSet, cursorRawQuery.getColumnNames());
            return hashSet;
        } finally {
            cursorRawQuery.close();
        }
    }

    static void b(zzet zzetVar, SQLiteDatabase sQLiteDatabase) {
        if (zzetVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        File file = new File(sQLiteDatabase.getPath());
        if (!file.setReadable(false, false)) {
            zzetVar.K().a("Failed to turn off database read permission");
        }
        if (!file.setWritable(false, false)) {
            zzetVar.K().a("Failed to turn off database write permission");
        }
        if (!file.setReadable(true, true)) {
            zzetVar.K().a("Failed to turn on database read permission for owner");
        }
        if (file.setWritable(true, true)) {
            return;
        }
        zzetVar.K().a("Failed to turn on database write permission for owner");
    }

    static void c(zzet zzetVar, SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, String[] strArr) throws SQLiteException {
        if (zzetVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        if (!d(zzetVar, sQLiteDatabase, str)) {
            sQLiteDatabase.execSQL(str2);
        }
        try {
            Set<String> setA = a(sQLiteDatabase, str);
            for (String str4 : str3.split(",")) {
                if (!setA.remove(str4)) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str4).length());
                    sb.append("Table ");
                    sb.append(str);
                    sb.append(" is missing required column: ");
                    sb.append(str4);
                    throw new SQLiteException(sb.toString());
                }
            }
            if (strArr != null) {
                for (int i2 = 0; i2 < strArr.length; i2 += 2) {
                    if (!setA.remove(strArr[i2])) {
                        sQLiteDatabase.execSQL(strArr[i2 + 1]);
                    }
                }
            }
            if (setA.isEmpty()) {
                return;
            }
            zzetVar.K().c("Table has extra columns. table, columns", str, TextUtils.join(", ", setA));
        } catch (SQLiteException e2) {
            zzetVar.H().b("Failed to verify columns on table that was just created", str);
            throw e2;
        }
    }

    private static boolean d(zzet zzetVar, SQLiteDatabase sQLiteDatabase, String str) {
        if (zzetVar == null) {
            throw new IllegalArgumentException("Monitor must not be null");
        }
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("SQLITE_MASTER", new String[]{"name"}, "name=?", new String[]{str}, null, null, null);
                boolean zMoveToFirst = cursorQuery.moveToFirst();
                cursorQuery.close();
                return zMoveToFirst;
            } catch (SQLiteException e2) {
                zzetVar.K().c("Error querying for table", str, e2);
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return false;
            }
        } catch (Throwable th) {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            throw th;
        }
    }
}
