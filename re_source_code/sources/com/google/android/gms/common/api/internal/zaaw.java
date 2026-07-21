package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClientEventManager;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
public final class zaaw extends GoogleApiClient implements zabt {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lock f11815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f11816c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final GmsClientEventManager f11817d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f11819f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Context f11820g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Looper f11821h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f11823j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f11824k;
    private long l;
    private final u m;
    private final GoogleApiAvailability n;

    @VisibleForTesting
    private zabq o;
    final Map<Api.AnyClientKey<?>, Api.Client> p;
    Set<Scope> q;
    private final ClientSettings r;
    private final Map<Api<?>, Boolean> s;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> t;
    private final ListenerHolders u;
    private final ArrayList<zaq> v;
    private Integer w;
    Set<zacm> x;
    final zacp y;
    private final GmsClientEventManager.GmsClientEventState z;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private zabs f11818e = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @VisibleForTesting
    final Queue<BaseImplementation.ApiMethodImpl<?, ?>> f11822i = new LinkedList();

    public zaaw(Context context, Lock lock, Looper looper, ClientSettings clientSettings, GoogleApiAvailability googleApiAvailability, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Map<Api<?>, Boolean> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.AnyClientKey<?>, Api.Client> map2, int i2, int i3, ArrayList<zaq> arrayList, boolean z) {
        this.f11824k = ClientLibraryUtils.c() ? 10000L : LocalNotificationSyncManager.TWO_MINUTES;
        this.l = 5000L;
        this.q = new HashSet();
        this.u = new ListenerHolders();
        this.w = null;
        this.x = null;
        q qVar = new q(this);
        this.z = qVar;
        this.f11820g = context;
        this.f11815b = lock;
        this.f11816c = false;
        this.f11817d = new GmsClientEventManager(looper, qVar);
        this.f11821h = looper;
        this.m = new u(this, looper);
        this.n = googleApiAvailability;
        this.f11819f = i2;
        if (i2 >= 0) {
            this.w = Integer.valueOf(i3);
        }
        this.s = map;
        this.p = map2;
        this.v = arrayList;
        this.y = new zacp(map2);
        Iterator<GoogleApiClient.ConnectionCallbacks> it = list.iterator();
        while (it.hasNext()) {
            this.f11817d.f(it.next());
        }
        Iterator<GoogleApiClient.OnConnectionFailedListener> it2 = list2.iterator();
        while (it2.hasNext()) {
            this.f11817d.g(it2.next());
        }
        this.r = clientSettings;
        this.t = abstractClientBuilder;
    }

    private final void C() {
        this.f11817d.b();
        this.f11818e.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        this.f11815b.lock();
        try {
            if (E()) {
                C();
            }
        } finally {
            this.f11815b.unlock();
        }
    }

