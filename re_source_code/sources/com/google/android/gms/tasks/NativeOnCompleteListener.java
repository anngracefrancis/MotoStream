package com.google.android.gms.tasks;

import com.google.android.gms.common.annotation.KeepForSdk;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
public class NativeOnCompleteListener implements OnCompleteListener<Object> {
    private final long a;

    @Override // com.google.android.gms.tasks.OnCompleteListener
    @KeepForSdk
    public void a(Task<Object> task) {
        Object objJ;
        String message;
        Exception excI;
        if (task.n()) {
            objJ = task.j();
            message = null;
        } else if (task.l() || (excI = task.i()) == null) {
            objJ = null;
            message = null;
        } else {
            message = excI.getMessage();
            objJ = null;
        }
        nativeOnComplete(this.a, objJ, task.n(), task.l(), message);
    }

    @KeepForSdk
    public native void nativeOnComplete(long j2, Object obj, boolean z, boolean z2, String str);
}
