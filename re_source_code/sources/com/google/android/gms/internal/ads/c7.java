package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
@zzard
final class c7 {
    private final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Runnable> f12403b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f12404c = false;

    public final void a(final Runnable runnable, final Executor executor) {
        synchronized (this.a) {
            if (this.f12404c) {
                executor.execute(runnable);
            } else {
                this.f12403b.add(new Runnable(executor, runnable) { // from class: com.google.android.gms.internal.ads.d7

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    private final Executor f12458f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    private final Runnable f12459g;

                    {
                        this.f12458f = executor;
                        this.f12459g = runnable;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12458f.execute(this.f12459g);
                    }
                });
            }
        }
    }

    public final void b() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.a) {
            if (this.f12404c) {
                return;
            }
            arrayList.addAll(this.f12403b);
            this.f12403b.clear();
            this.f12404c = true;
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                ((Runnable) obj).run();
            }
        }
    }
}
