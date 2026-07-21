package com.google.android.gms.cloudmessaging;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zza implements Parcelable {
    public static final Parcelable.Creator<zza> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Messenger f11608f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private IMessengerCompat f11609g;

    /* JADX INFO: renamed from: com.google.android.gms.cloudmessaging.zza$zza, reason: collision with other inner class name */
    /* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    public static final class C0173zza extends ClassLoader {
        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if (!"com.google.android.gms.iid.MessengerCompat".equals(str)) {
                return super.loadClass(str, z);
            }
            if (!(Log.isLoggable("CloudMessengerCompat", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("CloudMessengerCompat", 3)))) {
                return zza.class;
            }
            Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
            return zza.class;
        }
    }

    public zza(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f11608f = new Messenger(iBinder);
        } else {
            this.f11609g = new IMessengerCompat.Proxy(iBinder);
        }
    }

    private final IBinder a() {
        Messenger messenger = this.f11608f;
        return messenger != null ? messenger.getBinder() : this.f11609g.asBinder();
    }

    public final void b(Message message) throws RemoteException {
        Messenger messenger = this.f11608f;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f11609g.E1(message);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zza) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Messenger messenger = this.f11608f;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f11609g.asBinder());
        }
    }
}
