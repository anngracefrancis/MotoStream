package com.google.android.gms.location;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class c implements Comparator<ActivityTransition> {
    c() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(ActivityTransition activityTransition, ActivityTransition activityTransition2) {
        ActivityTransition activityTransition3 = activityTransition;
        ActivityTransition activityTransition4 = activityTransition2;
        int iY = activityTransition3.y();
        int iY2 = activityTransition4.y();
        if (iY != iY2) {
            return iY < iY2 ? -1 : 1;
        }
        int iZ = activityTransition3.z();
        int iZ2 = activityTransition4.z();
        if (iZ == iZ2) {
            return 0;
        }
        return iZ < iZ2 ? -1 : 1;
    }
}
