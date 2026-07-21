package kotlin.reflect.y.internal.j0.e.a0;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.p002reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.p002reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.p002reflect.jvm.internal.impl.protobuf.f;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;
import kotlin.p002reflect.jvm.internal.impl.protobuf.p;
import kotlin.p002reflect.jvm.internal.impl.protobuf.w;
import kotlin.reflect.y.internal.j0.e.i;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.s;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: JvmProtoBuf.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final h.f<kotlin.reflect.y.internal.j0.e.d, c> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h.f<i, c> f23821b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h.f<i, Integer> f23822c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h.f<n, d> f23823d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final h.f<n, Integer> f23824e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final h.f<q, List<kotlin.reflect.y.internal.j0.e.b>> f23825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final h.f<q, Boolean> f23826g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final h.f<s, List<kotlin.reflect.y.internal.j0.e.b>> f23827h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final h.f<kotlin.reflect.y.internal.j0.e.c, Integer> f23828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final h.f<kotlin.reflect.y.internal.j0.e.c, List<n>> f23829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final h.f<kotlin.reflect.y.internal.j0.e.c, Integer> f23830k;
    public static final h.f<kotlin.reflect.y.internal.j0.e.c, Integer> l;
    public static final h.f<l, Integer> m;
    public static final h.f<l, List<n>> n;

    /* JADX INFO: compiled from: JvmProtoBuf.java */
    public static final class e extends h implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final e f23857g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static kotlin.p002reflect.jvm.internal.impl.protobuf.q<e> f23858h = new C0357a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final kotlin.p002reflect.jvm.internal.impl.protobuf.d f23859i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private List<c> f23860j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private List<Integer> f23861k;
        private int l;
        private byte m;
        private int n;

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.a0.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        static class C0357a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<e> {
            C0357a() {
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public e b(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new e(eVar, fVar);
            }
        }

        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static final class b extends h.b<e, b> implements p {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f23862g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private List<c> f23863h = Collections.emptyList();

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private List<Integer> f23864i = Collections.emptyList();

            private b() {
                v();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b s() {
                return new b();
            }

            private void t() {
                if ((this.f23862g & 2) != 2) {
                    this.f23864i = new ArrayList(this.f23864i);
                    this.f23862g |= 2;
                }
            }

            private void u() {
                if ((this.f23862g & 1) != 1) {
                    this.f23863h = new ArrayList(this.f23863h);
                    this.f23862g |= 1;
                }
            }

            private void v() {
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
            /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
            public b i(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws Throwable {
                e eVar2 = null;
                try {
                    try {
                        e eVarB = e.f23858h.b(eVar, fVar);
                        if (eVarB != null) {
                            m(eVarB);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        e eVar3 = (e) e2.a();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            eVar2 = eVar3;
                            if (eVar2 != null) {
                                m(eVar2);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (eVar2 != null) {
                        m(eVar2);
                    }
                    throw th;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
            /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
            public e c() {
                e eVarQ = q();
                if (eVarQ.isInitialized()) {
                    return eVarQ;
                }
                throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(eVarQ);
            }

            public e q() {
                e eVar = new e(this);
                if ((this.f23862g & 1) == 1) {
                    this.f23863h = Collections.unmodifiableList(this.f23863h);
                    this.f23862g &= -2;
                }
                eVar.f23860j = this.f23863h;
                if ((this.f23862g & 2) == 2) {
                    this.f23864i = Collections.unmodifiableList(this.f23864i);
                    this.f23862g &= -3;
                }
                eVar.f23861k = this.f23864i;
                return eVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public b k() {
                return s().m(q());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
            public b m(e eVar) {
                if (eVar == e.w()) {
                    return this;
                }
                if (!eVar.f23860j.isEmpty()) {
                    if (this.f23863h.isEmpty()) {
                        this.f23863h = eVar.f23860j;
                        this.f23862g &= -2;
                    } else {
                        u();
                        this.f23863h.addAll(eVar.f23860j);
                    }
                }
                if (!eVar.f23861k.isEmpty()) {
                    if (this.f23864i.isEmpty()) {
                        this.f23864i = eVar.f23861k;
                        this.f23862g &= -3;
                    } else {
                        t();
                        this.f23864i.addAll(eVar.f23861k);
                    }
                }
                n(l().f(eVar.f23859i));
                return this;
            }
        }

        static {
            e eVar = new e(true);
            f23857g = eVar;
            eVar.z();
        }

        public static b A() {
            return b.s();
        }

        public static b B(e eVar) {
            return A().m(eVar);
        }

        public static e D(InputStream inputStream, f fVar) throws IOException {
            return f23858h.c(inputStream, fVar);
        }

        public static e w() {
            return f23857g;
        }

        private void z() {
            this.f23860j = Collections.emptyList();
            this.f23861k = Collections.emptyList();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public b f() {
            return A();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public b d() {
            return B(this);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public int e() {
            int i2 = this.n;
            if (i2 != -1) {
                return i2;
            }
            int iS = 0;
            for (int i3 = 0; i3 < this.f23860j.size(); i3++) {
                iS += CodedOutputStream.s(1, this.f23860j.get(i3));
            }
            int iP = 0;
            for (int i4 = 0; i4 < this.f23861k.size(); i4++) {
                iP += CodedOutputStream.p(this.f23861k.get(i4).intValue());
            }
            int iP2 = iS + iP;
            if (!x().isEmpty()) {
                iP2 = iP2 + 1 + CodedOutputStream.p(iP);
            }
            this.l = iP;
            int size = iP2 + this.f23859i.size();
            this.n = size;
            return size;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public kotlin.p002reflect.jvm.internal.impl.protobuf.q<e> g() {
            return f23858h;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public void h(CodedOutputStream codedOutputStream) throws IOException {
            e();
            for (int i2 = 0; i2 < this.f23860j.size(); i2++) {
                codedOutputStream.d0(1, this.f23860j.get(i2));
            }
            if (x().size() > 0) {
                codedOutputStream.o0(42);
                codedOutputStream.o0(this.l);
            }
            for (int i3 = 0; i3 < this.f23861k.size(); i3++) {
                codedOutputStream.b0(this.f23861k.get(i3).intValue());
            }
            codedOutputStream.i0(this.f23859i);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.m = (byte) 1;
            return true;
        }

        public List<Integer> x() {
            return this.f23861k;
        }

        public List<c> y() {
            return this.f23860j;
        }

        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static final class c extends h implements p {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private static final c f23865g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public static kotlin.p002reflect.jvm.internal.impl.protobuf.q<c> f23866h = new C0358a();

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private final kotlin.p002reflect.jvm.internal.impl.protobuf.d f23867i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private int f23868j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private int f23869k;
            private int l;
            private Object m;
            private EnumC0359c n;
            private List<Integer> o;
            private int p;
            private List<Integer> q;
            private int r;
            private byte s;
            private int t;

            /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.a0.a$e$c$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: JvmProtoBuf.java */
            static class C0358a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<c> {
                C0358a() {
                }

                @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public c b(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                    return new c(eVar, fVar);
                }
            }

            /* JADX INFO: compiled from: JvmProtoBuf.java */
            public static final class b extends h.b<c, b> implements p {

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private int f23870g;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                private int f23872i;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                private int f23871h = 1;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                private Object f23873j = HttpUrl.FRAGMENT_ENCODE_SET;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                private EnumC0359c f23874k = EnumC0359c.NONE;
                private List<Integer> l = Collections.emptyList();
                private List<Integer> m = Collections.emptyList();

                private b() {
                    v();
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static b s() {
                    return new b();
                }

                private void t() {
                    if ((this.f23870g & 32) != 32) {
                        this.m = new ArrayList(this.m);
                        this.f23870g |= 32;
                    }
                }

                private void u() {
                    if ((this.f23870g & 16) != 16) {
                        this.l = new ArrayList(this.l);
                        this.f23870g |= 16;
                    }
                }

                private void v() {
                }

                /* JADX WARN: Code duplicated, block: B:15:0x001d  */
                @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
                /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
                public b i(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws Throwable {
                    c cVar = null;
                    try {
                        try {
                            c cVarB = c.f23866h.b(eVar, fVar);
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

                public b B(EnumC0359c enumC0359c) {
                    enumC0359c.getClass();
                    this.f23870g |= 8;
                    this.f23874k = enumC0359c;
                    return this;
                }

                public b C(int i2) {
                    this.f23870g |= 2;
                    this.f23872i = i2;
                    return this;
                }

                public b D(int i2) {
                    this.f23870g |= 1;
                    this.f23871h = i2;
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
                    int i2 = this.f23870g;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    cVar.f23869k = this.f23871h;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    cVar.l = this.f23872i;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    cVar.m = this.f23873j;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    cVar.n = this.f23874k;
                    if ((this.f23870g & 16) == 16) {
                        this.l = Collections.unmodifiableList(this.l);
                        this.f23870g &= -17;
                    }
                    cVar.o = this.l;
                    if ((this.f23870g & 32) == 32) {
                        this.m = Collections.unmodifiableList(this.m);
                        this.f23870g &= -33;
                    }
                    cVar.q = this.m;
                    cVar.f23868j = i3;
                    return cVar;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
                public b k() {
                    return s().m(q());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
                public b m(c cVar) {
                    if (cVar == c.C()) {
                        return this;
                    }
                    if (cVar.O()) {
                        D(cVar.F());
                    }
                    if (cVar.N()) {
                        C(cVar.E());
                    }
                    if (cVar.P()) {
                        this.f23870g |= 4;
                        this.f23873j = cVar.m;
                    }
                    if (cVar.M()) {
                        B(cVar.D());
                    }
                    if (!cVar.o.isEmpty()) {
                        if (this.l.isEmpty()) {
                            this.l = cVar.o;
                            this.f23870g &= -17;
                        } else {
                            u();
                            this.l.addAll(cVar.o);
                        }
                    }
                    if (!cVar.q.isEmpty()) {
                        if (this.m.isEmpty()) {
                            this.m = cVar.q;
                            this.f23870g &= -33;
                        } else {
                            t();
                            this.m.addAll(cVar.q);
                        }
                    }
                    n(l().f(cVar.f23867i));
                    return this;
                }
            }

            /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.a0.a$e$c$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: JvmProtoBuf.java */
            public enum EnumC0359c implements kotlin.reflect.jvm.internal.impl.protobuf.i.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);


                /* JADX INFO: renamed from: i, reason: collision with root package name */
                private static kotlin.reflect.jvm.internal.impl.protobuf.i.b<EnumC0359c> f23878i = new C0360a();

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                private final int f23880k;

                /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.a0.a$e$c$c$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: JvmProtoBuf.java */
                static class C0360a implements kotlin.reflect.jvm.internal.impl.protobuf.i.b<EnumC0359c> {
                    C0360a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0359c a(int i2) {
                        return EnumC0359c.g(i2);
                    }
                }

                EnumC0359c(int i2, int i3) {
                    this.f23880k = i3;
                }

                public static EnumC0359c g(int i2) {
                    if (i2 == 0) {
                        return NONE;
                    }
                    if (i2 == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i2 != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
                public final int f() {
                    return this.f23880k;
                }
            }

            static {
                c cVar = new c(true);
                f23865g = cVar;
                cVar.Q();
            }

            public static c C() {
                return f23865g;
            }

            private void Q() {
                this.f23869k = 1;
                this.l = 0;
                this.m = HttpUrl.FRAGMENT_ENCODE_SET;
                this.n = EnumC0359c.NONE;
                this.o = Collections.emptyList();
                this.q = Collections.emptyList();
            }

            public static b R() {
                return b.s();
            }

            public static b S(c cVar) {
                return R().m(cVar);
            }

            public EnumC0359c D() {
                return this.n;
            }

            public int E() {
                return this.l;
            }

            public int F() {
                return this.f23869k;
            }

            public int G() {
                return this.q.size();
            }

            public List<Integer> H() {
                return this.q;
            }

            public String I() {
                Object obj = this.m;
                if (obj instanceof String) {
                    return (String) obj;
                }
                kotlin.p002reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.p002reflect.jvm.internal.impl.protobuf.d) obj;
                String strD = dVar.D();
                if (dVar.t()) {
                    this.m = strD;
                }
                return strD;
            }

            public kotlin.p002reflect.jvm.internal.impl.protobuf.d J() {
                Object obj = this.m;
                if (!(obj instanceof String)) {
                    return (kotlin.p002reflect.jvm.internal.impl.protobuf.d) obj;
                }
                kotlin.p002reflect.jvm.internal.impl.protobuf.d dVarN = kotlin.p002reflect.jvm.internal.impl.protobuf.d.n((String) obj);
                this.m = dVarN;
                return dVarN;
            }

            public int K() {
                return this.o.size();
            }

            public List<Integer> L() {
                return this.o;
            }

            public boolean M() {
                return (this.f23868j & 8) == 8;
            }

            public boolean N() {
                return (this.f23868j & 2) == 2;
            }

            public boolean O() {
                return (this.f23868j & 1) == 1;
            }

            public boolean P() {
                return (this.f23868j & 4) == 4;
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
            /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
            public b f() {
                return R();
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
            /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
            public b d() {
                return S(this);
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
            public int e() {
                int i2 = this.t;
                if (i2 != -1) {
                    return i2;
                }
                int iO = (this.f23868j & 1) == 1 ? CodedOutputStream.o(1, this.f23869k) + 0 : 0;
                if ((this.f23868j & 2) == 2) {
                    iO += CodedOutputStream.o(2, this.l);
                }
                if ((this.f23868j & 8) == 8) {
                    iO += CodedOutputStream.h(3, this.n.f());
                }
                int iP = 0;
                for (int i3 = 0; i3 < this.o.size(); i3++) {
                    iP += CodedOutputStream.p(this.o.get(i3).intValue());
                }
                int iP2 = iO + iP;
                if (!L().isEmpty()) {
                    iP2 = iP2 + 1 + CodedOutputStream.p(iP);
                }
                this.p = iP;
                int iP3 = 0;
                for (int i4 = 0; i4 < this.q.size(); i4++) {
                    iP3 += CodedOutputStream.p(this.q.get(i4).intValue());
                }
                int iD = iP2 + iP3;
                if (!H().isEmpty()) {
                    iD = iD + 1 + CodedOutputStream.p(iP3);
                }
                this.r = iP3;
                if ((this.f23868j & 4) == 4) {
                    iD += CodedOutputStream.d(6, J());
                }
                int size = iD + this.f23867i.size();
                this.t = size;
                return size;
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
            public kotlin.p002reflect.jvm.internal.impl.protobuf.q<c> g() {
                return f23866h;
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
            public void h(CodedOutputStream codedOutputStream) throws IOException {
                e();
                if ((this.f23868j & 1) == 1) {
                    codedOutputStream.a0(1, this.f23869k);
                }
                if ((this.f23868j & 2) == 2) {
                    codedOutputStream.a0(2, this.l);
                }
                if ((this.f23868j & 8) == 8) {
                    codedOutputStream.S(3, this.n.f());
                }
                if (L().size() > 0) {
                    codedOutputStream.o0(34);
                    codedOutputStream.o0(this.p);
                }
                for (int i2 = 0; i2 < this.o.size(); i2++) {
                    codedOutputStream.b0(this.o.get(i2).intValue());
                }
                if (H().size() > 0) {
                    codedOutputStream.o0(42);
                    codedOutputStream.o0(this.r);
                }
                for (int i3 = 0; i3 < this.q.size(); i3++) {
                    codedOutputStream.b0(this.q.get(i3).intValue());
                }
                if ((this.f23868j & 4) == 4) {
                    codedOutputStream.O(6, J());
                }
                codedOutputStream.i0(this.f23867i);
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
                this.s = (byte) 1;
                return true;
            }

            private c(h.b bVar) {
                super(bVar);
                this.p = -1;
                this.r = -1;
                this.s = (byte) -1;
                this.t = -1;
                this.f23867i = bVar.l();
            }

            private c(boolean z) {
                this.p = -1;
                this.r = -1;
                this.s = (byte) -1;
                this.t = -1;
                this.f23867i = kotlin.p002reflect.jvm.internal.impl.protobuf.d.f25399f;
            }

            private c(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                this.p = -1;
                this.r = -1;
                this.s = (byte) -1;
                this.t = -1;
                Q();
                kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarW = kotlin.p002reflect.jvm.internal.impl.protobuf.d.w();
                CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
                boolean z = false;
                int i2 = 0;
                while (!z) {
                    try {
                        try {
                            int iK = eVar.K();
                            if (iK != 0) {
                                if (iK == 8) {
                                    this.f23868j |= 1;
                                    this.f23869k = eVar.s();
                                } else if (iK == 16) {
                                    this.f23868j |= 2;
                                    this.l = eVar.s();
                                } else if (iK == 24) {
                                    int iN = eVar.n();
                                    EnumC0359c enumC0359cG = EnumC0359c.g(iN);
                                    if (enumC0359cG == null) {
                                        codedOutputStreamJ.o0(iK);
                                        codedOutputStreamJ.o0(iN);
                                    } else {
                                        this.f23868j |= 8;
                                        this.n = enumC0359cG;
                                    }
                                } else if (iK == 32) {
                                    if ((i2 & 16) != 16) {
                                        this.o = new ArrayList();
                                        i2 |= 16;
                                    }
                                    this.o.add(Integer.valueOf(eVar.s()));
                                } else if (iK == 34) {
                                    int iJ = eVar.j(eVar.A());
                                    if ((i2 & 16) != 16 && eVar.e() > 0) {
                                        this.o = new ArrayList();
                                        i2 |= 16;
                                    }
                                    while (eVar.e() > 0) {
                                        this.o.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(iJ);
                                } else if (iK == 40) {
                                    if ((i2 & 32) != 32) {
                                        this.q = new ArrayList();
                                        i2 |= 32;
                                    }
                                    this.q.add(Integer.valueOf(eVar.s()));
                                } else if (iK == 42) {
                                    int iJ2 = eVar.j(eVar.A());
                                    if ((i2 & 32) != 32 && eVar.e() > 0) {
                                        this.q = new ArrayList();
                                        i2 |= 32;
                                    }
                                    while (eVar.e() > 0) {
                                        this.q.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(iJ2);
                                } else if (iK != 50) {
                                    if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                    }
                                } else {
                                    kotlin.p002reflect.jvm.internal.impl.protobuf.d dVarL = eVar.l();
                                    this.f23868j |= 4;
                                    this.m = dVarL;
                                }
                            }
                            z = true;
                        } catch (Throwable th) {
                            if ((i2 & 16) == 16) {
                                this.o = Collections.unmodifiableList(this.o);
                            }
                            if ((i2 & 32) == 32) {
                                this.q = Collections.unmodifiableList(this.q);
                            }
                            try {
                                codedOutputStreamJ.I();
                            } catch (IOException unused) {
                            } finally {
                                this.f23867i = bVarW.e();
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
                if ((i2 & 16) == 16) {
                    this.o = Collections.unmodifiableList(this.o);
                }
                if ((i2 & 32) == 32) {
                    this.q = Collections.unmodifiableList(this.q);
                }
                try {
                    codedOutputStreamJ.I();
                } catch (IOException unused2) {
                } finally {
                    this.f23867i = bVarW.e();
                }
                m();
            }
        }

        private e(h.b bVar) {
            super(bVar);
            this.l = -1;
            this.m = (byte) -1;
            this.n = -1;
            this.f23859i = bVar.l();
        }

        private e(boolean z) {
            this.l = -1;
            this.m = (byte) -1;
            this.n = -1;
            this.f23859i = kotlin.p002reflect.jvm.internal.impl.protobuf.d.f25399f;
        }

        private e(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
            this.l = -1;
            this.m = (byte) -1;
            this.n = -1;
            z();
            kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarW = kotlin.p002reflect.jvm.internal.impl.protobuf.d.w();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
            boolean z = false;
            int i2 = 0;
            while (!z) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 10) {
                                if ((i2 & 1) != 1) {
                                    this.f23860j = new ArrayList();
                                    i2 |= 1;
                                }
                                this.f23860j.add((c) eVar.u(c.f23866h, fVar));
                            } else if (iK == 40) {
                                if ((i2 & 2) != 2) {
                                    this.f23861k = new ArrayList();
                                    i2 |= 2;
                                }
                                this.f23861k.add(Integer.valueOf(eVar.s()));
                            } else if (iK != 42) {
                                if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                }
                            } else {
                                int iJ = eVar.j(eVar.A());
                                if ((i2 & 2) != 2 && eVar.e() > 0) {
                                    this.f23861k = new ArrayList();
                                    i2 |= 2;
                                }
                                while (eVar.e() > 0) {
                                    this.f23861k.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(iJ);
                            }
                        }
                        z = true;
                    } catch (Throwable th) {
                        if ((i2 & 1) == 1) {
                            this.f23860j = Collections.unmodifiableList(this.f23860j);
                        }
                        if ((i2 & 2) == 2) {
                            this.f23861k = Collections.unmodifiableList(this.f23861k);
                        }
                        try {
                            codedOutputStreamJ.I();
                        } catch (IOException unused) {
                        } finally {
                            this.f23859i = bVarW.e();
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
            if ((i2 & 1) == 1) {
                this.f23860j = Collections.unmodifiableList(this.f23860j);
            }
            if ((i2 & 2) == 2) {
                this.f23861k = Collections.unmodifiableList(this.f23861k);
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } finally {
                this.f23859i = bVarW.e();
            }
            m();
        }
    }

    static {
        kotlin.reflect.y.internal.j0.e.d dVarH = kotlin.reflect.y.internal.j0.e.d.H();
        c cVarV = c.v();
        c cVarV2 = c.v();
        w.b bVar = w.b.p;
        a = h.o(dVarH, cVarV, cVarV2, null, 100, bVar, c.class);
        f23821b = h.o(i.b0(), c.v(), c.v(), null, 100, bVar, c.class);
        i iVarB0 = i.b0();
        w.b bVar2 = w.b.f25497j;
        f23822c = h.o(iVarB0, 0, null, null, 101, bVar2, Integer.class);
        f23823d = h.o(n.Z(), d.y(), d.y(), null, 100, bVar, d.class);
        f23824e = h.o(n.Z(), 0, null, null, 101, bVar2, Integer.class);
        f23825f = h.n(q.Y(), kotlin.reflect.y.internal.j0.e.b.z(), null, 100, bVar, false, kotlin.reflect.y.internal.j0.e.b.class);
        f23826g = h.o(q.Y(), Boolean.FALSE, null, null, 101, w.b.m, Boolean.class);
        f23827h = h.n(s.K(), kotlin.reflect.y.internal.j0.e.b.z(), null, 100, bVar, false, kotlin.reflect.y.internal.j0.e.b.class);
        f23828i = h.o(kotlin.reflect.y.internal.j0.e.c.z0(), 0, null, null, 101, bVar2, Integer.class);
        f23829j = h.n(kotlin.reflect.y.internal.j0.e.c.z0(), n.Z(), null, 102, bVar, false, n.class);
        f23830k = h.o(kotlin.reflect.y.internal.j0.e.c.z0(), 0, null, null, 103, bVar2, Integer.class);
        l = h.o(kotlin.reflect.y.internal.j0.e.c.z0(), 0, null, null, 104, bVar2, Integer.class);
        m = h.o(l.K(), 0, null, null, 101, bVar2, Integer.class);
        n = h.n(l.K(), n.Z(), null, 102, bVar, false, n.class);
    }

    public static void a(f fVar) {
        fVar.a(a);
        fVar.a(f23821b);
        fVar.a(f23822c);
        fVar.a(f23823d);
        fVar.a(f23824e);
        fVar.a(f23825f);
        fVar.a(f23826g);
        fVar.a(f23827h);
        fVar.a(f23828i);
        fVar.a(f23829j);
        fVar.a(f23830k);
        fVar.a(l);
        fVar.a(m);
        fVar.a(n);
    }

    /* JADX INFO: compiled from: JvmProtoBuf.java */
    public static final class b extends h implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final b f23831g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static kotlin.p002reflect.jvm.internal.impl.protobuf.q<b> f23832h = new C0353a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final kotlin.p002reflect.jvm.internal.impl.protobuf.d f23833i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f23834j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f23835k;
        private int l;
        private byte m;
        private int n;

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.a0.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        static class C0353a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<b> {
            C0353a() {
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public b b(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new b(eVar, fVar);
            }
        }

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.a0.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static final class C0354b extends h.b<b, C0354b> implements p {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f23836g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private int f23837h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private int f23838i;

            private C0354b() {
                t();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static C0354b s() {
                return new C0354b();
            }

            private void t() {
            }

            public C0354b A(int i2) {
                this.f23836g |= 1;
                this.f23837h = i2;
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
                int i2 = this.f23836g;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                bVar.f23835k = this.f23837h;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                bVar.l = this.f23838i;
                bVar.f23834j = i3;
                return bVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public C0354b k() {
                return s().m(q());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            public C0354b m(b bVar) {
                if (bVar == b.v()) {
                    return this;
                }
                if (bVar.z()) {
                    A(bVar.x());
                }
                if (bVar.y()) {
                    w(bVar.w());
                }
                n(l().f(bVar.f23833i));
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public C0354b i(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws Throwable {
                b bVar = null;
                try {
                    try {
                        b bVarB = b.f23832h.b(eVar, fVar);
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

            public C0354b w(int i2) {
                this.f23836g |= 2;
                this.f23838i = i2;
                return this;
            }
        }

        static {
            b bVar = new b(true);
            f23831g = bVar;
            bVar.A();
        }

        private void A() {
            this.f23835k = 0;
            this.l = 0;
        }

        public static C0354b B() {
            return C0354b.s();
        }

        public static C0354b C(b bVar) {
            return B().m(bVar);
        }

        public static b v() {
            return f23831g;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public C0354b f() {
            return B();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public C0354b d() {
            return C(this);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public int e() {
            int i2 = this.n;
            if (i2 != -1) {
                return i2;
            }
            int iO = (this.f23834j & 1) == 1 ? 0 + CodedOutputStream.o(1, this.f23835k) : 0;
            if ((this.f23834j & 2) == 2) {
                iO += CodedOutputStream.o(2, this.l);
            }
            int size = iO + this.f23833i.size();
            this.n = size;
            return size;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public kotlin.p002reflect.jvm.internal.impl.protobuf.q<b> g() {
            return f23832h;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public void h(CodedOutputStream codedOutputStream) throws IOException {
            e();
            if ((this.f23834j & 1) == 1) {
                codedOutputStream.a0(1, this.f23835k);
            }
            if ((this.f23834j & 2) == 2) {
                codedOutputStream.a0(2, this.l);
            }
            codedOutputStream.i0(this.f23833i);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.m = (byte) 1;
            return true;
        }

        public int w() {
            return this.l;
        }

        public int x() {
            return this.f23835k;
        }

        public boolean y() {
            return (this.f23834j & 2) == 2;
        }

        public boolean z() {
            return (this.f23834j & 1) == 1;
        }

        private b(h.b bVar) {
            super(bVar);
            this.m = (byte) -1;
            this.n = -1;
            this.f23833i = bVar.l();
        }

        private b(boolean z) {
            this.m = (byte) -1;
            this.n = -1;
            this.f23833i = kotlin.p002reflect.jvm.internal.impl.protobuf.d.f25399f;
        }

        private b(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
            this.m = (byte) -1;
            this.n = -1;
            A();
            kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarW = kotlin.p002reflect.jvm.internal.impl.protobuf.d.w();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.f23834j |= 1;
                                this.f23835k = eVar.s();
                            } else if (iK != 16) {
                                if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                }
                            } else {
                                this.f23834j |= 2;
                                this.l = eVar.s();
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
                        this.f23833i = bVarW.e();
                    }
                    m();
                    throw th;
                }
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } finally {
                this.f23833i = bVarW.e();
            }
            m();
        }
    }

    /* JADX INFO: compiled from: JvmProtoBuf.java */
    public static final class c extends h implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final c f23839g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static kotlin.p002reflect.jvm.internal.impl.protobuf.q<c> f23840h = new C0355a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final kotlin.p002reflect.jvm.internal.impl.protobuf.d f23841i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f23842j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f23843k;
        private int l;
        private byte m;
        private int n;

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.a0.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        static class C0355a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<c> {
            C0355a() {
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public c b(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new c(eVar, fVar);
            }
        }

        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static final class b extends h.b<c, b> implements p {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f23844g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private int f23845h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private int f23846i;

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
                this.f23844g |= 1;
                this.f23845h = i2;
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
                int i2 = this.f23844g;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                cVar.f23843k = this.f23845h;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                cVar.l = this.f23846i;
                cVar.f23842j = i3;
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
                if (cVar == c.v()) {
                    return this;
                }
                if (cVar.z()) {
                    A(cVar.x());
                }
                if (cVar.y()) {
                    w(cVar.w());
                }
                n(l().f(cVar.f23841i));
                return this;
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public b i(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws Throwable {
                c cVar = null;
                try {
                    try {
                        c cVarB = c.f23840h.b(eVar, fVar);
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

            public b w(int i2) {
                this.f23844g |= 2;
                this.f23846i = i2;
                return this;
            }
        }

        static {
            c cVar = new c(true);
            f23839g = cVar;
            cVar.A();
        }

        private void A() {
            this.f23843k = 0;
            this.l = 0;
        }

        public static b B() {
            return b.s();
        }

        public static b C(c cVar) {
            return B().m(cVar);
        }

        public static c v() {
            return f23839g;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public b f() {
            return B();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public b d() {
            return C(this);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public int e() {
            int i2 = this.n;
            if (i2 != -1) {
                return i2;
            }
            int iO = (this.f23842j & 1) == 1 ? 0 + CodedOutputStream.o(1, this.f23843k) : 0;
            if ((this.f23842j & 2) == 2) {
                iO += CodedOutputStream.o(2, this.l);
            }
            int size = iO + this.f23841i.size();
            this.n = size;
            return size;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public kotlin.p002reflect.jvm.internal.impl.protobuf.q<c> g() {
            return f23840h;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public void h(CodedOutputStream codedOutputStream) throws IOException {
            e();
            if ((this.f23842j & 1) == 1) {
                codedOutputStream.a0(1, this.f23843k);
            }
            if ((this.f23842j & 2) == 2) {
                codedOutputStream.a0(2, this.l);
            }
            codedOutputStream.i0(this.f23841i);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.m = (byte) 1;
            return true;
        }

        public int w() {
            return this.l;
        }

        public int x() {
            return this.f23843k;
        }

        public boolean y() {
            return (this.f23842j & 2) == 2;
        }

        public boolean z() {
            return (this.f23842j & 1) == 1;
        }

        private c(h.b bVar) {
            super(bVar);
            this.m = (byte) -1;
            this.n = -1;
            this.f23841i = bVar.l();
        }

        private c(boolean z) {
            this.m = (byte) -1;
            this.n = -1;
            this.f23841i = kotlin.p002reflect.jvm.internal.impl.protobuf.d.f25399f;
        }

        private c(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
            this.m = (byte) -1;
            this.n = -1;
            A();
            kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarW = kotlin.p002reflect.jvm.internal.impl.protobuf.d.w();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 8) {
                                this.f23842j |= 1;
                                this.f23843k = eVar.s();
                            } else if (iK != 16) {
                                if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                }
                            } else {
                                this.f23842j |= 2;
                                this.l = eVar.s();
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
                        this.f23841i = bVarW.e();
                    }
                    m();
                    throw th;
                }
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } finally {
                this.f23841i = bVarW.e();
            }
            m();
        }
    }

    /* JADX INFO: compiled from: JvmProtoBuf.java */
    public static final class d extends h implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final d f23847g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static kotlin.p002reflect.jvm.internal.impl.protobuf.q<d> f23848h = new C0356a();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final kotlin.p002reflect.jvm.internal.impl.protobuf.d f23849i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f23850j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private b f23851k;
        private c l;
        private c m;
        private c n;
        private c o;
        private byte p;
        private int q;

        /* JADX INFO: renamed from: kotlin.f0.y.e.j0.e.a0.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: JvmProtoBuf.java */
        static class C0356a extends kotlin.p002reflect.jvm.internal.impl.protobuf.b<d> {
            C0356a() {
            }

            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.q
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public d b(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new d(eVar, fVar);
            }
        }

        /* JADX INFO: compiled from: JvmProtoBuf.java */
        public static final class b extends h.b<d, b> implements p {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private int f23852g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            private b f23853h = b.v();

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            private c f23854i = c.v();

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            private c f23855j = c.v();

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            private c f23856k = c.v();
            private c l = c.v();

            private b() {
                t();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static b s() {
                return new b();
            }

            private void t() {
            }

            /* JADX WARN: Code duplicated, block: B:15:0x001d  */
            @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
            /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
            public b i(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws Throwable {
                d dVar = null;
                try {
                    try {
                        d dVarB = d.f23848h.b(eVar, fVar);
                        if (dVarB != null) {
                            m(dVarB);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        d dVar2 = (d) e2.a();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            dVar = dVar2;
                            if (dVar != null) {
                                m(dVar);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (dVar != null) {
                        m(dVar);
                    }
                    throw th;
                }
            }

            public b B(c cVar) {
                if ((this.f23852g & 4) != 4 || this.f23855j == c.v()) {
                    this.f23855j = cVar;
                } else {
                    this.f23855j = c.C(this.f23855j).m(cVar).q();
                }
                this.f23852g |= 4;
                return this;
            }

            public b C(c cVar) {
                if ((this.f23852g & 8) != 8 || this.f23856k == c.v()) {
                    this.f23856k = cVar;
                } else {
                    this.f23856k = c.C(this.f23856k).m(cVar).q();
                }
                this.f23852g |= 8;
                return this;
            }

            public b D(c cVar) {
                if ((this.f23852g & 2) != 2 || this.f23854i == c.v()) {
                    this.f23854i = cVar;
                } else {
                    this.f23854i = c.C(this.f23854i).m(cVar).q();
                }
                this.f23852g |= 2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
            /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
            public d c() {
                d dVarQ = q();
                if (dVarQ.isInitialized()) {
                    return dVarQ;
                }
                throw kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a.j(dVarQ);
            }

            public d q() {
                d dVar = new d(this);
                int i2 = this.f23852g;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                dVar.f23851k = this.f23853h;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                dVar.l = this.f23854i;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                dVar.m = this.f23855j;
                if ((i2 & 8) == 8) {
                    i3 |= 8;
                }
                dVar.n = this.f23856k;
                if ((i2 & 16) == 16) {
                    i3 |= 16;
                }
                dVar.o = this.l;
                dVar.f23850j = i3;
                return dVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public b k() {
                return s().m(q());
            }

            public b u(c cVar) {
                if ((this.f23852g & 16) != 16 || this.l == c.v()) {
                    this.l = cVar;
                } else {
                    this.l = c.C(this.l).m(cVar).q();
                }
                this.f23852g |= 16;
                return this;
            }

            public b v(b bVar) {
                if ((this.f23852g & 1) != 1 || this.f23853h == b.v()) {
                    this.f23853h = bVar;
                } else {
                    this.f23853h = b.C(this.f23853h).m(bVar).q();
                }
                this.f23852g |= 1;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
            public b m(d dVar) {
                if (dVar == d.y()) {
                    return this;
                }
                if (dVar.F()) {
                    v(dVar.A());
                }
                if (dVar.I()) {
                    D(dVar.D());
                }
                if (dVar.G()) {
                    B(dVar.B());
                }
                if (dVar.H()) {
                    C(dVar.C());
                }
                if (dVar.E()) {
                    u(dVar.z());
                }
                n(l().f(dVar.f23849i));
                return this;
            }
        }

        static {
            d dVar = new d(true);
            f23847g = dVar;
            dVar.J();
        }

        private void J() {
            this.f23851k = b.v();
            this.l = c.v();
            this.m = c.v();
            this.n = c.v();
            this.o = c.v();
        }

        public static b K() {
            return b.s();
        }

        public static b L(d dVar) {
            return K().m(dVar);
        }

        public static d y() {
            return f23847g;
        }

        public b A() {
            return this.f23851k;
        }

        public c B() {
            return this.m;
        }

        public c C() {
            return this.n;
        }

        public c D() {
            return this.l;
        }

        public boolean E() {
            return (this.f23850j & 16) == 16;
        }

        public boolean F() {
            return (this.f23850j & 1) == 1;
        }

        public boolean G() {
            return (this.f23850j & 4) == 4;
        }

        public boolean H() {
            return (this.f23850j & 8) == 8;
        }

        public boolean I() {
            return (this.f23850j & 2) == 2;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public b f() {
            return K();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public b d() {
            return L(this);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public int e() {
            int i2 = this.q;
            if (i2 != -1) {
                return i2;
            }
            int iS = (this.f23850j & 1) == 1 ? 0 + CodedOutputStream.s(1, this.f23851k) : 0;
            if ((this.f23850j & 2) == 2) {
                iS += CodedOutputStream.s(2, this.l);
            }
            if ((this.f23850j & 4) == 4) {
                iS += CodedOutputStream.s(3, this.m);
            }
            if ((this.f23850j & 8) == 8) {
                iS += CodedOutputStream.s(4, this.n);
            }
            if ((this.f23850j & 16) == 16) {
                iS += CodedOutputStream.s(5, this.o);
            }
            int size = iS + this.f23849i.size();
            this.q = size;
            return size;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h, kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public kotlin.p002reflect.jvm.internal.impl.protobuf.q<d> g() {
            return f23848h;
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
        public void h(CodedOutputStream codedOutputStream) throws IOException {
            e();
            if ((this.f23850j & 1) == 1) {
                codedOutputStream.d0(1, this.f23851k);
            }
            if ((this.f23850j & 2) == 2) {
                codedOutputStream.d0(2, this.l);
            }
            if ((this.f23850j & 4) == 4) {
                codedOutputStream.d0(3, this.m);
            }
            if ((this.f23850j & 8) == 8) {
                codedOutputStream.d0(4, this.n);
            }
            if ((this.f23850j & 16) == 16) {
                codedOutputStream.d0(5, this.o);
            }
            codedOutputStream.i0(this.f23849i);
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.p
        public final boolean isInitialized() {
            byte b2 = this.p;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            this.p = (byte) 1;
            return true;
        }

        public c z() {
            return this.o;
        }

        private d(h.b bVar) {
            super(bVar);
            this.p = (byte) -1;
            this.q = -1;
            this.f23849i = bVar.l();
        }

        private d(boolean z) {
            this.p = (byte) -1;
            this.q = -1;
            this.f23849i = kotlin.p002reflect.jvm.internal.impl.protobuf.d.f25399f;
        }

        private d(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
            this.p = (byte) -1;
            this.q = -1;
            J();
            kotlin.reflect.jvm.internal.impl.protobuf.d.b bVarW = kotlin.p002reflect.jvm.internal.impl.protobuf.d.w();
            CodedOutputStream codedOutputStreamJ = CodedOutputStream.J(bVarW, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int iK = eVar.K();
                        if (iK != 0) {
                            if (iK == 10) {
                                b.C0354b c0354bD = (this.f23850j & 1) == 1 ? this.f23851k.d() : null;
                                b bVar = (b) eVar.u(b.f23832h, fVar);
                                this.f23851k = bVar;
                                if (c0354bD != null) {
                                    c0354bD.m(bVar);
                                    this.f23851k = c0354bD.q();
                                }
                                this.f23850j |= 1;
                            } else if (iK == 18) {
                                c.b bVarD = (this.f23850j & 2) == 2 ? this.l.d() : null;
                                c cVar = (c) eVar.u(c.f23840h, fVar);
                                this.l = cVar;
                                if (bVarD != null) {
                                    bVarD.m(cVar);
                                    this.l = bVarD.q();
                                }
                                this.f23850j |= 2;
                            } else if (iK == 26) {
                                c.b bVarD2 = (this.f23850j & 4) == 4 ? this.m.d() : null;
                                c cVar2 = (c) eVar.u(c.f23840h, fVar);
                                this.m = cVar2;
                                if (bVarD2 != null) {
                                    bVarD2.m(cVar2);
                                    this.m = bVarD2.q();
                                }
                                this.f23850j |= 4;
                            } else if (iK == 34) {
                                c.b bVarD3 = (this.f23850j & 8) == 8 ? this.n.d() : null;
                                c cVar3 = (c) eVar.u(c.f23840h, fVar);
                                this.n = cVar3;
                                if (bVarD3 != null) {
                                    bVarD3.m(cVar3);
                                    this.n = bVarD3.q();
                                }
                                this.f23850j |= 8;
                            } else if (iK != 42) {
                                if (!p(eVar, codedOutputStreamJ, fVar, iK)) {
                                }
                            } else {
                                c.b bVarD4 = (this.f23850j & 16) == 16 ? this.o.d() : null;
                                c cVar4 = (c) eVar.u(c.f23840h, fVar);
                                this.o = cVar4;
                                if (bVarD4 != null) {
                                    bVarD4.m(cVar4);
                                    this.o = bVarD4.q();
                                }
                                this.f23850j |= 16;
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
                        this.f23849i = bVarW.e();
                    }
                    m();
                    throw th;
                }
            }
            try {
                codedOutputStreamJ.I();
            } catch (IOException unused2) {
            } finally {
                this.f23849i = bVarW.e();
            }
            m();
        }
    }
}
