package androidx.recyclerview.widget;

/* JADX INFO: compiled from: ViewInfoStore.java */
/* JADX INFO: loaded from: classes.dex */
class t {
    final c.e.g<RecyclerView.c0, a> a = new c.e.g<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final c.e.d<RecyclerView.c0> f2108b = new c.e.d<>();

    /* JADX INFO: compiled from: ViewInfoStore.java */
    static class a {
        static c.i.j.f<a> a = new c.i.j.g(20);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2109b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        RecyclerView.l.c f2110c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        RecyclerView.l.c f2111d;

        private a() {
        }

        static void a() {
            while (a.b() != null) {
            }
        }

        static a b() {
            a aVarB = a.b();
            return aVarB == null ? new a() : aVarB;
        }

        static void c(a aVar) {
            aVar.f2109b = 0;
            aVar.f2110c = null;
            aVar.f2111d = null;
            a.a(aVar);
        }
    }

    /* JADX INFO: compiled from: ViewInfoStore.java */
    interface b {
        void a(RecyclerView.c0 c0Var);

        void b(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.c0 c0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    t() {
    }

    private RecyclerView.l.c l(RecyclerView.c0 c0Var, int i2) {
        a aVarN;
        RecyclerView.l.c cVar;
        int iF = this.a.f(c0Var);
        if (iF >= 0 && (aVarN = this.a.n(iF)) != null) {
            int i3 = aVarN.f2109b;
            if ((i3 & i2) != 0) {
                int i4 = (i2 ^ (-1)) & i3;
                aVarN.f2109b = i4;
                if (i2 == 4) {
                    cVar = aVarN.f2110c;
                } else {
                    if (i2 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVarN.f2111d;
                }
                if ((i4 & 12) == 0) {
                    this.a.l(iF);
                    a.c(aVarN);
                }
                return cVar;
            }
        }
        return null;
    }

    void a(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVarB = this.a.get(c0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(c0Var, aVarB);
        }
        aVarB.f2109b |= 2;
        aVarB.f2110c = cVar;
    }

    void b(RecyclerView.c0 c0Var) {
        a aVarB = this.a.get(c0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(c0Var, aVarB);
        }
        aVarB.f2109b |= 1;
    }

    void c(long j2, RecyclerView.c0 c0Var) {
        this.f2108b.k(j2, c0Var);
    }

    void d(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVarB = this.a.get(c0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(c0Var, aVarB);
        }
        aVarB.f2111d = cVar;
        aVarB.f2109b |= 8;
    }

    void e(RecyclerView.c0 c0Var, RecyclerView.l.c cVar) {
        a aVarB = this.a.get(c0Var);
        if (aVarB == null) {
            aVarB = a.b();
            this.a.put(c0Var, aVarB);
        }
        aVarB.f2110c = cVar;
        aVarB.f2109b |= 4;
    }

    void f() {
        this.a.clear();
        this.f2108b.d();
    }

    RecyclerView.c0 g(long j2) {
        return this.f2108b.g(j2);
    }

    boolean h(RecyclerView.c0 c0Var) {
        a aVar = this.a.get(c0Var);
        return (aVar == null || (aVar.f2109b & 1) == 0) ? false : true;
    }

    boolean i(RecyclerView.c0 c0Var) {
        a aVar = this.a.get(c0Var);
        return (aVar == null || (aVar.f2109b & 4) == 0) ? false : true;
    }

    void j() {
        a.a();
    }

    public void k(RecyclerView.c0 c0Var) {
        p(c0Var);
    }

    RecyclerView.l.c m(RecyclerView.c0 c0Var) {
        return l(c0Var, 8);
    }

    RecyclerView.l.c n(RecyclerView.c0 c0Var) {
        return l(c0Var, 4);
    }

    void o(b bVar) {
        for (int size = this.a.size() - 1; size >= 0; size--) {
            RecyclerView.c0 c0VarJ = this.a.j(size);
            a aVarL = this.a.l(size);
            int i2 = aVarL.f2109b;
            if ((i2 & 3) == 3) {
                bVar.a(c0VarJ);
            } else if ((i2 & 1) != 0) {
                RecyclerView.l.c cVar = aVarL.f2110c;
                if (cVar == null) {
                    bVar.a(c0VarJ);
                } else {
                    bVar.c(c0VarJ, cVar, aVarL.f2111d);
                }
            } else if ((i2 & 14) == 14) {
                bVar.b(c0VarJ, aVarL.f2110c, aVarL.f2111d);
            } else if ((i2 & 12) == 12) {
                bVar.d(c0VarJ, aVarL.f2110c, aVarL.f2111d);
            } else if ((i2 & 4) != 0) {
                bVar.c(c0VarJ, aVarL.f2110c, null);
            } else if ((i2 & 8) != 0) {
                bVar.b(c0VarJ, aVarL.f2110c, aVarL.f2111d);
            }
            a.c(aVarL);
        }
    }

    void p(RecyclerView.c0 c0Var) {
        a aVar = this.a.get(c0Var);
        if (aVar == null) {
            return;
        }
        aVar.f2109b &= -2;
    }

    void q(RecyclerView.c0 c0Var) {
        for (int iN = this.f2108b.n() - 1; iN >= 0; iN--) {
            if (c0Var == this.f2108b.o(iN)) {
                this.f2108b.m(iN);
                break;
            }
        }
        a aVarRemove = this.a.remove(c0Var);
        if (aVarRemove != null) {
            a.c(aVarRemove);
        }
    }
}
