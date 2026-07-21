package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.SimpleClientAdapter;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class zaah implements zabd {
    private final zabe a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f11804b = false;

    public zaah(zabe zabeVar) {
        this.a = zabeVar;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void H(int i2) {
        this.a.m(null);
        this.a.t.c(i2, this.f11804b);
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void P(Bundle bundle) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void a() {
        if (this.f11804b) {
            this.f11804b = false;
            this.a.h(new f(this, this));
        }
    }

    final void c() {
        if (this.f11804b) {
            this.f11804b = false;
            this.a.s.y.a();
            disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void d() {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final boolean disconnect() {
        if (this.f11804b) {
            return false;
        }
        if (!this.a.s.F()) {
            this.a.m(null);
            return true;
        }
        this.f11804b = true;
        Iterator<zacm> it = this.a.s.x.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        return false;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final void k0(ConnectionResult connectionResult, Api<?> api, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T l0(T t) {
        try {
            this.a.s.y.b(t);
            zaaw zaawVar = this.a.s;
            Api.Client client = zaawVar.p.get(t.u());
            Preconditions.l(client, "Appropriate Api was not requested.");
            if (client.isConnected() || !this.a.l.containsKey(t.u())) {
                boolean z = client instanceof SimpleClientAdapter;
                A aJ = client;
                if (z) {
                    aJ = ((SimpleClientAdapter) client).j();
                }
                t.w(aJ);
            } else {
                t.y(new Status(17));
            }
        } catch (DeadObjectException unused) {
            this.a.h(new e(this, this));
        }
        return t;
    }

    @Override // com.google.android.gms.common.api.internal.zabd
    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T m0(T t) {
        return (T) l0(t);
    }
}
