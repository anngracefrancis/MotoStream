package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes2.dex */
public class zzax extends zzr<String> {
    private final Object u;
    private zzaa<String> v;

    public zzax(int i2, String str, zzaa<String> zzaaVar, zzz zzzVar) {
        super(i2, str, zzzVar);
        this.u = new Object();
        this.v = zzaaVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzr
    /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
    public void F(String str) {
        zzaa<String> zzaaVar;
        synchronized (this.u) {
            zzaaVar = this.v;
        }
        if (zzaaVar != null) {
            zzaaVar.b(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzr
    protected final zzy<String> y(zzp zzpVar) {
        String str;
        try {
            byte[] bArr = zzpVar.f16552b;
            String str2 = "ISO-8859-1";
            String str3 = zzpVar.f16553c.get("Content-Type");
            if (str3 != null) {
                String[] strArrSplit = str3.split(";", 0);
                for (int i2 = 1; i2 < strArrSplit.length; i2++) {
                    String[] strArrSplit2 = strArrSplit[i2].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str2 = strArrSplit2[1];
                        break;
                    }
                }
            }
            str = new String(bArr, str2);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzpVar.f16552b);
        }
        return zzy.a(str, zzaq.a(zzpVar));
    }
}
