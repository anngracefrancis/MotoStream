package com.airbnb.epoxy;

/* JADX INFO: compiled from: ControllerModelList.java */
/* JADX INFO: loaded from: classes.dex */
class h extends c0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final c0.d f8433h = new a();

    /* JADX INFO: compiled from: ControllerModelList.java */
    static class a implements c0.d {
        a() {
        }

        @Override // com.airbnb.epoxy.c0.d
        public void a(int i2, int i3) {
            throw new IllegalStateException("Models cannot be changed once they are added to the controller");
        }

        @Override // com.airbnb.epoxy.c0.d
        public void b(int i2, int i3) {
            throw new IllegalStateException("Models cannot be changed once they are added to the controller");
        }
    }

    h(int i2) {
        super(i2);
        S();
    }

    void c0() {
        b0(f8433h);
        V();
    }
}
