package com.google.android.gms.common.data;

import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@KeepName
@SafeParcelable.Class
public final class DataHolder extends AbstractSafeParcelable implements Closeable {

    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zac();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Builder f11909f = new a(new String[0], null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11910g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final String[] f11911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Bundle f11912i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final CursorWindow[] f11913j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final int f11914k;

    @SafeParcelable.Field
    private final Bundle l;
    private int[] m;
    private int n;
    private boolean o = false;
    private boolean p = true;

    public static class zaa extends RuntimeException {
    }

    @SafeParcelable.Constructor
    DataHolder(@SafeParcelable.Param(id = 1000) int i2, @SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.Param(id = 3) int i3, @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.f11910g = i2;
        this.f11911h = strArr;
        this.f11913j = cursorWindowArr;
        this.f11914k = i3;
        this.l = bundle;
    }

    private final void i0(String str, int i2) {
        Bundle bundle = this.f11912i;
        if (bundle == null || !bundle.containsKey(str)) {
            String strValueOf = String.valueOf(str);
            throw new IllegalArgumentException(strValueOf.length() != 0 ? "No such column: ".concat(strValueOf) : new String("No such column: "));
        }
        if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        }
        if (i2 < 0 || i2 >= this.n) {
            throw new CursorIndexOutOfBoundsException(i2, this.n);
        }
    }

    @KeepForSdk
    public final int W() {
        return this.f11914k;
    }

    @KeepForSdk
    public final String Y(String str, int i2, int i3) {
        i0(str, i2);
        return this.f11913j[i3].getString(i2, this.f11912i.getInt(str));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @KeepForSdk
    public final void close() {
        synchronized (this) {
            if (!this.o) {
                this.o = true;
                int i2 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.f11913j;
                    if (i2 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i2].close();
                    i2++;
                }
            }
        }
    }

    @KeepForSdk
    public final int e0(int i2) {
        int[] iArr;
        int i3 = 0;
        Preconditions.n(i2 >= 0 && i2 < this.n);
        while (true) {
            iArr = this.m;
            if (i3 >= iArr.length) {
                break;
            }
            if (i2 < iArr[i3]) {
                i3--;
                break;
            }
            i3++;
        }
        return i3 == iArr.length ? i3 - 1 : i3;
    }

    protected final void finalize() throws Throwable {
        try {
            if (this.p && this.f11913j.length > 0 && !isClosed()) {
                close();
                String string = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(string);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public final int getCount() {
        return this.n;
    }

    @KeepForSdk
    public final boolean isClosed() {
        boolean z;
        synchronized (this) {
            z = this.o;
        }
        return z;
    }

    public final void p0() {
        this.f11912i = new Bundle();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = this.f11911h;
            if (i3 >= strArr.length) {
                break;
            }
            this.f11912i.putInt(strArr[i3], i3);
            i3++;
        }
        this.m = new int[this.f11913j.length];
        int numRows = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f11913j;
            if (i2 >= cursorWindowArr.length) {
                this.n = numRows;
                return;
            }
            this.m[i2] = numRows;
            numRows += this.f11913j[i2].getNumRows() - (numRows - cursorWindowArr[i2].getStartPosition());
            i2++;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.v(parcel, 1, this.f11911h, false);
        SafeParcelWriter.x(parcel, 2, this.f11913j, i2, false);
        SafeParcelWriter.l(parcel, 3, W());
        SafeParcelWriter.e(parcel, 4, z(), false);
        SafeParcelWriter.l(parcel, 1000, this.f11910g);
        SafeParcelWriter.b(parcel, iA);
        if ((i2 & 1) != 0) {
            close();
        }
    }

    @KeepForSdk
    public final byte[] y(String str, int i2, int i3) {
        i0(str, i2);
        return this.f11913j[i3].getBlob(i2, this.f11912i.getInt(str));
    }

    @KeepForSdk
    public final Bundle z() {
        return this.l;
    }

    @KeepForSdk
    public static class Builder {
        private final String[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ArrayList<HashMap<String, Object>> f11915b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f11916c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final HashMap<Object, Integer> f11917d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f11918e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f11919f;

        private Builder(String[] strArr, String str) {
            this.a = (String[]) Preconditions.k(strArr);
            this.f11915b = new ArrayList<>();
            this.f11916c = str;
            this.f11917d = new HashMap<>();
            this.f11918e = false;
            this.f11919f = null;
        }

        /* synthetic */ Builder(String[] strArr, String str, a aVar) {
            this(strArr, null);
        }
    }
}
