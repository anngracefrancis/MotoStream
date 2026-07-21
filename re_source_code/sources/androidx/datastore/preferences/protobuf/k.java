package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: CodedInputStreamReader.java */
/* JADX INFO: loaded from: classes.dex */
final class k implements e1 {
    private final j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1361d = 0;

    /* JADX INFO: compiled from: CodedInputStreamReader.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r1.b.values().length];
            a = iArr;
            try {
                iArr[r1.b.m.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r1.b.q.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r1.b.f1397f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r1.b.s.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r1.b.l.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r1.b.f1402k.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r1.b.f1398g.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r1.b.f1401j.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r1.b.f1399h.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r1.b.p.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r1.b.t.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r1.b.u.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[r1.b.v.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[r1.b.w.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[r1.b.n.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[r1.b.r.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[r1.b.f1400i.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private k(j jVar) {
        j jVar2 = (j) a0.b(jVar, "input");
        this.a = jVar2;
        jVar2.f1336d = this;
    }

    public static k P(j jVar) {
        k kVar = jVar.f1336d;
        return kVar != null ? kVar : new k(jVar);
    }

    private Object Q(r1.b bVar, Class<?> cls, p pVar) throws IOException {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(l());
            case 2:
                return C();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(v());
            case 5:
                return Integer.valueOf(k());
            case 6:
                return Long.valueOf(f());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(E());
            case 9:
                return Long.valueOf(L());
            case 10:
                return g(cls, pVar);
            case 11:
                return Integer.valueOf(H());
            case 12:
                return Long.valueOf(m());
            case 13:
                return Integer.valueOf(x());
            case 14:
                return Long.valueOf(y());
            case 15:
                return M();
            case 16:
                return Integer.valueOf(p());
            case 17:
                return Long.valueOf(e());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private <T> T R(f1<T> f1Var, p pVar) throws IOException {
        int i2 = this.f1360c;
        this.f1360c = r1.c(r1.a(this.f1359b), 4);
        try {
            T tC = f1Var.c();
            f1Var.e(tC, this, pVar);
            f1Var.f(tC);
            if (this.f1359b != this.f1360c) {
                throw InvalidProtocolBufferException.g();
            }
            this.f1360c = i2;
            return tC;
        } catch (Throwable th) {
            this.f1360c = i2;
            throw th;
        }
    }

    private <T> T S(f1<T> f1Var, p pVar) throws IOException {
        int iC = this.a.C();
        j jVar = this.a;
        if (jVar.a >= jVar.f1334b) {
            throw InvalidProtocolBufferException.h();
        }
        int iL = jVar.l(iC);
        T tC = f1Var.c();
        this.a.a++;
        f1Var.e(tC, this, pVar);
        f1Var.f(tC);
        this.a.a(0);
        j jVar2 = this.a;
        jVar2.a--;
        jVar2.k(iL);
        return tC;
    }

    private void U(int i2) throws IOException {
        if (this.a.d() != i2) {
            throw InvalidProtocolBufferException.k();
        }
    }

    private void V(int i2) throws IOException {
        if (r1.b(this.f1359b) != i2) {
            throw InvalidProtocolBufferException.d();
        }
    }

    private void W(int i2) throws IOException {
        if ((i2 & 3) != 0) {
            throw InvalidProtocolBufferException.g();
        }
    }

    private void X(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw InvalidProtocolBufferException.g();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public int A() throws IOException {
        int i2 = this.f1361d;
        if (i2 != 0) {
            this.f1359b = i2;
            this.f1361d = 0;
        } else {
            this.f1359b = this.a.B();
        }
        int i3 = this.f1359b;
        if (i3 == 0 || i3 == this.f1360c) {
            return Integer.MAX_VALUE;
        }
        return r1.a(i3);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void B(List<String> list) throws IOException {
        T(list, true);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public h C() throws IOException {
        V(2);
        return this.a.n();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void D(List<Float> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof w)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 2) {
                int iC = this.a.C();
                W(iC);
                int iD = this.a.d() + iC;
                do {
                    list.add(Float.valueOf(this.a.s()));
                } while (this.a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Float.valueOf(this.a.s()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.f1359b);
            this.f1361d = iB;
            return;
        }
        w wVar = (w) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 2) {
            int iC2 = this.a.C();
            W(iC2);
            int iD2 = this.a.d() + iC2;
            do {
                wVar.h(this.a.s());
            } while (this.a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            wVar.h(this.a.s());
            if (this.a.e()) {
                return;
            } else {
                iB2 = this.a.B();
            }
        } while (iB2 == this.f1359b);
        this.f1361d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public int E() throws IOException {
        V(0);
        return this.a.t();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.e1
    public <T> void F(List<T> list, f1<T> f1Var, p pVar) throws IOException {
        int iB;
        if (r1.b(this.f1359b) != 3) {
            throw InvalidProtocolBufferException.d();
        }
        int i2 = this.f1359b;
        do {
            list.add(R(f1Var, pVar));
            if (this.a.e() || this.f1361d != 0) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == i2);
        this.f1361d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public boolean G() throws IOException {
        int i2;
        if (this.a.e() || (i2 = this.f1359b) == this.f1360c) {
            return false;
        }
        return this.a.E(i2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public int H() throws IOException {
        V(5);
        return this.a.v();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void I(List<h> list) throws IOException {
        int iB;
        if (r1.b(this.f1359b) != 2) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            list.add(C());
            if (this.a.e()) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == this.f1359b);
        this.f1361d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void J(List<Double> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof m)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 1) {
                do {
                    list.add(Double.valueOf(this.a.o()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.f1359b);
                this.f1361d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iC = this.a.C();
            X(iC);
            int iD = this.a.d() + iC;
            do {
                list.add(Double.valueOf(this.a.o()));
            } while (this.a.d() < iD);
            return;
        }
        m mVar = (m) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 1) {
            do {
                mVar.h(this.a.o());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.f1359b);
            this.f1361d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iC2 = this.a.C();
        X(iC2);
        int iD2 = this.a.d() + iC2;
        do {
            mVar.h(this.a.o());
        } while (this.a.d() < iD2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.e1
    public <T> void K(List<T> list, f1<T> f1Var, p pVar) throws IOException {
        int iB;
        if (r1.b(this.f1359b) != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int i2 = this.f1359b;
        do {
            list.add(S(f1Var, pVar));
            if (this.a.e() || this.f1361d != 0) {
                return;
            } else {
                iB = this.a.B();
            }
        } while (iB == i2);
        this.f1361d = iB;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public long L() throws IOException {
        V(0);
        return this.a.u();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public String M() throws IOException {
        V(2);
        return this.a.A();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void N(List<Long> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof h0)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 1) {
                do {
                    list.add(Long.valueOf(this.a.r()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.f1359b);
                this.f1361d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iC = this.a.C();
            X(iC);
            int iD = this.a.d() + iC;
            do {
                list.add(Long.valueOf(this.a.r()));
            } while (this.a.d() < iD);
            return;
        }
        h0 h0Var = (h0) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 1) {
            do {
                h0Var.i(this.a.r());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.f1359b);
            this.f1361d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iC2 = this.a.C();
        X(iC2);
        int iD2 = this.a.d() + iC2;
        do {
            h0Var.i(this.a.r());
        } while (this.a.d() < iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public <T> T O(f1<T> f1Var, p pVar) throws IOException {
        V(3);
        return (T) R(f1Var, pVar);
    }

    public void T(List<String> list, boolean z) throws IOException {
        int iB;
        int iB2;
        if (r1.b(this.f1359b) != 2) {
            throw InvalidProtocolBufferException.d();
        }
        if (!(list instanceof f0) || z) {
            do {
                list.add(z ? M() : a());
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.f1359b);
            this.f1361d = iB;
            return;
        }
        f0 f0Var = (f0) list;
        do {
            f0Var.a0(C());
            if (this.a.e()) {
                return;
            } else {
                iB2 = this.a.B();
            }
        } while (iB2 == this.f1359b);
        this.f1361d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public String a() throws IOException {
        V(2);
        return this.a.z();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void b(List<String> list) throws IOException {
        T(list, false);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public <T> T c(f1<T> f1Var, p pVar) throws IOException {
        V(2);
        return (T) S(f1Var, pVar);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void d(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof z)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.x()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.f1359b);
                this.f1361d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Integer.valueOf(this.a.x()));
            } while (this.a.d() < iD);
            U(iD);
            return;
        }
        z zVar = (z) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 0) {
            do {
                zVar.h(this.a.x());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.f1359b);
            this.f1361d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            zVar.h(this.a.x());
        } while (this.a.d() < iD2);
        U(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public long e() throws IOException {
        V(0);
        return this.a.D();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public long f() throws IOException {
        V(1);
        return this.a.r();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public <T> T g(Class<T> cls, p pVar) throws IOException {
        V(2);
        return (T) S(b1.a().d(cls), pVar);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public int getTag() {
        return this.f1359b;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void h(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof z)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 2) {
                int iC = this.a.C();
                W(iC);
                int iD = this.a.d() + iC;
                do {
                    list.add(Integer.valueOf(this.a.v()));
                } while (this.a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Integer.valueOf(this.a.v()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.f1359b);
            this.f1361d = iB;
            return;
        }
        z zVar = (z) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 2) {
            int iC2 = this.a.C();
            W(iC2);
            int iD2 = this.a.d() + iC2;
            do {
                zVar.h(this.a.v());
            } while (this.a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            zVar.h(this.a.v());
            if (this.a.e()) {
                return;
            } else {
                iB2 = this.a.B();
            }
        } while (iB2 == this.f1359b);
        this.f1361d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void i(List<Long> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof h0)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.a.y()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.f1359b);
                this.f1361d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Long.valueOf(this.a.y()));
            } while (this.a.d() < iD);
            U(iD);
            return;
        }
        h0 h0Var = (h0) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 0) {
            do {
                h0Var.i(this.a.y());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.f1359b);
            this.f1361d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            h0Var.i(this.a.y());
        } while (this.a.d() < iD2);
        U(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void j(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof z)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.C()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.f1359b);
                this.f1361d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Integer.valueOf(this.a.C()));
            } while (this.a.d() < iD);
            U(iD);
            return;
        }
        z zVar = (z) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 0) {
            do {
                zVar.h(this.a.C());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.f1359b);
            this.f1361d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            zVar.h(this.a.C());
        } while (this.a.d() < iD2);
        U(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public int k() throws IOException {
        V(5);
        return this.a.q();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public boolean l() throws IOException {
        V(0);
        return this.a.m();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public long m() throws IOException {
        V(1);
        return this.a.w();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void n(List<Long> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof h0)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.a.D()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.f1359b);
                this.f1361d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Long.valueOf(this.a.D()));
            } while (this.a.d() < iD);
            U(iD);
            return;
        }
        h0 h0Var = (h0) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 0) {
            do {
                h0Var.i(this.a.D());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.f1359b);
            this.f1361d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            h0Var.i(this.a.D());
        } while (this.a.d() < iD2);
        U(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public <T> T o(Class<T> cls, p pVar) throws IOException {
        V(3);
        return (T) R(b1.a().d(cls), pVar);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public int p() throws IOException {
        V(0);
        return this.a.C();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void q(List<Long> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof h0)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 0) {
                do {
                    list.add(Long.valueOf(this.a.u()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.f1359b);
                this.f1361d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Long.valueOf(this.a.u()));
            } while (this.a.d() < iD);
            U(iD);
            return;
        }
        h0 h0Var = (h0) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 0) {
            do {
                h0Var.i(this.a.u());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.f1359b);
            this.f1361d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            h0Var.i(this.a.u());
        } while (this.a.d() < iD2);
        U(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void r(List<Long> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof h0)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 1) {
                do {
                    list.add(Long.valueOf(this.a.w()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.f1359b);
                this.f1361d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iC = this.a.C();
            X(iC);
            int iD = this.a.d() + iC;
            do {
                list.add(Long.valueOf(this.a.w()));
            } while (this.a.d() < iD);
            return;
        }
        h0 h0Var = (h0) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 1) {
            do {
                h0Var.i(this.a.w());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.f1359b);
            this.f1361d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iC2 = this.a.C();
        X(iC2);
        int iD2 = this.a.d() + iC2;
        do {
            h0Var.i(this.a.w());
        } while (this.a.d() < iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public double readDouble() throws IOException {
        V(1);
        return this.a.o();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public float readFloat() throws IOException {
        V(5);
        return this.a.s();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void s(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof z)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.t()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.f1359b);
                this.f1361d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Integer.valueOf(this.a.t()));
            } while (this.a.d() < iD);
            U(iD);
            return;
        }
        z zVar = (z) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 0) {
            do {
                zVar.h(this.a.t());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.f1359b);
            this.f1361d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            zVar.h(this.a.t());
        } while (this.a.d() < iD2);
        U(iD2);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void t(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof z)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.p()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.f1359b);
                this.f1361d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Integer.valueOf(this.a.p()));
            } while (this.a.d() < iD);
            U(iD);
            return;
        }
        z zVar = (z) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 0) {
            do {
                zVar.h(this.a.p());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.f1359b);
            this.f1361d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            zVar.h(this.a.p());
        } while (this.a.d() < iD2);
        U(iD2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.e1
    public <K, V> void u(Map<K, V> map, j0.a<K, V> aVar, p pVar) throws IOException {
        V(2);
        int iL = this.a.l(this.a.C());
        Object objQ = aVar.f1352b;
        Object objQ2 = aVar.f1354d;
        while (true) {
            try {
                int iA = A();
                if (iA == Integer.MAX_VALUE || this.a.e()) {
                    break;
                }
                if (iA == 1) {
                    objQ = Q(aVar.a, null, null);
                } else if (iA != 2) {
                    try {
                        if (!G()) {
                            throw new InvalidProtocolBufferException("Unable to parse map entry.");
                        }
                    } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                        if (!G()) {
                            throw new InvalidProtocolBufferException("Unable to parse map entry.");
                        }
                    }
                } else {
                    objQ2 = Q(aVar.f1353c, aVar.f1354d.getClass(), pVar);
                }
            } catch (Throwable th) {
                this.a.k(iL);
                throw th;
            }
        }
        map.put(objQ, objQ2);
        this.a.k(iL);
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public int v() throws IOException {
        V(0);
        return this.a.p();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void w(List<Integer> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof z)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 2) {
                int iC = this.a.C();
                W(iC);
                int iD = this.a.d() + iC;
                do {
                    list.add(Integer.valueOf(this.a.q()));
                } while (this.a.d() < iD);
                return;
            }
            if (iB3 != 5) {
                throw InvalidProtocolBufferException.d();
            }
            do {
                list.add(Integer.valueOf(this.a.q()));
                if (this.a.e()) {
                    return;
                } else {
                    iB = this.a.B();
                }
            } while (iB == this.f1359b);
            this.f1361d = iB;
            return;
        }
        z zVar = (z) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 2) {
            int iC2 = this.a.C();
            W(iC2);
            int iD2 = this.a.d() + iC2;
            do {
                zVar.h(this.a.q());
            } while (this.a.d() < iD2);
            return;
        }
        if (iB4 != 5) {
            throw InvalidProtocolBufferException.d();
        }
        do {
            zVar.h(this.a.q());
            if (this.a.e()) {
                return;
            } else {
                iB2 = this.a.B();
            }
        } while (iB2 == this.f1359b);
        this.f1361d = iB2;
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public int x() throws IOException {
        V(0);
        return this.a.x();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public long y() throws IOException {
        V(0);
        return this.a.y();
    }

    @Override // androidx.datastore.preferences.protobuf.e1
    public void z(List<Boolean> list) throws IOException {
        int iB;
        int iB2;
        if (!(list instanceof f)) {
            int iB3 = r1.b(this.f1359b);
            if (iB3 == 0) {
                do {
                    list.add(Boolean.valueOf(this.a.m()));
                    if (this.a.e()) {
                        return;
                    } else {
                        iB = this.a.B();
                    }
                } while (iB == this.f1359b);
                this.f1361d = iB;
                return;
            }
            if (iB3 != 2) {
                throw InvalidProtocolBufferException.d();
            }
            int iD = this.a.d() + this.a.C();
            do {
                list.add(Boolean.valueOf(this.a.m()));
            } while (this.a.d() < iD);
            U(iD);
            return;
        }
        f fVar = (f) list;
        int iB4 = r1.b(this.f1359b);
        if (iB4 == 0) {
            do {
                fVar.i(this.a.m());
                if (this.a.e()) {
                    return;
                } else {
                    iB2 = this.a.B();
                }
            } while (iB2 == this.f1359b);
            this.f1361d = iB2;
            return;
        }
        if (iB4 != 2) {
            throw InvalidProtocolBufferException.d();
        }
        int iD2 = this.a.d() + this.a.C();
        do {
            fVar.i(this.a.m());
        } while (this.a.d() < iD2);
        U(iD2);
    }
}
