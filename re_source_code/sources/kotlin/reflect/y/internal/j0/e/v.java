package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import kotlin.p002reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.p002reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.p002reflect.jvm.internal.impl.protobuf.e;
import kotlin.p002reflect.jvm.internal.impl.protobuf.f;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.p002reflect.jvm.internal.impl.protobuf.i;
import kotlin.p002reflect.jvm.internal.impl.protobuf.p;
import kotlin.p002reflect.jvm.internal.impl.protobuf.q;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends h implements p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final v f24129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static q<v> f24130h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final kotlin.p002reflect.jvm.internal.impl.protobuf.d f24131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f24132j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f24133k;
    private int l;
    private c m;
    private int n;
    private int o;
    private d p;
    private byte q;
    private int r;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<v> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public v b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new v(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h.b<v, b> implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f24134g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f24135h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f24136i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f24138k;
        private int l;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private c f24137j = c.ERROR;
        private d m = d.LANGUAGE_VERSION;

        private b() {
            t();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b s() {
            return new b();
        }

        private void t() {
        }

        public b A(c cVar) {
            cVar.getClass();
            this.f24134g |= 4;
            this.f24137j = cVar;
            return this;
        }

        public b B(int i2) {
            this.f24134g |= 16;
            this.l = i2;
            return this;
        }

        public b C(int i2) {
            this.f24134g |= 1;
            this.f24135h = i2;
            return this;
        }

        public b D(int i2) {
            this.f24134g |= 2;
            this.f24136i = i2;
            return this;
        }

        public b E(d dVar) {
            dVar.getClass();
            this.f24134g |= 32;
            this.m = dVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public v c() {
            v vVarQ = q();
            if (vVarQ.isInitialized()) {
                return vVarQ;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(vVarQ);
        }

        public v q() {
            v vVar = new v(this);
            int i2 = this.f24134g;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            vVar.f24133k = this.f24135h;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            vVar.l = this.f24136i;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            vVar.m = this.f24137j;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            vVar.n = this.f24138k;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            vVar.o = this.l;
            if ((i2 & 32) == 32) {
                i3 |= 32;
            }
            vVar.p = this.m;
            vVar.f24132j = i3;
            return vVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public b m(v vVar) {
            if (vVar == v.z()) {
                return this;
            }
            if (vVar.J()) {
                C(vVar.D());
            }
            if (vVar.K()) {
                D(vVar.E());
            }
            if (vVar.H()) {
                A(vVar.B());
            }
            if (vVar.G()) {
                w(vVar.A());
            }
            if (vVar.I()) {
                B(vVar.C());
            }
            if (vVar.L()) {
                E(vVar.F());
            }
            n(l().f(vVar.f24131i));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b i(e eVar, f fVar) throws Throwable {
            v vVar = null;
            try {
                try {
                    v vVarB = v.f24130h.b(eVar, fVar);
                    if (vVarB != null) {
                        m(vVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    v vVar2 = (v) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        vVar = vVar2;
                        if (vVar != null) {
                            m(vVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (vVar != null) {
                    m(vVar);
                }
                throw th;
            }
        }

        public b w(int i2) {
            this.f24134g |= 8;
            this.f24138k = i2;
            return this;
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements i.a {
        WARNING(0, 0),
        ERROR(1, 1),
        HIDDEN(2, 2);


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static i.b<c> f24142i = new a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f24144k;

        /* JADX INFO: compiled from: ProtoBuf.java */
        static class a implements i.b<c> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i2) {
                return c.g(i2);
            }
        }

        c(int i2, int i3) {
            this.f24144k = i3;
        }

        public static c g(int i2) {
            if (i2 == 0) {
                return WARNING;
            }
            if (i2 == 1) {
                return ERROR;
            }
            if (i2 != 2) {
                return null;
            }
            return HIDDEN;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int f() {
            return this.f24144k;
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum d implements i.a {
        LANGUAGE_VERSION(0, 0),
        COMPILER_VERSION(1, 1),
        API_VERSION(2, 2);


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static i.b<d> f24148i = new a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f24150k;

        /* JADX INFO: compiled from: ProtoBuf.java */
        static class a implements i.b<d> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i2) {
                return d.g(i2);
            }
        }

        d(int i2, int i3) {
            this.f24150k = i3;
        }

        public static d g(int i2) {
            if (i2 == 0) {
                return LANGUAGE_VERSION;
            }
            if (i2 == 1) {
                return COMPILER_VERSION;
            }
            if (i2 != 2) {
                return null;
            }
            return API_VERSION;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int f() {
            return this.f24150k;
        }
    }

    static {
        v vVar = new v(true);
        f24129g = vVar;
        vVar.M();
    }

    private void M() {
        this.f24133k = 0;
        this.l = 0;
        this.m = c.ERROR;
        this.n = 0;
        this.o = 0;
        this.p = d.LANGUAGE_VERSION;
    }

    public static b N() {
        return b.s();
    }

    public static b O(v vVar) {
        return N().m(vVar);
    }

    public static v z() {
        return f24129g;
    }

    public int A() {
        return this.n;
    }

    public c B() {
        return this.m;
    }

    public int C() {
        return this.o;
    }

    public int D() {
        return this.f24133k;
    }

    public int E() {
        return this.l;
    }

    public d F() {
        return this.p;
    }

    public boolean G() {
        return (this.f24132j & 8) == 8;
    }

    public boolean H() {
        return (this.f24132j & 4) == 4;
    }

    public boolean I() {
        return (this.f24132j & 16) == 16;
    }

    public boolean J() {
        return (this.f24132j & 1) == 1;
    }

    public boolean K() {
        return (this.f24132j & 2) == 2;
    }

    public boolean L() {
        return (this.f24132j & 32) == 32;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public b f() {
        return N();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b d() {
        return O(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.r;
        if (i2 != -1) {
            return i2;
        }
        int iO = (this.f24132j & 1) == 1 ? 0 + CodedOutputStream.o(1, this.f24133k) : 0;
        if ((this.f24132j & 2) == 2) {
            iO += CodedOutputStream.o(2, this.l);
        }
        if ((this.f24132j & 4) == 4) {
            iO += CodedOutputStream.h(3, this.m.f());
        }
        if ((this.f24132j & 8) == 8) {
            iO += CodedOutputStream.o(4, this.n);
        }
        if ((this.f24132j & 16) == 16) {
            iO += CodedOutputStream.o(5, this.o);
        }
        if ((this.f24132j & 32) == 32) {
            iO += CodedOutputStream.h(6, this.p.f());
        }
        int size = iO + this.f24131i.size();
        this.r = size;
        return size;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<v> g() {
        return f24130h;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        if ((this.f24132j & 1) == 1) {
            codedOutputStream.a0(1, this.f24133k);
        }
        if ((this.f24132j & 2) == 2) {
            codedOutputStream.a0(2, this.l);
        }
        if ((this.f24132j & 4) == 4) {
            codedOutputStream.S(3, this.m.f());
        }
        if ((this.f24132j & 8) == 8) {
            codedOutputStream.a0(4, this.n);
        }
        if ((this.f24132j & 16) == 16) {
            codedOutputStream.a0(5, this.o);
        }
        if ((this.f24132j & 32) == 32) {
            codedOutputStream.S(6, this.p.f());
        }
        codedOutputStream.i0(this.f24131i);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.q;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.q = (byte) 1;
        return true;
    }

    private v(h.b bVar) {
        super(bVar);
        this.q = (byte) -1;
        this.r = -1;
        this.f24131i = bVar.l();
    }

    private v(boolean z) {
        this.q = (byte) -1;
        this.r = -1;
        this.f24131i = kotlin.p002reflect.jvm.internal.impl.protobuf.d.f25399f;
    }

    private v(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.q = (byte) -1;
        this.r = -1;
        M();
        kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarW = kotlin.p002reflect.jvm.internal.impl.protobuf.d.w();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
        boolean z = false;
        while (!z) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK == 8) {
                            this.f24132j |= 1;
                            this.f24133k = eVar.s();
                        } else if (iK == 16) {
                            this.f24132j |= 2;
                            this.l = eVar.s();
                        } else if (iK == 24) {
                            int iN = eVar.n();
                            c cVarG = c.g(iN);
                            if (cVarG == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN);
                            } else {
                                this.f24132j |= 4;
                                this.m = cVarG;
                            }
                        } else if (iK == 32) {
                            this.f24132j |= 8;
                            this.n = eVar.s();
                        } else if (iK == 40) {
                            this.f24132j |= 16;
                            this.o = eVar.s();
                        } else if (iK != 48) {
                            if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                            }
                        } else {
                            int iN2 = eVar.n();
                            d dVarG = d.g(iN2);
                            if (dVarG == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN2);
                            } else {
                                this.f24132j |= 32;
                                this.p = dVarG;
                            }
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.i(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
                }
            } catch (Throwable th) {
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } finally {
                    this.f24131i = bVarW.e();
                }
                m();
                throw th;
            }
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f24131i = bVarW.e();
        }
        m();
    }
}
