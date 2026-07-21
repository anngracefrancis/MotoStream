package com.google.android.material.textfield;

import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import e.e.b.c.j;

/* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
/* JADX INFO: loaded from: classes2.dex */
class i extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TextWatcher f18819d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextInputLayout.f f18820e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextInputLayout.g f18821f;

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class a implements TextWatcher {
        a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            i iVar = i.this;
            iVar.f18800c.setChecked(!iVar.g());
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class b implements TextInputLayout.f {
        b() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.f
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            i iVar = i.this;
            iVar.f18800c.setChecked(!iVar.g());
            editText.removeTextChangedListener(i.this.f18819d);
            editText.addTextChangedListener(i.this.f18819d);
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class c implements TextInputLayout.g {
        c() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.g
        public void a(TextInputLayout textInputLayout, int i2) {
            EditText editText = textInputLayout.getEditText();
            if (editText == null || i2 != 1) {
                return;
            }
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            editText.removeTextChangedListener(i.this.f18819d);
        }
    }

    /* JADX INFO: compiled from: PasswordToggleEndIconDelegate.java */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EditText editText = i.this.a.getEditText();
            if (editText == null) {
                return;
            }
            int selectionEnd = editText.getSelectionEnd();
            if (i.this.g()) {
                editText.setTransformationMethod(null);
            } else {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            if (selectionEnd >= 0) {
                editText.setSelection(selectionEnd);
            }
        }
    }

    i(TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f18819d = new a();
        this.f18820e = new b();
        this.f18821f = new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        EditText editText = this.a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    private static boolean h(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    @Override // com.google.android.material.textfield.e
    void a() {
        this.a.setEndIconDrawable(c.a.k.a.a.d(this.f18799b, e.e.b.c.e.f20992b));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(j.s));
        this.a.setEndIconOnClickListener(new d());
        this.a.addOnEditTextAttachedListener(this.f18820e);
        this.a.addOnEndIconChangedListener(this.f18821f);
        EditText editText = this.a.getEditText();
        if (h(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
