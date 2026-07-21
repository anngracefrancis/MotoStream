package com.squareup.moshi;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: StandardJsonAdapters.java */
/* JADX INFO: loaded from: classes2.dex */
final class t {
    public static final com.squareup.moshi.f.e a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final com.squareup.moshi.f<Boolean> f20614b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final com.squareup.moshi.f<Byte> f20615c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final com.squareup.moshi.f<Character> f20616d = new f();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final com.squareup.moshi.f<Double> f20617e = new g();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final com.squareup.moshi.f<Float> f20618f = new h();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final com.squareup.moshi.f<Integer> f20619g = new i();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final com.squareup.moshi.f<Long> f20620h = new j();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final com.squareup.moshi.f<Short> f20621i = new k();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final com.squareup.moshi.f<String> f20622j = new a();

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    class a extends com.squareup.moshi.f<String> {
        a() {
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public String fromJson(com.squareup.moshi.i iVar) throws IOException {
            return iVar.y();
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, String str) throws IOException {
            oVar.N(str);
        }

        public String toString() {
            return "JsonAdapter(String)";
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.squareup.moshi.i.b.values().length];
            a = iArr;
            try {
                iArr[com.squareup.moshi.i.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.squareup.moshi.i.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.squareup.moshi.i.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.squareup.moshi.i.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.squareup.moshi.i.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.squareup.moshi.i.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    class c implements com.squareup.moshi.f.e {
        c() {
        }

        @Override // com.squareup.moshi.f.e
        public com.squareup.moshi.f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
            if (!set.isEmpty()) {
                return null;
            }
            if (type == Boolean.TYPE) {
                return t.f20614b;
            }
            if (type == Byte.TYPE) {
                return t.f20615c;
            }
            if (type == Character.TYPE) {
                return t.f20616d;
            }
            if (type == Double.TYPE) {
                return t.f20617e;
            }
            if (type == Float.TYPE) {
                return t.f20618f;
            }
            if (type == Integer.TYPE) {
                return t.f20619g;
            }
            if (type == Long.TYPE) {
                return t.f20620h;
            }
            if (type == Short.TYPE) {
                return t.f20621i;
            }
            if (type == Boolean.class) {
                return t.f20614b.nullSafe();
            }
            if (type == Byte.class) {
                return t.f20615c.nullSafe();
            }
            if (type == Character.class) {
                return t.f20616d.nullSafe();
            }
            if (type == Double.class) {
                return t.f20617e.nullSafe();
            }
            if (type == Float.class) {
                return t.f20618f.nullSafe();
            }
            if (type == Integer.class) {
                return t.f20619g.nullSafe();
            }
            if (type == Long.class) {
                return t.f20620h.nullSafe();
            }
            if (type == Short.class) {
                return t.f20621i.nullSafe();
            }
            if (type == String.class) {
                return t.f20622j.nullSafe();
            }
            if (type == Object.class) {
                return new m(rVar).nullSafe();
            }
            Class<?> clsG = u.g(type);
            com.squareup.moshi.f<?> fVarD = com.squareup.moshi.w.c.d(rVar, type, clsG);
            if (fVarD != null) {
                return fVarD;
            }
            if (clsG.isEnum()) {
                return new l(clsG).nullSafe();
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    class d extends com.squareup.moshi.f<Boolean> {
        d() {
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Boolean.valueOf(iVar.k());
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Boolean bool) throws IOException {
            oVar.Q(bool.booleanValue());
        }

        public String toString() {
            return "JsonAdapter(Boolean)";
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    class e extends com.squareup.moshi.f<Byte> {
        e() {
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Byte fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Byte.valueOf((byte) t.a(iVar, "a byte", -128, 255));
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Byte b2) throws IOException {
            oVar.J(b2.intValue() & 255);
        }

        public String toString() {
            return "JsonAdapter(Byte)";
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    class f extends com.squareup.moshi.f<Character> {
        f() {
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Character fromJson(com.squareup.moshi.i iVar) throws IOException {
            String strY = iVar.y();
            if (strY.length() <= 1) {
                return Character.valueOf(strY.charAt(0));
            }
            throw new JsonDataException(String.format("Expected %s but was %s at path %s", "a char", '\"' + strY + '\"', iVar.g()));
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Character ch) throws IOException {
            oVar.N(ch.toString());
        }

        public String toString() {
            return "JsonAdapter(Character)";
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    class g extends com.squareup.moshi.f<Double> {
        g() {
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Double fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Double.valueOf(iVar.l());
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Double d2) throws IOException {
            oVar.I(d2.doubleValue());
        }

        public String toString() {
            return "JsonAdapter(Double)";
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    class h extends com.squareup.moshi.f<Float> {
        h() {
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float fromJson(com.squareup.moshi.i iVar) throws IOException {
            float fL = (float) iVar.l();
            if (iVar.j() || !Float.isInfinite(fL)) {
                return Float.valueOf(fL);
            }
            throw new JsonDataException("JSON forbids NaN and infinities: " + fL + " at path " + iVar.g());
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Float f2) throws IOException {
            f2.getClass();
            oVar.K(f2);
        }

        public String toString() {
            return "JsonAdapter(Float)";
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    class i extends com.squareup.moshi.f<Integer> {
        i() {
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Integer.valueOf(iVar.m());
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Integer num) throws IOException {
            oVar.J(num.intValue());
        }

        public String toString() {
            return "JsonAdapter(Integer)";
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    class j extends com.squareup.moshi.f<Long> {
        j() {
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Long fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Long.valueOf(iVar.p());
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Long l) throws IOException {
            oVar.J(l.longValue());
        }

        public String toString() {
            return "JsonAdapter(Long)";
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    class k extends com.squareup.moshi.f<Short> {
        k() {
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Short fromJson(com.squareup.moshi.i iVar) throws IOException {
            return Short.valueOf((short) t.a(iVar, "a short", -32768, 32767));
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, Short sh) throws IOException {
            oVar.J(sh.intValue());
        }

        public String toString() {
            return "JsonAdapter(Short)";
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    static final class l<T extends Enum<T>> extends com.squareup.moshi.f<T> {
        private final Class<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String[] f20623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final T[] f20624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.squareup.moshi.i.a f20625d;

        l(Class<T> cls) {
            this.a = cls;
            try {
                T[] enumConstants = cls.getEnumConstants();
                this.f20624c = enumConstants;
                this.f20623b = new String[enumConstants.length];
                int i2 = 0;
                while (true) {
                    T[] tArr = this.f20624c;
                    if (i2 >= tArr.length) {
                        this.f20625d = com.squareup.moshi.i.a.a(this.f20623b);
                        return;
                    } else {
                        String strName = tArr[i2].name();
                        this.f20623b[i2] = com.squareup.moshi.w.c.m(strName, cls.getField(strName));
                        i2++;
                    }
                }
            } catch (NoSuchFieldException e2) {
                AssertionError assertionError = new AssertionError("Missing field in " + cls.getName());
                assertionError.initCause(e2);
                throw assertionError;
            }
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public T fromJson(com.squareup.moshi.i iVar) throws IOException {
            int I = iVar.I(this.f20625d);
            if (I != -1) {
                return this.f20624c[I];
            }
            String strG = iVar.g();
            throw new JsonDataException("Expected one of " + Arrays.asList(this.f20623b) + " but was " + iVar.y() + " at path " + strG);
        }

        @Override // com.squareup.moshi.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void toJson(o oVar, T t) throws IOException {
            oVar.N(this.f20623b[t.ordinal()]);
        }

        public String toString() {
            return "JsonAdapter(" + this.a.getName() + ")";
        }
    }

    /* JADX INFO: compiled from: StandardJsonAdapters.java */
    static final class m extends com.squareup.moshi.f<Object> {
        private final r a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.squareup.moshi.f<List> f20626b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.squareup.moshi.f<Map> f20627c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final com.squareup.moshi.f<String> f20628d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.squareup.moshi.f<Double> f20629e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final com.squareup.moshi.f<Boolean> f20630f;

        m(r rVar) {
            this.a = rVar;
            this.f20626b = rVar.c(List.class);
            this.f20627c = rVar.c(Map.class);
            this.f20628d = rVar.c(String.class);
            this.f20629e = rVar.c(Double.class);
            this.f20630f = rVar.c(Boolean.class);
        }

        private Class<?> a(Class<?> cls) {
            if (Map.class.isAssignableFrom(cls)) {
                return Map.class;
            }
            return Collection.class.isAssignableFrom(cls) ? Collection.class : cls;
        }

        @Override // com.squareup.moshi.f
        public Object fromJson(com.squareup.moshi.i iVar) throws IOException {
            switch (b.a[iVar.A().ordinal()]) {
                case 1:
                    return this.f20626b.fromJson(iVar);
                case 2:
                    return this.f20627c.fromJson(iVar);
                case 3:
                    return this.f20628d.fromJson(iVar);
                case 4:
                    return this.f20629e.fromJson(iVar);
                case 5:
                    return this.f20630f.fromJson(iVar);
                case 6:
                    return iVar.x();
                default:
                    throw new IllegalStateException("Expected a value but was " + iVar.A() + " at path " + iVar.g());
            }
        }

        @Override // com.squareup.moshi.f
        public void toJson(o oVar, Object obj) throws IOException {
            Class<?> cls = obj.getClass();
            if (cls != Object.class) {
                this.a.e(a(cls), com.squareup.moshi.w.c.a).toJson(oVar, obj);
            } else {
                oVar.b();
                oVar.e();
            }
        }

        public String toString() {
            return "JsonAdapter(Object)";
        }
    }

    static int a(com.squareup.moshi.i iVar, String str, int i2, int i3) throws IOException {
        int iM = iVar.m();
        if (iM < i2 || iM > i3) {
            throw new JsonDataException(String.format("Expected %s but was %s at path %s", str, Integer.valueOf(iM), iVar.g()));
        }
        return iM;
    }
}
