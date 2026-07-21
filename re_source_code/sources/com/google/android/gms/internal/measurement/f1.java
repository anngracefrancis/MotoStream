package com.google.android.gms.internal.measurement;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class f1 {
    private final ConcurrentHashMap<e1, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReferenceQueue<Throwable> f17151b = new ReferenceQueue<>();

    f1() {
    }

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> referencePoll = this.f17151b.poll();
        while (referencePoll != null) {
            this.a.remove(referencePoll);
            referencePoll = this.f17151b.poll();
        }
        List<Throwable> list = this.a.get(new e1(th, null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> listPutIfAbsent = this.a.putIfAbsent(new e1(th, this.f17151b), vector);
        return listPutIfAbsent == null ? vector : listPutIfAbsent;
    }
}
