package c.i.i;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: BidiFormatter.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    static final d a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f3247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f3248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final a f3249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final a f3250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean f3251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f3252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final d f3253h;

    /* JADX INFO: renamed from: c.i.i.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BidiFormatter.java */
    public static final class C0074a {
        private boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3254b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private d f3255c;

        public C0074a() {
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z) {
            return z ? a.f3250e : a.f3249d;
        }

        private void c(boolean z) {
            this.a = z;
            this.f3255c = a.a;
            this.f3254b = 2;
        }

        public a a() {
            return (this.f3254b == 2 && this.f3255c == a.a) ? b(this.a) : new a(this.a, this.f3254b, this.f3255c);
        }
    }

    /* JADX INFO: compiled from: BidiFormatter.java */
    private static class b {
        private static final byte[] a = new byte[1792];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final CharSequence f3256b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f3257c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f3258d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f3259e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private char f3260f;

        static {
            for (int i2 = 0; i2 < 1792; i2++) {
                a[i2] = Character.getDirectionality(i2);
            }
        }

        b(CharSequence charSequence, boolean z) {
            this.f3256b = charSequence;
            this.f3257c = z;
            this.f3258d = charSequence.length();
        }

        private static byte c(char c2) {
            return c2 < 1792 ? a[c2] : Character.getDirectionality(c2);
        }

        private byte f() {
            char cCharAt;
            int i2 = this.f3259e;
            do {
                int i3 = this.f3259e;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f3256b;
                int i4 = i3 - 1;
                this.f3259e = i4;
                cCharAt = charSequence.charAt(i4);
                this.f3260f = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f3259e = i2;
            this.f3260f = ';';
            return (byte) 13;
        }

        private byte g() {
            char cCharAt;
            do {
                int i2 = this.f3259e;
                if (i2 >= this.f3258d) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f3256b;
                this.f3259e = i2 + 1;
                cCharAt = charSequence.charAt(i2);
                this.f3260f = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char cCharAt;
            int i2 = this.f3259e;
            while (true) {
                int i3 = this.f3259e;
                if (i3 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f3256b;
                int i4 = i3 - 1;
                this.f3259e = i4;
                char cCharAt2 = charSequence.charAt(i4);
                this.f3260f = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i5 = this.f3259e;
                        if (i5 <= 0) {
                            break;
                        }
                        CharSequence charSequence2 = this.f3256b;
                        int i6 = i5 - 1;
                        this.f3259e = i6;
                        cCharAt = charSequence2.charAt(i6);
                        this.f3260f = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f3259e = i2;
            this.f3260f = '>';
            return (byte) 13;
        }

        private byte i() {
            char cCharAt;
            int i2 = this.f3259e;
            while (true) {
                int i3 = this.f3259e;
                if (i3 >= this.f3258d) {
                    this.f3259e = i2;
                    this.f3260f = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f3256b;
                this.f3259e = i3 + 1;
                char cCharAt2 = charSequence.charAt(i3);
                this.f3260f = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i4 = this.f3259e;
                        if (i4 >= this.f3258d) {
                            break;
                        }
                        CharSequence charSequence2 = this.f3256b;
                        this.f3259e = i4 + 1;
                        cCharAt = charSequence2.charAt(i4);
                        this.f3260f = cCharAt;
                    } while (cCharAt != cCharAt2);
                }
            }
        }

        byte a() {
            char cCharAt = this.f3256b.charAt(this.f3259e - 1);
            this.f3260f = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f3256b, this.f3259e);
                this.f3259e -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f3259e--;
            byte bC = c(this.f3260f);
            if (!this.f3257c) {
                return bC;
            }
            char c2 = this.f3260f;
            if (c2 == '>') {
                return h();
            }
            return c2 == ';' ? f() : bC;
        }

        byte b() {
            char cCharAt = this.f3256b.charAt(this.f3259e);
            this.f3260f = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f3256b, this.f3259e);
                this.f3259e += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f3259e++;
            byte bC = c(this.f3260f);
            if (!this.f3257c) {
                return bC;
            }
            char c2 = this.f3260f;
            if (c2 == '<') {
                return i();
            }
            return c2 == '&' ? g() : bC;
        }

        int d() {
            this.f3259e = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (this.f3259e < this.f3258d && i2 == 0) {
                byte b2 = b();
                if (b2 != 0) {
                    if (b2 == 1 || b2 == 2) {
                        if (i4 == 0) {
                            return 1;
                        }
                    } else if (b2 != 9) {
                        switch (b2) {
                            case 14:
                            case 15:
                                i4++;
                                i3 = -1;
                                continue;
                            case 16:
                            case 17:
                                i4++;
                                i3 = 1;
                                continue;
                            case 18:
                                i4--;
                                i3 = 0;
                                continue;
                        }
                    }
                } else if (i4 == 0) {
                    return -1;
                }
                i2 = i4;
            }
            if (i2 == 0) {
                return 0;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.f3259e > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i2 == i4) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i2 == i4) {
                            return 1;
                        }
                        break;
                    case 18:
                        i4++;
                        continue;
                    default:
                        continue;
                }
                i4--;
            }
            return 0;
        }

        int e() {
            this.f3259e = this.f3258d;
            int i2 = 0;
            int i3 = 0;
            while (this.f3259e > 0) {
                byte bA = a();
                if (bA == 0) {
                    if (i2 == 0) {
                        return -1;
                    }
                    if (i3 == 0) {
                        i3 = i2;
                    }
                } else if (bA == 1 || bA == 2) {
                    if (i2 == 0) {
                        return 1;
                    }
                    if (i3 == 0) {
                        i3 = i2;
                    }
                } else if (bA != 9) {
                    switch (bA) {
                        case 14:
                        case 15:
                            if (i3 == i2) {
                                return -1;
                            }
                            i2--;
                            break;
                        case 16:
                        case 17:
                            if (i3 == i2) {
                                return 1;
                            }
                            i2--;
                            break;
                        case 18:
                            i2++;
                            break;
                        default:
                            if (i3 == 0) {
                                i3 = i2;
                            }
                            break;
                    }
                } else {
                    continue;
                }
            }
            return 0;
        }
    }

    static {
        d dVar = e.f3274c;
        a = dVar;
        f3247b = Character.toString((char) 8206);
        f3248c = Character.toString((char) 8207);
        f3249d = new a(false, 2, dVar);
        f3250e = new a(true, 2, dVar);
    }

    a(boolean z, int i2, d dVar) {
        this.f3251f = z;
        this.f3252g = i2;
        this.f3253h = dVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0074a().a();
    }

    static boolean e(Locale locale) {
        return f.b(locale) == 1;
    }

    private String f(CharSequence charSequence, d dVar) {
        boolean zA = dVar.a(charSequence, 0, charSequence.length());
        if (!this.f3251f && (zA || b(charSequence) == 1)) {
            return f3247b;
        }
        if (this.f3251f) {
            return (!zA || b(charSequence) == -1) ? f3248c : HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    private String g(CharSequence charSequence, d dVar) {
        boolean zA = dVar.a(charSequence, 0, charSequence.length());
        if (!this.f3251f && (zA || a(charSequence) == 1)) {
            return f3247b;
        }
        if (this.f3251f) {
            return (!zA || a(charSequence) == -1) ? f3248c : HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public boolean d() {
        return (this.f3252g & 2) != 0;
    }

    public CharSequence h(CharSequence charSequence) {
        return i(charSequence, this.f3253h, true);
    }

    public CharSequence i(CharSequence charSequence, d dVar, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zA = dVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z) {
            spannableStringBuilder.append((CharSequence) g(charSequence, zA ? e.f3273b : e.a));
        }
        if (zA != this.f3251f) {
            spannableStringBuilder.append(zA ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) f(charSequence, zA ? e.f3273b : e.a));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.f3253h, true);
    }

    public String k(String str, d dVar, boolean z) {
        if (str == null) {
            return null;
        }
        return i(str, dVar, z).toString();
    }
}
