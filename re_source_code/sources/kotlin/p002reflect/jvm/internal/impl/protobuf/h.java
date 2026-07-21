package kotlin.p002reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GeneratedMessageLite.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends kotlin.p002reflect.jvm.internal.impl.protobuf.a implements Serializable {

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[w.c.values().length];
            a = iArr;
            try {
                iArr[w.c.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[w.c.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class b<MessageType extends h, BuilderType extends b> extends kotlin.p002reflect.jvm.internal.impl.protobuf.a.AbstractC0413a<BuilderType> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private kotlin.p002reflect.jvm.internal.impl.protobuf.d f25422f = kotlin.p002reflect.jvm.internal.impl.protobuf.d.f25399f;

        protected b() {
        }

        @Override // 
        public BuilderType k() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final kotlin.p002reflect.jvm.internal.impl.protobuf.d l() {
            return this.f25422f;
        }

        public abstract BuilderType m(MessageType messagetype);

        public final BuilderType n(kotlin.p002reflect.jvm.internal.impl.protobuf.d dVar) {
            this.f25422f = dVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class c<MessageType extends d<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private g<e> f25423g = g.g();

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f25424h;

        protected c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public g<e> p() {
            this.f25423g.q();
            this.f25424h = false;
            return this.f25423g;
        }

        private void q() {
            if (this.f25424h) {
                return;
            }
            this.f25423g = this.f25423g.clone();
            this.f25424h = true;
        }

        protected final void r(MessageType messagetype) {
            q();
            this.f25423g.r(((d) messagetype).f25425g);
        }
    }

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    static final class e implements g.b<e> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final i.b<?> f25429f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final int f25430g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final w.b f25431h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final boolean f25432i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final boolean f25433j;

        e(i.b<?> bVar, int i2, w.b bVar2, boolean z, boolean z2) {
            this.f25429f = bVar;
            this.f25430g = i2;
            this.f25431h = bVar2;
            this.f25432i = z;
            this.f25433j = z2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public int f() {
            return this.f25430g;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.f25430g - eVar.f25430g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public boolean h() {
            return this.f25432i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public w.b j() {
            return this.f25431h;
        }

        public i.b<?> k() {
            return this.f25429f;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public w.c l() {
            return this.f25431h.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public boolean m() {
            return this.f25433j;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public o.a n(o.a aVar, o oVar) {
            return ((b) aVar).m((h) oVar);
        }
    }

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static class f<ContainingType extends o, Type> {
        final ContainingType a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Type f25434b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final o f25435c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final e f25436d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Class f25437e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final Method f25438f;

        f(ContainingType containingtype, Type type, o oVar, e eVar, Class cls) {
            if (containingtype == null) {
                throw new IllegalArgumentException("Null containingTypeDefaultInstance");
            }
            if (eVar.j() == w.b.p && oVar == null) {
                throw new IllegalArgumentException("Null messageDefaultInstance");
            }
            this.a = containingtype;
            this.f25434b = type;
            this.f25435c = oVar;
            this.f25436d = eVar;
            this.f25437e = cls;
            if (i.a.class.isAssignableFrom(cls)) {
                this.f25438f = h.k(cls, "valueOf", Integer.TYPE);
            } else {
                this.f25438f = null;
            }
        }

        Object a(Object obj) {
            if (!this.f25436d.h()) {
                return e(obj);
            }
            if (this.f25436d.l() != w.c.ENUM) {
                return obj;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                arrayList.add(e(it.next()));
            }
            return arrayList;
        }

        public ContainingType b() {
            return this.a;
        }

        public o c() {
            return this.f25435c;
        }

        public int d() {
            return this.f25436d.f();
        }

        Object e(Object obj) {
            return this.f25436d.l() == w.c.ENUM ? h.l(this.f25438f, null, (Integer) obj) : obj;
        }

        Object f(Object obj) {
            return this.f25436d.l() == w.c.ENUM ? Integer.valueOf(((i.a) obj).f()) : obj;
        }
    }

    protected h() {
    }

    static Method k(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            String name = cls.getName();
            String strValueOf = String.valueOf(str);
            StringBuilder sb = new StringBuilder(name.length() + 45 + strValueOf.length());
            sb.append("Generated message class \"");
            sb.append(name);
            sb.append("\" missing method \"");
            sb.append(strValueOf);
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    static Object l(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    public static <ContainingType extends o, Type> f<ContainingType, Type> n(ContainingType containingtype, o oVar, i.b<?> bVar, int i2, w.b bVar2, boolean z, Class cls) {
        return new f<>(containingtype, Collections.emptyList(), oVar, new e(bVar, i2, bVar2, true, z), cls);
    }

    public static <ContainingType extends o, Type> f<ContainingType, Type> o(ContainingType containingtype, Type type, o oVar, i.b<?> bVar, int i2, w.b bVar2, Class cls) {
        return new f<>(containingtype, type, oVar, new e(bVar, i2, bVar2, false, false), cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:4:0x0010  */
    public static <MessageType extends o> boolean q(g<e> gVar, MessageType messagetype, kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.p002reflect.jvm.internal.impl.protobuf.f fVar, int i2) throws IOException {
        boolean z;
        boolean z2;
        Object objC;
        o oVar;
        int iB = w.b(i2);
        f fVarB = fVar.b(messagetype, w.a(i2));
        if (fVarB == null) {
            z = true;
            z2 = false;
        } else if (iB == g.l(fVarB.f25436d.j(), false)) {
            z = false;
            z2 = false;
        } else {
            e eVar2 = fVarB.f25436d;
            if (eVar2.f25432i && eVar2.f25431h.q() && iB == g.l(fVarB.f25436d.j(), true)) {
                z = false;
                z2 = true;
            } else {
                z = true;
                z2 = false;
            }
        }
        if (z) {
            return eVar.P(i2, codedOutputStream);
        }
        if (z2) {
            int iJ = eVar.j(eVar.A());
            if (fVarB.f25436d.j() == w.b.s) {
                while (eVar.e() > 0) {
                    i.a aVarA = fVarB.f25436d.k().a(eVar.n());
                    if (aVarA == null) {
                        return true;
                    }
                    gVar.a(fVarB.f25436d, fVarB.f(aVarA));
                }
            } else {
                while (eVar.e() > 0) {
                    gVar.a(fVarB.f25436d, g.u(eVar, fVarB.f25436d.j(), false));
                }
            }
            eVar.i(iJ);
        } else {
            int i3 = a.a[fVarB.f25436d.l().ordinal()];
            if (i3 == 1) {
                o.a aVarF = null;
                if (!fVarB.f25436d.h() && (oVar = (o) gVar.h(fVarB.f25436d)) != null) {
                    aVarF = oVar.d();
                }
                if (aVarF == null) {
                    aVarF = fVarB.c().f();
                }
                if (fVarB.f25436d.j() == w.b.o) {
                    eVar.r(fVarB.d(), aVarF, fVar);
                } else {
                    eVar.v(aVarF, fVar);
                }
                objC = aVarF.c();
            } else if (i3 != 2) {
                objC = g.u(eVar, fVarB.f25436d.j(), false);
            } else {
                int iN = eVar.n();
                i.a aVarA2 = fVarB.f25436d.k().a(iN);
                if (aVarA2 == null) {
                    codedOutputStream.o0(i2);
                    codedOutputStream.y0(iN);
                    return true;
                }
                objC = aVarA2;
            }
            if (fVarB.f25436d.h()) {
                gVar.a(fVarB.f25436d, fVarB.f(objC));
            } else {
                gVar.v(fVarB.f25436d, fVarB.f(objC));
            }
        }
        return true;
    }

    @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.o
    public q<? extends o> g() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    protected void m() {
    }

    protected boolean p(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.p002reflect.jvm.internal.impl.protobuf.f fVar, int i2) throws IOException {
        return eVar.P(i2, codedOutputStream);
    }

    /* JADX INFO: compiled from: GeneratedMessageLite.java */
    public static abstract class d<MessageType extends d<MessageType>> extends h implements p {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final g<e> f25425g;

        /* JADX INFO: compiled from: GeneratedMessageLite.java */
        protected class a {
            private final Iterator<Map.Entry<e, Object>> a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private Map.Entry<e, Object> f25426b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final boolean f25427c;

            /* synthetic */ a(d dVar, boolean z, a aVar) {
                this(z);
            }

            public void a(int i2, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<e, Object> entry = this.f25426b;
                    if (entry == null || entry.getKey().f() >= i2) {
                        return;
                    }
                    e key = this.f25426b.getKey();
                    if (this.f25427c && key.l() == w.c.MESSAGE && !key.h()) {
                        codedOutputStream.f0(key.f(), (o) this.f25426b.getValue());
                    } else {
                        g.z(key, this.f25426b.getValue(), codedOutputStream);
                    }
                    if (this.a.hasNext()) {
                        this.f25426b = this.a.next();
                    } else {
                        this.f25426b = null;
                    }
                }
            }

            private a(boolean z) {
                Iterator<Map.Entry<e, Object>> itP = d.this.f25425g.p();
                this.a = itP;
                if (itP.hasNext()) {
                    this.f25426b = itP.next();
                }
                this.f25427c = z;
            }
        }

        protected d() {
            this.f25425g = g.t();
        }

        private void z(f<MessageType, ?> fVar) {
            if (fVar.b() != b()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h
        protected void m() {
            this.f25425g.q();
        }

        @Override // kotlin.p002reflect.jvm.internal.impl.protobuf.h
        protected boolean p(kotlin.p002reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.p002reflect.jvm.internal.impl.protobuf.f fVar, int i2) throws IOException {
            return h.q(this.f25425g, b(), eVar, codedOutputStream, fVar, i2);
        }

        protected boolean s() {
            return this.f25425g.n();
        }

        protected int t() {
            return this.f25425g.k();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type u(f<MessageType, Type> fVar) {
            z(fVar);
            Object objH = this.f25425g.h(fVar.f25436d);
            return objH == null ? fVar.f25434b : (Type) fVar.a(objH);
        }

        public final <Type> Type v(f<MessageType, List<Type>> fVar, int i2) {
            z(fVar);
            return (Type) fVar.e(this.f25425g.i(fVar.f25436d, i2));
        }

        public final <Type> int w(f<MessageType, List<Type>> fVar) {
            z(fVar);
            return this.f25425g.j(fVar.f25436d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean x(f<MessageType, Type> fVar) {
            z(fVar);
            return this.f25425g.m(fVar.f25436d);
        }

        protected d<MessageType>.a y() {
            return new a(this, false, null);
        }

        protected d(c<MessageType, ?> cVar) {
            this.f25425g = cVar.p();
        }
    }

    protected h(b bVar) {
    }
}
