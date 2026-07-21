package com.google.firebase.crashlytics.internal.n;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.installations.i;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: IdManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class i0 implements j0 {
    private static final Pattern a = Pattern.compile("[^\\p{Alnum}]");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f19046b = Pattern.quote("/");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final k0 f19047c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f19048d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f19049e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f19050f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final e0 f19051g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private j0.a f19052h;

    public i0(Context context, String str, i iVar, e0 e0Var) {
        if (context == null) {
            throw new IllegalArgumentException("appContext must not be null");
        }
        if (str == null) {
            throw new IllegalArgumentException("appIdentifier must not be null");
        }
        this.f19048d = context;
        this.f19049e = str;
        this.f19050f = iVar;
        this.f19051g = e0Var;
        this.f19047c = new k0();
    }

    private synchronized String b(String str, SharedPreferences sharedPreferences) {
        String strE;
        strE = e(UUID.randomUUID().toString());
        h.f().i("Created new Crashlytics installation ID: " + strE + " for FID: " + str);
        sharedPreferences.edit().putString("crashlytics.installation.id", strE).putString("firebase.installation.id", str).apply();
        return strE;
    }

    static String c() {
        return "SYN_" + UUID.randomUUID().toString();
    }

    private static String e(String str) {
        if (str == null) {
            return null;
        }
        return a.matcher(str).replaceAll(HttpUrl.FRAGMENT_ENCODE_SET).toLowerCase(Locale.US);
    }

    static boolean k(String str) {
        return str != null && str.startsWith("SYN_");
    }

    private String l(SharedPreferences sharedPreferences) {
        return sharedPreferences.getString("crashlytics.installation.id", null);
    }

    private String m(String str) {
        return str.replaceAll(f19046b, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    private boolean n() {
        j0.a aVar = this.f19052h;
        return aVar == null || (aVar.d() == null && this.f19051g.d());
    }

    @Override // com.google.firebase.crashlytics.internal.n.j0
    public synchronized j0.a a() {
        if (!n()) {
            return this.f19052h;
        }
        h.f().i("Determining Crashlytics installation ID...");
        SharedPreferences sharedPreferencesQ = t.q(this.f19048d);
        String string = sharedPreferencesQ.getString("firebase.installation.id", null);
        h.f().i("Cached Firebase Installation ID: " + string);
        if (this.f19051g.d()) {
            String strD = d();
            h.f().i("Fetched Firebase Installation ID: " + strD);
            if (strD == null) {
                strD = string == null ? c() : string;
            }
            if (strD.equals(string)) {
                this.f19052h = j0.a.a(l(sharedPreferencesQ), strD);
            } else {
                this.f19052h = j0.a.a(b(strD, sharedPreferencesQ), strD);
            }
        } else if (k(string)) {
            this.f19052h = j0.a.b(l(sharedPreferencesQ));
        } else {
            this.f19052h = j0.a.b(b(c(), sharedPreferencesQ));
        }
        h.f().i("Install IDs: " + this.f19052h);
        return this.f19052h;
    }

    public String d() {
        try {
            return (String) q0.a(this.f19050f.getId());
        } catch (Exception e2) {
            h.f().l("Failed to retrieve Firebase Installation ID.", e2);
            return null;
        }
    }

    public String f() {
        return this.f19049e;
    }

    public String g() {
        return this.f19047c.a(this.f19048d);
    }

    public String h() {
        return String.format(Locale.US, "%s/%s", m(Build.MANUFACTURER), m(Build.MODEL));
    }

    public String i() {
        return m(Build.VERSION.INCREMENTAL);
    }

    public String j() {
        return m(Build.VERSION.RELEASE);
    }
}
