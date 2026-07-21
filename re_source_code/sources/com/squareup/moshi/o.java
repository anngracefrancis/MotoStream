package com.squareup.moshi;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class o implements Closeable, Flushable {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    String f20576j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    boolean f20577k;
    boolean l;
    boolean m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    int f20572f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    int[] f20573g = new int[32];

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    String[] f20574h = new String[32];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int[] f20575i = new int[32];
    int n = -1;

    o() {
    }

    public static o p(j.g gVar) {
        return new l(gVar);
    }

    final void A(int i2) {
        this.f20573g[this.f20572f - 1] = i2;
    }

    public void B(String str) {
        if (str.isEmpty()) {
            str = null;
        }
        this.f20576j = str;
    }

    public final void D(boolean z) {
        this.f20577k = z;
    }

    public final void H(boolean z) {
        this.l = z;
    }

    public abstract o I(double d2) throws IOException;

    public abstract o J(long j2) throws IOException;

    public abstract o K(Number number) throws IOException;

    public abstract o N(String str) throws IOException;

    public abstract o Q(boolean z) throws IOException;

    public abstract o a() throws IOException;

    public abstract o b() throws IOException;

    final boolean c() {
        int i2 = this.f20572f;
        int[] iArr = this.f20573g;
        if (i2 != iArr.length) {
            return false;
        }
        if (i2 == 256) {
            throw new JsonDataException("Nesting too deep at " + g() + ": circular reference?");
        }
        this.f20573g = Arrays.copyOf(iArr, iArr.length * 2);
        String[] strArr = this.f20574h;
        this.f20574h = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
        int[] iArr2 = this.f20575i;
        this.f20575i = Arrays.copyOf(iArr2, iArr2.length * 2);
        if (!(this instanceof n)) {
            return true;
        }
        n nVar = (n) this;
        Object[] objArr = nVar.o;
        nVar.o = Arrays.copyOf(objArr, objArr.length * 2);
        return true;
    }

    public abstract o d() throws IOException;

    public abstract o e() throws IOException;

    public final String f() {
        String str = this.f20576j;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public final String g() {
        return j.a(this.f20572f, this.f20573g, this.f20574h, this.f20575i);
    }

    public final boolean j() {
        return this.l;
    }

    public final boolean k() {
        return this.f20577k;
    }

    public abstract o l(String str) throws IOException;

    public abstract o m() throws IOException;

    final int x() {
        int i2 = this.f20572f;
        if (i2 != 0) {
            return this.f20573g[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void y() throws IOException {
        int iX = x();
        if (iX != 5 && iX != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        this.m = true;
    }

    final void z(int i2) {
        int[] iArr = this.f20573g;
        int i3 = this.f20572f;
        this.f20572f = i3 + 1;
        iArr[i3] = i2;
    }
}
