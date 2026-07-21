package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.common.zzc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface IFragmentWrapper extends IInterface {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    public static abstract class Stub extends com.google.android.gms.internal.common.zzb implements IFragmentWrapper {
        public Stub() {
            super("com.google.android.gms.dynamic.IFragmentWrapper");
        }

        @Override // com.google.android.gms.internal.common.zzb
        protected final boolean H(int i2, Parcel parcel, Parcel parcel2, int i3) throws RemoteException {
            switch (i2) {
                case 2:
                    IObjectWrapper iObjectWrapperS = s();
                    parcel2.writeNoException();
                    zzc.f(parcel2, iObjectWrapperS);
                    return true;
                case 3:
                    Bundle bundleD = d();
                    parcel2.writeNoException();
                    zzc.e(parcel2, bundleD);
                    return true;
                case 4:
                    int iB = b();
                    parcel2.writeNoException();
                    parcel2.writeInt(iB);
                    return true;
                case 5:
                    IFragmentWrapper iFragmentWrapperE = e();
                    parcel2.writeNoException();
                    zzc.f(parcel2, iFragmentWrapperE);
                    return true;
                case 6:
                    IObjectWrapper iObjectWrapperM = m();
                    parcel2.writeNoException();
                    zzc.f(parcel2, iObjectWrapperM);
                    return true;
                case 7:
                    boolean zX = x();
                    parcel2.writeNoException();
                    zzc.c(parcel2, zX);
                    return true;
                case 8:
                    String strV = v();
                    parcel2.writeNoException();
                    parcel2.writeString(strV);
                    return true;
                case 9:
                    IFragmentWrapper iFragmentWrapperQ = q();
                    parcel2.writeNoException();
                    zzc.f(parcel2, iFragmentWrapperQ);
                    return true;
                case 10:
                    int iC = c();
                    parcel2.writeNoException();
                    parcel2.writeInt(iC);
                    return true;
                case 11:
                    boolean zY = y();
                    parcel2.writeNoException();
                    zzc.c(parcel2, zY);
                    return true;
                case 12:
                    IObjectWrapper iObjectWrapperL = l();
                    parcel2.writeNoException();
                    zzc.f(parcel2, iObjectWrapperL);
                    return true;
                case 13:
                    boolean zG = G();
                    parcel2.writeNoException();
                    zzc.c(parcel2, zG);
                    return true;
                case 14:
                    boolean zA0 = A0();
                    parcel2.writeNoException();
                    zzc.c(parcel2, zA0);
                    return true;
                case 15:
                    boolean zF0 = f0();
                    parcel2.writeNoException();
                    zzc.c(parcel2, zF0);
                    return true;
                case 16:
                    boolean zL0 = l0();
                    parcel2.writeNoException();
                    zzc.c(parcel2, zL0);
                    return true;
                case 17:
                    boolean zU = U();
                    parcel2.writeNoException();
                    zzc.c(parcel2, zU);
                    return true;
                case 18:
                    boolean zX2 = X();
                    parcel2.writeNoException();
                    zzc.c(parcel2, zX2);
                    return true;
                case 19:
                    boolean zZ6 = Z6();
                    parcel2.writeNoException();
                    zzc.c(parcel2, zZ6);
                    return true;
                case 20:
                    IObjectWrapper iObjectWrapperP = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                    zzc.b(parcel);
                    s0(iObjectWrapperP);
                    parcel2.writeNoException();
                    return true;
                case 21:
                    boolean zG2 = zzc.g(parcel);
                    zzc.b(parcel);
                    P0(zG2);
                    parcel2.writeNoException();
                    return true;
                case 22:
                    boolean zG3 = zzc.g(parcel);
                    zzc.b(parcel);
                    r1(zG3);
                    parcel2.writeNoException();
                    return true;
                case 23:
                    boolean zG4 = zzc.g(parcel);
                    zzc.b(parcel);
                    b2(zG4);
                    parcel2.writeNoException();
                    return true;
                case 24:
                    boolean zG5 = zzc.g(parcel);
                    zzc.b(parcel);
                    h6(zG5);
                    parcel2.writeNoException();
                    return true;
                case 25:
                    Intent intent = (Intent) zzc.a(parcel, Intent.CREATOR);
                    zzc.b(parcel);
                    w2(intent);
                    parcel2.writeNoException();
                    return true;
                case 26:
                    Intent intent2 = (Intent) zzc.a(parcel, Intent.CREATOR);
                    int i4 = parcel.readInt();
                    zzc.b(parcel);
                    D2(intent2, i4);
                    parcel2.writeNoException();
                    return true;
                case 27:
                    IObjectWrapper iObjectWrapperP2 = IObjectWrapper.Stub.P(parcel.readStrongBinder());
                    zzc.b(parcel);
                    w0(iObjectWrapperP2);
                    parcel2.writeNoException();
                    return true;
                default:
                    return false;
            }
        }
    }

    boolean A0() throws RemoteException;

    void D2(Intent intent, int i2) throws RemoteException;

    boolean G() throws RemoteException;

    void P0(boolean z) throws RemoteException;

    boolean U() throws RemoteException;

    boolean X() throws RemoteException;

    boolean Z6() throws RemoteException;

    int b() throws RemoteException;

    void b2(boolean z) throws RemoteException;

    int c() throws RemoteException;

    Bundle d() throws RemoteException;

    IFragmentWrapper e() throws RemoteException;

    boolean f0() throws RemoteException;

    void h6(boolean z) throws RemoteException;

    IObjectWrapper l() throws RemoteException;

    boolean l0() throws RemoteException;

    IObjectWrapper m() throws RemoteException;

    IFragmentWrapper q() throws RemoteException;

    void r1(boolean z) throws RemoteException;

    IObjectWrapper s() throws RemoteException;

    void s0(IObjectWrapper iObjectWrapper) throws RemoteException;

    String v() throws RemoteException;

    void w0(IObjectWrapper iObjectWrapper) throws RemoteException;

    void w2(Intent intent) throws RemoteException;

    boolean x() throws RemoteException;

    boolean y() throws RemoteException;
}
