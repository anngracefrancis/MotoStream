package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.p002reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.p002reflect.jvm.internal.impl.protobuf.d;
import kotlin.p002reflect.jvm.internal.impl.protobuf.e;
import kotlin.p002reflect.jvm.internal.impl.protobuf.f;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.p002reflect.jvm.internal.impl.protobuf.i;
import kotlin.p002reflect.jvm.internal.impl.protobuf.p;
import kotlin.p002reflect.jvm.internal.impl.protobuf.q;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends h.d<s> implements p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final s f24101h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static q<s> f24102i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f24103j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f24104k;
    private int l;
    private int m;
    private boolean n;
    private c o;
    private List<q> p;
    private List<Integer> q;
    private int r;
    private byte s;
    private int t;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<s> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public s b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new s(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h.c<s, b> implements p {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f24105i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f24106j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f24107k;
        private boolean l;
        private c m = c.INV;
        private List<q> n = Collections.emptyList();
        private List<Integer> o = Collections.emptyList();

        private b() {
            C();
        }

        private void A() {
            if ((this.f24105i & 32) != 32) {
                this.o = new ArrayList(this.o);
                this.f24105i |= 32;
            }
        }

        private void B() {
            if ((this.f24105i & 16) != 16) {
                this.n = new ArrayList(this.n);
                this.f24105i |= 16;
            }
        }

        private void C() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b w() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public b m(s sVar) {
            if (sVar == s.K()) {
                return this;
            }
            if (sVar.U()) {
                F(sVar.M());
            }
            if (sVar.V()) {
                G(sVar.N());
            }
            if (sVar.X()) {
                H(sVar.O());
            }
            if (sVar.Y()) {
                I(sVar.T());
            }
            if (!sVar.p.isEmpty()) {
                if (this.n.isEmpty()) {
                    this.n = sVar.p;
                    this.f24105i &= -17;
                } else {
                    B();
                    this.n.addAll(sVar.p);
                }
            }
            if (!sVar.q.isEmpty()) {
                if (this.o.isEmpty()) {
                    this.o = sVar.q;
                    this.f24105i &= -33;
                } else {
                    A();
                    this.o.addAll(sVar.q);
                }
            }
            r(sVar);
            n(l().f(sVar.f24103j));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public b i(e eVar, f fVar) throws Throwable {
            s sVar = null;
            try {
                try {
                    s sVarB = s.f24102i.b(eVar, fVar);
                    if (sVarB != null) {
                        m(sVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    s sVar2 = (s) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        sVar = sVar2;
                        if (sVar != null) {
                            m(sVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (sVar != null) {
                    m(sVar);
                }
                throw th;
            }
        }

        public b F(int i2) {
            this.f24105i |= 1;
            this.f24106j = i2;
            return this;
        }

        public b G(int i2) {
            this.f24105i |= 2;
            this.f24107k = i2;
            return this;
        }

        public b H(boolean z) {
            this.f24105i |= 4;
            this.l = z;
            return this;
        }

        public b I(c cVar) {
            cVar.getClass();
            this.f24105i |= 8;
            this.m = cVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public s c() {
            s sVarU = u();
            if (sVarU.isInitialized()) {
                return sVarU;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(sVarU);
        }

        public s u() {
            s sVar = new s(this);
            int i2 = this.f24105i;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            sVar.l = this.f24106j;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            sVar.m = this.f24107k;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            sVar.n = this.l;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            sVar.o = this.m;
            if ((this.f24105i & 16) == 16) {
                this.n = Collections.unmodifiableList(this.n);
                this.f24105i &= -17;
            }
            sVar.p = this.n;
            if ((this.f24105i & 32) == 32) {
                this.o = Collections.unmodifiableList(this.o);
                this.f24105i &= -33;
            }
            sVar.q = this.o;
            sVar.f24104k = i3;
            return sVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements i.a {
        IN(0, 0),
        OUT(1, 1),
        INV(2, 2);


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static i.b<c> f24111i = new a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f24113k;

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
            this.f24113k = i3;
        }

        public static c g(int i2) {
            if (i2 == 0) {
                return IN;
            }
            if (i2 == 1) {
                return OUT;
            }
            if (i2 != 2) {
                return null;
            }
            return INV;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int f() {
            return this.f24113k;
        }
    }

    static {
        s sVar = new s(true);
        f24101h = sVar;
        sVar.Z();
    }

    public static s K() {
        return f24101h;
    }

    private void Z() {
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = c.INV;
        this.p = Collections.emptyList();
        this.q = Collections.emptyList();
    }

    public static b a0() {
        return b.w();
    }

    public static b b0(s sVar) {
        return a0().m(sVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public s b() {
        return f24101h;
    }

    public int M() {
        return this.l;
    }

    public int N() {
        return this.m;
    }

    public boolean O() {
        return this.n;
    }

    public q P(int i2) {
        return this.p.get(i2);
    }

    public int Q() {
        return this.p.size();
    }

    public List<Integer> R() {
        return this.q;
    }

    public List<q> S() {
        return this.p;
    }

    public c T() {
        return this.o;
    }

    public boolean U() {
        return (this.f24104k & 1) == 1;
    }

    public boolean V() {
        return (this.f24104k & 2) == 2;
    }

    public boolean X() {
        return (this.f24104k & 4) == 4;
    }

    public boolean Y() {
        return (this.f24104k & 8) == 8;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: c0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return a0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return b0(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.t;
        if (i2 != -1) {
            return i2;
        }
        int iO = (this.f24104k & 1) == 1 ? CodedOutputStream.o(1, this.l) + 0 : 0;
        if ((this.f24104k & 2) == 2) {
            iO += CodedOutputStream.o(2, this.m);
        }
        if ((this.f24104k & 4) == 4) {
            iO += CodedOutputStream.a(3, this.n);
        }
        if ((this.f24104k & 8) == 8) {
            iO += CodedOutputStream.h(4, this.o.f());
        }
        for (int i3 = 0; i3 < this.p.size(); i3++) {
            iO += CodedOutputStream.s(5, this.p.get(i3));
        }
        int iP = 0;
        for (int i4 = 0; i4 < this.q.size(); i4++) {
            iP += CodedOutputStream.p(this.q.get(i4).intValue());
        }
        int iP2 = iO + iP;
        if (!R().isEmpty()) {
            iP2 = iP2 + 1 + CodedOutputStream.p(iP);
        }
        this.r = iP;
        int iT = iP2 + t() + this.f24103j.size();
        this.t = iT;
        return iT;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<s> g() {
        return f24102i;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a aVarY = y();
        if ((this.f24104k & 1) == 1) {
            codedOutputStream.a0(1, this.l);
        }
        if ((this.f24104k & 2) == 2) {
            codedOutputStream.a0(2, this.m);
        }
        if ((this.f24104k & 4) == 4) {
            codedOutputStream.L(3, this.n);
        }
        if ((this.f24104k & 8) == 8) {
            codedOutputStream.S(4, this.o.f());
        }
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            codedOutputStream.d0(5, this.p.get(i2));
        }
        if (R().size() > 0) {
            codedOutputStream.o0(50);
            codedOutputStream.o0(this.r);
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            codedOutputStream.b0(this.q.get(i3).intValue());
        }
        aVarY.a(1000, codedOutputStream);
        codedOutputStream.i0(this.f24103j);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.s;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!U()) {
            this.s = (byte) 0;
            return false;
        }
        if (!V()) {
            this.s = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < Q(); i2++) {
            if (!P(i2).isInitialized()) {
                this.s = (byte) 0;
                return false;
            }
        }
        if (s()) {
            this.s = (byte) 1;
            return true;
        }
        this.s = (byte) 0;
        return false;
    }

    private s(h.c<s, ?> cVar) {
        super(cVar);
        this.r = -1;
        this.s = (byte) -1;
        this.t = -1;
        this.f24103j = cVar.l();
    }

    private s(boolean z) {
        this.r = -1;
        this.s = (byte) -1;
        this.t = -1;
        this.f24103j = d.f25399f;
    }

    private s(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.r = -1;
        this.s = (byte) -1;
        this.t = -1;
        Z();
        d.b bVarW = d.w();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
        boolean z = false;
        int i2 = 0;
        while (!z) {
            try {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.f24104k |= 1;
                                this.l = eVar.s();
                            } else if (iK == 16) {
                                this.f24104k |= 2;
                                this.m = eVar.s();
                            } else if (iK == 24) {
                                this.f24104k |= 4;
                                this.n = eVar.k();
                            } else if (iK == 32) {
                                int iN = eVar.n();
                                c cVarG = c.g(iN);
                                if (cVarG == null) {
                                    codedOutputStreamJ.o0(iK);
                                    codedOutputStreamJ.o0(iN);
                                } else {
                                    this.f24104k |= 8;
                                    this.o = cVarG;
                                }
                            } else if (iK == 42) {
                                if ((i2 & 16) != 16) {
                                    this.p = new ArrayList();
                                    i2 |= 16;
                                }
                                this.p.add((q) eVar.u(q.f24073i, fVar));
                            } else if (iK == 48) {
                                if ((i2 & 32) != 32) {
                                    this.q = new ArrayList();
                                    i2 |= 32;
                                }
                                this.q.add(Integer.valueOf(eVar.s()));
                            } else if (iK != 50) {
                                if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                }
                            } else {
                                int iJ = eVar.j(eVar.A());
                                if ((i2 & 32) != 32 && eVar.e() > 0) {
                                    this.q = new ArrayList();
                                    i2 |= 32;
                                }
                                while (eVar.e() > 0) {
                                    this.q.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(iJ);
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
                if ((i2 & 16) == 16) {
                    this.p = Collections.unmodifiableList(this.p);
                }
                if ((i2 & 32) == 32) {
                    this.q = Collections.unmodifiableList(this.q);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } finally {
                    this.f24103j = bVarW.e();
                }
                m();
                throw th;
            }
        }
        if ((i2 & 16) == 16) {
            this.p = Collections.unmodifiableList(this.p);
        }
        if ((i2 & 32) == 32) {
            this.q = Collections.unmodifiableList(this.q);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f24103j = bVarW.e();
        }
        m();
    }
}
