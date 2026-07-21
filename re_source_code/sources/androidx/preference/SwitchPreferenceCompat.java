package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;

/* JADX INFO: loaded from: classes.dex */
public class SwitchPreferenceCompat extends TwoStatePreference {
    private final a a0;
    private CharSequence b0;
    private CharSequence c0;

    private class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (SwitchPreferenceCompat.this.k(Boolean.valueOf(z))) {
                SwitchPreferenceCompat.this.a1(z);
            } else {
                compoundButton.setChecked(!z);
            }
        }
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.a0 = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.N1, i2, i3);
        d1(androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.V1, t.O1));
        c1(androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.U1, t.P1));
        h1(androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.X1, t.R1));
        g1(androidx.core.content.d.g.o(typedArrayObtainStyledAttributes, t.W1, t.S1));
        b1(androidx.core.content.d.g.b(typedArrayObtainStyledAttributes, t.T1, t.Q1, false));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void i1(View view) {
        boolean z = view instanceof SwitchCompat;
        if (z) {
            ((SwitchCompat) view).setOnCheckedChangeListener(null);
        }
        if (view instanceof Checkable) {
            ((Checkable) view).setChecked(this.V);
        }
        if (z) {
            SwitchCompat switchCompat = (SwitchCompat) view;
            switchCompat.setTextOn(this.b0);
            switchCompat.setTextOff(this.c0);
            switchCompat.setOnCheckedChangeListener(this.a0);
        }
    }

    private void j1(View view) {
        if (((AccessibilityManager) D().getSystemService("accessibility")).isEnabled()) {
            i1(view.findViewById(p.f1878f));
            e1(view.findViewById(R.id.summary));
        }
    }

    public void g1(CharSequence charSequence) {
        this.c0 = charSequence;
        e0();
    }

    public void h1(CharSequence charSequence) {
        this.b0 = charSequence;
        e0();
    }

    @Override // androidx.preference.Preference
    public void k0(l lVar) {
        super.k0(lVar);
        i1(lVar.a(p.f1878f));
        f1(lVar);
    }

    @Override // androidx.preference.Preference
    protected void x0(View view) {
        super.x0(view);
        j1(view);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public SwitchPreferenceCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, m.l);
    }
}
