package c.g.b.k;

/* JADX INFO: compiled from: Optimizer.java */
/* JADX INFO: loaded from: classes.dex */
public class j {
    static boolean[] a = new boolean[3];

    static void a(f fVar, c.g.b.d dVar, e eVar) {
        eVar.o = -1;
        eVar.p = -1;
        e.b bVar = fVar.T[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.T[0] == e.b.MATCH_PARENT) {
            int i2 = eVar.I.f3058g;
            int iR = fVar.R() - eVar.K.f3058g;
            d dVar2 = eVar.I;
            dVar2.f3060i = dVar.q(dVar2);
            d dVar3 = eVar.K;
            dVar3.f3060i = dVar.q(dVar3);
            dVar.f(eVar.I.f3060i, i2);
            dVar.f(eVar.K.f3060i, iR);
            eVar.o = 2;
            eVar.y0(i2, iR);
        }
        if (fVar.T[1] == bVar2 || eVar.T[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i3 = eVar.J.f3058g;
        int iV = fVar.v() - eVar.L.f3058g;
        d dVar4 = eVar.J;
        dVar4.f3060i = dVar.q(dVar4);
        d dVar5 = eVar.L;
        dVar5.f3060i = dVar.q(dVar5);
        dVar.f(eVar.J.f3060i, i3);
        dVar.f(eVar.L.f3060i, iV);
        if (eVar.f0 > 0 || eVar.Q() == 8) {
            d dVar6 = eVar.M;
            dVar6.f3060i = dVar.q(dVar6);
            dVar.f(eVar.M.f3060i, eVar.f0 + i3);
        }
        eVar.p = 2;
        eVar.P0(i3, iV);
    }

    public static final boolean b(int i2, int i3) {
        return (i2 & i3) == i3;
    }
}
