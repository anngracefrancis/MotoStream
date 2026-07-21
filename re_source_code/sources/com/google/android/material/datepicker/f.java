package com.google.android.material.datepicker;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.u;
import com.google.android.material.internal.CheckableImageButton;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: MaterialDatePicker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<S> extends androidx.fragment.app.c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Object f18599f = "CONFIRM_BUTTON_TAG";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final Object f18600g = "CANCEL_BUTTON_TAG";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    static final Object f18601h = "TOGGLE_BUTTON_TAG";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final LinkedHashSet<g<? super S>> f18602i = new LinkedHashSet<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final LinkedHashSet<View.OnClickListener> f18603j = new LinkedHashSet<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f18604k = new LinkedHashSet<>();
    private final LinkedHashSet<DialogInterface.OnDismissListener> l = new LinkedHashSet<>();
    private int m;
    private DateSelector<S> n;
    private l<S> o;
    private CalendarConstraints p;
    private e<S> q;
    private int r;
    private CharSequence s;
    private boolean t;
    private int u;
    private TextView v;
    private CheckableImageButton w;
    private e.e.b.c.a0.g x;
    private Button y;

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class a implements View.OnClickListener {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = f.this.f18602i.iterator();
            while (it.hasNext()) {
                ((g) it.next()).a(f.this.p());
            }
            f.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Iterator it = f.this.f18603j.iterator();
            while (it.hasNext()) {
                ((View.OnClickListener) it.next()).onClick(view);
            }
            f.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class c extends k<S> {
        c() {
        }

        @Override // com.google.android.material.datepicker.k
        public void a(S s) {
            f.this.v();
            f.this.y.setEnabled(f.this.n.K0());
        }
    }

    /* JADX INFO: compiled from: MaterialDatePicker.java */
    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.y.setEnabled(f.this.n.K0());
            f.this.w.toggle();
            f fVar = f.this;
            fVar.w(fVar.w);
            f.this.t();
        }
    }

    private static Drawable l(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_checked}, c.a.k.a.a.d(context, e.e.b.c.e.f20993c));
        stateListDrawable.addState(new int[0], c.a.k.a.a.d(context, e.e.b.c.e.f20994d));
        return stateListDrawable;
    }

    private static int m(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(e.e.b.c.d.F) + resources.getDimensionPixelOffset(e.e.b.c.d.G) + resources.getDimensionPixelOffset(e.e.b.c.d.E);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(e.e.b.c.d.A);
        int i2 = i.f18610f;
        return dimensionPixelSize + dimensionPixelSize2 + (resources.getDimensionPixelSize(e.e.b.c.d.y) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(e.e.b.c.d.D)) + resources.getDimensionPixelOffset(e.e.b.c.d.w);
    }

    private static int o(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(e.e.b.c.d.x);
        int i2 = Month.u().f18559j;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(e.e.b.c.d.z) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(e.e.b.c.d.C));
    }

    private int q(Context context) {
        int i2 = this.m;
        return i2 != 0 ? i2 : this.n.E0(context);
    }

    private void r(Context context) {
        this.w.setTag(f18601h);
        this.w.setImageDrawable(l(context));
        this.w.setChecked(this.u != 0);
        u.i0(this.w, null);
        w(this.w);
        this.w.setOnClickListener(new d());
    }

    static boolean s(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(e.e.b.c.x.b.c(context, e.e.b.c.b.v, e.class.getCanonicalName()), new int[]{R.attr.windowFullscreen});
        boolean z = typedArrayObtainStyledAttributes.getBoolean(0, false);
        typedArrayObtainStyledAttributes.recycle();
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.q = e.u(this.n, q(requireContext()), this.p);
        this.o = this.w.isChecked() ? h.f(this.n, this.p) : this.q;
        v();
        androidx.fragment.app.u uVarM = getChildFragmentManager().m();
        uVarM.q(e.e.b.c.f.p, this.o);
        uVarM.k();
        this.o.d(new c());
    }

    public static long u() {
        return Month.u().l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        String strN = n();
        this.v.setContentDescription(String.format(getString(e.e.b.c.j.l), strN));
        this.v.setText(strN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(CheckableImageButton checkableImageButton) {
        this.w.setContentDescription(this.w.isChecked() ? checkableImageButton.getContext().getString(e.e.b.c.j.o) : checkableImageButton.getContext().getString(e.e.b.c.j.q));
    }

    public String n() {
        return this.n.A(getContext());
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.f18604k.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.m = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.n = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.p = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.r = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.s = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.u = bundle.getInt("INPUT_MODE_KEY");
    }

    @Override // androidx.fragment.app.c
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), q(requireContext()));
        Context context = dialog.getContext();
        this.t = s(context);
        int iC = e.e.b.c.x.b.c(context, e.e.b.c.b.o, f.class.getCanonicalName());
        e.e.b.c.a0.g gVar = new e.e.b.c.a0.g(context, null, e.e.b.c.b.v, e.e.b.c.k.w);
        this.x = gVar;
        gVar.N(context);
        this.x.X(ColorStateList.valueOf(iC));
        this.x.W(u.t(dialog.getWindow().getDecorView()));
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(this.t ? e.e.b.c.h.q : e.e.b.c.h.p, viewGroup);
        Context context = viewInflate.getContext();
        if (this.t) {
            viewInflate.findViewById(e.e.b.c.f.p).setLayoutParams(new LinearLayout.LayoutParams(o(context), -2));
        } else {
            View viewFindViewById = viewInflate.findViewById(e.e.b.c.f.q);
            View viewFindViewById2 = viewInflate.findViewById(e.e.b.c.f.p);
            viewFindViewById.setLayoutParams(new LinearLayout.LayoutParams(o(context), -1));
            viewFindViewById2.setMinimumHeight(m(requireContext()));
        }
        TextView textView = (TextView) viewInflate.findViewById(e.e.b.c.f.w);
        this.v = textView;
        u.k0(textView, 1);
        this.w = (CheckableImageButton) viewInflate.findViewById(e.e.b.c.f.x);
        TextView textView2 = (TextView) viewInflate.findViewById(e.e.b.c.f.y);
        CharSequence charSequence = this.s;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.r);
        }
        r(context);
        this.y = (Button) viewInflate.findViewById(e.e.b.c.f.f20999b);
        if (this.n.K0()) {
            this.y.setEnabled(true);
        } else {
            this.y.setEnabled(false);
        }
        this.y.setTag(f18599f);
        this.y.setOnClickListener(new a());
        Button button = (Button) viewInflate.findViewById(e.e.b.c.f.a);
        button.setTag(f18600g);
        button.setOnClickListener(new b());
        return viewInflate;
    }

    @Override // androidx.fragment.app.c, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.l.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.m);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.n);
        CalendarConstraints.b bVar = new CalendarConstraints.b(this.p);
        if (this.q.q() != null) {
            bVar.b(this.q.q().l);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", bVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.r);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.s);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.t) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.x);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(e.e.b.c.d.B);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable((Drawable) this.x, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new e.e.b.c.r.a(requireDialog(), rect));
        }
        t();
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onStop() {
        this.o.e();
        super.onStop();
    }

    public final S p() {
        return this.n.V0();
    }
}
