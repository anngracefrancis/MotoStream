package androidx.media;

import androidx.versionedparcelable.VersionedParcel;

/* JADX INFO: loaded from: classes.dex */
public final class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(VersionedParcel versionedParcel) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.a = versionedParcel.p(audioAttributesImplBase.a, 1);
        audioAttributesImplBase.f1790b = versionedParcel.p(audioAttributesImplBase.f1790b, 2);
        audioAttributesImplBase.f1791c = versionedParcel.p(audioAttributesImplBase.f1791c, 3);
        audioAttributesImplBase.f1792d = versionedParcel.p(audioAttributesImplBase.f1792d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, VersionedParcel versionedParcel) {
        versionedParcel.x(false, false);
        versionedParcel.F(audioAttributesImplBase.a, 1);
        versionedParcel.F(audioAttributesImplBase.f1790b, 2);
        versionedParcel.F(audioAttributesImplBase.f1791c, 3);
        versionedParcel.F(audioAttributesImplBase.f1792d, 4);
    }
}
