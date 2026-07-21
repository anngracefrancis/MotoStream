package com.google.zxing.i;

/* JADX INFO: compiled from: CodaBarWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends n {
    private static final char[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f20380b = {'T', 'N', '*', 'E'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f20381c = {'/', ':', '+', '.'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char f20382d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        a = cArr;
        f20382d = cArr[0];
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String str) {
        int i2;
        if (str.length() < 2) {
            StringBuilder sb = new StringBuilder();
            char c2 = f20382d;
            sb.append(c2);
            sb.append(str);
            sb.append(c2);
            str = sb.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = a;
            boolean zA = a.a(cArr, upperCase);
            boolean zA2 = a.a(cArr, upperCase2);
            char[] cArr2 = f20380b;
            boolean zA3 = a.a(cArr2, upperCase);
            boolean zA4 = a.a(cArr2, upperCase2);
            if (zA) {
                if (!zA2) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
            } else if (!zA3) {
                if (zA2 || zA4) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
                }
                StringBuilder sb2 = new StringBuilder();
                char c3 = f20382d;
                sb2.append(c3);
                sb2.append(str);
                sb2.append(c3);
                str = sb2.toString();
            } else if (!zA4) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(str));
            }
        }
        int i3 = 20;
        for (int i4 = 1; i4 < str.length() - 1; i4++) {
            if (Character.isDigit(str.charAt(i4)) || str.charAt(i4) == '-' || str.charAt(i4) == '$') {
                i3 += 9;
            } else {
                if (!a.a(f20381c, str.charAt(i4))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i4) + '\'');
                }
                i3 += 10;
            }
        }
        boolean[] zArr = new boolean[i3 + (str.length() - 1)];
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i6));
            if (i6 == 0 || i6 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i7 = 0;
            while (true) {
                char[] cArr3 = a.a;
                if (i7 >= cArr3.length) {
                    i2 = 0;
                    break;
                }
                if (upperCase3 == cArr3[i7]) {
                    i2 = a.f20378b[i7];
                    break;
                }
                i7++;
            }
            int i8 = 0;
            boolean z = true;
            while (true) {
                int i9 = 0;
                while (i8 < 7) {
                    zArr[i5] = z;
                    i5++;
                    if (((i2 >> (6 - i8)) & 1) == 0 || i9 == 1) {
                        z = !z;
                        i8++;
                    } else {
                        i9++;
                    }
                }
                break;
            }
            if (i6 < str.length() - 1) {
                zArr[i5] = false;
                i5++;
            }
        }
        return zArr;
    }
}
