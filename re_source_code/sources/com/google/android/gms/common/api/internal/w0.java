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
final class w0 implements OnCompleteListener<Map<zai<?>, String>> {
    private final /* synthetic */ zax a;

    private w0(zax zaxVar) {
        this.a = zaxVar;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void a(Task<Map<zai<?>, String>> task) {
        this.a.f11886k.lock();
        try {
            if (this.a.s) {
                if (task.n()) {
                    zax zaxVar = this.a;
                    zaxVar.t = new c.e.a(zaxVar.f11881f.size());
                    Iterator it = this.a.f11881f.values().iterator();
                    while (it.hasNext()) {
                        this.a.t.put(((zaw) it.next()).l(), ConnectionResult.f11619f);
                    }
                } else if (task.i() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.i();
                    if (this.a.q) {
                        zax zaxVar2 = this.a;
                        zaxVar2.t = new c.e.a(zaxVar2.f11881f.size());
                        for (zaw zawVar : this.a.f11881f.values()) {
                            Object objL = zawVar.l();
                            ConnectionResult connectionResultA = availabilityException.a(zawVar);
                            if (this.a.l(zawVar, connectionResultA)) {
                                this.a.t.put(objL, new ConnectionResult(16));
                            } else {
                                this.a.t.put(objL, connectionResultA);
                            }
                        }
                    } else {
                        this.a.t = availabilityException.b();
                    }
                    zax zaxVar3 = this.a;
                    zaxVar3.w = zaxVar3.r();
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.i());
                    this.a.t = Collections.emptyMap();
                    this.a.w = new ConnectionResult(8);
                }
                if (this.a.u != null) {
                    this.a.t.putAll(this.a.u);
                    zax zaxVar4 = this.a;
                    zaxVar4.w = zaxVar4.r();
                }
                if (this.a.w == null) {
                    this.a.p();
                    this.a.q();
                } else {
                    zax.n(this.a, false);
                    this.a.f11885j.a(this.a.w);
                }
                this.a.n.signalAll();
            }
        } finally {
            this.a.f11886k.unlock();
        }
    }
}
