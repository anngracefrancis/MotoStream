package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@KeepName
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> a = new q0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f11699b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CallbackHandler<R> f11700c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final WeakReference<GoogleApiClient> f11701d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final CountDownLatch f11702e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ArrayList<PendingResult.StatusListener> f11703f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ResultCallback<? super R> f11704g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final AtomicReference<l0> f11705h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private R f11706i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Status f11707j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private volatile boolean f11708k;
    private boolean l;
    private boolean m;

    @KeepName
    private a mResultGuardian;
    private ICancelToken n;
    private volatile zacm<R> o;
    private boolean p;

    @VisibleForTesting
    public static class CallbackHandler<R extends Result> extends zap {
        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public final void a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 == 2) {
                    ((BasePendingResult) message.obj).p(Status.f11691j);
                    return;
                }
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i2);
                Log.wtf("BasePendingResult", sb.toString(), new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            ResultCallback resultCallback = (ResultCallback) pair.first;
            Result result = (Result) pair.second;
            try {
                resultCallback.a(result);
            } catch (RuntimeException e2) {
                BasePendingResult.o(result);
                throw e2;
            }
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }
    }

    private final class a {
        private a() {
        }

        protected final void finalize() throws Throwable {
            BasePendingResult.o(BasePendingResult.this.f11706i);
            super.finalize();
        }

        /* synthetic */ a(BasePendingResult basePendingResult, q0 q0Var) {
            this();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.f11699b = new Object();
        this.f11702e = new CountDownLatch(1);
        this.f11703f = new ArrayList<>();
        this.f11705h = new AtomicReference<>();
        this.p = false;
        this.f11700c = new CallbackHandler<>(Looper.getMainLooper());
        this.f11701d = new WeakReference<>(null);
    }

    private final R i() {
        R r;
        synchronized (this.f11699b) {
            Preconditions.o(!this.f11708k, "Result has already been consumed.");
            Preconditions.o(j(), "Result is not ready.");
            r = this.f11706i;
            this.f11706i = null;
            this.f11704g = null;
            this.f11708k = true;
        }
        l0 andSet = this.f11705h.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    private final void m(R r) {
        this.f11706i = r;
        q0 q0Var = null;
        this.n = null;
        this.f11702e.countDown();
        this.f11707j = this.f11706i.getStatus();
        if (this.l) {
            this.f11704g = null;
        } else if (this.f11704g != null) {
            this.f11700c.removeMessages(2);
            this.f11700c.a(this.f11704g, i());
        } else if (this.f11706i instanceof Releasable) {
            this.mResultGuardian = new a(this, q0Var);
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.f11703f;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            PendingResult.StatusListener statusListener = arrayList.get(i2);
            i2++;
            statusListener.a(this.f11707j);
        }
        this.f11703f.clear();
    }

    public static void o(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).c();
            } catch (RuntimeException e2) {
                String strValueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(strValueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void b(PendingResult.StatusListener statusListener) {
        Preconditions.b(statusListener != null, "Callback cannot be null.");
        synchronized (this.f11699b) {
            if (j()) {
                statusListener.a(this.f11707j);
            } else {
                this.f11703f.add(statusListener);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R c(long j2, TimeUnit timeUnit) {
        if (j2 > 0) {
            Preconditions.j("await must not be called on the UI thread when time is greater than zero.");
        }
        Preconditions.o(!this.f11708k, "Result has already been consumed.");
        Preconditions.o(this.o == null, "Cannot await if then() has been called.");
        try {
            if (!this.f11702e.await(j2, timeUnit)) {
                p(Status.f11691j);
            }
        } catch (InterruptedException unused) {
            p(Status.f11689h);
        }
        Preconditions.o(j(), "Result is not ready.");
        return (R) i();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public void d() {
        synchronized (this.f11699b) {
            if (!this.l && !this.f11708k) {
                ICancelToken iCancelToken = this.n;
                if (iCancelToken != null) {
                    try {
                        iCancelToken.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                o(this.f11706i);
                this.l = true;
                m(h(Status.f11692k));
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean e() {
        boolean z;
        synchronized (this.f11699b) {
            z = this.l;
        }
        return z;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void f(ResultCallback<? super R> resultCallback) {
        synchronized (this.f11699b) {
            try {
                if (resultCallback == null) {
                    this.f11704g = null;
                    return;
                }
                boolean z = true;
                Preconditions.o(!this.f11708k, "Result has already been consumed.");
                if (this.o != null) {
                    z = false;
                }
                Preconditions.o(z, "Cannot set callbacks if then() has been called.");
                if (e()) {
                    return;
                }
                if (j()) {
                    this.f11700c.a(resultCallback, i());
                } else {
                    this.f11704g = resultCallback;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final Integer g() {
        return null;
    }

    @KeepForSdk
    protected abstract R h(Status status);

    @KeepForSdk
    public final boolean j() {
        return this.f11702e.getCount() == 0;
    }

    @KeepForSdk
    public final void k(R r) {
        synchronized (this.f11699b) {
            if (this.m || this.l) {
                o(r);
                return;
            }
            j();
            boolean z = true;
            Preconditions.o(!j(), "Results have already been set");
            if (this.f11708k) {
                z = false;
            }
            Preconditions.o(z, "Result has already been consumed");
            m(r);
        }
    }

    public final void n(l0 l0Var) {
        this.f11705h.set(l0Var);
    }

    public final void p(Status status) {
        synchronized (this.f11699b) {
            if (!j()) {
                k(h(status));
                this.m = true;
            }
        }
    }

    public final boolean q() {
        boolean zE;
        synchronized (this.f11699b) {
            if (this.f11701d.get() == null || !this.p) {
                d();
            }
            zE = e();
        }
        return zE;
    }

    public final void r() {
        this.p = this.p || a.get().booleanValue();
    }

    @KeepForSdk
    protected BasePendingResult(GoogleApiClient googleApiClient) {
        this.f11699b = new Object();
        this.f11702e = new CountDownLatch(1);
        this.f11703f = new ArrayList<>();
        this.f11705h = new AtomicReference<>();
        this.p = false;
        this.f11700c = new CallbackHandler<>(googleApiClient != null ? googleApiClient.o() : Looper.getMainLooper());
        this.f11701d = new WeakReference<>(googleApiClient);
    }
}
