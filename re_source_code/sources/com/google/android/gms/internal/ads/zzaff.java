package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaff extends zzfn implements zzafe {
    public zzaff() {
        super("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    public static zzafe h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
        return iInterfaceQueryLocalInterface instanceof zzafe ? (zzafe) iInterfaceQueryLocalInterface : new zzafg(iBinder);
    }

    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        switch (i2) {
            case 1:
                String strY0 = Y0(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(strY0);
                return true;
            case 2:
                zzaei zzaeiVarN1 = N1(parcel.readString());
                parcel2.writeNoException();
                zzfo.c(parcel2, zzaeiVarN1);
                return true;
            case 3:
                List<String> availableAssetNames = getAvailableAssetNames();
                parcel2.writeNoException();
                parcel2.writeStringList(availableAssetNames);
                return true;
            case 4:
                String customTemplateId = getCustomTemplateId();
                parcel2.writeNoException();
                parcel2.writeString(customTemplateId);
                return true;
            case 5:
                performClick(parcel.readString());
                parcel2.writeNoException();
                return true;
            case 6:
                recordImpression();
                parcel2.writeNoException();
                return true;
            case 7:
                zzaar videoController = getVideoController();
                parcel2.writeNoException();
                zzfo.c(parcel2, videoController);
                return true;
            case 8:
                destroy();
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper iObjectWrapperU4 = U4();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperU4);
                return true;
            case 10:
                boolean zF3 = F3(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                parcel2.writeNoException();
                zzfo.a(parcel2, zF3);
                return true;
            case 11:
                IObjectWrapper iObjectWrapperR = r();
                parcel2.writeNoException();
                zzfo.c(parcel2, iObjectWrapperR);
                return true;
            default:
                return false;
        }
    }
}
