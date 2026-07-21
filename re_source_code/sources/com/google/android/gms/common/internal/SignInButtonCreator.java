package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: loaded from: classes2.dex */
public final class SignInButtonCreator extends RemoteCreator<ISignInButtonCreator> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SignInButtonCreator f12014c = new SignInButtonCreator();

    private SignInButtonCreator() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View c(Context context, int i2, int i3) throws RemoteCreator.RemoteCreatorException {
        return f12014c.e(context, i2, i3);
    }

    private final View e(Context context, int i2, int i3) throws RemoteCreator.RemoteCreatorException {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i2, i3, null);
            return (View) ObjectWrapper.k0(b(context).l3(ObjectWrapper.E0(context), signInButtonConfig));
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder(64);
            sb.append("Could not get button with size ");
            sb.append(i2);
            sb.append(" and color ");
            sb.append(i3);
            throw new RemoteCreator.RemoteCreatorException(sb.toString(), e2);
        }
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final ISignInButtonCreator a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return iInterfaceQueryLocalInterface instanceof ISignInButtonCreator ? (ISignInButtonCreator) iInterfaceQueryLocalInterface : new zah(iBinder);
    }
}
