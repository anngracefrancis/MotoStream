package android.support.v4.os;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f62f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Handler f63g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    android.support.v4.os.a f64h;

    class a implements Parcelable.Creator<ResultReceiver> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ResultReceiver[] newArray(int i2) {
            return new ResultReceiver[i2];
        }
    }

    class b extends android.support.v4.os.a.AbstractBinderC0005a {
        b() {
        }

        @Override // android.support.v4.os.a
        public void d7(int i2, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f63g;
            if (handler != null) {
                handler.post(resultReceiver.new c(i2, bundle));
            } else {
                resultReceiver.a(i2, bundle);
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f66f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final Bundle f67g;

        c(int i2, Bundle bundle) {
            this.f66f = i2;
            this.f67g = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.a(this.f66f, this.f67g);
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f64h = android.support.v4.os.a.AbstractBinderC0005a.H(parcel.readStrongBinder());
    }

    protected void a(int i2, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            if (this.f64h == null) {
                this.f64h = new b();
            }
            parcel.writeStrongBinder(this.f64h.asBinder());
        }
    }
}
