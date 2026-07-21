package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
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
public final class u extends h.d<u> implements p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final u f24122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static q<u> f24123i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f24124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f24125k;
    private int l;
    private int m;
    private q n;
    private int o;
    private q p;
    private int q;
    private byte r;
    private int s;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<u> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public u b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new u(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h.c<u, b> implements p {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f24126i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f24127j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f24128k;
        private int m;
        private int o;
        private q l = q.Y();
        private q n = q.Y();

        private b() {
            A();
        }

        private void A() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b w() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public b m(u uVar) {
            if (uVar == u.I()) {
                return this;
            }
            if (uVar.Q()) {
                F(uVar.K());
            }
            if (uVar.R()) {
                G(uVar.L());
            }
            if (uVar.S()) {
                D(uVar.M());
            }
            if (uVar.T()) {
                H(uVar.N());
            }
            if (uVar.U()) {
                E(uVar.O());
            }
            if (uVar.V()) {
                I(uVar.P());
            }
            r(uVar);
            n(l().f(uVar.f24124j));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public b i(e eVar, f fVar) throws Throwable {
            u uVar = null;
            try {
                try {
                    u uVarB = u.f24123i.b(eVar, fVar);
                    if (uVarB != null) {
                        m(uVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    u uVar2 = (u) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        uVar = uVar2;
                        if (uVar != null) {
                            m(uVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (uVar != null) {
                    m(uVar);
                }
                throw th;
            }
        }

        public b D(q qVar) {
            if ((this.f24126i & 4) != 4 || this.l == q.Y()) {
                this.l = qVar;
            } else {
                this.l = q.z0(this.l).m(qVar).u();
            }
            this.f24126i |= 4;
            return this;
        }

        public b E(q qVar) {
            if ((this.f24126i & 16) != 16 || this.n == q.Y()) {
                this.n = qVar;
            } else {
                this.n = q.z0(this.n).m(qVar).u();
            }
            this.f24126i |= 16;
            return this;
        }

        public b F(int i2) {
            this.f24126i |= 1;
            this.f24127j = i2;
            return this;
        }

        public b G(int i2) {
            this.f24126i |= 2;
            this.f24128k = i2;
            return this;
        }

        public b H(int i2) {
            this.f24126i |= 8;
            this.m = i2;
            return this;
        }

        public b I(int i2) {
            this.f24126i |= 32;
            this.o = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public u c() {
            u uVarU = u();
            if (uVarU.isInitialized()) {
                return uVarU;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(uVarU);
        }

        public u u() {
            u uVar = new u(this);
            int i2 = this.f24126i;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            uVar.l = this.f24127j;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            uVar.m = this.f24128k;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            uVar.n = this.l;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            uVar.o = this.m;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            uVar.p = this.n;
            if ((i2 & 32) == 32) {
                i3 |= 32;
            }
            uVar.q = this.o;
            uVar.f24125k = i3;
            return uVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    static {
        u uVar = new u(true);
        f24122h = uVar;
        uVar.X();
    }

    public static u I() {
        return f24122h;
    }

    private void X() {
        this.l = 0;
        this.m = 0;
        this.n = q.Y();
        this.o = 0;
        this.p = q.Y();
        this.q = 0;
    }

    public static b Y() {
        return b.w();
    }

    public static b Z(u uVar) {
        return Y().m(uVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public u b() {
        return f24122h;
    }

    public int K() {
        return this.l;
    }

    public int L() {
        return this.m;
    }

    public q M() {
        return this.n;
    }

    public int N() {
        return this.o;
    }

    public q O() {
        return this.p;
    }

    public int P() {
        return this.q;
    }

    public boolean Q() {
        return (this.f24125k & 1) == 1;
    }

    public boolean R() {
        return (this.f24125k & 2) == 2;
    }

    public boolean S() {
        return (this.f24125k & 4) == 4;
    }

    public boolean T() {
        return (this.f24125k & 8) == 8;
    }

    public boolean U() {
        return (this.f24125k & 16) == 16;
    }

    public boolean V() {
        return (this.f24125k & 32) == 32;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return Y();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return Z(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.s;
        if (i2 != -1) {
            return i2;
        }
        int iO = (this.f24125k & 1) == 1 ? 0 + CodedOutputStream.o(1, this.l) : 0;
        if ((this.f24125k & 2) == 2) {
            iO += CodedOutputStream.o(2, this.m);
        }
        if ((this.f24125k & 4) == 4) {
            iO += CodedOutputStream.s(3, this.n);
        }
        if ((this.f24125k & 16) == 16) {
            iO += CodedOutputStream.s(4, this.p);
        }
        if ((this.f24125k & 8) == 8) {
            iO += CodedOutputStream.o(5, this.o);
        }
        if ((this.f24125k & 32) == 32) {
            iO += CodedOutputStream.o(6, this.q);
        }
        int iT = iO + t() + this.f24124j.size();
        this.s = iT;
        return iT;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<u> g() {
        return f24123i;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a aVarY = y();
        if ((this.f24125k & 1) == 1) {
            codedOutputStream.a0(1, this.l);
        }
        if ((this.f24125k & 2) == 2) {
            codedOutputStream.a0(2, this.m);
        }
        if ((this.f24125k & 4) == 4) {
            codedOutputStream.d0(3, this.n);
        }
        if ((this.f24125k & 16) == 16) {
            codedOutputStream.d0(4, this.p);
        }
        if ((this.f24125k & 8) == 8) {
            codedOutputStream.a0(5, this.o);
        }
        if ((this.f24125k & 32) == 32) {
            codedOutputStream.a0(6, this.q);
        }
        aVarY.a(200, codedOutputStream);
        codedOutputStream.i0(this.f24124j);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.r;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!R()) {
            this.r = (byte) 0;
            return false;
        }
        if (S() && !M().isInitialized()) {
            this.r = (byte) 0;
            return false;
        }
        if (U() && !O().isInitialized()) {
            this.r = (byte) 0;
            return false;
        }
        if (s()) {
            this.r = (byte) 1;
            return true;
        }
        this.r = (byte) 0;
        return false;
    }

    private u(h.c<u, ?> cVar) {
        super(cVar);
        this.r = (byte) -1;
        this.s = -1;
        this.f24124j = cVar.l();
    }

    private u(boolean z) {
        this.r = (byte) -1;
        this.s = -1;
        this.f24124j = d.f25399f;
    }

    private u(e eVar, f fVar) throws InvalidProtocolBufferException {
        q.c cVarD;
        this.r = (byte) -1;
        this.s = -1;
        X();
        d.b bVarW = d.w();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
        boolean z = false;
        while (!z) {
            try {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.f24125k |= 1;
                                this.l = eVar.s();
                            } else if (iK != 16) {
                                if (iK == 26) {
                                    cVarD = (this.f24125k & 4) == 4 ? this.n.d() : null;
                                    q qVar = (q) eVar.u(q.f24073i, fVar);
                                    this.n = qVar;
                                    if (cVarD != null) {
                                        cVarD.m(qVar);
                                        this.n = cVarD.u();
                                    }
                                    this.f24125k |= 4;
                                } else if (iK == 34) {
                                    cVarD = (this.f24125k & 16) == 16 ? this.p.d() : null;
                                    q qVar2 = (q) eVar.u(q.f24073i, fVar);
                                    this.p = qVar2;
                                    if (cVarD != null) {
                                        cVarD.m(qVar2);
                                        this.p = cVarD.u();
                                    }
                                    this.f24125k |= 16;
                                } else if (iK == 40) {
                                    this.f24125k |= 8;
                                    this.o = eVar.s();
                                } else if (iK != 48) {
                                    if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                    }
                                } else {
                                    this.f24125k |= 32;
                                    this.q = eVar.s();
                                }
                            } else {
                                this.f24125k |= 2;
                                this.m = eVar.s();
                            }
                        }
                        z = true;
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).i(this);
                    }
                } catch (InvalidProtocolBufferException e3) {
                    throw e3.i(this);
                }
            } catch (Throwable th) {
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } finally {
                    this.f24124j = bVarW.e();
                }
                m();
                throw th;
            }
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f24124j = bVarW.e();
        }
        m();
    }
}
