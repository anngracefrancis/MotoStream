package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

/* JADX INFO: compiled from: AlertDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends h implements DialogInterface {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final AlertController f161h;

    /* JADX INFO: compiled from: AlertDialog.java */
    public static class a {
        private final AlertController.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f162b;

        public a(Context context) {
            this(context, c.g(context, 0));
        }

        public c a() {
            c cVar = new c(this.a.a, this.f162b);
            this.a.a(cVar.f161h);
            cVar.setCancelable(this.a.r);
            if (this.a.r) {
                cVar.setCanceledOnTouchOutside(true);
            }
            cVar.setOnCancelListener(this.a.s);
            cVar.setOnDismissListener(this.a.t);
            DialogInterface.OnKeyListener onKeyListener = this.a.u;
            if (onKeyListener != null) {
                cVar.setOnKeyListener(onKeyListener);
            }
            return cVar;
        }

        public Context b() {
            return this.a.a;
        }

        public a c(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            return this;
        }

        public a d(boolean z) {
            this.a.r = z;
            return this;
        }

        public a e(View view) {
            this.a.f144g = view;
            return this;
        }

        public a f(int i2) {
            this.a.f140c = i2;
            return this;
        }

        public a g(Drawable drawable) {
            this.a.f141d = drawable;
            return this;
        }

        public a h(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.v = fVar.a.getResources().getTextArray(i2);
            this.a.x = onClickListener;
            return this;
        }

        public a i(int i2) {
            AlertController.f fVar = this.a;
            fVar.f145h = fVar.a.getText(i2);
            return this;
        }

        public a j(CharSequence charSequence) {
            this.a.f145h = charSequence;
            return this;
        }

        public a k(CharSequence[] charSequenceArr, boolean[] zArr, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener) {
            AlertController.f fVar = this.a;
            fVar.v = charSequenceArr;
            fVar.J = onMultiChoiceClickListener;
            fVar.F = zArr;
            fVar.G = true;
            return this;
        }

        public a l(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.l = fVar.a.getText(i2);
            this.a.n = onClickListener;
            return this;
        }

        public a m(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.l = charSequence;
            fVar.n = onClickListener;
            return this;
        }

        public a n(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.o = charSequence;
            fVar.q = onClickListener;
            return this;
        }

        public a o(DialogInterface.OnCancelListener onCancelListener) {
            this.a.s = onCancelListener;
            return this;
        }

        public a p(DialogInterface.OnKeyListener onKeyListener) {
            this.a.u = onKeyListener;
            return this;
        }

        public a q(int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.f146i = fVar.a.getText(i2);
            this.a.f148k = onClickListener;
            return this;
        }

        public a r(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.f146i = charSequence;
            fVar.f148k = onClickListener;
            return this;
        }

        public a s(ListAdapter listAdapter, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.w = listAdapter;
            fVar.x = onClickListener;
            fVar.I = i2;
            fVar.H = true;
            return this;
        }

        public a t(CharSequence[] charSequenceArr, int i2, DialogInterface.OnClickListener onClickListener) {
            AlertController.f fVar = this.a;
            fVar.v = charSequenceArr;
            fVar.x = onClickListener;
            fVar.I = i2;
            fVar.H = true;
            return this;
        }

        public a u(int i2) {
            AlertController.f fVar = this.a;
            fVar.f143f = fVar.a.getText(i2);
            return this;
        }

        public a v(CharSequence charSequence) {
            this.a.f143f = charSequence;
            return this;
        }

        public a w(View view) {
            AlertController.f fVar = this.a;
            fVar.z = view;
            fVar.y = 0;
            fVar.E = false;
            return this;
        }

        public a(Context context, int i2) {
            this.a = new AlertController.f(new ContextThemeWrapper(context, c.g(context, i2)));
            this.f162b = i2;
        }
    }

    protected c(Context context, int i2) {
        super(context, g(context, i2));
        this.f161h = new AlertController(getContext(), this, getWindow());
    }

    static int g(Context context, int i2) {
        if (((i2 >>> 24) & 255) >= 1) {
            return i2;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(c.a.a.o, typedValue, true);
        return typedValue.resourceId;
    }

    public Button e(int i2) {
        return this.f161h.c(i2);
    }

    public ListView f() {
        return this.f161h.e();
    }

    public void h(Drawable drawable) {
        this.f161h.o(drawable);
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f161h.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (this.f161h.h(i2, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (this.f161h.i(i2, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i2, keyEvent);
    }

    @Override // androidx.appcompat.app.h, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f161h.r(charSequence);
    }
}
