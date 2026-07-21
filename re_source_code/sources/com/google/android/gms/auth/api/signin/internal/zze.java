package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.SignInConnectionListener;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class zze extends c.p.b.a<Void> implements SignInConnectionListener {
    private Semaphore p;
    private Set<GoogleApiClient> q;

    public zze(Context context, Set<GoogleApiClient> set) {
        super(context);
        this.p = new Semaphore(0);
        this.q = set;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // c.p.b.a
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public final Void B() {
        Iterator<GoogleApiClient> it = this.q.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().q(this)) {
                i2++;
            }
        }
        try {
            this.p.tryAcquire(i2, 5L, TimeUnit.SECONDS);
            return null;
        } catch (InterruptedException e2) {
            Log.i("GACSignInLoader", "Unexpected InterruptedException", e2);
            Thread.currentThread().interrupt();
            return null;
        }
    }

    @Override // com.google.android.gms.common.api.internal.SignInConnectionListener
    public final void a() {
        this.p.release();
    }

    @Override // c.p.b.b
    protected final void p() {
        this.p.drainPermits();
        i();
    }
}
