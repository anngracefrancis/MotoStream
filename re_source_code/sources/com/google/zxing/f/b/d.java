package com.google.zxing.f.b;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: HighLevelEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {
    static final String[] a = {"UPPER", "LOWER", "DIGIT", "MIXED", "PUNCT"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final int[][] f20327b = {new int[]{0, 327708, 327710, 327709, 656318}, new int[]{590318, 0, 327710, 327709, 656318}, new int[]{262158, 590300, 0, 590301, 932798}, new int[]{327709, 327708, 656318, 0, 327710}, new int[]{327711, 656380, 656382, 656381, 0}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[][] f20328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final int[][] f20329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final byte[] f20330e;

    /* JADX INFO: compiled from: HighLevelEncoder.java */
    class a implements Comparator<f> {
        a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(f fVar, f fVar2) {
            return fVar.d() - fVar2.d();
        }
    }

    static {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, 5, 256);
        f20328c = iArr;
        iArr[0][32] = 1;
        for (int i2 = 65; i2 <= 90; i2++) {
            f20328c[0][i2] = (i2 - 65) + 2;
        }
        f20328c[1][32] = 1;
        for (int i3 = 97; i3 <= 122; i3++) {
            f20328c[1][i3] = (i3 - 97) + 2;
        }
        f20328c[2][32] = 1;
        for (int i4 = 48; i4 <= 57; i4++) {
            f20328c[2][i4] = (i4 - 48) + 2;
        }
        int[][] iArr2 = f20328c;
        iArr2[2][44] = 12;
        iArr2[2][46] = 13;
        int[] iArr3 = {0, 32, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 27, 28, 29, 30, 31, 64, 92, 94, 95, 96, 124, WebSocketProtocol.PAYLOAD_SHORT, 127};
        for (int i5 = 0; i5 < 28; i5++) {
            f20328c[3][iArr3[i5]] = i5;
        }
        int[] iArr4 = {0, 13, 0, 0, 0, 0, 33, 39, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 58, 59, 60, 61, 62, 63, 91, 93, 123, 125};
        for (int i6 = 0; i6 < 31; i6++) {
            if (iArr4[i6] > 0) {
                f20328c[4][iArr4[i6]] = i6;
            }
        }
        int[][] iArr5 = (int[][]) Array.newInstance((Class<?>) int.class, 6, 6);
        f20329d = iArr5;
        for (int[] iArr6 : iArr5) {
            Arrays.fill(iArr6, -1);
        }
        int[][] iArr7 = f20329d;
        iArr7[0][4] = 0;
        iArr7[1][4] = 0;
        iArr7[1][0] = 28;
        iArr7[3][4] = 0;
        iArr7[2][4] = 0;
        iArr7[2][0] = 15;
    }

    public d(byte[] bArr) {
        this.f20330e = bArr;
    }

    private static Collection<f> b(Iterable<f> iterable) {
        LinkedList linkedList = new LinkedList();
        for (f fVar : iterable) {
            boolean z = true;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                f fVar2 = (f) it.next();
                if (fVar2.f(fVar)) {
                    z = false;
                    break;
                }
                if (fVar.f(fVar2)) {
                    it.remove();
                }
            }
            if (z) {
                linkedList.add(fVar);
            }
        }
        return linkedList;
    }

    private void c(f fVar, int i2, Collection<f> collection) {
        char c2 = (char) (this.f20330e[i2] & 255);
        boolean z = f20328c[fVar.e()][c2] > 0;
        f fVarB = null;
        for (int i3 = 0; i3 <= 4; i3++) {
            int i4 = f20328c[i3][c2];
            if (i4 > 0) {
                if (fVarB == null) {
                    fVarB = fVar.b(i2);
                }
                if (!z || i3 == fVar.e() || i3 == 2) {
                    collection.add(fVarB.g(i3, i4));
                }
                if (!z && f20329d[fVar.e()][i3] >= 0) {
                    collection.add(fVarB.h(i3, i4));
                }
            }
        }
        if (fVar.c() > 0 || f20328c[fVar.e()][c2] == 0) {
            collection.add(fVar.a(i2));
        }
    }

    private static void d(f fVar, int i2, int i3, Collection<f> collection) {
        f fVarB = fVar.b(i2);
        collection.add(fVarB.g(4, i3));
        if (fVar.e() != 4) {
            collection.add(fVarB.h(4, i3));
        }
        if (i3 == 3 || i3 == 4) {
            collection.add(fVarB.g(2, 16 - i3).g(2, 1));
        }
        if (fVar.c() > 0) {
            collection.add(fVar.a(i2).a(i2 + 1));
        }
    }

    private Collection<f> e(Iterable<f> iterable, int i2) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            c(it.next(), i2, linkedList);
        }
        return b(linkedList);
    }

    private static Collection<f> f(Iterable<f> iterable, int i2, int i3) {
        LinkedList linkedList = new LinkedList();
        Iterator<f> it = iterable.iterator();
        while (it.hasNext()) {
            d(it.next(), i2, i3, linkedList);
        }
        return b(linkedList);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002a  */
    public com.google.zxing.g.a a() {
        int i2;
        Collection<f> collectionSingletonList = Collections.singletonList(f.a);
        int i3 = 0;
        while (true) {
            byte[] bArr = this.f20330e;
            if (i3 >= bArr.length) {
                return ((f) Collections.min(collectionSingletonList, new a())).i(this.f20330e);
            }
            int i4 = i3 + 1;
            byte b2 = i4 < bArr.length ? bArr[i4] : (byte) 0;
            byte b3 = bArr[i3];
            if (b3 != 13) {
                if (b3 != 44) {
                    if (b3 != 46) {
                        if (b3 == 58 && b2 == 32) {
                            i2 = 5;
                        } else {
                            i2 = 0;
                        }
                    } else if (b2 == 32) {
                        i2 = 3;
                    } else {
                        i2 = 0;
                    }
                } else if (b2 == 32) {
                    i2 = 4;
                } else {
                    i2 = 0;
                }
            } else if (b2 == 10) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            if (i2 > 0) {
                collectionSingletonList = f(collectionSingletonList, i3, i2);
                i3 = i4;
            } else {
                collectionSingletonList = e(collectionSingletonList, i3);
            }
            i3++;
        }
    }
}
