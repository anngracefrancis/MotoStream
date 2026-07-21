package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.ConditionVariable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzacr implements SharedPreferences.OnSharedPreferenceChangeListener {
    private Context l;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Object f13792f = new Object();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ConditionVariable f13793g = new ConditionVariable();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile boolean f13794h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    private volatile boolean f13795i = false;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private SharedPreferences f13796j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Bundle f13797k = new Bundle();
    private JSONObject m = new JSONObject();

    private final void d() {
        if (this.f13796j == null) {
            return;
        }
        try {
            this.m = new JSONObject((String) zzazl.a(this.l, new Callable(this) { // from class: com.google.android.gms.internal.ads.q

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzacr f13198f;

                {
                    this.f13198f = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.f13198f.e();
                }
            }));
        } catch (JSONException unused) {
        }
    }

    public final void a(Context context) {
        if (this.f13794h) {
            return;
        }
        synchronized (this.f13792f) {
            if (this.f13794h) {
                return;
            }
            if (!this.f13795i) {
                this.f13795i = true;
            }
            Context applicationContext = context.getApplicationContext() == null ? context : context.getApplicationContext();
            this.l = applicationContext;
            try {
                this.f13797k = Wrappers.a(applicationContext).c(this.l.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException | NullPointerException unused) {
            }
            try {
                Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
                if (remoteContext == null) {
                    Context applicationContext2 = context.getApplicationContext();
                    if (applicationContext2 != null) {
                        context = applicationContext2;
                    }
                    remoteContext = context;
                }
                if (remoteContext == null) {
                    this.f13795i = false;
                    this.f13793g.open();
                    return;
                }
                zzyt.c();
                SharedPreferences sharedPreferences = remoteContext.getSharedPreferences("google_ads_flags", 0);
                this.f13796j = sharedPreferences;
                if (sharedPreferences != null) {
                    sharedPreferences.registerOnSharedPreferenceChangeListener(this);
                }
                d();
                this.f13794h = true;
                this.f13795i = false;
                this.f13793g.open();
            } catch (Throwable th) {
                this.f13795i = false;
                this.f13793g.open();
                throw th;
            }
        }
    }

    public final <T> T c(zzacj<T> zzacjVar) {
        if (!this.f13793g.block(5000L)) {
            synchronized (this.f13792f) {
                if (!this.f13795i) {
                    throw new IllegalStateException("Flags.initialize() was not called!");
                }
            }
        }
        if (!this.f13794h || this.f13796j == null) {
            synchronized (this.f13792f) {
                if (this.f13794h && this.f13796j != null) {
                }
                return zzacjVar.n();
            }
        }
        if (zzacjVar.b() != 2) {
            return (zzacjVar.b() == 1 && this.m.has(zzacjVar.a())) ? zzacjVar.j(this.m) : (T) zzazl.a(this.l, new r(this, zzacjVar));
        }
        Bundle bundle = this.f13797k;
        return bundle == null ? zzacjVar.n() : zzacjVar.i(bundle);
    }

    final /* synthetic */ String e() throws Exception {
        return this.f13796j.getString("flag_configuration", "{}");
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if ("flag_configuration".equals(str)) {
            d();
        }
    }
}
