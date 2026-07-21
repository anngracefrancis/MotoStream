package androidx.work.impl.n;

import androidx.work.x;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: WorkSpec.java */
/* JADX INFO: loaded from: classes.dex */
public final class p {
    private static final String a = androidx.work.n.f("WorkSpec");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c.b.a.c.a<List<c>, List<x>> f2524b = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public x.a f2526d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f2527e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f2528f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public androidx.work.e f2529g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public androidx.work.e f2530h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f2531i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f2532j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f2533k;
    public androidx.work.c l;
    public int m;
    public androidx.work.a n;
    public long o;
    public long p;
    public long q;
    public long r;
    public boolean s;
    public androidx.work.r t;

    /* JADX INFO: compiled from: WorkSpec.java */
    class a implements c.b.a.c.a<List<c>, List<x>> {
        a() {
        }

        @Override // c.b.a.c.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<x> a(List<c> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a());
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: WorkSpec.java */
    public static class b {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public x.a f2534b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f2534b != bVar.f2534b) {
                return false;
            }
            return this.a.equals(bVar.a);
        }

        public int hashCode() {
            return (this.a.hashCode() * 31) + this.f2534b.hashCode();
        }
    }

    /* JADX INFO: compiled from: WorkSpec.java */
    public static class c {
        public String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public x.a f2535b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public androidx.work.e f2536c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2537d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<String> f2538e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public List<androidx.work.e> f2539f;

        public x a() {
            List<androidx.work.e> list = this.f2539f;
            return new x(UUID.fromString(this.a), this.f2535b, this.f2536c, this.f2538e, (list == null || list.isEmpty()) ? androidx.work.e.f2327b : this.f2539f.get(0), this.f2537d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f2537d != cVar.f2537d) {
                return false;
            }
            String str = this.a;
            if (str == null ? cVar.a != null : !str.equals(cVar.a)) {
                return false;
            }
            if (this.f2535b != cVar.f2535b) {
                return false;
            }
            androidx.work.e eVar = this.f2536c;
            if (eVar == null ? cVar.f2536c != null : !eVar.equals(cVar.f2536c)) {
                return false;
            }
            List<String> list = this.f2538e;
            if (list == null ? cVar.f2538e != null : !list.equals(cVar.f2538e)) {
                return false;
            }
            List<androidx.work.e> list2 = this.f2539f;
            List<androidx.work.e> list3 = cVar.f2539f;
            if (list2 != null) {
                return list2.equals(list3);
            }
            return list3 == null;
        }

        public int hashCode() {
            String str = this.a;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            x.a aVar = this.f2535b;
            int iHashCode2 = (iHashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
            androidx.work.e eVar = this.f2536c;
            int iHashCode3 = (((iHashCode2 + (eVar != null ? eVar.hashCode() : 0)) * 31) + this.f2537d) * 31;
            List<String> list = this.f2538e;
            int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            List<androidx.work.e> list2 = this.f2539f;
            return iHashCode4 + (list2 != null ? list2.hashCode() : 0);
        }
    }

    public p(String str, String str2) {
        this.f2526d = x.a.ENQUEUED;
        androidx.work.e eVar = androidx.work.e.f2327b;
        this.f2529g = eVar;
        this.f2530h = eVar;
        this.l = androidx.work.c.a;
        this.n = androidx.work.a.EXPONENTIAL;
        this.o = 30000L;
        this.r = -1L;
        this.t = androidx.work.r.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f2525c = str;
        this.f2527e = str2;
    }

    public long a() {
        if (c()) {
            return this.p + Math.min(18000000L, this.n == androidx.work.a.LINEAR ? this.o * ((long) this.m) : (long) Math.scalb(this.o, this.m - 1));
        }
        if (!d()) {
            long jCurrentTimeMillis = this.p;
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            return jCurrentTimeMillis + this.f2531i;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        long j2 = this.p;
        long j3 = j2 == 0 ? jCurrentTimeMillis2 + this.f2531i : j2;
        long j4 = this.f2533k;
        long j5 = this.f2532j;
        if (j4 != j5) {
            return j3 + j5 + (j2 == 0 ? j4 * (-1) : 0L);
        }
        return j3 + (j2 != 0 ? j5 : 0L);
    }

    public boolean b() {
        return !androidx.work.c.a.equals(this.l);
    }

    public boolean c() {
        return this.f2526d == x.a.ENQUEUED && this.m > 0;
    }

    public boolean d() {
        return this.f2532j != 0;
    }

    public void e(long j2) {
        if (j2 < 900000) {
            androidx.work.n.c().h(a, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
            j2 = 900000;
        }
        f(j2, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f2531i != pVar.f2531i || this.f2532j != pVar.f2532j || this.f2533k != pVar.f2533k || this.m != pVar.m || this.o != pVar.o || this.p != pVar.p || this.q != pVar.q || this.r != pVar.r || this.s != pVar.s || !this.f2525c.equals(pVar.f2525c) || this.f2526d != pVar.f2526d || !this.f2527e.equals(pVar.f2527e)) {
            return false;
        }
        String str = this.f2528f;
        if (str == null ? pVar.f2528f == null : str.equals(pVar.f2528f)) {
            return this.f2529g.equals(pVar.f2529g) && this.f2530h.equals(pVar.f2530h) && this.l.equals(pVar.l) && this.n == pVar.n && this.t == pVar.t;
        }
        return false;
    }

    public void f(long j2, long j3) {
        if (j2 < 900000) {
            androidx.work.n.c().h(a, String.format("Interval duration lesser than minimum allowed value; Changed to %s", 900000L), new Throwable[0]);
            j2 = 900000;
        }
        if (j3 < LocalNotificationSyncManager.FIVE_MINUTES) {
            androidx.work.n.c().h(a, String.format("Flex duration lesser than minimum allowed value; Changed to %s", Long.valueOf(LocalNotificationSyncManager.FIVE_MINUTES)), new Throwable[0]);
            j3 = 300000;
        }
        if (j3 > j2) {
            androidx.work.n.c().h(a, String.format("Flex duration greater than interval duration; Changed to %s", Long.valueOf(j2)), new Throwable[0]);
            j3 = j2;
        }
        this.f2532j = j2;
        this.f2533k = j3;
    }

    public int hashCode() {
        int iHashCode = ((((this.f2525c.hashCode() * 31) + this.f2526d.hashCode()) * 31) + this.f2527e.hashCode()) * 31;
        String str = this.f2528f;
        int iHashCode2 = (((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f2529g.hashCode()) * 31) + this.f2530h.hashCode()) * 31;
        long j2 = this.f2531i;
        int i2 = (iHashCode2 + ((int) (j2 ^ (j2 >>> 32)))) * 31;
        long j3 = this.f2532j;
        int i3 = (i2 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
        long j4 = this.f2533k;
        int iHashCode3 = (((((((i3 + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.l.hashCode()) * 31) + this.m) * 31) + this.n.hashCode()) * 31;
        long j5 = this.o;
        int i4 = (iHashCode3 + ((int) (j5 ^ (j5 >>> 32)))) * 31;
        long j6 = this.p;
        int i5 = (i4 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.q;
        int i6 = (i5 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j8 = this.r;
        return ((((i6 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + (this.s ? 1 : 0)) * 31) + this.t.hashCode();
    }

    public String toString() {
        return "{WorkSpec: " + this.f2525c + "}";
    }

    public p(p pVar) {
        this.f2526d = x.a.ENQUEUED;
        androidx.work.e eVar = androidx.work.e.f2327b;
        this.f2529g = eVar;
        this.f2530h = eVar;
        this.l = androidx.work.c.a;
        this.n = androidx.work.a.EXPONENTIAL;
        this.o = 30000L;
        this.r = -1L;
        this.t = androidx.work.r.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f2525c = pVar.f2525c;
        this.f2527e = pVar.f2527e;
        this.f2526d = pVar.f2526d;
        this.f2528f = pVar.f2528f;
        this.f2529g = new androidx.work.e(pVar.f2529g);
        this.f2530h = new androidx.work.e(pVar.f2530h);
        this.f2531i = pVar.f2531i;
        this.f2532j = pVar.f2532j;
        this.f2533k = pVar.f2533k;
        this.l = new androidx.work.c(pVar.l);
        this.m = pVar.m;
        this.n = pVar.n;
        this.o = pVar.o;
        this.p = pVar.p;
        this.q = pVar.q;
        this.r = pVar.r;
        this.s = pVar.s;
        this.t = pVar.t;
    }
}
