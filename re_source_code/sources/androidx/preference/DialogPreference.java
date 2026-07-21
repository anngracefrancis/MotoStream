package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    private CharSequence V;
    private CharSequence W;
    private Drawable X;
    private CharSequence Y;
    private CharSequence Z;
    private int a0;

    public interface a {
        <T extends Preference> T findPreference(CharSequence charSequence);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.D, i2, i3);
        String strO = androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.N, t.E);
        this.V = strO;
        if (strO == null) {
            this.V = W();
        }
        this.W = androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.M, t.F);
        this.X = androidx.core.content.d.g.c(typedArrayObtainStyledAttributes, t.K, t.G);
        this.Y = androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.P, t.H);
        this.Z = androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.O, t.I);
        this.a0 = androidx.core.content.d.g.n(typedArrayObtainStyledAttributes, t.L, t.J, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public Drawable Z0() {
        return this.X;
    }

    public int a1() {
        return this.a0;
    }

    public CharSequence b1() {
        return this.W;
    }

    public CharSequence c1() {
        return this.V;
    }

    public CharSequence d1() {
        return this.Z;
    }

    public CharSequence e1() {
        return this.Y;
    }

    @Override // androidx.preference.Preference
    protected void l0() {
        S().s(this);
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.core.content.d.g.a(context, m.f1865c, R.attr.dialogPreferenceStyle));
    }
}
