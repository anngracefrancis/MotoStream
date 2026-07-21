package e.e.b.a.i.b0.j;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: EventStoreConfig.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
abstract class k0 {
    static final k0 a = a().f(10485760).d(200).b(10000).c(604800000).e(81920).a();

    /* JADX INFO: compiled from: EventStoreConfig.java */
    @AutoValue.Builder
    static abstract class a {
        a() {
        }

        abstract k0 a();

        abstract a b(int i2);

        abstract a c(long j2);

        abstract a d(int i2);

        abstract a e(int i2);

        abstract a f(long j2);
    }

    k0() {
    }

    static a a() {
        return new g0.b();
    }

    abstract int b();

    abstract long c();

    abstract int d();

    abstract int e();

    abstract long f();
}
