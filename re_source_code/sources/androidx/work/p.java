package androidx.work;

import android.os.Build;

/* JADX INFO: compiled from: OneTimeWorkRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class p extends z {

    /* JADX INFO: compiled from: OneTimeWorkRequest.java */
    public static final class a extends z.a<a, p> {
        public a(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.f2681c.f2528f = OverwritingInputMerger.class.getName();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.z.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public p c() {
            if (this.a && Build.VERSION.SDK_INT >= 23 && this.f2681c.l.h()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new p(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.z.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public a d() {
            return this;
        }
    }

    p(a aVar) {
        super(aVar.f2680b, aVar.f2681c, aVar.f2682d);
    }

    public static p d(Class<? extends ListenableWorker> cls) {
        return new a(cls).b();
    }
}
