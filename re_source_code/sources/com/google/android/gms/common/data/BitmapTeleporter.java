package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
@KeepForSdk
@SafeParcelable.Class
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {

    @KeepForSdk
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new zaa();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11897f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private ParcelFileDescriptor f11898g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11899h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Bitmap f11900i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f11901j = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private File f11902k;

    @SafeParcelable.Constructor
    BitmapTeleporter(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 3) int i3) {
        this.f11897f = i2;
        this.f11898g = parcelFileDescriptor;
        this.f11899h = i3;
    }

    private static void y(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w("BitmapTeleporter", "Could not close stream", e2);
        }
    }

    private final FileOutputStream z() {
        File file = this.f11902k;
        if (file == null) {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
        try {
            File fileCreateTempFile = File.createTempFile("teleporter", ".tmp", file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                this.f11898g = ParcelFileDescriptor.open(fileCreateTempFile, 268435456);
                fileCreateTempFile.delete();
                return fileOutputStream;
            } catch (FileNotFoundException unused) {
                throw new IllegalStateException("Temporary file is somehow already deleted");
            }
        } catch (IOException e2) {
            throw new IllegalStateException("Could not create temporary file", e2);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (this.f11898g == null) {
            Bitmap bitmap = this.f11900i;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(byteBufferAllocate);
            byte[] bArrArray = byteBufferAllocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(z()));
            try {
                try {
                    dataOutputStream.writeInt(bArrArray.length);
                    dataOutputStream.writeInt(bitmap.getWidth());
                    dataOutputStream.writeInt(bitmap.getHeight());
                    dataOutputStream.writeUTF(bitmap.getConfig().toString());
                    dataOutputStream.write(bArrArray);
                    y(dataOutputStream);
                } catch (IOException e2) {
                    throw new IllegalStateException("Could not write into unlinked file", e2);
                }
            } catch (Throwable th) {
                y(dataOutputStream);
                throw th;
            }
        }
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11897f);
        SafeParcelWriter.s(parcel, 2, this.f11898g, i2 | 1, false);
        SafeParcelWriter.l(parcel, 3, this.f11899h);
        SafeParcelWriter.b(parcel, iA);
        this.f11898g = null;
    }
}
