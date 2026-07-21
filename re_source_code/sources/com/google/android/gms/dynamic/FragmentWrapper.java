package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* JADX INFO: loaded from: classes2.dex */
@KeepForSdk
@SuppressLint({"NewApi"})
public final class FragmentWrapper extends IFragmentWrapper.Stub {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Fragment f12189f;

    private FragmentWrapper(Fragment fragment) {
        this.f12189f = fragment;
    }

    @KeepForSdk
    public static FragmentWrapper P(Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean A0() {
        return this.f12189f.isDetached();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void D2(Intent intent, int i2) {
        this.f12189f.startActivityForResult(intent, i2);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean G() {
        return this.f12189f.isAdded();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void P0(boolean z) {
        this.f12189f.setHasOptionsMenu(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean U() {
        return this.f12189f.isRemoving();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean X() {
        return this.f12189f.isResumed();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean Z6() {
        return this.f12189f.isVisible();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int b() {
        return this.f12189f.getId();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void b2(boolean z) {
        this.f12189f.setRetainInstance(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int c() {
        return this.f12189f.getTargetRequestCode();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle d() {
        return this.f12189f.getArguments();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper e() {
        return P(this.f12189f.getParentFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean f0() {
        return this.f12189f.isHidden();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void h6(boolean z) {
        this.f12189f.setUserVisibleHint(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper l() {
        return ObjectWrapper.E0(this.f12189f.getView());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean l0() {
        return this.f12189f.isInLayout();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper m() {
        return ObjectWrapper.E0(this.f12189f.getResources());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper q() {
        return P(this.f12189f.getTargetFragment());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void r1(boolean z) {
        this.f12189f.setMenuVisibility(z);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper s() {
        return ObjectWrapper.E0(this.f12189f.getActivity());
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void s0(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.k0(iObjectWrapper);
        Fragment fragment = this.f12189f;
        Preconditions.k(view);
        fragment.registerForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final String v() {
        return this.f12189f.getTag();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void w0(IObjectWrapper iObjectWrapper) {
        View view = (View) ObjectWrapper.k0(iObjectWrapper);
        Fragment fragment = this.f12189f;
        Preconditions.k(view);
        fragment.unregisterForContextMenu(view);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void w2(Intent intent) {
        this.f12189f.startActivity(intent);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean x() {
        return this.f12189f.getRetainInstance();
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean y() {
        return this.f12189f.getUserVisibleHint();
    }
}
