package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
@SafeParcelable.Reserved
public class SafeBrowsingData extends AbstractSafeParcelable {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private String f18254g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private DataHolder f18255h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private ParcelFileDescriptor f18256i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private long f18257j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private byte[] f18258k;
    private byte[] l;
    private File m;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f18253f = SafeBrowsingData.class.getSimpleName();
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new zzj();

    public SafeBrowsingData() {
        this(null, null, null, 0L, null);
    }

    @SafeParcelable.Constructor
    public SafeBrowsingData(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) DataHolder dataHolder, @SafeParcelable.Param(id = 4) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 5) long j2, @SafeParcelable.Param(id = 6) byte[] bArr) {
        this.f18254g = str;
        this.f18255h = dataHolder;
        this.f18256i = parcelFileDescriptor;
        this.f18257j = j2;
        this.f18258k = bArr;
    }

    private final FileOutputStream i0() throws Throwable {
        Throwable th;
        File fileCreateTempFile;
        File file = this.m;
        if (file == null) {
            return null;
        }
        try {
            fileCreateTempFile = File.createTempFile("xlb", ".tmp", file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(fileCreateTempFile);
                this.f18256i = ParcelFileDescriptor.open(fileCreateTempFile, 268435456);
                if (fileCreateTempFile != null) {
                    fileCreateTempFile.delete();
                }
                return fileOutputStream;
            } catch (IOException unused) {
                if (fileCreateTempFile != null) {
                    fileCreateTempFile.delete();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (fileCreateTempFile != null) {
                    fileCreateTempFile.delete();
                }
                throw th;
            }
        } catch (IOException unused2) {
            fileCreateTempFile = null;
        } catch (Throwable th3) {
            th = th3;
            fileCreateTempFile = null;
        }
    }

    private static void p0(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public long W() {
        return this.f18257j;
    }

    public String Y() {
        return this.f18254g;
    }

    public byte[] e0() {
        return this.f18258k;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        boolean z;
        FileOutputStream fileOutputStreamI0;
        if (this.f18256i != null || this.l == null || (fileOutputStreamI0 = i0()) == null) {
            z = false;
        } else {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(fileOutputStreamI0));
            try {
                dataOutputStream.writeInt(this.l.length);
                dataOutputStream.write(this.l);
                p0(dataOutputStream);
                z = true;
            } catch (IOException unused) {
                p0(dataOutputStream);
                z = false;
            } catch (Throwable th) {
                p0(dataOutputStream);
                throw th;
            }
        }
        if (z) {
            i2 |= 1;
        }
        zzj.a(this, parcel, i2);
        this.f18256i = null;
    }

    public DataHolder y() {
        return this.f18255h;
    }

    public ParcelFileDescriptor z() {
        return this.f18256i;
    }
}
