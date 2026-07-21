package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes2.dex */
public final class zacm<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private ResultTransform<? super R, ? extends Result> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private zacm<? extends Result> f11843b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private volatile ResultCallbacks<? super R> f11844c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f11845d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Status f11846e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final WeakReference<GoogleApiClient> f11847f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final i0 f11848g;

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).c();
            } catch (RuntimeException e2) {
                String strValueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 18);
                sb.append("Unable to release ");
                sb.append(strValueOf);
                Log.w("TransformedResultImpl", sb.toString(), e2);
            }
        }
    }

    private final boolean e() {
        return (this.f11844c == null || this.f11847f.get() == null) ? false : true;
    }

    private final void h(Status status) {
        synchronized (this.f11845d) {
            this.f11846e = status;
            j(status);
        }
    }

    private final void j(Status status) {
        synchronized (this.f11845d) {
            ResultTransform<? super R, ? extends Result> resultTransform = this.a;
            if (resultTransform != null) {
                Status statusA = resultTransform.a(status);
                Preconditions.l(statusA, "onFailure must not return null");
                this.f11843b.h(statusA);
            } else if (e()) {
                this.f11844c.b(status);
            }
        }
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final void a(R r) {
        synchronized (this.f11845d) {
            if (!r.getStatus().e0()) {
                h(r.getStatus());
                c(r);
            } else if (this.a != null) {
                zacc.a().submit(new h0(this, r));
            } else if (e()) {
                this.f11844c.c(r);
            }
        }
    }

    final void d() {
        this.f11844c = null;
    }
}
