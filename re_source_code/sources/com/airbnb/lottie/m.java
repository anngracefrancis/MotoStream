package com.airbnb.lottie;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: PerformanceTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class m {
    private boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Set<b> f8552b = new c.e.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, com.airbnb.lottie.v.d> f8553c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Comparator<c.i.j.e<String, Float>> f8554d = new a();

    /* JADX INFO: compiled from: PerformanceTracker.java */
    class a implements Comparator<c.i.j.e<String, Float>> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c.i.j.e<String, Float> eVar, c.i.j.e<String, Float> eVar2) {
            float fFloatValue = eVar.f3281b.floatValue();
            float fFloatValue2 = eVar2.f3281b.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    /* JADX INFO: compiled from: PerformanceTracker.java */
    public interface b {
        void a(float f2);
    }

    public void a(String str, float f2) {
        if (this.a) {
            com.airbnb.lottie.v.d dVar = this.f8553c.get(str);
            if (dVar == null) {
                dVar = new com.airbnb.lottie.v.d();
                this.f8553c.put(str, dVar);
            }
            dVar.a(f2);
            if (str.equals("__container")) {
                Iterator<b> it = this.f8552b.iterator();
                while (it.hasNext()) {
                    it.next().a(f2);
                }
            }
        }
    }

    void b(boolean z) {
        this.a = z;
    }
}
