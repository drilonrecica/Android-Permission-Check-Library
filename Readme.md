# Android Permission Check Library

[![Build Status](https://travis-ci.org/drilonreqica/Android-Permission-Check-Library.svg?branch=develop)](https://travis-ci.org/drilonreqica/Android-Permission-Check-Library) [ ![Download](https://api.bintray.com/packages/drilonreqica/maven/android-permission-check-library/images/download.svg) ](https://bintray.com/drilonreqica/maven/android-permission-check-library/_latestVersion)

Add library dependency using gradle:
```golang
compile 'com.reqica.drilon:android-permission-check-library:2.0.0'
```
Add library dependency using maven:
```maven
<dependency>
  <groupId>com.reqica.drilon</groupId>
  <artifactId>android-permission-check-library</artifactId>
  <version>2.0.0</version>
  <type>pom</type>
</dependency>
```
Add library dependency using ivy:
```ivy
<dependency org='com.reqica.drilon' name='android-permission-check-library' rev='2.0.0'>
  <artifact name='android-permission-check-library' ext='pom' ></artifact>
</dependency>
```

Initialize Class CheckPermission:
```java
CheckPermission checkPermission = new CheckPermission(context);
```

If you want to check a single permission call:
```java
checkPermission.checkOne(Permission.CAMERA);
```


If you want to check multiple permissions at once call:
```java
checkPermission.checkMultiple(permissionArray);
```

