package io.sentry.vendor.gson.stream;

import cm.aptoide.pt.account.AdultContentAnalytics;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: JsonWriter.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public class c implements Closeable, Flushable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String[] f22790f = new String[128];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String[] f22791g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Writer f22792h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int[] f22793i = new int[32];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f22794j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f22795k;
    private String l;
    private boolean m;
    private boolean n;
    private String o;
    private boolean p;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f22790f[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f22790f;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f22791g = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        y(6);
        this.l = ":";
        this.p = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f22792h = writer;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0034  */
    private void B(String str) throws IOException {
        String str2;
        String[] strArr = this.n ? f22791g : f22790f;
        this.f22792h.write(34);
        int length = str.length();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char cCharAt = str.charAt(i3);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i2 < i3) {
                        this.f22792h.write(str, i2, i3 - i2);
                    }
                    this.f22792h.write(str2);
                    i2 = i3 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i2 < i3) {
                    this.f22792h.write(str, i2, i3 - i2);
                }
                this.f22792h.write(str2);
                i2 = i3 + 1;
            }
        }
        if (i2 < length) {
            this.f22792h.write(str, i2, length - i2);
        }
        this.f22792h.write(34);
    }

    private void N() throws IOException {
        if (this.o != null) {
            a();
            B(this.o);
            this.o = null;
        }
    }

    private void a() throws IOException {
        int iX = x();
        if (iX == 5) {
            this.f22792h.write(44);
        } else if (iX != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        l();
        z(4);
    }

    private void b() throws IOException {
        int iX = x();
        if (iX == 1) {
            z(2);
            l();
            return;
        }
        if (iX == 2) {
            this.f22792h.append(',');
            l();
        } else {
            if (iX == 4) {
                this.f22792h.append((CharSequence) this.l);
                z(5);
                return;
            }
            if (iX != 6) {
                if (iX != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.m) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            z(7);
        }
    }

    private c e(int i2, int i3, char c2) throws IOException {
        int iX = x();
        if (iX != i3 && iX != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.o != null) {
            throw new IllegalStateException("Dangling name: " + this.o);
        }
        this.f22794j--;
        if (iX == i3) {
            l();
        }
        this.f22792h.write(c2);
        return this;
    }

    private void l() throws IOException {
        if (this.f22795k == null) {
            return;
        }
        this.f22792h.write(10);
        int i2 = this.f22794j;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f22792h.write(this.f22795k);
        }
    }

    private c p(int i2, char c2) throws IOException {
        b();
        y(i2);
        this.f22792h.write(c2);
        return this;
    }

    private int x() {
        int i2 = this.f22794j;
        if (i2 != 0) {
            return this.f22793i[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void y(int i2) {
        int i3 = this.f22794j;
        int[] iArr = this.f22793i;
        if (i3 == iArr.length) {
            this.f22793i = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.f22793i;
        int i4 = this.f22794j;
        this.f22794j = i4 + 1;
        iArr2[i4] = i2;
    }

    private void z(int i2) {
        this.f22793i[this.f22794j - 1] = i2;
    }

    public final void A(String str) {
        if (str.length() == 0) {
            this.f22795k = null;
            this.l = ":";
        } else {
            this.f22795k = str;
            this.l = ": ";
        }
    }

    public c D(long j2) throws IOException {
        N();
        b();
        this.f22792h.write(Long.toString(j2));
        return this;
    }

    public c H(Boolean bool) throws IOException {
        if (bool == null) {
            return m();
        }
        N();
        b();
        this.f22792h.write(bool.booleanValue() ? "true" : AdultContentAnalytics.UNLOCK);
        return this;
    }

    public c I(Number number) throws IOException {
        if (number == null) {
            return m();
        }
        N();
        String string = number.toString();
        if (this.m || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            b();
            this.f22792h.append((CharSequence) string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    public c J(String str) throws IOException {
        if (str == null) {
            return m();
        }
        N();
        b();
        B(str);
        return this;
    }

    public c K(boolean z) throws IOException {
        N();
        b();
        this.f22792h.write(z ? "true" : AdultContentAnalytics.UNLOCK);
        return this;
    }

    public c c() throws IOException {
        N();
        return p(1, '[');
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f22792h.close();
        int i2 = this.f22794j;
        if (i2 > 1 || (i2 == 1 && this.f22793i[i2 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f22794j = 0;
    }

    public c d() throws IOException {
        N();
        return p(3, '{');
    }

    public c f() throws IOException {
        return e(1, 2, ']');
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f22794j == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f22792h.flush();
    }

    public c j() throws IOException {
        return e(3, 5, '}');
    }

    public c k(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.o != null) {
            throw new IllegalStateException();
        }
        if (this.f22794j == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.o = str;
        return this;
    }

    public c m() throws IOException {
        if (this.o != null) {
            if (!this.p) {
                this.o = null;
                return this;
            }
            N();
        }
        b();
        this.f22792h.write("null");
        return this;
    }
}
