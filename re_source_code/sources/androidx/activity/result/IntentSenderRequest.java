package androidx.activity.result;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class IntentSenderRequest implements Parcelable {
    public static final Parcelable.Creator<IntentSenderRequest> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final IntentSender f109f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Intent f110g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f111h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f112i;

    class a implements Parcelable.Creator<IntentSenderRequest> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest createFromParcel(Parcel parcel) {
            return new IntentSenderRequest(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public IntentSenderRequest[] newArray(int i2) {
            return new IntentSenderRequest[i2];
        }
    }

    public static final class b {
        private IntentSender a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Intent f113b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f114c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f115d;

        public b(IntentSender intentSender) {
            this.a = intentSender;
        }

        public IntentSenderRequest a() {
            return new IntentSenderRequest(this.a, this.f113b, this.f114c, this.f115d);
        }

        public b b(Intent intent) {
            this.f113b = intent;
            return this;
        }

        public b c(int i2, int i3) {
            this.f115d = i2;
            this.f114c = i3;
            return this;
        }
    }

    IntentSenderRequest(IntentSender intentSender, Intent intent, int i2, int i3) {
        this.f109f = intentSender;
        this.f110g = intent;
        this.f111h = i2;
        this.f112i = i3;
    }

    public Intent a() {
        return this.f110g;
    }

    public int b() {
        return this.f111h;
    }

    public int c() {
        return this.f112i;
    }

    public IntentSender d() {
        return this.f109f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.f109f, i2);
        parcel.writeParcelable(this.f110g, i2);
        parcel.writeInt(this.f111h);
        parcel.writeInt(this.f112i);
    }

    IntentSenderRequest(Parcel parcel) {
        this.f109f = (IntentSender) parcel.readParcelable(IntentSender.class.getClassLoader());
        this.f110g = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f111h = parcel.readInt();
        this.f112i = parcel.readInt();
    }
}
