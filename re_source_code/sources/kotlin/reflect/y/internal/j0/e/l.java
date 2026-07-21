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
public final class l extends h.d<l> implements p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final l f24022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static q<l> f24023i = new a();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f24024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f24025k;
    private List<i> l;
    private List<n> m;
    private List<r> n;
    private t o;
    private w p;
    private byte q;
    private int r;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<l> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public l b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new l(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h.c<l, b> implements p {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f24026i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<i> f24027j = Collections.emptyList();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private List<n> f24028k = Collections.emptyList();
        private List<r> l = Collections.emptyList();
        private t m = t.w();
        private w n = w.u();

        private b() {
            D();
        }

        private void A() {
            if ((this.f24026i & 1) != 1) {
                this.f24027j = new ArrayList(this.f24027j);
                this.f24026i |= 1;
            }
        }

        private void B() {
            if ((this.f24026i & 2) != 2) {
                this.f24028k = new ArrayList(this.f24028k);
                this.f24026i |= 2;
            }
        }

        private void C() {
            if ((this.f24026i & 4) != 4) {
                this.l = new ArrayList(this.l);
                this.f24026i |= 4;
            }
        }

        private void D() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b w() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public b m(l lVar) {
            if (lVar == l.K()) {
                return this;
            }
            if (!lVar.l.isEmpty()) {
                if (this.f24027j.isEmpty()) {
                    this.f24027j = lVar.l;
                    this.f24026i &= -2;
                } else {
                    A();
                    this.f24027j.addAll(lVar.l);
                }
            }
            if (!lVar.m.isEmpty()) {
                if (this.f24028k.isEmpty()) {
                    this.f24028k = lVar.m;
                    this.f24026i &= -3;
                } else {
                    B();
                    this.f24028k.addAll(lVar.m);
                }
            }
            if (!lVar.n.isEmpty()) {
                if (this.l.isEmpty()) {
                    this.l = lVar.n;
                    this.f24026i &= -5;
                } else {
                    C();
                    this.l.addAll(lVar.n);
                }
            }
            if (lVar.Y()) {
                G(lVar.V());
            }
            if (lVar.Z()) {
                H(lVar.X());
            }
            r(lVar);
            n(l().f(lVar.f24024j));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public b i(e eVar, f fVar) throws Throwable {
            l lVar = null;
            try {
                try {
                    l lVarB = l.f24023i.b(eVar, fVar);
                    if (lVarB != null) {
                        m(lVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    l lVar2 = (l) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        lVar = lVar2;
                        if (lVar != null) {
                            m(lVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (lVar != null) {
                    m(lVar);
                }
                throw th;
            }
        }

        public b G(t tVar) {
            if ((this.f24026i & 8) != 8 || this.m == t.w()) {
                this.m = tVar;
            } else {
                this.m = t.E(this.m).m(tVar).q();
            }
            this.f24026i |= 8;
            return this;
        }

        public b H(w wVar) {
            if ((this.f24026i & 16) != 16 || this.n == w.u()) {
                this.n = wVar;
            } else {
                this.n = w.z(this.n).m(wVar).q();
            }
            this.f24026i |= 16;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public l c() {
            l lVarU = u();
            if (lVarU.isInitialized()) {
                return lVarU;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(lVarU);
        }

        public l u() {
            l lVar = new l(this);
            int i2 = this.f24026i;
            if ((i2 & 1) == 1) {
                this.f24027j = Collections.unmodifiableList(this.f24027j);
                this.f24026i &= -2;
            }
            lVar.l = this.f24027j;
            if ((this.f24026i & 2) == 2) {
                this.f24028k = Collections.unmodifiableList(this.f24028k);
                this.f24026i &= -3;
            }
            lVar.m = this.f24028k;
            if ((this.f24026i & 4) == 4) {
                this.l = Collections.unmodifiableList(this.l);
                this.f24026i &= -5;
            }
            lVar.n = this.l;
            int i3 = (i2 & 8) != 8 ? 0 : 1;
            lVar.o = this.m;
            if ((i2 & 16) == 16) {
                i3 |= 2;
            }
            lVar.p = this.n;
            lVar.f24025k = i3;
            return lVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    static {
        l lVar = new l(true);
        f24022h = lVar;
        lVar.a0();
    }

    public static l K() {
        return f24022h;
    }

    private void a0() {
        this.l = Collections.emptyList();
        this.m = Collections.emptyList();
        this.n = Collections.emptyList();
        this.o = t.w();
        this.p = w.u();
    }

    public static b b0() {
        return b.w();
    }

    public static b c0(l lVar) {
        return b0().m(lVar);
    }

    public static l e0(InputStream inputStream, f fVar) throws IOException {
        return f24023i.a(inputStream, fVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public l b() {
        return f24022h;
    }

    public i M(int i2) {
        return this.l.get(i2);
    }

    public int N() {
        return this.l.size();
    }

    public List<i> O() {
        return this.l;
    }

    public n P(int i2) {
        return this.m.get(i2);
    }

    public int Q() {
        return this.m.size();
    }

    public List<n> R() {
        return this.m;
    }

    public r S(int i2) {
        return this.n.get(i2);
    }

    public int T() {
        return this.n.size();
    }

    public List<r> U() {
        return this.n;
    }

    public t V() {
        return this.o;
    }

    public w X() {
        return this.p;
    }

    public boolean Y() {
        return (this.f24025k & 1) == 1;
    }

    public boolean Z() {
        return (this.f24025k & 2) == 2;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return b0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.r;
        if (i2 != -1) {
            return i2;
        }
        int iS = 0;
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            iS += CodedOutputStream.s(3, this.l.get(i3));
        }
        for (int i4 = 0; i4 < this.m.size(); i4++) {
            iS += CodedOutputStream.s(4, this.m.get(i4));
        }
        for (int i5 = 0; i5 < this.n.size(); i5++) {
            iS += CodedOutputStream.s(5, this.n.get(i5));
        }
        if ((this.f24025k & 1) == 1) {
            iS += CodedOutputStream.s(30, this.o);
        }
        if ((this.f24025k & 2) == 2) {
            iS += CodedOutputStream.s(32, this.p);
        }
        int iT = iS + t() + this.f24024j.size();
        this.r = iT;
        return iT;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return c0(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<l> g() {
        return f24023i;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a aVarY = y();
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            codedOutputStream.d0(3, this.l.get(i2));
        }
        for (int i3 = 0; i3 < this.m.size(); i3++) {
            codedOutputStream.d0(4, this.m.get(i3));
        }
        for (int i4 = 0; i4 < this.n.size(); i4++) {
            codedOutputStream.d0(5, this.n.get(i4));
        }
        if ((this.f24025k & 1) == 1) {
            codedOutputStream.d0(30, this.o);
        }
        if ((this.f24025k & 2) == 2) {
            codedOutputStream.d0(32, this.p);
        }
        aVarY.a(200, codedOutputStream);
        codedOutputStream.i0(this.f24024j);
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
        for (int i2 = 0; i2 < N(); i2++) {
            if (!M(i2).isInitialized()) {
                this.q = (byte) 0;
                return false;
            }
        }
        for (int i3 = 0; i3 < Q(); i3++) {
            if (!P(i3).isInitialized()) {
                this.q = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < T(); i4++) {
            if (!S(i4).isInitialized()) {
                this.q = (byte) 0;
                return false;
            }
        }
        if (Y() && !V().isInitialized()) {
            this.q = (byte) 0;
            return false;
        }
        if (s()) {
            this.q = (byte) 1;
            return true;
        }
        this.q = (byte) 0;
        return false;
    }

    private l(h.c<l, ?> cVar) {
        super(cVar);
        this.q = (byte) -1;
        this.r = -1;
        this.f24024j = cVar.l();
    }

    private l(boolean z) {
        this.q = (byte) -1;
        this.r = -1;
        this.f24024j = d.f25399f;
    }

    private l(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.q = (byte) -1;
        this.r = -1;
        a0();
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
                            if (iK == 26) {
                                if ((i2 & 1) != 1) {
                                    this.l = new ArrayList();
                                    i2 |= 1;
                                }
                                this.l.add((i) eVar.u(i.f24004i, fVar));
                            } else if (iK == 34) {
                                if ((i2 & 2) != 2) {
                                    this.m = new ArrayList();
                                    i2 |= 2;
                                }
                                this.m.add((n) eVar.u(n.f24037i, fVar));
                            } else if (iK != 42) {
                                if (iK == 242) {
                                    t.b bVarG = (this.f24025k & 1) == 1 ? this.o.d() : null;
                                    t tVar = (t) eVar.u(t.f24115h, fVar);
                                    this.o = tVar;
                                    if (bVarG != null) {
                                        bVarG.m(tVar);
                                        this.o = bVarG.q();
                                    }
                                    this.f24025k |= 1;
                                } else if (iK != 258) {
                                    if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                    }
                                } else {
                                    w.b bVarB = (this.f24025k & 2) == 2 ? this.p.d() : null;
                                    w wVar = (w) eVar.u(w.f24152h, fVar);
                                    this.p = wVar;
                                    if (bVarB != null) {
                                        bVarB.m(wVar);
                                        this.p = bVarB.q();
                                    }
                                    this.f24025k |= 2;
                                }
                            } else {
                                if ((i2 & 4) != 4) {
                                    this.n = new ArrayList();
                                    i2 |= 4;
                                }
                                this.n.add((r) eVar.u(r.f24095i, fVar));
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.i(this);
                    }
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if ((i2 & 1) == 1) {
                    this.l = Collections.unmodifiableList(this.l);
                }
                if ((i2 & 2) == 2) {
                    this.m = Collections.unmodifiableList(this.m);
                }
                if ((i2 & 4) == 4) {
                    this.n = Collections.unmodifiableList(this.n);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } finally {
                    this.f24024j = bVarW.e();
                }
                m();
                throw th;
            }
        }
        if ((i2 & 1) == 1) {
            this.l = Collections.unmodifiableList(this.l);
        }
        if ((i2 & 2) == 2) {
            this.m = Collections.unmodifiableList(this.m);
        }
        if ((i2 & 4) == 4) {
            this.n = Collections.unmodifiableList(this.n);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f24024j = bVarW.e();
        }
        m();
    }
}
