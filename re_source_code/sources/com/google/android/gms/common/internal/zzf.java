package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzf extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f12062g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ BaseGmsClient f12063h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzf(BaseGmsClient baseGmsClient, int i2, IBinder iBinder, Bundle bundle) {
        super(baseGmsClient, i2, bundle);
        this.f12063h = baseGmsClient;
        this.f12062g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.i
    protected final void f(ConnectionResult connectionResult) {
        if (this.f12063h.zzx != null) {
            this.f12063h.zzx.E0(connectionResult);
        }
        this.f12063h.onConnectionFailed(connectionResult);
    }

    @Override // com.google.android.gms.common.internal.i
    protected final boolean g() {
        try {
            IBinder iBinder = this.f12062g;
            Preconditions.k(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f12063h.getServiceDescriptor().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.f12063h.getServiceDescriptor() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceCreateServiceInterface = this.f12063h.createServiceInterface(this.f12062g);
            if (iInterfaceCreateServiceInterface == null || !(BaseGmsClient.zzn(this.f12063h, 2, 4, iInterfaceCreateServiceInterface) || BaseGmsClient.zzn(this.f12063h, 3, 4, iInterfaceCreateServiceInterface))) {
                return false;
            }
            this.f12063h.zzB = null;
            Bundle connectionHint = this.f12063h.getConnectionHint();
            BaseGmsClient baseGmsClient = this.f12063h;
            if (baseGmsClient.zzw == null) {
                return true;
            }
            baseGmsClient.zzw.P(connectionHint);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
