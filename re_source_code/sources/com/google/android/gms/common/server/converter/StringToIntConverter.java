package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@SafeParcelable.Class
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zac();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f12098f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap<String, Integer> f12099g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final SparseArray<String> f12100h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final ArrayList<zaa> f12101i;

    @SafeParcelable.Constructor
    StringToIntConverter(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) ArrayList<zaa> arrayList) {
        this.f12098f = i2;
        this.f12099g = new HashMap<>();
        this.f12100h = new SparseArray<>();
        this.f12101i = null;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            zaa zaaVar = arrayList.get(i3);
            i3++;
            zaa zaaVar2 = zaaVar;
            y(zaaVar2.f12103g, zaaVar2.f12104h);
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse.FieldConverter
    public final /* synthetic */ String c(Integer num) {
        String str = this.f12100h.get(num.intValue());
        return (str == null && this.f12099g.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f12098f);
        ArrayList arrayList = new ArrayList();
        for (String str : this.f12099g.keySet()) {
            arrayList.add(new zaa(str, this.f12099g.get(str).intValue()));
        }
        SafeParcelWriter.y(parcel, 2, arrayList, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @KeepForSdk
    public final StringToIntConverter y(String str, int i2) {
        this.f12099g.put(str, Integer.valueOf(i2));
        this.f12100h.put(i2, str);
        return this;
    }

    @SafeParcelable.Class
    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new zad();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @SafeParcelable.VersionField
        private final int f12102f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @SafeParcelable.Field
        final String f12103g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @SafeParcelable.Field
        final int f12104h;

        @SafeParcelable.Constructor
        zaa(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i3) {
            this.f12102f = i2;
            this.f12103g = str;
            this.f12104h = i3;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i2) {
            int iA = SafeParcelWriter.a(parcel);
            SafeParcelWriter.l(parcel, 1, this.f12102f);
            SafeParcelWriter.u(parcel, 2, this.f12103g, false);
            SafeParcelWriter.l(parcel, 3, this.f12104h);
            SafeParcelWriter.b(parcel, iA);
        }

        zaa(String str, int i2) {
            this.f12102f = 1;
            this.f12103g = str;
            this.f12104h = i2;
        }
    }

    @KeepForSdk
    public StringToIntConverter() {
        this.f12098f = 1;
        this.f12099g = new HashMap<>();
        this.f12100h = new SparseArray<>();
        this.f12101i = null;
    }
}
