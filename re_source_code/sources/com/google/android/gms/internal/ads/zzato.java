package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
public final class zzato extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzato> CREATOR = new zzatp();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    public final String f14157f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    public final int f14158g;

    public zzato(RewardItem rewardItem) {
        this(rewardItem.getType(), rewardItem.getAmount());
    }

    public static zzato y(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        return new zzato(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzato)) {
            zzato zzatoVar = (zzato) obj;
            if (Objects.a(this.f14157f, zzatoVar.f14157f) && Objects.a(Integer.valueOf(this.f14158g), Integer.valueOf(zzatoVar.f14158g))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.b(this.f14157f, Integer.valueOf(this.f14158g));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int iA = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 2, this.f14157f, false);
        SafeParcelWriter.l(parcel, 3, this.f14158g);
        SafeParcelWriter.b(parcel, iA);
    }

    @SafeParcelable.Constructor
    public zzato(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i2) {
        this.f14157f = str;
        this.f14158g = i2;
    }
}
