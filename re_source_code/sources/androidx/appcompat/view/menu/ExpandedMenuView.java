package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.widget.q0;

/* JADX INFO: loaded from: classes.dex */
public final class ExpandedMenuView extends ListView implements g.b, n, AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int[] f248f = {R.attr.background, R.attr.divider};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g f249g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f250h;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listViewStyle);
    }

    @Override // androidx.appcompat.view.menu.g.b
    public boolean a(i iVar) {
        return this.f249g.N(iVar, 0);
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(g gVar) {
        this.f249g = gVar;
    }

    public int getWindowAnimations() {
        return this.f250h;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
        a((i) getAdapter().getItem(i2));
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        q0 q0VarV = q0.v(context, attributeSet, f248f, i2, 0);
        if (q0VarV.s(0)) {
            setBackgroundDrawable(q0VarV.g(0));
        }
        if (q0VarV.s(1)) {
            setDivider(q0VarV.g(1));
        }
        q0VarV.w();
    }
}
