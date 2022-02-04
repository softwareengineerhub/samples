From root dir of project:

keytool -genkeypair -keyalg RSA -dname "CN=localhost" -keystore dropbookmarks.keystore -keypass 11111111 -storepass 11111111


File dropbookmarks.keystore is presented now in dir

Run configuration:
server config.yml

In Browser:
https://127.0.0.1:8443/hello