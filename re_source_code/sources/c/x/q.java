package c.x;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: TransitionSet.java */
/* JADX INFO: loaded from: classes.dex */
public class q extends m {
    int R;
    private ArrayList<m> P = new ArrayList<>();
    private boolean Q = true;
    boolean S = false;
    private int T = 0;

    /* JADX INFO: compiled from: TransitionSet.java */
    class a extends n {
        final /* synthetic */ m a;

        a(m mVar) {
            this.a = mVar;
        }

        @Override // c.x.m.f
        public void c(m mVar) {
            this.a.Z();
            mVar.T(this);
        }
    }

    /* JADX INFO: compiled from: TransitionSet.java */
    static class b extends n {
        q a;

        b(q qVar) {
            this.a = qVar;
        }

        @Override // c.x.n, c.x.m.f
        public void a(m mVar) {
            q qVar = this.a;
            if (qVar.S) {
                return;
            }
            qVar.h0();
            this.a.S = true;
        }

        @Override // c.x.m.f
        public void c(m mVar) {
            q qVar = this.a;
            int i2 = qVar.R - 1;
            qVar.R = i2;
            if (i2 == 0) {
                qVar.S = false;
                qVar.q();
            }
            mVar.T(this);
        }
    }

    private void n0(m mVar) {
        this.P.add(mVar);
        mVar.z = this;
    }

    private void x0() {
        b bVar = new b(this);
        Iterator<m> it = this.P.iterator();
        while (it.hasNext()) {
            it.next().b(bVar);
        }
        this.R = this.P.size();
    }

    @Override // c.x.m
    public void R(View view) {
        super.R(view);
        int size = this.P.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.P.get(i2).R(view);
        }
    }

    @Override // c.x.m
    public void V(View view) {
        super.V(view);
        int size = this.P.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.P.get(i2).V(view);
        }
    }

    @Override // c.x.m
    protected void Z() {
        if (this.P.isEmpty()) {
            h0();
            q();
            return;
        }
        x0();
        if (this.Q) {
            Iterator<m> it = this.P.iterator();
            while (it.hasNext()) {
                it.next().Z();
            }
            return;
        }
        for (int i2 = 1; i2 < this.P.size(); i2++) {
            this.P.get(i2 - 1).b(new a(this.P.get(i2)));
        }
        m mVar = this.P.get(0);
        if (mVar != null) {
            mVar.Z();
        }
    }

    @Override // c.x.m
    public void b0(m.e eVar) {
        super.b0(eVar);
        this.T |= 8;
        int size = this.P.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.P.get(i2).b0(eVar);
        }
    }

    @Override // c.x.m
    public void d0(g gVar) {
        super.d0(gVar);
        this.T |= 4;
        if (this.P != null) {
            for (int i2 = 0; i2 < this.P.size(); i2++) {
                this.P.get(i2).d0(gVar);
            }
        }
    }

    @Override // c.x.m
    public void f0(p pVar) {
        super.f0(pVar);
        this.T |= 2;
        int size = this.P.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.P.get(i2).f0(pVar);
        }
    }

    @Override // c.x.m
    public void h(s sVar) {
        if (K(sVar.f3608b)) {
            for (m mVar : this.P) {
                if (mVar.K(sVar.f3608b)) {
                    mVar.h(sVar);
                    sVar.f3609c.add(mVar);
                }
            }
        }
    }

    @Override // c.x.m
    void j(s sVar) {
        super.j(sVar);
        int size = this.P.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.P.get(i2).j(sVar);
        }
    }

    @Override // c.x.m
    String j0(String str) {
        String strJ0 = super.j0(str);
        for (int i2 = 0; i2 < this.P.size(); i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strJ0);
            sb.append("\n");
            sb.append(this.P.get(i2).j0(str + "  "));
            strJ0 = sb.toString();
        }
        return strJ0;
    }

    @Override // c.x.m
    public void k(s sVar) {
        if (K(sVar.f3608b)) {
            for (m mVar : this.P) {
                if (mVar.K(sVar.f3608b)) {
                    mVar.k(sVar);
                    sVar.f3609c.add(mVar);
                }
            }
        }
    }

    @Override // c.x.m
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public q b(m.f fVar) {
        return (q) super.b(fVar);
    }

    @Override // c.x.m
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public q d(View view) {
        for (int i2 = 0; i2 < this.P.size(); i2++) {
            this.P.get(i2).d(view);
        }
        return (q) super.d(view);
    }

    public q m0(m mVar) {
        n0(mVar);
        long j2 = this.f3594k;
        if (j2 >= 0) {
            mVar.a0(j2);
        }
        if ((this.T & 1) != 0) {
            mVar.c0(t());
        }
        if ((this.T & 2) != 0) {
            mVar.f0(A());
        }
        if ((this.T & 4) != 0) {
            mVar.d0(w());
        }
        if ((this.T & 8) != 0) {
            mVar.b0(s());
        }
        return this;
    }

    @Override // c.x.m
    /* JADX INFO: renamed from: n */
    public m clone() {
        q qVar = (q) super.clone();
        qVar.P = new ArrayList<>();
        int size = this.P.size();
        for (int i2 = 0; i2 < size; i2++) {
            qVar.n0(this.P.get(i2).clone());
        }
        return qVar;
    }

    public m o0(int i2) {
        if (i2 < 0 || i2 >= this.P.size()) {
            return null;
        }
        return this.P.get(i2);
    }

    @Override // c.x.m
    protected void p(ViewGroup viewGroup, t tVar, t tVar2, ArrayList<s> arrayList, ArrayList<s> arrayList2) {
        long jC = C();
        int size = this.P.size();
        for (int i2 = 0; i2 < size; i2++) {
            m mVar = this.P.get(i2);
            if (jC > 0 && (this.Q || i2 == 0)) {
                long jC2 = mVar.C();
                if (jC2 > 0) {
                    mVar.g0(jC2 + jC);
                } else {
                    mVar.g0(jC);
                }
            }
            mVar.p(viewGroup, tVar, tVar2, arrayList, arrayList2);
        }
    }

    public int q0() {
        return this.P.size();
    }

    @Override // c.x.m
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public q T(m.f fVar) {
        return (q) super.T(fVar);
    }

    @Override // c.x.m
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public q U(View view) {
        for (int i2 = 0; i2 < this.P.size(); i2++) {
            this.P.get(i2).U(view);
        }
        return (q) super.U(view);
    }

    @Override // c.x.m
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public q a0(long j2) {
        ArrayList<m> arrayList;
        super.a0(j2);
        if (this.f3594k >= 0 && (arrayList = this.P) != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.P.get(i2).a0(j2);
            }
        }
        return this;
    }

    @Override // c.x.m
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public q c0(TimeInterpolator timeInterpolator) {
        this.T |= 1;
        ArrayList<m> arrayList = this.P;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.P.get(i2).c0(timeInterpolator);
            }
        }
        return (q) super.c0(timeInterpolator);
    }

    public q v0(int i2) {
        if (i2 == 0) {
            this.Q = true;
        } else {
            if (i2 != 1) {
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i2);
            }
            this.Q = false;
        }
        return this;
    }

    @Override // c.x.m
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public q g0(long j2) {
        return (q) super.g0(j2);
    }
}
