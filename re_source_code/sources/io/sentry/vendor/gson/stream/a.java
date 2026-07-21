package io.sentry.vendor.gson.stream;

import cm.aptoide.pt.account.AdultContentAnalytics;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: JsonReader.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public class a implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Reader f22784f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f22785g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final char[] f22786h = new char[1024];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f22787i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f22788j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f22789k = 0;
    private int l = 0;
    int m = 0;
    private long n;
    private int o;
    private String p;
    private int[] q;
    private int r;
    private String[] s;
    private int[] t;

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.q = iArr;
        this.r = 0;
        this.r = 0 + 1;
        iArr[0] = 6;
        this.s = new String[32];
        this.t = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f22784f = reader;
    }

    private int D(boolean z) throws IOException {
        char[] cArr = this.f22786h;
        int i2 = this.f22787i;
        int i3 = this.f22788j;
        while (true) {
            if (i2 == i3) {
                this.f22787i = i2;
                if (!k(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + p());
                }
                i2 = this.f22787i;
                i3 = this.f22788j;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f22789k++;
                this.l = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f22787i = i4;
                    if (i4 == i3) {
                        this.f22787i = i4 - 1;
                        boolean zK = k(2);
                        this.f22787i++;
                        if (!zK) {
                            return c2;
                        }
                    }
                    c();
                    int i5 = this.f22787i;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f22787i = i5 + 1;
                        if (!a0("*/")) {
                            throw m0("Unterminated comment");
                        }
                        i2 = this.f22787i + 2;
                        i3 = this.f22788j;
                    } else {
                        if (c3 != '/') {
                            return c2;
                        }
                        this.f22787i = i5 + 1;
                        e0();
                        i2 = this.f22787i;
                        i3 = this.f22788j;
                    }
                } else {
                    if (c2 != '#') {
                        this.f22787i = i4;
                        return c2;
                    }
                    this.f22787i = i4;
                    c();
                    e0();
                    i2 = this.f22787i;
                    i3 = this.f22788j;
                }
            }
            i2 = i4;
        }
    }

    private String I(char c2) throws IOException {
        int i2;
        char[] cArr = this.f22786h;
        StringBuilder sb = null;
        do {
            int i3 = this.f22787i;
            int i4 = this.f22788j;
            while (true) {
                int i5 = i4;
                i2 = i3;
                while (true) {
                    if (i3 < i5) {
                        int i6 = i3 + 1;
                        char c3 = cArr[i3];
                        if (c3 == c2) {
                            this.f22787i = i6;
                            int i7 = (i6 - i2) - 1;
                            if (sb == null) {
                                return new String(cArr, i2, i7);
                            }
                            sb.append(cArr, i2, i7);
                            return sb.toString();
                        }
                        if (c3 == '\\') {
                            this.f22787i = i6;
                            int i8 = (i6 - i2) - 1;
                            if (sb == null) {
                                sb = new StringBuilder(Math.max((i8 + 1) * 2, 16));
                            }
                            sb.append(cArr, i2, i8);
                            sb.append(Y());
                            i3 = this.f22787i;
                            i4 = this.f22788j;
                        } else {
                            if (c3 == '\n') {
                                this.f22789k++;
                                this.l = i6;
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
            this.f22787i = i3;
        } while (k(1));
        throw m0("Unterminated string");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    private String K() throws IOException {
        String string;
        int i2 = 0;
        StringBuilder sb = null;
        while (true) {
            int i3 = 0;
            while (true) {
                int i4 = this.f22787i;
                if (i4 + i3 < this.f22788j) {
                    char c2 = this.f22786h[i4 + i3];
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
                } else if (i3 >= this.f22786h.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i3, 16));
                    }
                    sb.append(this.f22786h, this.f22787i, i3);
                    this.f22787i += i3;
                    if (!k(1)) {
                    }
                } else if (!k(i3 + 1)) {
                    i2 = i3;
                }
                if (sb == null) {
                    string = new String(this.f22786h, this.f22787i, i2);
                } else {
                    sb.append(this.f22786h, this.f22787i, i2);
                    string = sb.toString();
                }
                this.f22787i += i2;
                return string;
            }
        }
    }

    private int Q() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f22786h[this.f22787i];
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
            if (this.f22787i + i3 >= this.f22788j && !k(i3 + 1)) {
                return 0;
            }
            char c3 = this.f22786h[this.f22787i + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f22787i + length < this.f22788j || k(length + 1)) && m(this.f22786h[this.f22787i + length])) {
            return 0;
        }
        this.f22787i += length;
        this.m = i2;
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x00fd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:14:0x0031  */
    /* JADX WARN: Code duplicated, block: B:92:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:94:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:99:0x00f2  */
    private int T() throws IOException {
        char c2;
        char[] cArr = this.f22786h;
        int i2 = this.f22787i;
        int i3 = this.f22788j;
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
                            if (!m(c2)) {
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
                i2 = this.f22787i;
                i3 = this.f22788j;
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
            this.n = j2;
            this.f22787i += i5;
            this.m = 15;
            return 15;
        }
        if (c3 != 2 && c3 != 4 && c3 != 7) {
            return 0;
        }
        this.o = i5;
        this.m = 16;
        return 16;
    }

    private void W(int i2) {
        int i3 = this.r;
        int[] iArr = this.q;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.q = Arrays.copyOf(iArr, i4);
            this.t = Arrays.copyOf(this.t, i4);
            this.s = (String[]) Arrays.copyOf(this.s, i4);
        }
        int[] iArr2 = this.q;
        int i5 = this.r;
        this.r = i5 + 1;
        iArr2[i5] = i2;
    }

    private char Y() throws IOException {
        int i2;
        int i3;
        if (this.f22787i == this.f22788j && !k(1)) {
            throw m0("Unterminated escape sequence");
        }
        char[] cArr = this.f22786h;
        int i4 = this.f22787i;
        int i5 = i4 + 1;
        this.f22787i = i5;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.f22789k++;
            this.l = i5;
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
                throw m0("Invalid escape sequence");
            }
            if (i5 + 4 > this.f22788j && !k(4)) {
                throw m0("Unterminated escape sequence");
            }
            char c3 = 0;
            int i6 = this.f22787i;
            int i7 = i6 + 4;
            while (i6 < i7) {
                char c4 = this.f22786h[i6];
                char c5 = (char) (c3 << 4);
                if (c4 < '0' || c4 > '9') {
                    if (c4 >= 'a' && c4 <= 'f') {
                        i2 = c4 - 'a';
                    } else {
                        if (c4 < 'A' || c4 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f22786h, this.f22787i, 4));
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
            this.f22787i += 4;
            return c3;
        }
        return c2;
    }

    private void Z(char c2) throws IOException {
        char[] cArr = this.f22786h;
        do {
            int i2 = this.f22787i;
            int i3 = this.f22788j;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f22787i = i4;
                    return;
                }
                if (c3 == '\\') {
                    this.f22787i = i4;
                    Y();
                    i2 = this.f22787i;
                    i3 = this.f22788j;
                } else {
                    if (c3 == '\n') {
                        this.f22789k++;
                        this.l = i4;
                    }
                    i2 = i4;
                }
            }
            this.f22787i = i2;
        } while (k(1));
        throw m0("Unterminated string");
    }

    private boolean a0(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f22787i + length > this.f22788j && !k(length)) {
                return false;
            }
            char[] cArr = this.f22786h;
            int i2 = this.f22787i;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f22786h[this.f22787i + i3] == str.charAt(i3)) {
                    }
                }
                return true;
            }
            this.f22789k++;
            this.l = i2 + 1;
            this.f22787i++;
        }
    }

    private void c() throws IOException {
        if (!this.f22785g) {
            throw m0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void d() throws IOException {
        D(true);
        int i2 = this.f22787i - 1;
        this.f22787i = i2;
        if (i2 + 5 <= this.f22788j || k(5)) {
            char[] cArr = this.f22786h;
            if (cArr[i2] == ')' && cArr[i2 + 1] == ']' && cArr[i2 + 2] == '}' && cArr[i2 + 3] == '\'' && cArr[i2 + 4] == '\n') {
                this.f22787i += 5;
            }
        }
    }

    private void e0() throws IOException {
        char c2;
        do {
            if (this.f22787i >= this.f22788j && !k(1)) {
                return;
            }
            char[] cArr = this.f22786h;
            int i2 = this.f22787i;
            int i3 = i2 + 1;
            this.f22787i = i3;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.f22789k++;
                this.l = i3;
                return;
            }
        } while (c2 != '\r');
    }

    private void f0() throws IOException {
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.f22787i;
                if (i3 + i2 < this.f22788j) {
                    char c2 = this.f22786h[i3 + i2];
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
                    this.f22787i += i2;
                    return;
                }
                this.f22787i = i3 + i2;
            }
        } while (k(1));
    }

    private boolean k(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.f22786h;
        int i5 = this.l;
        int i6 = this.f22787i;
        this.l = i5 - i6;
        int i7 = this.f22788j;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f22788j = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f22788j = 0;
        }
        this.f22787i = 0;
        do {
            Reader reader = this.f22784f;
            int i9 = this.f22788j;
            int i10 = reader.read(cArr, i9, cArr.length - i9);
            if (i10 == -1) {
                return false;
            }
            i3 = this.f22788j + i10;
            this.f22788j = i3;
            if (this.f22789k == 0 && (i4 = this.l) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f22787i++;
                this.l = i4 + 1;
                i2++;
            }
        } while (i3 < i2);
        return true;
    }

    private boolean m(char c2) throws IOException {
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

    private IOException m0(String str) throws IOException {
        throw new MalformedJsonException(str + p());
    }

    public long A() throws IOException {
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.m = 0;
            int[] iArr = this.t;
            int i2 = this.r - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.n;
        }
        if (iE == 16) {
            this.p = new String(this.f22786h, this.f22787i, this.o);
            this.f22787i += this.o;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected a long but was " + N() + p());
            }
            if (iE == 10) {
                this.p = K();
            } else {
                this.p = I(iE == 8 ? '\'' : '\"');
            }
            try {
                long j2 = Long.parseLong(this.p);
                this.m = 0;
                int[] iArr2 = this.t;
                int i3 = this.r - 1;
                iArr2[i3] = iArr2[i3] + 1;
                return j2;
            } catch (NumberFormatException unused) {
            }
        }
        this.m = 11;
        double d2 = Double.parseDouble(this.p);
        long j3 = (long) d2;
        if (j3 != d2) {
            throw new NumberFormatException("Expected a long but was " + this.p + p());
        }
        this.p = null;
        this.m = 0;
        int[] iArr3 = this.t;
        int i4 = this.r - 1;
        iArr3[i4] = iArr3[i4] + 1;
        return j3;
    }

    public String B() throws IOException {
        String strI;
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 14) {
            strI = K();
        } else if (iE == 12) {
            strI = I('\'');
        } else {
            if (iE != 13) {
                throw new IllegalStateException("Expected a name but was " + N() + p());
            }
            strI = I('\"');
        }
        this.m = 0;
        this.s[this.r - 1] = strI;
        return strI;
    }

    public void H() throws IOException {
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 7) {
            this.m = 0;
            int[] iArr = this.t;
            int i2 = this.r - 1;
            iArr[i2] = iArr[i2] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + N() + p());
    }

    public String J() throws IOException {
        String str;
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 10) {
            str = K();
        } else if (iE == 8) {
            str = I('\'');
        } else if (iE == 9) {
            str = I('\"');
        } else if (iE == 11) {
            str = this.p;
            this.p = null;
        } else if (iE == 15) {
            str = Long.toString(this.n);
        } else {
            if (iE != 16) {
                throw new IllegalStateException("Expected a string but was " + N() + p());
            }
            str = new String(this.f22786h, this.f22787i, this.o);
            this.f22787i += this.o;
        }
        this.m = 0;
        int[] iArr = this.t;
        int i2 = this.r - 1;
        iArr[i2] = iArr[i2] + 1;
        return str;
    }

    public b N() throws IOException {
        int iE = this.m;
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
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 3) {
            W(1);
            this.t[this.r - 1] = 0;
            this.m = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + N() + p());
        }
    }

    public void b() throws IOException {
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 1) {
            W(3);
            this.m = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + N() + p());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.m = 0;
        this.q[0] = 8;
        this.r = 1;
        this.f22784f.close();
    }

    int e() throws IOException {
        int iD;
        int[] iArr = this.q;
        int i2 = this.r;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int iD2 = D(true);
            if (iD2 != 44) {
                if (iD2 != 59) {
                    if (iD2 != 93) {
                        throw m0("Unterminated array");
                    }
                    this.m = 4;
                    return 4;
                }
                c();
            }
        } else {
            if (i3 == 3 || i3 == 5) {
                iArr[i2 - 1] = 4;
                if (i3 == 5 && (iD = D(true)) != 44) {
                    if (iD != 59) {
                        if (iD != 125) {
                            throw m0("Unterminated object");
                        }
                        this.m = 2;
                        return 2;
                    }
                    c();
                }
                int iD3 = D(true);
                if (iD3 == 34) {
                    this.m = 13;
                    return 13;
                }
                if (iD3 == 39) {
                    c();
                    this.m = 12;
                    return 12;
                }
                if (iD3 == 125) {
                    if (i3 == 5) {
                        throw m0("Expected name");
                    }
                    this.m = 2;
                    return 2;
                }
                c();
                this.f22787i--;
                if (!m((char) iD3)) {
                    throw m0("Expected name");
                }
                this.m = 14;
                return 14;
            }
            if (i3 == 4) {
                iArr[i2 - 1] = 5;
                int iD4 = D(true);
                if (iD4 != 58) {
                    if (iD4 != 61) {
                        throw m0("Expected ':'");
                    }
                    c();
                    if (this.f22787i < this.f22788j || k(1)) {
                        char[] cArr = this.f22786h;
                        int i4 = this.f22787i;
                        if (cArr[i4] == '>') {
                            this.f22787i = i4 + 1;
                        }
                    }
                }
            } else if (i3 == 6) {
                if (this.f22785g) {
                    d();
                }
                this.q[this.r - 1] = 7;
            } else if (i3 == 7) {
                if (D(false) == -1) {
                    this.m = 17;
                    return 17;
                }
                c();
                this.f22787i--;
            } else if (i3 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iD5 = D(true);
        if (iD5 == 34) {
            this.m = 9;
            return 9;
        }
        if (iD5 == 39) {
            c();
            this.m = 8;
            return 8;
        }
        if (iD5 != 44 && iD5 != 59) {
            if (iD5 == 91) {
                this.m = 3;
                return 3;
            }
            if (iD5 != 93) {
                if (iD5 == 123) {
                    this.m = 1;
                    return 1;
                }
                this.f22787i--;
                int iQ = Q();
                if (iQ != 0) {
                    return iQ;
                }
                int iT = T();
                if (iT != 0) {
                    return iT;
                }
                if (!m(this.f22786h[this.f22787i])) {
                    throw m0("Expected value");
                }
                c();
                this.m = 10;
                return 10;
            }
            if (i3 == 1) {
                this.m = 4;
                return 4;
            }
        }
        if (i3 != 1 && i3 != 2) {
            throw m0("Unexpected value");
        }
        c();
        this.f22787i--;
        this.m = 7;
        return 7;
    }

    public void f() throws IOException {
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + N() + p());
        }
        int i2 = this.r - 1;
        this.r = i2;
        int[] iArr = this.t;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.m = 0;
    }

    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.r;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.q[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.t[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.s;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public void i0() throws IOException {
        int i2 = 0;
        do {
            int iE = this.m;
            if (iE == 0) {
                iE = e();
            }
            if (iE == 3) {
                W(1);
            } else {
                if (iE == 1) {
                    W(3);
                } else if (iE == 4 || iE == 2) {
                    this.r--;
                    i2--;
                } else if (iE == 14 || iE == 10) {
                    f0();
                } else if (iE == 8 || iE == 12) {
                    Z('\'');
                } else if (iE == 9 || iE == 13) {
                    Z('\"');
                } else if (iE == 16) {
                    this.f22787i += this.o;
                }
                this.m = 0;
            }
            i2++;
            this.m = 0;
        } while (i2 != 0);
        int[] iArr = this.t;
        int i3 = this.r;
        int i4 = i3 - 1;
        iArr[i4] = iArr[i4] + 1;
        this.s[i3 - 1] = "null";
    }

    public void j() throws IOException {
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        if (iE != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + N() + p());
        }
        int i2 = this.r - 1;
        this.r = i2;
        this.s[i2] = null;
        int[] iArr = this.t;
        int i3 = i2 - 1;
        iArr[i3] = iArr[i3] + 1;
        this.m = 0;
    }

    public boolean l() throws IOException {
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        return (iE == 2 || iE == 4) ? false : true;
    }

    String p() {
        return " at line " + (this.f22789k + 1) + " column " + ((this.f22787i - this.l) + 1) + " path " + g();
    }

    public String toString() {
        return getClass().getSimpleName() + p();
    }

    public boolean x() throws IOException {
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 5) {
            this.m = 0;
            int[] iArr = this.t;
            int i2 = this.r - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        }
        if (iE == 6) {
            this.m = 0;
            int[] iArr2 = this.t;
            int i3 = this.r - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + N() + p());
    }

    public double y() throws IOException {
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            this.m = 0;
            int[] iArr = this.t;
            int i2 = this.r - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.n;
        }
        if (iE == 16) {
            this.p = new String(this.f22786h, this.f22787i, this.o);
            this.f22787i += this.o;
        } else if (iE == 8 || iE == 9) {
            this.p = I(iE == 8 ? '\'' : '\"');
        } else if (iE == 10) {
            this.p = K();
        } else if (iE != 11) {
            throw new IllegalStateException("Expected a double but was " + N() + p());
        }
        this.m = 11;
        double d2 = Double.parseDouble(this.p);
        if (!this.f22785g && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + d2 + p());
        }
        this.p = null;
        this.m = 0;
        int[] iArr2 = this.t;
        int i3 = this.r - 1;
        iArr2[i3] = iArr2[i3] + 1;
        return d2;
    }

    public int z() throws IOException {
        int iE = this.m;
        if (iE == 0) {
            iE = e();
        }
        if (iE == 15) {
            long j2 = this.n;
            int i2 = (int) j2;
            if (j2 == i2) {
                this.m = 0;
                int[] iArr = this.t;
                int i3 = this.r - 1;
                iArr[i3] = iArr[i3] + 1;
                return i2;
            }
            throw new NumberFormatException("Expected an int but was " + this.n + p());
        }
        if (iE == 16) {
            this.p = new String(this.f22786h, this.f22787i, this.o);
            this.f22787i += this.o;
        } else {
            if (iE != 8 && iE != 9 && iE != 10) {
                throw new IllegalStateException("Expected an int but was " + N() + p());
            }
            if (iE == 10) {
                this.p = K();
            } else {
                this.p = I(iE == 8 ? '\'' : '\"');
            }
            try {
                int i4 = Integer.parseInt(this.p);
                this.m = 0;
                int[] iArr2 = this.t;
                int i5 = this.r - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return i4;
            } catch (NumberFormatException unused) {
            }
        }
        this.m = 11;
        double d2 = Double.parseDouble(this.p);
        int i6 = (int) d2;
        if (i6 != d2) {
            throw new NumberFormatException("Expected an int but was " + this.p + p());
        }
        this.p = null;
        this.m = 0;
        int[] iArr3 = this.t;
        int i7 = this.r - 1;
        iArr3[i7] = iArr3[i7] + 1;
        return i6;
    }
}
