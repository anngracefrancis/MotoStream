package com.google.gson.stream;

import cm.aptoide.pt.account.AdultContentAnalytics;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f20168f = new String[128];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f20169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Writer f20170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f20171i = new int[32];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20172j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f20173k;
    private String l;
    private boolean m;
    private boolean n;
    private String o;
    private boolean p;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f20168f[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f20168f;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f20169g = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        B(6);
        this.l = ":";
        this.p = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f20170h = writer;
    }

    private int A() {
        int i2 = this.f20172j;
        if (i2 != 0) {
            return this.f20171i[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void B(int i2) {
        int i3 = this.f20172j;
        int[] iArr = this.f20171i;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f20171i = iArr2;
        }
        int[] iArr3 = this.f20171i;
        int i4 = this.f20172j;
        this.f20172j = i4 + 1;
        iArr3[i4] = i2;
    }

    private void D(int i2) {
        this.f20171i[this.f20172j - 1] = i2;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void N(String str) throws IOException {
        String str2;
        String[] strArr = this.n ? f20169g : f20168f;
        this.f20170h.write("\"");
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i2 < i3) {
                        this.f20170h.write(str, i2, i3 - i2);
                    }
                    this.f20170h.write(str2);
                    i2 = i3 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i3) {
                    this.f20170h.write(str, i2, i3 - i2);
                }
                this.f20170h.write(str2);
                i2 = i3 + 1;
            }
        }
        if (i2 < length) {
            this.f20170h.write(str, i2, length - i2);
        }
        this.f20170h.write("\"");
    }

    private void a() throws IOException {
        int iA = A();
        if (iA == 5) {
            this.f20170h.write(44);
        } else if (iA != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        x();
        D(4);
    }

    private void a0() throws IOException {
        if (this.o != null) {
            a();
            N(this.o);
            this.o = null;
        }
    }

    private void b() throws IOException {
        int iA = A();
        if (iA == 1) {
            D(2);
            x();
            return;
        }
        if (iA == 2) {
            this.f20170h.append(',');
            x();
        } else {
            if (iA == 4) {
                this.f20170h.append((CharSequence) this.l);
                D(5);
                return;
            }
            if (iA != 6) {
                if (iA != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.m) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            D(7);
        }
    }

    private c e(int i2, int i3, String str) throws IOException {
        int iA = A();
        if (iA != i3 && iA != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.o != null) {
            throw new IllegalStateException("Dangling name: " + this.o);
        }
        this.f20172j--;
        if (iA == i3) {
            x();
        }
        this.f20170h.write(str);
        return this;
    }

    private void x() throws IOException {
        if (this.f20173k == null) {
            return;
        }
        this.f20170h.write("\n");
        int i2 = this.f20172j;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f20170h.write(this.f20173k);
        }
    }

    private c z(int i2, String str) throws IOException {
        b();
        B(i2);
        this.f20170h.write(str);
        return this;
    }

    public final void H(boolean z) {
        this.n = z;
    }

    public final void I(String str) {
        if (str.length() == 0) {
            this.f20173k = null;
            this.l = ":";
        } else {
            this.f20173k = str;
            this.l = ": ";
        }
    }

    public final void J(boolean z) {
        this.m = z;
    }

    public final void K(boolean z) {
        this.p = z;
    }

    public c Q(long j2) throws IOException {
        a0();
        b();
        this.f20170h.write(Long.toString(j2));
        return this;
    }

    public c T(Boolean bool) throws IOException {
        if (bool == null) {
            return y();
        }
        a0();
        b();
        this.f20170h.write(bool.booleanValue() ? "true" : AdultContentAnalytics.UNLOCK);
        return this;
    }

    public c W(Number number) throws IOException {
        if (number == null) {
            return y();
        }
        a0();
        String string = number.toString();
        if (this.m || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            b();
            this.f20170h.append((CharSequence) string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public c Y(String str) throws IOException {
        if (str == null) {
            return y();
        }
        a0();
        b();
        N(str);
        return this;
    }

    public c Z(boolean z) throws IOException {
        a0();
        b();
        this.f20170h.write(z ? "true" : AdultContentAnalytics.UNLOCK);
        return this;
    }

    public c c() throws IOException {
        a0();
        return z(1, "[");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f20170h.close();
        int i2 = this.f20172j;
        if (i2 > 1 || (i2 == 1 && this.f20171i[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f20172j = 0;
    }

    public c d() throws IOException {
        a0();
        return z(3, "{");
    }

    public c f() throws IOException {
        return e(1, 2, "]");
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f20172j == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f20170h.flush();
    }

    public c j() throws IOException {
        return e(3, 5, "}");
    }

    public final boolean k() {
        return this.p;
    }

    public final boolean l() {
        return this.n;
    }

    public boolean m() {
        return this.m;
    }

    public c p(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.o != null) {
            throw new IllegalStateException();
        }
        if (this.f20172j == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.o = str;
        return this;
    }

    public c y() throws IOException {
        if (this.o != null) {
            if (!this.p) {
                this.o = null;
                return this;
            }
            a0();
        }
        b();
        this.f20170h.write("null");
        return this;
    }
}
