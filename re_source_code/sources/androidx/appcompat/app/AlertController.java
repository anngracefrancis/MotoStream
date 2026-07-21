package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.c0;
import androidx.core.view.u;
import androidx.core.widget.NestedScrollView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final androidx.appcompat.app.h f116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Window f117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f118d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f119e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f120f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    ListView f121g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private View f122h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f123i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f124j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f125k;
    private int l;
    private int m;
    Button o;
    private CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private CharSequence x;
    Message y;
    private Drawable z;
    private boolean n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new a();

    public static class RecycleListView extends ListView {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final int f126f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f127g;

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.j.f2);
            this.f127g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(c.a.j.g2, -1);
            this.f126f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(c.a.j.h2, -1);
        }

        public void a(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.f126f, getPaddingRight(), z2 ? getPaddingBottom() : this.f127g);
        }
    }

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view == alertController.o && (message3 = alertController.q) != null) {
                messageObtain = Message.obtain(message3);
            } else if (view != alertController.s || (message2 = alertController.u) == null) {
                messageObtain = (view != alertController.w || (message = alertController.y) == null) ? null : Message.obtain(message);
            } else {
                messageObtain = Message.obtain(message2);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController2 = AlertController.this;
            alertController2.R.obtainMessage(1, alertController2.f116b).sendToTarget();
        }
    }

    class b implements NestedScrollView.b {
        final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f129b;

        b(View view, View view2) {
            this.a = view;
            this.f129b = view2;
        }

        @Override // androidx.core.widget.NestedScrollView.b
        public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
            AlertController.g(nestedScrollView, this.a, this.f129b);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f132g;

        c(View view, View view2) {
            this.f131f = view;
            this.f132g = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.A, this.f131f, this.f132g);
        }
    }

    class d implements AbsListView.OnScrollListener {
        final /* synthetic */ View a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f134b;

        d(View view, View view2) {
            this.a = view;
            this.f134b = view2;
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            AlertController.g(absListView, this.a, this.f134b);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ View f136f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ View f137g;

        e(View view, View view2) {
            this.f136f = view;
            this.f137g = view2;
        }

        @Override // java.lang.Runnable
        public void run() {
            AlertController.g(AlertController.this.f121g, this.f136f, this.f137g);
        }
    }

    public static class f {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public e O;
        public final Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f139b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f141d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f143f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public View f144g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public CharSequence f145h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public CharSequence f146i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Drawable f147j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public DialogInterface.OnClickListener f148k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f140c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f142e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;
        public boolean r = true;

        class a extends ArrayAdapter<CharSequence> {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ RecycleListView f149f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Context context, int i2, int i3, CharSequence[] charSequenceArr, RecycleListView recycleListView) {
                super(context, i2, i3, charSequenceArr);
                this.f149f = recycleListView;
            }

            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int i2, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i2, view, viewGroup);
                boolean[] zArr = f.this.F;
                if (zArr != null && zArr[i2]) {
                    this.f149f.setItemChecked(i2, true);
                }
                return view2;
            }
        }

        class b extends CursorAdapter {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final int f151f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final int f152g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ RecycleListView f153h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ AlertController f154i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(Context context, Cursor cursor, boolean z, RecycleListView recycleListView, AlertController alertController) {
                super(context, cursor, z);
                this.f153h = recycleListView;
                this.f154i = alertController;
                Cursor cursor2 = getCursor();
                this.f151f = cursor2.getColumnIndexOrThrow(f.this.L);
                this.f152g = cursor2.getColumnIndexOrThrow(f.this.M);
            }

            @Override // android.widget.CursorAdapter
            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(R.id.text1)).setText(cursor.getString(this.f151f));
                this.f153h.setItemChecked(cursor.getPosition(), cursor.getInt(this.f152g) == 1);
            }

            @Override // android.widget.CursorAdapter
            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return f.this.f139b.inflate(this.f154i.M, viewGroup, false);
            }
        }

        class c implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ AlertController f156f;

            c(AlertController alertController) {
                this.f156f = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                f.this.x.onClick(this.f156f.f116b, i2);
                if (f.this.H) {
                    return;
                }
                this.f156f.f116b.dismiss();
            }
        }

        class d implements AdapterView.OnItemClickListener {

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            final /* synthetic */ RecycleListView f158f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ AlertController f159g;

            d(RecycleListView recycleListView, AlertController alertController) {
                this.f158f = recycleListView;
                this.f159g = alertController;
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                boolean[] zArr = f.this.F;
                if (zArr != null) {
                    zArr[i2] = this.f158f.isItemChecked(i2);
                }
                f.this.J.onClick(this.f159g.f116b, i2, this.f158f.isItemChecked(i2));
            }
        }

        public interface e {
            void a(ListView listView);
        }

        public f(Context context) {
            this.a = context;
            this.f139b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            ListAdapter hVar;
            RecycleListView recycleListView = (RecycleListView) this.f139b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                hVar = this.K == null ? new a(this.a, alertController.M, R.id.text1, this.v, recycleListView) : new b(this.a, this.K, false, recycleListView, alertController);
            } else {
                int i2 = this.H ? alertController.N : alertController.O;
                if (this.K != null) {
                    hVar = new SimpleCursorAdapter(this.a, i2, this.K, new String[]{this.L}, new int[]{R.id.text1});
                } else {
                    hVar = this.w;
                    if (hVar == null) {
                        hVar = new h(this.a, i2, R.id.text1, this.v);
                    }
                }
            }
            e eVar = this.O;
            if (eVar != null) {
                eVar.a(recycleListView);
            }
            alertController.H = hVar;
            alertController.I = this.I;
            if (this.x != null) {
                recycleListView.setOnItemClickListener(new c(alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new d(recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.f121g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.f144g;
            if (view != null) {
                alertController.m(view);
            } else {
                CharSequence charSequence = this.f143f;
                if (charSequence != null) {
                    alertController.r(charSequence);
                }
                Drawable drawable = this.f141d;
                if (drawable != null) {
                    alertController.o(drawable);
                }
                int i2 = this.f140c;
                if (i2 != 0) {
                    alertController.n(i2);
                }
                int i3 = this.f142e;
                if (i3 != 0) {
                    alertController.n(alertController.d(i3));
                }
            }
            CharSequence charSequence2 = this.f145h;
            if (charSequence2 != null) {
                alertController.p(charSequence2);
            }
            CharSequence charSequence3 = this.f146i;
            if (charSequence3 != null || this.f147j != null) {
                alertController.l(-1, charSequence3, this.f148k, null, this.f147j);
            }
            CharSequence charSequence4 = this.l;
            if (charSequence4 != null || this.m != null) {
                alertController.l(-2, charSequence4, this.n, null, this.m);
            }
            CharSequence charSequence5 = this.o;
            if (charSequence5 != null || this.p != null) {
                alertController.l(-3, charSequence5, this.q, null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 != null) {
                if (this.E) {
                    alertController.u(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.t(view2);
                    return;
                }
            }
            int i4 = this.y;
            if (i4 != 0) {
                alertController.s(i4);
            }
        }
    }

    private static final class g extends Handler {
        private WeakReference<DialogInterface> a;

        public g(DialogInterface dialogInterface) {
            this.a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == -3 || i2 == -2 || i2 == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.a.get(), message.what);
            } else {
                if (i2 != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class h extends ArrayAdapter<CharSequence> {
        public h(Context context, int i2, int i3, CharSequence[] charSequenceArr) {
            super(context, i2, i3, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i2) {
            return i2;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, androidx.appcompat.app.h hVar, Window window) {
        this.a = context;
        this.f116b = hVar;
        this.f117c = window;
        this.R = new g(hVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, c.a.j.F, c.a.a.n, 0);
        this.J = typedArrayObtainStyledAttributes.getResourceId(c.a.j.G, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(c.a.j.I, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(c.a.j.K, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(c.a.j.L, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(c.a.j.N, 0);
        this.O = typedArrayObtainStyledAttributes.getResourceId(c.a.j.J, 0);
        this.P = typedArrayObtainStyledAttributes.getBoolean(c.a.j.M, true);
        this.f118d = typedArrayObtainStyledAttributes.getDimensionPixelSize(c.a.j.H, 0);
        typedArrayObtainStyledAttributes.recycle();
        hVar.d(1);
    }

    private static boolean A(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(c.a.a.m, typedValue, true);
        return typedValue.data != 0;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private void b(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }

    static void g(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private ViewGroup j(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private int k() {
        int i2 = this.K;
        if (i2 == 0) {
            return this.J;
        }
        return this.Q == 1 ? i2 : this.J;
    }

    private void q(ViewGroup viewGroup, View view, int i2, int i3) {
        View viewFindViewById = this.f117c.findViewById(c.a.f.v);
        View viewFindViewById2 = this.f117c.findViewById(c.a.f.u);
        if (Build.VERSION.SDK_INT >= 23) {
            u.y0(view, i2, i3);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        if (viewFindViewById != null && (i2 & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (i2 & 2) == 0) {
            viewGroup.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        if (this.f120f != null) {
            this.A.setOnScrollChangeListener(new b(viewFindViewById, viewFindViewById2));
            this.A.post(new c(viewFindViewById, viewFindViewById2));
            return;
        }
        ListView listView = this.f121g;
        if (listView != null) {
            listView.setOnScrollListener(new d(viewFindViewById, viewFindViewById2));
            this.f121g.post(new e(viewFindViewById, viewFindViewById2));
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (viewFindViewById2 != null) {
            viewGroup.removeView(viewFindViewById2);
        }
    }

    private void v(ViewGroup viewGroup) {
        int i2;
        Button button = (Button) viewGroup.findViewById(R.id.button1);
        this.o = button;
        button.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            this.o.setVisibility(8);
            i2 = 0;
        } else {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i3 = this.f118d;
                drawable.setBounds(0, 0, i3, i3);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            i2 = 1;
        }
        Button button2 = (Button) viewGroup.findViewById(R.id.button2);
        this.s = button2;
        button2.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i4 = this.f118d;
                drawable2.setBounds(0, 0, i4, i4);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            i2 |= 2;
        }
        Button button3 = (Button) viewGroup.findViewById(R.id.button3);
        this.w = button3;
        button3.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.x);
            Drawable drawable3 = this.z;
            if (drawable3 != null) {
                int i5 = this.f118d;
                drawable3.setBounds(0, 0, i5, i5);
                this.w.setCompoundDrawables(this.z, null, null, null);
            }
            this.w.setVisibility(0);
            i2 |= 4;
        }
        if (A(this.a)) {
            if (i2 == 1) {
                b(this.o);
            } else if (i2 == 2) {
                b(this.s);
            } else if (i2 == 4) {
                b(this.w);
            }
        }
        if (i2 != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void w(ViewGroup viewGroup) {
        NestedScrollView nestedScrollView = (NestedScrollView) this.f117c.findViewById(c.a.f.w);
        this.A = nestedScrollView;
        nestedScrollView.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroup.findViewById(R.id.message);
        this.F = textView;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f120f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.f121g == null) {
            viewGroup.setVisibility(8);
            return;
        }
        ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
        int iIndexOfChild = viewGroup2.indexOfChild(this.A);
        viewGroup2.removeViewAt(iIndexOfChild);
        viewGroup2.addView(this.f121g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private void x(ViewGroup viewGroup) {
        View viewInflate = this.f122h;
        if (viewInflate == null) {
            viewInflate = this.f123i != 0 ? LayoutInflater.from(this.a).inflate(this.f123i, viewGroup, false) : null;
        }
        boolean z = viewInflate != null;
        if (!z || !a(viewInflate)) {
            this.f117c.setFlags(131072, 131072);
        }
        if (!z) {
            viewGroup.setVisibility(8);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.f117c.findViewById(c.a.f.n);
        frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
        if (this.n) {
            frameLayout.setPadding(this.f124j, this.f125k, this.l, this.m);
        }
        if (this.f121g != null) {
            ((c0.a) viewGroup.getLayoutParams()).a = 0.0f;
        }
    }

    private void y(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f117c.findViewById(c.a.f.O).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f117c.findViewById(R.id.icon);
        if (!(!TextUtils.isEmpty(this.f119e)) || !this.P) {
            this.f117c.findViewById(c.a.f.O).setVisibility(8);
            this.D.setVisibility(8);
            viewGroup.setVisibility(8);
            return;
        }
        TextView textView = (TextView) this.f117c.findViewById(c.a.f.f2730j);
        this.E = textView;
        textView.setText(this.f119e);
        int i2 = this.B;
        if (i2 != 0) {
            this.D.setImageResource(i2);
            return;
        }
        Drawable drawable = this.C;
        if (drawable != null) {
            this.D.setImageDrawable(drawable);
        } else {
            this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
            this.D.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f117c.findViewById(c.a.f.t);
        int i2 = c.a.f.P;
        View viewFindViewById4 = viewFindViewById3.findViewById(i2);
        int i3 = c.a.f.m;
        View viewFindViewById5 = viewFindViewById3.findViewById(i3);
        int i4 = c.a.f.f2731k;
        View viewFindViewById6 = viewFindViewById3.findViewById(i4);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(c.a.f.o);
        x(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(i2);
        View viewFindViewById8 = viewGroup.findViewById(i3);
        View viewFindViewById9 = viewGroup.findViewById(i4);
        ViewGroup viewGroupJ = j(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupJ2 = j(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupJ3 = j(viewFindViewById9, viewFindViewById6);
        w(viewGroupJ2);
        v(viewGroupJ3);
        y(viewGroupJ);
        boolean z = viewGroup.getVisibility() != 8;
        boolean z2 = (viewGroupJ == null || viewGroupJ.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (viewGroupJ3 == null || viewGroupJ3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupJ2 != null && (viewFindViewById2 = viewGroupJ2.findViewById(c.a.f.K)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f120f == null && this.f121g == null) ? null : viewGroupJ.findViewById(c.a.f.N);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupJ2 != null && (viewFindViewById = viewGroupJ2.findViewById(c.a.f.L)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.f121g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).a(z2, z3);
        }
        if (!z) {
            View view = this.f121g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                q(viewGroupJ2, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.f121g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i5 = this.I;
        if (i5 > -1) {
            listView2.setItemChecked(i5, true);
            listView2.setSelection(i5);
        }
    }

    public Button c(int i2) {
        if (i2 == -3) {
            return this.w;
        }
        if (i2 == -2) {
            return this.s;
        }
        if (i2 != -1) {
            return null;
        }
        return this.o;
    }

    public int d(int i2) {
        TypedValue typedValue = new TypedValue();
        this.a.getTheme().resolveAttribute(i2, typedValue, true);
        return typedValue.resourceId;
    }

    public ListView e() {
        return this.f121g;
    }

    public void f() {
        this.f116b.setContentView(k());
        z();
    }

    public boolean h(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public boolean i(int i2, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.q(keyEvent);
    }

    public void l(int i2, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i2, onClickListener);
        }
        if (i2 == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i2 == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else {
            if (i2 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.p = charSequence;
            this.q = message;
            this.r = drawable;
        }
    }

    public void m(View view) {
        this.G = view;
    }

    public void n(int i2) {
        this.C = null;
        this.B = i2;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i2 == 0) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            }
        }
    }

    public void o(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable == null) {
                imageView.setVisibility(8);
            } else {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            }
        }
    }

    public void p(CharSequence charSequence) {
        this.f120f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void r(CharSequence charSequence) {
        this.f119e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void s(int i2) {
        this.f122h = null;
        this.f123i = i2;
        this.n = false;
    }

    public void t(View view) {
        this.f122h = view;
        this.f123i = 0;
        this.n = false;
    }

    public void u(View view, int i2, int i3, int i4, int i5) {
        this.f122h = view;
        this.f123i = 0;
        this.n = true;
        this.f124j = i2;
        this.f125k = i3;
        this.l = i4;
        this.m = i5;
    }
}
