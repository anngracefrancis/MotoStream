package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: FragmentLayoutInflaterFactory.java */
/* JADX INFO: loaded from: classes.dex */
class k implements LayoutInflater.Factory2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final FragmentManager f1621f;

    k(FragmentManager fragmentManager) {
        this.f1621f = fragmentManager;
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        r rVarW;
        if (g.class.getName().equals(str)) {
            return new g(context, attributeSet, this.f1621f);
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.m.c.f3346d);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes.getString(c.m.c.f3347e);
        }
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(c.m.c.f3348f, -1);
        String string = typedArrayObtainStyledAttributes.getString(c.m.c.f3349g);
        typedArrayObtainStyledAttributes.recycle();
        if (attributeValue == null || !i.b(context.getClassLoader(), attributeValue)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
        }
        Fragment fragmentI0 = resourceId != -1 ? this.f1621f.i0(resourceId) : null;
        if (fragmentI0 == null && string != null) {
            fragmentI0 = this.f1621f.j0(string);
        }
        if (fragmentI0 == null && id != -1) {
            fragmentI0 = this.f1621f.i0(id);
        }
        if (fragmentI0 == null) {
            fragmentI0 = this.f1621f.t0().a(context.getClassLoader(), attributeValue);
            fragmentI0.mFromLayout = true;
            fragmentI0.mFragmentId = resourceId != 0 ? resourceId : id;
            fragmentI0.mContainerId = id;
            fragmentI0.mTag = string;
            fragmentI0.mInLayout = true;
            FragmentManager fragmentManager = this.f1621f;
            fragmentI0.mFragmentManager = fragmentManager;
            fragmentI0.mHost = fragmentManager.w0();
            fragmentI0.onInflate(this.f1621f.w0().f(), attributeSet, fragmentI0.mSavedFragmentState);
            rVarW = this.f1621f.w(fragmentI0);
            this.f1621f.g(fragmentI0);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Fragment " + fragmentI0 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        } else {
            if (fragmentI0.mInLayout) {
                throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + attributeValue);
            }
            fragmentI0.mInLayout = true;
            FragmentManager fragmentManager2 = this.f1621f;
            fragmentI0.mFragmentManager = fragmentManager2;
            fragmentI0.mHost = fragmentManager2.w0();
            fragmentI0.onInflate(this.f1621f.w0().f(), attributeSet, fragmentI0.mSavedFragmentState);
            rVarW = this.f1621f.w(fragmentI0);
            if (FragmentManager.H0(2)) {
                Log.v("FragmentManager", "Retained Fragment " + fragmentI0 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
            }
        }
        fragmentI0.mContainer = (ViewGroup) view;
        rVarW.m();
        rVarW.j();
        View view2 = fragmentI0.mView;
        if (view2 != null) {
            if (resourceId != 0) {
                view2.setId(resourceId);
            }
            if (fragmentI0.mView.getTag() == null) {
                fragmentI0.mView.setTag(string);
            }
            return fragmentI0.mView;
        }
        throw new IllegalStateException("Fragment " + attributeValue + " did not create a view.");
    }
}
