package com.squareup.moshi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: JsonValueWriter.java */
/* JADX INFO: loaded from: classes2.dex */
final class n extends o {
    Object[] o = new Object[32];
    private String p;

    n() {
        z(6);
    }

    private n T(Object obj) {
        String str;
        Object objPut;
        int iX = x();
        int i2 = this.f20572f;
        if (i2 == 1) {
            if (iX != 6) {
                throw new IllegalStateException("JSON must have only one top-level value.");
            }
            this.f20573g[i2 - 1] = 7;
            this.o[i2 - 1] = obj;
        } else if (iX != 3 || (str = this.p) == null) {
            if (iX != 1) {
                if (iX == 9) {
                    throw new IllegalStateException("Sink from valueSink() was not closed");
                }
                throw new IllegalStateException("Nesting problem.");
            }
            ((List) this.o[i2 - 1]).add(obj);
        } else {
            if ((obj != null || this.l) && (objPut = ((Map) this.o[i2 - 1]).put(str, obj)) != null) {
                throw new IllegalArgumentException("Map key '" + this.p + "' has multiple values at path " + g() + ": " + objPut + " and " + obj);
            }
            this.p = null;
        }
        return this;
    }

    @Override // com.squareup.moshi.o
    public o I(double d2) throws IOException {
        if (!this.f20577k && (Double.isNaN(d2) || d2 == Double.NEGATIVE_INFINITY || d2 == Double.POSITIVE_INFINITY)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        if (this.m) {
            this.m = false;
            return l(Double.toString(d2));
        }
        T(Double.valueOf(d2));
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o J(long j2) throws IOException {
        if (this.m) {
            this.m = false;
            return l(Long.toString(j2));
        }
        T(Long.valueOf(j2));
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o K(Number number) throws IOException {
        if ((number instanceof Byte) || (number instanceof Short) || (number instanceof Integer) || (number instanceof Long)) {
            return J(number.longValue());
        }
        if ((number instanceof Float) || (number instanceof Double)) {
            return I(number.doubleValue());
        }
        if (number == null) {
            return m();
        }
        BigDecimal bigDecimal = number instanceof BigDecimal ? (BigDecimal) number : new BigDecimal(number.toString());
        if (this.m) {
            this.m = false;
            return l(bigDecimal.toString());
        }
        T(bigDecimal);
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o N(String str) throws IOException {
        if (this.m) {
            this.m = false;
            return l(str);
        }
        T(str);
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o Q(boolean z) throws IOException {
        if (this.m) {
            throw new IllegalStateException("Boolean cannot be used as a map key in JSON at path " + g());
        }
        T(Boolean.valueOf(z));
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }

    public Object W() {
        int i2 = this.f20572f;
        if (i2 > 1 || (i2 == 1 && this.f20573g[i2 - 1] != 7)) {
            throw new IllegalStateException("Incomplete document");
        }
        return this.o[0];
    }

    @Override // com.squareup.moshi.o
    public o a() throws IOException {
        if (this.m) {
            throw new IllegalStateException("Array cannot be used as a map key in JSON at path " + g());
        }
        int i2 = this.f20572f;
        int i3 = this.n;
        if (i2 == i3 && this.f20573g[i2 - 1] == 1) {
            this.n = i3 ^ (-1);
            return this;
        }
        c();
        ArrayList arrayList = new ArrayList();
        T(arrayList);
        Object[] objArr = this.o;
        int i4 = this.f20572f;
        objArr[i4] = arrayList;
        this.f20575i[i4] = 0;
        z(1);
        return this;
    }

    @Override // com.squareup.moshi.o
    public o b() throws IOException {
        if (this.m) {
            throw new IllegalStateException("Object cannot be used as a map key in JSON at path " + g());
        }
        int i2 = this.f20572f;
        int i3 = this.n;
        if (i2 == i3 && this.f20573g[i2 - 1] == 3) {
            this.n = i3 ^ (-1);
            return this;
        }
        c();
        p pVar = new p();
        T(pVar);
        this.o[this.f20572f] = pVar;
        z(3);
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        int i2 = this.f20572f;
        if (i2 > 1 || (i2 == 1 && this.f20573g[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f20572f = 0;
    }

    @Override // com.squareup.moshi.o
    public o d() throws IOException {
        if (x() != 1) {
            throw new IllegalStateException("Nesting problem.");
        }
        int i2 = this.f20572f;
        int i3 = this.n;
        if (i2 == (i3 ^ (-1))) {
            this.n = i3 ^ (-1);
            return this;
        }
        int i4 = i2 - 1;
        this.f20572f = i4;
        this.o[i4] = null;
        int[] iArr = this.f20575i;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o e() throws IOException {
        if (x() != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.p != null) {
            throw new IllegalStateException("Dangling name: " + this.p);
        }
        int i2 = this.f20572f;
        int i3 = this.n;
        if (i2 == (i3 ^ (-1))) {
            this.n = i3 ^ (-1);
            return this;
        }
        this.m = false;
        int i4 = i2 - 1;
        this.f20572f = i4;
        this.o[i4] = null;
        this.f20574h[i4] = null;
        int[] iArr = this.f20575i;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        return this;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f20572f == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    @Override // com.squareup.moshi.o
    public o l(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f20572f == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        if (x() != 3 || this.p != null || this.m) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.p = str;
        this.f20574h[this.f20572f - 1] = str;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o m() throws IOException {
        if (this.m) {
            throw new IllegalStateException("null cannot be used as a map key in JSON at path " + g());
        }
        T(null);
        int[] iArr = this.f20575i;
        int i2 = this.f20572f - 1;
        iArr[i2] = iArr[i2] + 1;
        return this;
    }
}
