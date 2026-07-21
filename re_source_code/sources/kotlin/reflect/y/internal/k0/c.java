package kotlin.reflect.y.internal.k0;

/* JADX INFO: compiled from: IntTree.java */
/* JADX INFO: loaded from: classes3.dex */
final class c<V> {
    static final c<Object> a = new c<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f24949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final V f24950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c<V> f24951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c<V> f24952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f24953f;

    private c() {
        this.f24953f = 0;
        this.f24949b = 0L;
        this.f24950c = null;
        this.f24951d = null;
        this.f24952e = null;
    }

    private static <V> c<V> c(long j2, V v, c<V> cVar, c<V> cVar2) {
        int i2 = ((c) cVar).f24953f;
        int i3 = ((c) cVar2).f24953f;
        if (i2 + i3 > 1) {
            if (i2 >= i3 * 5) {
                c<V> cVar3 = ((c) cVar).f24951d;
                c<V> cVar4 = ((c) cVar).f24952e;
                if (((c) cVar4).f24953f < ((c) cVar3).f24953f * 2) {
                    long j3 = ((c) cVar).f24949b;
                    return new c<>(j3 + j2, ((c) cVar).f24950c, cVar3, new c(-j3, v, cVar4.e(((c) cVar4).f24949b + j3), cVar2));
                }
                c<V> cVar5 = ((c) cVar4).f24951d;
                c<V> cVar6 = ((c) cVar4).f24952e;
                long j4 = ((c) cVar4).f24949b;
                long j5 = ((c) cVar).f24949b + j4 + j2;
                V v2 = ((c) cVar4).f24950c;
                c cVar7 = new c(-j4, ((c) cVar).f24950c, cVar3, cVar5.e(((c) cVar5).f24949b + j4));
                long j6 = ((c) cVar).f24949b;
                long j7 = ((c) cVar4).f24949b;
                return new c<>(j5, v2, cVar7, new c((-j6) - j7, v, cVar6.e(((c) cVar6).f24949b + j7 + j6), cVar2));
            }
            if (i3 >= i2 * 5) {
                c<V> cVar8 = ((c) cVar2).f24951d;
                c<V> cVar9 = ((c) cVar2).f24952e;
                if (((c) cVar8).f24953f < ((c) cVar9).f24953f * 2) {
                    long j8 = ((c) cVar2).f24949b;
                    return new c<>(j8 + j2, ((c) cVar2).f24950c, new c(-j8, v, cVar, cVar8.e(((c) cVar8).f24949b + j8)), cVar9);
                }
                c<V> cVar10 = ((c) cVar8).f24951d;
                c<V> cVar11 = ((c) cVar8).f24952e;
                long j9 = ((c) cVar8).f24949b;
                long j10 = ((c) cVar2).f24949b;
                long j11 = j9 + j10 + j2;
                V v3 = ((c) cVar8).f24950c;
                c cVar12 = new c((-j10) - j9, v, cVar, cVar10.e(((c) cVar10).f24949b + j9 + j10));
                long j12 = ((c) cVar8).f24949b;
                return new c<>(j11, v3, cVar12, new c(-j12, ((c) cVar2).f24950c, cVar11.e(((c) cVar11).f24949b + j12), cVar9));
            }
        }
        return new c<>(j2, v, cVar, cVar2);
    }

    private c<V> d(c<V> cVar, c<V> cVar2) {
        return (cVar == this.f24951d && cVar2 == this.f24952e) ? this : c(this.f24949b, this.f24950c, cVar, cVar2);
    }

    private c<V> e(long j2) {
        return (this.f24953f == 0 || j2 == this.f24949b) ? this : new c<>(j2, this.f24950c, this.f24951d, this.f24952e);
    }

    V a(long j2) {
        if (this.f24953f == 0) {
            return null;
        }
        long j3 = this.f24949b;
        if (j2 < j3) {
            return this.f24951d.a(j2 - j3);
        }
        return j2 > j3 ? this.f24952e.a(j2 - j3) : this.f24950c;
    }

    c<V> b(long j2, V v) {
        if (this.f24953f == 0) {
            return new c<>(j2, v, this, this);
        }
        long j3 = this.f24949b;
        if (j2 < j3) {
            return d(this.f24951d.b(j2 - j3, v), this.f24952e);
        }
        if (j2 > j3) {
            return d(this.f24951d, this.f24952e.b(j2 - j3, v));
        }
        return v == this.f24950c ? this : new c<>(j2, v, this.f24951d, this.f24952e);
    }

    private c(long j2, V v, c<V> cVar, c<V> cVar2) {
        this.f24949b = j2;
        this.f24950c = v;
        this.f24951d = cVar;
        this.f24952e = cVar2;
        this.f24953f = cVar.f24953f + 1 + cVar2.f24953f;
    }
}
