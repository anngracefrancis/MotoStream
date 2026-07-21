package kotlin.reflect.y.internal.j0.e;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdRequest;
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

/* JADX INFO: compiled from: ProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends h.d<q> implements p {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final q f24072h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static kotlin.p002reflect.jvm.internal.impl.protobuf.q<q> f24073i = new a();
    private int A;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final d f24074j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f24075k;
    private List<b> l;
    private boolean m;
    private int n;
    private q o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private q u;
    private int v;
    private q w;
    private int x;
    private int y;
    private byte z;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<q> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public q b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new q(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class c extends h.c<q, c> implements p {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f24091i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private boolean f24093k;
        private int l;
        private int n;
        private int o;
        private int p;
        private int q;
        private int r;
        private int t;
        private int v;
        private int w;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<b> f24092j = Collections.emptyList();
        private q m = q.Y();
        private q s = q.Y();
        private q u = q.Y();

        private c() {
            B();
        }

        private void A() {
            if ((this.f24091i & 1) != 1) {
                this.f24092j = new ArrayList(this.f24092j);
                this.f24091i |= 1;
            }
        }

        private void B() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static c w() {
            return new c();
        }

        public c C(q qVar) {
            if ((this.f24091i & RecyclerView.l.FLAG_MOVED) != 2048 || this.u == q.Y()) {
                this.u = qVar;
            } else {
                this.u = q.z0(this.u).m(qVar).u();
            }
            this.f24091i |= RecyclerView.l.FLAG_MOVED;
            return this;
        }

        public c D(q qVar) {
            if ((this.f24091i & 8) != 8 || this.m == q.Y()) {
                this.m = qVar;
            } else {
                this.m = q.z0(this.m).m(qVar).u();
            }
            this.f24091i |= 8;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public c m(q qVar) {
            if (qVar == q.Y()) {
                return this;
            }
            if (!qVar.l.isEmpty()) {
                if (this.f24092j.isEmpty()) {
                    this.f24092j = qVar.l;
                    this.f24091i &= -2;
                } else {
                    A();
                    this.f24092j.addAll(qVar.l);
                }
            }
            if (qVar.r0()) {
                M(qVar.e0());
            }
            if (qVar.o0()) {
                K(qVar.b0());
            }
            if (qVar.p0()) {
                D(qVar.c0());
            }
            if (qVar.q0()) {
                L(qVar.d0());
            }
            if (qVar.m0()) {
                I(qVar.X());
            }
            if (qVar.v0()) {
                P(qVar.i0());
            }
            if (qVar.w0()) {
                Q(qVar.j0());
            }
            if (qVar.u0()) {
                O(qVar.h0());
            }
            if (qVar.s0()) {
                G(qVar.f0());
            }
            if (qVar.t0()) {
                N(qVar.g0());
            }
            if (qVar.k0()) {
                C(qVar.R());
            }
            if (qVar.l0()) {
                H(qVar.S());
            }
            if (qVar.n0()) {
                J(qVar.a0());
            }
            r(qVar);
            n(l().f(qVar.f24074j));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public c i(e eVar, f fVar) throws Throwable {
            q qVar = null;
            try {
                try {
                    q qVarB = q.f24073i.b(eVar, fVar);
                    if (qVarB != null) {
                        m(qVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    q qVar2 = (q) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        qVar = qVar2;
                        if (qVar != null) {
                            m(qVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (qVar != null) {
                    m(qVar);
                }
                throw th;
            }
        }

        public c G(q qVar) {
            if ((this.f24091i & AdRequest.MAX_CONTENT_URL_LENGTH) != 512 || this.s == q.Y()) {
                this.s = qVar;
            } else {
                this.s = q.z0(this.s).m(qVar).u();
            }
            this.f24091i |= AdRequest.MAX_CONTENT_URL_LENGTH;
            return this;
        }

        public c H(int i2) {
            this.f24091i |= RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
            this.v = i2;
            return this;
        }

        public c I(int i2) {
            this.f24091i |= 32;
            this.o = i2;
            return this;
        }

        public c J(int i2) {
            this.f24091i |= 8192;
            this.w = i2;
            return this;
        }

        public c K(int i2) {
            this.f24091i |= 4;
            this.l = i2;
            return this;
        }

        public c L(int i2) {
            this.f24091i |= 16;
            this.n = i2;
            return this;
        }

        public c M(boolean z) {
            this.f24091i |= 2;
            this.f24093k = z;
            return this;
        }

        public c N(int i2) {
            this.f24091i |= 1024;
            this.t = i2;
            return this;
        }

        public c O(int i2) {
            this.f24091i |= 256;
            this.r = i2;
            return this;
        }

        public c P(int i2) {
            this.f24091i |= 64;
            this.p = i2;
            return this;
        }

        public c Q(int i2) {
            this.f24091i |= 128;
            this.q = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public q c() {
            q qVarU = u();
            if (qVarU.isInitialized()) {
                return qVarU;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(qVarU);
        }

        public q u() {
            q qVar = new q(this);
            int i2 = this.f24091i;
            if ((i2 & 1) == 1) {
                this.f24092j = Collections.unmodifiableList(this.f24092j);
                this.f24091i &= -2;
            }
            qVar.l = this.f24092j;
            int i3 = (i2 & 2) != 2 ? 0 : 1;
            qVar.m = this.f24093k;
            if ((i2 & 4) == 4) {
                i3 |= 2;
            }
            qVar.n = this.l;
            if ((i2 & 8) == 8) {
                i3 |= 4;
            }
            qVar.o = this.m;
            if ((i2 & 16) == 16) {
                i3 |= 8;
            }
            qVar.p = this.n;
            if ((i2 & 32) == 32) {
                i3 |= 16;
            }
            qVar.q = this.o;
            if ((i2 & 64) == 64) {
                i3 |= 32;
            }
            qVar.r = this.p;
            if ((i2 & 128) == 128) {
                i3 |= 64;
            }
            qVar.s = this.q;
            if ((i2 & 256) == 256) {
                i3 |= 128;
            }
            qVar.t = this.r;
            if ((i2 & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
                i3 |= 256;
            }
            qVar.u = this.s;
            if ((i2 & 1024) == 1024) {
                i3 |= AdRequest.MAX_CONTENT_URL_LENGTH;
            }
            qVar.v = this.t;
            if ((i2 & RecyclerView.l.FLAG_MOVED) == 2048) {
                i3 |= 1024;
            }
            qVar.w = this.u;
            if ((i2 & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) == 4096) {
                i3 |= RecyclerView.l.FLAG_MOVED;
            }
            qVar.x = this.v;
            if ((i2 & 8192) == 8192) {
                i3 |= RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
            }
            qVar.y = this.w;
            qVar.f24075k = i3;
            return qVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public c k() {
            return w().m(u());
        }
    }

    static {
        q qVar = new q(true);
        f24072h = qVar;
        qVar.x0();
    }

    public static q Y() {
        return f24072h;
    }

    private void x0() {
        this.l = Collections.emptyList();
        this.m = false;
        this.n = 0;
        this.o = Y();
        this.p = 0;
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = Y();
        this.v = 0;
        this.w = Y();
        this.x = 0;
        this.y = 0;
    }

    public static c y0() {
        return c.w();
    }

    public static c z0(q qVar) {
        return y0().m(qVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: A0, reason: merged with bridge method [inline-methods] */
    public c f() {
        return y0();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public c d() {
        return z0(this);
    }

    public q R() {
        return this.w;
    }

    public int S() {
        return this.x;
    }

    public b T(int i2) {
        return this.l.get(i2);
    }

    public int U() {
        return this.l.size();
    }

    public List<b> V() {
        return this.l;
    }

    public int X() {
        return this.q;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public q b() {
        return f24072h;
    }

    public int a0() {
        return this.y;
    }

    public int b0() {
        return this.n;
    }

    public q c0() {
        return this.o;
    }

    public int d0() {
        return this.p;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.A;
        if (i2 != -1) {
            return i2;
        }
        int iO = (this.f24075k & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) == 4096 ? CodedOutputStream.o(1, this.y) + 0 : 0;
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            iO += CodedOutputStream.s(2, this.l.get(i3));
        }
        if ((this.f24075k & 1) == 1) {
            iO += CodedOutputStream.a(3, this.m);
        }
        if ((this.f24075k & 2) == 2) {
            iO += CodedOutputStream.o(4, this.n);
        }
        if ((this.f24075k & 4) == 4) {
            iO += CodedOutputStream.s(5, this.o);
        }
        if ((this.f24075k & 16) == 16) {
            iO += CodedOutputStream.o(6, this.q);
        }
        if ((this.f24075k & 32) == 32) {
            iO += CodedOutputStream.o(7, this.r);
        }
        if ((this.f24075k & 8) == 8) {
            iO += CodedOutputStream.o(8, this.p);
        }
        if ((this.f24075k & 64) == 64) {
            iO += CodedOutputStream.o(9, this.s);
        }
        if ((this.f24075k & 256) == 256) {
            iO += CodedOutputStream.s(10, this.u);
        }
        if ((this.f24075k & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
            iO += CodedOutputStream.o(11, this.v);
        }
        if ((this.f24075k & 128) == 128) {
            iO += CodedOutputStream.o(12, this.t);
        }
        if ((this.f24075k & 1024) == 1024) {
            iO += CodedOutputStream.s(13, this.w);
        }
        if ((this.f24075k & RecyclerView.l.FLAG_MOVED) == 2048) {
            iO += CodedOutputStream.o(14, this.x);
        }
        int iT = iO + t() + this.f24074j.size();
        this.A = iT;
        return iT;
    }

    public boolean e0() {
        return this.m;
    }

    public q f0() {
        return this.u;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public kotlin.p002reflect.jvm.internal.impl.protobuf.q<q> g() {
        return f24073i;
    }

    public int g0() {
        return this.v;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a aVarY = y();
        if ((this.f24075k & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) == 4096) {
            codedOutputStream.a0(1, this.y);
        }
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            codedOutputStream.d0(2, this.l.get(i2));
        }
        if ((this.f24075k & 1) == 1) {
            codedOutputStream.L(3, this.m);
        }
        if ((this.f24075k & 2) == 2) {
            codedOutputStream.a0(4, this.n);
        }
        if ((this.f24075k & 4) == 4) {
            codedOutputStream.d0(5, this.o);
        }
        if ((this.f24075k & 16) == 16) {
            codedOutputStream.a0(6, this.q);
        }
        if ((this.f24075k & 32) == 32) {
            codedOutputStream.a0(7, this.r);
        }
        if ((this.f24075k & 8) == 8) {
            codedOutputStream.a0(8, this.p);
        }
        if ((this.f24075k & 64) == 64) {
            codedOutputStream.a0(9, this.s);
        }
        if ((this.f24075k & 256) == 256) {
            codedOutputStream.d0(10, this.u);
        }
        if ((this.f24075k & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
            codedOutputStream.a0(11, this.v);
        }
        if ((this.f24075k & 128) == 128) {
            codedOutputStream.a0(12, this.t);
        }
        if ((this.f24075k & 1024) == 1024) {
            codedOutputStream.d0(13, this.w);
        }
        if ((this.f24075k & RecyclerView.l.FLAG_MOVED) == 2048) {
            codedOutputStream.a0(14, this.x);
        }
        aVarY.a(200, codedOutputStream);
        codedOutputStream.i0(this.f24074j);
    }

    public int h0() {
        return this.t;
    }

    public int i0() {
        return this.r;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.z;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < U(); i2++) {
            if (!T(i2).isInitialized()) {
                this.z = (byte) 0;
                return false;
            }
        }
        if (p0() && !c0().isInitialized()) {
            this.z = (byte) 0;
            return false;
        }
        if (s0() && !f0().isInitialized()) {
            this.z = (byte) 0;
            return false;
        }
        if (k0() && !R().isInitialized()) {
            this.z = (byte) 0;
            return false;
        }
        if (s()) {
            this.z = (byte) 1;
            return true;
        }
        this.z = (byte) 0;
        return false;
    }

    public int j0() {
        return this.s;
    }

    public boolean k0() {
        return (this.f24075k & 1024) == 1024;
    }

    public boolean l0() {
        return (this.f24075k & RecyclerView.l.FLAG_MOVED) == 2048;
    }

    public boolean m0() {
        return (this.f24075k & 16) == 16;
    }

    public boolean n0() {
        return (this.f24075k & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) == 4096;
    }

    public boolean o0() {
        return (this.f24075k & 2) == 2;
    }

    public boolean p0() {
        return (this.f24075k & 4) == 4;
    }

    public boolean q0() {
        return (this.f24075k & 8) == 8;
    }

    public boolean r0() {
        return (this.f24075k & 1) == 1;
    }

    public boolean s0() {
        return (this.f24075k & 256) == 256;
    }

    public boolean t0() {
        return (this.f24075k & AdRequest.MAX_CONTENT_URL_LENGTH) == 512;
    }

    public boolean u0() {
        return (this.f24075k & 128) == 128;
    }

    public boolean v0() {
        return (this.f24075k & 32) == 32;
    }

    public boolean w0() {
        return (this.f24075k & 64) == 64;
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final b f24076g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static kotlin.p002reflect.jvm.internal.impl.protobuf.q<b> f24077h = new a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final d f24078i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f24079j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private c f24080k;
        private q l;
        private int m;
        private byte n;
        private int o;

        /* JADX INFO: compiled from: ProtoBuf.java */
        static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<b> {
            a() {
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b b(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new b(eVar, fVar);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.q$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public static final class C0367b extends h.b<b, C0367b> implements p {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f24081g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private c f24082h = c.INV;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private q f24083i = q.Y();

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private int f24084j;

            private C0367b() {
                t();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0367b s() {
                return new C0367b();
            }

            private void t() {
            }

            public C0367b A(c cVar) {
                cVar.getClass();
                this.f24081g |= 1;
                this.f24082h = cVar;
                return this;
            }

            public C0367b B(int i2) {
                this.f24081g |= 4;
                this.f24084j = i2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
            /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
            public b c() {
                b bVarQ = q();
                if (bVarQ.isInitialized()) {
                    return bVarQ;
                }
                throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(bVarQ);
            }

            public b q() {
                b bVar = new b(this);
                int i2 = this.f24081g;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                bVar.f24080k = this.f24082h;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                bVar.l = this.f24083i;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                bVar.m = this.f24084j;
                bVar.f24079j = i3;
                return bVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public C0367b k() {
                return s().m(q());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public C0367b m(b bVar) {
                if (bVar == b.w()) {
                    return this;
                }
                if (bVar.A()) {
                    A(bVar.x());
                }
                if (bVar.B()) {
                    w(bVar.y());
                }
                if (bVar.C()) {
                    B(bVar.z());
                }
                n(l().f(bVar.f24078i));
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public C0367b i(e eVar, f fVar) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b bVarB = b.f24077h.b(eVar, fVar);
                        if (bVarB != null) {
                            m(bVarB);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        b bVar2 = (b) e2.a();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            bVar = bVar2;
                            if (bVar != null) {
                                m(bVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (bVar != null) {
                        m(bVar);
                    }
                    throw th;
                }
            }

            public C0367b w(q qVar) {
                if ((this.f24081g & 2) != 2 || this.f24083i == q.Y()) {
                    this.f24083i = qVar;
                } else {
                    this.f24083i = q.z0(this.f24083i).m(qVar).u();
                }
                this.f24081g |= 2;
                return this;
            }
        }

        /* JADX INFO: compiled from: ProtoBuf.java */
        public enum c implements i.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2),
            STAR(3, 3);


            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private static i.b<c> f24089j = new a();
            private final int l;

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
                this.l = i3;
            }

            public static c g(int i2) {
                if (i2 == 0) {
                    return IN;
                }
                if (i2 == 1) {
                    return OUT;
                }
                if (i2 == 2) {
                    return INV;
                }
                if (i2 != 3) {
                    return null;
                }
                return STAR;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
            public final int f() {
                return this.l;
            }
        }

        static {
            b bVar = new b(true);
            f24076g = bVar;
            bVar.D();
        }

        private void D() {
            this.f24080k = c.INV;
            this.l = q.Y();
            this.m = 0;
        }

        public static C0367b E() {
            return C0367b.s();
        }

        public static C0367b F(b bVar) {
            return E().m(bVar);
        }

        public static b w() {
            return f24076g;
        }

        public boolean A() {
            return (this.f24079j & 1) == 1;
        }

        public boolean B() {
            return (this.f24079j & 2) == 2;
        }

        public boolean C() {
            return (this.f24079j & 4) == 4;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public C0367b f() {
            return E();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public C0367b d() {
            return F(this);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public int e() {
            int i2 = this.o;
            if (i2 != -1) {
                return i2;
            }
            int iH = (this.f24079j & 1) == 1 ? 0 + CodedOutputStream.h(1, this.f24080k.f()) : 0;
            if ((this.f24079j & 2) == 2) {
                iH += CodedOutputStream.s(2, this.l);
            }
            if ((this.f24079j & 4) == 4) {
                iH += CodedOutputStream.o(3, this.m);
            }
            int size = iH + this.f24078i.size();
            this.o = size;
            return size;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public kotlin.p002reflect.jvm.internal.impl.protobuf.q<b> g() {
            return f24077h;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public void h(CodedOutputStream codedOutputStream) throws IOException {
            e();
            if ((this.f24079j & 1) == 1) {
                codedOutputStream.S(1, this.f24080k.f());
            }
            if ((this.f24079j & 2) == 2) {
                codedOutputStream.d0(2, this.l);
            }
            if ((this.f24079j & 4) == 4) {
                codedOutputStream.a0(3, this.m);
            }
            codedOutputStream.i0(this.f24078i);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
        public final boolean isInitialized() {
            byte b2 = this.n;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!B() || y().isInitialized()) {
                this.n = (byte) 1;
                return true;
            }
            this.n = (byte) 0;
            return false;
        }

        public c x() {
            return this.f24080k;
        }

        public q y() {
            return this.l;
        }

        public int z() {
            return this.m;
        }

        private b(h.b bVar) {
            super(bVar);
            this.n = (byte) -1;
            this.o = -1;
            this.f24078i = bVar.l();
        }

        private b(boolean z) {
            this.n = (byte) -1;
            this.o = -1;
            this.f24078i = d.f25399f;
        }

        private b(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.n = (byte) -1;
            this.o = -1;
            D();
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
                                    int iN = eVar.n();
                                    c cVarG = c.g(iN);
                                    if (cVarG == null) {
                                        codedOutputStreamJ.o0(iK);
                                        codedOutputStreamJ.o0(iN);
                                    } else {
                                        this.f24079j |= 1;
                                        this.f24080k = cVarG;
                                    }
                                } else if (iK == 18) {
                                    c cVarD = (this.f24079j & 2) == 2 ? this.l.d() : null;
                                    q qVar = (q) eVar.u(q.f24073i, fVar);
                                    this.l = qVar;
                                    if (cVarD != null) {
                                        cVarD.m(qVar);
                                        this.l = cVarD.u();
                                    }
                                    this.f24079j |= 2;
                                } else if (iK != 24) {
                                    if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                    }
                                } else {
                                    this.f24079j |= 4;
                                    this.m = eVar.s();
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
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } finally {
                        this.f24078i = bVarW.e();
                    }
                    m();
                    throw th;
                }
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } finally {
                this.f24078i = bVarW.e();
            }
            m();
        }
    }

    private q(h.c<q, ?> cVar) {
        super(cVar);
        this.z = (byte) -1;
        this.A = -1;
        this.f24074j = cVar.l();
    }

    private q(boolean z) {
        this.z = (byte) -1;
        this.A = -1;
        this.f24074j = d.f25399f;
    }

    private q(e eVar, f fVar) throws InvalidProtocolBufferException {
        c cVarD;
        this.z = (byte) -1;
        this.A = -1;
        x0();
        d.b bVarW = d.w();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    int iK = eVar.K();
                    switch (iK) {
                        case 0:
                            break;
                        case 8:
                            this.f24075k |= RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
                            this.y = eVar.s();
                            continue;
                        case 18:
                            if (!(z2 & true)) {
                                this.l = new ArrayList();
                                z2 |= true;
                            }
                            this.l.add((b) eVar.u(b.f24077h, fVar));
                            continue;
                        case 24:
                            this.f24075k |= 1;
                            this.m = eVar.k();
                            continue;
                        case 32:
                            this.f24075k |= 2;
                            this.n = eVar.s();
                            continue;
                        case 42:
                            cVarD = (this.f24075k & 4) == 4 ? this.o.d() : null;
                            q qVar = (q) eVar.u(f24073i, fVar);
                            this.o = qVar;
                            if (cVarD != null) {
                                cVarD.m(qVar);
                                this.o = cVarD.u();
                            }
                            this.f24075k |= 4;
                            continue;
                        case 48:
                            this.f24075k |= 16;
                            this.q = eVar.s();
                            continue;
                        case 56:
                            this.f24075k |= 32;
                            this.r = eVar.s();
                            continue;
                        case 64:
                            this.f24075k |= 8;
                            this.p = eVar.s();
                            continue;
                        case 72:
                            this.f24075k |= 64;
                            this.s = eVar.s();
                            continue;
                        case 82:
                            cVarD = (this.f24075k & 256) == 256 ? this.u.d() : null;
                            q qVar2 = (q) eVar.u(f24073i, fVar);
                            this.u = qVar2;
                            if (cVarD != null) {
                                cVarD.m(qVar2);
                                this.u = cVarD.u();
                            }
                            this.f24075k |= 256;
                            continue;
                        case 88:
                            this.f24075k |= AdRequest.MAX_CONTENT_URL_LENGTH;
                            this.v = eVar.s();
                            continue;
                        case 96:
                            this.f24075k |= 128;
                            this.t = eVar.s();
                            continue;
                        case 106:
                            cVarD = (this.f24075k & 1024) == 1024 ? this.w.d() : null;
                            q qVar3 = (q) eVar.u(f24073i, fVar);
                            this.w = qVar3;
                            if (cVarD != null) {
                                cVarD.m(qVar3);
                                this.w = cVarD.u();
                            }
                            this.f24075k |= 1024;
                            continue;
                        case 112:
                            this.f24075k |= RecyclerView.l.FLAG_MOVED;
                            this.x = eVar.s();
                            continue;
                        default:
                            if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                break;
                            }
                            break;
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.i(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if (z2 & true) {
                    this.l = Collections.unmodifiableList(this.l);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused) {
                } finally {
                    this.f24074j = bVarW.e();
                }
                m();
                throw th;
            }
        }
        if (z2 & true) {
            this.l = Collections.unmodifiableList(this.l);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f24074j = bVarW.e();
        }
        m();
    }
}
