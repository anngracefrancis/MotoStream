package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbw {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static HashMap<String, String> f17328f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static Object f17333k;
    private static boolean l;
    public static final Uri a = Uri.parse("content://com.google.android.gsf.gservices");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f17324b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f17325c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Pattern f17326d = Pattern.compile("^(0|false|f|off|no|n)$", 2);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final AtomicBoolean f17327e = new AtomicBoolean();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final HashMap<String, Boolean> f17329g = new HashMap<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final HashMap<String, Integer> f17330h = new HashMap<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final HashMap<String, Long> f17331i = new HashMap<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final HashMap<String, Float> f17332j = new HashMap<>();
    private static String[] m = new String[0];

    public static String a(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzbw.class) {
            d(contentResolver);
            Object obj = f17333k;
            if (f17328f.containsKey(str)) {
                String str3 = f17328f.get(str);
                return str3 != null ? str3 : null;
            }
            for (String str4 : m) {
                if (str.startsWith(str4)) {
                    if (!l || f17328f.isEmpty()) {
                        f17328f.putAll(b(contentResolver, m));
                        l = true;
                        if (f17328f.containsKey(str)) {
                            String str5 = f17328f.get(str);
                            return str5 != null ? str5 : null;
                        }
                    }
                    return null;
                }
            }
            Cursor cursorQuery = contentResolver.query(a, null, null, new String[]{str}, null);
            if (cursorQuery == null) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            }
            try {
                if (!cursorQuery.moveToFirst()) {
                    e(obj, str, null);
                    return null;
                }
                String string = cursorQuery.getString(1);
                if (string != null && string.equals(null)) {
                    string = null;
                }
                e(obj, str, string);
                return string != null ? string : null;
            } finally {
                cursorQuery.close();
            }
        }
    }

    private static Map<String, String> b(ContentResolver contentResolver, String... strArr) {
        Cursor cursorQuery = contentResolver.query(f17324b, null, null, strArr, null);
        TreeMap treeMap = new TreeMap();
        if (cursorQuery == null) {
            return treeMap;
        }
        while (cursorQuery.moveToNext()) {
            try {
                treeMap.put(cursorQuery.getString(0), cursorQuery.getString(1));
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
        }
        cursorQuery.close();
        return treeMap;
    }

    private static void d(ContentResolver contentResolver) {
        if (f17328f == null) {
            f17327e.set(false);
            f17328f = new HashMap<>();
            f17333k = new Object();
            l = false;
            contentResolver.registerContentObserver(a, true, new j0(null));
            return;
        }
        if (f17327e.getAndSet(false)) {
            f17328f.clear();
            f17329g.clear();
            f17330h.clear();
            f17331i.clear();
            f17332j.clear();
            f17333k = new Object();
            l = false;
        }
    }

    private static void e(Object obj, String str, String str2) {
        synchronized (zzbw.class) {
            if (obj == f17333k) {
                f17328f.put(str, str2);
            }
        }
    }
}
