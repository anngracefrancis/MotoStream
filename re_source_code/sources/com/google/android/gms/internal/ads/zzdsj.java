package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
public final class zzdsj extends zzdrr<zzdsj> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f16110c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private zzdrz.zza.zzc f16111d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f16112e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f16113f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f16114g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public zzdsk f16115h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public zzdsp[] f16116i = zzdsp.f();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f16117j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public zzdso f16118k = null;
    private Boolean l = null;
    private String[] m;
    private String n;
    private Boolean o;
    private Boolean p;
    private byte[] q;
    public zzdsq r;
    public String[] s;
    public String[] t;

    public zzdsj() {
        String[] strArr = zzdry.f16084f;
        this.m = strArr;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = strArr;
        this.t = strArr;
        this.f16072b = null;
        this.a = -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    public final void a(zzdrp zzdrpVar) throws IOException {
        String str = this.f16112e;
        if (str != null) {
            zzdrpVar.k(1, str);
        }
        String str2 = this.f16113f;
        if (str2 != null) {
            zzdrpVar.k(2, str2);
        }
        zzdsp[] zzdspVarArr = this.f16116i;
        int i2 = 0;
        if (zzdspVarArr != null && zzdspVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzdsp[] zzdspVarArr2 = this.f16116i;
                if (i3 >= zzdspVarArr2.length) {
                    break;
                }
                zzdsp zzdspVar = zzdspVarArr2[i3];
                if (zzdspVar != null) {
                    zzdrpVar.b(4, zzdspVar);
                }
                i3++;
            }
        }
        String[] strArr = this.m;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            while (true) {
                String[] strArr2 = this.m;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i4];
                if (str3 != null) {
                    zzdrpVar.k(6, str3);
                }
                i4++;
            }
        }
        Integer num = this.f16110c;
        if (num != null) {
            zzdrpVar.x(10, num.intValue());
        }
        zzdsk zzdskVar = this.f16115h;
        if (zzdskVar != null) {
            zzdrpVar.b(12, zzdskVar);
        }
        String str4 = this.f16117j;
        if (str4 != null) {
            zzdrpVar.k(13, str4);
        }
        zzdso zzdsoVar = this.f16118k;
        if (zzdsoVar != null) {
            zzdrpVar.b(14, zzdsoVar);
        }
        zzdsq zzdsqVar = this.r;
        if (zzdsqVar != null) {
            zzdrpVar.b(17, zzdsqVar);
        }
        String[] strArr3 = this.s;
        if (strArr3 != null && strArr3.length > 0) {
            int i5 = 0;
            while (true) {
                String[] strArr4 = this.s;
                if (i5 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i5];
                if (str5 != null) {
                    zzdrpVar.k(20, str5);
                }
                i5++;
            }
        }
        String[] strArr5 = this.t;
        if (strArr5 != null && strArr5.length > 0) {
            while (true) {
                String[] strArr6 = this.t;
                if (i2 >= strArr6.length) {
                    break;
                }
                String str6 = strArr6[i2];
                if (str6 != null) {
                    zzdrpVar.k(21, str6);
                }
                i2++;
            }
        }
        super.a(zzdrpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdrr, com.google.android.gms.internal.ads.zzdrw
    protected final int e() {
        int iE = super.e();
        String str = this.f16112e;
        if (str != null) {
            iE += zzdrp.n(1, str);
        }
        String str2 = this.f16113f;
        if (str2 != null) {
            iE += zzdrp.n(2, str2);
        }
        zzdsp[] zzdspVarArr = this.f16116i;
        int i2 = 0;
        if (zzdspVarArr != null && zzdspVarArr.length > 0) {
            int i3 = 0;
            while (true) {
                zzdsp[] zzdspVarArr2 = this.f16116i;
                if (i3 >= zzdspVarArr2.length) {
                    break;
                }
                zzdsp zzdspVar = zzdspVarArr2[i3];
                if (zzdspVar != null) {
                    iE += zzdrp.g(4, zzdspVar);
                }
                i3++;
            }
        }
        String[] strArr = this.m;
        if (strArr != null && strArr.length > 0) {
            int i4 = 0;
            int iR = 0;
            int i5 = 0;
            while (true) {
                String[] strArr2 = this.m;
                if (i4 >= strArr2.length) {
                    break;
                }
                String str3 = strArr2[i4];
                if (str3 != null) {
                    i5++;
                    iR += zzdrp.r(str3);
                }
                i4++;
            }
            iE = iE + iR + (i5 * 1);
        }
        Integer num = this.f16110c;
        if (num != null) {
            iE += zzdrp.d(10, num.intValue());
        }
        zzdsk zzdskVar = this.f16115h;
        if (zzdskVar != null) {
            iE += zzdrp.g(12, zzdskVar);
        }
        String str4 = this.f16117j;
        if (str4 != null) {
            iE += zzdrp.n(13, str4);
        }
        zzdso zzdsoVar = this.f16118k;
        if (zzdsoVar != null) {
            iE += zzdrp.g(14, zzdsoVar);
        }
        zzdsq zzdsqVar = this.r;
        if (zzdsqVar != null) {
            iE += zzdrp.g(17, zzdsqVar);
        }
        String[] strArr3 = this.s;
        if (strArr3 != null && strArr3.length > 0) {
            int i6 = 0;
            int iR2 = 0;
            int i7 = 0;
            while (true) {
                String[] strArr4 = this.s;
                if (i6 >= strArr4.length) {
                    break;
                }
                String str5 = strArr4[i6];
                if (str5 != null) {
                    i7++;
                    iR2 += zzdrp.r(str5);
                }
                i6++;
            }
            iE = iE + iR2 + (i7 * 2);
        }
        String[] strArr5 = this.t;
        if (strArr5 == null || strArr5.length <= 0) {
            return iE;
        }
        int iR3 = 0;
        int i8 = 0;
        while (true) {
            String[] strArr6 = this.t;
            if (i2 >= strArr6.length) {
                return iE + iR3 + (i8 * 2);
            }
            String str6 = strArr6[i2];
            if (str6 != null) {
                i8++;
                iR3 += zzdrp.r(str6);
            }
            i2++;
        }
    }
}