    private final void J(int i2) {
        Integer num = this.w;
        if (num == null) {
            this.w = Integer.valueOf(i2);
        } else if (num.intValue() != i2) {
            String strK = K(i2);
            String strK2 = K(this.w.intValue());
            StringBuilder sb = new StringBuilder(String.valueOf(strK).length() + 51 + String.valueOf(strK2).length());
            sb.append("Cannot use sign-in mode: ");
            sb.append(strK);
            sb.append(". Mode was already set to ");
            sb.append(strK2);
            throw new IllegalStateException(sb.toString());
        }
        if (this.f11818e != null) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (Api.Client client : this.p.values()) {
            if (client.requiresSignIn()) {
                z = true;
            }
            if (client.providesSignIn()) {
                z2 = true;
            }
        }
        int iIntValue = this.w.intValue();
        if (iIntValue == 1) {
            if (!z) {
                throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
            }
            if (z2) {
                throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
        } else if (iIntValue == 2 && z) {
            if (this.f11816c) {
                this.f11818e = new zax(this.f11820g, this.f11815b, this.f11821h, this.n, this.p, this.r, this.s, this.t, this.v, this, true);
                return;
            } else {
                this.f11818e = r0.h(this.f11820g, this, this.f11815b, this.f11821h, this.n, this.p, this.r, this.s, this.t, this.v);
                return;
            }
        }
        if (!this.f11816c || z2) {
            this.f11818e = new zabe(this.f11820g, this, this.f11815b, this.f11821h, this.n, this.p, this.r, this.s, this.t, this.v, this);
        } else {
            this.f11818e = new zax(this.f11820g, this.f11815b, this.f11821h, this.n, this.p, this.r, this.s, this.t, this.v, this, false);
        }
    }

    private static String K(int i2) {
        if (i2 == 1) {
            return "SIGN_IN_MODE_REQUIRED";
        }
        if (i2 != 2) {
            return i2 != 3 ? "UNKNOWN" : "SIGN_IN_MODE_NONE";
        }
        return "SIGN_IN_MODE_OPTIONAL";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        this.f11815b.lock();
        try {
            if (this.f11823j) {
                C();
            }
        } finally {
            this.f11815b.unlock();
        }
    }

    public static int y(Iterable<Api.Client> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.Client client : iterable) {
            if (client.requiresSignIn()) {
                z2 = true;
            }
            if (client.providesSignIn()) {
                z3 = true;
            }
        }
        if (z2) {
            return (z3 && z) ? 2 : 1;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(GoogleApiClient googleApiClient, StatusPendingResult statusPendingResult, boolean z) {
        Common.f12050d.a(googleApiClient).f(new t(this, statusPendingResult, z, googleApiClient));
    }

    final boolean E() {
        if (!this.f11823j) {
            return false;
        }
        this.f11823j = false;
        this.m.removeMessages(2);
        this.m.removeMessages(1);
        zabq zabqVar = this.o;
        if (zabqVar != null) {
            zabqVar.a();
            this.o = null;
        }
        return true;
    }

    final boolean F() {
        Lock lock;
        this.f11815b.lock();
        try {
            Set<zacm> set = this.x;
            if (set == null) {
                return false;
            }
            return !set.isEmpty();
        } finally {
            this.f11815b.unlock();
        }
    }

    final String G() {
        StringWriter stringWriter = new StringWriter();
        i(HttpUrl.FRAGMENT_ENCODE_SET, null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(ConnectionResult connectionResult) {
        if (!this.n.k(this.f11820g, connectionResult.y())) {
            E();
        }
        if (this.f11823j) {
            return;
        }
        this.f11817d.c(connectionResult);
        this.f11817d.a();
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void b(Bundle bundle) {
        while (!this.f11822i.isEmpty()) {
            k(this.f11822i.remove());
        }
        this.f11817d.d(bundle);
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void c(int i2, boolean z) {
        if (i2 == 1 && !z && !this.f11823j) {
            this.f11823j = true;
            if (this.o == null && !ClientLibraryUtils.c()) {
                this.o = this.n.v(this.f11820g.getApplicationContext(), new v(this));
            }
            u uVar = this.m;
            uVar.sendMessageDelayed(uVar.obtainMessage(1), this.f11824k);
            u uVar2 = this.m;
            uVar2.sendMessageDelayed(uVar2.obtainMessage(2), this.l);
        }
        this.y.c();
        this.f11817d.e(i2);
        this.f11817d.a();
        if (i2 == 2) {
            C();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final ConnectionResult d() {
        boolean z = true;
        Preconditions.o(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.f11815b.lock();
        try {
            if (this.f11819f >= 0) {
                if (this.w == null) {
                    z = false;
                }
                Preconditions.o(z, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.w;
                if (num == null) {
                    this.w = Integer.valueOf(y(this.p.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            J(this.w.intValue());
            this.f11817d.b();
            ConnectionResult connectionResultE = this.f11818e.e();
            this.f11815b.unlock();
            return connectionResultE;
        } catch (Throwable th) {
            this.f11815b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final PendingResult<Status> e() {
        Preconditions.o(p(), "GoogleApiClient is not connected yet.");
        Preconditions.o(this.w.intValue() != 2, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        StatusPendingResult statusPendingResult = new StatusPendingResult(this);
        if (this.p.containsKey(Common.a)) {
            z(this, statusPendingResult, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient googleApiClientE = new GoogleApiClient.Builder(this.f11820g).a(Common.f12049c).c(new r(this, atomicReference, statusPendingResult)).d(new s(this, statusPendingResult)).g(this.m).e();
            atomicReference.set(googleApiClientE);
            googleApiClientE.f();
        }
        return statusPendingResult;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void f() {
        this.f11815b.lock();
        try {
            if (this.f11819f >= 0) {
                Preconditions.o(this.w != null, "Sign-in mode should have been set explicitly by auto-manage.");
            } else {
                Integer num = this.w;
                if (num == null) {
                    this.w = Integer.valueOf(y(this.p.values(), false));
                } else if (num.intValue() == 2) {
                    throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
                }
            }
            g(this.w.intValue());
            this.f11815b.unlock();
        } catch (Throwable th) {
            this.f11815b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void g(int i2) {
        this.f11815b.lock();
        boolean z = true;
        if (i2 != 3 && i2 != 1 && i2 != 2) {
            z = false;
        }
        try {
            StringBuilder sb = new StringBuilder(33);
            sb.append("Illegal sign-in mode: ");
            sb.append(i2);
            Preconditions.b(z, sb.toString());
            J(i2);
            C();
        } finally {
            this.f11815b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void h() {
        this.f11815b.lock();
        try {
            this.y.a();
            zabs zabsVar = this.f11818e;
            if (zabsVar != null) {
                zabsVar.disconnect();
            }
            this.u.a();
            for (BaseImplementation.ApiMethodImpl<?, ?> apiMethodImpl : this.f11822i) {
                apiMethodImpl.n(null);
                apiMethodImpl.d();
            }
            this.f11822i.clear();
            if (this.f11818e == null) {
                return;
            }
            E();
            this.f11817d.a();
        } finally {
            this.f11815b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mContext=").println(this.f11820g);
        printWriter.append((CharSequence) str).append("mResuming=").print(this.f11823j);
        printWriter.append(" mWorkQueue.size()=").print(this.f11822i.size());
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.y.f11850c.size());
        zabs zabsVar = this.f11818e;
        if (zabsVar != null) {
            zabsVar.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T j(T t) {
        Preconditions.b(t.u() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean zContainsKey = this.p.containsKey(t.u());
        String strB = t.t() != null ? t.t().b() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(strB);
        sb.append(" required for this call.");
        Preconditions.b(zContainsKey, sb.toString());
        this.f11815b.lock();
        try {
            zabs zabsVar = this.f11818e;
            if (zabsVar != null) {
                return (T) zabsVar.m0(t);
            }
            this.f11822i.add(t);
            return t;
        } finally {
            this.f11815b.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T k(T t) {
        Preconditions.b(t.u() != null, "This task can not be executed (it's probably a Batch or malformed)");
        boolean zContainsKey = this.p.containsKey(t.u());
        String strB = t.t() != null ? t.t().b() : "the API";
        StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 65);
        sb.append("GoogleApiClient is not configured to use ");
        sb.append(strB);
        sb.append(" required for this call.");
        Preconditions.b(zContainsKey, sb.toString());
        this.f11815b.lock();
        try {
            if (this.f11818e == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (!this.f11823j) {
                T t2 = (T) this.f11818e.l0(t);
                this.f11815b.unlock();
                return t2;
            }
            this.f11822i.add(t);
            while (!this.f11822i.isEmpty()) {
                BaseImplementation.ApiMethodImpl<?, ?> apiMethodImplRemove = this.f11822i.remove();
                this.y.b(apiMethodImplRemove);
                apiMethodImplRemove.y(Status.f11690i);
            }
            this.f11815b.unlock();
            return t;
        } catch (Throwable th) {
            this.f11815b.unlock();
            throw th;
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final <C extends Api.Client> C m(Api.AnyClientKey<C> anyClientKey) {
        C c2 = (C) this.p.get(anyClientKey);
        Preconditions.l(c2, "Appropriate Api was not requested.");
        return c2;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Context n() {
        return this.f11820g;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final Looper o() {
        return this.f11821h;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean p() {
        zabs zabsVar = this.f11818e;
        return zabsVar != null && zabsVar.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final boolean q(SignInConnectionListener signInConnectionListener) {
        zabs zabsVar = this.f11818e;
        return zabsVar != null && zabsVar.b(signInConnectionListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void r() {
        zabs zabsVar = this.f11818e;
        if (zabsVar != null) {
            zabsVar.d();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void s() {
        h();
        f();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void t(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f11817d.g(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void u(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f11817d.h(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public final void v(zacm zacmVar) {
        this.f11815b.lock();
        try {
            Set<zacm> set = this.x;
            if (set == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!set.remove(zacmVar)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!F()) {
                this.f11818e.c();
            }
        } finally {
            this.f11815b.unlock();
        }
    }
}
