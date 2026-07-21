package com.squareup.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: JsonReader.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class i implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f20556f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int[] f20557g = new int[32];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String[] f20558h = new String[32];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int[] f20559i = new int[32];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    boolean f20560j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f20561k;

    /* JADX INFO: compiled from: JsonReader.java */
    public static final class a {
        final String[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final j.t f20562b;

        private a(String[] strArr, j.t tVar) {
            this.a = strArr;
            this.f20562b = tVar;
        }

        public static a a(String... strArr) {
            try {
                j.i[] iVarArr = new j.i[strArr.length];
                j.f fVar = new j.f();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    l.e0(fVar, strArr[i2]);
                    fVar.readByte();
                    iVarArr[i2] = fVar.D0();
                }
                return new a((String[]) strArr.clone(), j.t.r(iVarArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* JADX INFO: compiled from: JsonReader.java */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    i() {
    }

    public static i z(j.h hVar) {
        return new k(hVar);
    }

    public abstract b A() throws IOException;

    public abstract void B() throws IOException;

    final void D(int i2) {
        int i3 = this.f20556f;
        int[] iArr = this.f20557g;
        if (i3 == iArr.length) {
            if (i3 == 256) {
                throw new JsonDataException("Nesting too deep at " + g());
            }
            this.f20557g = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f20558h;
            this.f20558h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f20559i;
            this.f20559i = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f20557g;
        int i4 = this.f20556f;
        this.f20556f = i4 + 1;
        iArr3[i4] = i2;
    }

    public abstract int H(a aVar) throws IOException;

    public abstract int I(a aVar) throws IOException;

    public final void J(boolean z) {
        this.f20561k = z;
    }

    public final void K(boolean z) {
        this.f20560j = z;
    }

    public abstract void N() throws IOException;

    public abstract void Q() throws IOException;

    final JsonEncodingException T(String str) throws JsonEncodingException {
        throw new JsonEncodingException(str + " at path " + g());
    }

    final JsonDataException W(Object obj, Object obj2) {
        if (obj == null) {
            return new JsonDataException("Expected " + obj2 + " but was null at path " + g());
        }
        return new JsonDataException("Expected " + obj2 + " but was " + obj + ", a " + obj.getClass().getName() + ", at path " + g());
    }

    public abstract void a() throws IOException;

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public final boolean e() {
        return this.f20561k;
    }

    public abstract boolean f() throws IOException;

    public final String g() {
        return j.a(this.f20556f, this.f20557g, this.f20558h, this.f20559i);
    }

    public final boolean j() {
        return this.f20560j;
    }

    public abstract boolean k() throws IOException;

    public abstract double l() throws IOException;

    public abstract int m() throws IOException;

    public abstract long p() throws IOException;

    public abstract <T> T x() throws IOException;

    public abstract String y() throws IOException;
}
