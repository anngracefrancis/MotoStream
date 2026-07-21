package c.g.b.k.m;

import java.util.ArrayList;

/* JADX INFO: compiled from: RunGroup.java */
/* JADX INFO: loaded from: classes.dex */
class m {
    public static int a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    p f3123d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    p f3124e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int f3126g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f3127h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3121b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3122c = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<p> f3125f = new ArrayList<>();

    public m(p pVar, int i2) {
        this.f3123d = null;
        this.f3124e = null;
        this.f3126g = 0;
        int i3 = a;
        this.f3126g = i3;
        a = i3 + 1;
        this.f3123d = pVar;
        this.f3124e = pVar;
        this.f3127h = i2;
    }

    private long c(f fVar, long j2) {
        p pVar = fVar.f3106d;
        if (pVar instanceof k) {
            return j2;
        }
        int size = fVar.f3113k.size();
        long jMin = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f3113k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f3106d != pVar) {
                    jMin = Math.min(jMin, c(fVar2, ((long) fVar2.f3108f) + j2));
                }
            }
        }
        if (fVar != pVar.f3149i) {
            return jMin;
        }
        long j3 = j2 - pVar.j();
        return Math.min(Math.min(jMin, c(pVar.f3148h, j3)), j3 - ((long) pVar.f3148h.f3108f));
    }

    private long d(f fVar, long j2) {
        p pVar = fVar.f3106d;
        if (pVar instanceof k) {
            return j2;
        }
        int size = fVar.f3113k.size();
        long jMax = j2;
        for (int i2 = 0; i2 < size; i2++) {
            d dVar = fVar.f3113k.get(i2);
            if (dVar instanceof f) {
                f fVar2 = (f) dVar;
                if (fVar2.f3106d != pVar) {
                    jMax = Math.max(jMax, d(fVar2, ((long) fVar2.f3108f) + j2));
                }
            }
        }
        if (fVar != pVar.f3148h) {
            return jMax;
        }
        long j3 = j2 + pVar.j();
        return Math.max(Math.max(jMax, d(pVar.f3149i, j3)), j3 - ((long) pVar.f3149i.f3108f));
    }

    public void a(p pVar) {
        this.f3125f.add(pVar);
        this.f3124e = pVar;
    }

    public long b(c.g.b.k.f fVar, int i2) {
        long j2;
        int i3;
        p pVar = this.f3123d;
        if (pVar instanceof c) {
            if (((c) pVar).f3146f != i2) {
                return 0L;
            }
        } else if (i2 == 0) {
            if (!(pVar instanceof l)) {
                return 0L;
            }
        } else if (!(pVar instanceof n)) {
            return 0L;
        }
        f fVar2 = (i2 == 0 ? fVar.f3071f : fVar.f3072g).f3148h;
        f fVar3 = (i2 == 0 ? fVar.f3071f : fVar.f3072g).f3149i;
        boolean zContains = pVar.f3148h.l.contains(fVar2);
        boolean zContains2 = this.f3123d.f3149i.l.contains(fVar3);
        long j3 = this.f3123d.j();
        if (zContains && zContains2) {
            long jD = d(this.f3123d.f3148h, 0L);
            long jC = c(this.f3123d.f3149i, 0L);
            long j4 = jD - j3;
            p pVar2 = this.f3123d;
            int i4 = pVar2.f3149i.f3108f;
            if (j4 >= (-i4)) {
                j4 += (long) i4;
            }
            int i5 = pVar2.f3148h.f3108f;
            long j5 = ((-jC) - j3) - ((long) i5);
            if (j5 >= i5) {
                j5 -= (long) i5;
            }
            float fO = pVar2.f3142b.o(i2);
            float f2 = fO > 0.0f ? (long) ((j5 / fO) + (j4 / (1.0f - fO))) : 0L;
            long j6 = ((long) ((f2 * fO) + 0.5f)) + j3 + ((long) ((f2 * (1.0f - fO)) + 0.5f));
            p pVar3 = this.f3123d;
            j2 = ((long) pVar3.f3148h.f3108f) + j6;
            i3 = pVar3.f3149i.f3108f;
        } else {
            if (zContains) {
                f fVar4 = this.f3123d.f3148h;
                return Math.max(d(fVar4, fVar4.f3108f), ((long) this.f3123d.f3148h.f3108f) + j3);
            }
            if (zContains2) {
                f fVar5 = this.f3123d.f3149i;
                return Math.max(-c(fVar5, fVar5.f3108f), ((long) (-this.f3123d.f3149i.f3108f)) + j3);
            }
            p pVar4 = this.f3123d;
            j2 = ((long) pVar4.f3148h.f3108f) + pVar4.j();
            i3 = this.f3123d.f3149i.f3108f;
        }
        return j2 - ((long) i3);
    }
}
