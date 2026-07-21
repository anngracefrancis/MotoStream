package com.squareup.moshi;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Set;

/* JADX INFO: compiled from: JsonAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class f<T> {

    /* JADX INFO: compiled from: JsonAdapter.java */
    class a extends f<T> {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        @Override // com.squareup.moshi.f
        public T fromJson(i iVar) throws IOException {
            return (T) this.a.fromJson(iVar);
        }

        @Override // com.squareup.moshi.f
        boolean isLenient() {
            return this.a.isLenient();
        }

        @Override // com.squareup.moshi.f
        public void toJson(o oVar, T t) throws IOException {
            boolean zJ = oVar.j();
            oVar.H(true);
            try {
                this.a.toJson(oVar, t);
            } finally {
                oVar.H(zJ);
            }
        }

        public String toString() {
            return this.a + ".serializeNulls()";
        }
    }

    /* JADX INFO: compiled from: JsonAdapter.java */
    class b extends f<T> {
        final /* synthetic */ f a;

        b(f fVar) {
            this.a = fVar;
        }

        @Override // com.squareup.moshi.f
        public T fromJson(i iVar) throws IOException {
            boolean zJ = iVar.j();
            iVar.K(true);
            try {
                return (T) this.a.fromJson(iVar);
            } finally {
                iVar.K(zJ);
            }
        }

        @Override // com.squareup.moshi.f
        boolean isLenient() {
            return true;
        }

        @Override // com.squareup.moshi.f
        public void toJson(o oVar, T t) throws IOException {
            boolean zK = oVar.k();
            oVar.D(true);
            try {
                this.a.toJson(oVar, t);
            } finally {
                oVar.D(zK);
            }
        }

        public String toString() {
            return this.a + ".lenient()";
        }
    }

    /* JADX INFO: compiled from: JsonAdapter.java */
    class c extends f<T> {
        final /* synthetic */ f a;

        c(f fVar) {
            this.a = fVar;
        }

        @Override // com.squareup.moshi.f
        public T fromJson(i iVar) throws IOException {
            boolean zE = iVar.e();
            iVar.J(true);
            try {
                return (T) this.a.fromJson(iVar);
            } finally {
                iVar.J(zE);
            }
        }

        @Override // com.squareup.moshi.f
        boolean isLenient() {
            return this.a.isLenient();
        }

        @Override // com.squareup.moshi.f
        public void toJson(o oVar, T t) throws IOException {
            this.a.toJson(oVar, t);
        }

        public String toString() {
            return this.a + ".failOnUnknown()";
        }
    }

    /* JADX INFO: compiled from: JsonAdapter.java */
    class d extends f<T> {
        final /* synthetic */ f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f20554b;

        d(f fVar, String str) {
            this.a = fVar;
            this.f20554b = str;
        }

        @Override // com.squareup.moshi.f
        public T fromJson(i iVar) throws IOException {
            return (T) this.a.fromJson(iVar);
        }

        @Override // com.squareup.moshi.f
        boolean isLenient() {
            return this.a.isLenient();
        }

        @Override // com.squareup.moshi.f
        public void toJson(o oVar, T t) throws IOException {
            String strF = oVar.f();
            oVar.B(this.f20554b);
            try {
                this.a.toJson(oVar, t);
            } finally {
                oVar.B(strF);
            }
        }

        public String toString() {
            return this.a + ".indent(\"" + this.f20554b + "\")";
        }
    }

    /* JADX INFO: compiled from: JsonAdapter.java */
    public interface e {
        f<?> a(Type type, Set<? extends Annotation> set, r rVar);
    }

    public final f<T> failOnUnknown() {
        return new c(this);
    }

    public abstract T fromJson(i iVar) throws IOException;

    public final T fromJson(j.h hVar) throws IOException {
        return fromJson(i.z(hVar));
    }

    public final T fromJsonValue(Object obj) {
        try {
            return fromJson(new m(obj));
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public f<T> indent(String str) {
        if (str != null) {
            return new d(this, str);
        }
        throw new NullPointerException("indent == null");
    }

    boolean isLenient() {
        return false;
    }

    public final f<T> lenient() {
        return new b(this);
    }

    public final f<T> nonNull() {
        return this instanceof com.squareup.moshi.w.a ? this : new com.squareup.moshi.w.a(this);
    }

    public final f<T> nullSafe() {
        return this instanceof com.squareup.moshi.w.b ? this : new com.squareup.moshi.w.b(this);
    }

    public final f<T> serializeNulls() {
        return new a(this);
    }

    public abstract void toJson(o oVar, T t) throws IOException;

    public final void toJson(j.g gVar, T t) throws IOException {
        toJson(o.p(gVar), t);
    }

    public final Object toJsonValue(T t) {
        n nVar = new n();
        try {
            toJson(nVar, t);
            return nVar.W();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public final T fromJson(String str) throws IOException {
        i iVarZ = i.z(new j.f().r0(str));
        T tFromJson = fromJson(iVarZ);
        if (isLenient() || iVarZ.A() == i.b.END_DOCUMENT) {
            return tFromJson;
        }
        throw new JsonDataException("JSON document was not fully consumed.");
    }

    public final String toJson(T t) {
        j.f fVar = new j.f();
        try {
            toJson(fVar, t);
            return fVar.T();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
