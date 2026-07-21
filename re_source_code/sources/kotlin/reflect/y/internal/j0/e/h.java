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
import kotlin.p002reflect.jvm.internal.impl.protobuf.i;
import kotlin.p002reflect.jvm.internal.impl.protobuf.p;
import kotlin.p002reflect.jvm.internal.impl.protobuf.q;

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends kotlin.p002reflect.jvm.internal.impl.protobuf.h implements p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final h f23987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static q<h> f23988h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d f23989i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f23990j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f23991k;
    private int l;
    private c m;
    private q n;
    private int o;
    private List<h> p;
    private List<h> q;
    private byte r;
    private int s;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<h> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public h b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new h(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends kotlin.reflect.jvm.internal.impl.protobuf.h.b<h, b> implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f23992g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f23993h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f23994i;
        private int l;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private c f23995j = c.TRUE;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private q f23996k = q.Y();
        private List<h> m = Collections.emptyList();
        private List<h> n = Collections.emptyList();

        private b() {
            v();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b s() {
            return new b();
        }

        private void t() {
            if ((this.f23992g & 32) != 32) {
                this.m = new ArrayList(this.m);
                this.f23992g |= 32;
            }
        }

        private void u() {
            if ((this.f23992g & 64) != 64) {
                this.n = new ArrayList(this.n);
                this.f23992g |= 64;
            }
        }

        private void v() {
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        public b i(e eVar, f fVar) throws Throwable {
            h hVar = null;
            try {
                try {
                    h hVarB = h.f23988h.b(eVar, fVar);
                    if (hVarB != null) {
                        m(hVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    h hVar2 = (h) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        hVar = hVar2;
                        if (hVar != null) {
                            m(hVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (hVar != null) {
                    m(hVar);
                }
                throw th;
            }
        }

        public b B(q qVar) {
            if ((this.f23992g & 8) != 8 || this.f23996k == q.Y()) {
                this.f23996k = qVar;
            } else {
                this.f23996k = q.z0(this.f23996k).m(qVar).u();
            }
            this.f23992g |= 8;
            return this;
        }

        public b C(c cVar) {
            cVar.getClass();
            this.f23992g |= 4;
            this.f23995j = cVar;
            return this;
        }

        public b D(int i2) {
            this.f23992g |= 1;
            this.f23993h = i2;
            return this;
        }

        public b E(int i2) {
            this.f23992g |= 16;
            this.l = i2;
            return this;
        }

        public b F(int i2) {
            this.f23992g |= 2;
            this.f23994i = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public h c() {
            h hVarQ = q();
            if (hVarQ.isInitialized()) {
                return hVarQ;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(hVarQ);
        }

        public h q() {
            h hVar = new h(this);
            int i2 = this.f23992g;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            hVar.f23991k = this.f23993h;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            hVar.l = this.f23994i;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            hVar.m = this.f23995j;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            hVar.n = this.f23996k;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            hVar.o = this.l;
            if ((this.f23992g & 32) == 32) {
                this.m = Collections.unmodifiableList(this.m);
                this.f23992g &= -33;
            }
            hVar.p = this.m;
            if ((this.f23992g & 64) == 64) {
                this.n = Collections.unmodifiableList(this.n);
                this.f23992g &= -65;
            }
            hVar.q = this.n;
            hVar.f23990j = i3;
            return hVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public b m(h hVar) {
            if (hVar == h.F()) {
                return this;
            }
            if (hVar.N()) {
                D(hVar.G());
            }
            if (hVar.Q()) {
                F(hVar.L());
            }
            if (hVar.M()) {
                C(hVar.E());
            }
            if (hVar.O()) {
                B(hVar.H());
            }
            if (hVar.P()) {
                E(hVar.I());
            }
            if (!hVar.p.isEmpty()) {
                if (this.m.isEmpty()) {
                    this.m = hVar.p;
                    this.f23992g &= -33;
                } else {
                    t();
                    this.m.addAll(hVar.p);
                }
            }
            if (!hVar.q.isEmpty()) {
                if (this.n.isEmpty()) {
                    this.n = hVar.q;
                    this.f23992g &= -65;
                } else {
                    u();
                    this.n.addAll(hVar.q);
                }
            }
            n(l().f(hVar.f23989i));
            return this;
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public enum c implements i.a {
        TRUE(0, 0),
        FALSE(1, 1),
        NULL(2, 2);


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static i.b<c> f24000i = new a();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private final int f24002k;

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
            this.f24002k = i3;
        }

        public static c g(int i2) {
            if (i2 == 0) {
                return TRUE;
            }
            if (i2 == 1) {
                return FALSE;
            }
            if (i2 != 2) {
                return null;
            }
            return NULL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int f() {
            return this.f24002k;
        }
    }

    static {
        h hVar = new h(true);
        f23987g = hVar;
        hVar.R();
    }

    public static h F() {
        return f23987g;
    }

    private void R() {
        this.f23991k = 0;
        this.l = 0;
        this.m = c.TRUE;
        this.n = q.Y();
        this.o = 0;
        this.p = Collections.emptyList();
        this.q = Collections.emptyList();
    }

    public static b S() {
        return b.s();
    }

    public static b T(h hVar) {
        return S().m(hVar);
    }

    public h C(int i2) {
        return this.p.get(i2);
    }

    public int D() {
        return this.p.size();
    }

    public c E() {
        return this.m;
    }

    public int G() {
        return this.f23991k;
    }

    public q H() {
        return this.n;
    }

    public int I() {
        return this.o;
    }

    public h J(int i2) {
        return this.q.get(i2);
    }

    public int K() {
        return this.q.size();
    }

    public int L() {
        return this.l;
    }

    public boolean M() {
        return (this.f23990j & 4) == 4;
    }

    public boolean N() {
        return (this.f23990j & 1) == 1;
    }

    public boolean O() {
        return (this.f23990j & 8) == 8;
    }

    public boolean P() {
        return (this.f23990j & 16) == 16;
    }

    public boolean Q() {
        return (this.f23990j & 2) == 2;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
    public b f() {
        return S();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public b d() {
        return T(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.s;
        if (i2 != -1) {
            return i2;
        }
        int iO = (this.f23990j & 1) == 1 ? CodedOutputStream.o(1, this.f23991k) + 0 : 0;
        if ((this.f23990j & 2) == 2) {
            iO += CodedOutputStream.o(2, this.l);
        }
        if ((this.f23990j & 4) == 4) {
            iO += CodedOutputStream.h(3, this.m.f());
        }
        if ((this.f23990j & 8) == 8) {
            iO += CodedOutputStream.s(4, this.n);
        }
        if ((this.f23990j & 16) == 16) {
            iO += CodedOutputStream.o(5, this.o);
        }
        for (int i3 = 0; i3 < this.p.size(); i3++) {
            iO += CodedOutputStream.s(6, this.p.get(i3));
        }
        for (int i4 = 0; i4 < this.q.size(); i4++) {
            iO += CodedOutputStream.s(7, this.q.get(i4));
        }
        int size = iO + this.f23989i.size();
        this.s = size;
        return size;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<h> g() {
        return f23988h;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        if ((this.f23990j & 1) == 1) {
            codedOutputStream.a0(1, this.f23991k);
        }
        if ((this.f23990j & 2) == 2) {
            codedOutputStream.a0(2, this.l);
        }
        if ((this.f23990j & 4) == 4) {
            codedOutputStream.S(3, this.m.f());
        }
        if ((this.f23990j & 8) == 8) {
            codedOutputStream.d0(4, this.n);
        }
        if ((this.f23990j & 16) == 16) {
            codedOutputStream.a0(5, this.o);
        }
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            codedOutputStream.d0(6, this.p.get(i2));
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            codedOutputStream.d0(7, this.q.get(i3));
        }
        codedOutputStream.i0(this.f23989i);
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
        if (O() && !H().isInitialized()) {
            this.r = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < D(); i2++) {
            if (!C(i2).isInitialized()) {
                this.r = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < K(); i3++) {
            if (!J(i3).isInitialized()) {
                this.r = (byte) 0;
                return false;
            }
        }
        this.r = (byte) 1;
        return true;
    }

    private h(kotlin.reflect.jvm.internal.impl.protobuf.h.b bVar) {
        super(bVar);
        this.r = (byte) -1;
        this.s = -1;
        this.f23989i = bVar.l();
    }

    private h(boolean z) {
        this.r = (byte) -1;
        this.s = -1;
        this.f23989i = d.f25399f;
    }

    private h(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.r = (byte) -1;
        this.s = -1;
        R();
        d.b bVarW = d.w();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
        boolean z = false;
        int i2 = 0;
        while (!z) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK == 8) {
                            this.f23990j |= 1;
                            this.f23991k = eVar.s();
                        } else if (iK == 16) {
                            this.f23990j |= 2;
                            this.l = eVar.s();
                        } else if (iK == 24) {
                            int iN = eVar.n();
                            c cVarG = c.g(iN);
                            if (cVarG == null) {
                                codedOutputStreamJ.o0(iK);
                                codedOutputStreamJ.o0(iN);
                            } else {
                                this.f23990j |= 4;
                                this.m = cVarG;
                            }
                        } else if (iK == 34) {
                            q.c cVarD = (this.f23990j & 8) == 8 ? this.n.d() : null;
                            q qVar = (q) eVar.u(q.f24073i, fVar);
                            this.n = qVar;
                            if (cVarD != null) {
                                cVarD.m(qVar);
                                this.n = cVarD.u();
                            }
                            this.f23990j |= 8;
                        } else if (iK == 40) {
                            this.f23990j |= 16;
                            this.o = eVar.s();
                        } else if (iK == 50) {
                            if ((i2 & 32) != 32) {
                                this.p = new ArrayList();
                                i2 |= 32;
                            }
                            this.p.add((h) eVar.u(f23988h, fVar));
                        } else if (iK != 58) {
                            if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                            }
                        } else {
                            if ((i2 & 64) != 64) {
                                this.q = new ArrayList();
                                i2 |= 64;
                            }
                            this.q.add((h) eVar.u(f23988h, fVar));
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.i(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i2 & 32) == 32) {
                    this.p = Collections.unmodifiableList(this.p);
                }
                if ((i2 & 64) == 64) {
                    this.q = Collections.unmodifiableList(this.q);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } finally {
                    this.f23989i = bVarW.e();
                }
                m();
                throw th;
            }
        }
        if ((i2 & 32) == 32) {
            this.p = Collections.unmodifiableList(this.p);
        }
        if ((i2 & 64) == 64) {
            this.q = Collections.unmodifiableList(this.q);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f23989i = bVarW.e();
        }
        m();
    }
}
