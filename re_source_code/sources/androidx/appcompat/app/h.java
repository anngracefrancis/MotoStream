package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: AppCompatDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends Dialog implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private f f191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final androidx.core.view.e.a f192g;

    /* JADX INFO: compiled from: AppCompatDialog.java */
    class a implements androidx.core.view.e.a {
        a() {
        }

        @Override // androidx.core.view.e.a
        public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
            return h.this.c(keyEvent);
        }
    }

    public h(Context context, int i2) {
        super(context, b(context, i2));
        this.f192g = new a();
        f fVarA = a();
        fVarA.I(b(context, i2));
        fVarA.t(null);
    }

    private static int b(Context context, int i2) {
        if (i2 != 0) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(c.a.a.z, typedValue, true);
        return typedValue.resourceId;
    }

    public f a() {
        if (this.f191f == null) {
            this.f191f = f.j(this, this);
        }
        return this.f191f;
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().d(view, layoutParams);
    }

    boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    public boolean d(int i2) {
        return a().C(i2);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        a().u();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return androidx.core.view.e.e(this.f192g, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i2) {
        return (T) a().k(i2);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().r();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        a().q();
        super.onCreate(bundle);
        a().t(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().z();
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeFinished(c.a.o.b bVar) {
    }

    @Override // androidx.appcompat.app.e
    public void onSupportActionModeStarted(c.a.o.b bVar) {
    }

    @Override // androidx.appcompat.app.e
    public c.a.o.b onWindowStartingSupportActionMode(c.a.o.b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i2) {
        a().D(i2);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().J(charSequence);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().E(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().F(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i2) {
        super.setTitle(i2);
        a().J(getContext().getString(i2));
    }
}
