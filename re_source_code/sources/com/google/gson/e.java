package com.google.gson;

import com.google.gson.stream.MalformedJsonException;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* JADX INFO: compiled from: Gson.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {
    private static final com.google.gson.u.a<?> a = com.google.gson.u.a.get(Object.class);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadLocal<Map<com.google.gson.u.a<?>, f<?>>> f20141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<com.google.gson.u.a<?>, q<?>> f20142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.gson.t.c f20143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.google.gson.t.n.d f20144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final List<r> f20145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final com.google.gson.t.d f20146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final com.google.gson.d f20147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Map<Type, com.google.gson.f<?>> f20148i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final boolean f20149j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final boolean f20150k;
    final boolean l;
    final boolean m;
    final boolean n;
    final boolean o;
    final boolean p;
    final String q;
    final int r;
    final int s;
    final p t;
    final List<r> u;
    final List<r> v;

    /* JADX INFO: compiled from: Gson.java */
    class a extends q<Number> {
        a() {
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Double b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() != com.google.gson.stream.b.NULL) {
                return Double.valueOf(aVar.z());
            }
            aVar.I();
            return null;
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.y();
            } else {
                e.d(number.doubleValue());
                cVar.W(number);
            }
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    class b extends q<Number> {
        b() {
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Float b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() != com.google.gson.stream.b.NULL) {
                return Float.valueOf((float) aVar.z());
            }
            aVar.I();
            return null;
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.y();
            } else {
                e.d(number.floatValue());
                cVar.W(number);
            }
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    static class c extends q<Number> {
        c() {
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Number b(com.google.gson.stream.a aVar) throws IOException {
            if (aVar.Q() != com.google.gson.stream.b.NULL) {
                return Long.valueOf(aVar.B());
            }
            aVar.I();
            return null;
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.y();
            } else {
                cVar.Y(number.toString());
            }
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    static class d extends q<AtomicLong> {
        final /* synthetic */ q a;

        d(q qVar) {
            this.a = qVar;
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLong b(com.google.gson.stream.a aVar) throws IOException {
            return new AtomicLong(((Number) this.a.b(aVar)).longValue());
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, AtomicLong atomicLong) throws IOException {
            this.a.d(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: renamed from: com.google.gson.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Gson.java */
    static class C0239e extends q<AtomicLongArray> {
        final /* synthetic */ q a;

        C0239e(q qVar) {
            this.a = qVar;
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray b(com.google.gson.stream.a aVar) throws IOException {
            ArrayList arrayList = new ArrayList();
            aVar.a();
            while (aVar.l()) {
                arrayList.add(Long.valueOf(((Number) this.a.b(aVar)).longValue()));
            }
            aVar.f();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i2 = 0; i2 < size; i2++) {
                atomicLongArray.set(i2, ((Long) arrayList.get(i2)).longValue());
            }
            return atomicLongArray;
        }

        @Override // com.google.gson.q
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(com.google.gson.stream.c cVar, AtomicLongArray atomicLongArray) throws IOException {
            cVar.c();
            int length = atomicLongArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                this.a.d(cVar, Long.valueOf(atomicLongArray.get(i2)));
            }
            cVar.f();
        }
    }

    /* JADX INFO: compiled from: Gson.java */
    static class f<T> extends q<T> {
        private q<T> a;

        f() {
        }

        @Override // com.google.gson.q
        public T b(com.google.gson.stream.a aVar) throws IOException {
            q<T> qVar = this.a;
            if (qVar != null) {
                return qVar.b(aVar);
            }
            throw new IllegalStateException();
        }

        @Override // com.google.gson.q
        public void d(com.google.gson.stream.c cVar, T t) throws IOException {
            q<T> qVar = this.a;
            if (qVar == null) {
                throw new IllegalStateException();
            }
            qVar.d(cVar, t);
        }

        public void e(q<T> qVar) {
            if (this.a != null) {
                throw new AssertionError();
            }
            this.a = qVar;
        }
    }

    public e() {
        this(com.google.gson.t.d.f20190f, com.google.gson.c.f20135f, Collections.emptyMap(), false, false, false, true, false, false, false, p.f20153f, null, 2, 2, Collections.emptyList(), Collections.emptyList(), Collections.emptyList());
    }

    private static void a(Object obj, com.google.gson.stream.a aVar) {
        if (obj != null) {
            try {
                if (aVar.Q() == com.google.gson.stream.b.END_DOCUMENT) {
                } else {
                    throw new JsonIOException("JSON document was not fully consumed.");
                }
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    private static q<AtomicLong> b(q<Number> qVar) {
        return new d(qVar).a();
    }

    private static q<AtomicLongArray> c(q<Number> qVar) {
        return new C0239e(qVar).a();
    }

    static void d(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    private q<Number> e(boolean z) {
        return z ? com.google.gson.t.n.n.v : new a();
    }

    private q<Number> f(boolean z) {
        return z ? com.google.gson.t.n.n.u : new b();
    }

    private static q<Number> m(p pVar) {
        return pVar == p.f20153f ? com.google.gson.t.n.n.t : new c();
    }

    public <T> T g(com.google.gson.stream.a aVar, Type type) throws JsonSyntaxException, JsonIOException {
        boolean zM = aVar.m();
        boolean z = true;
        aVar.a0(true);
        try {
            try {
                try {
                    aVar.Q();
                    z = false;
                    T tB = j(com.google.gson.u.a.get(type)).b(aVar);
                    aVar.a0(zM);
                    return tB;
                } catch (AssertionError e2) {
                    AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.5): " + e2.getMessage());
                    assertionError.initCause(e2);
                    throw assertionError;
                } catch (IllegalStateException e3) {
                    throw new JsonSyntaxException(e3);
                }
            } catch (EOFException e4) {
                if (!z) {
                    throw new JsonSyntaxException(e4);
                }
                aVar.a0(zM);
                return null;
            } catch (IOException e5) {
                throw new JsonSyntaxException(e5);
            }
        } catch (Throwable th) {
            aVar.a0(zM);
            throw th;
        }
    }

    public <T> T h(Reader reader, Type type) throws JsonSyntaxException, JsonIOException {
        com.google.gson.stream.a aVarN = n(reader);
        T t = (T) g(aVarN, type);
        a(t, aVarN);
        return t;
    }

    public <T> T i(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) h(new StringReader(str), type);
    }

    public <T> q<T> j(com.google.gson.u.a<T> aVar) {
        q<T> qVar = (q) this.f20142c.get(aVar == null ? a : aVar);
        if (qVar != null) {
            return qVar;
        }
        Map<com.google.gson.u.a<?>, f<?>> map = this.f20141b.get();
        boolean z = false;
        if (map == null) {
            map = new HashMap<>();
            this.f20141b.set(map);
            z = true;
        }
        f<?> fVar = map.get(aVar);
        if (fVar != null) {
            return fVar;
        }
        try {
            f<?> fVar2 = new f<>();
            map.put(aVar, fVar2);
            Iterator<r> it = this.f20145f.iterator();
            while (it.hasNext()) {
                q<T> qVarB = it.next().b(this, aVar);
                if (qVarB != null) {
                    fVar2.e(qVarB);
                    this.f20142c.put(aVar, qVarB);
                    map.remove(aVar);
                    if (z) {
                        this.f20141b.remove();
                    }
                    return qVarB;
                }
            }
            throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + aVar);
        } catch (Throwable th) {
            map.remove(aVar);
            if (z) {
                this.f20141b.remove();
            }
            throw th;
        }
    }

    public <T> q<T> k(Class<T> cls) {
        return j(com.google.gson.u.a.get((Class) cls));
    }

    public <T> q<T> l(r rVar, com.google.gson.u.a<T> aVar) {
        if (!this.f20145f.contains(rVar)) {
            rVar = this.f20144e;
        }
        boolean z = false;
        for (r rVar2 : this.f20145f) {
            if (z) {
                q<T> qVarB = rVar2.b(this, aVar);
                if (qVarB != null) {
                    return qVarB;
                }
            } else if (rVar2 == rVar) {
                z = true;
            }
        }
        throw new IllegalArgumentException("GSON cannot serialize " + aVar);
    }

    public com.google.gson.stream.a n(Reader reader) {
        com.google.gson.stream.a aVar = new com.google.gson.stream.a(reader);
        aVar.a0(this.o);
        return aVar;
    }

    public com.google.gson.stream.c o(Writer writer) throws IOException {
        if (this.l) {
            writer.write(")]}'\n");
        }
        com.google.gson.stream.c cVar = new com.google.gson.stream.c(writer);
        if (this.n) {
            cVar.I("  ");
        }
        cVar.K(this.f20149j);
        return cVar;
    }

    public String p(j jVar) {
        StringWriter stringWriter = new StringWriter();
        t(jVar, stringWriter);
        return stringWriter.toString();
    }

    public String q(Object obj) {
        return obj == null ? p(k.a) : r(obj, obj.getClass());
    }

    public String r(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        v(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void s(j jVar, com.google.gson.stream.c cVar) throws JsonIOException {
        boolean zM = cVar.m();
        cVar.J(true);
        boolean zL = cVar.l();
        cVar.H(this.m);
        boolean zK = cVar.k();
        cVar.K(this.f20149j);
        try {
            try {
                com.google.gson.t.l.b(jVar, cVar);
                cVar.J(zM);
                cVar.H(zL);
                cVar.K(zK);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } catch (Throwable th) {
            cVar.J(zM);
            cVar.H(zL);
            cVar.K(zK);
            throw th;
        }
    }

    public void t(j jVar, Appendable appendable) throws JsonIOException {
        try {
            s(jVar, o(com.google.gson.t.l.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f20149j + ",factories:" + this.f20145f + ",instanceCreators:" + this.f20143d + "}";
    }

    public void u(Object obj, Type type, com.google.gson.stream.c cVar) throws JsonIOException {
        q qVarJ = j(com.google.gson.u.a.get(type));
        boolean zM = cVar.m();
        cVar.J(true);
        boolean zL = cVar.l();
        cVar.H(this.m);
        boolean zK = cVar.k();
        cVar.K(this.f20149j);
        try {
            try {
                qVarJ.d(cVar, obj);
                cVar.J(zM);
                cVar.H(zL);
                cVar.K(zK);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            } catch (AssertionError e3) {
                AssertionError assertionError = new AssertionError("AssertionError (GSON 2.8.5): " + e3.getMessage());
                assertionError.initCause(e3);
                throw assertionError;
            }
        } catch (Throwable th) {
            cVar.J(zM);
            cVar.H(zL);
            cVar.K(zK);
            throw th;
        }
    }

    public void v(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            u(obj, type, o(com.google.gson.t.l.c(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    e(com.google.gson.t.d dVar, com.google.gson.d dVar2, Map<Type, com.google.gson.f<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, p pVar, String str, int i2, int i3, List<r> list, List<r> list2, List<r> list3) {
        this.f20141b = new ThreadLocal<>();
        this.f20142c = new ConcurrentHashMap();
        this.f20146g = dVar;
        this.f20147h = dVar2;
        this.f20148i = map;
        com.google.gson.t.c cVar = new com.google.gson.t.c(map);
        this.f20143d = cVar;
        this.f20149j = z;
        this.f20150k = z2;
        this.l = z3;
        this.m = z4;
        this.n = z5;
        this.o = z6;
        this.p = z7;
        this.t = pVar;
        this.q = str;
        this.r = i2;
        this.s = i3;
        this.u = list;
        this.v = list2;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.t.n.n.Y);
        arrayList.add(com.google.gson.t.n.h.a);
        arrayList.add(dVar);
        arrayList.addAll(list3);
        arrayList.add(com.google.gson.t.n.n.D);
        arrayList.add(com.google.gson.t.n.n.m);
        arrayList.add(com.google.gson.t.n.n.f20270g);
        arrayList.add(com.google.gson.t.n.n.f20272i);
        arrayList.add(com.google.gson.t.n.n.f20274k);
        q<Number> qVarM = m(pVar);
        arrayList.add(com.google.gson.t.n.n.b(Long.TYPE, Long.class, qVarM));
        arrayList.add(com.google.gson.t.n.n.b(Double.TYPE, Double.class, e(z7)));
        arrayList.add(com.google.gson.t.n.n.b(Float.TYPE, Float.class, f(z7)));
        arrayList.add(com.google.gson.t.n.n.x);
        arrayList.add(com.google.gson.t.n.n.o);
        arrayList.add(com.google.gson.t.n.n.q);
        arrayList.add(com.google.gson.t.n.n.a(AtomicLong.class, b(qVarM)));
        arrayList.add(com.google.gson.t.n.n.a(AtomicLongArray.class, c(qVarM)));
        arrayList.add(com.google.gson.t.n.n.s);
        arrayList.add(com.google.gson.t.n.n.z);
        arrayList.add(com.google.gson.t.n.n.F);
        arrayList.add(com.google.gson.t.n.n.H);
        arrayList.add(com.google.gson.t.n.n.a(BigDecimal.class, com.google.gson.t.n.n.B));
        arrayList.add(com.google.gson.t.n.n.a(BigInteger.class, com.google.gson.t.n.n.C));
        arrayList.add(com.google.gson.t.n.n.J);
        arrayList.add(com.google.gson.t.n.n.L);
        arrayList.add(com.google.gson.t.n.n.P);
        arrayList.add(com.google.gson.t.n.n.R);
        arrayList.add(com.google.gson.t.n.n.W);
        arrayList.add(com.google.gson.t.n.n.N);
        arrayList.add(com.google.gson.t.n.n.f20267d);
        arrayList.add(com.google.gson.t.n.c.a);
        arrayList.add(com.google.gson.t.n.n.U);
        arrayList.add(com.google.gson.t.n.k.a);
        arrayList.add(com.google.gson.t.n.j.a);
        arrayList.add(com.google.gson.t.n.n.S);
        arrayList.add(com.google.gson.t.n.a.a);
        arrayList.add(com.google.gson.t.n.n.f20265b);
        arrayList.add(new com.google.gson.t.n.b(cVar));
        arrayList.add(new com.google.gson.t.n.g(cVar, z2));
        com.google.gson.t.n.d dVar3 = new com.google.gson.t.n.d(cVar);
        this.f20144e = dVar3;
        arrayList.add(dVar3);
        arrayList.add(com.google.gson.t.n.n.Z);
        arrayList.add(new com.google.gson.t.n.i(cVar, dVar2, dVar, dVar3));
        this.f20145f = Collections.unmodifiableList(arrayList);
    }
}
