package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzaru extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaru> CREATOR = new zzarw();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private ParcelFileDescriptor f14101f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Parcelable f14102g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14103h = true;

    @SafeParcelable.Constructor
    public zzaru(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.f14101f = parcelFileDescriptor;
    }

    private final ParcelFileDescriptor W() {
        if (this.f14101f == null) {
            Parcel parcelObtain = Parcel.obtain();
            try {
                this.f14102g.writeToParcel(parcelObtain, 0);
                byte[] bArrMarshall = parcelObtain.marshall();
                parcelObtain.recycle();
                this.f14101f = z(bArrMarshall);
            } catch (Throwable th) {
                parcelObtain.recycle();
                throw th;
            }
        }
        return this.f14101f;
    }

    private final <T> ParcelFileDescriptor z(byte[] bArr) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        try {
            ParcelFileDescriptor[] parcelFileDescriptorArrCreatePipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptorArrCreatePipe[1]);
            try {
                new Thread(new r3(this, autoCloseOutputStream, bArr)).start();
                return parcelFileDescriptorArrCreatePipe[0];
            } catch (IOException e2) {
                e = e2;
                zzbad.c("Error transporting the ad response", e);
                zzk.zzlk().e(e, "LargeParcelTeleporter.pipeData.2");
                IOUtils.a(autoCloseOutputStream);
                return null;
            }
        } catch (IOException e3) {
            e = e3;
            autoCloseOutputStream = null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        W();
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 2, this.f14101f, i2, false);
        SafeParcelWriter.b(parcel, iA);
    }

    public final <T extends SafeParcelable> T y(Parcelable.Creator<T> creator) {
        if (this.f14103h) {
            if (this.f14101f == null) {
                zzbad.g("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.f14101f));
            try {
                try {
                    int i2 = dataInputStream.readInt();
                    byte[] bArr = new byte[i2];
                    dataInputStream.readFully(bArr, 0, i2);
                    IOUtils.a(dataInputStream);
                    Parcel parcelObtain = Parcel.obtain();
                    try {
                        parcelObtain.unmarshall(bArr, 0, i2);
                        parcelObtain.setDataPosition(0);
                        this.f14102g = creator.createFromParcel(parcelObtain);
                        parcelObtain.recycle();
                        this.f14103h = false;
                    } catch (Throwable th) {
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (IOException e2) {
                    zzbad.c("Could not read from parcel file descriptor", e2);
                    IOUtils.a(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                IOUtils.a(dataInputStream);
                throw th2;
            }
        }
        return (T) this.f14102g;
    }
}
