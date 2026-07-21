package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: BaseMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements m {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected Context f267f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Context f268g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected g f269h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected LayoutInflater f270i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected LayoutInflater f271j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private m.a f272k;
    private int l;
    private int m;
    protected n n;
    private int o;

    public b(Context context, int i2, int i3) {
        this.f267f = context;
        this.f270i = LayoutInflater.from(context);
        this.l = i2;
        this.m = i3;
    }

    protected void a(View view, int i2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.n).addView(view, i2);
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        m.a aVar = this.f272k;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.m
    public void c(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.n;
        if (viewGroup == null) {
            return;
        }
        g gVar = this.f269h;
        int i2 = 0;
        if (gVar != null) {
            gVar.t();
            ArrayList<i> arrayListG = this.f269h.G();
            int size = arrayListG.size();
            int i3 = 0;
            for (int i4 = 0; i4 < size; i4++) {
                i iVar = arrayListG.get(i4);
                if (s(i3, iVar)) {
                    View childAt = viewGroup.getChildAt(i3);
                    i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                    View viewP = p(iVar, childAt, viewGroup);
                    if (iVar != itemData) {
                        viewP.setPressed(false);
                        viewP.jumpDrawablesToCurrentState();
                    }
                    if (viewP != childAt) {
                        a(viewP, i3);
                    }
                    i3++;
                }
            }
            i2 = i3;
        }
        while (i2 < viewGroup.getChildCount()) {
            if (!n(viewGroup, i2)) {
                i2++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean e(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean f(g gVar, i iVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.m
    public void g(m.a aVar) {
        this.f272k = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public int getId() {
        return this.o;
    }

    @Override // androidx.appcompat.view.menu.m
    public void h(Context context, g gVar) {
        this.f268g = context;
        this.f271j = LayoutInflater.from(context);
        this.f269h = gVar;
    }

    public abstract void j(i iVar, n.a aVar);

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.appcompat.view.menu.m
    public boolean k(r rVar) {
        m.a aVar = this.f272k;
        g gVar = rVar;
        if (aVar == null) {
            return false;
        }
        if (rVar == null) {
            gVar = this.f269h;
        }
        return aVar.c(gVar);
    }

    public n.a m(ViewGroup viewGroup) {
        return (n.a) this.f270i.inflate(this.m, viewGroup, false);
    }

    protected boolean n(ViewGroup viewGroup, int i2) {
        viewGroup.removeViewAt(i2);
        return true;
    }

    public m.a o() {
        return this.f272k;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View p(i iVar, View view, ViewGroup viewGroup) {
        n.a aVarM = view instanceof n.a ? (n.a) view : m(viewGroup);
        j(iVar, aVarM);
        return (View) aVarM;
    }

    public n q(ViewGroup viewGroup) {
        if (this.n == null) {
            n nVar = (n) this.f270i.inflate(this.l, viewGroup, false);
            this.n = nVar;
            nVar.b(this.f269h);
            c(true);
        }
        return this.n;
    }

    public void r(int i2) {
        this.o = i2;
    }

    public abstract boolean s(int i2, i iVar);
}
