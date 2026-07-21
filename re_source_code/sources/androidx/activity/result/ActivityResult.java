package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class ActivityResult implements Parcelable {
    public static final Parcelable.Creator<ActivityResult> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f90f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Intent f91g;

    class a implements Parcelable.Creator<ActivityResult> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ActivityResult createFromParcel(Parcel parcel) {
            return new ActivityResult(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ActivityResult[] newArray(int i2) {
            return new ActivityResult[i2];
        }
    }

    public ActivityResult(int i2, Intent intent) {
        this.f90f = i2;
        this.f91g = intent;
    }

    public static String c(int i2) {
        if (i2 != -1) {
            return i2 != 0 ? String.valueOf(i2) : "RESULT_CANCELED";
        }
        return "RESULT_OK";
    }

    public Intent a() {
        return this.f91g;
    }

    public int b() {
        return this.f90f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivityResult{resultCode=" + c(this.f90f) + ", data=" + this.f91g + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f90f);
        parcel.writeInt(this.f91g == null ? 0 : 1);
        Intent intent = this.f91g;
        if (intent != null) {
            intent.writeToParcel(parcel, i2);
        }
    }

    ActivityResult(Parcel parcel) {
        this.f90f = parcel.readInt();
        this.f91g = parcel.readInt() == 0 ? null : (Intent) Intent.CREATOR.createFromParcel(parcel);
    }
}
