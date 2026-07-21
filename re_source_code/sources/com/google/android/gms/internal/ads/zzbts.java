package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class zzbts<ListenerT> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<ListenerT, Executor> f14724f = new HashMap();

    protected zzbts(Set<zzbuz<ListenerT>> set) {
        X(set);
    }

    private final synchronized void X(Set<zzbuz<ListenerT>> set) {
        Iterator<zzbuz<ListenerT>> it = set.iterator();
        while (it.hasNext()) {
            U(it.next());
        }
    }

    protected final synchronized void T(final zzbtu<ListenerT> zzbtuVar) {
        for (Map.Entry<ListenerT, Executor> entry : this.f14724f.entrySet()) {
            final ListenerT key = entry.getKey();
            entry.getValue().execute(new Runnable(zzbtuVar, key) { // from class: com.google.android.gms.internal.ads.te

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzbtu f13352f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final Object f13353g;

                {
                    this.f13352f = zzbtuVar;
                    this.f13353g = key;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.f13352f.a(this.f13353g);
                    } catch (Throwable th) {
                        zzk.zzlk().h(th, "EventEmitter.notify");
                        zzawz.l("Event emitter exception.", th);
                    }
                }
            });
        }
    }

    public final synchronized void U(zzbuz<ListenerT> zzbuzVar) {
        V(zzbuzVar.a, zzbuzVar.f14744b);
    }

    public final synchronized void V(ListenerT listenert, Executor executor) {
        this.f14724f.put(listenert, executor);
    }
}
