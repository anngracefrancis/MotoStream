package j.g0;

import j.f;
import j.i;
import kotlin.jvm.internal.m;
import kotlin.u;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:138:0x012f  */
    /* JADX WARN: Code duplicated, block: B:141:0x0135  */
    /* JADX WARN: Code duplicated, block: B:143:0x0139  */
    /* JADX WARN: Code duplicated, block: B:144:0x013b  */
    /* JADX WARN: Code duplicated, block: B:209:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:212:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:214:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:215:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:228:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:235:0x00b5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:243:0x0134 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:254:0x01ca A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x0066 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:44:0x0069 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x006b  */
    /* JADX WARN: Code duplicated, block: B:46:0x006d  */
    /* JADX WARN: Code duplicated, block: B:81:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:83:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:85:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:86:0x00bc  */
    public static final int c(byte[] bArr, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int length = bArr.length;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < length) {
            byte b2 = bArr[i8];
            if (b2 >= 0) {
                int i11 = i10 + 1;
                if (i10 == i2) {
                    return i9;
                }
                if (b2 != 10 && b2 != 13) {
                    if (!((b2 >= 0 && 31 >= b2) || (127 <= b2 && 159 >= b2))) {
                    }
                    return -1;
                }
                if (b2 == 65533) {
                    return -1;
                }
                i9 += b2 < 65536 ? 1 : 2;
                i8++;
                while (true) {
                    i10 = i11;
                    if (i8 >= length || bArr[i8] < 0) {
                        break;
                    }
                    int i12 = i8 + 1;
                    byte b3 = bArr[i8];
                    i11 = i10 + 1;
                    if (i10 == i2) {
                        return i9;
                    }
                    if (b3 != 10 && b3 != 13) {
                        if (!((b3 >= 0 && 31 >= b3) || (127 <= b3 && 159 >= b3))) {
                            if (b3 == 65533) {
                                if (b3 < 65536) {
                                    i3 = 1;
                                } else {
                                    i3 = 2;
                                }
                                i9 += i3;
                                i8 = i12;
                            }
                        }
                    } else if (b3 == 65533) {
                        if (b3 < 65536) {
                            i3 = 1;
                        } else {
                            i3 = 2;
                        }
                        i9 += i3;
                        i8 = i12;
                    }
                    return -1;
                }
            }
            if ((b2 >> 5) == -2) {
                int i13 = i8 + 1;
                if (length <= i13) {
                    if (i10 == i2) {
                        return i9;
                    }
                    return -1;
                }
                byte b4 = bArr[i8];
                byte b5 = bArr[i13];
                if (!((b5 & 192) == 128)) {
                    if (i10 == i2) {
                        return i9;
                    }
                    return -1;
                }
                int i14 = (b5 ^ 3968) ^ (b4 << 6);
                if (i14 < 128) {
                    if (i10 == i2) {
                        return i9;
                    }
                    return -1;
                }
                i4 = i10 + 1;
                if (i10 == i2) {
                    return i9;
                }
                if (i14 != 10 && i14 != 13) {
                    if (!((i14 >= 0 && 31 >= i14) || (127 <= i14 && 159 >= i14))) {
                        if (i14 == 65533) {
                            if (i14 < 65536) {
                                i7 = 1;
                            } else {
                                i7 = 2;
                            }
                            i9 += i7;
                            u uVar = u.a;
                            i8 += 2;
                        }
                    }
                } else if (i14 == 65533) {
                    if (i14 < 65536) {
                        i7 = 1;
                    } else {
                        i7 = 2;
                    }
                    i9 += i7;
                    u uVar2 = u.a;
                    i8 += 2;
                }
                return -1;
            }
            if ((b2 >> 4) == -2) {
                int i15 = i8 + 2;
                if (length <= i15) {
                    if (i10 == i2) {
                        return i9;
                    }
                    return -1;
                }
                byte b6 = bArr[i8];
                byte b7 = bArr[i8 + 1];
                if (!((b7 & 192) == 128)) {
                    if (i10 == i2) {
                        return i9;
                    }
                    return -1;
                }
                byte b8 = bArr[i15];
                if (!((b8 & 192) == 128)) {
                    if (i10 == i2) {
                        return i9;
                    }
                    return -1;
                }
                int i16 = ((b8 ^ (-123008)) ^ (b7 << 6)) ^ (b6 << 12);
                if (i16 < 2048) {
                    if (i10 == i2) {
                        return i9;
                    }
                    return -1;
                }
                if (55296 <= i16 && 57343 >= i16) {
                    if (i10 == i2) {
                        return i9;
                    }
                    return -1;
                }
                i4 = i10 + 1;
                if (i10 == i2) {
                    return i9;
                }
                if (i16 != 10 && i16 != 13) {
                    if (!((i16 >= 0 && 31 >= i16) || (127 <= i16 && 159 >= i16))) {
                        if (i16 == 65533) {
                            if (i16 < 65536) {
                                i6 = 1;
                            } else {
                                i6 = 2;
                            }
                            i9 += i6;
                            u uVar3 = u.a;
                            i8 += 3;
                        }
                    }
                } else if (i16 == 65533) {
                    if (i16 < 65536) {
                        i6 = 1;
                    } else {
                        i6 = 2;
                    }
                    i9 += i6;
                    u uVar4 = u.a;
                    i8 += 3;
                }
                return -1;
            }
            if ((b2 >> 3) != -2) {
                if (i10 == i2) {
                    return i9;
                }
                return -1;
            }
            int i17 = i8 + 3;
            if (length <= i17) {
                if (i10 == i2) {
                    return i9;
                }
                return -1;
            }
            byte b9 = bArr[i8];
            byte b10 = bArr[i8 + 1];
            if (!((b10 & 192) == 128)) {
                if (i10 == i2) {
                    return i9;
                }
                return -1;
            }
            byte b11 = bArr[i8 + 2];
            if (!((b11 & 192) == 128)) {
                if (i10 == i2) {
                    return i9;
                }
                return -1;
            }
            byte b12 = bArr[i17];
            if (!((b12 & 192) == 128)) {
                if (i10 == i2) {
                    return i9;
                }
                return -1;
            }
            int i18 = (((b12 ^ 3678080) ^ (b11 << 6)) ^ (b10 << 12)) ^ (b9 << 18);
            if (i18 > 1114111) {
                if (i10 == i2) {
                    return i9;
                }
                return -1;
            }
            if (55296 <= i18 && 57343 >= i18) {
                if (i10 == i2) {
                    return i9;
                }
                return -1;
            }
            if (i18 < 65536) {
                if (i10 == i2) {
                    return i9;
                }
                return -1;
            }
            i4 = i10 + 1;
            if (i10 == i2) {
                return i9;
            }
            if (i18 != 10 && i18 != 13) {
                if (!((i18 >= 0 && 31 >= i18) || (127 <= i18 && 159 >= i18))) {
                    if (i18 == 65533) {
                        if (i18 < 65536) {
                            i5 = 1;
                        } else {
                            i5 = 2;
                        }
                        i9 += i5;
                        u uVar5 = u.a;
                        i8 += 4;
                    }
                }
            } else if (i18 == 65533) {
                if (i18 < 65536) {
                    i5 = 1;
                } else {
                    i5 = 2;
                }
                i9 += i5;
                u uVar6 = u.a;
                i8 += 4;
            }
            return -1;
            i10 = i4;
        }
        return i9;
    }

    public static final void d(i iVar, f fVar, int i2, int i3) {
        m.f(iVar, "$this$commonWrite");
        m.f(fVar, "buffer");
        fVar.write(iVar.y(), i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int e(char c2) {
        if ('0' <= c2 && '9' >= c2) {
            return c2 - '0';
        }
        char c3 = 'a';
        if ('a' > c2 || 'f' < c2) {
            c3 = 'A';
            if ('A' > c2 || 'F' < c2) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c2);
            }
        }
        return (c2 - c3) + 10;
    }

    public static final char[] f() {
        return a;
    }
}
