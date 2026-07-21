package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(VersionedParcel versionedParcel) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        audioAttributesCompat.f1788c = (AudioAttributesImpl) versionedParcel.v(audioAttributesCompat.f1788c, 1);
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.M(audioAttributesCompat.f1788c, 1);
    }
}
