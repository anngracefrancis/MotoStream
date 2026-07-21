package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzaow extends zzfn implements zzaov {
    public zzaow() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    public static zzaov h7(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
        return iInterfaceQueryLocalInterface instanceof zzaov ? (zzaov) iInterfaceQueryLocalInterface : new zzaox(iBinder);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.google.android.gms.internal.ads.zzaov, com.google.android.gms.internal.ads.zzaow] */
    /* JADX WARN: Type inference failed for: r7v10, types: [com.google.android.gms.internal.ads.zzaop] */
    /* JADX WARN: Type inference failed for: r7v3, types: [com.google.android.gms.internal.ads.zzaoj] */
    /* JADX WARN: Type inference failed for: r7v6, types: [com.google.android.gms.internal.ads.zzaom] */
    /* JADX WARN: Type inference failed for: r7v8, types: [com.google.android.gms.internal.ads.zzaos] */
    @Override // com.google.android.gms.internal.ads.zzfn
    protected final boolean dispatchTransaction(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
        zzaoy zzapaVar;
        IInterface zzaolVar = null;
        if (i2 == 1) {
            IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcel.readStrongBinder());
            String string = parcel.readString();
            Parcelable.Creator creator = Bundle.CREATOR;
            Bundle bundle = (Bundle) zzfo.b(parcel, creator);
            Bundle bundle2 = (Bundle) zzfo.b(parcel, creator);
            zzyd zzydVar = (zzyd) zzfo.b(parcel, zzyd.CREATOR);
            IBinder strongBinder = parcel.readStrongBinder();
            if (strongBinder == null) {
                zzapaVar = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.ISignalsCallback");
                zzapaVar = iInterfaceQueryLocalInterface instanceof zzaoy ? (zzaoy) iInterfaceQueryLocalInterface : new zzapa(strongBinder);
            }
            u3(iObjectWrapperP, string, bundle, bundle2, zzydVar, zzapaVar);
            parcel2.writeNoException();
        } else if (i2 == 2) {
            zzapj zzapjVarA6 = a6();
            parcel2.writeNoException();
            zzfo.g(parcel2, zzapjVarA6);
        } else if (i2 == 3) {
            zzapj zzapjVarI5 = i5();
            parcel2.writeNoException();
            zzfo.g(parcel2, zzapjVarI5);
        } else if (i2 == 5) {
            zzaar videoController = getVideoController();
            parcel2.writeNoException();
            zzfo.c(parcel2, videoController);
        } else if (i2 == 10) {
            o3(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
            parcel2.writeNoException();
        } else if (i2 != 11) {
            switch (i2) {
                case 13:
                    String string2 = parcel.readString();
                    String string3 = parcel.readString();
                    zzxz zzxzVar = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                    IObjectWrapper iObjectWrapperP2 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                    IBinder strongBinder2 = parcel.readStrongBinder();
                    if (strongBinder2 != null) {
                        IInterface iInterfaceQueryLocalInterface2 = strongBinder2.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IBannerCallback");
                        zzaolVar = iInterfaceQueryLocalInterface2 instanceof zzaoj ? (zzaoj) iInterfaceQueryLocalInterface2 : new zzaol(strongBinder2);
                    }
                    K4(string2, string3, zzxzVar, iObjectWrapperP2, zzaolVar, zzamw.h7(parcel.readStrongBinder()), (zzyd) zzfo.b(parcel, zzyd.CREATOR));
                    parcel2.writeNoException();
                    break;
                case 14:
                    String string4 = parcel.readString();
                    String string5 = parcel.readString();
                    zzxz zzxzVar2 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                    IObjectWrapper iObjectWrapperP3 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                    IBinder strongBinder3 = parcel.readStrongBinder();
                    if (strongBinder3 != null) {
                        IInterface iInterfaceQueryLocalInterface3 = strongBinder3.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
                        zzaolVar = iInterfaceQueryLocalInterface3 instanceof zzaom ? (zzaom) iInterfaceQueryLocalInterface3 : new zzaoo(strongBinder3);
                    }
                    y6(string4, string5, zzxzVar2, iObjectWrapperP3, zzaolVar, zzamw.h7(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 15:
                    boolean zX2 = x2(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzfo.a(parcel2, zX2);
                    break;
                case 16:
                    String string6 = parcel.readString();
                    String string7 = parcel.readString();
                    zzxz zzxzVar3 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                    IObjectWrapper iObjectWrapperP4 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                    IBinder strongBinder4 = parcel.readStrongBinder();
                    if (strongBinder4 != null) {
                        IInterface iInterfaceQueryLocalInterface4 = strongBinder4.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
                        zzaolVar = iInterfaceQueryLocalInterface4 instanceof zzaos ? (zzaos) iInterfaceQueryLocalInterface4 : new zzaou(strongBinder4);
                    }
                    h5(string6, string7, zzxzVar3, iObjectWrapperP4, zzaolVar, zzamw.h7(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                case 17:
                    boolean zL2 = L2(IObjectWrapper.Stub.P(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzfo.a(parcel2, zL2);
                    break;
                case 18:
                    String string8 = parcel.readString();
                    String string9 = parcel.readString();
                    zzxz zzxzVar4 = (zzxz) zzfo.b(parcel, zzxz.CREATOR);
                    IObjectWrapper iObjectWrapperP5 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                    IBinder strongBinder5 = parcel.readStrongBinder();
                    if (strongBinder5 != null) {
                        IInterface iInterfaceQueryLocalInterface5 = strongBinder5.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
                        zzaolVar = iInterfaceQueryLocalInterface5 instanceof zzaop ? (zzaop) iInterfaceQueryLocalInterface5 : new zzaor(strongBinder5);
                    }
                    g4(string8, string9, zzxzVar4, iObjectWrapperP5, zzaolVar, zzamw.h7(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    break;
                default:
                    return false;
            }
        } else {
            j5(parcel.createStringArray(), (Bundle[]) parcel.createTypedArray(Bundle.CREATOR));
            parcel2.writeNoException();
        }
        return true;
    }
}
