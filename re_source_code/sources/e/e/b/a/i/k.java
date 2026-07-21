package e.e.b.a.i;

import android.annotation.SuppressLint;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import javax.inject.Singleton;

/* JADX INFO: compiled from: ExecutionModule.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class k {
    @Singleton
    @SuppressLint({"ThreadPoolCreation"})
    static Executor a() {
        return new o(Executors.newSingleThreadExecutor());
    }
}
