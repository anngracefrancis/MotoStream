package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@SafeParcelable.Class
public class zzo extends zzaz {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final c.e.a<String, FastJsonResponse.Field<?, ?>> f11432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.VersionField
    private final int f11433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private List<String> f11434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private List<String> f11435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private List<String> f11436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private List<String> f11437k;

    @SafeParcelable.Field
    private List<String> l;

    static {
        c.e.a<String, FastJsonResponse.Field<?, ?>> aVar = new c.e.a<>();
        f11432f = aVar;
        aVar.put("registered", FastJsonResponse.Field.i0("registered", 2));
        aVar.put("in_progress", FastJsonResponse.Field.i0("in_progress", 3));
        aVar.put(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION, FastJsonResponse.Field.i0(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION, 4));
        aVar.put("failed", FastJsonResponse.Field.i0("failed", 5));
        aVar.put("escrowed", FastJsonResponse.Field.i0("escrowed", 6));
    }

    public zzo() {
        this.f11433g = 1;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    public Map<String, FastJsonResponse.Field<?, ?>> a() {
        return f11432f;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object b(FastJsonResponse.Field field) {
        switch (field.p0()) {
            case 1:
                return Integer.valueOf(this.f11433g);
            case 2:
                return this.f11434h;
            case 3:
                return this.f11435i;
            case 4:
                return this.f11436j;
            case 5:
                return this.f11437k;
            case 6:
                return this.l;
            default:
                int iP0 = field.p0();
                StringBuilder sb = new StringBuilder(37);
                sb.append("Unknown SafeParcelable id=");
                sb.append(iP0);
                throw new IllegalStateException(sb.toString());
        }
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean d(FastJsonResponse.Field field) {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.l(parcel, 1, this.f11433g);
        SafeParcelWriter.w(parcel, 2, this.f11434h, false);
        SafeParcelWriter.w(parcel, 3, this.f11435i, false);
        SafeParcelWriter.w(parcel, 4, this.f11436j, false);
        SafeParcelWriter.w(parcel, 5, this.f11437k, false);
        SafeParcelWriter.w(parcel, 6, this.l, false);
        SafeParcelWriter.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    zzo(@SafeParcelable.Param(id = 1) int i2, @SafeParcelable.Param(id = 2) List<String> list, @SafeParcelable.Param(id = 3) List<String> list2, @SafeParcelable.Param(id = 4) List<String> list3, @SafeParcelable.Param(id = 5) List<String> list4, @SafeParcelable.Param(id = 6) List<String> list5) {
        this.f11433g = i2;
        this.f11434h = list;
        this.f11435i = list2;
        this.f11436j = list3;
        this.f11437k = list4;
        this.l = list5;
    }
}
