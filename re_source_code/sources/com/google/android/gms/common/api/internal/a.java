package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class a implements OnCompleteListener<Map<zai<?>, String>> {
    private SignInConnectionListener a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zax f11741b;

    a(zax zaxVar, SignInConnectionListener signInConnectionListener) {
        this.f11741b = zaxVar;
        this.a = signInConnectionListener;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void a(Task<Map<zai<?>, String>> task) {
        this.f11741b.f11886k.lock();
        try {
            if (!this.f11741b.s) {
                this.a.a();
                this.f11741b.f11886k.unlock();
                return;
            }
            if (task.n()) {
                zax zaxVar = this.f11741b;
                zaxVar.u = new c.e.a(zaxVar.f11882g.size());
                Iterator it = this.f11741b.f11882g.values().iterator();
                while (it.hasNext()) {
                    this.f11741b.u.put(((zaw) it.next()).l(), ConnectionResult.f11619f);
                }
            } else if (task.i() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) task.i();
                if (this.f11741b.q) {
                    zax zaxVar2 = this.f11741b;
                    zaxVar2.u = new c.e.a(zaxVar2.f11882g.size());
                    for (zaw zawVar : this.f11741b.f11882g.values()) {
                        Object objL = zawVar.l();
                        ConnectionResult connectionResultA = availabilityException.a(zawVar);
                        if (this.f11741b.l(zawVar, connectionResultA)) {
                            this.f11741b.u.put(objL, new ConnectionResult(16));
                        } else {
                            this.f11741b.u.put(objL, connectionResultA);
                        }
                    }
                } else {
                    this.f11741b.u = availabilityException.b();
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", task.i());
                this.f11741b.u = Collections.emptyMap();
            }
            if (this.f11741b.isConnected()) {
                this.f11741b.t.putAll(this.f11741b.u);
                if (this.f11741b.r() == null) {
                    this.f11741b.p();
                    this.f11741b.q();
                    this.f11741b.n.signalAll();
                }
            }
            this.a.a();
            this.f11741b.f11886k.unlock();
        } catch (Throwable th) {
            this.f11741b.f11886k.unlock();
            throw th;
        }
    }

    final void b() {
        this.a.a();
    }
}
