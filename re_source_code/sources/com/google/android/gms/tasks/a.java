package com.google.android.gms.tasks;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
final class a<T> implements b<T> {
    private final CountDownLatch a = new CountDownLatch(1);

    /* synthetic */ a(zzac zzacVar) {
    }

    public final void a() throws InterruptedException {
        this.a.await();
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void b() {
        this.a.countDown();
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void c(Exception exc) {
        this.a.countDown();
    }

    public final boolean d(long j2, TimeUnit timeUnit) throws InterruptedException {
        return this.a.await(j2, timeUnit);
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(T t) {
        this.a.countDown();
    }
}
