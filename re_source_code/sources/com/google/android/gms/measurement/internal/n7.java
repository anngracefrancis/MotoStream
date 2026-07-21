package com.google.android.gms.measurement.internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class n7 extends SSLSocket {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final SSLSocket f17891f;

    n7(o7 o7Var, SSLSocket sSLSocket) {
        this.f17891f = sSLSocket;
    }

    @Override // javax.net.ssl.SSLSocket
    public final void addHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f17891f.addHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public final void bind(SocketAddress socketAddress) throws IOException {
        this.f17891f.bind(socketAddress);
    }

    @Override // java.net.Socket, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        this.f17891f.close();
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress) throws IOException {
        this.f17891f.connect(socketAddress);
    }

    public final boolean equals(Object obj) {
        return this.f17891f.equals(obj);
    }

    @Override // java.net.Socket
    public final SocketChannel getChannel() {
        return this.f17891f.getChannel();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getEnableSessionCreation() {
        return this.f17891f.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledCipherSuites() {
        return this.f17891f.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getEnabledProtocols() {
        return this.f17891f.getEnabledProtocols();
    }

    @Override // java.net.Socket
    public final InetAddress getInetAddress() {
        return this.f17891f.getInetAddress();
    }

    @Override // java.net.Socket
    public final InputStream getInputStream() throws IOException {
        return this.f17891f.getInputStream();
    }

    @Override // java.net.Socket
    public final boolean getKeepAlive() throws SocketException {
        return this.f17891f.getKeepAlive();
    }

    @Override // java.net.Socket
    public final InetAddress getLocalAddress() {
        return this.f17891f.getLocalAddress();
    }

    @Override // java.net.Socket
    public final int getLocalPort() {
        return this.f17891f.getLocalPort();
    }

    @Override // java.net.Socket
    public final SocketAddress getLocalSocketAddress() {
        return this.f17891f.getLocalSocketAddress();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getNeedClientAuth() {
        return this.f17891f.getNeedClientAuth();
    }

    @Override // java.net.Socket
    public final boolean getOOBInline() throws SocketException {
        return this.f17891f.getOOBInline();
    }

    @Override // java.net.Socket
    public final OutputStream getOutputStream() throws IOException {
        return this.f17891f.getOutputStream();
    }

    @Override // java.net.Socket
    public final int getPort() {
        return this.f17891f.getPort();
    }

    @Override // java.net.Socket
    public final synchronized int getReceiveBufferSize() throws SocketException {
        return this.f17891f.getReceiveBufferSize();
    }

    @Override // java.net.Socket
    public final SocketAddress getRemoteSocketAddress() {
        return this.f17891f.getRemoteSocketAddress();
    }

    @Override // java.net.Socket
    public final boolean getReuseAddress() throws SocketException {
        return this.f17891f.getReuseAddress();
    }

    @Override // java.net.Socket
    public final synchronized int getSendBufferSize() throws SocketException {
        return this.f17891f.getSendBufferSize();
    }

    @Override // javax.net.ssl.SSLSocket
    public final SSLSession getSession() {
        return this.f17891f.getSession();
    }

    @Override // java.net.Socket
    public final int getSoLinger() throws SocketException {
        return this.f17891f.getSoLinger();
    }

    @Override // java.net.Socket
    public final synchronized int getSoTimeout() throws SocketException {
        return this.f17891f.getSoTimeout();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedCipherSuites() {
        return this.f17891f.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocket
    public final String[] getSupportedProtocols() {
        return this.f17891f.getSupportedProtocols();
    }

    @Override // java.net.Socket
    public final boolean getTcpNoDelay() throws SocketException {
        return this.f17891f.getTcpNoDelay();
    }

    @Override // java.net.Socket
    public final int getTrafficClass() throws SocketException {
        return this.f17891f.getTrafficClass();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getUseClientMode() {
        return this.f17891f.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLSocket
    public final boolean getWantClientAuth() {
        return this.f17891f.getWantClientAuth();
    }

    @Override // java.net.Socket
    public final boolean isBound() {
        return this.f17891f.isBound();
    }

    @Override // java.net.Socket
    public final boolean isClosed() {
        return this.f17891f.isClosed();
    }

    @Override // java.net.Socket
    public final boolean isConnected() {
        return this.f17891f.isConnected();
    }

    @Override // java.net.Socket
    public final boolean isInputShutdown() {
        return this.f17891f.isInputShutdown();
    }

    @Override // java.net.Socket
    public final boolean isOutputShutdown() {
        return this.f17891f.isOutputShutdown();
    }

    @Override // javax.net.ssl.SSLSocket
    public final void removeHandshakeCompletedListener(HandshakeCompletedListener handshakeCompletedListener) {
        this.f17891f.removeHandshakeCompletedListener(handshakeCompletedListener);
    }

    @Override // java.net.Socket
    public final void sendUrgentData(int i2) throws IOException {
        this.f17891f.sendUrgentData(i2);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnableSessionCreation(boolean z) {
        this.f17891f.setEnableSessionCreation(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledCipherSuites(String[] strArr) {
        this.f17891f.setEnabledCipherSuites(strArr);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setEnabledProtocols(String[] strArr) {
        if (strArr != null && Arrays.asList(strArr).contains("SSLv3")) {
            ArrayList arrayList = new ArrayList(Arrays.asList(this.f17891f.getEnabledProtocols()));
            if (arrayList.size() > 1) {
                arrayList.remove("SSLv3");
            }
            strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        this.f17891f.setEnabledProtocols(strArr);
    }

    @Override // java.net.Socket
    public final void setKeepAlive(boolean z) throws SocketException {
        this.f17891f.setKeepAlive(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setNeedClientAuth(boolean z) {
        this.f17891f.setNeedClientAuth(z);
    }

    @Override // java.net.Socket
    public final void setOOBInline(boolean z) throws SocketException {
        this.f17891f.setOOBInline(z);
    }

    @Override // java.net.Socket
    public final void setPerformancePreferences(int i2, int i3, int i4) {
        this.f17891f.setPerformancePreferences(i2, i3, i4);
    }

    @Override // java.net.Socket
    public final synchronized void setReceiveBufferSize(int i2) throws SocketException {
        this.f17891f.setReceiveBufferSize(i2);
    }

    @Override // java.net.Socket
    public final void setReuseAddress(boolean z) throws SocketException {
        this.f17891f.setReuseAddress(z);
    }

    @Override // java.net.Socket
    public final synchronized void setSendBufferSize(int i2) throws SocketException {
        this.f17891f.setSendBufferSize(i2);
    }

    @Override // java.net.Socket
    public final void setSoLinger(boolean z, int i2) throws SocketException {
        this.f17891f.setSoLinger(z, i2);
    }

    @Override // java.net.Socket
    public final synchronized void setSoTimeout(int i2) throws SocketException {
        this.f17891f.setSoTimeout(i2);
    }

    @Override // java.net.Socket
    public final void setTcpNoDelay(boolean z) throws SocketException {
        this.f17891f.setTcpNoDelay(z);
    }

    @Override // java.net.Socket
    public final void setTrafficClass(int i2) throws SocketException {
        this.f17891f.setTrafficClass(i2);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setUseClientMode(boolean z) {
        this.f17891f.setUseClientMode(z);
    }

    @Override // javax.net.ssl.SSLSocket
    public final void setWantClientAuth(boolean z) {
        this.f17891f.setWantClientAuth(z);
    }

    @Override // java.net.Socket
    public final void shutdownInput() throws IOException {
        this.f17891f.shutdownInput();
    }

    @Override // java.net.Socket
    public final void shutdownOutput() throws IOException {
        this.f17891f.shutdownOutput();
    }

    @Override // javax.net.ssl.SSLSocket
    public final void startHandshake() throws IOException {
        this.f17891f.startHandshake();
    }

    @Override // javax.net.ssl.SSLSocket, java.net.Socket
    public final String toString() {
        return this.f17891f.toString();
    }

    @Override // java.net.Socket
    public final void connect(SocketAddress socketAddress, int i2) throws IOException {
        this.f17891f.connect(socketAddress, i2);
    }
}
