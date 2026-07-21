package com.google.android.gms.internal.firebase_messaging;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
final class g {
    private final ConcurrentHashMap<f, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReferenceQueue<Throwable> f17078b = new ReferenceQueue<>();

    g() {
    }

    public final List<Throwable> a(Throwable th, boolean z) {
        ReferenceQueue<Throwable> referenceQueue = this.f17078b;
        while (true) {
            Reference<? extends Throwable> referencePoll = referenceQueue.poll();
            if (referencePoll == null) {
                break;
            }
            this.a.remove(referencePoll);
            referenceQueue = this.f17078b;
        }
        List<Throwable> list = this.a.get(new f(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> listPutIfAbsent = this.a.putIfAbsent(new f(th, this.f17078b), vector);
        return listPutIfAbsent == null ? vector : listPutIfAbsent;
    }
}
