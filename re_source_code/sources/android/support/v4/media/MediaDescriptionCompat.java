package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f6f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final CharSequence f7g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final CharSequence f8h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final CharSequence f9i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Bitmap f10j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final Uri f11k;
    private final Bundle l;
    private final Uri m;
    private Object n;

    static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return Build.VERSION.SDK_INT < 21 ? new MediaDescriptionCompat(parcel) : MediaDescriptionCompat.a(android.support.v4.media.b.a(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaDescriptionCompat[] newArray(int i2) {
            return new MediaDescriptionCompat[i2];
        }
    }

    public static final class b {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private CharSequence f12b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private CharSequence f13c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private CharSequence f14d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Bitmap f15e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private Uri f16f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private Bundle f17g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Uri f18h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.a, this.f12b, this.f13c, this.f14d, this.f15e, this.f16f, this.f17g, this.f18h);
        }

        public b b(CharSequence charSequence) {
            this.f14d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f17g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f15e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f16f = uri;
            return this;
        }

        public b f(String str) {
            this.a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f18h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f13c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f12b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f6f = str;
        this.f7g = charSequence;
        this.f8h = charSequence2;
        this.f9i = charSequence3;
        this.f10j = bitmap;
        this.f11k = uri;
        this.l = bundle;
        this.m = uri2;
    }

    public static MediaDescriptionCompat a(Object obj) {
        int i2;
        Uri uri;
        Bundle bundle = null;
        if (obj == null || (i2 = Build.VERSION.SDK_INT) < 21) {
            return null;
        }
        b bVar = new b();
        bVar.f(android.support.v4.media.b.f(obj));
        bVar.i(android.support.v4.media.b.h(obj));
        bVar.h(android.support.v4.media.b.g(obj));
        bVar.b(android.support.v4.media.b.b(obj));
        bVar.d(android.support.v4.media.b.d(obj));
        bVar.e(android.support.v4.media.b.e(obj));
        Bundle bundleC = android.support.v4.media.b.c(obj);
        if (bundleC != null) {
            MediaSessionCompat.a(bundleC);
            uri = (Uri) bundleC.getParcelable("android.support.v4.media.description.MEDIA_URI");
        } else {
            uri = null;
        }
        if (uri == null) {
            bundle = bundleC;
        } else if (!bundleC.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") || bundleC.size() != 2) {
            bundleC.remove("android.support.v4.media.description.MEDIA_URI");
            bundleC.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleC;
        }
        bVar.c(bundle);
        if (uri != null) {
            bVar.g(uri);
        } else if (i2 >= 23) {
            bVar.g(c.a(obj));
        }
        MediaDescriptionCompat mediaDescriptionCompatA = bVar.a();
        mediaDescriptionCompatA.n = obj;
        return mediaDescriptionCompatA;
    }

    public Object b() {
        int i2;
        Object obj = this.n;
        if (obj != null || (i2 = Build.VERSION.SDK_INT) < 21) {
            return obj;
        }
        Object objB = android.support.v4.media.b.a.b();
        android.support.v4.media.b.a.g(objB, this.f6f);
        android.support.v4.media.b.a.i(objB, this.f7g);
        android.support.v4.media.b.a.h(objB, this.f8h);
        android.support.v4.media.b.a.c(objB, this.f9i);
        android.support.v4.media.b.a.e(objB, this.f10j);
        android.support.v4.media.b.a.f(objB, this.f11k);
        Bundle bundle = this.l;
        if (i2 < 23 && this.m != null) {
            if (bundle == null) {
                bundle = new Bundle();
                bundle.putBoolean("android.support.v4.media.description.NULL_BUNDLE_FLAG", true);
            }
            bundle.putParcelable("android.support.v4.media.description.MEDIA_URI", this.m);
        }
        android.support.v4.media.b.a.d(objB, bundle);
        if (i2 >= 23) {
            c.a.a(objB, this.m);
        }
        Object objA = android.support.v4.media.b.a.a(objB);
        this.n = objA;
        return objA;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return ((Object) this.f7g) + ", " + ((Object) this.f8h) + ", " + ((Object) this.f9i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            android.support.v4.media.b.i(b(), parcel, i2);
            return;
        }
        parcel.writeString(this.f6f);
        TextUtils.writeToParcel(this.f7g, parcel, i2);
        TextUtils.writeToParcel(this.f8h, parcel, i2);
        TextUtils.writeToParcel(this.f9i, parcel, i2);
        parcel.writeParcelable(this.f10j, i2);
        parcel.writeParcelable(this.f11k, i2);
        parcel.writeBundle(this.l);
        parcel.writeParcelable(this.m, i2);
    }

    MediaDescriptionCompat(Parcel parcel) {
        this.f6f = parcel.readString();
        this.f7g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f8h = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f9i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        ClassLoader classLoader = MediaDescriptionCompat.class.getClassLoader();
        this.f10j = (Bitmap) parcel.readParcelable(classLoader);
        this.f11k = (Uri) parcel.readParcelable(classLoader);
        this.l = parcel.readBundle(classLoader);
        this.m = (Uri) parcel.readParcelable(classLoader);
    }
}
