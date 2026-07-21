package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;

/* JADX INFO: loaded from: classes2.dex */
final class r0 implements zabs {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f11783f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zaaw f11784g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Looper f11785h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zabe f11786i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zabe f11787j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Map<Api.AnyClientKey<?>, zabe> f11788k;
    private final Api.Client m;
    private Bundle n;
    private final Lock r;
    private final Set<SignInConnectionListener> l = Collections.newSetFromMap(new WeakHashMap());
    private ConnectionResult o = null;
    private ConnectionResult p = null;
    private boolean q = false;
    private int s = 0;

    private r0(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, Map<Api.AnyClientKey<?>, Api.Client> map2, ClientSettings clientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Api.Client client, ArrayList<zaq> arrayList, ArrayList<zaq> arrayList2, Map<Api<?>, Boolean> map3, Map<Api<?>, Boolean> map4) {
        this.f11783f = context;
        this.f11784g = zaawVar;
        this.r = lock;
        this.f11785h = looper;
        this.m = client;
        this.f11786i = new zabe(context, zaawVar, lock, looper, googleApiAvailabilityLight, map2, null, map4, null, arrayList2, new t0(this, null));
        this.f11787j = new zabe(context, zaawVar, lock, looper, googleApiAvailabilityLight, map, clientSettings, map3, abstractClientBuilder, arrayList, new u0(this, null));
        c.e.a aVar = new c.e.a();
        Iterator<Api.AnyClientKey<?>> it = map2.keySet().iterator();
        while (it.hasNext()) {
            aVar.put(it.next(), this.f11786i);
        }
        Iterator<Api.AnyClientKey<?>> it2 = map.keySet().iterator();
        while (it2.hasNext()) {
            aVar.put(it2.next(), this.f11787j);
        }
        this.f11788k = Collections.unmodifiableMap(aVar);
    }

    private final boolean A() {
        ConnectionResult connectionResult = this.p;
        return connectionResult != null && connectionResult.y() == 4;
    }

