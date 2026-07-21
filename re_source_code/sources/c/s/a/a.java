package c.s.a;

import android.graphics.Color;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: ColorCutQuantizer.java */
/* JADX INFO: loaded from: classes.dex */
final class a {
    private static final Comparator<b> a = new C0092a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int[] f3411b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int[] f3412c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final List<c.s.a.b.e> f3413d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final c.s.a.b.c[] f3415f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final float[] f3416g = new float[3];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final TimingLogger f3414e = null;

    /* JADX INFO: renamed from: c.s.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ColorCutQuantizer.java */
    static class C0092a implements Comparator<b> {
        C0092a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            return bVar2.g() - bVar.g();
        }
    }

    /* JADX INFO: compiled from: ColorCutQuantizer.java */
    private class b {
        private int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3417b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f3418c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f3419d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f3420e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f3421f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f3422g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f3423h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f3424i;

        b(int i2, int i3) {
            this.a = i2;
            this.f3417b = i3;
            c();
        }

        final boolean a() {
            return e() > 1;
        }

        final int b() {
            int iF = f();
            a aVar = a.this;
            int[] iArr = aVar.f3411b;
            int[] iArr2 = aVar.f3412c;
            a.e(iArr, iF, this.a, this.f3417b);
            Arrays.sort(iArr, this.a, this.f3417b + 1);
            a.e(iArr, iF, this.a, this.f3417b);
            int i2 = this.f3418c / 2;
            int i3 = this.a;
            int i4 = 0;
            while (true) {
                int i5 = this.f3417b;
                if (i3 > i5) {
                    return this.a;
                }
                i4 += iArr2[iArr[i3]];
                if (i4 >= i2) {
                    return Math.min(i5 - 1, i3);
                }
                i3++;
            }
        }

        final void c() {
            a aVar = a.this;
            int[] iArr = aVar.f3411b;
            int[] iArr2 = aVar.f3412c;
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MAX_VALUE;
            int i4 = Integer.MAX_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = Integer.MIN_VALUE;
            int i7 = Integer.MIN_VALUE;
            int i8 = 0;
            for (int i9 = this.a; i9 <= this.f3417b; i9++) {
                int i10 = iArr[i9];
                i8 += iArr2[i10];
                int iK = a.k(i10);
                int iJ = a.j(i10);
                int i11 = a.i(i10);
                if (iK > i5) {
                    i5 = iK;
                }
                if (iK < i2) {
                    i2 = iK;
                }
                if (iJ > i6) {
                    i6 = iJ;
                }
                if (iJ < i3) {
                    i3 = iJ;
                }
                if (i11 > i7) {
                    i7 = i11;
                }
                if (i11 < i4) {
                    i4 = i11;
                }
            }
            this.f3419d = i2;
            this.f3420e = i5;
            this.f3421f = i3;
            this.f3422g = i6;
            this.f3423h = i4;
            this.f3424i = i7;
            this.f3418c = i8;
        }

        final c.s.a.b.e d() {
            a aVar = a.this;
            int[] iArr = aVar.f3411b;
            int[] iArr2 = aVar.f3412c;
            int iK = 0;
            int i2 = 0;
            int iJ = 0;
            int i3 = 0;
            for (int i4 = this.a; i4 <= this.f3417b; i4++) {
                int i5 = iArr[i4];
                int i6 = iArr2[i5];
                i2 += i6;
                iK += a.k(i5) * i6;
                iJ += a.j(i5) * i6;
                i3 += i6 * a.i(i5);
            }
            float f2 = i2;
            return new c.s.a.b.e(a.b(Math.round(iK / f2), Math.round(iJ / f2), Math.round(i3 / f2)), i2);
        }

        final int e() {
            return (this.f3417b + 1) - this.a;
        }

        final int f() {
            int i2 = this.f3420e - this.f3419d;
            int i3 = this.f3422g - this.f3421f;
            int i4 = this.f3424i - this.f3423h;
            if (i2 < i3 || i2 < i4) {
                return (i3 < i2 || i3 < i4) ? -1 : -2;
            }
            return -3;
        }

        final int g() {
            return ((this.f3420e - this.f3419d) + 1) * ((this.f3422g - this.f3421f) + 1) * ((this.f3424i - this.f3423h) + 1);
        }

        final b h() {
            if (!a()) {
                throw new IllegalStateException("Can not split a box with only 1 color");
            }
            int iB = b();
            b bVar = a.this.new b(iB + 1, this.f3417b);
            this.f3417b = iB;
            c();
            return bVar;
        }
    }

    a(int[] iArr, int i2, c.s.a.b.c[] cVarArr) {
        this.f3415f = cVarArr;
        int[] iArr2 = new int[32768];
        this.f3412c = iArr2;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            int iG = g(iArr[i3]);
            iArr[i3] = iG;
            iArr2[iG] = iArr2[iG] + 1;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < 32768; i5++) {
            if (iArr2[i5] > 0 && l(i5)) {
                iArr2[i5] = 0;
            }
            if (iArr2[i5] > 0) {
                i4++;
            }
        }
        int[] iArr3 = new int[i4];
        this.f3411b = iArr3;
        int i6 = 0;
        for (int i7 = 0; i7 < 32768; i7++) {
            if (iArr2[i7] > 0) {
                iArr3[i6] = i7;
                i6++;
            }
        }
        if (i4 > i2) {
            this.f3413d = h(i2);
            return;
        }
        this.f3413d = new ArrayList();
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = iArr3[i8];
            this.f3413d.add(new c.s.a.b.e(a(i9), iArr2[i9]));
        }
    }

    private static int a(int i2) {
        return b(k(i2), j(i2), i(i2));
    }

    static int b(int i2, int i3, int i4) {
        return Color.rgb(f(i2, 5, 8), f(i3, 5, 8), f(i4, 5, 8));
    }

    private List<c.s.a.b.e> c(Collection<b> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator<b> it = collection.iterator();
        while (it.hasNext()) {
            c.s.a.b.e eVarD = it.next().d();
            if (!n(eVarD)) {
                arrayList.add(eVarD);
            }
        }
        return arrayList;
    }

    static void e(int[] iArr, int i2, int i3, int i4) {
        if (i2 == -2) {
            while (i3 <= i4) {
                int i5 = iArr[i3];
                iArr[i3] = i(i5) | (j(i5) << 10) | (k(i5) << 5);
                i3++;
            }
            return;
        }
        if (i2 != -1) {
            return;
        }
        while (i3 <= i4) {
            int i6 = iArr[i3];
            iArr[i3] = k(i6) | (i(i6) << 10) | (j(i6) << 5);
            i3++;
        }
    }

    private static int f(int i2, int i3, int i4) {
        return (i4 > i3 ? i2 << (i4 - i3) : i2 >> (i3 - i4)) & ((1 << i4) - 1);
    }

    private static int g(int i2) {
        return f(Color.blue(i2), 8, 5) | (f(Color.red(i2), 8, 5) << 10) | (f(Color.green(i2), 8, 5) << 5);
    }

    private List<c.s.a.b.e> h(int i2) {
        PriorityQueue<b> priorityQueue = new PriorityQueue<>(i2, a);
        priorityQueue.offer(new b(0, this.f3411b.length - 1));
        o(priorityQueue, i2);
        return c(priorityQueue);
    }

    static int i(int i2) {
        return i2 & 31;
    }

    static int j(int i2) {
        return (i2 >> 5) & 31;
    }

    static int k(int i2) {
        return (i2 >> 10) & 31;
    }

    private boolean l(int i2) {
        int iA = a(i2);
        c.i.e.a.g(iA, this.f3416g);
        return m(iA, this.f3416g);
    }

    private boolean m(int i2, float[] fArr) {
        c.s.a.b.c[] cVarArr = this.f3415f;
        if (cVarArr != null && cVarArr.length > 0) {
            int length = cVarArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                if (!this.f3415f[i3].a(i2, fArr)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean n(c.s.a.b.e eVar) {
        return m(eVar.e(), eVar.c());
    }

    private void o(PriorityQueue<b> priorityQueue, int i2) {
        b bVarPoll;
        while (priorityQueue.size() < i2 && (bVarPoll = priorityQueue.poll()) != null && bVarPoll.a()) {
            priorityQueue.offer(bVarPoll.h());
            priorityQueue.offer(bVarPoll);
        }
    }

    List<c.s.a.b.e> d() {
        return this.f3413d;
    }
}
