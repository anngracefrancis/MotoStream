package c.g.b.k.m;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: DependencyNode.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    p f3106d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f3108f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f3109g;
    public d a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f3104b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3105c = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    a f3107e = a.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    int f3110h = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    g f3111i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f3112j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    List<d> f3113k = new ArrayList();
    List<f> l = new ArrayList();

    /* JADX INFO: compiled from: DependencyNode.java */
    enum a {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public f(p pVar) {
        this.f3106d = pVar;
    }

    @Override // c.g.b.k.m.d
    public void a(d dVar) {
        Iterator<f> it = this.l.iterator();
        while (it.hasNext()) {
            if (!it.next().f3112j) {
                return;
            }
        }
        this.f3105c = true;
        d dVar2 = this.a;
        if (dVar2 != null) {
            dVar2.a(this);
        }
        if (this.f3104b) {
            this.f3106d.a(this);
            return;
        }
        f fVar = null;
        int i2 = 0;
        for (f fVar2 : this.l) {
            if (!(fVar2 instanceof g)) {
                i2++;
                fVar = fVar2;
            }
        }
        if (fVar != null && i2 == 1 && fVar.f3112j) {
            g gVar = this.f3111i;
            if (gVar != null) {
                if (!gVar.f3112j) {
                    return;
                } else {
                    this.f3108f = this.f3110h * gVar.f3109g;
                }
            }
            d(fVar.f3109g + this.f3108f);
        }
        d dVar3 = this.a;
        if (dVar3 != null) {
            dVar3.a(this);
        }
    }

    public void b(d dVar) {
        this.f3113k.add(dVar);
        if (this.f3112j) {
            dVar.a(dVar);
        }
    }

    public void c() {
        this.l.clear();
        this.f3113k.clear();
        this.f3112j = false;
        this.f3109g = 0;
        this.f3105c = false;
        this.f3104b = false;
    }

    public void d(int i2) {
        if (this.f3112j) {
            return;
        }
        this.f3112j = true;
        this.f3109g = i2;
        for (d dVar : this.f3113k) {
            dVar.a(dVar);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3106d.f3142b.r());
        sb.append(":");
        sb.append(this.f3107e);
        sb.append("(");
        sb.append(this.f3112j ? Integer.valueOf(this.f3109g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.f3113k.size());
        sb.append(">");
        return sb.toString();
    }
}
