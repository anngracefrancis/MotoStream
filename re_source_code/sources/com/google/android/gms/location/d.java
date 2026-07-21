package com.google.android.gms.location;

import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
final class d implements Comparator<DetectedActivity> {
    d() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
        DetectedActivity detectedActivity3 = detectedActivity;
        DetectedActivity detectedActivity4 = detectedActivity2;
        int iCompareTo = Integer.valueOf(detectedActivity4.y()).compareTo(Integer.valueOf(detectedActivity3.y()));
        return iCompareTo == 0 ? Integer.valueOf(detectedActivity3.z()).compareTo(Integer.valueOf(detectedActivity4.z())) : iCompareTo;
    }
}
