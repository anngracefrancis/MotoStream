package com.google.android.gms.tasks;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* JADX INFO: loaded from: classes2.dex */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException a(Task<?> task) {
        String strConcat;
        if (!task.m()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception excI = task.i();
        if (excI != null) {
            strConcat = "failure";
        } else if (task.n()) {
            strConcat = "result ".concat(String.valueOf(task.j()));
        } else {
            strConcat = task.l() ? "cancellation" : "unknown issue";
        }
        return new DuplicateTaskCompletionException("Complete with: ".concat(strConcat), excI);
    }
}
