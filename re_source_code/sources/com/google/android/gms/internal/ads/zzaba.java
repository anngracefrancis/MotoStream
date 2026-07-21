package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public final class zzaba {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Date f13747g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f13748h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Location f13750j;
    private String l;
    private String m;
    private boolean o;
    private String q;
    private final HashSet<String> a = new HashSet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Bundle f13742b = new Bundle();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> f13743c = new HashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HashSet<String> f13744d = new HashSet<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Bundle f13745e = new Bundle();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final HashSet<String> f13746f = new HashSet<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f13749i = -1;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f13751k = false;
    private int n = -1;
    private int p = -1;

    public final void I(boolean z) {
        this.n = z ? 1 : 0;
    }

    @Deprecated
    public final void J(boolean z) {
        this.o = z;
    }

    public final void a(boolean z) {
        this.f13751k = z;
    }

    public final void c(Location location) {
        this.f13750j = location;
    }

    @Deprecated
    public final void d(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            e(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.f13743c.put((Class<? extends NetworkExtras>) networkExtras.getClass(), networkExtras);
        }
    }

    public final void e(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.f13742b.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void f(Date date) {
        this.f13747g = date;
    }

    public final void h(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.f13742b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.f13742b.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.f13742b.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void i(String str) {
        this.a.add(str);
    }

    public final void j(String str) {
        this.f13744d.add(str);
    }

    public final void k(String str) {
        this.f13744d.remove(str);
    }

    public final void l(String str) {
        this.f13748h = str;
    }

    public final void n(String str) {
        this.l = str;
    }

    public final void o(String str) {
        this.m = str;
    }

    public final void p(String str) {
        this.f13746f.add(str);
    }

    public final void q(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.q = str;
        }
    }

    @Deprecated
    public final void r(int i2) {
        this.f13749i = i2;
    }

    public final void s(int i2) {
        if (i2 == -1 || i2 == 0 || i2 == 1) {
            this.p = i2;
        }
    }

    public final void v(String str, String str2) {
        this.f13745e.putString(str, str2);
    }
}
