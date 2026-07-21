package androidx.preference;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import cm.aptoide.pt.database.room.RoomNotification;

/* JADX INFO: compiled from: PreferenceDialogFragmentCompat.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class f extends androidx.fragment.app.c implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DialogPreference f1813f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private CharSequence f1814g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private CharSequence f1815h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CharSequence f1816i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private CharSequence f1817j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f1818k;
    private BitmapDrawable l;
    private int m;

    private void j(Dialog dialog) {
        dialog.getWindow().setSoftInputMode(5);
    }

    public DialogPreference d() {
        if (this.f1813f == null) {
            this.f1813f = (DialogPreference) ((DialogPreference.a) getTargetFragment()).findPreference(getArguments().getString(RoomNotification.KEY));
        }
        return this.f1813f;
    }

    protected boolean e() {
        return false;
    }

    protected void f(View view) {
        View viewFindViewById = view.findViewById(R.id.message);
        if (viewFindViewById != null) {
            CharSequence charSequence = this.f1817j;
            int i2 = 8;
            if (!TextUtils.isEmpty(charSequence)) {
                if (viewFindViewById instanceof TextView) {
                    ((TextView) viewFindViewById).setText(charSequence);
                }
                i2 = 0;
            }
            if (viewFindViewById.getVisibility() != i2) {
                viewFindViewById.setVisibility(i2);
            }
        }
    }

    protected View g(Context context) {
        int i2 = this.f1818k;
        if (i2 == 0) {
            return null;
        }
        return LayoutInflater.from(context).inflate(i2, (ViewGroup) null);
    }

    public abstract void h(boolean z);

    protected void i(androidx.appcompat.app.c.a aVar) {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i2) {
        this.m = i2;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.savedstate.c targetFragment = getTargetFragment();
        if (!(targetFragment instanceof DialogPreference.a)) {
            throw new IllegalStateException("Target fragment must implement TargetFragment interface");
        }
        DialogPreference.a aVar = (DialogPreference.a) targetFragment;
        String string = getArguments().getString(RoomNotification.KEY);
        if (bundle != null) {
            this.f1814g = bundle.getCharSequence("PreferenceDialogFragment.title");
            this.f1815h = bundle.getCharSequence("PreferenceDialogFragment.positiveText");
            this.f1816i = bundle.getCharSequence("PreferenceDialogFragment.negativeText");
            this.f1817j = bundle.getCharSequence("PreferenceDialogFragment.message");
            this.f1818k = bundle.getInt("PreferenceDialogFragment.layout", 0);
            Bitmap bitmap = (Bitmap) bundle.getParcelable("PreferenceDialogFragment.icon");
            if (bitmap != null) {
                this.l = new BitmapDrawable(getResources(), bitmap);
                return;
            }
            return;
        }
        DialogPreference dialogPreference = (DialogPreference) aVar.findPreference(string);
        this.f1813f = dialogPreference;
        this.f1814g = dialogPreference.c1();
        this.f1815h = this.f1813f.e1();
        this.f1816i = this.f1813f.d1();
        this.f1817j = this.f1813f.b1();
        this.f1818k = this.f1813f.a1();
        Drawable drawableZ0 = this.f1813f.Z0();
        if (drawableZ0 == null || (drawableZ0 instanceof BitmapDrawable)) {
            this.l = (BitmapDrawable) drawableZ0;
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawableZ0.getIntrinsicWidth(), drawableZ0.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawableZ0.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawableZ0.draw(canvas);
        this.l = new BitmapDrawable(getResources(), bitmapCreateBitmap);
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        androidx.fragment.app.d activity = getActivity();
        this.m = -2;
        androidx.appcompat.app.c.a aVarM = new androidx.appcompat.app.c.a(activity).v(this.f1814g).g(this.l).r(this.f1815h, this).m(this.f1816i, this);
        View viewG = g(activity);
        if (viewG != null) {
            f(viewG);
            aVarM.w(viewG);
        } else {
            aVarM.j(this.f1817j);
        }
        i(aVarM);
        androidx.appcompat.app.c cVarA = aVarM.a();
        if (e()) {
            j(cVarA);
        }
        return cVarA;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        h(this.m == -1);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putCharSequence("PreferenceDialogFragment.title", this.f1814g);
        bundle.putCharSequence("PreferenceDialogFragment.positiveText", this.f1815h);
        bundle.putCharSequence("PreferenceDialogFragment.negativeText", this.f1816i);
        bundle.putCharSequence("PreferenceDialogFragment.message", this.f1817j);
        bundle.putInt("PreferenceDialogFragment.layout", this.f1818k);
        BitmapDrawable bitmapDrawable = this.l;
        if (bitmapDrawable != null) {
            bundle.putParcelable("PreferenceDialogFragment.icon", bitmapDrawable.getBitmap());
        }
    }
}
