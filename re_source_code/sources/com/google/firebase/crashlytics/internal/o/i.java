package com.google.firebase.crashlytics.internal.o;

import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.n.t;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: compiled from: QueueFileLogStore.java */
/* JADX INFO: loaded from: classes2.dex */
class i implements d {
    private static final Charset a = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f19169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h f19171d;

    /* JADX INFO: compiled from: QueueFileLogStore.java */
    class a implements h.d {
        final /* synthetic */ byte[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int[] f19172b;

        a(byte[] bArr, int[] iArr) {
            this.a = bArr;
            this.f19172b = iArr;
        }

        @Override // com.google.firebase.crashlytics.h.o.h.d
        public void a(InputStream inputStream, int i2) throws IOException {
            try {
                inputStream.read(this.a, this.f19172b[0], i2);
                int[] iArr = this.f19172b;
                iArr[0] = iArr[0] + i2;
            } finally {
                inputStream.close();
            }
        }
    }

    /* JADX INFO: compiled from: QueueFileLogStore.java */
    private static class b {
        public final byte[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19174b;

        b(byte[] bArr, int i2) {
            this.a = bArr;
            this.f19174b = i2;
        }
    }

    i(File file, int i2) {
        this.f19169b = file;
        this.f19170c = i2;
    }

    private void f(long j2, String str) {
        if (this.f19171d == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i2 = this.f19170c / 4;
            if (str.length() > i2) {
                str = "..." + str.substring(str.length() - i2);
            }
            this.f19171d.e(String.format(Locale.US, "%d %s%n", Long.valueOf(j2), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(a));
            while (!this.f19171d.p() && this.f19171d.N() > this.f19170c) {
                this.f19171d.H();
            }
        } catch (IOException e2) {
            h.f().e("There was a problem writing to the Crashlytics log.", e2);
        }
    }

    private b g() {
        if (!this.f19169b.exists()) {
            return null;
        }
        h();
        h hVar = this.f19171d;
        if (hVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[hVar.N()];
        try {
            this.f19171d.l(new a(bArr, iArr));
        } catch (IOException e2) {
            h.f().e("A problem occurred while reading the Crashlytics log file.", e2);
        }
        return new b(bArr, iArr[0]);
    }

    private void h() {
        if (this.f19171d == null) {
            try {
                this.f19171d = new h(this.f19169b);
            } catch (IOException e2) {
                h.f().e("Could not open log file: " + this.f19169b, e2);
            }
        }
    }

    @Override // com.google.firebase.crashlytics.internal.o.d
    public void a() {
        t.f(this.f19171d, "There was a problem closing the Crashlytics log file.");
        this.f19171d = null;
    }

    @Override // com.google.firebase.crashlytics.internal.o.d
    public String b() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return new String(bArrC, a);
        }
        return null;
    }

    @Override // com.google.firebase.crashlytics.internal.o.d
    public byte[] c() {
        b bVarG = g();
        if (bVarG == null) {
            return null;
        }
        int i2 = bVarG.f19174b;
        byte[] bArr = new byte[i2];
        System.arraycopy(bVarG.a, 0, bArr, 0, i2);
        return bArr;
    }

    @Override // com.google.firebase.crashlytics.internal.o.d
    public void d() {
        a();
        this.f19169b.delete();
    }

    @Override // com.google.firebase.crashlytics.internal.o.d
    public void e(long j2, String str) {
        h();
        f(j2, str);
    }
}
