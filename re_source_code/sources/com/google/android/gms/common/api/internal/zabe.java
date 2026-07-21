package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes2.dex */
public final class zabe implements zabs, zar {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Lock f11825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Condition f11826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f11827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final GoogleApiAvailabilityLight f11828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final x f11829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Map<Api.AnyClientKey<?>, Api.Client> f11830k;
    private final ClientSettings m;
    private final Map<Api<?>, Boolean> n;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> o;
    private volatile zabd p;
    int r;
    final zaaw s;
    final zabt t;
    final Map<Api.AnyClientKey<?>, ConnectionResult> l = new HashMap();
    private ConnectionResult q = null;

    public zabe(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList, zabt zabtVar) {
        this.f11827h = context;
        this.f11825f = lock;
        this.f11828i = googleApiAvailabilityLight;
        this.f11830k = map;
        this.m = clientSettings;
        this.n = map2;
        this.o = abstractClientBuilder;
        this.s = zaawVar;
        this.t = zabtVar;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            zaq zaqVar = arrayList.get(i2);
            i2++;
            zaqVar.a(this);
        }
        this.f11829j = new x(this, looper);
        this.f11826g = lock.newCondition();
        this.p = new zaav(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void H(int i2) {
        this.f11825f.lock();
        try {
            this.p.H(i2);
        } finally {
            this.f11825f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
    public final void P(Bundle bundle) {
        this.f11825f.lock();
        try {
            this.p.P(bundle);
        } finally {
            this.f11825f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void a() {
        this.p.a();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean b(SignInConnectionListener signInConnectionListener) {
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void c() {
        if (isConnected()) {
            ((zaah) this.p).c();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void d() {
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void disconnect() {
        if (this.p.disconnect()) {
            this.l.clear();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String strConcat = String.valueOf(str).concat("  ");
        printWriter.append((CharSequence) str).append("mState=").println(this.p);
        for (Api<?> api : this.n.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.b()).println(":");
            this.f11830k.get(api.a()).dump(strConcat, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final ConnectionResult e() {
        a();
        while (f()) {
            try {
                this.f11826g.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        if (isConnected()) {
            return ConnectionResult.f11619f;
        }
        ConnectionResult connectionResult = this.q;
        return connectionResult != null ? connectionResult : new ConnectionResult(13, null);
    }

    public final boolean f() {
        return this.p instanceof zaak;
    }

    final void h(w wVar) {
        this.f11829j.sendMessage(this.f11829j.obtainMessage(1, wVar));
    }

    final void i() {
        this.f11825f.lock();
        try {
            this.p = new zaak(this, this.m, this.n, this.f11828i, this.o, this.f11825f, this.f11827h);
            this.p.d();
            this.f11826g.signalAll();
        } finally {
            this.f11825f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnected() {
        return this.p instanceof zaah;
    }

    final void k(RuntimeException runtimeException) {
        this.f11829j.sendMessage(this.f11829j.obtainMessage(2, runtimeException));
    }

    @Override // com.google.android.gms.common.api.internal.zar
    public final void k0(ConnectionResult connectionResult, Api<?> api, boolean z) {
        this.f11825f.lock();
        try {
            this.p.k0(connectionResult, api, z);
        } finally {
            this.f11825f.unlock();
        }
    }

    final void l() {
        this.f11825f.lock();
        try {
            this.s.E();
            this.p = new zaah(this);
            this.p.d();
            this.f11826g.signalAll();
        } finally {
            this.f11825f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T l0(T t) {
        t.r();
        return (T) this.p.l0(t);
    }

    final void m(ConnectionResult connectionResult) {
        this.f11825f.lock();
        try {
            this.q = connectionResult;
            this.p = new zaav(this);
            this.p.d();
            this.f11826g.signalAll();
        } finally {
            this.f11825f.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T m0(T t) {
        t.r();
        return (T) this.p.m0(t);
    }
}
