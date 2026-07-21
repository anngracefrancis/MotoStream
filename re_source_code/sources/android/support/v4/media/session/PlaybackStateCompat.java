package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final int f43f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f44g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final long f45h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final float f46i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final long f47j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final int f48k;
    final CharSequence l;
    final long m;
    List<CustomAction> n;
    final long o;
    final Bundle p;
    private Object q;

    static class a implements Parcelable.Creator<PlaybackStateCompat> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }
    }

    PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, int i3, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        this.f43f = i2;
        this.f44g = j2;
        this.f45h = j3;
        this.f46i = f2;
        this.f47j = j4;
        this.f48k = i3;
        this.l = charSequence;
        this.m = j5;
        this.n = new ArrayList(list);
        this.o = j6;
        this.p = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> listD = g.d(obj);
        if (listD != null) {
            ArrayList arrayList2 = new ArrayList(listD.size());
            Iterator<Object> it = listD.iterator();
            while (it.hasNext()) {
                arrayList2.add(CustomAction.a(it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(g.i(obj), g.h(obj), g.c(obj), g.g(obj), g.a(obj), 0, g.e(obj), g.f(obj), arrayList, g.b(obj), Build.VERSION.SDK_INT >= 22 ? h.a(obj) : null);
        playbackStateCompat.q = obj;
        return playbackStateCompat;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f43f + ", position=" + this.f44g + ", buffered position=" + this.f45h + ", speed=" + this.f46i + ", updated=" + this.m + ", actions=" + this.f47j + ", error code=" + this.f48k + ", error message=" + this.l + ", custom actions=" + this.n + ", active item id=" + this.o + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f43f);
        parcel.writeLong(this.f44g);
        parcel.writeFloat(this.f46i);
        parcel.writeLong(this.m);
        parcel.writeLong(this.f45h);
        parcel.writeLong(this.f47j);
        TextUtils.writeToParcel(this.l, parcel, i2);
        parcel.writeTypedList(this.n);
        parcel.writeLong(this.o);
        parcel.writeBundle(this.p);
        parcel.writeInt(this.f48k);
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f49f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final CharSequence f50g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final int f51h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final Bundle f52i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private Object f53j;

        static class a implements Parcelable.Creator<CustomAction> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i2) {
                return new CustomAction[i2];
            }
        }

        CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.f49f = str;
            this.f50g = charSequence;
            this.f51h = i2;
            this.f52i = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(g.a.a(obj), g.a.d(obj), g.a.c(obj), g.a.b(obj));
            customAction.f53j = obj;
            return customAction;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f50g) + ", mIcon=" + this.f51h + ", mExtras=" + this.f52i;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f49f);
            TextUtils.writeToParcel(this.f50g, parcel, i2);
            parcel.writeInt(this.f51h);
            parcel.writeBundle(this.f52i);
        }

        CustomAction(Parcel parcel) {
            this.f49f = parcel.readString();
            this.f50g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f51h = parcel.readInt();
            this.f52i = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f43f = parcel.readInt();
        this.f44g = parcel.readLong();
        this.f46i = parcel.readFloat();
        this.m = parcel.readLong();
        this.f45h = parcel.readLong();
        this.f47j = parcel.readLong();
        this.l = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.n = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.o = parcel.readLong();
        this.p = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f48k = parcel.readInt();
    }
}
