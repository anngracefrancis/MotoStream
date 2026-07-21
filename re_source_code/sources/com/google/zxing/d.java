package com.google.zxing;

import com.google.zxing.i.f;
import com.google.zxing.i.h;
import com.google.zxing.i.j;
import com.google.zxing.i.k;
import com.google.zxing.i.l;
import com.google.zxing.i.o;
import com.google.zxing.i.s;
import java.util.Map;

/* JADX INFO: compiled from: MultiFormatWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements e {

    /* JADX INFO: compiled from: MultiFormatWriter.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.google.zxing.a.values().length];
            a = iArr;
            try {
                iArr[com.google.zxing.a.EAN_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.google.zxing.a.UPC_E.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.google.zxing.a.EAN_13.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.google.zxing.a.UPC_A.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.google.zxing.a.QR_CODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.google.zxing.a.CODE_39.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.google.zxing.a.CODE_93.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.google.zxing.a.CODE_128.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.google.zxing.a.ITF.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[com.google.zxing.a.PDF_417.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[com.google.zxing.a.CODABAR.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[com.google.zxing.a.DATA_MATRIX.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[com.google.zxing.a.AZTEC.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    @Override // com.google.zxing.e
    public com.google.zxing.g.b a(String str, com.google.zxing.a aVar, int i2, int i3, Map<c, ?> map) throws WriterException {
        e kVar;
        switch (a.a[aVar.ordinal()]) {
            case 1:
                kVar = new k();
                break;
            case 2:
                kVar = new s();
                break;
            case 3:
                kVar = new j();
                break;
            case 4:
                kVar = new o();
                break;
            case 5:
                kVar = new com.google.zxing.k.a();
                break;
            case 6:
                kVar = new f();
                break;
            case 7:
                kVar = new h();
                break;
            case 8:
                kVar = new com.google.zxing.i.d();
                break;
            case 9:
                kVar = new l();
                break;
            case 10:
                kVar = new com.google.zxing.j.a();
                break;
            case 11:
                kVar = new com.google.zxing.i.b();
                break;
            case 12:
                kVar = new com.google.zxing.h.a();
                break;
            case 13:
                kVar = new com.google.zxing.f.a();
                break;
            default:
                throw new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(aVar)));
        }
        return kVar.a(str, aVar, i2, i3, map);
    }
}
