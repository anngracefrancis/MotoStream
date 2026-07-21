package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zal extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected volatile boolean f11872g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected final AtomicReference<n0> f11873h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Handler f11874i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final GoogleApiAvailability f11875j;

    protected zal(LifecycleFragment lifecycleFragment) {
        this(lifecycleFragment, GoogleApiAvailability.q());
    }

    private static int k(n0 n0Var) {
        if (n0Var == null) {
            return -1;
        }
        return n0Var.b();
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void d(int i2, int i3, Intent intent) {
        n0 n0Var = this.f11873h.get();
        boolean z = true;
        if (i2 != 1) {
            if (i2 != 2) {
                z = false;
            } else {
                int i4 = this.f11875j.i(b());
                z = i4 == 0;
                if (n0Var == null) {
                    return;
                }
                if (n0Var.a().y() == 18 && i4 == 18) {
                    return;
                }
            }
        } else if (i3 != -1) {
            if (i3 == 0) {
                n0 n0Var2 = new n0(new ConnectionResult(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null), k(n0Var));
                this.f11873h.set(n0Var2);
                n0Var = n0Var2;
            }
            z = false;
        }
        if (z) {
            o();
        } else if (n0Var != null) {
            l(n0Var.a(), n0Var.b());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void e(Bundle bundle) {
        super.e(bundle);
        if (bundle != null) {
            this.f11873h.set(bundle.getBoolean("resolving_error", false) ? new n0(new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void h(Bundle bundle) {
        super.h(bundle);
        n0 n0Var = this.f11873h.get();
        if (n0Var != null) {
            bundle.putBoolean("resolving_error", true);
            bundle.putInt("failed_client_id", n0Var.b());
            bundle.putInt("failed_status", n0Var.a().y());
            bundle.putParcelable("failed_resolution", n0Var.a().W());
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void i() {
        super.i();
        this.f11872g = true;
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public void j() {
        super.j();
        this.f11872g = false;
    }

    protected abstract void l(ConnectionResult connectionResult, int i2);

    public final void m(ConnectionResult connectionResult, int i2) {
        n0 n0Var = new n0(connectionResult, i2);
        if (this.f11873h.compareAndSet(null, n0Var)) {
            this.f11874i.post(new o0(this, n0Var));
        }
    }

    protected abstract void n();

    protected final void o() {
        this.f11873h.set(null);
        n();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        l(new ConnectionResult(13, null), k(this.f11873h.get()));
        o();
    }

    @VisibleForTesting
    private zal(LifecycleFragment lifecycleFragment, GoogleApiAvailability googleApiAvailability) {
        super(lifecycleFragment);
        this.f11873h = new AtomicReference<>(null);
        this.f11874i = new zap(Looper.getMainLooper());
        this.f11875j = googleApiAvailability;
    }
}
