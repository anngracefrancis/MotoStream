package c.g.b.k.m;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: WidgetGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class o {
    static int a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f3130c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f3132e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<c.g.b.k.e> f3129b = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f3131d = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    ArrayList<a> f3133f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f3134g = -1;

    /* JADX INFO: compiled from: WidgetGroup.java */
    class a {
        WeakReference<c.g.b.k.e> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f3135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f3136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f3137d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f3138e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f3139f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        int f3140g;

        public a(c.g.b.k.e eVar, c.g.b.d dVar, int i2) {
            this.a = new WeakReference<>(eVar);
            this.f3135b = dVar.x(eVar.I);
            this.f3136c = dVar.x(eVar.J);
            this.f3137d = dVar.x(eVar.K);
            this.f3138e = dVar.x(eVar.L);
            this.f3139f = dVar.x(eVar.M);
            this.f3140g = i2;
        }
    }

    public o(int i2) {
        this.f3130c = -1;
        this.f3132e = 0;
        int i3 = a;
        a = i3 + 1;
        this.f3130c = i3;
        this.f3132e = i2;
    }

    private String e() {
        int i2 = this.f3132e;
        if (i2 == 0) {
            return "Horizontal";
        }
        if (i2 == 1) {
            return "Vertical";
        }
        return i2 == 2 ? "Both" : "Unknown";
    }

    private int j(c.g.b.d dVar, ArrayList<c.g.b.k.e> arrayList, int i2) {
        int iX;
        int iX2;
        c.g.b.k.f fVar = (c.g.b.k.f) arrayList.get(0).I();
        dVar.D();
        fVar.g(dVar, false);
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            arrayList.get(i3).g(dVar, false);
        }
        if (i2 == 0 && fVar.O0 > 0) {
            c.g.b.k.b.b(fVar, dVar, arrayList, 0);
        }
        if (i2 == 1 && fVar.P0 > 0) {
            c.g.b.k.b.b(fVar, dVar, arrayList, 1);
        }
        try {
            dVar.z();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.f3133f = new ArrayList<>();
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            this.f3133f.add(new a(arrayList.get(i4), dVar, i2));
        }
        if (i2 == 0) {
            iX = dVar.x(fVar.I);
            iX2 = dVar.x(fVar.K);
            dVar.D();
        } else {
            iX = dVar.x(fVar.J);
            iX2 = dVar.x(fVar.L);
            dVar.D();
        }
        return iX2 - iX;
    }

    public boolean a(c.g.b.k.e eVar) {
        if (this.f3129b.contains(eVar)) {
            return false;
        }
        this.f3129b.add(eVar);
        return true;
    }

    public void b(ArrayList<o> arrayList) {
        int size = this.f3129b.size();
        if (this.f3134g != -1 && size > 0) {
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                o oVar = arrayList.get(i2);
                if (this.f3134g == oVar.f3130c) {
                    g(this.f3132e, oVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public int c() {
        return this.f3130c;
    }

    public int d() {
        return this.f3132e;
    }

    public int f(c.g.b.d dVar, int i2) {
        if (this.f3129b.size() == 0) {
            return 0;
        }
        return j(dVar, this.f3129b, i2);
    }

    public void g(int i2, o oVar) {
        for (c.g.b.k.e eVar : this.f3129b) {
            oVar.a(eVar);
            if (i2 == 0) {
                eVar.B0 = oVar.c();
            } else {
                eVar.C0 = oVar.c();
            }
        }
        this.f3134g = oVar.f3130c;
    }

    public void h(boolean z) {
        this.f3131d = z;
    }

    public void i(int i2) {
        this.f3132e = i2;
    }

    public String toString() {
        String str = e() + " [" + this.f3130c + "] <";
        Iterator<c.g.b.k.e> it = this.f3129b.iterator();
        while (it.hasNext()) {
            str = str + " " + it.next().r();
        }
        return str + " >";
    }
}
