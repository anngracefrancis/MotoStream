package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: GapWorker.java */
/* JADX INFO: loaded from: classes.dex */
final class h implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final ThreadLocal<h> f2075f = new ThreadLocal<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static Comparator<c> f2076g = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    long f2078i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    long f2079j;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    ArrayList<RecyclerView> f2077h = new ArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ArrayList<c> f2080k = new ArrayList<>();

    /* JADX INFO: compiled from: GapWorker.java */
    static class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f2086d;
            if ((recyclerView == null) != (cVar2.f2086d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z = cVar.a;
            if (z != cVar2.a) {
                return z ? -1 : 1;
            }
            int i2 = cVar2.f2084b - cVar.f2084b;
            if (i2 != 0) {
                return i2;
            }
            int i3 = cVar.f2085c - cVar2.f2085c;
            if (i3 != 0) {
                return i3;
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: GapWorker.java */
    @SuppressLint({"VisibleForTests"})
    static class b implements RecyclerView.o.c {
        int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2081b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int[] f2082c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2083d;

        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.o.c
        public void a(int i2, int i3) {
            if (i2 < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i3 < 0) {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
            int i4 = this.f2083d * 2;
            int[] iArr = this.f2082c;
            if (iArr == null) {
                int[] iArr2 = new int[4];
                this.f2082c = iArr2;
                Arrays.fill(iArr2, -1);
            } else if (i4 >= iArr.length) {
                int[] iArr3 = new int[i4 * 2];
                this.f2082c = iArr3;
                System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            }
            int[] iArr4 = this.f2082c;
            iArr4[i4] = i2;
            iArr4[i4 + 1] = i3;
            this.f2083d++;
        }

        void b() {
            int[] iArr = this.f2082c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2083d = 0;
        }

        void c(RecyclerView recyclerView, boolean z) {
            this.f2083d = 0;
            int[] iArr = this.f2082c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.o oVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || oVar == null || !oVar.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.p()) {
                    oVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                oVar.collectAdjacentPrefetchPositions(this.a, this.f2081b, recyclerView.mState, this);
            }
            int i2 = this.f2083d;
            if (i2 > oVar.mPrefetchMaxCountObserved) {
                oVar.mPrefetchMaxCountObserved = i2;
                oVar.mPrefetchMaxObservedInInitialPrefetch = z;
                recyclerView.mRecycler.K();
            }
        }

        boolean d(int i2) {
            if (this.f2082c != null) {
                int i3 = this.f2083d * 2;
                for (int i4 = 0; i4 < i3; i4 += 2) {
                    if (this.f2082c[i4] == i2) {
                        return true;
                    }
                }
            }
            return false;
        }

        void e(int i2, int i3) {
            this.a = i2;
            this.f2081b = i3;
        }
    }

    /* JADX INFO: compiled from: GapWorker.java */
    static class c {
        public boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2084b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2085c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f2086d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2087e;

        c() {
        }

        public void a() {
            this.a = false;
            this.f2084b = 0;
            this.f2085c = 0;
            this.f2086d = null;
            this.f2087e = 0;
        }
    }

    h() {
    }

    private void b() {
        c cVar;
        int size = this.f2077h.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView recyclerView = this.f2077h.get(i3);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.c(recyclerView, false);
                i2 += recyclerView.mPrefetchRegistry.f2083d;
            }
        }
        this.f2080k.ensureCapacity(i2);
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            RecyclerView recyclerView2 = this.f2077h.get(i5);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.mPrefetchRegistry;
                int iAbs = Math.abs(bVar.a) + Math.abs(bVar.f2081b);
                for (int i6 = 0; i6 < bVar.f2083d * 2; i6 += 2) {
                    if (i4 >= this.f2080k.size()) {
                        cVar = new c();
                        this.f2080k.add(cVar);
                    } else {
                        cVar = this.f2080k.get(i4);
                    }
                    int[] iArr = bVar.f2082c;
                    int i7 = iArr[i6 + 1];
                    cVar.a = i7 <= iAbs;
                    cVar.f2084b = iAbs;
                    cVar.f2085c = i7;
                    cVar.f2086d = recyclerView2;
                    cVar.f2087e = iArr[i6];
                    i4++;
                }
            }
        }
        Collections.sort(this.f2080k, f2076g);
    }

    private void c(c cVar, long j2) {
        RecyclerView.c0 c0VarI = i(cVar.f2086d, cVar.f2087e, cVar.a ? Long.MAX_VALUE : j2);
        if (c0VarI == null || c0VarI.mNestedRecyclerView == null || !c0VarI.isBound() || c0VarI.isInvalid()) {
            return;
        }
        h(c0VarI.mNestedRecyclerView.get(), j2);
    }

    private void d(long j2) {
        for (int i2 = 0; i2 < this.f2080k.size(); i2++) {
            c cVar = this.f2080k.get(i2);
            if (cVar.f2086d == null) {
                return;
            }
            c(cVar, j2);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i2) {
        int iJ = recyclerView.mChildHelper.j();
        for (int i3 = 0; i3 < iJ; i3++) {
            RecyclerView.c0 childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.i(i3));
            if (childViewHolderInt.mPosition == i2 && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j2) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.j() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        b bVar = recyclerView.mPrefetchRegistry;
        bVar.c(recyclerView, true);
        if (bVar.f2083d != 0) {
            try {
                androidx.core.os.d.a("RV Nested Prefetch");
                recyclerView.mState.f(recyclerView.mAdapter);
                for (int i2 = 0; i2 < bVar.f2083d * 2; i2 += 2) {
                    i(recyclerView, bVar.f2082c[i2], j2);
                }
                androidx.core.os.d.b();
            } catch (Throwable th) {
                androidx.core.os.d.b();
                throw th;
            }
        }
    }

    private RecyclerView.c0 i(RecyclerView recyclerView, int i2, long j2) {
        if (e(recyclerView, i2)) {
            return null;
        }
        RecyclerView.v vVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.c0 c0VarI = vVar.I(i2, false, j2);
            if (c0VarI != null) {
                if (!c0VarI.isBound() || c0VarI.isInvalid()) {
                    vVar.a(c0VarI, false);
                } else {
                    vVar.B(c0VarI.itemView);
                }
            }
            return c0VarI;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f2077h.add(recyclerView);
    }

    void f(RecyclerView recyclerView, int i2, int i3) {
        if (recyclerView.isAttachedToWindow() && this.f2078i == 0) {
            this.f2078i = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.e(i2, i3);
    }

    void g(long j2) {
        b();
        d(j2);
    }

    public void j(RecyclerView recyclerView) {
        this.f2077h.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.os.d.a("RV Prefetch");
            if (!this.f2077h.isEmpty()) {
                int size = this.f2077h.size();
                long jMax = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    RecyclerView recyclerView = this.f2077h.get(i2);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f2079j);
                }
            }
        } finally {
            this.f2078i = 0L;
            androidx.core.os.d.b();
        }
    }
}
