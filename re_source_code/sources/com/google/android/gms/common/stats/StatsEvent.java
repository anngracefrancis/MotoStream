package com.google.android.gms.common.stats;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@Deprecated
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    /* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
    @KeepForSdk
    public interface Types {
    }

    public abstract long W();

    public abstract String Y();

    public final String toString() {
        return W() + "\t" + y() + "\t" + z() + Y();
    }

    public abstract int y();

    public abstract long z();
}
