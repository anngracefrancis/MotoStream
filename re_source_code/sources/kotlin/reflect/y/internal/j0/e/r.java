package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.p002reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.p002reflect.jvm.internal.impl.protobuf.d;
import kotlin.p002reflect.jvm.internal.impl.protobuf.e;
import kotlin.p002reflect.jvm.internal.impl.protobuf.f;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.p002reflect.jvm.internal.impl.protobuf.p;
import kotlin.p002reflect.jvm.internal.impl.protobuf.q;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends h.d<r> implements p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final r f24094h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static q<r> f24095i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f24096j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f24097k;
    private int l;
    private int m;
    private List<s> n;
    private q o;
    private int p;
    private q q;
    private int r;
    private List<kotlin.reflect.y.internal.j0.e.b> s;
    private List<Integer> t;
    private byte u;
    private int v;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<r> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public r b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new r(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h.c<r, b> implements p {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f24098i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f24100k;
        private int n;
        private int p;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f24099j = 6;
        private List<s> l = Collections.emptyList();
        private q m = q.Y();
        private q o = q.Y();
        private List<kotlin.reflect.y.internal.j0.e.b> q = Collections.emptyList();
        private List<Integer> r = Collections.emptyList();

        private b() {
            D();
        }

        private void A() {
            if ((this.f24098i & 128) != 128) {
                this.q = new ArrayList(this.q);
                this.f24098i |= 128;
            }
        }

        private void B() {
            if ((this.f24098i & 4) != 4) {
                this.l = new ArrayList(this.l);
                this.f24098i |= 4;
            }
        }

        private void C() {
            if ((this.f24098i & 256) != 256) {
                this.r = new ArrayList(this.r);
                this.f24098i |= 256;
            }
        }

        private void D() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b w() {
            return new b();
        }

        public b E(q qVar) {
            if ((this.f24098i & 32) != 32 || this.o == q.Y()) {
                this.o = qVar;
            } else {
                this.o = q.z0(this.o).m(qVar).u();
            }
            this.f24098i |= 32;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public b m(r rVar) {
            if (rVar == r.R()) {
                return this;
            }
            if (rVar.g0()) {
                J(rVar.V());
            }
            if (rVar.h0()) {
                K(rVar.X());
            }
            if (!rVar.n.isEmpty()) {
                if (this.l.isEmpty()) {
                    this.l = rVar.n;
                    this.f24098i &= -5;
                } else {
                    B();
                    this.l.addAll(rVar.n);
                }
            }
            if (rVar.i0()) {
                H(rVar.b0());
            }
            if (rVar.j0()) {
                L(rVar.c0());
            }
            if (rVar.e0()) {
                E(rVar.T());
            }
            if (rVar.f0()) {
                I(rVar.U());
            }
            if (!rVar.s.isEmpty()) {
                if (this.q.isEmpty()) {
                    this.q = rVar.s;
                    this.f24098i &= -129;
                } else {
                    A();
                    this.q.addAll(rVar.s);
                }
            }
            if (!rVar.t.isEmpty()) {
                if (this.r.isEmpty()) {
                    this.r = rVar.t;
                    this.f24098i &= -257;
                } else {
                    C();
                    this.r.addAll(rVar.t);
                }
            }
            r(rVar);
            n(l().f(rVar.f24096j));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public b i(e eVar, f fVar) throws Throwable {
            r rVar = null;
            try {
                try {
                    r rVarB = r.f24095i.b(eVar, fVar);
                    if (rVarB != null) {
                        m(rVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    r rVar2 = (r) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        rVar = rVar2;
                        if (rVar != null) {
                            m(rVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (rVar != null) {
                    m(rVar);
                }
                throw th;
            }
        }

        public b H(q qVar) {
            if ((this.f24098i & 8) != 8 || this.m == q.Y()) {
                this.m = qVar;
            } else {
                this.m = q.z0(this.m).m(qVar).u();
            }
            this.f24098i |= 8;
            return this;
        }

        public b I(int i2) {
            this.f24098i |= 64;
            this.p = i2;
            return this;
        }

        public b J(int i2) {
            this.f24098i |= 1;
            this.f24099j = i2;
            return this;
        }

        public b K(int i2) {
            this.f24098i |= 2;
            this.f24100k = i2;
            return this;
        }

        public b L(int i2) {
            this.f24098i |= 16;
            this.n = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public r c() {
            r rVarU = u();
            if (rVarU.isInitialized()) {
                return rVarU;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(rVarU);
        }

        public r u() {
            r rVar = new r(this);
            int i2 = this.f24098i;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            rVar.l = this.f24099j;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            rVar.m = this.f24100k;
            if ((this.f24098i & 4) == 4) {
                this.l = Collections.unmodifiableList(this.l);
                this.f24098i &= -5;
            }
            rVar.n = this.l;
            if ((i2 & 8) == 8) {
                i3 |= 4;
            }
            rVar.o = this.m;
            if ((i2 & 16) == 16) {
                i3 |= 8;
            }
            rVar.p = this.n;
            if ((i2 & 32) == 32) {
                i3 |= 16;
            }
            rVar.q = this.o;
            if ((i2 & 64) == 64) {
                i3 |= 32;
            }
            rVar.r = this.p;
            if ((this.f24098i & 128) == 128) {
                this.q = Collections.unmodifiableList(this.q);
                this.f24098i &= -129;
            }
            rVar.s = this.q;
            if ((this.f24098i & 256) == 256) {
                this.r = Collections.unmodifiableList(this.r);
                this.f24098i &= -257;
            }
            rVar.t = this.r;
            rVar.f24097k = i3;
            return rVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    static {
        r rVar = new r(true);
        f24094h = rVar;
        rVar.k0();
    }

    public static r R() {
        return f24094h;
    }

    private void k0() {
        this.l = 6;
        this.m = 0;
        this.n = Collections.emptyList();
        this.o = q.Y();
        this.p = 0;
        this.q = q.Y();
        this.r = 0;
        this.s = Collections.emptyList();
        this.t = Collections.emptyList();
    }

    public static b l0() {
        return b.w();
    }

    public static b m0(r rVar) {
        return l0().m(rVar);
    }

    public static r o0(InputStream inputStream, f fVar) throws IOException {
        return f24095i.c(inputStream, fVar);
    }

    public kotlin.reflect.y.internal.j0.e.b O(int i2) {
        return this.s.get(i2);
    }

    public int P() {
        return this.s.size();
    }

    public List<kotlin.reflect.y.internal.j0.e.b> Q() {
        return this.s;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public r b() {
        return f24094h;
    }

    public q T() {
        return this.q;
    }

    public int U() {
        return this.r;
    }

    public int V() {
        return this.l;
    }

    public int X() {
        return this.m;
    }

    public s Y(int i2) {
        return this.n.get(i2);
    }

    public int Z() {
        return this.n.size();
    }

    public List<s> a0() {
        return this.n;
    }

    public q b0() {
        return this.o;
    }

    public int c0() {
        return this.p;
    }

    public List<Integer> d0() {
        return this.t;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.v;
        if (i2 != -1) {
            return i2;
        }
        int iO = (this.f24097k & 1) == 1 ? CodedOutputStream.o(1, this.l) + 0 : 0;
        if ((this.f24097k & 2) == 2) {
            iO += CodedOutputStream.o(2, this.m);
        }
        for (int i3 = 0; i3 < this.n.size(); i3++) {
            iO += CodedOutputStream.s(3, this.n.get(i3));
        }
        if ((this.f24097k & 4) == 4) {
            iO += CodedOutputStream.s(4, this.o);
        }
        if ((this.f24097k & 8) == 8) {
            iO += CodedOutputStream.o(5, this.p);
        }
        if ((this.f24097k & 16) == 16) {
            iO += CodedOutputStream.s(6, this.q);
        }
        if ((this.f24097k & 32) == 32) {
            iO += CodedOutputStream.o(7, this.r);
        }
        for (int i4 = 0; i4 < this.s.size(); i4++) {
            iO += CodedOutputStream.s(8, this.s.get(i4));
        }
        int iP = 0;
        for (int i5 = 0; i5 < this.t.size(); i5++) {
            iP += CodedOutputStream.p(this.t.get(i5).intValue());
        }
        int size = iO + iP + (d0().size() * 2) + t() + this.f24096j.size();
        this.v = size;
        return size;
    }

    public boolean e0() {
        return (this.f24097k & 16) == 16;
    }

    public boolean f0() {
        return (this.f24097k & 32) == 32;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<r> g() {
        return f24095i;
    }

    public boolean g0() {
        return (this.f24097k & 1) == 1;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a aVarY = y();
        if ((this.f24097k & 1) == 1) {
            codedOutputStream.a0(1, this.l);
        }
        if ((this.f24097k & 2) == 2) {
            codedOutputStream.a0(2, this.m);
        }
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            codedOutputStream.d0(3, this.n.get(i2));
        }
        if ((this.f24097k & 4) == 4) {
            codedOutputStream.d0(4, this.o);
        }
        if ((this.f24097k & 8) == 8) {
            codedOutputStream.a0(5, this.p);
        }
        if ((this.f24097k & 16) == 16) {
            codedOutputStream.d0(6, this.q);
        }
        if ((this.f24097k & 32) == 32) {
            codedOutputStream.a0(7, this.r);
        }
        for (int i3 = 0; i3 < this.s.size(); i3++) {
            codedOutputStream.d0(8, this.s.get(i3));
        }
        for (int i4 = 0; i4 < this.t.size(); i4++) {
            codedOutputStream.a0(31, this.t.get(i4).intValue());
        }
        aVarY.a(200, codedOutputStream);
        codedOutputStream.i0(this.f24096j);
    }

    public boolean h0() {
        return (this.f24097k & 2) == 2;
    }

    public boolean i0() {
        return (this.f24097k & 4) == 4;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.u;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!h0()) {
            this.u = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < Z(); i2++) {
            if (!Y(i2).isInitialized()) {
                this.u = (byte) 0;
                return false;
            }
        }
        if (i0() && !b0().isInitialized()) {
            this.u = (byte) 0;
            return false;
        }
        if (e0() && !T().isInitialized()) {
            this.u = (byte) 0;
            return false;
        }
        for (int i3 = 0; i3 < P(); i3++) {
            if (!O(i3).isInitialized()) {
                this.u = (byte) 0;
                return false;
            }
        }
        if (s()) {
            this.u = (byte) 1;
            return true;
        }
        this.u = (byte) 0;
        return false;
    }

    public boolean j0() {
        return (this.f24097k & 8) == 8;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return l0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return m0(this);
    }

    private r(h.c<r, ?> cVar) {
        super(cVar);
        this.u = (byte) -1;
        this.v = -1;
        this.f24096j = cVar.l();
    }

    private r(boolean z) {
        this.u = (byte) -1;
        this.v = -1;
        this.f24096j = d.f25399f;
    }

    private r(e eVar, f fVar) throws InvalidProtocolBufferException {
        q.c cVarD;
        this.u = (byte) -1;
        this.v = -1;
        k0();
        d.b bVarW = d.w();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
        boolean z = false;
        int i2 = 0;
        while (!z) {
            try {
                try {
                    try {
                        int iK = eVar.K();
                        switch (iK) {
                            case 0:
                                break;
                            case 8:
                                this.f24097k |= 1;
                                this.l = eVar.s();
                                continue;
                            case 16:
                                this.f24097k |= 2;
                                this.m = eVar.s();
                                continue;
                            case 26:
                                if ((i2 & 4) != 4) {
                                    this.n = new ArrayList();
                                    i2 |= 4;
                                }
                                this.n.add((s) eVar.u(s.f24102i, fVar));
                                continue;
                            case 34:
                                cVarD = (this.f24097k & 4) == 4 ? this.o.d() : null;
                                q qVar = (q) eVar.u(q.f24073i, fVar);
                                this.o = qVar;
                                if (cVarD != null) {
                                    cVarD.m(qVar);
                                    this.o = cVarD.u();
                                }
                                this.f24097k |= 4;
                                continue;
                            case 40:
                                this.f24097k |= 8;
                                this.p = eVar.s();
                                continue;
                            case 50:
                                cVarD = (this.f24097k & 16) == 16 ? this.q.d() : null;
                                q qVar2 = (q) eVar.u(q.f24073i, fVar);
                                this.q = qVar2;
                                if (cVarD != null) {
                                    cVarD.m(qVar2);
                                    this.q = cVarD.u();
                                }
                                this.f24097k |= 16;
                                continue;
                            case 56:
                                this.f24097k |= 32;
                                this.r = eVar.s();
                                continue;
                            case 66:
                                if ((i2 & 128) != 128) {
                                    this.s = new ArrayList();
                                    i2 |= 128;
                                }
                                this.s.add((kotlin.reflect.y.internal.j0.e.b) eVar.u(kotlin.reflect.y.internal.j0.e.b.f23901h, fVar));
                                continue;
                            case 248:
                                if ((i2 & 256) != 256) {
                                    this.t = new ArrayList();
                                    i2 |= 256;
                                }
                                this.t.add(Integer.valueOf(eVar.s()));
                                continue;
                            case 250:
                                int iJ = eVar.j(eVar.A());
                                if ((i2 & 256) != 256 && eVar.e() > 0) {
                                    this.t = new ArrayList();
                                    i2 |= 256;
                                }
                                while (eVar.e() > 0) {
                                    this.t.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(iJ);
                                continue;
                            default:
                                if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                    break;
                                }
                                break;
                        }
                        z = true;
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).i(this);
                    }
                } catch (InvalidProtocolBufferException e3) {
                    throw e3.i(this);
                }
            } catch (Throwable th) {
                if ((i2 & 4) == 4) {
                    this.n = Collections.unmodifiableList(this.n);
                }
                if ((i2 & 128) == 128) {
                    this.s = Collections.unmodifiableList(this.s);
                }
                if ((i2 & 256) == 256) {
                    this.t = Collections.unmodifiableList(this.t);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } finally {
                    this.f24096j = bVarW.e();
                }
                m();
                throw th;
            }
        }
        if ((i2 & 4) == 4) {
            this.n = Collections.unmodifiableList(this.n);
        }
        if ((i2 & 128) == 128) {
            this.s = Collections.unmodifiableList(this.s);
        }
        if ((i2 & 256) == 256) {
            this.t = Collections.unmodifiableList(this.t);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f24096j = bVarW.e();
        }
        m();
    }
}
