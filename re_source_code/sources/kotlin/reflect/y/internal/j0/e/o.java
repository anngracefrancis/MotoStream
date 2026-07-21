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
public final class o extends h implements p {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final o f24043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static q<o> f24044h = new a();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d f24045i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<c> f24046j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte f24047k;
    private int l;

    /* JADX INFO: compiled from: ProtoBuf.java */
    static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<o> {
        a() {
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public o b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new o(eVar, fVar);
        }
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class b extends h.b<o, b> implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f24048g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private List<c> f24049h = Collections.emptyList();

        private b() {
            u();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static b s() {
            return new b();
        }

        private void t() {
            if ((this.f24048g & 1) != 1) {
                this.f24049h = new ArrayList(this.f24049h);
                this.f24048g |= 1;
            }
        }

        private void u() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public o c() {
            o oVarQ = q();
            if (oVarQ.isInitialized()) {
                return oVarQ;
            }
            throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(oVarQ);
        }

        public o q() {
            o oVar = new o(this);
            if ((this.f24048g & 1) == 1) {
                this.f24049h = Collections.unmodifiableList(this.f24049h);
                this.f24048g &= -2;
            }
            oVar.f24046j = this.f24049h;
            return oVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        public b m(o oVar) {
            if (oVar == o.u()) {
                return this;
            }
            if (!oVar.f24046j.isEmpty()) {
                if (this.f24049h.isEmpty()) {
                    this.f24049h = oVar.f24046j;
                    this.f24048g &= -2;
                } else {
                    t();
                    this.f24049h.addAll(oVar.f24046j);
                }
            }
            n(l().f(oVar.f24045i));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:15:0x001d  */
        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
        public b i(e eVar, f fVar) throws Throwable {
            o oVar = null;
            try {
                try {
                    o oVarB = o.f24044h.b(eVar, fVar);
                    if (oVarB != null) {
                        m(oVarB);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    o oVar2 = (o) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        oVar = oVar2;
                        if (oVar != null) {
                            m(oVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (oVar != null) {
                    m(oVar);
                }
                throw th;
            }
        }
    }

    static {
        o oVar = new o(true);
        f24043g = oVar;
        oVar.x();
    }

    public static o u() {
        return f24043g;
    }

    private void x() {
        this.f24046j = Collections.emptyList();
    }

    public static b y() {
        return b.s();
    }

    public static b z(o oVar) {
        return y().m(oVar);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public b f() {
        return y();
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public b d() {
        return z(this);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.l;
        if (i2 != -1) {
            return i2;
        }
        int iS = 0;
        for (int i3 = 0; i3 < this.f24046j.size(); i3++) {
            iS += CodedOutputStream.s(1, this.f24046j.get(i3));
        }
        int size = iS + this.f24045i.size();
        this.l = size;
        return size;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<o> g() {
        return f24044h;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        for (int i2 = 0; i2 < this.f24046j.size(); i2++) {
            codedOutputStream.d0(1, this.f24046j.get(i2));
        }
        codedOutputStream.i0(this.f24045i);
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.f24047k;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < w(); i2++) {
            if (!v(i2).isInitialized()) {
                this.f24047k = (byte) 0;
                return false;
            }
        }
        this.f24047k = (byte) 1;
        return true;
    }

    public c v(int i2) {
        return this.f24046j.get(i2);
    }

    public int w() {
        return this.f24046j.size();
    }

    /* JADX INFO: compiled from: ProtoBuf.java */
    public static final class c extends h implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final c f24050g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static q<c> f24051h = new a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final d f24052i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f24053j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f24054k;
        private int l;
        private EnumC0366c m;
        private byte n;
        private int o;

        /* JADX INFO: compiled from: ProtoBuf.java */
        static class a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<c> {
            a() {
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public c b(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new c(eVar, fVar);
            }
        }

        /* JADX INFO: compiled from: ProtoBuf.java */
        public static final class b extends h.b<c, b> implements p {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f24055g;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private int f24057i;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private int f24056h = -1;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private EnumC0366c f24058j = EnumC0366c.PACKAGE;

            private b() {
                t();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b s() {
                return new b();
            }

            private void t() {
            }

            public b A(int i2) {
                this.f24055g |= 1;
                this.f24056h = i2;
                return this;
            }

            public b B(int i2) {
                this.f24055g |= 2;
                this.f24057i = i2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
            /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
            public c c() {
                c cVarQ = q();
                if (cVarQ.isInitialized()) {
                    return cVarQ;
                }
                throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(cVarQ);
            }

            public c q() {
                c cVar = new c(this);
                int i2 = this.f24055g;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                cVar.f24054k = this.f24056h;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                cVar.l = this.f24057i;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                cVar.m = this.f24058j;
                cVar.f24053j = i3;
                return cVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public b k() {
                return s().m(q());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public b m(c cVar) {
                if (cVar == c.w()) {
                    return this;
                }
                if (cVar.B()) {
                    A(cVar.y());
                }
                if (cVar.C()) {
                    B(cVar.z());
                }
                if (cVar.A()) {
                    w(cVar.x());
                }
                n(l().f(cVar.f24052i));
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public b i(e eVar, f fVar) throws Throwable {
                c cVar = null;
                try {
                    try {
                        c cVarB = c.f24051h.b(eVar, fVar);
                        if (cVarB != null) {
                            m(cVarB);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        c cVar2 = (c) e2.a();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            cVar = cVar2;
                            if (cVar != null) {
                                m(cVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (cVar != null) {
                        m(cVar);
                    }
                    throw th;
                }
            }

            public b w(EnumC0366c enumC0366c) {
                enumC0366c.getClass();
                this.f24055g |= 4;
                this.f24058j = enumC0366c;
                return this;
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.o$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ProtoBuf.java */
        public enum EnumC0366c implements i.a {
            CLASS(0, 0),
            PACKAGE(1, 1),
            LOCAL(2, 2);


            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private static i.b<EnumC0366c> f24062i = new a();

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private final int f24064k;

            /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.o$c$c$a */
            /* JADX INFO: compiled from: ProtoBuf.java */
            static class a implements i.b<EnumC0366c> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumC0366c a(int i2) {
                    return EnumC0366c.g(i2);
                }
            }

            EnumC0366c(int i2, int i3) {
                this.f24064k = i3;
            }

            public static EnumC0366c g(int i2) {
                if (i2 == 0) {
                    return CLASS;
                }
                if (i2 == 1) {
                    return PACKAGE;
                }
                if (i2 != 2) {
                    return null;
                }
                return LOCAL;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
            public final int f() {
                return this.f24064k;
            }
        }

        static {
            c cVar = new c(true);
            f24050g = cVar;
            cVar.D();
        }

        private void D() {
            this.f24054k = -1;
            this.l = 0;
            this.m = EnumC0366c.PACKAGE;
        }

        public static b E() {
            return b.s();
        }

        public static b F(c cVar) {
            return E().m(cVar);
        }

        public static c w() {
            return f24050g;
        }

        public boolean A() {
            return (this.f24053j & 4) == 4;
        }

        public boolean B() {
            return (this.f24053j & 1) == 1;
        }

        public boolean C() {
            return (this.f24053j & 2) == 2;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public b f() {
            return E();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public b d() {
            return F(this);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public int e() {
            int i2 = this.o;
            if (i2 != -1) {
                return i2;
            }
            int iO = (this.f24053j & 1) == 1 ? 0 + CodedOutputStream.o(1, this.f24054k) : 0;
            if ((this.f24053j & 2) == 2) {
                iO += CodedOutputStream.o(2, this.l);
            }
            if ((this.f24053j & 4) == 4) {
                iO += CodedOutputStream.h(3, this.m.f());
            }
            int size = iO + this.f24052i.size();
            this.o = size;
            return size;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public q<c> g() {
            return f24051h;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public void h(CodedOutputStream codedOutputStream) throws IOException {
            e();
            if ((this.f24053j & 1) == 1) {
                codedOutputStream.a0(1, this.f24054k);
            }
            if ((this.f24053j & 2) == 2) {
                codedOutputStream.a0(2, this.l);
            }
            if ((this.f24053j & 4) == 4) {
                codedOutputStream.S(3, this.m.f());
            }
            codedOutputStream.i0(this.f24052i);
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
            if (C()) {
                this.n = (byte) 1;
                return true;
            }
            this.n = (byte) 0;
            return false;
        }

        public EnumC0366c x() {
            return this.m;
        }

        public int y() {
            return this.f24054k;
        }

        public int z() {
            return this.l;
        }

        private c(h.b bVar) {
            super(bVar);
            this.n = (byte) -1;
            this.o = -1;
            this.f24052i = bVar.l();
        }

        private c(boolean z) {
            this.n = (byte) -1;
            this.o = -1;
            this.f24052i = d.f25399f;
        }

        private c(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.n = (byte) -1;
            this.o = -1;
            D();
            d.b bVarW = d.w();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.f24053j |= 1;
                                this.f24054k = eVar.s();
                            } else if (iK == 16) {
                                this.f24053j |= 2;
                                this.l = eVar.s();
                            } else if (iK != 24) {
                                if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                }
                            } else {
                                int iN = eVar.n();
                                EnumC0366c enumC0366cG = EnumC0366c.g(iN);
                                if (enumC0366cG == null) {
                                    codedOutputStreamJ.o0(iK);
                                    codedOutputStreamJ.o0(iN);
                                } else {
                                    this.f24053j |= 4;
                                    this.m = enumC0366cG;
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
                        this.f24052i = bVarW.e();
                    }
                    m();
                    throw th;
                }
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } finally {
                this.f24052i = bVarW.e();
            }
            m();
        }
    }

    private o(h.b bVar) {
        super(bVar);
        this.f24047k = (byte) -1;
        this.l = -1;
        this.f24045i = bVar.l();
    }

    private o(boolean z) {
        this.f24047k = (byte) -1;
        this.l = -1;
        this.f24045i = d.f25399f;
    }

    private o(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.f24047k = (byte) -1;
        this.l = -1;
        x();
        d.b bVarW = d.w();
        CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    int iK = eVar.K();
                    if (iK != 0) {
                        if (iK != 10) {
                            if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                            }
                        } else {
                            if (!(z2 & true)) {
                                this.f24046j = new ArrayList();
                                z2 |= true;
                            }
                            this.f24046j.add((c) eVar.u(c.f24051h, fVar));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.f24046j = Collections.unmodifiableList(this.f24046j);
                    }
                    try {
                        codedOutputStreamJ.I();
                    } catch (IOException unused) {
                    } finally {
                        this.f24045i = bVarW.e();
                    }
                    m();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e2) {
                throw e2.i(this);
            } catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
            }
        }
        if (z2 & true) {
            this.f24046j = Collections.unmodifiableList(this.f24046j);
        }
        try {
            codedOutputStreamJ.I();
        } catch (IOException unused2) {
        } finally {
            this.f24045i = bVarW.e();
        }
        m();
    }
}
