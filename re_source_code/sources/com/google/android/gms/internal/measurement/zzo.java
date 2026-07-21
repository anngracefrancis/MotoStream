package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzo extends zza implements zzm {
    zzo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void beginAdUnitExposure(String str, long j2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeLong(j2);
        k0(23, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void clearConditionalUserProperty(String str, String str2, Bundle bundle) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzb.c(parcelH, bundle);
        k0(9, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void endAdUnitExposure(String str, long j2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeLong(j2);
        k0(24, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void generateEventId(zzn zznVar) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, zznVar);
        k0(22, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getCachedAppInstanceId(zzn zznVar) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, zznVar);
        k0(19, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getConditionalUserProperties(String str, String str2, zzn zznVar) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzb.b(parcelH, zznVar);
        k0(10, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getCurrentScreenClass(zzn zznVar) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, zznVar);
        k0(17, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getCurrentScreenName(zzn zznVar) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, zznVar);
        k0(16, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getGmpAppId(zzn zznVar) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, zznVar);
        k0(21, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getMaxUserProperties(String str, zzn zznVar) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        zzb.b(parcelH, zznVar);
        k0(6, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void getUserProperties(String str, String str2, boolean z, zzn zznVar) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzb.d(parcelH, z);
        zzb.b(parcelH, zznVar);
        k0(5, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void initialize(IObjectWrapper iObjectWrapper, zzv zzvVar, long j2) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, iObjectWrapper);
        zzb.c(parcelH, zzvVar);
        parcelH.writeLong(j2);
        k0(1, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void logEvent(String str, String str2, Bundle bundle, boolean z, boolean z2, long j2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzb.c(parcelH, bundle);
        zzb.d(parcelH, z);
        zzb.d(parcelH, z2);
        parcelH.writeLong(j2);
        k0(2, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void logHealthData(int i2, String str, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeInt(i2);
        parcelH.writeString(str);
        zzb.b(parcelH, iObjectWrapper);
        zzb.b(parcelH, iObjectWrapper2);
        zzb.b(parcelH, iObjectWrapper3);
        k0(33, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityCreated(IObjectWrapper iObjectWrapper, Bundle bundle, long j2) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, iObjectWrapper);
        zzb.c(parcelH, bundle);
        parcelH.writeLong(j2);
        k0(27, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityDestroyed(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, iObjectWrapper);
        parcelH.writeLong(j2);
        k0(28, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityPaused(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, iObjectWrapper);
        parcelH.writeLong(j2);
        k0(29, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityResumed(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, iObjectWrapper);
        parcelH.writeLong(j2);
        k0(30, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivitySaveInstanceState(IObjectWrapper iObjectWrapper, zzn zznVar, long j2) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, iObjectWrapper);
        zzb.b(parcelH, zznVar);
        parcelH.writeLong(j2);
        k0(31, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityStarted(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, iObjectWrapper);
        parcelH.writeLong(j2);
        k0(25, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void onActivityStopped(IObjectWrapper iObjectWrapper, long j2) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, iObjectWrapper);
        parcelH.writeLong(j2);
        k0(26, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void performAction(Bundle bundle, zzn zznVar, long j2) throws RemoteException {
        Parcel parcelH = H();
        zzb.c(parcelH, bundle);
        zzb.b(parcelH, zznVar);
        parcelH.writeLong(j2);
        k0(32, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void registerOnMeasurementEventListener(zzs zzsVar) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, zzsVar);
        k0(35, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setConditionalUserProperty(Bundle bundle, long j2) throws RemoteException {
        Parcel parcelH = H();
        zzb.c(parcelH, bundle);
        parcelH.writeLong(j2);
        k0(8, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setCurrentScreen(IObjectWrapper iObjectWrapper, String str, String str2, long j2) throws RemoteException {
        Parcel parcelH = H();
        zzb.b(parcelH, iObjectWrapper);
        parcelH.writeString(str);
        parcelH.writeString(str2);
        parcelH.writeLong(j2);
        k0(15, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setDataCollectionEnabled(boolean z) throws RemoteException {
        Parcel parcelH = H();
        zzb.d(parcelH, z);
        k0(39, parcelH);
    }

    @Override // com.google.android.gms.internal.measurement.zzm
    public final void setUserProperty(String str, String str2, IObjectWrapper iObjectWrapper, boolean z, long j2) throws RemoteException {
        Parcel parcelH = H();
        parcelH.writeString(str);
        parcelH.writeString(str2);
        zzb.b(parcelH, iObjectWrapper);
        zzb.d(parcelH, z);
        parcelH.writeLong(j2);
        k0(4, parcelH);
    }
}
