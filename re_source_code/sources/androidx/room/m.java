package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: RoomSQLiteQuery.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements c.u.a.e, c.u.a.d {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final TreeMap<Integer, m> f2185f = new TreeMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile String f2186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final long[] f2187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final double[] f2188i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final String[] f2189j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final byte[][] f2190k;
    private final int[] l;
    final int m;
    int n;

    private m(int i2) {
        this.m = i2;
        int i3 = i2 + 1;
        this.l = new int[i3];
        this.f2187h = new long[i3];
        this.f2188i = new double[i3];
        this.f2189j = new String[i3];
        this.f2190k = new byte[i3][];
    }

    public static m c(String str, int i2) {
        TreeMap<Integer, m> treeMap = f2185f;
        synchronized (treeMap) {
            Map.Entry<Integer, m> entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i2));
            if (entryCeilingEntry == null) {
                m mVar = new m(i2);
                mVar.d(str, i2);
                return mVar;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            m value = entryCeilingEntry.getValue();
            value.d(str, i2);
            return value;
        }
    }

    private static void e() {
        TreeMap<Integer, m> treeMap = f2185f;
        if (treeMap.size() <= 15) {
            return;
        }
        int size = treeMap.size() - 10;
        Iterator<Integer> it = treeMap.descendingKeySet().iterator();
        while (true) {
            int i2 = size - 1;
            if (size <= 0) {
                return;
            }
            it.next();
            it.remove();
            size = i2;
        }
    }

    @Override // c.u.a.d
    public void I0(int i2) {
        this.l[i2] = 1;
    }

    @Override // c.u.a.d
    public void L(int i2, double d2) {
        this.l[i2] = 3;
        this.f2188i[i2] = d2;
    }

    @Override // c.u.a.e
    public String a() {
        return this.f2186g;
    }

    @Override // c.u.a.e
    public void b(c.u.a.d dVar) {
        for (int i2 = 1; i2 <= this.n; i2++) {
            int i3 = this.l[i2];
            if (i3 == 1) {
                dVar.I0(i2);
            } else if (i3 == 2) {
                dVar.h0(i2, this.f2187h[i2]);
            } else if (i3 == 3) {
                dVar.L(i2, this.f2188i[i2]);
            } else if (i3 == 4) {
                dVar.w(i2, this.f2189j[i2]);
            } else if (i3 == 5) {
                dVar.o0(i2, this.f2190k[i2]);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    void d(String str, int i2) {
        this.f2186g = str;
        this.n = i2;
    }

    public void f() {
        TreeMap<Integer, m> treeMap = f2185f;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.m), this);
            e();
        }
    }

    @Override // c.u.a.d
    public void h0(int i2, long j2) {
        this.l[i2] = 2;
        this.f2187h[i2] = j2;
    }

    @Override // c.u.a.d
    public void o0(int i2, byte[] bArr) {
        this.l[i2] = 5;
        this.f2190k[i2] = bArr;
    }

    @Override // c.u.a.d
    public void w(int i2, String str) {
        this.l[i2] = 4;
        this.f2189j[i2] = str;
    }
}
