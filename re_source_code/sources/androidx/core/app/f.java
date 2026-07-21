package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.lifecycle.t;

/* JADX INFO: compiled from: ComponentActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends Activity implements androidx.lifecycle.k, androidx.core.view.e.a {
    private c.e.g<Class<? extends a>, a> mExtraDataMap = new c.e.g<>();
    private androidx.lifecycle.l mLifecycleRegistry = new androidx.lifecycle.l(this);

    /* JADX INFO: compiled from: ComponentActivity.java */
    @Deprecated
    public static class a {
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.view.e.d(decorView, keyEvent)) {
            return androidx.core.view.e.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.view.e.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Deprecated
    public <T extends a> T getExtraData(Class<T> cls) {
        return (T) this.mExtraDataMap.get(cls);
    }

    public androidx.lifecycle.g getLifecycle() {
        throw null;
    }

    @Override // android.app.Activity
    @SuppressLint({"RestrictedApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        t.g(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.mLifecycleRegistry.j(androidx.lifecycle.g.c.CREATED);
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public void putExtraData(a aVar) {
        this.mExtraDataMap.put((Class<? extends a>) aVar.getClass(), aVar);
    }

    @Override // androidx.core.view.e.a
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
