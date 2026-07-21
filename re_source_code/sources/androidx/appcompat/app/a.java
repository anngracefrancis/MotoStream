package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: ActionBar.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: compiled from: ActionBar.java */
    public interface b {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: ActionBar.java */
    @Deprecated
    public static abstract class c {
        public abstract CharSequence a();

        public abstract View b();

        public abstract Drawable c();

        public abstract CharSequence d();

        public abstract void e();
    }

    public boolean f() {
        return false;
    }

    public abstract boolean g();

    public abstract void h(boolean z);

    public abstract int i();

    public abstract Context j();

    public boolean k() {
        return false;
    }

    public void l(Configuration configuration) {
    }

    void m() {
    }

    public abstract boolean n(int i2, KeyEvent keyEvent);

    public boolean o(KeyEvent keyEvent) {
        return false;
    }

    public boolean p() {
        return false;
    }

    public abstract void q(boolean z);

    public abstract void r(boolean z);

    public abstract void s(boolean z);

    public abstract void t(boolean z);

    public abstract void u(boolean z);

    public abstract void v(CharSequence charSequence);

    public abstract void w(CharSequence charSequence);

    public c.a.o.b x(c.a.o.b.a aVar) {
        return null;
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionBar.java */
    public static class C0009a extends ViewGroup.MarginLayoutParams {
        public int a;

        public C0009a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.t);
            this.a = typedArrayObtainStyledAttributes.getInt(c.a.j.u, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public C0009a(int i2, int i3) {
            super(i2, i3);
            this.a = 0;
            this.a = 8388627;
        }

        public C0009a(C0009a c0009a) {
            super((ViewGroup.MarginLayoutParams) c0009a);
            this.a = 0;
            this.a = c0009a.a;
        }

        public C0009a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 0;
        }
    }
}
