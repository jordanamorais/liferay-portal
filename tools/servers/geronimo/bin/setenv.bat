set "GERONIMO_OPTS=%GERONIMO_OPTS% -Dfile.encoding=UTF8 @java.security.manager.option@ -Djava.security.policy==@app.server.geronimo.dir@/etc/server.policy -Djava.net.preferIPv4Stack=true -Duser.timezone=GMT -DXorg.apache.geronimo.deployment.LenientMFCP=true -Xmx1024m -XX:MaxPermSize=512m"