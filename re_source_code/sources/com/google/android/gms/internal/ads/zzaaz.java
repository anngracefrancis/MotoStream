package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzaaz {
    private final Date a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13733c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Set<String> f13734d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Location f13735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f13736f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Bundle f13737g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> f13738h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f13739i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f13740j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final SearchAdRequest f13741k;
    private final int l;
    private final Set<String> m;
    private final Bundle n;
    private final Set<String> o;
    private final boolean p;
    private final zzdak q;
    private final int r;
    private final String s;

    public zzaaz(zzaba zzabaVar) {
        this(zzabaVar, null);
    }

    @Deprecated
    public final Date a() {
        return this.a;
    }

    public final String b() {
        return this.f13732b;
    }

    public final Bundle c(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.f13737g.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle d() {
        return this.n;
    }

    @Deprecated
    public final int e() {
        return this.f13733c;
    }

    public final Set<String> f() {
        return this.f13734d;
    }

    public final Location g() {
        return this.f13735e;
    }

    public final boolean h() {
        return this.f13736f;
    }

    public final String i() {
        return this.s;
    }

    @Deprecated
    public final <T extends NetworkExtras> T j(Class<T> cls) {
        return (T) this.f13738h.get(cls);
    }

    public final Bundle k(Class<? extends MediationExtrasReceiver> cls) {
        return this.f13737g.getBundle(cls.getName());
    }

    public final String l() {
        return this.f13739i;
    }

    @Deprecated
    public final boolean m() {
        return this.p;
    }

    public final boolean n(Context context) {
        Set<String> set = this.m;
        zzyt.a();
        return set.contains(zzazt.l(context));
    }

    public final String o() {
        return this.f13740j;
    }

    public final SearchAdRequest p() {
        return this.f13741k;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> q() {
        return this.f13738h;
    }

    public final Bundle r() {
        return this.f13737g;
    }

    public final int s() {
        return this.l;
    }

    public final Set<String> t() {
        return this.o;
    }

    public final int u() {
        return this.r;
    }

    public zzaaz(zzaba zzabaVar, SearchAdRequest searchAdRequest) {
        this.a = zzabaVar.f13747g;
        this.f13732b = zzabaVar.f13748h;
        this.f13733c = zzabaVar.f13749i;
        this.f13734d = Collections.unmodifiableSet(zzabaVar.a);
        this.f13735e = zzabaVar.f13750j;
        this.f13736f = zzabaVar.f13751k;
        this.f13737g = zzabaVar.f13742b;
        this.f13738h = Collections.unmodifiableMap(zzabaVar.f13743c);
        this.f13739i = zzabaVar.l;
        this.f13740j = zzabaVar.m;
        this.f13741k = searchAdRequest;
        this.l = zzabaVar.n;
        this.m = Collections.unmodifiableSet(zzabaVar.f13744d);
        this.n = zzabaVar.f13745e;
        this.o = Collections.unmodifiableSet(zzabaVar.f13746f);
        this.p = zzabaVar.o;
        this.q = null;
        this.r = zzabaVar.p;
        this.s = zzabaVar.q;
    }
}
