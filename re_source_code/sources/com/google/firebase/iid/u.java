package com.google.firebase.iid;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
class u {
    final SharedPreferences a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Context f19657b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, Long> f19658c = new c.e.a();

    /* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    static class a {
        private static final long a = TimeUnit.DAYS.toMillis(7);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final String f19659b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final String f19660c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final long f19661d;

        private a(String str, String str2, long j2) {
            this.f19659b = str;
            this.f19660c = str2;
            this.f19661d = j2;
        }

        static String a(String str, String str2, long j2) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("token", str);
                jSONObject.put("appVersion", str2);
                jSONObject.put("timestamp", j2);
                return jSONObject.toString();
            } catch (JSONException e2) {
                String strValueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
                sb.append("Failed to encode token: ");
                sb.append(strValueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                return null;
            }
        }

        static String b(a aVar) {
            if (aVar == null) {
                return null;
            }
            return aVar.f19659b;
        }

        static a d(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (!str.startsWith("{")) {
                return new a(str, null, 0L);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                return new a(jSONObject.getString("token"), jSONObject.getString("appVersion"), jSONObject.getLong("timestamp"));
            } catch (JSONException e2) {
                String strValueOf = String.valueOf(e2);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 23);
                sb.append("Failed to parse token: ");
                sb.append(strValueOf);
                Log.w("FirebaseInstanceId", sb.toString());
                return null;
            }
        }

        boolean c(String str) {
            return System.currentTimeMillis() > this.f19661d + a || !str.equals(this.f19660c);
        }
    }

    public u(Context context) {
        this.f19657b = context;
        this.a = context.getSharedPreferences("com.google.android.gms.appid", 0);
        a("com.google.android.gms.appid-no-backup");
    }

    private void a(String str) {
        File file = new File(androidx.core.content.a.i(this.f19657b), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (!file.createNewFile() || g()) {
                return;
            }
            Log.i("FirebaseInstanceId", "App restored, clearing state");
            d();
        } catch (IOException e2) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String strValueOf = String.valueOf(e2.getMessage());
                Log.d("FirebaseInstanceId", strValueOf.length() != 0 ? "Error creating file in no backup dir: ".concat(strValueOf) : new String("Error creating file in no backup dir: "));
            }
        }
    }

    static String b(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 6);
        sb.append(str);
        sb.append("|S|cre");
        return sb.toString();
    }

    private String c(String str, String str2, String str3) {
        int length = String.valueOf(str).length();
        StringBuilder sb = new StringBuilder(length + 4 + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append(str);
        sb.append("|T|");
        sb.append(str2);
        sb.append("|");
        sb.append(str3);
        return sb.toString();
    }

    private long e(String str) {
        String string = this.a.getString(b(str, "cre"), null);
        if (string == null) {
            return 0L;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            return 0L;
        }
    }

    private long j(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.a.contains(b(str, "cre"))) {
            return e(str);
        }
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.putString(b(str, "cre"), String.valueOf(jCurrentTimeMillis));
        editorEdit.commit();
        return jCurrentTimeMillis;
    }

    public synchronized void d() {
        this.f19658c.clear();
        this.a.edit().clear().commit();
    }

    public synchronized a f(String str, String str2, String str3) {
        return a.d(this.a.getString(c(str, str2, str3), null));
    }

    public synchronized boolean g() {
        return this.a.getAll().isEmpty();
    }

    public synchronized void h(String str, String str2, String str3, String str4, String str5) {
        String strA = a.a(str4, str5, System.currentTimeMillis());
        if (strA == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = this.a.edit();
        editorEdit.putString(c(str, str2, str3), strA);
        editorEdit.commit();
    }

    public synchronized long i(String str) {
        long j2;
        j2 = j(str);
        this.f19658c.put(str, Long.valueOf(j2));
        return j2;
    }
}
