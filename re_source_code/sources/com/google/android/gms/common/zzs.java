package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new zzt();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f12185f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final g f12186g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f12187h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final boolean f12188i;

    @SafeParcelable.Constructor
    zzs(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) boolean z, @SafeParcelable.Param(id = 4) boolean z2) {
        this.f12185f = str;
        h hVar = null;
        if (iBinder != null) {
            try {
                IObjectWrapper iObjectWrapperD = zzy.P(iBinder).d();
                byte[] bArr = iObjectWrapperD == null ? null : (byte[]) ObjectWrapper.k0(iObjectWrapperD);
                if (bArr != null) {
                    hVar = new h(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e2) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e2);
            }
        }
        this.f12186g = hVar;
        this.f12187h = z;
        this.f12188i = z2;
    }

    zzs(String str, g gVar, boolean z, boolean z2) {
        this.f12185f = str;
        this.f12186g = gVar;
        this.f12187h = z;
        this.f12188i = z2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, this.f12185f, false);
        g gVar = this.f12186g;
        if (gVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            gVar = null;
        }
        SafeParcelWriter.k(parcel, 2, gVar, false);
        SafeParcelWriter.c(parcel, 3, this.f12187h);
        SafeParcelWriter.c(parcel, 4, this.f12188i);
        SafeParcelWriter.b(parcel, iA);
    }
}
