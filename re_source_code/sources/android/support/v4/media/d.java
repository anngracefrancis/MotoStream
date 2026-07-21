package android.support.v4.media;

import android.media.MediaMetadata;
import android.os.Parcel;

/* JADX INFO: compiled from: MediaMetadataCompatApi21.java */
/* JADX INFO: loaded from: classes.dex */
class d {
    public static void a(Object obj, Parcel parcel, int i2) {
        ((MediaMetadata) obj).writeToParcel(parcel, i2);
    }
}
