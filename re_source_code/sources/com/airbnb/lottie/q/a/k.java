package com.airbnb.lottie.q.a;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.os.Build;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: MergePathsContent.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(19)
public class k implements l, i {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f8611d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.airbnb.lottie.s.j.h f8613f;
    private final Path a = new Path();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Path f8609b = new Path();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Path f8610c = new Path();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<l> f8612e = new ArrayList();

    /* JADX INFO: compiled from: MergePathsContent.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.airbnb.lottie.s.j.h.a.values().length];
            a = iArr;
            try {
                iArr[com.airbnb.lottie.s.j.h.a.Merge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.airbnb.lottie.s.j.h.a.Add.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.airbnb.lottie.s.j.h.a.Subtract.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.airbnb.lottie.s.j.h.a.Intersect.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.airbnb.lottie.s.j.h.a.ExcludeIntersections.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public k(com.airbnb.lottie.s.j.h hVar) {
        if (Build.VERSION.SDK_INT < 19) {
            throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
        }
        this.f8611d = hVar.c();
        this.f8613f = hVar;
    }

    private void a() {
        for (int i2 = 0; i2 < this.f8612e.size(); i2++) {
            this.f8610c.addPath(this.f8612e.get(i2).g());
        }
    }

    @TargetApi(19)
    private void c(Path.Op op) {
        this.f8609b.reset();
        this.a.reset();
        for (int size = this.f8612e.size() - 1; size >= 1; size--) {
            l lVar = this.f8612e.get(size);
            if (lVar instanceof c) {
                c cVar = (c) lVar;
                List<l> listJ = cVar.j();
                for (int size2 = listJ.size() - 1; size2 >= 0; size2--) {
                    Path pathG = listJ.get(size2).g();
                    pathG.transform(cVar.k());
                    this.f8609b.addPath(pathG);
                }
            } else {
                this.f8609b.addPath(lVar.g());
            }
        }
        l lVar2 = this.f8612e.get(0);
        if (lVar2 instanceof c) {
            c cVar2 = (c) lVar2;
            List<l> listJ2 = cVar2.j();
            for (int i2 = 0; i2 < listJ2.size(); i2++) {
                Path pathG2 = listJ2.get(i2).g();
                pathG2.transform(cVar2.k());
                this.a.addPath(pathG2);
            }
        } else {
            this.a.set(lVar2.g());
        }
        this.f8610c.op(this.a, this.f8609b, op);
    }

    @Override // com.airbnb.lottie.q.a.b
    public void b(List<b> list, List<b> list2) {
        for (int i2 = 0; i2 < this.f8612e.size(); i2++) {
            this.f8612e.get(i2).b(list, list2);
        }
    }

    @Override // com.airbnb.lottie.q.a.i
    public void e(ListIterator<b> listIterator) {
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        while (listIterator.hasPrevious()) {
            b bVarPrevious = listIterator.previous();
            if (bVarPrevious instanceof l) {
                this.f8612e.add((l) bVarPrevious);
                listIterator.remove();
            }
        }
    }

    @Override // com.airbnb.lottie.q.a.l
    public Path g() {
        this.f8610c.reset();
        int i2 = a.a[this.f8613f.b().ordinal()];
        if (i2 == 1) {
            a();
        } else if (i2 == 2) {
            c(Path.Op.UNION);
        } else if (i2 == 3) {
            c(Path.Op.REVERSE_DIFFERENCE);
        } else if (i2 == 4) {
            c(Path.Op.INTERSECT);
        } else if (i2 == 5) {
            c(Path.Op.XOR);
        }
        return this.f8610c;
    }
}
