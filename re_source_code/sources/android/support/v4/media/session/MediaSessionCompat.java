package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediaSessionCompat {

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ResultReceiver f34f;

        static class a implements Parcelable.Creator<ResultReceiverWrapper> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ResultReceiverWrapper[] newArray(int i2) {
                return new ResultReceiverWrapper[i2];
            }
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f34f = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            this.f34f.writeToParcel(parcel, i2);
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Object f35f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private b f36g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Bundle f37h;

        static class a implements Parcelable.Creator<Token> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Token createFromParcel(Parcel parcel) {
                return new Token(Build.VERSION.SDK_INT >= 21 ? parcel.readParcelable(null) : parcel.readStrongBinder());
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Token[] newArray(int i2) {
                return new Token[i2];
            }
        }

        Token(Object obj) {
            this(obj, null, null);
        }

        public b a() {
            return this.f36g;
        }

        public void b(b bVar) {
            this.f36g = bVar;
        }

        public void c(Bundle bundle) {
            this.f37h = bundle;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f35f;
            if (obj2 == null) {
                return token.f35f == null;
            }
            Object obj3 = token.f35f;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public int hashCode() {
            Object obj = this.f35f;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f35f, i2);
            } else {
                parcel.writeStrongBinder((IBinder) this.f35f);
            }
        }

        Token(Object obj, b bVar, Bundle bundle) {
            this.f35f = obj;
            this.f36g = bVar;
            this.f37h = bundle;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final MediaDescriptionCompat f31f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f32g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Object f33h;

        static class a implements Parcelable.Creator<QueueItem> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public QueueItem[] newArray(int i2) {
                return new QueueItem[i2];
            }
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (j2 == -1) {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
            this.f31f = mediaDescriptionCompat;
            this.f32g = j2;
            this.f33h = obj;
        }

        public static QueueItem a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.a(f.a(obj)), f.b(obj));
        }

        public static List<QueueItem> b(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f31f + ", Id=" + this.f32g + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            this.f31f.writeToParcel(parcel, i2);
            parcel.writeLong(this.f32g);
        }

        QueueItem(Parcel parcel) {
            this.f31f = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f32g = parcel.readLong();
        }
    }
}
