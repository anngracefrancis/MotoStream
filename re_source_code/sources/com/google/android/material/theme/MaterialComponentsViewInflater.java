package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.j;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.c;
import androidx.appcompat.widget.e;
import androidx.appcompat.widget.t;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.g;
import com.google.android.material.textview.MaterialTextView;
import e.e.b.c.o.a;

/* JADX INFO: loaded from: classes2.dex */
public class MaterialComponentsViewInflater extends j {
    @Override // androidx.appcompat.app.j
    protected c b(Context context, AttributeSet attributeSet) {
        return new g(context, attributeSet);
    }

    @Override // androidx.appcompat.app.j
    protected AppCompatButton c(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // androidx.appcompat.app.j
    protected e d(Context context, AttributeSet attributeSet) {
        return new a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.j
    protected AppCompatRadioButton j(Context context, AttributeSet attributeSet) {
        return new e.e.b.c.w.a(context, attributeSet);
    }

    @Override // androidx.appcompat.app.j
    protected t n(Context context, AttributeSet attributeSet) {
        return new MaterialTextView(context, attributeSet);
    }
}
