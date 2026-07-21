package com.google.android.gms.internal.ads;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
final class d30 {
    private final zznn[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zznp f12446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zznn f12447c;

    public d30(zznn[] zznnVarArr, zznp zznpVar) {
        this.a = zznnVarArr;
        this.f12446b = zznpVar;
    }

    public final void a() {
        zznn zznnVar = this.f12447c;
        if (zznnVar != null) {
            zznnVar.c();
            this.f12447c = null;
        }
    }

    public final zznn b(zzno zznoVar, Uri uri) throws InterruptedException, IOException {
        zznn zznnVar = this.f12447c;
        if (zznnVar != null) {
            return zznnVar;
        }
        for (zznn zznnVar2 : this.a) {
            try {
                if (zznnVar2.g(zznoVar)) {
                    this.f12447c = zznnVar2;
                    zznoVar.c();
                    break;
                }
                zznoVar.c();
            } catch (EOFException unused) {
                zznoVar.c();
            } catch (Throwable th) {
                zznoVar.c();
                throw th;
            }
        }
        zznn zznnVar3 = this.f12447c;
        if (zznnVar3 != null) {
            zznnVar3.e(this.f12446b);
            return this.f12447c;
        }
        String strD = zzsy.d(this.a);
        StringBuilder sb = new StringBuilder(String.valueOf(strD).length() + 58);
        sb.append("None of the available extractors (");
        sb.append(strD);
        sb.append(") could read the stream.");
        throw new zzrc(sb.toString(), uri);
    }
}
