package cm.aptoide.pt.permission;

import android.annotation.TargetApi;
import cm.aptoide.pt.actions.PermissionService;
import cm.aptoide.pt.view.BackButtonFragment;

/* JADX INFO: loaded from: classes.dex */
public abstract class PermissionServiceFragment extends BackButtonFragment implements PermissionService {
    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void hasDownloadAccess(rx.m.a aVar, rx.m.a aVar2) {
        try {
            ((PermissionService) getActivity()).hasDownloadAccess(aVar, aVar2);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Containing activity of this fragment must implement " + PermissionService.class.getName());
        }
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestAccessToAccounts(rx.m.a aVar, rx.m.a aVar2) {
        try {
            ((PermissionService) getActivity()).requestAccessToAccounts(aVar, aVar2);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Containing activity of this fragment must implement " + PermissionService.class.getName());
        }
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestAccessToCamera(rx.m.a aVar, rx.m.a aVar2) {
        try {
            ((PermissionService) getActivity()).requestAccessToCamera(aVar, aVar2);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Containing activity of this fragment must implement " + PermissionService.class.getName());
        }
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestAccessToExternalFileSystem(rx.m.a aVar, rx.m.a aVar2) {
        try {
            ((PermissionService) getActivity()).requestAccessToExternalFileSystem(aVar, aVar2);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Containing activity of this fragment must implement " + PermissionService.class.getName());
        }
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestDownloadAccess(rx.m.a aVar, rx.m.a aVar2, boolean z, boolean z2, long j2) {
        try {
            ((PermissionService) getActivity()).requestDownloadAccess(aVar, aVar2, z, z2, j2);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Containing activity of this fragment must implement " + PermissionService.class.getName());
        }
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestAccessToAccounts(boolean z, rx.m.a aVar, rx.m.a aVar2) {
        try {
            ((PermissionService) getActivity()).requestAccessToAccounts(z, aVar, aVar2);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Containing activity of this fragment must implement " + PermissionService.class.getName());
        }
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestAccessToExternalFileSystem(boolean z, rx.m.a aVar, rx.m.a aVar2) {
        try {
            ((PermissionService) getActivity()).requestAccessToExternalFileSystem(z, aVar, aVar2);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Containing activity of this fragment must implement " + PermissionService.class.getName());
        }
    }

    @Override // cm.aptoide.pt.actions.PermissionService
    @TargetApi(23)
    public void requestAccessToExternalFileSystem(boolean z, int i2, rx.m.a aVar, rx.m.a aVar2) {
        try {
            ((PermissionService) getActivity()).requestAccessToExternalFileSystem(z, i2, aVar, aVar2);
        } catch (ClassCastException unused) {
            throw new IllegalStateException("Containing activity of this fragment must implement " + PermissionService.class.getName());
        }
    }
}
