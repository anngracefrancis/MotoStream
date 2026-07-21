package androidx.work;

import android.os.Build;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PeriodicWorkRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class s extends z {

    /* JADX INFO: compiled from: PeriodicWorkRequest.java */
    public static final class a extends z.a<a, s> {
        public a(Class<? extends ListenableWorker> cls, long j2, TimeUnit timeUnit) {
            super(cls);
            this.f2681c.e(timeUnit.toMillis(j2));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.z.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public s c() {
            if (this.a && Build.VERSION.SDK_INT >= 23 && this.f2681c.l.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            if (this.f2681c.s) {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited");
            }
            return new s(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.z.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a d() {
            return this;
        }
    }

    s(a aVar) {
        super(aVar.f2680b, aVar.f2681c, aVar.f2682d);
    }
}
