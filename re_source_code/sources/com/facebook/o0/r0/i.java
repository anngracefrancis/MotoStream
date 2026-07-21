package com.facebook.o0.r0;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: Operator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    public static final i a = new i();

    private i() {
    }

    public static final void a(f fVar, f fVar2) {
        m.f(fVar, "x");
        m.f(fVar2, "b");
        int iB = fVar.b(0);
        int iB2 = fVar.b(1);
        int iB3 = fVar.b(2);
        float[] fArrA = fVar.a();
        float[] fArrA2 = fVar2.a();
        if (iB <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (iB2 > 0) {
                int i4 = 0;
                while (true) {
                    int i5 = i4 + 1;
                    if (iB3 > 0) {
                        int i6 = 0;
                        while (true) {
                            int i7 = i6 + 1;
                            int i8 = (i2 * iB2 * iB3) + (i4 * iB3) + i6;
                            fArrA[i8] = fArrA[i8] + fArrA2[i6];
                            if (i7 >= iB3) {
                                break;
                            } else {
                                i6 = i7;
                            }
                        }
                    }
                    if (i5 >= iB2) {
                        break;
                    } else {
                        i4 = i5;
                    }
                }
            }
            if (i3 >= iB) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    public static final f b(f[] fVarArr) {
        int iB;
        m.f(fVarArr, "tensors");
        int iB2 = fVarArr[0].b(0);
        int length = fVarArr.length - 1;
        if (length >= 0) {
            int i2 = 0;
            iB = 0;
            while (true) {
                int i3 = i2 + 1;
                iB += fVarArr[i2].b(1);
                if (i3 > length) {
                    break;
                }
                i2 = i3;
            }
        } else {
            iB = 0;
        }
        f fVar = new f(new int[]{iB2, iB});
        float[] fArrA = fVar.a();
        if (iB2 > 0) {
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                int i6 = i4 * iB;
                int length2 = fVarArr.length - 1;
                if (length2 >= 0) {
                    int i7 = 0;
                    while (true) {
                        int i8 = i7 + 1;
                        float[] fArrA2 = fVarArr[i7].a();
                        int iB3 = fVarArr[i7].b(1);
                        System.arraycopy(fArrA2, i4 * iB3, fArrA, i6, iB3);
                        i6 += iB3;
                        if (i8 > length2) {
                            break;
                        }
                        i7 = i8;
                    }
                }
                if (i5 >= iB2) {
                    break;
                }
                i4 = i5;
            }
        }
        return fVar;
    }

    public static final f c(f fVar, f fVar2) {
        f fVar3;
        int i2;
        int i3;
        m.f(fVar, "x");
        m.f(fVar2, "w");
        int iB = fVar.b(0);
        int iB2 = fVar.b(1);
        int iB3 = fVar.b(2);
        int iB4 = fVar2.b(0);
        int i4 = (iB2 - iB4) + 1;
        int iB5 = fVar2.b(2);
        f fVar4 = new f(new int[]{iB, i4, iB5});
        float[] fArrA = fVar.a();
        float[] fArrA2 = fVar4.a();
        float[] fArrA3 = fVar2.a();
        if (iB <= 0) {
            return fVar4;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5 + 1;
            if (iB5 > 0) {
                int i7 = 0;
                while (true) {
                    int i8 = i7 + 1;
                    if (i4 > 0) {
                        int i9 = 0;
                        while (true) {
                            int i10 = i9 + 1;
                            float f2 = 0.0f;
                            if (iB4 > 0) {
                                int i11 = 0;
                                while (true) {
                                    fVar3 = fVar4;
                                    int i12 = i11 + 1;
                                    if (iB3 > 0) {
                                        int i13 = 0;
                                        while (true) {
                                            i3 = iB;
                                            int i14 = i13 + 1;
                                            f2 += fArrA[(iB2 * iB3 * i5) + ((i11 + i9) * iB3) + i13] * fArrA3[(((i11 * iB3) + i13) * iB5) + i7];
                                            if (i14 >= iB3) {
                                                break;
                                            }
                                            i13 = i14;
                                            iB = i3;
                                        }
                                    } else {
                                        i3 = iB;
                                    }
                                    if (i12 >= iB4) {
                                        break;
                                    }
                                    i11 = i12;
                                    fVar4 = fVar3;
                                    iB = i3;
                                }
                            } else {
                                i3 = iB;
                                fVar3 = fVar4;
                            }
                            fArrA2[(i4 * iB5 * i5) + (i9 * iB5) + i7] = f2;
                            if (i10 >= i4) {
                                break;
                            }
                            i9 = i10;
                            fVar4 = fVar3;
                            iB = i3;
                        }
                    } else {
                        i3 = iB;
                        fVar3 = fVar4;
                    }
                    if (i8 >= iB5) {
                        break;
                    }
                    i7 = i8;
                    fVar4 = fVar3;
                    iB = i3;
                }
                i2 = i3;
            } else {
                fVar3 = fVar4;
                i2 = iB;
            }
            if (i6 >= i2) {
                return fVar3;
            }
            iB = i2;
            i5 = i6;
            fVar4 = fVar3;
        }
    }

    public static final f d(f fVar, f fVar2, f fVar3) {
        m.f(fVar, "x");
        m.f(fVar2, "w");
        m.f(fVar3, "b");
        int iB = fVar.b(0);
        int iB2 = fVar3.b(0);
        f fVarH = h(fVar, fVar2);
        float[] fArrA = fVar3.a();
        float[] fArrA2 = fVarH.a();
        if (iB > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (iB2 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        int i6 = (i2 * iB2) + i4;
                        fArrA2[i6] = fArrA2[i6] + fArrA[i4];
                        if (i5 >= iB2) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                if (i3 >= iB) {
                    break;
                }
                i2 = i3;
            }
        }
        return fVarH;
    }

    public static final f e(String[] strArr, int i2, f fVar) {
        m.f(strArr, "texts");
        m.f(fVar, "w");
        int length = strArr.length;
        int iB = fVar.b(1);
        f fVar2 = new f(new int[]{length, i2, iB});
        float[] fArrA = fVar2.a();
        float[] fArrA2 = fVar.a();
        if (length > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                int[] iArrD = j.a.d(strArr[i3], i2);
                if (i2 > 0) {
                    int i5 = 0;
                    while (true) {
                        int i6 = i5 + 1;
                        System.arraycopy(fArrA2, iArrD[i5] * iB, fArrA, (iB * i2 * i3) + (i5 * iB), iB);
                        if (i6 >= i2) {
                            break;
                        }
                        i5 = i6;
                    }
                }
                if (i4 >= length) {
                    break;
                }
                i3 = i4;
            }
        }
        return fVar2;
    }

    public static final void f(f fVar, int i2) {
        m.f(fVar, "x");
        if (i2 >= fVar.c()) {
            return;
        }
        int iC = fVar.c();
        int iB = 1;
        if (i2 < iC) {
            int i3 = i2;
            while (true) {
                int i4 = i3 + 1;
                iB *= fVar.b(i3);
                if (i4 >= iC) {
                    break;
                } else {
                    i3 = i4;
                }
            }
        }
        int[] iArr = new int[i2 + 1];
        int i5 = 0;
        if (i2 > 0) {
            while (true) {
                int i6 = i5 + 1;
                iArr[i5] = fVar.b(i5);
                if (i6 >= i2) {
                    break;
                } else {
                    i5 = i6;
                }
            }
        }
        iArr[i2] = iB;
        fVar.d(iArr);
    }

    public static final f g(f fVar, int i2) {
        int i3;
        m.f(fVar, "x");
        int iB = fVar.b(0);
        int iB2 = fVar.b(1);
        int iB3 = fVar.b(2);
        int i4 = (iB2 - i2) + 1;
        f fVar2 = new f(new int[]{iB, i4, iB3});
        float[] fArrA = fVar.a();
        float[] fArrA2 = fVar2.a();
        if (iB > 0) {
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                if (iB3 > 0) {
                    int i7 = 0;
                    while (true) {
                        int i8 = i7 + 1;
                        if (i4 > 0) {
                            int i9 = 0;
                            while (true) {
                                int i10 = i9 + 1;
                                int i11 = i9 * iB3;
                                int i12 = (i5 * i4 * iB3) + i11 + i7;
                                int i13 = (i5 * iB2 * iB3) + i11 + i7;
                                fArrA2[i12] = Float.MIN_VALUE;
                                if (i2 > 0) {
                                    int i14 = 0;
                                    while (true) {
                                        int i15 = i14 + 1;
                                        i3 = iB2;
                                        fArrA2[i12] = Math.max(fArrA2[i12], fArrA[i13 + (i14 * iB3)]);
                                        if (i15 >= i2) {
                                            break;
                                        }
                                        i14 = i15;
                                        iB2 = i3;
                                    }
                                } else {
                                    i3 = iB2;
                                }
                                if (i10 >= i4) {
                                    break;
                                }
                                i9 = i10;
                                iB2 = i3;
                            }
                        } else {
                            i3 = iB2;
                        }
                        if (i8 >= iB3) {
                            break;
                        }
                        i7 = i8;
                        iB2 = i3;
                    }
                } else {
                    i3 = iB2;
                }
                if (i6 >= iB) {
                    break;
                }
                i5 = i6;
                iB2 = i3;
            }
        }
        return fVar2;
    }

    public static final f h(f fVar, f fVar2) {
        m.f(fVar, "x");
        m.f(fVar2, "w");
        int iB = fVar.b(0);
        int iB2 = fVar2.b(0);
        int iB3 = fVar2.b(1);
        f fVar3 = new f(new int[]{iB, iB3});
        float[] fArrA = fVar.a();
        float[] fArrA2 = fVar2.a();
        float[] fArrA3 = fVar3.a();
        if (iB > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (iB3 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        int i6 = (i2 * iB3) + i4;
                        fArrA3[i6] = 0.0f;
                        if (iB2 > 0) {
                            int i7 = 0;
                            while (true) {
                                int i8 = i7 + 1;
                                fArrA3[i6] = fArrA3[i6] + (fArrA[(i2 * iB2) + i7] * fArrA2[(i7 * iB3) + i4]);
                                if (i8 >= iB2) {
                                    break;
                                }
                                i7 = i8;
                            }
                        }
                        if (i5 >= iB3) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                if (i3 >= iB) {
                    break;
                }
                i2 = i3;
            }
        }
        return fVar3;
    }

    public static final void i(f fVar) {
        m.f(fVar, "x");
        float[] fArrA = fVar.a();
        int length = fArrA.length - 1;
        if (length < 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (fArrA[i2] < 0.0f) {
                fArrA[i2] = 0.0f;
            }
            if (i3 > length) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    public static final void j(f fVar) {
        m.f(fVar, "x");
        int i2 = 0;
        int iB = fVar.b(0);
        int iB2 = fVar.b(1);
        float[] fArrA = fVar.a();
        if (iB <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            int i4 = i2 * iB2;
            int i5 = i4 + iB2;
            float f2 = Float.MIN_VALUE;
            float f3 = 0.0f;
            if (i4 < i5) {
                int i6 = i4;
                while (true) {
                    int i7 = i6 + 1;
                    if (fArrA[i6] > f2) {
                        f2 = fArrA[i6];
                    }
                    if (i7 >= i5) {
                        break;
                    } else {
                        i6 = i7;
                    }
                }
            }
            if (i4 < i5) {
                int i8 = i4;
                while (true) {
                    int i9 = i8 + 1;
                    fArrA[i8] = (float) Math.exp(fArrA[i8] - f2);
                    f3 += fArrA[i8];
                    if (i9 >= i5) {
                        break;
                    } else {
                        i8 = i9;
                    }
                }
            }
            if (i4 < i5) {
                while (true) {
                    int i10 = i4 + 1;
                    fArrA[i4] = fArrA[i4] / f3;
                    if (i10 >= i5) {
                        break;
                    } else {
                        i4 = i10;
                    }
                }
            }
            if (i3 >= iB) {
                return;
            } else {
                i2 = i3;
            }
        }
    }

    public static final f k(f fVar) {
        m.f(fVar, "x");
        int iB = fVar.b(0);
        int iB2 = fVar.b(1);
        f fVar2 = new f(new int[]{iB2, iB});
        float[] fArrA = fVar.a();
        float[] fArrA2 = fVar2.a();
        if (iB > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (iB2 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        fArrA2[(i4 * iB) + i2] = fArrA[(i2 * iB2) + i4];
                        if (i5 >= iB2) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                if (i3 >= iB) {
                    break;
                }
                i2 = i3;
            }
        }
        return fVar2;
    }

    public static final f l(f fVar) {
        m.f(fVar, "x");
        int iB = fVar.b(0);
        int iB2 = fVar.b(1);
        int iB3 = fVar.b(2);
        f fVar2 = new f(new int[]{iB3, iB2, iB});
        float[] fArrA = fVar.a();
        float[] fArrA2 = fVar2.a();
        if (iB > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (iB2 > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        if (iB3 > 0) {
                            int i6 = 0;
                            while (true) {
                                int i7 = i6 + 1;
                                fArrA2[(i6 * iB * iB2) + (i4 * iB) + i2] = fArrA[(i2 * iB2 * iB3) + (i4 * iB3) + i6];
                                if (i7 >= iB3) {
                                    break;
                                }
                                i6 = i7;
                            }
                        }
                        if (i5 >= iB2) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                if (i3 >= iB) {
                    break;
                }
                i2 = i3;
            }
        }
        return fVar2;
    }
}
