package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DiffUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
    private static final Comparator<g> a = new a();

    /* JADX INFO: compiled from: DiffUtil.java */
    static class a implements Comparator<g> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(g gVar, g gVar2) {
            int i2 = gVar.a - gVar2.a;
            return i2 == 0 ? gVar.f2059b - gVar2.f2059b : i2;
        }
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    public static abstract class b {
        public abstract boolean areContentsTheSame(int i2, int i3);

        public abstract boolean areItemsTheSame(int i2, int i3);

        public Object getChangePayload(int i2, int i3) {
            return null;
        }

        public abstract int getNewListSize();

        public abstract int getOldListSize();
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    public static class c {
        private final List<g> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f2048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int[] f2049c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final b f2050d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f2051e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f2052f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final boolean f2053g;

        c(b bVar, List<g> list, int[] iArr, int[] iArr2, boolean z) {
            this.a = list;
            this.f2048b = iArr;
            this.f2049c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f2050d = bVar;
            this.f2051e = bVar.getOldListSize();
            this.f2052f = bVar.getNewListSize();
            this.f2053g = z;
            a();
            h();
        }

        private void a() {
            g gVar = this.a.isEmpty() ? null : this.a.get(0);
            if (gVar != null && gVar.a == 0 && gVar.f2059b == 0) {
                return;
            }
            g gVar2 = new g();
            gVar2.a = 0;
            gVar2.f2059b = 0;
            gVar2.f2061d = false;
            gVar2.f2060c = 0;
            gVar2.f2062e = false;
            this.a.add(0, gVar2);
        }

        private void b(List<e> list, l lVar, int i2, int i3, int i4) {
            if (!this.f2053g) {
                lVar.b(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int[] iArr = this.f2049c;
                int i6 = i4 + i5;
                int i7 = iArr[i6] & 31;
                if (i7 == 0) {
                    lVar.b(i2, 1);
                    Iterator<e> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f2054b++;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = iArr[i6] >> 5;
                    lVar.a(j(list, i8, true).f2054b, i2);
                    if (i7 == 4) {
                        lVar.d(i2, 1, this.f2050d.getChangePayload(i8, i6));
                    }
                } else {
                    if (i7 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                    }
                    list.add(new e(i6, i2, false));
                }
            }
        }

        private void c(List<e> list, l lVar, int i2, int i3, int i4) {
            if (!this.f2053g) {
                lVar.c(i2, i3);
                return;
            }
            for (int i5 = i3 - 1; i5 >= 0; i5--) {
                int[] iArr = this.f2048b;
                int i6 = i4 + i5;
                int i7 = iArr[i6] & 31;
                if (i7 == 0) {
                    lVar.c(i2 + i5, 1);
                    Iterator<e> it = list.iterator();
                    while (it.hasNext()) {
                        it.next().f2054b--;
                    }
                } else if (i7 == 4 || i7 == 8) {
                    int i8 = iArr[i6] >> 5;
                    e eVarJ = j(list, i8, false);
                    lVar.a(i2 + i5, eVarJ.f2054b - 1);
                    if (i7 == 4) {
                        lVar.d(eVarJ.f2054b - 1, 1, this.f2050d.getChangePayload(i6, i8));
                    }
                } else {
                    if (i7 != 16) {
                        throw new IllegalStateException("unknown flag for pos " + i6 + " " + Long.toBinaryString(i7));
                    }
                    list.add(new e(i6, i2 + i5, true));
                }
            }
        }

        private void f(int i2, int i3, int i4) {
            if (this.f2048b[i2 - 1] != 0) {
                return;
            }
            g(i2, i3, i4, false);
        }

        private boolean g(int i2, int i3, int i4, boolean z) {
            int i5;
            int i6;
            int i7;
            if (z) {
                i3--;
                i6 = i2;
                i5 = i3;
            } else {
                i5 = i2 - 1;
                i6 = i5;
            }
            while (i4 >= 0) {
                g gVar = this.a.get(i4);
                int i8 = gVar.a;
                int i9 = gVar.f2060c;
                int i10 = i8 + i9;
                int i11 = gVar.f2059b + i9;
                if (z) {
                    for (int i12 = i6 - 1; i12 >= i10; i12--) {
                        if (this.f2050d.areItemsTheSame(i12, i5)) {
                            i7 = this.f2050d.areContentsTheSame(i12, i5) ? 8 : 4;
                            this.f2049c[i5] = (i12 << 5) | 16;
                            this.f2048b[i12] = (i5 << 5) | i7;
                            return true;
                        }
                    }
                } else {
                    for (int i13 = i3 - 1; i13 >= i11; i13--) {
                        if (this.f2050d.areItemsTheSame(i5, i13)) {
                            i7 = this.f2050d.areContentsTheSame(i5, i13) ? 8 : 4;
                            int i14 = i2 - 1;
                            this.f2048b[i14] = (i13 << 5) | 16;
                            this.f2049c[i13] = (i14 << 5) | i7;
                            return true;
                        }
                    }
                }
                i6 = gVar.a;
                i3 = gVar.f2059b;
                i4--;
            }
            return false;
        }

        private void h() {
            int i2 = this.f2051e;
            int i3 = this.f2052f;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                g gVar = this.a.get(size);
                int i4 = gVar.a;
                int i5 = gVar.f2060c;
                int i6 = i4 + i5;
                int i7 = gVar.f2059b + i5;
                if (this.f2053g) {
                    while (i2 > i6) {
                        f(i2, i3, size);
                        i2--;
                    }
                    while (i3 > i7) {
                        i(i2, i3, size);
                        i3--;
                    }
                }
                for (int i8 = 0; i8 < gVar.f2060c; i8++) {
                    int i9 = gVar.a + i8;
                    int i10 = gVar.f2059b + i8;
                    int i11 = this.f2050d.areContentsTheSame(i9, i10) ? 1 : 2;
                    this.f2048b[i9] = (i10 << 5) | i11;
                    this.f2049c[i10] = (i9 << 5) | i11;
                }
                i2 = gVar.a;
                i3 = gVar.f2059b;
            }
        }

        private void i(int i2, int i3, int i4) {
            if (this.f2049c[i3 - 1] != 0) {
                return;
            }
            g(i2, i3, i4, true);
        }

        private static e j(List<e> list, int i2, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                e eVar = list.get(size);
                if (eVar.a == i2 && eVar.f2055c == z) {
                    list.remove(size);
                    while (size < list.size()) {
                        list.get(size).f2054b += z ? 1 : -1;
                        size++;
                    }
                    return eVar;
                }
                size--;
            }
            return null;
        }

        public void d(l lVar) {
            androidx.recyclerview.widget.c cVar = lVar instanceof androidx.recyclerview.widget.c ? (androidx.recyclerview.widget.c) lVar : new androidx.recyclerview.widget.c(lVar);
            List<e> arrayList = new ArrayList<>();
            int i2 = this.f2051e;
            int i3 = this.f2052f;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                g gVar = this.a.get(size);
                int i4 = gVar.f2060c;
                int i5 = gVar.a + i4;
                int i6 = gVar.f2059b + i4;
                if (i5 < i2) {
                    c(arrayList, cVar, i5, i2 - i5, i5);
                }
                if (i6 < i3) {
                    b(arrayList, cVar, i5, i3 - i6, i6);
                }
                for (int i7 = i4 - 1; i7 >= 0; i7--) {
                    int[] iArr = this.f2048b;
                    int i8 = gVar.a;
                    if ((iArr[i8 + i7] & 31) == 2) {
                        cVar.d(i8 + i7, 1, this.f2050d.getChangePayload(i8 + i7, gVar.f2059b + i7));
                    }
                }
                i2 = gVar.a;
                i3 = gVar.f2059b;
            }
            cVar.e();
        }

        public void e(RecyclerView.g gVar) {
            d(new androidx.recyclerview.widget.b(gVar));
        }
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    public static abstract class d<T> {
        public abstract boolean a(T t, T t2);

        public abstract boolean b(T t, T t2);

        public abstract Object c(T t, T t2);
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    private static class e {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2054b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f2055c;

        public e(int i2, int i3, boolean z) {
            this.a = i2;
            this.f2054b = i3;
            this.f2055c = z;
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DiffUtil.java */
    static class C0042f {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2056b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2057c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2058d;

        public C0042f() {
        }

        public C0042f(int i2, int i3, int i4, int i5) {
            this.a = i2;
            this.f2056b = i3;
            this.f2057c = i4;
            this.f2058d = i5;
        }
    }

    /* JADX INFO: compiled from: DiffUtil.java */
    static class g {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f2060c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f2061d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f2062e;

        g() {
        }
    }

    public static c a(b bVar) {
        return b(bVar, true);
    }

    public static c b(b bVar, boolean z) {
        int oldListSize = bVar.getOldListSize();
        int newListSize = bVar.getNewListSize();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new C0042f(0, oldListSize, 0, newListSize));
        int iAbs = oldListSize + newListSize + Math.abs(oldListSize - newListSize);
        int i2 = iAbs * 2;
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            C0042f c0042f = (C0042f) arrayList2.remove(arrayList2.size() - 1);
            g gVarC = c(bVar, c0042f.a, c0042f.f2056b, c0042f.f2057c, c0042f.f2058d, iArr, iArr2, iAbs);
            if (gVarC != null) {
                if (gVarC.f2060c > 0) {
                    arrayList.add(gVarC);
                }
                gVarC.a += c0042f.a;
                gVarC.f2059b += c0042f.f2057c;
                C0042f c0042f2 = arrayList3.isEmpty() ? new C0042f() : (C0042f) arrayList3.remove(arrayList3.size() - 1);
                c0042f2.a = c0042f.a;
                c0042f2.f2057c = c0042f.f2057c;
                if (gVarC.f2062e) {
                    c0042f2.f2056b = gVarC.a;
                    c0042f2.f2058d = gVarC.f2059b;
                } else if (gVarC.f2061d) {
                    c0042f2.f2056b = gVarC.a - 1;
                    c0042f2.f2058d = gVarC.f2059b;
                } else {
                    c0042f2.f2056b = gVarC.a;
                    c0042f2.f2058d = gVarC.f2059b - 1;
                }
                arrayList2.add(c0042f2);
                if (!gVarC.f2062e) {
                    int i3 = gVarC.a;
                    int i4 = gVarC.f2060c;
                    c0042f.a = i3 + i4;
                    c0042f.f2057c = gVarC.f2059b + i4;
                } else if (gVarC.f2061d) {
                    int i5 = gVarC.a;
                    int i6 = gVarC.f2060c;
                    c0042f.a = i5 + i6 + 1;
                    c0042f.f2057c = gVarC.f2059b + i6;
                } else {
                    int i7 = gVarC.a;
                    int i8 = gVarC.f2060c;
                    c0042f.a = i7 + i8;
                    c0042f.f2057c = gVarC.f2059b + i8 + 1;
                }
                arrayList2.add(c0042f);
            } else {
                arrayList3.add(c0042f);
            }
        }
        Collections.sort(arrayList, a);
        return new c(bVar, arrayList, iArr, iArr2, z);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x004d  */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:52:0x00cd
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:111)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    private static androidx.recyclerview.widget.f.g c(androidx.recyclerview.widget.f.b r19, int r20, int r21, int r22, int r23, int[] r24, int[] r25, int r26) {
        /*
            Method dump skipped, instruction units count: 305
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.f.c(androidx.recyclerview.widget.f$b, int, int, int, int, int[], int[], int):androidx.recyclerview.widget.f$g");
    }
}
