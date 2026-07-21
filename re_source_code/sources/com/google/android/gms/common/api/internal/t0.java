package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: loaded from: classes2.dex */
final class t0 implements zabt {
    private final /* synthetic */ r0 a;

    private t0(r0 r0Var) {
        this.a = r0Var;
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void a(ConnectionResult connectionResult) {
        this.a.r.lock();
        try {
            this.a.o = connectionResult;
            this.a.y();
        } finally {
            this.a.r.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void b(Bundle bundle) {
        this.a.r.lock();
        try {
            this.a.k(bundle);
            this.a.o = ConnectionResult.f11619f;
            this.a.y();
        } finally {
            this.a.r.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabt
    public final void c(int i2, boolean z) {
        this.a.r.lock();
        try {
            if (!this.a.q && this.a.p != null && this.a.p.e0()) {
                this.a.q = true;
                this.a.f11787j.H(i2);
                return;
            }
            this.a.q = false;
            this.a.j(i2, z);
        } finally {
            this.a.r.unlock();
        }
    }

    /* synthetic */ t0(r0 r0Var, s0 s0Var) {
        this(r0Var);
    }
}