    public static r0 h(Context context, zaaw zaawVar, Lock lock, Looper looper, GoogleApiAvailabilityLight googleApiAvailabilityLight, Map<Api.AnyClientKey<?>, Api.Client> map, ClientSettings clientSettings, Map<Api<?>, Boolean> map2, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, ArrayList<zaq> arrayList) {
        c.e.a aVar = new c.e.a();
        c.e.a aVar2 = new c.e.a();
        Api.Client client = null;
        for (Map.Entry<Api.AnyClientKey<?>, Api.Client> entry : map.entrySet()) {
            Api.Client value = entry.getValue();
            if (value.providesSignIn()) {
                client = value;
            }
            if (value.requiresSignIn()) {
                aVar.put(entry.getKey(), value);
            } else {
                aVar2.put(entry.getKey(), value);
            }
        }
        Preconditions.o(!aVar.isEmpty(), "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        c.e.a aVar3 = new c.e.a();
        c.e.a aVar4 = new c.e.a();
        for (Api<?> api : map2.keySet()) {
            Api.AnyClientKey<?> anyClientKeyA = api.a();
            if (aVar.containsKey(anyClientKeyA)) {
                aVar3.put(api, map2.get(api));
            } else {
                if (!aVar2.containsKey(anyClientKeyA)) {
                    throw new IllegalStateException("Each API in the isOptionalMap must have a corresponding client in the clients map.");
                }
                aVar4.put(api, map2.get(api));
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            zaq zaqVar = arrayList.get(i2);
            i2++;
            zaq zaqVar2 = zaqVar;
            if (aVar3.containsKey(zaqVar2.f11876f)) {
                arrayList2.add(zaqVar2);
            } else {
                if (!aVar4.containsKey(zaqVar2.f11876f)) {
                    throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the isOptionalMap");
                }
                arrayList3.add(zaqVar2);
            }
        }
        return new r0(context, zaawVar, lock, looper, googleApiAvailabilityLight, aVar, aVar2, clientSettings, abstractClientBuilder, client, arrayList2, arrayList3, aVar3, aVar4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(int i2, boolean z) {
        this.f11784g.c(i2, z);
        this.p = null;
        this.o = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Bundle bundle) {
        Bundle bundle2 = this.n;
        if (bundle2 == null) {
            this.n = bundle;
        } else if (bundle != null) {
            bundle2.putAll(bundle);
        }
    }

    private final void l(ConnectionResult connectionResult) {
        int i2 = this.s;
        if (i2 == 1) {
            z();
        } else if (i2 != 2) {
            Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
        } else {
            this.f11784g.a(connectionResult);
            z();
        }
        this.s = 0;
    }

    private final boolean o(BaseImplementation.ApiMethodImpl<? extends Result, ? extends Api.AnyClient> apiMethodImpl) {
        Object objU = apiMethodImpl.u();
        Preconditions.b(this.f11788k.containsKey(objU), "GoogleApiClient is not configured to use the API required for this call.");
        return this.f11788k.get(objU).equals(this.f11787j);
    }

    private final PendingIntent q() {
        if (this.m == null) {
            return null;
        }
        return PendingIntent.getActivity(this.f11783f, System.identityHashCode(this.f11784g), this.m.getSignInIntent(), 134217728);
    }

    private static boolean t(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.e0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        ConnectionResult connectionResult;
        if (!t(this.o)) {
            if (this.o != null && t(this.p)) {
                this.f11787j.disconnect();
                l(this.o);
                return;
            }
            ConnectionResult connectionResult2 = this.o;
            if (connectionResult2 == null || (connectionResult = this.p) == null) {
                return;
            }
            if (this.f11787j.r < this.f11786i.r) {
                connectionResult2 = connectionResult;
            }
            l(connectionResult2);
            return;
        }
        if (t(this.p) || A()) {
            int i2 = this.s;
            if (i2 == 1) {
                z();
            } else if (i2 != 2) {
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
            } else {
                this.f11784g.b(this.n);
                z();
            }
            this.s = 0;
            return;
        }
        ConnectionResult connectionResult3 = this.p;
        if (connectionResult3 != null) {
            if (this.s == 1) {
                z();
            } else {
                l(connectionResult3);
                this.f11786i.disconnect();
            }
        }
    }

    private final void z() {
        Iterator<SignInConnectionListener> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.l.clear();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void a() {
        this.s = 2;
        this.q = false;
        this.p = null;
        this.o = null;
        this.f11786i.a();
        this.f11787j.a();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean b(SignInConnectionListener signInConnectionListener) {
        this.r.lock();
        try {
            if ((!f() && !isConnected()) || this.f11787j.isConnected()) {
                return false;
            }
            this.l.add(signInConnectionListener);
            if (this.s == 0) {
                this.s = 1;
            }
            this.p = null;
            this.f11787j.a();
            return true;
        } finally {
            this.r.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void c() {
        this.f11786i.c();
        this.f11787j.c();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void d() {
        this.r.lock();
        try {
            boolean zF = f();
            this.f11787j.disconnect();
            this.p = new ConnectionResult(4);
            if (zF) {
                new zap(this.f11785h).post(new s0(this));
            } else {
                z();
            }
        } finally {
            this.r.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void disconnect() {
        this.p = null;
        this.o = null;
        this.s = 0;
        this.f11786i.disconnect();
        this.f11787j.disconnect();
        z();
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("authClient").println(":");
        this.f11787j.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append((CharSequence) str).append("anonClient").println(":");
        this.f11786i.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final ConnectionResult e() {
        throw new UnsupportedOperationException();
    }

    public final boolean f() {
        this.r.lock();
        try {
            return this.s == 2;
        } finally {
            this.r.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final boolean isConnected() {
        this.r.lock();
        try {
            boolean z = true;
            if (!this.f11786i.isConnected() || (!this.f11787j.isConnected() && !A() && this.s != 1)) {
                z = false;
            }
            return z;
        } finally {
            this.r.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T l0(T t) {
        if (!o(t)) {
            return (T) this.f11786i.l0(t);
        }
        if (!A()) {
            return (T) this.f11787j.l0(t);
        }
        t.y(new Status(4, null, q()));
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabs
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T m0(T t) {
        if (!o(t)) {
            return (T) this.f11786i.m0(t);
        }
        if (!A()) {
            return (T) this.f11787j.m0(t);
        }
        t.y(new Status(4, null, q()));
        return t;
    }
}
