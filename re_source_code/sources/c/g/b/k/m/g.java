package c.g.b.k.m;

/* JADX INFO: compiled from: DimensionDependency.java */
/* JADX INFO: loaded from: classes.dex */
class g extends f {
    public int m;

    public g(p pVar) {
        super(pVar);
        if (pVar instanceof l) {
            this.f3107e = f.a.HORIZONTAL_DIMENSION;
        } else {
            this.f3107e = f.a.VERTICAL_DIMENSION;
        }
    }

    @Override // c.g.b.k.m.f
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
}
