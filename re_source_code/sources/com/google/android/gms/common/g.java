package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class g extends zzy {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f11923f;

    protected g(byte[] bArr) {
        Preconditions.a(bArr.length == 25);
        this.f11923f = Arrays.hashCode(bArr);
    }

    protected static byte[] k0(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    abstract byte[] E0();

    @Override // com.google.android.gms.common.internal.zzz
    public final int c() {
        return this.f11923f;
    }

    @Override // com.google.android.gms.common.internal.zzz
    public final IObjectWrapper d() {
        return ObjectWrapper.E0(E0());
    }

    public final boolean equals(Object obj) {
        IObjectWrapper iObjectWrapperD;
        if (obj != null && (obj instanceof zzz)) {
            try {
                zzz zzzVar = (zzz) obj;
                if (zzzVar.c() == this.f11923f && (iObjectWrapperD = zzzVar.d()) != null) {
                    return Arrays.equals(E0(), (byte[]) ObjectWrapper.k0(iObjectWrapperD));
                }
                return false;
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f11923f;
    }
}
