package com.google.gson.stream;

import cm.aptoide.pt.account.AdultContentAnalytics;
import com.google.gson.t.f;
import com.google.gson.t.n.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

/* JADX INFO: compiled from: JsonReader.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char[] f20156f = ")]}'\n".toCharArray();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Reader f20157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f20158h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final char[] f20159i = new char[1024];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f20160j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f20161k = 0;
    private int l = 0;
    private int m = 0;
    int n = 0;
    private long o;
    private int p;
    private String q;
    private int[] r;
    private int s;
    private String[] t;
    private int[] u;

    /* JADX INFO: renamed from: com.google.gson.stream.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: JsonReader.java */
    static class C0240a extends f {
        C0240a() {
        }

        @Override // com.google.gson.t.f
        public void a(a aVar) throws IOException {
            if (aVar instanceof e) {
                ((e) aVar).y0();
                return;
            }
            int iE = aVar.n;
            if (iE == 0) {
                iE = aVar.e();
            }
            if (iE == 13) {
                aVar.n = 9;
                return;
            }
            if (iE == 12) {
                aVar.n = 8;
                return;
            }
            if (iE == 14) {
                aVar.n = 10;
                return;
            }
            throw new IllegalStateException("Expected a name but was " + aVar.Q() + aVar.x());
        }
    }

    static {
        f.a = new C0240a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.r = iArr;
        this.s = 0;
        this.s = 0 + 1;
        iArr[0] = 6;
        this.t = new String[32];
        this.u = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f20157g = reader;
    }

    private int H(boolean z) throws IOException {
        char[] cArr = this.f20159i;
        int i2 = this.f20160j;
        int i3 = this.f20161k;
        while (true) {
            if (i2 == i3) {
                this.f20160j = i2;
                if (!k(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + x());
                }
                i2 = this.f20160j;
                i3 = this.f20161k;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.l++;
                this.m = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f20160j = i4;
                    if (i4 == i3) {
                        this.f20160j = i4 - 1;
                        boolean zK = k(2);
                        this.f20160j++;
                        if (!zK) {
                            return c2;
                        }
                    }
                    c();
                    int i5 = this.f20160j;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f20160j = i5 + 1;
                        if (!f0("*/")) {
                            throw p0("Unterminated comment");
                        }
                        i2 = this.f20160j + 2;
                        i3 = this.f20161k;
                    } else {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.f20160j = i5 + 1;
                        i0();
                        i2 = this.f20160j;
                        i3 = this.f20161k;
                    }
                } else {
                    if (c2 != '#') {
                        this.f20160j = i4;
                        return c2;
                    }
                    this.f20160j = i4;
                    c();
                    i0();
                    i2 = this.f20160j;
                    i3 = this.f20161k;
                }
            }
            i2 = i4;
        }
    }

    private String J(char c2) throws IOException {
        int i2;
        char[] cArr = this.f20159i;
        StringBuilder sb = null;
        do {
            int i3 = this.f20160j;
            int i4 = this.f20161k;
            while (true) {
                int i5 = i4;
                i2 = i3;
                while (true) {
                    if (i3 < i5) {
                        int i6 = i3 + 1;
                        char c3 = cArr[i3];
                        if (c3 == c2) {
                            this.f20160j = i6;
                            int i7 = (i6 - i2) - 1;
                            if (sb == null) {
                                return new String(cArr, i2, i7);
                            }
                            sb.append(cArr, i2, i7);
                            return sb.toString();
                        }
                        if (c3 == '\\') {
                            this.f20160j = i6;
                            int i8 = (i6 - i2) - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max((i8 + 1) * 2, 16));
                            }
                            sb.append(cArr, i2, i8);
                            sb.append(Z());
                            i3 = this.f20160j;
                            i4 = this.f20161k;
                        } else {
                            if (c3 == '\n') {
                                this.l++;
                                this.m = i6;
                            }
                            i3 = i6;
                        }
                    }
                }
            }
            if (sb == null) {
                sb = new StringBuilder(Math.max((i3 - i2) * 2, 16));
            }
            sb.append(cArr, i2, i3 - i2);
            this.f20160j = i3;
        } while (k(1));
        throw p0("Unterminated string");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String N() throws IOException {
        String string;
        int i2 = 0;
        StringBuilder sb = null;
        while (true) {
            int i3 = 0;
            while (true) {
                int i4 = this.f20160j;
                if (i4 + i3 < this.f20161k) {
                    char c2 = this.f20159i[i4 + i3];
                    if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (c2 != '/' && c2 != '=') {
                                    if (c2 != '{' && c2 != '}' && c2 != ':') {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i3++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        c();
                    }
                    i2 = i3;
                } else if (i3 >= this.f20159i.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i3, 16));
                    }
                    sb.append(this.f20159i, this.f20160j, i3);
                    this.f20160j += i3;
                    if (!k(1)) {
                    }
                } else if (!k(i3 + 1)) {
                    i2 = i3;
                }
                if (sb == null) {
                    string = new String(this.f20159i, this.f20160j, i2);
                } else {
                    sb.append(this.f20159i, this.f20160j, i2);
                    string = sb.toString();
                }
                this.f20160j += i2;
                return string;
            }
        }
    }

    private int T() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f20159i[this.f20160j];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str = AdultContentAnalytics.UNLOCK;
            str2 = "FALSE";
        } else {
            if (c2 != 'n' && c2 != 'N') {
                return 0;
            }
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f20160j + i3 >= this.f20161k && !k(i3 + 1)) {
                return 0;
            }
            char c3 = this.f20159i[this.f20160j + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f20160j + length < this.f20161k || k(length + 1)) && p(this.f20159i[this.f20160j + length])) {
            return 0;
        }
        this.f20160j += length;
        this.n = i2;
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:92:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:94:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:99:0x00f2  */
    private int W() throws IOException {
        char c2;
        char[] cArr = this.f20159i;
        int i2 = this.f20160j;
        int i3 = this.f20161k;
        int i4 = 0;
        int i5 = 0;
        char c3 = 0;
        boolean z = true;
        long j2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 + i5 != i3) {
                c2 = cArr[i2 + i5];
                if (c2 != '+') {
                    if (c2 != 'E' || c2 == 'e') {
                        i4 = 0;
                        if (c3 == 2 && c3 != 4) {
                            return 0;
                        }
                        c3 = 5;
                    } else if (c2 == '-') {
                        i4 = 0;
                        if (c3 == 0) {
                            c3 = 1;
                            z2 = true;
                        } else if (c3 != 5) {
                            return 0;
                        }
                    } else if (c2 == '.') {
                        i4 = 0;
                        if (c3 != 2) {
                            return 0;
                        }
                        c3 = 3;
                    } else {
                        if (c2 < '0' || c2 > '9') {
                            if (!p(c2)) {
                                break;
                            }
                            return 0;
                        }
                        if (c3 == 1 || c3 == 0) {
                            j2 = -(c2 - '0');
                            i4 = 0;
                            c3 = 2;
                        } else {
                            if (c3 == 2) {
                                if (j2 == 0) {
                                    return 0;
                                }
                                long j3 = (10 * j2) - ((long) (c2 - '0'));
                                z &= j2 > -922337203685477580L || (j2 == -922337203685477580L && j3 < j2);
                                j2 = j3;
                            } else if (c3 == 3) {
                                i4 = 0;
                                c3 = 4;
                            } else if (c3 == 5 || c3 == 6) {
                                i4 = 0;
                                c3 = 7;
                            }
                            i4 = 0;
                        }
                    }
                    i5++;
                } else {
                    i4 = 0;
                    if (c3 != 5) {
                        return 0;
                    }
                }
                c3 = 6;
                i5++;
            } else {
                if (i5 == cArr.length) {
                    return i4;
                }
                if (!k(i5 + 1)) {
                    break;
                }
                i2 = this.f20160j;
                i3 = this.f20161k;
                c2 = cArr[i2 + i5];
                if (c2 != '+') {
                    if (c2 != 'E') {
                        i4 = 0;
                        if (c3 == 2) {
                        }
                        c3 = 5;
                    } else {
                        i4 = 0;
                        if (c3 == 2) {
                        }
                        c3 = 5;
                    }
                    i5++;
                } else {
                    i4 = 0;
                    if (c3 != 5) {
                        return 0;
                    }
                }
                c3 = 6;
                i5++;
            }
        }
        if (c3 == 2 && z && ((j2 != Long.MIN_VALUE || z2) && (j2 != 0 || !z2))) {
            if (!z2) {
                j2 = -j2;
            }
            this.o = j2;
            this.f20160j += i5;
            this.n = 15;
            return 15;
        }
        if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        }
        this.p = i5;
        this.n = 16;
        return 16;
    }

    private void Y(int i2) {
        int i3 = this.s;
        int[] iArr = this.r;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            int[] iArr3 = new int[i3 * 2];
            String[] strArr = new String[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.u, 0, iArr3, 0, this.s);
            System.arraycopy(this.t, 0, strArr, 0, this.s);
            this.r = iArr2;
            this.u = iArr3;
            this.t = strArr;
        }
        int[] iArr4 = this.r;
        int i4 = this.s;
        this.s = i4 + 1;
        iArr4[i4] = i2;
    }

    private char Z() throws IOException {
        int i2;
        int i3;
        if (this.f20160j == this.f20161k && !k(1)) {
            throw p0("Unterminated escape sequence");
        }
        char[] cArr = this.f20159i;
        int i4 = this.f20160j;
        int i5 = i4 + 1;
        this.f20160j = i5;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.l++;
            this.m = i5;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 == 'b') {
                return '\b';
            }
            if (c2 == 'f') {
                return '\f';
            }
            if (c2 == 'n') {
                return '\n';
            }
            if (c2 == 'r') {
                return '\r';
            }
            if (c2 == 't') {
                return '\t';
            }
            if (c2 != 'u') {
                throw p0("Invalid escape sequence");
            }
            if (i5 + 4 > this.f20161k && !k(4)) {
                throw p0("Unterminated escape sequence");
            }
            char c3 = 0;
            int i6 = this.f20160j;
            int i7 = i6 + 4;
            while (i6 < i7) {
                char c4 = this.f20159i[i6];
                char c5 = (char) (c3 << 4);
                if (c4 < '0' || c4 > '9') {
                    if (c4 >= 'a' && c4 <= 'f') {
                        i2 = c4 - 'a';
                    } else {
                        if (c4 < 'A' || c4 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f20159i, this.f20160j, 4));
                        }
                        i2 = c4 - 'A';
                    }
                    i3 = i2 + 10;
                } else {
                    i3 = c4 - '0';
                }
                c3 = (char) (c5 + i3);
                i6++;
            }
            this.f20160j += 4;
            return c3;
        }
        return c2;
    }

    private void c() throws IOException {
        if (!this.f20158h) {
            throw p0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void d() throws IOException {
        H(true);
        int i2 = this.f20160j - 1;
        this.f20160j = i2;
        char[] cArr = f20156f;
        if (i2 + cArr.length > this.f20161k && !k(cArr.length)) {
            return;
        }
        int i3 = 0;
        while (true) {
            char[] cArr2 = f20156f;
            if (i3 >= cArr2.length) {
                this.f20160j += cArr2.length;
                return;
            } else if (this.f20159i[this.f20160j + i3] != cArr2[i3]) {
                return;
            } else {
                i3++;
            }
        }
    }

    private void e0(char c2) throws IOException {
        char[] cArr = this.f20159i;
        do {
            int i2 = this.f20160j;
            int i3 = this.f20161k;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f20160j = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f20160j = i4;
                    Z();
                    i2 = this.f20160j;
                    i3 = this.f20161k;
                } else {
                    if (c3 == '\n') {
                        this.l++;
                        this.m = i4;
                    }
                    i2 = i4;
                }
            }
            this.f20160j = i2;
        } while (k(1));
        throw p0("Unterminated string");
    }

    private boolean f0(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f20160j + length > this.f20161k && !k(length)) {
                return false;
            }
            char[] cArr = this.f20159i;
            int i2 = this.f20160j;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f20159i[this.f20160j + i3] == str.charAt(i3)) {
                    }
                }
                return true;
            }
            this.l++;
            this.m = i2 + 1;
            this.f20160j++;
        }
    }

    private void i0() throws IOException {
        char c2;
        do {
            if (this.f20160j >= this.f20161k && !k(1)) {
                return;
            }
            char[] cArr = this.f20159i;
            int i2 = this.f20160j;
            int i3 = i2 + 1;
            this.f20160j = i3;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.l++;
                this.m = i3;
                return;
            }
        } while (c2 != '\r');
    }

    private boolean k(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.f20159i;
        int i5 = this.m;
        int i6 = this.f20160j;
        this.m = i5 - i6;
        int i7 = this.f20161k;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f20161k = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f20161k = 0;
        }
        this.f20160j = 0;
        do {
            Reader reader = this.f20157g;
            int i9 = this.f20161k;
            int i10 = reader.read(cArr, i9, cArr.length - i9);
            if (i10 == -1) {
                return false;
            }
            i3 = this.f20161k + i10;
            this.f20161k = i3;
            if (this.l == 0 && (i4 = this.m) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f20160j++;
                this.m = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    private void m0() throws IOException {
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.f20160j;
                if (i3 + i2 < this.f20161k) {
                    char c2 = this.f20159i[i3 + i2];
                    if (c2 != '\t' && c2 != '\n' && c2 != '\f' && c2 != '\r' && c2 != ' ') {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (c2 != '/' && c2 != '=') {
                                    if (c2 != '{' && c2 != '}' && c2 != ':') {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                        c();
                    }
                    this.f20160j += i2;
                    return;
                }
                this.f20160j = i3 + i2;
            }
        } while (k(1));
    }

    private boolean p(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    private IOException p0(String str) throws IOException {
        throw new MalformedJsonException(str + x());
    }

    public int A() throws IOException {
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            long j2 = this.o;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.n = 0;
                int[] iArr = this.u;
                int i3 = this.s - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.o + x());
        }
        if (iE == 16) {
            this.q = new String(this.f20159i, this.f20160j, this.p);
            this.f20160j += this.p;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected an int but was " + Q() + x());
            }
            if (iE == 10) {
                this.q = N();
            } else {
                this.q = J(iE == 8 ? '\'' : '\"');
            }
            try {
                int i4 = Integer.parseInt(this.q);
                this.n = 0;
                int[] iArr2 = this.u;
                int i5 = this.s - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        this.n = 11;
        double d2 = Double.parseDouble(this.q);
        int i6 = (int) d2;
        if (i6 != d2) {
            throw new NumberFormatException("Expected an int but was " + this.q + x());
        }
        this.q = null;
        this.n = 0;
        int[] iArr3 = this.u;
        int i7 = this.s - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }

    public long B() throws IOException {
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.n = 0;
            int[] iArr = this.u;
            int i2 = this.s - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.o;
        }
        if (iE == 16) {
            this.q = new String(this.f20159i, this.f20160j, this.p);
            this.f20160j += this.p;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected a long but was " + Q() + x());
            }
            if (iE == 10) {
                this.q = N();
            } else {
                this.q = J(iE == 8 ? '\'' : '\"');
            }
            try {
                long j2 = Long.parseLong(this.q);
                this.n = 0;
                int[] iArr2 = this.u;
                int i3 = this.s - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j2;
            } catch (NumberFormatException unused) {
            }
        }
        this.n = 11;
        double d2 = Double.parseDouble(this.q);
        long j3 = (long) d2;
        if (j3 != d2) {
            throw new NumberFormatException("Expected a long but was " + this.q + x());
        }
        this.q = null;
        this.n = 0;
        int[] iArr3 = this.u;
        int i4 = this.s - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j3;
    }

    public String D() throws IOException {
        String strJ;
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 14) {
            strJ = N();
        } else if (iE == 12) {
            strJ = J('\'');
        } else {
            if (iE != 13) {
                throw new IllegalStateException("Expected a name but was " + Q() + x());
            }
            strJ = J('\"');
        }
        this.n = 0;
        this.t[this.s - 1] = strJ;
        return strJ;
    }

    public void I() throws IOException {
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 7) {
            this.n = 0;
            int[] iArr = this.u;
            int i2 = this.s - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + Q() + x());
    }

    public String K() throws IOException {
        String str;
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 10) {
            str = N();
        } else if (iE == 8) {
            str = J('\'');
        } else if (iE == 9) {
            str = J('\"');
        } else if (iE == 11) {
            str = this.q;
            this.q = null;
        } else if (iE == 15) {
            str = Long.toString(this.o);
        } else {
            if (iE != 16) {
                throw new IllegalStateException("Expected a string but was " + Q() + x());
            }
            str = new String(this.f20159i, this.f20160j, this.p);
            this.f20160j += this.p;
        }
        this.n = 0;
        int[] iArr = this.u;
        int i2 = this.s - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public b Q() throws IOException {
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        switch (iE) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void a() throws IOException {
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 3) {
            Y(1);
            this.u[this.s - 1] = 0;
            this.n = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + Q() + x());
        }
    }

    public final void a0(boolean z) {
        this.f20158h = z;
    }

    public void b() throws IOException {
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 1) {
            Y(3);
            this.n = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + Q() + x());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.n = 0;
        this.r[0] = 8;
        this.s = 1;
        this.f20157g.close();
    }

    int e() throws IOException {
        int iH;
        int[] iArr = this.r;
        int i2 = this.s;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int iH2 = H(true);
            if (iH2 != 44) {
                if (iH2 != 59) {
                    if (iH2 != 93) {
                        throw p0("Unterminated array");
                    }
                    this.n = 4;
                    return 4;
                }
                c();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5 && (iH = H(true)) != 44) {
                    if (iH != 59) {
                        if (iH != 125) {
                            throw p0("Unterminated object");
                        }
                        this.n = 2;
                        return 2;
                    }
                    c();
                }
                int iH3 = H(true);
                if (iH3 == 34) {
                    this.n = 13;
                    return 13;
                }
                if (iH3 == 39) {
                    c();
                    this.n = 12;
                    return 12;
                }
                if (iH3 == 125) {
                    if (i3 == 5) {
                        throw p0("Expected name");
                    }
                    this.n = 2;
                    return 2;
                }
                c();
                this.f20160j--;
                if (!p((char) iH3)) {
                    throw p0("Expected name");
                }
                this.n = 14;
                return 14;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int iH4 = H(true);
                if (iH4 != 58) {
                    if (iH4 != 61) {
                        throw p0("Expected ':'");
                    }
                    c();
                    if (this.f20160j < this.f20161k || k(1)) {
                        char[] cArr = this.f20159i;
                        int i4 = this.f20160j;
                        if (cArr[i4] == '>') {
                            this.f20160j = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.f20158h) {
                    d();
                }
                this.r[this.s - 1] = 7;
            } else if (i3 == 7) {
                if (H(false) == -1) {
                    this.n = 17;
                    return 17;
                }
                c();
                this.f20160j--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iH5 = H(true);
        if (iH5 == 34) {
            this.n = 9;
            return 9;
        }
        if (iH5 == 39) {
            c();
            this.n = 8;
            return 8;
        }
        if (iH5 != 44 && iH5 != 59) {
            if (iH5 == 91) {
                this.n = 3;
                return 3;
            }
            if (iH5 != 93) {
                if (iH5 == 123) {
                    this.n = 1;
                    return 1;
                }
                this.f20160j--;
                int iT = T();
                if (iT != 0) {
                    return iT;
                }
                int iW = W();
                if (iW != 0) {
                    return iW;
                }
                if (!p(this.f20159i[this.f20160j])) {
                    throw p0("Expected value");
                }
                c();
                this.n = 10;
                return 10;
            }
            if (i3 == 1) {
                this.n = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw p0("Unexpected value");
        }
        c();
        this.f20160j--;
        this.n = 7;
        return 7;
    }

    public void f() throws IOException {
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + Q() + x());
        }
        int i2 = this.s - 1;
        this.s = i2;
        int[] iArr = this.u;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.n = 0;
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.s;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.r[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.u[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.t;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public void j() throws IOException {
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + Q() + x());
        }
        int i2 = this.s - 1;
        this.s = i2;
        this.t[i2] = null;
        int[] iArr = this.u;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.n = 0;
    }

    public boolean l() throws IOException {
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        return (iE == 2 || iE == 4) ? false : true;
    }

    public final boolean m() {
        return this.f20158h;
    }

    public void n0() throws IOException {
        int i2 = 0;
        do {
            int iE = this.n;
            if (iE == 0) {
                iE = e();
            }
            if (iE == 3) {
                Y(1);
            } else {
                if (iE == 1) {
                    Y(3);
                } else if (iE == 4 || iE == 2) {
                    this.s--;
                    i2--;
                } else if (iE == 14 || iE == 10) {
                    m0();
                } else if (iE == 8 || iE == 12) {
                    e0('\'');
                } else if (iE == 9 || iE == 13) {
                    e0('\"');
                } else if (iE == 16) {
                    this.f20160j += this.p;
                }
                this.n = 0;
            }
            i2++;
            this.n = 0;
        } while (i2 != 0);
        int[] iArr = this.u;
        int i3 = this.s;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.t[i3 - 1] = "null";
    }

    public String toString() {
        return getClass().getSimpleName() + x();
    }

    String x() {
        return " at line " + (this.l + 1) + " column " + ((this.f20160j - this.m) + 1) + " path " + g();
    }

    public boolean y() throws IOException {
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 5) {
            this.n = 0;
            int[] iArr = this.u;
            int i2 = this.s - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iE == 6) {
            this.n = 0;
            int[] iArr2 = this.u;
            int i3 = this.s - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + Q() + x());
    }

    public double z() throws IOException {
        int iE = this.n;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.n = 0;
            int[] iArr = this.u;
            int i2 = this.s - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.o;
        }
        if (iE == 16) {
            this.q = new String(this.f20159i, this.f20160j, this.p);
            this.f20160j += this.p;
        } else if (iE == 8 || iE == 9) {
            this.q = J(iE == 8 ? '\'' : '\"');
        } else if (iE == 10) {
            this.q = N();
        } else if (iE != 11) {
            throw new IllegalStateException("Expected a double but was " + Q() + x());
        }
        this.n = 11;
        double d2 = Double.parseDouble(this.q);
        if (!this.f20158h && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d2 + x());
        }
        this.q = null;
        this.n = 0;
        int[] iArr2 = this.u;
        int i3 = this.s - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d2;
    }
}
