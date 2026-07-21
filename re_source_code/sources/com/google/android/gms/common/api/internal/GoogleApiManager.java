package com.google.android.gms.common.api.internal;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.database.room.RoomNotification;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.signin.zad;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class GoogleApiManager implements Handler.Callback {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Status f11711f = new Status(4, "Sign-out occurred while this API call was in progress.");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Status f11712g = new Status(4, "The user must be signed in to make this API call.");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f11713h = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static GoogleApiManager f11714i;
    private final Context m;
    private final GoogleApiAvailability n;
    private final GoogleApiAvailabilityCache o;
    private final Handler v;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private long f11715j = 5000;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f11716k = LocalNotificationSyncManager.TWO_MINUTES;
    private long l = 10000;
    private final AtomicInteger p = new AtomicInteger(1);
    private final AtomicInteger q = new AtomicInteger(0);
    private final Map<zai<?>, zaa<?>> r = new ConcurrentHashMap(5, 0.75f, 1);
    private zaae s = null;
    private final Set<zai<?>> t = new c.e.b();
    private final Set<zai<?>> u = new c.e.b();

    /* JADX INFO: Access modifiers changed from: private */
    class b implements zach, BaseGmsClient.ConnectionProgressReportCallbacks {
        private final Api.Client a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final zai<?> f11718b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private IAccountAccessor f11719c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Set<Scope> f11720d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f11721e = false;

        public b(Api.Client client, zai<?> zaiVar) {
            this.a = client;
            this.f11718b = zaiVar;
        }

        static /* synthetic */ boolean e(b bVar, boolean z) {
            bVar.f11721e = true;
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void g() {
            IAccountAccessor iAccountAccessor;
            if (!this.f11721e || (iAccountAccessor = this.f11719c) == null) {
                return;
            }
            this.a.getRemoteService(iAccountAccessor, this.f11720d);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void a(ConnectionResult connectionResult) {
            GoogleApiManager.this.v.post(new e0(this, connectionResult));
        }

        @Override // com.google.android.gms.common.api.internal.zach
        public final void b(IAccountAccessor iAccountAccessor, Set<Scope> set) {
            if (iAccountAccessor == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                c(new ConnectionResult(4));
            } else {
                this.f11719c = iAccountAccessor;
                this.f11720d = set;
                g();
            }
        }

        @Override // com.google.android.gms.common.api.internal.zach
        public final void c(ConnectionResult connectionResult) {
            ((zaa) GoogleApiManager.this.r.get(this.f11718b)).I(connectionResult);
        }
    }

    public class zaa<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zar {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Api.Client f11724g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Api.AnyClient f11725h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final zai<O> f11726i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private final zaab f11727j;
        private final int m;
        private final zace n;
        private boolean o;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Queue<zab> f11723f = new LinkedList();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final Set<zak> f11728k = new HashSet();
        private final Map<ListenerHolder.ListenerKey<?>, zabw> l = new HashMap();
        private final List<a> p = new ArrayList();
        private ConnectionResult q = null;

        public zaa(GoogleApi<O> googleApi) {
            Api.Client clientI = googleApi.i(GoogleApiManager.this.v.getLooper(), this);
            this.f11724g = clientI;
            if (clientI instanceof SimpleClientAdapter) {
                this.f11725h = ((SimpleClientAdapter) clientI).j();
            } else {
                this.f11725h = clientI;
            }
            this.f11726i = googleApi.l();
            this.f11727j = new zaab();
            this.m = googleApi.g();
            if (clientI.requiresSignIn()) {
                this.n = googleApi.k(GoogleApiManager.this.m, GoogleApiManager.this.v);
            } else {
                this.n = null;
            }
        }

        private final void C(zab zabVar) {
            zabVar.d(this.f11727j, d());
            try {
                zabVar.c(this);
            } catch (DeadObjectException unused) {
                H(1);
                this.f11724g.disconnect();
            }
        }

        private final boolean D(boolean z) {
            Preconditions.d(GoogleApiManager.this.v);
            if (!this.f11724g.isConnected() || this.l.size() != 0) {
                return false;
            }
            if (!this.f11727j.e()) {
                this.f11724g.disconnect();
                return true;
            }
            if (z) {
                y();
            }
            return false;
        }

        private final boolean J(ConnectionResult connectionResult) {
            synchronized (GoogleApiManager.f11713h) {
                if (GoogleApiManager.this.s == null || !GoogleApiManager.this.t.contains(this.f11726i)) {
                    return false;
                }
                GoogleApiManager.this.s.m(connectionResult, this.m);
                return true;
            }
        }

        private final void K(ConnectionResult connectionResult) {
            for (zak zakVar : this.f11728k) {
                String endpointPackageName = null;
                if (Objects.a(connectionResult, ConnectionResult.f11619f)) {
                    endpointPackageName = this.f11724g.getEndpointPackageName();
                }
                zakVar.b(this.f11726i, connectionResult, endpointPackageName);
            }
            this.f11728k.clear();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final Feature f(Feature[] featureArr) {
            if (featureArr != null && featureArr.length != 0) {
                Feature[] availableFeatures = this.f11724g.getAvailableFeatures();
                if (availableFeatures == null) {
                    availableFeatures = new Feature[0];
                }
                c.e.a aVar = new c.e.a(availableFeatures.length);
                for (Feature feature : availableFeatures) {
                    aVar.put(feature.y(), Long.valueOf(feature.z()));
                }
                for (Feature feature2 : featureArr) {
                    if (!aVar.containsKey(feature2.y()) || ((Long) aVar.get(feature2.y())).longValue() < feature2.z()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(a aVar) {
            if (this.p.contains(aVar) && !this.o) {
                if (this.f11724g.isConnected()) {
                    s();
                } else {
                    a();
                }
            }
        }

        static /* synthetic */ boolean k(zaa zaaVar, boolean z) {
            return zaaVar.D(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void o(a aVar) {
            Feature[] featureArrG;
            if (this.p.remove(aVar)) {
                GoogleApiManager.this.v.removeMessages(15, aVar);
                GoogleApiManager.this.v.removeMessages(16, aVar);
                Feature feature = aVar.f11717b;
                ArrayList arrayList = new ArrayList(this.f11723f.size());
                for (zab zabVar : this.f11723f) {
                    if ((zabVar instanceof zac) && (featureArrG = ((zac) zabVar).g(this)) != null && ArrayUtils.b(featureArrG, feature)) {
                        arrayList.add(zabVar);
                    }
                }
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj = arrayList.get(i2);
                    i2++;
                    zab zabVar2 = (zab) obj;
                    this.f11723f.remove(zabVar2);
                    zabVar2.e(new UnsupportedApiCallException(feature));
                }
            }
        }

        private final boolean p(zab zabVar) {
            if (!(zabVar instanceof zac)) {
                C(zabVar);
                return true;
            }
            zac zacVar = (zac) zabVar;
            Feature featureF = f(zacVar.g(this));
            if (featureF == null) {
                C(zabVar);
                return true;
            }
            if (!zacVar.h(this)) {
                zacVar.e(new UnsupportedApiCallException(featureF));
                return false;
            }
            a aVar = new a(this.f11726i, featureF, null);
            int iIndexOf = this.p.indexOf(aVar);
            if (iIndexOf >= 0) {
                a aVar2 = this.p.get(iIndexOf);
                GoogleApiManager.this.v.removeMessages(15, aVar2);
                GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 15, aVar2), GoogleApiManager.this.f11715j);
                return false;
            }
            this.p.add(aVar);
            GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 15, aVar), GoogleApiManager.this.f11715j);
            GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 16, aVar), GoogleApiManager.this.f11716k);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (J(connectionResult)) {
                return false;
            }
            GoogleApiManager.this.s(connectionResult, this.m);
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void q() {
            v();
            K(ConnectionResult.f11619f);
            x();
            Iterator<zabw> it = this.l.values().iterator();
            while (it.hasNext()) {
                zabw next = it.next();
                if (f(next.a.c()) != null) {
                    it.remove();
                } else {
                    try {
                        next.a.d(this.f11725h, new TaskCompletionSource<>());
                    } catch (DeadObjectException unused) {
                        H(1);
                        this.f11724g.disconnect();
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            s();
            y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void r() {
            v();
            this.o = true;
            this.f11727j.g();
            GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 9, this.f11726i), GoogleApiManager.this.f11715j);
            GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 11, this.f11726i), GoogleApiManager.this.f11716k);
            GoogleApiManager.this.o.a();
        }

        private final void s() {
            ArrayList arrayList = new ArrayList(this.f11723f);
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                zab zabVar = (zab) obj;
                if (!this.f11724g.isConnected()) {
                    return;
                }
                if (p(zabVar)) {
                    this.f11723f.remove(zabVar);
                }
            }
        }

        private final void x() {
            if (this.o) {
                GoogleApiManager.this.v.removeMessages(11, this.f11726i);
                GoogleApiManager.this.v.removeMessages(9, this.f11726i);
                this.o = false;
            }
        }

        private final void y() {
            GoogleApiManager.this.v.removeMessages(12, this.f11726i);
            GoogleApiManager.this.v.sendMessageDelayed(GoogleApiManager.this.v.obtainMessage(12, this.f11726i), GoogleApiManager.this.l);
        }

        final zad A() {
            zace zaceVar = this.n;
            if (zaceVar == null) {
                return null;
            }
            return zaceVar.Y4();
        }

        public final void B(Status status) {
            Preconditions.d(GoogleApiManager.this.v);
            Iterator<zab> it = this.f11723f.iterator();
            while (it.hasNext()) {
                it.next().b(status);
            }
            this.f11723f.clear();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public final void E0(ConnectionResult connectionResult) {
            Preconditions.d(GoogleApiManager.this.v);
            zace zaceVar = this.n;
            if (zaceVar != null) {
                zaceVar.p5();
            }
            v();
            GoogleApiManager.this.o.a();
            K(connectionResult);
            if (connectionResult.y() == 4) {
                B(GoogleApiManager.f11712g);
                return;
            }
            if (this.f11723f.isEmpty()) {
                this.q = connectionResult;
                return;
            }
            if (J(connectionResult) || GoogleApiManager.this.s(connectionResult, this.m)) {
                return;
            }
            if (connectionResult.y() == 18) {
                this.o = true;
            }
            if (this.o) {
                GoogleApiManager.this.v.sendMessageDelayed(Message.obtain(GoogleApiManager.this.v, 9, this.f11726i), GoogleApiManager.this.f11715j);
                return;
            }
            String strC = this.f11726i.c();
            StringBuilder sb = new StringBuilder(String.valueOf(strC).length() + 38);
            sb.append("API: ");
            sb.append(strC);
            sb.append(" is not available on this device.");
            B(new Status(17, sb.toString()));
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void H(int i2) {
            if (Looper.myLooper() == GoogleApiManager.this.v.getLooper()) {
                r();
            } else {
                GoogleApiManager.this.v.post(new a0(this));
            }
        }

        public final void I(ConnectionResult connectionResult) {
            Preconditions.d(GoogleApiManager.this.v);
            this.f11724g.disconnect();
            E0(connectionResult);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public final void P(Bundle bundle) {
            if (Looper.myLooper() == GoogleApiManager.this.v.getLooper()) {
                q();
            } else {
                GoogleApiManager.this.v.post(new z(this));
            }
        }

        public final void a() {
            Preconditions.d(GoogleApiManager.this.v);
            if (this.f11724g.isConnected() || this.f11724g.isConnecting()) {
                return;
            }
            int iB = GoogleApiManager.this.o.b(GoogleApiManager.this.m, this.f11724g);
            if (iB != 0) {
                E0(new ConnectionResult(iB, null));
                return;
            }
            b bVar = GoogleApiManager.this.new b(this.f11724g, this.f11726i);
            if (this.f11724g.requiresSignIn()) {
                this.n.S4(bVar);
            }
            this.f11724g.connect(bVar);
        }

        public final int b() {
            return this.m;
        }

        final boolean c() {
            return this.f11724g.isConnected();
        }

        public final boolean d() {
            return this.f11724g.requiresSignIn();
        }

        public final void e() {
            Preconditions.d(GoogleApiManager.this.v);
            if (this.o) {
                a();
            }
        }

        public final void i(zab zabVar) {
            Preconditions.d(GoogleApiManager.this.v);
            if (this.f11724g.isConnected()) {
                if (p(zabVar)) {
                    y();
                    return;
                } else {
                    this.f11723f.add(zabVar);
                    return;
                }
            }
            this.f11723f.add(zabVar);
            ConnectionResult connectionResult = this.q;
            if (connectionResult == null || !connectionResult.Y()) {
                a();
            } else {
                E0(this.q);
            }
        }

        public final void j(zak zakVar) {
            Preconditions.d(GoogleApiManager.this.v);
            this.f11728k.add(zakVar);
        }

        @Override // com.google.android.gms.common.api.internal.zar
        public final void k0(ConnectionResult connectionResult, Api<?> api, boolean z) {
            if (Looper.myLooper() == GoogleApiManager.this.v.getLooper()) {
                E0(connectionResult);
            } else {
                GoogleApiManager.this.v.post(new b0(this, connectionResult));
            }
        }

        public final Api.Client l() {
            return this.f11724g;
        }

        public final void m() {
            Preconditions.d(GoogleApiManager.this.v);
            if (this.o) {
                x();
                B(GoogleApiManager.this.n.i(GoogleApiManager.this.m) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f11724g.disconnect();
            }
        }

        public final void t() {
            Preconditions.d(GoogleApiManager.this.v);
            B(GoogleApiManager.f11711f);
            this.f11727j.f();
            for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.l.keySet().toArray(new ListenerHolder.ListenerKey[this.l.size()])) {
                i(new zah(listenerKey, new TaskCompletionSource()));
            }
            K(new ConnectionResult(4));
            if (this.f11724g.isConnected()) {
                this.f11724g.onUserSignOut(new c0(this));
            }
        }

        public final Map<ListenerHolder.ListenerKey<?>, zabw> u() {
            return this.l;
        }

        public final void v() {
            Preconditions.d(GoogleApiManager.this.v);
            this.q = null;
        }

        public final ConnectionResult w() {
            Preconditions.d(GoogleApiManager.this.v);
            return this.q;
        }

        public final boolean z() {
            return D(true);
        }
    }

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.m = context;
        zap zapVar = new zap(looper, this);
        this.v = zapVar;
        this.n = googleApiAvailability;
        this.o = new GoogleApiAvailabilityCache(googleApiAvailability);
        zapVar.sendMessage(zapVar.obtainMessage(6));
    }

    @KeepForSdk
    public static void b() {
        synchronized (f11713h) {
            GoogleApiManager googleApiManager = f11714i;
            if (googleApiManager != null) {
                googleApiManager.q.incrementAndGet();
                Handler handler = googleApiManager.v;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    public static GoogleApiManager k(Context context) {
        GoogleApiManager googleApiManager;
        synchronized (f11713h) {
            if (f11714i == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                f11714i = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.q());
            }
            googleApiManager = f11714i;
        }
        return googleApiManager;
    }

    private final void l(GoogleApi<?> googleApi) {
        Object objL = googleApi.l();
        zaa<?> zaaVar = this.r.get(objL);
        if (zaaVar == null) {
            zaaVar = new zaa<>(googleApi);
            this.r.put((zai<?>) objL, zaaVar);
        }
        if (zaaVar.d()) {
            this.u.add((zai<?>) objL);
        }
        zaaVar.a();
    }

    public static GoogleApiManager n() {
        GoogleApiManager googleApiManager;
        synchronized (f11713h) {
            Preconditions.l(f11714i, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = f11714i;
        }
        return googleApiManager;
    }

    public final void A() {
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(3));
    }

    final void a() {
        this.q.incrementAndGet();
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(10));
    }

    final PendingIntent c(zai<?> zaiVar, int i2) {
        zad zadVarA;
        zaa<?> zaaVar = this.r.get(zaiVar);
        if (zaaVar == null || (zadVarA = zaaVar.A()) == null) {
            return null;
        }
        return PendingIntent.getActivity(this.m, i2, zadVarA.getSignInIntent(), 134217728);
    }

    public final Task<Map<zai<?>, String>> e(Iterable<? extends GoogleApi<?>> iterable) {
        zak zakVar = new zak(iterable);
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(2, zakVar));
        return zakVar.a();
    }

    public final void f(ConnectionResult connectionResult, int i2) {
        if (s(connectionResult, i2)) {
            return;
        }
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(5, i2, 0, connectionResult));
    }

    public final void g(GoogleApi<?> googleApi) {
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final <O extends Api.ApiOptions> void h(GoogleApi<O> googleApi, int i2, BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zae zaeVar = new zae(i2, apiMethodImpl);
        Handler handler = this.v;
        handler.sendMessage(handler.obtainMessage(4, new zabv(zaeVar, this.q.get(), googleApi)));
    }

    /* JADX WARN: Code duplicated, block: B:45:0x016d  */
    /* JADX WARN: Code duplicated, block: B:46:0x01b3  */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i2 = message.what;
        long j2 = LocalNotificationSyncManager.FIVE_MINUTES;
        zaa<?> zaaVar = null;
        switch (i2) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j2 = 10000;
                }
                this.l = j2;
                this.v.removeMessages(12);
                for (zai<?> zaiVar : this.r.keySet()) {
                    Handler handler = this.v;
                    handler.sendMessageDelayed(handler.obtainMessage(12, zaiVar), this.l);
                }
                return true;
            case 2:
                zak zakVar = (zak) message.obj;
                for (zai<?> zaiVar2 : zakVar.c()) {
                    zaa<?> zaaVar2 = this.r.get(zaiVar2);
                    if (zaaVar2 == null) {
                        zakVar.b(zaiVar2, new ConnectionResult(13), null);
                        return true;
                    }
                    if (zaaVar2.c()) {
                        zakVar.b(zaiVar2, ConnectionResult.f11619f, zaaVar2.l().getEndpointPackageName());
                    } else if (zaaVar2.w() != null) {
                        zakVar.b(zaiVar2, zaaVar2.w(), null);
                    } else {
                        zaaVar2.j(zakVar);
                        zaaVar2.a();
                    }
                }
                return true;
            case 3:
                for (zaa<?> zaaVar3 : this.r.values()) {
                    zaaVar3.v();
                    zaaVar3.a();
                }
                return true;
            case 4:
            case 8:
            case 13:
                zabv zabvVar = (zabv) message.obj;
                zaa<?> zaaVar4 = this.r.get(zabvVar.f11835c.l());
                if (zaaVar4 == null) {
                    l(zabvVar.f11835c);
                    zaaVar4 = this.r.get(zabvVar.f11835c.l());
                }
                if (!zaaVar4.d() || this.q.get() == zabvVar.f11834b) {
                    zaaVar4.i(zabvVar.a);
                } else {
                    zabvVar.a.b(f11711f);
                    zaaVar4.t();
                }
                return true;
            case 5:
                int i3 = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                for (zaa<?> zaaVar5 : this.r.values()) {
                    if (zaaVar5.b() == i3) {
                        zaaVar = zaaVar5;
                        if (zaaVar != null) {
                            String strG = this.n.g(connectionResult.y());
                            String strZ = connectionResult.z();
                            StringBuilder sb = new StringBuilder(String.valueOf(strG).length() + 69 + String.valueOf(strZ).length());
                            sb.append("Error resolution was canceled by the user, original error message: ");
                            sb.append(strG);
                            sb.append(": ");
                            sb.append(strZ);
                            zaaVar.B(new Status(17, sb.toString()));
                        } else {
                            StringBuilder sb2 = new StringBuilder(76);
                            sb2.append("Could not find API instance ");
                            sb2.append(i3);
                            sb2.append(" while trying to fail enqueued calls.");
                            Log.wtf("GoogleApiManager", sb2.toString(), new Exception());
                        }
                        return true;
                    }
                }
                if (zaaVar != null) {
                    String strG2 = this.n.g(connectionResult.y());
                    String strZ2 = connectionResult.z();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(strG2).length() + 69 + String.valueOf(strZ2).length());
                    sb3.append("Error resolution was canceled by the user, original error message: ");
                    sb3.append(strG2);
                    sb3.append(": ");
                    sb3.append(strZ2);
                    zaaVar.B(new Status(17, sb3.toString()));
                } else {
                    StringBuilder sb4 = new StringBuilder(76);
                    sb4.append("Could not find API instance ");
                    sb4.append(i3);
                    sb4.append(" while trying to fail enqueued calls.");
                    Log.wtf("GoogleApiManager", sb4.toString(), new Exception());
                }
                return true;
            case 6:
                if (PlatformVersion.a() && (this.m.getApplicationContext() instanceof Application)) {
                    BackgroundDetector.c((Application) this.m.getApplicationContext());
                    BackgroundDetector.b().a(new y(this));
                    if (!BackgroundDetector.b().e(true)) {
                        this.l = LocalNotificationSyncManager.FIVE_MINUTES;
                    }
                }
                return true;
            case 7:
                l((GoogleApi) message.obj);
                return true;
            case 9:
                if (this.r.containsKey(message.obj)) {
                    this.r.get(message.obj).e();
                }
                return true;
            case 10:
                Iterator<zai<?>> it = this.u.iterator();
                while (it.hasNext()) {
                    this.r.remove(it.next()).t();
                }
                this.u.clear();
                return true;
            case 11:
                if (this.r.containsKey(message.obj)) {
                    this.r.get(message.obj).m();
                }
                return true;
            case 12:
                if (this.r.containsKey(message.obj)) {
                    this.r.get(message.obj).z();
                }
                return true;
            case 14:
                d dVar = (d) message.obj;
                zai<?> zaiVarB = dVar.b();
                if (this.r.containsKey(zaiVarB)) {
                    dVar.a().c(Boolean.valueOf(zaa.k(this.r.get(zaiVarB), false)));
                } else {
                    dVar.a().c(Boolean.FALSE);
                }
                return true;
            case 15:
                a aVar = (a) message.obj;
                if (this.r.containsKey(aVar.a)) {
                    this.r.get(aVar.a).h(aVar);
                }
                return true;
            case 16:
                a aVar2 = (a) message.obj;
                if (this.r.containsKey(aVar2.a)) {
                    this.r.get(aVar2.a).o(aVar2);
                }
                return true;
            default:
                StringBuilder sb5 = new StringBuilder(31);
                sb5.append("Unknown message id: ");
                sb5.append(i2);
                Log.w("GoogleApiManager", sb5.toString());
                return false;
        }
    }

    public final void i(zaae zaaeVar) {
        synchronized (f11713h) {
            if (this.s != zaaeVar) {
                this.s = zaaeVar;
                this.t.clear();
            }
            this.t.addAll(zaaeVar.p());
        }
    }

    final void m(zaae zaaeVar) {
        synchronized (f11713h) {
            if (this.s == zaaeVar) {
                this.s = null;
                this.t.clear();
            }
        }
    }

    public final int o() {
        return this.p.getAndIncrement();
    }

    final boolean s(ConnectionResult connectionResult, int i2) {
        return this.n.A(this.m, connectionResult, i2);
    }

    private static class a {
        private final zai<?> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Feature f11717b;

        private a(zai<?> zaiVar, Feature feature) {
            this.a = zaiVar;
            this.f11717b = feature;
        }

        public final boolean equals(Object obj) {
            if (obj != null && (obj instanceof a)) {
                a aVar = (a) obj;
                if (Objects.a(this.a, aVar.a) && Objects.a(this.f11717b, aVar.f11717b)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.b(this.a, this.f11717b);
        }

        public final String toString() {
            return Objects.c(this).a(RoomNotification.KEY, this.a).a(DeepLinkIntentReceiver.DeepLinksTargets.FEATURE, this.f11717b).toString();
        }

        /* synthetic */ a(zai zaiVar, Feature feature, y yVar) {
            this(zaiVar, feature);
        }
    }
}
