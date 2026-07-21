package com.google.zxing.i;

import com.google.zxing.WriterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: Code128Writer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d extends n {

    /* JADX INFO: compiled from: Code128Writer.java */
    private enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    private static int f(CharSequence charSequence, int i2, int i3) {
        a aVarG;
        a aVarG2;
        char cCharAt;
        a aVarG3 = g(charSequence, i2);
        a aVar = a.ONE_DIGIT;
        if (aVarG3 == aVar) {
            return 100;
        }
        a aVar2 = a.UNCODABLE;
        if (aVarG3 == aVar2) {
            return (i2 >= charSequence.length() || ((cCharAt = charSequence.charAt(i2)) >= ' ' && (i3 != 101 || cCharAt >= '`'))) ? 100 : 101;
        }
        if (i3 == 99) {
            return 99;
        }
        if (i3 != 100) {
            if (aVarG3 == a.FNC_1) {
                aVarG3 = g(charSequence, i2 + 1);
            }
            return aVarG3 == a.TWO_DIGITS ? 99 : 100;
        }
        a aVar3 = a.FNC_1;
        if (aVarG3 == aVar3 || (aVarG = g(charSequence, i2 + 2)) == aVar2 || aVarG == aVar) {
            return 100;
        }
        if (aVarG == aVar3) {
            return g(charSequence, i2 + 3) == a.TWO_DIGITS ? 99 : 100;
        }
        int i4 = i2 + 4;
        while (true) {
            aVarG2 = g(charSequence, i4);
            if (aVarG2 != a.TWO_DIGITS) {
                break;
            }
            i4 += 2;
        }
        return aVarG2 == a.ONE_DIGIT ? 100 : 99;
    }

    private static a g(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        if (i2 >= length) {
            return a.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i2);
        if (cCharAt == 241) {
            return a.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return a.UNCODABLE;
        }
        int i3 = i2 + 1;
        if (i3 >= length) {
            return a.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i3);
        return (cCharAt2 < '0' || cCharAt2 > '9') ? a.ONE_DIGIT : a.TWO_DIGITS;
    }

    @Override // com.google.zxing.i.n, com.google.zxing.e
    public com.google.zxing.g.b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<com.google.zxing.c, ?> map) throws WriterException {
        if (aVar == com.google.zxing.a.CODE_128) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(aVar)));
    }

    @Override // com.google.zxing.i.n
    public boolean[] c(String str) {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int iB = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            switch (cCharAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (cCharAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(cCharAt)));
                    }
                    break;
                    break;
            }
        }
        ArrayList<int[]> arrayList = new ArrayList();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 1;
        while (true) {
            int i7 = 103;
            if (i3 >= length) {
                int[][] iArr = c.a;
                arrayList.add(iArr[i4 % 103]);
                arrayList.add(iArr[106]);
                int i8 = 0;
                for (int[] iArr2 : arrayList) {
                    for (int i9 : iArr2) {
                        i8 += i9;
                    }
                }
                boolean[] zArr = new boolean[i8];
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    iB += n.b(zArr, iB, (int[]) it.next(), true);
                }
                return zArr;
            }
            int iF = f(str, i3, i5);
            int iCharAt = 100;
            if (iF == i5) {
                switch (str.charAt(i3)) {
                    case 241:
                        iCharAt = 102;
                        break;
                    case 242:
                        iCharAt = 97;
                        break;
                    case 243:
                        iCharAt = 96;
                        break;
                    case 244:
                        if (i5 == 101) {
                            iCharAt = 101;
                        }
                        break;
                    default:
                        if (i5 == 100) {
                            iCharAt = str.charAt(i3) - ' ';
                        } else if (i5 != 101) {
                            iCharAt = Integer.parseInt(str.substring(i3, i3 + 2));
                            i3++;
                        } else {
                            iCharAt = str.charAt(i3) - ' ';
                            if (iCharAt < 0) {
                                iCharAt += 96;
                            }
                        }
                        break;
                }
                i3++;
            } else {
                if (i5 != 0) {
                    i7 = iF;
                } else if (iF == 100) {
                    i7 = 104;
                } else if (iF != 101) {
                    i7 = 105;
                }
                iCharAt = i7;
                i5 = iF;
            }
            arrayList.add(c.a[iCharAt]);
            i4 += iCharAt * i6;
            if (i3 != 0) {
                i6++;
            }
        }
    }
}
